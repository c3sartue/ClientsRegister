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
public class Vendedores {

   private int ID;
   private String txtNome;
   private String txtNascimento;
   private String txtTelefone1;
   private String txtTelefone2;
   private String txtEmail;
   private String txtRG;
   private String txtCPF;
   private String txtObservacao;
   private String txtRua;
   private String txtBairro;
   private String txtCidade;
   private String txtEstado;
    

    
    public Vendedores(int ID,String txtNome,String txtNascimento,String txtTelefone1,String txtTelefone2,String txtEmail,String txtRG,String txtCPF,String txtObservacao,String txtRua,String txtBairro,String txtCidade,String txtEstado){
       this.ID = ID;
       this.txtNome = txtNome;
       this.txtNascimento = txtNascimento;
       this.txtTelefone1 = txtTelefone1;
       this.txtTelefone2 = txtTelefone2;
       this.txtEmail = txtEmail;
       this.txtRG = txtRG;
       this.txtCPF = txtCPF;
       this.txtObservacao = txtObservacao;
       this.txtRua = txtRua;
       this.txtBairro = txtBairro;
       this.txtCidade = txtCidade;
       this.txtEstado = txtEstado;
    }

    
   
//    Métodos Construtores
     public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
     public String gettxtNome() {
        return txtNome;
    }

    public void settxtNome(String txtNome) {
        this.txtNome = txtNome;
    }
    
    public String gettxtNascimento() {
        return txtNascimento;
    }

    public void settxtNascimento(String txtNascimento) {
        this.txtNascimento = txtNascimento;
    }
    
     public String gettxtTelefone1() {
        return txtTelefone1;
    }

    public void settxtTelefone1(String txtTelefone1) {
        this.txtTelefone1 = txtTelefone1;
    }
    
      public String gettxtTelefone2() {
        return txtTelefone2;
    }

    public void settxtTelefone2(String txtTelefone2) {
        this.txtTelefone2 = txtTelefone2;
    }
    
      public String gettxtEmail() {
        return txtEmail;
    }

    public void settxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }
    
      public String gettxtRG() {
        return txtRG;
    }

    public void settxtRG(String txtRG) {
        this.txtRG = txtRG;
    }
    
      public String gettxtCPF() {
        return txtCPF;
    }

    public void settxtCPF(String txtCPF) {
        this.txtCPF = txtCPF;
    }
    
      public String gettxtObservacao() {
        return txtObservacao;
    }

    public void settxtObservacao(String txtObservacao) {
        this.txtObservacao = txtObservacao;
    }
    
      public String gettxtRua() {
        return txtRua;
    }

    public void settxtRua(String txtRua) {
        this.txtRua = txtRua;
    }
    
     public String gettxtBairro() {
        return txtBairro;
    }

    public void settxtBairro(String txtBairro) {
        this.txtBairro = txtBairro;
    }
    
     public String gettxtCidade() {
        return txtCidade;
    }

    public void settxtCidade(String txtCidade) {
        this.txtCidade = txtCidade;
    }
    
      public String gettxtEstado() {
        return txtEstado;
    }

    public void settxtEstado(String txtEstado) {
        this.txtEstado = txtEstado;
    }
    
    
    
    
    
     public String toString() {
        return "Vendedores{" + "ID=" + ID + ", txtNome=" + txtNome + ", txtNascimento=" + txtNascimento + ", txtTelefone1=" + txtTelefone1 + ", txtTelefone2=" + txtTelefone2 + ", txtEmail=" + txtEmail +", txtRG" + txtRG + ", txtCPF" + txtCPF +  ", txtObservacao=" + txtObservacao + ", txtRua=" + txtRua + ", txtBairro=" + txtBairro + ", txtCiadade=" + txtCidade + ", txtEstado=" + txtEstado + '}';
    }  

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
