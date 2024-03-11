<%-- 
    Document   : CadastroCidade
    Created on : 04/03/2024, 14:18:03
    Author     : tulio
--%>

<%
    String mensagem = request.getParameter("mensagem");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cidade</title>
    </head>
    <body>
        <h1>Cadastro Cidade</h1>
        <form name="cadastro" method="get" action="CAECidade.jsp">
            <p> <label>Cidade:</label>
                <input type="text" name="nomeCidade" value="" size="40" />
            </p> 
            <p> <label>UF:</label>
                <input type="text" name="ufCidade" value="" size="5" />
            </p> 
            <input type="submit" value="Cadastrar" name="Cadastrar" />
            
        </form>
        <br>  <%= (mensagem==null)?"":mensagem%>

    </body>
</html>
