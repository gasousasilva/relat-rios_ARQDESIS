<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="ItemPedido_Beans.ItemPedido"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar</title>
</head>
<body>
	<%
		ItemPedido iPedido = (ItemPedido)request.getAttribute("Pedidos");
	%>

	Id: <%=iPedido.getId()%><br>
	
</body>
</html>