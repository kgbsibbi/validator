<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h6>PHMR CDA Validator</h6>
<p>Select a file to validate</p>
<form action="validate.do?type=phmrcda" method="post" enctype="multipart/form-data">
	<div class="input-group">
		<div class="input-group col-xs-12">
			<span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
			<input type="text" id="filename" class="form-control" readonly required aria-label="Selected file name">
			<span class="input-group-btn">
				<button class="btn btn-secondary" type="button" id="browsebutton">Browse</button>
				<input class="btn btn-secondary" type="submit" id="validatebutton" value="VALIDATE">
			</span>
		</div>
		<input class="form-control file" type="file" id="fileinput" name="fileinput" required aria-label="Hidden input for file selection">
	</div>
</form>
<p>${result}</p>