<%@page import="modelo.DAOCidade"%>
<%@page import="modelo.Cidade"%>
<%
String nomeCidade = request.getParameter("nomeCidade");
String ufCidade = request.getParameter("ufCidade");
String opcao = request.getParameter("opcao");
String codigoCidade = request.getParameter("codigoCidade");
String mensagem="";

Cidade  objCidade = new Cidade();
objCidade.setCodigoCidade(Integer.parseInt(codigoCidade));
objCidade.setNomeCidade(nomeCidade);
objCidade.setUfCidade(ufCidade);
DAOCidade objDAOCidade = new DAOCidade();
if(opcao.equals("cadastrar")){
mensagem = objDAOCidade.inserirCidade(objCidade);
}
if(opcao.equals("alterar")){
mensagem = objDAOCidade.alterarCidade(objCidade);
}
if(opcao.equals("excluir")){
mensagem = objDAOCidade.excluirCidade(objCidade);
}
if(opcao.equals("cancelar")){
   response.sendRedirect("CadastroCidade.jsp?opcao=cadastrar"); 
}
response.sendRedirect("CadastroCidade.jsp?mensagem="+mensagem);
%>



