<%-- 
    Document   : CadastroFuncionario
    Created on : 04/03/2024, 14:18:03
    Author     : tulio
--%>

<%
    String mensagem = request.getParameter("mensagem");
    String codigoFuncionario = request.getParameter("codigoFuncionario");
    String nomeFuncionario = request.getParameter("nomeFuncionario");
    String salarioFuncionario = request.getParameter("salarioFuncionario");
    String nascimentoFuncionario = request.getParameter("nascimentoFuncionario");
    String codigoCidade = request.getParameter("codigoCidade");

    String opcao = request.getParameter("opcao");
    if (opcao == null) {
        opcao = "cadastrar";
    }
    if (codigoFuncionario == null) {
        codigoFuncionario = "0";
    }
    if (codigoCidade == null) {
        codigoCidade = "0";
    }

    DAOCidade daoCidade = new DAOCidade();
    List<Cidade> listaCidade2 = daoCidade.listarCidade();

%>

<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Cadastro Funcionário</title>
    </head>
    <body>
        <h1>Cadastro Funcionário</h1>
        <form name="cadastro" method="get" action="CAEFuncionario.jsp">
            <p> <label>Cidade:</label>
                <input type="text" name="nomeFuncionario" value="<%= (nomeFuncionario == null) ? "" : nomeFuncionario%>" size="40" />
            </p> 
            <p> <label>Salário:</label>
                <input type="text" name="salarioFuncionario" value="<%= (salarioFuncionario == null) ? "" : salarioFuncionario%>" size="5" />
            </p> 
            <p> <label>Nascimento:</label>
                <input type="text" name="nascimentoFuncionario" value="<%= (nascimentoFuncionario == null) ? "" : nascimentoFuncionario%>" size="5" />
            </p> 
            <p> <label>Cidade</label>
                <select name="codigoCidade">
                    <% for (Cidade cidade : listaCidade2) { %>
                    <% if (codigoCidade.equals(String.valueOf(cidade.getCodigoCidade()))) {%>
                    <option selected value="<%= cidade.getCodigoCidade()%>"> <%= cidade.getNomeCidade()%></option>
                    <% } else {%>
                    <option  value="<%= cidade.getCodigoCidade()%>"> <%= cidade.getNomeCidade()%></option>
                    <%}%>
                    <%}%>
                </select>
            </p> 



            <% if (opcao.equals("cadastrar")) { %>
            <input type="submit" value="Cadastrar" name="Cadastrar" />
            <% } %>
            <% if (opcao.equals("alterar")) { %>
            <input type="submit" value="Alterar" name="Alterar" />

            <% } %>
            <% if (opcao.equals("excluir")) { %>
            <input type="submit" value="Excluir" name="Excluir" />

            <% }%>
            <input type="hidden" name="opcao" value="<%= opcao%>">
            <input type="hidden" name="codigoFuncionario" value="<%= codigoFuncionario%>">
        </form>
        <br>  <%= (mensagem == null) ? "" : mensagem%>


        <%@include file="ListarFuncionario.jsp" %>    
    </body>
</html>
