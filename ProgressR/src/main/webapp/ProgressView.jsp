<%@page import="in.co.rays.bean.ProgressBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="ProgressCtl" method="post">
		<%
			String msg = (String) request.getAttribute("msg");
			ProgressBean bean = (ProgressBean) request.getAttribute("bean");
		%>
		<input type="hidden" name="id"
			value="<%=(bean != null) ? bean.getId() : ""%>">

		<table>
			<tr>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>

			</tr>
			<tr>
				<th>DeveloperName</th>
				<td><input type="text" name="DeveloperName"
					value="<%=(bean != null) ? bean.getDeveloperName() : ""%>"></td>
			</tr>
			<tr>
				<th>Work</th>
				<td><input type="text" name="Work"
					value="<%=(bean != null) ? bean.getWork() : ""%>"></td>
			</tr>

			<tr>
				<th>Target</th>
				<td><input type="text" name="Target"
					value="<%=(bean != null) ? bean.getTarget() : ""%>"></td>
			</tr>

			<tr>
				<th>Lastweek</th>
				<td><input type="text" name="lastweek"
					value="<%=(bean != null) ? bean.getLastWeek() : ""%>"></td>
			</tr>

			<tr>
				<th>CurrentWeek</th>
				<td><input type="text" name="CurrentWeek"
					value="<%=(bean != null) ? bean.getCurrentWeek() : ""%>"></td>
			</tr>
			<tr>
				<th>Today</th>
				<td><input type="date" name="Today"
					value="<%=(bean != null ? bean.getToday() : "")%>"></td>
			</tr>



			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(bean != null) ? "update" : "save"%>"></td>
			</tr>
			<a href="ProgressListCtl">ProgressList</a>

		</table>
	</form>
</body>
</html>