/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author tulio
 */
public class Conexao {
    
    private static final String banco = "jdbc:mysql://localhost:3306/3infog";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String senha = "";
    private static Connection con = null;
    
    public static Connection getConexao(){
        if(con==null){
           try{
               Class.forName(driver);
               con = DriverManager.getConnection(banco, usuario, senha);
           }catch(ClassNotFoundException ex){
               System.out.println("Não encontrou o driver: "+ex.getMessage());
           }catch(SQLException ex){
               System.out.println("Erro de conexão: "+ex.getMessage());
           }
        }
        return con;
    }
    
    public static PreparedStatement getPreparedStatement(String sql){
        if(con==null){
            con = getConexao();
        }
        try{
            return con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        }catch(SQLException ex){
            System.out.println("Erro no comando sql: "+ex.getMessage());
        }
       return null;
    }
    
    
    
}
