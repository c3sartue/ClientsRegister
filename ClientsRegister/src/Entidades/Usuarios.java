/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author julio
 */
public class Usuarios {
    
    int ID;
    String Login;
    String Senha;
   
    
    
    
    public Usuarios(int ID,String Login, String Senha ) {
        
        this.ID = ID;
        this.Login = Login;
        this.Senha = Senha;
        
    }
    
    //Métodos Construtores
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    
    }
    
}
