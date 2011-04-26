<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<jsp:useBean id="msg" type="java.lang.String" scope="request"/>
<jsp:useBean id="action" type="java.lang.String" scope="request"/>

<html>
  <head>
    <title>Log Into Your Account</title>
  </head>
 
  <body>
    <h1>Enter Your Login Credentials</h1>
 
    <c:if test="${not empty param.login_error}">
      <font color="red">
        Your login attempt was not successful, try again.<br/><br/>
        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
 
    <form:form name="f" action="${action}" method="POST">
      <table>
        <tr><td>User:</td><td><input type='text' name='j_username' value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/></td></tr>
        <tr><td>Password:</td><td><input type='password' name='j_password'></td></tr>
        <tr><td><input type="checkbox" name="_spring_security_remember_me"></td><td>Don't ask for my password for two weeks</td></tr>
 
        <tr><td colspan='2'><input name="submit" type="submit"></td></tr>
        <tr><td colspan='2'><input name="reset" type="reset"></td></tr>
        <tr><td colspan='2'><a href="/register">Register</a></td></tr>
      </table>
    </form:form>
  </body>
</html>