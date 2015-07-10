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
	</style>
</head>
<body>
<h1>
	Add a Customer
</h1>

<c:url var="addAction" value="/customer/add" ></c:url>
<form:form id="addCustomerForm" action="${addAction}" commandName="customer" >
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
	</tr>
	<tr>
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
			<form:input path="address1" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="address2">
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
	</tr>
	
	<tr>
		<td>
			<form:label path="state">
				<spring:message text="State"/>
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
	</tr>
	
	<tr>
		<td>
			<form:label path="phone">
				<spring:message text="Contact"/>
			</form:label>
		</td>
		<td>
			<form:input path="phone" />
		</td>
	</tr>
	
	
	 <tr>
        <td colspan="2">
                <input type="submit"
                    value="<spring:message text="Add Customer"/>" />
        </td>
    </tr>
	

</table>	



</form:form>
<br>
<h3>Customers List</h3>
<c:if test="${!empty listCustomers}">
	<table class="tg">
	<tr>
		<th width="80">Smart Meter ID</th>
		<th width="120">First Name</th>
		<th width="120">Last Name</th>
		<th width="120">Address 1</th>
		<th width="120">Address 2</th>
		<th width="120">City</th>
		<th width="120">State</th>
		<th width="120">Zip Code</th>
		<th width="120">Phone</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCustomers}" var="customer">
		<tr>
			<td>${customer.smartMeterId}</td>
			<td>${customer.customerFirstName}</td>
			<td>${customer.customerLastName}</td>
			<td>${customer.address1}</td>
			<td>${customer.address2}</td>
			<td>${customer.city}</td>
			<td>${customer.state}</td>
			<td>${customer.zipCode}</td>
			<td>${customer.phone}</td>
			<td><a href="<c:url value='/remove/${customer.smartMeterId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

<br>
<h3>Usage Details</h3>

<c:if test="${!empty listUsageDetails}">
	<table class="tg">
	<tr>
		<th width="80">Smart Meter ID</th>
		<th width="120">Invoice Number</th>
		<th width="120">Units Used</th>
		<th width="120">Amount</th>
		<th width="120">Due Date</th>
	</tr>
	<c:forEach items="${listUsageDetails}" var="usageDetail">
		<tr>
			<td>${usageDetail.smartMeterId}</td>
			<td>${usageDetail.invoiceNumber}</td>
			<td>${usageDetail.reading}</td>
			<td>${usageDetail.amount}</td>
			<td>${usageDetail.dueDate}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>
