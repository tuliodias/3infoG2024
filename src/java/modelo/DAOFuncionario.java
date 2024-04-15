/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFuncionario {
    String mensagem="";
    ConverteData objConverteData = new ConverteData();
    DAOCidade objDaoCidade = new DAOCidade();

    public List<Funcionario> listarFuncionario() {
        List<Funcionario> listaFuncionario = new ArrayList<>();
        String sql = "select * from funcionario";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setCodigoFuncionario(rs.getInt("codigo"));
                objFuncionario.setNomeFuncionario(rs.getString("nome"));
                objFuncionario.setSalarioFuncionario(rs.getDouble("salario"));
                objFuncionario.setDataNascimento(objConverteData.converteCalendario(rs.getDate("nascimento")));
              
                listaFuncionario.add(objFuncionario);
            }
        }catch(SQLException ex){
       System.out.println("Erro no listaCidade do DAOCidade:"+ex.getMessage());
        }
       return listaFuncionario;

    }
    
    public String inserirCidade(Cidade objCidade){
        String sql = "insert into cidade(nome,uf) values(?,?)";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objCidade.getNomeCidade());
            pst.setString(2, objCidade.getUfCidade());
            if(pst.executeUpdate()>0){
                mensagem = "Cidade cadastrada com sucesso!";
            }else{
                mensagem = "Cidade não cadastrada!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no inserirCidade do DAOCidade: "
                    +ex.getMessage()+"\n Comando sql="+sql;
        }
      return mensagem;  
    }
    public String alterarCidade(Cidade objCidade){
        String sql = "update cidade set nome=?, uf=? where codigo=?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objCidade.getNomeCidade());
            pst.setString(2, objCidade.getUfCidade());
            pst.setInt(3, objCidade.getCodigoCidade());
            if(pst.executeUpdate()>0){
                mensagem = "Cidade alterada com sucesso!";
            }else{
                mensagem = "Cidade não alterada!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no alterarCidade do DAOCidade: "
                    +ex.getMessage()+"\n Comando sql="+sql;
        }
      return mensagem;  
    }
    public String excluirCidade(Cidade objCidade){
        String sql = "delete from cidade where codigo=?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objCidade.getCodigoCidade());
            if(pst.executeUpdate()>0){
                mensagem = "Cidade excluida com sucesso!";
            }else{
                mensagem = "Cidade não excluida!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no excluirCidade do DAOCidade: "
                    +ex.getMessage()+"\n Comando sql="+sql;
        }
      return mensagem;  
    }

}
