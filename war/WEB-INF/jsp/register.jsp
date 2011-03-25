<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link rel="stylesheet" href="<spring:url value="/styles/contacts.css" htmlEscape="true" />" type="text/css"/>
		<title>Contact Registration</title>
	</head>	
	<body>
		<div class="container">
			<div class="header">
				Register at Contacts
			</div>
			<form:form modelAttribute="registrationModel" action="/register"
				method="POST">
						<table class="registerTable">
							<spring:hasBindErrors name="registrationModel">
								<tr>
									<td>&nbsp;</td>
									<td class="error" colspan="2">
										<form:errors path="*"></form:errors>
									</td>
								</tr>
							</spring:hasBindErrors>
							<tr>
								<td><form:label	for="name" path="userName">User Name:<font color="red" text-align="left">*</font></form:label></td>
								<td><form:input path="userName" cssClass="text" /></td>
								
							</tr>
							<tr>
								<td><form:label	for="name" path="email">Email:</form:label></td>
								<td><form:input path="email" cssClass="text" /></td>
							</tr>
							<tr>
								<td><form:label	for="name" path="password" >Password:<font color="red" text-align="left">*</font></form:label></td>
								<td><form:password path="password" cssClass="text" /> </td>
							</tr>
							<tr>
								<td><form:label	for="name" path="confirmPassword" >Confirm Password:<font color="red" text-align="left">*</font></form:label></td>
								<td><form:password path="confirmPassword" cssClass="text" /></td>
								
							</tr>
							
							<tr>
								<td><form:label	for="name" path="keyCode" >Key Code:<font color="red" text-align="left">*</font></form:label></td>
								<td><img id="captcha" src="/captcha" alt="" /></td>
								
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td><form:input path="keyCode"	cssClass="text" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" class="btn" value="Register" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><a class="link" href="/password"><spring:message code="authentication.login.link.password"/></a></td>
							</tr>
						</table>
			</form:form>
		</div>
	</body>
</html>