/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import t7e3.T7e3;

/**
 *
 * @author v6222
 */
public class vOperaciones extends javax.swing.JFrame {

    /**
     * Creates new form vCompra
     * @param x
     */
    public vOperaciones(int x) {
        initComponents();
        setLocationRelativeTo(null);
        compraventa(x);
    }

    private void compraventa(int x){
        if(x ==1){
            this.setTitle("Ventana Compra");
        }
        else{
            this.setTitle("Ventana Venta");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lProducto = new javax.swing.JLabel();
        lUnidad = new javax.swing.JLabel();
        lImporte = new javax.swing.JLabel();
        tfUnidad = new javax.swing.JTextField();
        tfProducto = new javax.swing.JTextField();
        tfImporte = new javax.swing.JTextField();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        lAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Compra");

        lProducto.setText("Producto");

        lUnidad.setText("Unidades");

        lImporte.setText("Importe");

        tfUnidad.setText("0");

        tfProducto.setToolTipText("");
        tfProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfProductoFocusLost(evt);
            }
        });

        tfImporte.setText("0");

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        lAviso.setForeground(new java.awt.Color(255, 0, 51));
        lAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lProducto)
                            .addComponent(lUnidad)
                            .addComponent(lImporte))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(tfUnidad)
                            .addComponent(tfImporte)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(bCancelar))
                    .addComponent(lAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProducto)
                    .addComponent(tfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUnidad)
                    .addComponent(tfUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lImporte)
                    .addComponent(tfImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tfUnidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) ||
                    (c == KeyEvent.VK_BACK_SPACE) ||
                    (c == KeyEvent.VK_DELETE) ||
                    (c == KeyEvent.VK_PERIOD))) {
                getToolkit().beep();
                e.consume();
            }
        }
    });
    tfImporte.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE) ||
                (c == KeyEvent.VK_PERIOD))) {
            getToolkit().beep();
            e.consume();
        }
    }
    });

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfProductoFocusLost
        // TODO add your handling code here:
        double p = T7e3.consultarP(tfProducto.getText());
        if(p != 0){
            if(this.getTitle().equals("Ventana Venta")){
                //Al no saber el márgen de beneficio, se ha multiplicado por 2 el precio de compra para su venta.
                tfImporte.setText(String.valueOf(p*2));
            }
            else{
                tfImporte.setText(String.valueOf(p));
            }
            
            tfUnidad.setText("1");
            lAviso.setText("");
        }
        else{
            tfUnidad.setText("1");
            lAviso.setText("El Producto no existe, pero le permito continuar.");
        }
        
    }//GEN-LAST:event_tfProductoFocusLost
    

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        // TODO add your handling code here:
        if(tfProducto.getText().equals("")){
            JOptionPane.showMessageDialog(this, "No has introducido ningún producto.\nNo se ha grabado nada.");
        }
        else{
            JOptionPane.showMessageDialog(null, calcular());
            if(this.getTitle().equals("Ventana Compra")){
                T7e3.comprar(Double.parseDouble(tfUnidad.getText()),Double.parseDouble(tfImporte.getText()));
            }
            else{
                T7e3.vender(Double.parseDouble(tfUnidad.getText()));
            }
        }
        tfProducto.setText(null);
        tfUnidad.setText("0");
        tfImporte.setText("0");
        tfProducto.grabFocus();
        lAviso.setText("");
            
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        T7e3.mostrarP(this);
    }//GEN-LAST:event_bCancelarActionPerformed

    public String calcular(){
        String dato ="Total a pagar: ";
        try{
            DecimalFormat df = new DecimalFormat("#.00");
            double pagar = Double.parseDouble(tfUnidad.getText()) * Double.parseDouble(tfImporte.getText());
            dato += df.format((pagar)).replace(",", ".");
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Los valores numéricos son incorrectos.");
        }   
        catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getClass());            
        }
        return dato;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel lAviso;
    private javax.swing.JLabel lImporte;
    private javax.swing.JLabel lProducto;
    private javax.swing.JLabel lUnidad;
    private javax.swing.JTextField tfImporte;
    private javax.swing.JTextField tfProducto;
    private javax.swing.JTextField tfUnidad;
    // End of variables declaration//GEN-END:variables
}
