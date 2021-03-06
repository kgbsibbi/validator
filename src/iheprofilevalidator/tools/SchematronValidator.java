package iheprofilevalidator.tools;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;

import com.schematron.ant.Validator;
import com.schematron.ant.ValidatorFactory;
import com.schematron.ant.SchematronReport;
import com.schematron.ant.SchematronResult;

public class SchematronValidator {
	private static SchematronValidator instance = new SchematronValidator();
	public static SchematronValidator getInstance() { return instance; }
	private SchematronValidator() {}
	
	
	public String validate(String schemaFolder, String schemaName, String fileFolder, String xmlName, String outFolder){
		String resultFile="";
	    try{
	    	Source source = new StreamSource(schemaFolder+"/" + schemaName);
	    	StreamSource xml = new StreamSource(fileFolder+"/"+xmlName);
			
			System.setProperty("javax.xml.transform.TransformerFactory",
			          "net.sf.saxon.TransformerFactoryImpl");
			ValidatorFactory factory;

		    factory = new ValidatorFactory("auto", "svrl");
		    factory.setDebugMode(true);
		    factory.setErrorListener(new SchematronErrorListener());
	    	Validator validator = factory.newValidator(source);
	    	SchematronResult result = validator.validate(xml, "", "", "", "", "utf-8");
	    	SchematronReport report = new SchematronReport();
	    	report.add(result);
	    	resultFile=xmlName+"_result.xml";
	    	report.saveAs(new File(outFolder, resultFile));
	    	resultFile = report.toString();
	    	
	    }catch(TransformerException | IOException | IllegalAccessException | ClassNotFoundException | InstantiationException e){
	    	e.printStackTrace();
	    	resultFile="500";
	    	return resultFile;
	    }
	    	return resultFile;
	}
}
