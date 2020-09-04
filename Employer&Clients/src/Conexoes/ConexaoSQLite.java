/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author julio
 */
public class ConexaoSQLite {
    
    private Connection conexao;
    
//Conecta a um bando de dados (cria o banco se ele nao existir)
    
    public boolean conectar(){
        try{
            String url = "jdbc:sqlite:banco_de_dados/banco_sqlite.db";
            
            this.conexao = DriverManager.getConnection(url);
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        
        System.out.println("Conexao realizada!");
        
        return true;
    }
    
    public boolean desconectar(){
        
        try{
            if(this.conexao.isClosed() == false)
                this.conexao.close();
            
            }catch(SQLException e){
                System.err.println(e.getMessage());
                return false;
            }
        
        System.out.println("Conexao desfeita!");
        
        return true;
    }
    
//    Criar os statements para nossos sqls serem executados
    
    public Statement criarStatement(){
        try{
            return this.conexao.createStatement();
        }catch(SQLException e){
            return null;
        }
    }
    
    public PreparedStatement criarPreparedStatement(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    
    public Connection getConexao (){
        return this.conexao;
    }
    
}
