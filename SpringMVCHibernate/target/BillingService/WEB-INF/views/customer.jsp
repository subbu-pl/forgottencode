<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Billing</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
		
		#rcorners2 {
   border-radius: 25px;
    background: #8AC007;
    padding: 20px; 
    width: 600px;
    height: 500px;  border-radius: 25px;
    border: 2px solid #8AC007;
    padding: 5px;     
}

div.body1 {
width: 600px;
height: 30px;
}

span.body2 {
width: 150px;
}
	</style>
</head>
<body>

<h3>Customers List</h3>
<c:if test="${!empty listCustomers}">
	<table class="tg" width="600px">
	<tr>
		<th width="80">Meter #</th>
		<th width="120">Name</th>
		<th width="120">Address</th>
		<th width="120">Phone</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCustomers}" var="customer">
		<tr>
			<td>${customer.smartMeterId}</td>
			<td>${customer.customerFirstName} ${customer.customerLastName}</td>
			<td>${customer.address1}<br/>${customer.address2}<br/>${customer.city}<br/>${customer.state}<br/${customer.zipCode}></td>
			<td>${customer.phone}</td>
			<td><a href="<c:url value='/remove/${customer.smartMeterId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<br/>

<c:url var="addAction" value="/customer/add" ></c:url>
<form:form id="addCustomerForm" action="${addAction}" commandName="customer" >

<fieldset >
	<legend>Add a Customer</legend>
	<table>
		<tr>
			<td>
				<form:label path="customerFirstName">
				<spring:message text="First Name"/>
				</form:label>
			</td>
			<td>
				<form:input path="customerFirstName" />
			</td>
			<td width="30%">&nbsp;</td>
			<td>
				<form:label path="customerLastName">
				<spring:message text="Last Name"/>
				</form:label>
			</td>
			<td>
				<form:input path="customerLastName" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="address1">
				<spring:message text="Address 1"/>
			</form:label>
			</td>
			<td>
				<form:input path="address2" />
			</td>
			<td width="30%">&nbsp;</td>
			<td>
				<form:label path="address1">
				<spring:message text="Address 2"/>
			</form:label>
			</td>
			<td>
				<form:input path="address2" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="city">
				<spring:message text="City"/>
			</form:label>
			</td>
			<td>
				<form:input path="city" />
			</td>
			<td width="30%">&nbsp;</td>
			<td>
				<form:label path="state">
				<spring:message text="state"/>
			</form:label>
			</td>
			<td>
				<form:input path="state" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="zipCode">
				<spring:message text="Zip Code"/>
			</form:label>
			</td>
			<td>
				<form:input path="zipCode" />
			</td>
			<td width="30%">&nbsp;</td>
			<td>
				<form:label path="phone">
				<spring:message text="Contact"/>
			</form:label>
			</td>
			<td>
				<form:input path="phone" />
			</td>
		</tr>
	</table>
	
	<div class="body1">
        <span class="body2" colspan="2">
                <input type="submit"
                    value="<spring:message text="Add Customer"/>" />
        </span>
    </div>
</fieldset>
</form:form>
</body>
</html>
