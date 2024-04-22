<%@page import="modelo.DAOFuncionario"%>
<%@page import="modelo.ConverteData"%>
<%@page import="modelo.Funcionario"%>

<%
String nomeFuncionario = request.getParameter("nomeFuncionario");
String salarioFuncionario = request.getParameter("salarioFuncionario");
String nascimentoFuncionario = request.getParameter("nascimentoFuncionario");
String codigoCidade = request.getParameter("codigoCidade");
String opcao = request.getParameter("opcao");
String codigoFuncionario = request.getParameter("codigoFuncionario");
String mensagem="";

ConverteData converte = new ConverteData();

Funcionario objFuncionario = new Funcionario();
objFuncionario.setCodigoFuncionario(Integer.valueOf(codigoFuncionario));
objFuncionario.setNomeFuncionario(nomeFuncionario);
objFuncionario.setSalarioFuncionario(Double.valueOf(salarioFuncionario));
objFuncionario.setDataNascimento(converte.converteCalendario(nascimentoFuncionario));
objFuncionario.getObjCidade().setCodigoCidade(Integer.valueOf(codigoCidade));



DAOFuncionario objDaoFuncionario = new DAOFuncionario();
if(opcao.equals("cadastrar")){
mensagem = objDaoFuncionario.inserirFuncionario(objFuncionario);
}
if(opcao.equals("alterar")){
mensagem = objDaoFuncionario.alterarFuncionario(objFuncionario);
}
if(opcao.equals("excluir")){
mensagem = objDaoFuncionario.excluirFuncionario(objFuncionario);
}

response.sendRedirect("CadastroFuncionario.jsp?mensagem="+mensagem);
%>



