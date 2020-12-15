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
public class Clientes {
    
    private int ID;
    private String txtNome;
    private String txtNascimento;
    private String txtTelefone1;
    private String txtTelefone2;
    private String txtEmail;
    private String txtObservacao;
    private String txtDiaria;
    private String txtValorMensalidade;
    private String txtDataCobranca;
    private String txtVendedor;
    private String txtDataVendaContrato;
    private String txtNumeroContrato;
    private String txtRua;
    private String txtBairro;
    private String txtCidade;
    private String txtEstado;
    

    
    public Clientes(int ID,String txtNome,String txtNascimento,String txtTelefone1,String txtTelefone2,String txtEmail,String txtObservacao,String txtDiaria,String txtValorMensalidade,String txtDataCobranca,String txtVendedor,String txtDataVendaContrato,String txtNumeroContrato,String txtRua,String txtBairro,String txtCidade,String txtEstado){
       this.ID = ID;
       this.txtNome = txtNome;
       this.txtNascimento = txtNascimento;
       this.txtTelefone1 = txtTelefone1;
       this.txtTelefone2 = txtTelefone2;
       this.txtEmail = txtEmail;
       this.txtObservacao = txtObservacao;
       
       this.txtDiaria = txtDiaria;
       this.txtValorMensalidade = txtValorMensalidade;
       this.txtDataCobranca = txtDataCobranca;
       this.txtVendedor = txtVendedor;
       this.txtDataVendaContrato = txtDataVendaContrato;
       this.txtNumeroContrato = txtNumeroContrato;
       
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
    
    public String gettxtObservacao() {
        return txtObservacao;
    }

    public void settxtObservacao(String txtObservacao) {
        this.txtObservacao = txtObservacao;
    }
    
      public String gettxtDiaria() {
        return txtDiaria;
    }

    public void settxtDiaria(String txtDiaria) {
        this.txtDiaria = txtDiaria;
    }
    
      public String gettxtValorMensalidade() {
        return txtValorMensalidade;
    }

    public void settxtValorMensalidade(String txtValorMensalidade) {
        this.txtValorMensalidade = txtValorMensalidade;
    }
    
      public String gettxtDataCobranca() {
        return txtDataCobranca;
    }

    public void settxtDataCobranca(String txtDataCobranca) {
        this.txtDataCobranca = txtDataCobranca;
    }
    
      public String gettxtVendedor() {
        return txtVendedor;
    }

    public void settxtVendedor(String txtVendedor) {
        this.txtVendedor = txtVendedor;
    }
    
      public String gettxtDataVendaContrato() {
        return txtDataVendaContrato;
    }

    public void settxtDataVendaContrato(String txtDatavendaContrato) {
        this.txtDataVendaContrato = txtDataVendaContrato;
    }
    
    
    
      public String gettxtNumeroContrato() {
        return txtNumeroContrato;
    }

    public void settxtNumeroContrato(String txtNumeroContrato) {
        this.txtNumeroContrato = txtNumeroContrato;
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
        return "Clientes{" + "ID=" + ID + ", txtNome=" + txtNome + ", txtNascimento=" + txtNascimento + ", txtTelefone1=" + txtTelefone1 + ", txtTelefone2=" + txtTelefone2 + ", txtEmail=" + txtEmail + ", txtObservacao=" + txtObservacao + ", txtDiaria=" + txtDiaria + ", txtValorMensalidade=" + txtValorMensalidade + ", txtDataCobranca=" + txtDataCobranca + ", txtVendedor=" + txtVendedor + ", txtDataVendaContrato=" + txtDataVendaContrato + ", txtNumeroContrato=" + txtNumeroContrato + ", txtRua=" + txtRua + ", txtBairro=" + txtBairro + ", txtCiadade=" + txtCidade + ", txtEstado=" + txtEstado + '}';
    }  
    
    
    
    
    
    
    
    
    
}
