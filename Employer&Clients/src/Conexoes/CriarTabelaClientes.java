/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexoes;

import Entidades.Clientes;
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
public class CriarTabelaClientes {
    
    private final ConexaoSQLite conexaoSQLite;
    
    public CriarTabelaClientes(){
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
    
      public void criarTabelaClientes(){
                String sql3 = "CREATE TABLE IF NOT EXISTS Clientes"
                    + "("
                    + "ID integer PRIMARY KEY,"
                    + "txtNome text,"
                    + "txtNascimento text,"
                    + "txtTelefone1 text,"
                    + "txtTelefone2 text,"
                    + "txtEmail text,"
                    + "txtObservacao text,"
                    + "txtDiaria text,"
                    + "txtValorMensalidade text,"
                    + "txtDataCobranca text,"
                    + "txtVendedor text,"
                    + "txtDataVendaContrato text,"
                    + "txtNumeroContrato text,"
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
           
           stmt.execute(sql3);
           
           System.out.println("Tabela Clientes");
           
        }catch(SQLException e){
             System.out.println("Erro ao criar Tabela Clientes!");
            System.out.println(e);
            
            
        }finally {
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
            
        }
      
      
      //Mudar Para Clientes
      
       public ArrayList<Clientes> getClientes(){
          
          ResultSet resultSet = null;
          Statement statement = null;
          
          conexaoSQLite.conectar();
          
          String query = "SELECT *FROM Clientes order by txtNome;";
          
          statement = conexaoSQLite.criarStatement();
          
          ArrayList<Clientes> Clientes = new ArrayList();
          
          try {
              resultSet = statement.executeQuery(query);
              
              while (resultSet.next()) {
                  Clientes.add(new Clientes(
                        resultSet.getInt("ID"),  
                        resultSet.getString("txtNome"),
                        resultSet.getString("txtNascimento"),
                        resultSet.getString("txtTelefone1"),
                        resultSet.getString("txtTelefone2"),
                        resultSet.getString("txtEmail"),
                        resultSet.getString("txtObservacao"),
                        resultSet.getString("txtDiaria"),
                        resultSet.getString("txtValorMensalidade"),
                        resultSet.getString("txtDataCobranca"),
                        resultSet.getString("txtVendedor"),
                        resultSet.getString("txtDataVendaContrato"),
                        resultSet.getString("txtNumeroContrato"),
                        resultSet.getString("txtRua"),
                        resultSet.getString("txtBairro"),
                        resultSet.getString("txtCidade"),
                        resultSet.getString("txtEstado")));
                  
              }
              
              return Clientes;
              
          }catch (SQLException e){
              System.out.println("Error ao retornar os clientes!");
              return null;
          }finally {
              try {
                  resultSet.close();
                  statement.close();
                  conexaoSQLite.desconectar();
                  
              }catch (SQLException ex){
                  System.out.println("Erro ao se desconectar da tabela clientes!");
              }
          }
          
      }
      
      
      public ArrayList<Clientes> getClientes(String query){
          
          ResultSet resultSet = null;
          Statement statement = null;
          
          conexaoSQLite.conectar();
          
          query = "SELECT *FROM Clientes where "+ query +";";
          
          statement = conexaoSQLite.criarStatement();
          
          ArrayList<Clientes> Clientes = new ArrayList();
          
          try {
              resultSet = statement.executeQuery(query);
              
              while (resultSet.next()) {
                  Clientes.add(new Clientes(
                        resultSet.getInt("ID"),  
                        resultSet.getString("txtNome"),
                        resultSet.getString("txtNascimento"),
                        resultSet.getString("txtTelefone1"),
                        resultSet.getString("txtTelefone2"),
                        resultSet.getString("txtEmail"),
                        resultSet.getString("txtObservacao"),
                        resultSet.getString("txtDiaria"),
                        resultSet.getString("txtValorMensalidade"),
                        resultSet.getString("txtDataCobranca"),
                        resultSet.getString("txtVendedor"),
                        resultSet.getString("txtDataVendaContrato"),
                        resultSet.getString("txtNumeroContrato"),
                        resultSet.getString("txtRua"),
                        resultSet.getString("txtBairro"),
                        resultSet.getString("txtCidade"),
                        resultSet.getString("txtEstado")));
                          
                  
              }
              return Clientes;
              
          }catch(SQLException e){
              System.out.println(e);
              return null;
          } finally {
              try{
                  resultSet.close();
                  statement.close();
                  conexaoSQLite.desconectar();
              }catch (SQLException ex){
                  System.out.println(ex);
              }
          }
          
      }
      
      public void insert(Clientes Clientes) {
          String sql = "INSERT INTO Clientes ("
                  + "txtNome,"
                  + "txtNascimento,"
                  + "txtTelefone1,"
                  + "txtTelefone2,"
                  + "txtEmail,"
                  + "txtObservacao,"
                  + "txtDiaria,"
                  + "txtValorMensalidade,"
                  + "txtDataCobranca,"
                  + "txtVendedor,"
                  + "txtDataVendaContrato,"
                  + "txtNumeroContrato,"
                  + "txtRua,"
                  + "txtBairro,"
                  + "txtCidade,"
                  + "txtEstado)" 
                  +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
          boolean conectou = false;
          conectou = conexaoSQLite.conectar();
          try {
              PreparedStatement pstmt = this.conexaoSQLite.criarPreparedStatement(sql);
              pstmt.setString(1, Clientes.gettxtNome());
              pstmt.setString(2, Clientes.gettxtNascimento());
              pstmt.setString(3, Clientes.gettxtTelefone1());
              pstmt.setString(4, Clientes.gettxtTelefone2());
              pstmt.setString(5, Clientes.gettxtEmail());
              pstmt.setString(6, Clientes.gettxtObservacao());
              pstmt.setString(7, Clientes.gettxtDiaria());
              pstmt.setString(8, Clientes.gettxtValorMensalidade());
              pstmt.setString(9, Clientes.gettxtDataCobranca());
              pstmt.setString(10, Clientes.gettxtVendedor());
              pstmt.setString(11, Clientes.gettxtDataVendaContrato());
              pstmt.setString(12, Clientes.gettxtNumeroContrato());
              pstmt.setString(13, Clientes.gettxtRua());
              pstmt.setString(14, Clientes.gettxtBairro());
              pstmt.setString(15, Clientes.gettxtCidade());
              pstmt.setString(16, Clientes.gettxtEstado());
              
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
          
          String sql = "Delete from Clientes where ID = "+ID+";";
          
          statement = conexaoSQLite.criarStatement();
          
          try {
              statement.executeQuery(sql);
              
              
          }catch(SQLException e){
              System.out.println(e);
          }finally{
              conexaoSQLite.desconectar();
          }
      }
      
      
      public void update(Clientes Clientes){
          String sql =
                  "UPDATE Clientes SET "
                  +  "txtNome = '" + Clientes.gettxtNome()+ "', "
                  +  "txtNascimento = '" + Clientes.gettxtNascimento()+ "', "
                  +  "txtTelefone1 = '" + Clientes.gettxtTelefone1()+ "', "
                  +  "txtTelefone2 = '" + Clientes.gettxtTelefone2()+ "', "
                  +  "txtEmail = '" + Clientes.gettxtEmail()+ "', "
                  +  "txtObservacao = '" + Clientes.gettxtObservacao()+ "', "
                  +  "txtDiaria = '" + Clientes.gettxtDiaria()+ "', "
                  +  "txtValorMensalidade= '" + Clientes.gettxtValorMensalidade()+ "', "
                  +  "txtDataCobranca = '" + Clientes.gettxtDataCobranca()+ "', "
                  +  "txtVendedor = '" + Clientes.gettxtVendedor()+ "', "
                  +  "txtDataVendaContrato = '" + Clientes.gettxtDataVendaContrato()+ "', "
                  +  "txtNumeroContrato = '" + Clientes.gettxtNumeroContrato()+ "', "
                  +  "txtRua = '" + Clientes.gettxtRua()+ "', "
                  +  "txtBairro= '" + Clientes.gettxtBairro()+ "', "
                  +  "txtCidade= '" + Clientes.gettxtCidade()+ "', "
                  +  "txtEstado = '" + Clientes.gettxtEstado()+ "'"
                  +  "WHERE ID = " + Clientes.getID() + ";";
                 
          
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
      
      public ArrayList<Clientes> searchClientes(String search){
          
        search = addTildeOptions(search).toLowerCase();

        ResultSet resultSet = null;
        Statement statement = null;
        
        conexaoSQLite.conectar();
        
        String query = "SELECT * FROM Clientes where lower(txtNome) glob '*" + search + "*' order by txtNome;";

        System.out.println(query);

        statement = conexaoSQLite.criarStatement();
        
        ArrayList <Clientes> Clientes = new ArrayList();
        
        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Clientes.add(new Clientes(
                        resultSet.getInt("ID"),  
                        resultSet.getString("txtNome"),
                        resultSet.getString("txtNascimento"),
                        resultSet.getString("txtTelefone1"),
                        resultSet.getString("txtTelefone2"),
                        resultSet.getString("txtEmail"),
                        resultSet.getString("txtObservacao"),
                        resultSet.getString("txtDiaria"),
                        resultSet.getString("txtValorMensalidade"),
                        resultSet.getString("txtDataCobranca"),
                        resultSet.getString("txtVendedor"),
                        resultSet.getString("txtDataVendaContrato"),
                        resultSet.getString("txtNumeroContrato"),
                        resultSet.getString("txtRua"),
                        resultSet.getString("txtBairro"),
                        resultSet.getString("txtCidade"),
                        resultSet.getString("txtEstado")));
 
            }
            return Clientes;
            
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
