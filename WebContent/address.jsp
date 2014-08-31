<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adding an address</title>
</head>
<body>
Provide your address info below <br/>
Fields that marked with * is required.<br/>

<html:form  action="/Address" >

	<div> <html:errors/> </div> 
	<br/>
	Name:<html:text property="name"/>*<br/><br/>
	Street:<html:text property="street" /><br/><br/>
	City:<html:text property="city" /><br/><br/>
	Country:<html:text property="country" /><br/><br/>
	zipCode:<html:text property="zip" maxlength="6" />*<br/><br/>
	
	 <html:submit value="Submit"/>
</html:form>

</body>
</html>