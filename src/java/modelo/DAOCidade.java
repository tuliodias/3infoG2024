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

public class DAOCidade {
    String mensagem="";

    public List<Cidade> listarCidade() {
        List<Cidade> listaCidade = new ArrayList<>();
        String sql = "select * from cidade";
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Cidade objCidade = new Cidade();
                objCidade.setCodigoCidade(rs.getInt("codigo"));
                objCidade.setNomeCidade(rs.getString("nome"));
                objCidade.setUfCidade(rs.getString("uf"));
                listaCidade.add(objCidade);
            }
        }catch(SQLException ex){
       System.out.println("Erro no listaCidade do DAOCidade:"+ex.getMessage());
        }
       return listaCidade;

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

}
