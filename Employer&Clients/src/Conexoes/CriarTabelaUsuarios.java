/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexoes;

import Entidades.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author julio
 */
public class CriarTabelaUsuarios {
    
    private final ConexaoSQLite conexaoSQLite;
    
    public CriarTabelaUsuarios(){
        this.conexaoSQLite = new ConexaoSQLite();
    }
    
     public void criarTabelaUsuarios(){
            String sql1 = "CREATE TABLE IF NOT EXISTS Usuarios"
                    + "("
                    + "ID integer PRIMARY KEY,"
                    + "Login text,"
                    + "Senha text"
                    + ");";
           
//            executando o sql de criar tabelas

        boolean conectou = false;
        
        try {
           conectou = this.conexaoSQLite.conectar();
           
           Statement stmt = this.conexaoSQLite.criarStatement();
           
           stmt.execute(sql1);
           
           System.out.println("Tabela Usuários!");
           
        }catch(SQLException e){
            System.out.println("Erro ao criar Tabela Usuários!");
            System.out.println(e);
            
        }finally {
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
            
        }
     
     public ArrayList<Usuarios> getUsuarios(){
         
        ResultSet resultSet = null;
        Statement statement = null;

        conexaoSQLite.conectar();

        String query = "SELECT *FROM Usuarios;";
        
        statement = conexaoSQLite.criarStatement();
        
        ArrayList<Usuarios> Usuarios = new ArrayList();
        
        try{
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()){
                Usuarios.add(new Usuarios(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Senha")));
                       
            }
            
            return Usuarios;
            
        }catch(SQLException e){
            System.out.println("Erro ao retornar os Usuários");
            System.out.println(e);
            return null;
            
        }finally {
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            } catch (SQLException ex) {
                System.out.println("Erro ao desconectar da tabela Usuários!");
                System.out.println(ex);
            }
            
        }
     }
     
     public void insert(Usuarios Usuarios) {
        String sql = "INSERT INTO Usuarios (Login ,Senha) VALUES (?,?)";

        boolean conectou = false;
        try {
            conectou = this.conexaoSQLite.conectar();
            PreparedStatement pstmt = this.conexaoSQLite.criarPreparedStatement(sql);
            pstmt.setString(1, Usuarios.getLogin());
            pstmt.setString(2, String.valueOf(Usuarios.getSenha()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
    }
     
    
        public int checkUser(String Login, String Senha){
        ResultSet resultSet = null;
        Statement pstmt = null;

        conexaoSQLite.conectar();
        pstmt = conexaoSQLite.criarStatement();
        
        String query = "Select * From Usuarios where Login = '" + Login + "' and Senha = '" + String.valueOf(Senha.hashCode()) + "';";
        
        
        ArrayList<Usuarios> Usuarios = new ArrayList();

        try {

            resultSet = pstmt.executeQuery(query);

            while (resultSet.next()) {
                Usuarios.add(new Usuarios(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"), 
                        resultSet.getString("Senha"))); 
 
            }
            resultSet.close();
            pstmt.close();
            return Usuarios.size();
        } catch (SQLException e) {
            System.out.println("Erro ao checkar Usuários!");
            System.out.println(e);
            return 0;
        } finally {
            conexaoSQLite.desconectar();
        }
    }
     
     
     
     
     
     
     
    
}
