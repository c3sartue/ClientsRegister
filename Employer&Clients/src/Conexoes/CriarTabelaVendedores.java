/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexoes;

import Entidades.Vendedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author julio
 */
public class CriarTabelaVendedores {
    
    private final ConexaoSQLite conexaoSQLite;
    
    public CriarTabelaVendedores(){
        this.conexaoSQLite = new ConexaoSQLite();
    }

    
    
     private String addTildeOptions(String search) {
            return search.toLowerCase()
                             .replaceAll("[aáàäâã]", "\\[aáàäâã\\]")
                             .replaceAll("[eéèëê]", "\\[eéèëê\\]")
                             .replaceAll("[iíìî]", "\\[iíìî\\]")
                             .replaceAll("[oóòöôõ]", "\\[oóòöôõ\\]")
                             .replaceAll("[uúùüû]", "\\[uúùüû\\]")
                             .replace("*", "[*]")
                             .replace("?", "[?]");
    }

    
    
    
    
      public void criarTabelaVendedores(){
               String sql2 = "CREATE TABLE IF NOT EXISTS Vendedores"
                    + "("
                    + "ID integer PRIMARY KEY,"
                    + "txtNome text ,"
                    + "txtNascimento text ,"
                    + "txtTelefone1 text,"
                    + "txtTelefone2 text,"
                    + "txtEmail text,"
                    + "txtRG text,"
                    + "txtCPF text,"
                    + "txtObservacao text,"
                    + "txtRua text,"
                    + "txtBairro text,"
                    + "txtCidade text,"
                    + "txtEstado text"
                    + ");";
           
//            executando o sql de criar tabelas

        boolean conectou = false;
        
        try {
           conectou = this.conexaoSQLite.conectar();
           
           Statement stmt = this.conexaoSQLite.criarStatement();
           
           stmt.execute(sql2);
           
           System.out.println("Tebela Vendedores!");
           
        }catch(SQLException e){
             System.out.println("Erro ao criar Tabela Vendedores!");
            System.out.println(e);
            
            
        }finally {
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
            
        }
      
      
      public ArrayList<Vendedores> getVendedores(){
          
          ResultSet resultSet = null;
          Statement statement = null;
          
          conexaoSQLite.conectar();
          
          String query = "SELECT *FROM Vendedores order by txtNome;";
          
          statement = conexaoSQLite.criarStatement();
          
          ArrayList<Vendedores> Vendedores = new ArrayList();
          
          try {
              resultSet = statement.executeQuery(query);
              
              while (resultSet.next()) {
                  Vendedores.add(new Vendedores(
                        resultSet.getInt("ID"),  
                        resultSet.getString("txtNome"),
                        resultSet.getString("txtNascimento"),
                        resultSet.getString("txtTelefone1"),
                        resultSet.getString("txtTelefone2"),
                        resultSet.getString("txtEmail"),
                        resultSet.getString("txtRG"),
                        resultSet.getString("txtCPF"),
                        resultSet.getString("txtObservacao"),
                        resultSet.getString("txtRua"),
                        resultSet.getString("txtBairro"),
                        resultSet.getString("txtCidade"),
                        resultSet.getString("txtEstado")));
                  
              }
              
              return Vendedores;
              
          }catch (SQLException e){
              System.out.println("Error ao retornar os vendedores!");
              return null;
          }finally {
              try {
                  resultSet.close();
                  statement.close();
                  conexaoSQLite.desconectar();
                  
              }catch (SQLException ex){
                  System.out.println("Erro ao se desconectar da tabela Vendedores!");
              }
          }
          
      }
      
      
      public ArrayList<String> getVendedorestxtNome(){
          
          ResultSet resultSet = null;
          Statement statement = null;
          
          conexaoSQLite.conectar();
          
          String query = "SELECT txtNome FROM Vendedores order by txtNome;";
          
          statement = conexaoSQLite.criarStatement();
          
          ArrayList<String> VendedorestxtNome = new ArrayList();
          
          try {
              resultSet = statement.executeQuery(query);
              
              while (resultSet.next()) {
                  VendedorestxtNome.add(resultSet.getString("txtNome"));
                  
              }
              return VendedorestxtNome;
              
          }catch(SQLException e){
              System.out.println("Erro ao buscar os nomes!");
              return null;
          } finally {
              try{
                  resultSet.close();
                  statement.close();
                  conexaoSQLite.desconectar();
              }catch (SQLException ex){
                  System.out.println("Erro ao se desconectar da tabela Vendedores");
              }
          }
          
      }
      
      public void insert(Vendedores Vendedores) {
          String sql = "INSERT INTO Vendedores ("
                  + "txtNome,"
                  + "txtNascimento,"
                  + "txtTelefone1,"
                  + "txtTelefone2,"
                  + "txtEmail,"
                  + "txtRG,"
                  + "txtCPF,"
                  + "txtObservacao,"
                  + "txtRua,"
                  + "txtBairro,"
                  + "txtCidade,"
                  + "txtEstado)" 
                  + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
          
          boolean conectou = false;
          conectou = conexaoSQLite.conectar();
          try {
              PreparedStatement pstmt = this.conexaoSQLite.criarPreparedStatement(sql);
              
              pstmt.setString(1, Vendedores.gettxtNome());
              pstmt.setString(2, Vendedores.gettxtNascimento());
              pstmt.setString(3, Vendedores.gettxtTelefone1());
              pstmt.setString(4, Vendedores.gettxtTelefone2());
              pstmt.setString(5, Vendedores.gettxtEmail());
              pstmt.setString(6, Vendedores.gettxtRG());
              pstmt.setString(7, Vendedores.gettxtCPF());
              pstmt.setString(8, Vendedores.gettxtObservacao());
              pstmt.setString(9, Vendedores.gettxtRua());
              pstmt.setString(10, Vendedores.gettxtBairro());
              pstmt.setString(11, Vendedores.gettxtCidade());
              pstmt.setString(12, Vendedores.gettxtEstado());
              
              pstmt.executeUpdate();
              
              
              
          }catch(SQLException e){
              System.out.println(e.getMessage());
          }finally{
              if(conectou){
                  conexaoSQLite.desconectar();
              }
          }
      }
      
      public void delete (int ID){
          
          Statement statement = null;
          
          conexaoSQLite.conectar();
          
          String sql = "Delete from Vendedores where ID = "+ID+";";
          
          statement = conexaoSQLite.criarStatement();
          
          try {
              statement.executeQuery(sql);
              
              
          }catch(SQLException e){
              System.out.println(e);
          }finally{
              conexaoSQLite.desconectar();
          }
      }
      
      
      public void update(Vendedores Vendedores){
          String sql =
                  "UPDATE Vendedores SET "
                  +  "txtNome = '" + Vendedores.gettxtNome()+ "', "
                  +  "txtNascimento = '" + Vendedores.gettxtNascimento()+ "', "
                  +  "txtTelefone1 = '" + Vendedores.gettxtTelefone1()+ "', "
                  +  "txtTelefone2 = '" + Vendedores.gettxtTelefone2()+ "', "
                  +  "txtEmail = '" + Vendedores.gettxtEmail()+ "', "
                  +  "txtRG = '" + Vendedores.gettxtRG()+ "', "
                  +  "txtCPF = '" + Vendedores.gettxtCPF()+ "', "
                  +  "txtObservacao = '" + Vendedores.gettxtObservacao()+ "', "
                  +  "txtRua = '" + Vendedores.gettxtRua()+ "', "
                  +  "txtBairro= '" + Vendedores.gettxtBairro()+ "', "
                  +  "txtCidade= '" + Vendedores.gettxtCidade()+ "', "
                  +  "txtEstado = '" + Vendedores.gettxtEstado()+ "' "
                  +  "WHERE ID = " + Vendedores.getID() + ";";
                  
          
          boolean conectou = false;
          conectou = conexaoSQLite.conectar();
          
          try {
              System.out.println(sql);
              PreparedStatement pstmt = this.conexaoSQLite.criarPreparedStatement(sql);
              
              pstmt.executeUpdate();
              
          }catch(SQLException e){
              System.out.println(e.getMessage());
          }finally{
              if (conectou){
                  conexaoSQLite.desconectar();
              }
          }
          
                  
      }
      
      public ArrayList<Vendedores> searchVendedores(String search){
          
        search = addTildeOptions(search).toLowerCase();

        ResultSet resultSet = null;
        Statement statement = null;
        
        conexaoSQLite.conectar();
        
        String query = "SELECT * FROM Vendedores where lower(txtNome) glob '*" + search + "*' order by txtNome;";

        System.out.println(query);

        statement = conexaoSQLite.criarStatement();
        
        ArrayList <Vendedores> Vendedores = new ArrayList();
        
        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Vendedores.add(new Vendedores(
                        resultSet.getInt("ID"),
                        resultSet.getString("txtNome"), 
                        resultSet.getString("txtNascimento"), 
                        resultSet.getString("txtTelefone1"), 
                        resultSet.getString("txtTelefone2"), 
                        resultSet.getString("txtEmail"), 
                        resultSet.getString("txtRG"), 
                        resultSet.getString("txtCPF"), 
                        resultSet.getString("txtObservacao"), 
                        resultSet.getString("txtRua"), 
                        resultSet.getString("txtBairro"), 
                        resultSet.getString("txtCidade"), 
                        resultSet.getString("txtEstado"))); 
 
            }
            return Vendedores;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                statement.close();
                conexaoSQLite.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
      }
      
      
      
      
      
      
      
      
    
}
