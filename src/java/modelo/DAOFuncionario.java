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
                objFuncionario.setObjCidade(objDaoCidade.localizar(rs.getInt("cidade")));
                listaFuncionario.add(objFuncionario);
            }
        }catch(SQLException ex){
       System.out.println("Erro no listaFuncionario do DAOFuncionario:"+ex.getMessage());
        }
       return listaFuncionario;

    }
    
    public String inserirFuncionario(Funcionario objFuncionario){
        String sql = "insert into funcionario(nome,salario,nascimento,cidade) values(?,?,?,?)";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objFuncionario.getNomeFuncionario());
            pst.setDouble(2, objFuncionario.getSalarioFuncionario());
            pst.setDate(3, objConverteData.converteBanco(objFuncionario.getDataNascimento()));
            pst.setInt(4, objFuncionario.getObjCidade().getCodigoCidade());
            if(pst.executeUpdate()>0){
                mensagem = "Funcionario cadastrado com sucesso!";
            }else{
                mensagem = "Funcionario não cadastrada!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no inserirFuncionario do DAOFuncionario: "
                    +ex.getMessage()+"\n Comando sql="+sql;
        }
      return mensagem;  
    }
    public String alterarFuncionario(Funcionario objFuncionario){
        String sql = "update funcionario set nome=?,salario=?,nascimento=?,cidade=? where codigo=?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, objFuncionario.getNomeFuncionario());
            pst.setDouble(2, objFuncionario.getSalarioFuncionario());
            pst.setDate(3, objConverteData.converteBanco(objFuncionario.getDataNascimento()));
            pst.setInt(4, objFuncionario.getObjCidade().getCodigoCidade());
            pst.setInt(5, objFuncionario.getCodigoFuncionario());
            if(pst.executeUpdate()>0){
                mensagem = "Funcionario alterado com sucesso!";
            }else{
                mensagem = "Funcionario não alterado!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no alterarFuncionario do DAOFuncionario: "
                    +ex.getMessage()+"\n Comando sql="+sql;
        }
      return mensagem;  
    }
    
    public String excluirFuncionario(Funcionario objFuncionario){
        String sql = "delete from funcionario where codigo=?";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, objFuncionario.getCodigoFuncionario());
            if(pst.executeUpdate()>0){
                mensagem = "Funcionario excluido com sucesso!";
            }else{
                mensagem = "Funcionario não excluida!";
            }
        }catch(SQLException ex){
            mensagem="Erro de SQL no excluirFuncionario do DAOFuncionario: "
                    +ex.getMessage()+"\n Comando sql="+sql;
        }
      return mensagem;  
    }

}
