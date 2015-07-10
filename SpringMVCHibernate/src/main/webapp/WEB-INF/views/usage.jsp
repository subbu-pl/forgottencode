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
		
		p.body1 {
			font: bold 15px arial, sans-serif;
		}
		p.body2 {
			font: 12px arial, sans-serif;
		}
		
		#overLay {
  width: 300px;
  height: 250px;
  position: absolute;
  top: 250;
  left: 100;
  background-color:white;
  z-index: 10;
}


div.padding {
    padding-top: 25px;
    padding-right: 50px;
    padding-bottom: 25px;
    padding-left: 50px;
    border: 2px solid;
     border-radius: 25px;
}

span.padding1 {
    padding-top: 20px;
    padding-right: 20px;
    padding-bottom: 20px;
    padding-left: 20px;
    border: 0px solid;
    width:500px;
}

#opaqueLayer{
 width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  background-color:black;
  z-index: -1;
  opacity: 0.4;
}
	</style>
	<script>
		function processOverLay(obj){
			document.getElementById("opaqueLayer").style.display="block";
			document.getElementById("overLay").style.display="block";
		}
		
		function popupInvoice(obj){
			document.getElementById("opaqueLayer").style.display="block";
			document.getElementById("overLay1").style.display="block";
		}
		
	</script>
</head>
<body>
<div>
	<h3>Usage Details</h3>
	<form:form action="/BillingService/usage" method="GET">
		<input type="submit" value="Today"/>
		<input type="button" value="Other Invoice" onclick="processOverLay(this)"/>
	</form:form>	
</div>


<div id="opaqueLayer" style="display:none;">&nbsp;</div><div id="overLay" style="display:none;" class="padding">
	<form:form action="/BillingService/fetchInvoiceData">
	<div>
	<h3><p class="body1">Customize Invoice Fetch</p></h3>
	<p class="body2">Select the Smart Meter # and Month from the below list.</p>
		<span>
			<select name="meterId" multiple="multiple" style="width:100px;height:100px">
			 <c:forEach items="${listSmtIds}" var="smtids">
				  <option value="${smtids}"><p class="body2">${smtids}</p></option>
			  </c:forEach>
			</select>
		</span>
		<span class="padding1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span>
			<select name="month">
			 	<option value="1"><p class="body2">January</p></option>
			 	<option value="2"><p class="body2">February</p></option>
			 	<option value="3"><p class="body2">March</p></option>
			 	<option value="4"><p class="body2">April</p></option>
			 	<option value="5"><p class="body2">May</p></option>
			 	<option value="6"><p class="body2">June</p></option>
			 	<option value="7"><p class="body2">July</p></option>
			 	<option value="8"><p class="body2">August</p></option>
			 	<option value="9"><p class="body2">September</p></option>
			 	<option value="10"><p class="body2">October</p></option>
			 	<option value="11"><p class="body2">November</p></option>
			 	<option value="12"><p class="body2">December</p></option>
			</select>
		</span>
	</div>
	<br/>
	<div align="center">
		<span><input type="submit" value="Submit"/></span>
	</div>
	</form:form>
</div>


<c:choose>
	<c:when test="${!empty listUsageDtls}">
		<div id="overLay1" class="padding">
	</c:when>
	<c:otherwise>
		<div id="overLay1" style="display:none;" class="padding">	
	</c:otherwise>
</c:choose>

	<table class="tg">
	<tr>
		<th width="80"><p class="body1">Meter #</p></th>
		<th width="120"><p class="body1">Start Time</p></th>
		<th width="120"><p class="body1">Start Reading</p></th>
		<th width="120"><p class="body1">End Time</p></th>
		<th width="120"><p class="body1">End Reading</p></th>
	</tr>
	<c:forEach items="${listUsageDtls}" var="usageDtls">
		<tr>
			<td><p class="body2">${usageDetail.smartMeterId}</p></td>
			<td><p class="body2">${usageDtls.startDateTime}</p></td>
			<td><p class="body2">${usageDtls.meterReadingStart}</p></td>
			<td><p class="body2">${usageDtls.endDateTime}</p></td>
			<td><p class="body2">${usageDtls.meterReadingEnd}</p></td>
		</tr>
	</c:forEach>
	</table>
</div>
<c:if test="${!empty listUsageDetails}">
	<table class="tg">
	<tr>
		<th width="80"><p class="body1">Meter #</p></th>
		<th width="120"><p class="body1">Invoice Number</p></th>
		<th width="120"><p class="body1">Units Used</p></th>
		<th width="120"><p class="body1">Amount</p></th>
		<th width="120"><p class="body1">Due Date</p></th>
	</tr>
	<c:forEach items="${listUsageDetails}" var="usageDetail">
		<tr>
			<td><p class="body2">${usageDetail.smartMeterId}</p></td>
			<td><p class="body2">${usageDetail.invoiceNumber}</p></td>
			<td><p class="body2">${usageDetail.reading}</p></td>
			<td><p class="body2">${usageDetail.amount}</p></td>
			<td><p class="body2">${usageDetail.dueDate}</p></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>
