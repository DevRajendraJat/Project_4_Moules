<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.bean.ProgressBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String msg = (String) request.getAttribute("msg");
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>
	<jsp:useBean id="bean" class="in.co.rays.bean.ProgressBean"
		scope="request"></jsp:useBean>

	<form action="ProgressListCtl" method="post">
		<tr>
			<td><lable>DeveloperName :</lable> <input type="text"
				name="name" placeholder=" Enter DeveloperName"></td>

			<td align="center"><input type="submit" name="operation"
				value="search"></td>
		</tr>
		</table>

		<table border="1">
			<tr>
				<th width="5%">Select</th>
				<th width="13%">DeveloperName</th>
				<th width="13%">Work</th>
				<th width="13%">Target</th>
				<th width="13%">Lastweek</th>
				<th width="13%">CurrentWeek</th>
				<th width="13%">Today</th>
				<th width="5%">Edit</th>
			</tr>
			<%
				while (it.hasNext()) {
					bean = (ProgressBean) it.next();
			%>
			<tr>
				<td style="text-align: center;"><input type="checkbox"
					name="ids" value="<%=bean.getId()%>"></td>
				<td style="text-align: center;"><%=bean.getDeveloperName()%></td>
				<td style="text-align: center;"><%=bean.getWork()%></td>
				<td style="text-align: center;"><%=bean.getTarget()%></td>
				<td style="text-align: center;"><%=bean.getLastWeek()%></td>
				<td style="text-align: center;"><%=bean.getCurrentWeek()%></td>
				<td style="text-align: center;"><%=bean.getToday()%></td>
				<td style="text-align: center;"><a
					href="ProgressCtl?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
			<table style="width: 100%">
				<tr>



					<td align="center"><input type="submit" name="operation"
						value="add"></td>

					<td align="justify"><input type="submit" name="operation"
						value="delete"></td>



				</tr>

			</table>
		</table>

	</form>
</body>
</html>