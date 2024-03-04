<%@page import="modelo.Cidade"%>
<%
String nomeCidade = request.getParameter("nomeCidade");
String ufCidade = request.getParameter("ufCidade");

Cidade objCidade = new Cidade();
objCidade.setNomeCidade(nomeCidade);
objCidade.setUfCidade(ufCidade);

%>


