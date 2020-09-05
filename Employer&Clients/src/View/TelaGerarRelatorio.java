/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Conexoes.CriarTabelaClientes;
import Conexoes.CriarTabelaVendedores;
import Entidades.Clientes;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Label;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */
public class TelaGerarRelatorio extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaGerarRelatorio
     */
    ArrayList<Clientes> Clientes;
    
    ArrayList<JTextField> ClientesFields = new ArrayList<>();
    ArrayList<JTextField> DataCobrancaFields = new ArrayList<>();
    ArrayList<JComboBox> VendedorComboBoxes = new ArrayList<>();
    
    private String addTildeOptions(String search) {
            return search.toLowerCase()
                             .replaceAll("[aáàäâã]", "\\[aáàäâãAÁÃÀÂ\\]")
                             .replaceAll("[eéèëê]", "\\[eéèëêEÉẼÈÊ\\]")
                             .replaceAll("[iíìî]", "\\[iíìîIÌÍĨÎ\\]")
                             .replaceAll("[oóòöôõ]", "\\[oóòöôõÔÕÓÒ\\]")
                             .replaceAll("[uúùüû]", "\\[uúùüûÚUÙÛŨ\\]")
                             .replace("*", "[*]")
                             .replace("?", "[?]");
    }
    
    private String getQueryCB(ArrayList<JComboBox> comboBox, String tbl) {
        int idx = 0;
        String query = "( ";
//        for (JComboBox cbAlcance: comboBox){
//            if(!cbAlcance.getSelectedItem().toString().trim().equals("")){
//                if(idx > 0){
//                query += " or ";
//            }
//            query += "lower(" + tbl + ") glob '*" + addTildeOptions(cbAlcance.getSelectedItem().toString()) + "*'"; 
//            idx++;
//            }
//        }
        query += " )";
        if(query.equals("(  )")){
            return "";
        }
        return query;
    }
    
     
     private String agregarQueries(String[] Queries){
        int idx = 0;
        String queryCompose = "";
        for (String query: Queries){
            System.out.println(query);
            if(!query.equals("")){
                if(idx > 0){
                    queryCompose += " and ";
                }
                queryCompose += " " + query; 
                idx++;
            }
        }
        return queryCompose;
    }
     
     private String getQueryTF(ArrayList<JTextField> textFields, String tbl) {
        int idx = 0;
        String query = "( ";
        for (JTextField tf: textFields){
            if(!tf.getText().trim().equals("")){
                if(idx > 0){
                query += " or ";
            }
            query += "lower(" + tbl + ") glob '*" + addTildeOptions(tf.getText()) + "*'"; 
            idx++;
            }
        }
        query += " )";
        if(query.equals("(  )")){
            return "";
        }
        return query;
    }
    
     private void addFilters(){
         
         CriarTabelaVendedores criarTabelaVendedores = new CriarTabelaVendedores();
         
         JTextField txtClientes = new JTextField();
         jFilters.add(txtClientes);
         ClientesFields.add(txtClientes);
         
         JTextField txtDataCobranca = new JTextField();
         jFilters.add(txtDataCobranca);
         DataCobrancaFields.add(txtDataCobranca);
         
         JComboBox comboboxVendedor = new JComboBox();
         DefaultComboBoxModel modelVendedor = new DefaultComboBoxModel(criarTabelaVendedores.getVendedorestxtNome().toArray());
         comboboxVendedor.setModel(modelVendedor);
         jFilters.add(comboboxVendedor);
         VendedorComboBoxes.add(comboboxVendedor);
            
     }
    
    
    public TelaGerarRelatorio() {
        initComponents();
        
        
        DefaultTableModel dtmClientes = (DefaultTableModel) jClientes.getModel();
    
        CriarTabelaClientes criarTabelaClientes = new CriarTabelaClientes();
        
        Clientes = criarTabelaClientes.getClientes();
        
        Clientes.stream().forEach(s -> {
            Object[] dados = {
                    s.getID(),
                    s.gettxtNome(),
                    s.gettxtNascimento(),
                    s.gettxtTelefone1(),
                    s.gettxtTelefone2(),
                    s.gettxtEmail(),
                    s.gettxtObservacao(),
                    s.gettxtDiaria(),
                    s.gettxtValorMensalidade(),
                    s.gettxtDataCobranca(),
                    s.gettxtVendedor(),
                    s.gettxtDataVendaContrato(),
                    s.gettxtNumeroContrato(),
                    s.gettxtRua(),
                    s.gettxtBairro(),
                    s.gettxtCidade(),
                    s.gettxtEstado(),};
                
                    dtmClientes.addRow(dados);
            
        });
        
        jClientes.setModel(dtmClientes);
        
        jFilters.add(new Label ("Cliente"));
        jFilters.add(new Label ("Vendedor"));
        jFilters.add(new Label ("Data Cobrança"));
        
        addFilters();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollFilters = new javax.swing.JScrollPane();
        jFilters = new javax.swing.JPanel();
        btAddFilters = new javax.swing.JButton();
        btFilter = new javax.swing.JButton();
        btCreatePdf = new javax.swing.JButton();

        setClosable(true);

        jClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data de nascimento", "Telefone - 1", "Telefone - 2", "Email", "Observação", "Diárias", "Valor da Mensalidade", "Data da cobrança", "Vendedor", "Data de venda do contrato", "Número do contrato", "Rua", "Bairro", "Cidade", "Estado"
            }
        ));
        jClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClientesMouseClicked(evt);
            }
        });
        jClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jClientesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jClientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        javax.swing.GroupLayout jFiltersLayout = new javax.swing.GroupLayout(jFilters);
        jFilters.setLayout(jFiltersLayout);
        jFiltersLayout.setHorizontalGroup(
            jFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 977, Short.MAX_VALUE)
        );
        jFiltersLayout.setVerticalGroup(
            jFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollFilters.setViewportView(jFilters);

        btAddFilters.setText("+ Adicionar Filtro");
        btAddFilters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddFiltersActionPerformed(evt);
            }
        });

        btFilter.setText("Filtrar");
        btFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAddFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btAddFilters)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btFilter)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        btCreatePdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icons/pdf.png"))); // NOI18N
        btCreatePdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreatePdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCreatePdf, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btCreatePdf)))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jClientesMouseClicked

       
    }//GEN-LAST:event_jClientesMouseClicked

    private void jClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jClientesKeyReleased

      
    }//GEN-LAST:event_jClientesKeyReleased

    private void btAddFiltersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddFiltersActionPerformed
        // TODO add your handling code here:
        addFilters();
    }//GEN-LAST:event_btAddFiltersActionPerformed

    private void btFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFilterActionPerformed
        // TODO add your handling code here:

    CriarTabelaClientes criarTabelaClientes = new CriarTabelaClientes();
    String [] queries = {
        getQueryTF(ClientesFields,"Nome"),
        getQueryTF(DataCobrancaFields,"Data Cobrança"),
        getQueryCB(VendedorComboBoxes, "Vendedor"),
        
        
    };
    
    String query = agregarQueries(queries);
    System.out.println(query);
    
    DefaultTableModel dtmClientes = (DefaultTableModel) jClientes.getModel();
    
    dtmClientes.setRowCount(0);
    
    ArrayList<Clientes> clientesReturn = criarTabelaClientes.getClientes(query);
    clientesReturn.stream().forEach(s -> {
         Object[] dados = {
                    s.getID(),
                    s.gettxtNome(),
                    s.gettxtNascimento(),
                    s.gettxtTelefone1(),
                    s.gettxtTelefone2(),
                    s.gettxtEmail(),
                    s.gettxtObservacao(),
                    s.gettxtDiaria(),
                    s.gettxtValorMensalidade(),
                    s.gettxtDataCobranca(),
                    s.gettxtVendedor(),
                    s.gettxtDataVendaContrato(),
                    s.gettxtNumeroContrato(),
                    s.gettxtRua(),
                    s.gettxtBairro(),
                    s.gettxtCidade(),
                    s.gettxtEstado(),};
                
                    dtmClientes.addRow(dados);
    });
    
        this.Clientes = clientesReturn;
        
        jClientes.setModel(dtmClientes);
        JOptionPane.showMessageDialog(null, "Formulário gerado!");
     
    }//GEN-LAST:event_btFilterActionPerformed

    private void btCreatePdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreatePdfActionPerformed

        String path="";
        JFileChooser j= new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x=j.showSaveDialog(this);

        path=j.getSelectedFile().getPath();
        System.out.println(path);
        
        Document doc = new Document ();

        try {
            String so = String.valueOf( System.getProperty("os.name") );
            if (so.equals("Linux")){
                PdfWriter.getInstance(doc, new FileOutputStream(path+"/relatório.pdf"));
            }else{
                PdfWriter.getInstance(doc, new FileOutputStream(path+"\\relatório.pdf"));
            }
            
            doc.open();
            
            
            Consumer<Clientes> consumer = s -> { 
                
                
                try {   
                    doc.add(new Paragraph("Nome: "+ s.gettxtNome() + " | Data de Nascimento: " + s.gettxtNascimento()));
                    doc.add(new Paragraph("E-mail: " + s.gettxtEmail()+ " | Telefone 1: " + s.gettxtTelefone1() + " | Telefone 2: " +  s.gettxtTelefone2()));
                    doc.add(new Paragraph("Observação: " + s.gettxtObservacao()));
                    doc.add(new Paragraph("Diária: " + s.gettxtDiaria() + " | Valor da Mensalidade: " + s.gettxtValorMensalidade()));
                    doc.add(new Paragraph("Data da cobrança: " + s.gettxtDataCobranca()+ " | Vendedor: " + s.gettxtVendedor()));
                    doc.add(new Paragraph("Data de venda contrato: " + s.gettxtDataVendaContrato()+ " | Número contrato: " + s.gettxtNumeroContrato()));
                    doc.add(new Paragraph("Endereço: " + s.gettxtRua() + " | Bairro: " + s.gettxtBairro() + " | Cidade: " + s.gettxtCidade() + " | Estado: " + s.gettxtEstado()));
                    doc.add(new Paragraph("Cidade: " + s.gettxtCidade() + " | Estado: " + s.gettxtEstado()));
                    doc.add(new Paragraph("_____________________________________________________________________________"));

                } catch (DocumentException ex) {
                    Logger.getLogger(TelaGerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            };
            Clientes.stream().forEach(consumer);
            
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(TelaGerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();

    }//GEN-LAST:event_btCreatePdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddFilters;
    private javax.swing.JButton btCreatePdf;
    private javax.swing.JButton btFilter;
    private javax.swing.JTable jClientes;
    private javax.swing.JPanel jFilters;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollFilters;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
