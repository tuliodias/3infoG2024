<%@page import="modelo.ConverteData"%>
<%@page import="modelo.Funcionario"%>
<%@page import="modelo.DAOFuncionario"%>
<%@page import="modelo.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="modelo.DAOCidade"%>
<%
DAOFuncionario objDAOFuncionario = new DAOFuncionario();
List<Funcionario> listaFuncionario = objDAOFuncionario.listarFuncionario();
ConverteData objConverteData = new ConverteData();

%>

<table border="1">
    <thead>
        <tr>
            <th>CODIGO</th>
            <th>NOME</th>
            <th>SALARIO</th>
            <th>NACIMENTO</th>
            <th>CIDADE</th>
            <th>ALTERAR</th>
            <th>EXCLUIR</th>
        </tr>
    </thead>
    <tbody>
        <% for(Funcionario funcionario:listaFuncionario){  %>
        <tr>
            <td><%= funcionario.getCodigoFuncionario() %></td>
            <td><%= funcionario.getNomeFuncionario() %></td>
            <td><%= funcionario.getSalarioFuncionario() %></td>
            <td><%= objConverteData.converteTela(funcionario.getDataNascimento()) %></td>
            <td><%= funcionario.getObjCidade().getNomeCidade() %></td>
     
            <td><a href="CadastroFuncionario.jsp?opcao=alterar&codigoFuncionario=<%= funcionario.getCodigoFuncionario()%>&nomeFuncionario=<%= funcionario.getNomeFuncionario() %>&nascimentoFuncionario=<%= objConverteData.converteTela(funcionario.getDataNascimento()) %>&codigoCidade=<%= funcionario.getObjCidade().getCodigoCidade() %>&salarioFuncionario=<%= funcionario.getSalarioFuncionario() %>">alterar</a> </td>
            <td><a href="CadastroFuncionario.jsp?opcao=excluir&codigoFuncionario=<%= funcionario.getCodigoFuncionario()%>&nomeFuncionario=<%= funcionario.getNomeFuncionario() %>&nascimentoFuncionario=<%= objConverteData.converteTela(funcionario.getDataNascimento()) %>&codigoCidade=<%= funcionario.getObjCidade().getCodigoCidade() %>&salarioFuncionario=<%= funcionario.getSalarioFuncionario() %>">excluir</a> </td>
                  
        </tr>
        
        <%}%>
    </tbody>
</table>