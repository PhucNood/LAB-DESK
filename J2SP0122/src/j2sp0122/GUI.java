/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2sp0122;

import java.awt.Color;

/**
 *
 * @author ACER
 */
public class GUI extends javax.swing.JFrame {

    private int R = 0;
    private int G = 0;
    private int B = 0;
    

    public GUI() {
        initComponents();
        txtDisplay.setBackground(new Color(0, 0, 0));
        txtDisplay.setOpaque(true);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSliderR = new javax.swing.JSlider();
        jSliderB = new javax.swing.JSlider();
        lblRed = new javax.swing.JLabel();
        lblBlue = new javax.swing.JLabel();
        lblGreen = new javax.swing.JLabel();
        txtDisplay = new javax.swing.JTextField();
        jSliderG = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSliderR.setMaximum(255);
        jSliderR.setPaintTicks(true);
        jSliderR.setSnapToTicks(true);
        jSliderR.setValue(0);
        jSliderR.setAutoscrolls(true);
        jSliderR.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSliderR.setValueIsAdjusting(true);
        jSliderR.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderRStateChanged(evt);
            }
        });

        jSliderB.setMaximum(255);
        jSliderB.setPaintTicks(true);
        jSliderB.setValue(0);
        jSliderB.setAutoscrolls(true);
        jSliderB.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSliderB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderBStateChanged(evt);
            }
        });

        lblRed.setForeground(new java.awt.Color(255, 0, 0));
        lblRed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRed.setText("R = 0");
        lblRed.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBlue.setForeground(new java.awt.Color(0, 0, 255));
        lblBlue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBlue.setText("B = 0");
        lblBlue.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGreen.setForeground(new java.awt.Color(0, 255, 0));
        lblGreen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGreen.setText("G = 0");
        lblGreen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDisplay.setEditable(false);
        txtDisplay.setOpaque(false);

        jSliderG.setMaximum(255);
        jSliderG.setPaintTicks(true);
        jSliderG.setSnapToTicks(true);
        jSliderG.setValue(0);
        jSliderG.setAutoscrolls(true);
        jSliderG.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSliderG.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderGStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSliderR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSliderB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSliderG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRed, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDisplay)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSliderR, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSliderG, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSliderB, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSliderRStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderRStateChanged
      
        R = jSliderR.getValue();
        lblRed.setText("R = " + R);  
        Color color = new Color(R, G, B);
        txtDisplay.setBackground(color);
    }//GEN-LAST:event_jSliderRStateChanged

    private void jSliderBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderBStateChanged
       
        B = jSliderB.getValue();
        lblBlue.setText("B = " + B);   
         Color color = new Color(R, G, B);
        txtDisplay.setBackground(color);

    }//GEN-LAST:event_jSliderBStateChanged

    private void jSliderGStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderGStateChanged
       
        G = jSliderG.getValue();
        lblGreen.setText("G = " + G);      
         Color color = new Color(R, G, B);
        txtDisplay.setBackground(color);

    }//GEN-LAST:event_jSliderGStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider jSliderB;
    private javax.swing.JSlider jSliderG;
    private javax.swing.JSlider jSliderR;
    private javax.swing.JLabel lblBlue;
    private javax.swing.JLabel lblGreen;
    private javax.swing.JLabel lblRed;
    private javax.swing.JTextField txtDisplay;
    // End of variables declaration//GEN-END:variables
}
