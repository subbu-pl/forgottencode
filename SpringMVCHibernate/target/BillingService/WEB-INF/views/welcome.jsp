<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
    border: 0px solid black;
}

p.header1 {
    font: bold 30px arial, sans-serif;
}

p.ex2 {
    font: italic bold 12px/30px Georgia, serif;
}
p.footer1 {
	font: bold 10px arial, sans-serif;
}
</style>
</head>
<body scrolling="no">

<table width="100%" height="1024px" bgcolor="rgba(43, 190, 188, 1)" scrolling="no">
	<tr height="10%">
		<td >
			<table width="100%" height="100%">
				<tr><td align="center"  bgcolor="black"><p style="color:white;" class="header1">Tamil Nadu Electricity Board</h1></p></td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" height="1024px">
				<tr>
					<td>
									<iframe src="/BillingService/customers" width=100% height="100%" scrolling="yes" frameborder="0px">
									  <p>Your browser does not support iframes.</p>
									</iframe>
					</td>
					<td>
						<iframe src="/BillingService/usage" width=100% height="100%" scrolling="no" frameborder="0px">
									  <p>Your browser does not support iframes.</p>
									</iframe>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr height="10%"><td align="right"  bgcolor="black"><p style="color:white;" class="footer1">Powered By VDSI-Forgotten</p></td></tr>
</table>
</body>
</html>
