<%@page import="modelo.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="modelo.DAOCidade"%>
<%
DAOCidade objDAOCidade = new DAOCidade();
List<Cidade> listaCidade = objDAOCidade.listarCidade();

%>

<table border="1">
    <thead>
        <tr>
            <th>CODIGO</th>
            <th>NOME</th>
            <th>UF</th>
        </tr>
    </thead>
    <tbody>
        <% for(Cidade cidade:listaCidade){  %>
        <tr>
            <td><%= cidade.getCodigoCidade()%></td>
            <td><%= cidade.getNomeCidade() %></td>
            <td><%= cidade.getUfCidade() %></td>
        </tr>
        
        <%}%>
    </tbody>
</table>