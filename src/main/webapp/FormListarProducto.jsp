<%@page import="model.TblProductocl2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body bgcolor="#c5dec9">
	<h1 align="center">Listado de Productos</h2>
	<table border="2"  align="center">
		<tr>
			<td>Codigo</td>
			<td>Nom</td>
			<td>pv</td>
			<td>pc</td>
			<td>Est.</td>
			<td>Des.</td>
		</tr>
		<%
			List<TblProductocl2> listadoProducto = (List<TblProductocl2>)request.getAttribute("listadoproductos");
			if(listadoProducto != null){
				for(TblProductocl2 pro : listadoProducto){
				%>
					<tr>
						<td><%=pro.getIdproductocl2() %></td>
						<td><%=pro.getNombrecl2()%></td>
						<td><%=pro.getPrecioventacl2() %></td>
						<td><%=pro.getPreciocompcl2()%></td>
						<td><%=pro.getEstadocl2() %></td>
						<td><%=pro.getDescripcl2() %></td>
					</tr>
				<% 	
				}
			}
		%>
		
	</table>
	<a href="FormRegistrarProducto.jsp">Registrar Producto</a>
</body>
</html>