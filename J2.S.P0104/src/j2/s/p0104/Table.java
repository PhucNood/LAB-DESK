/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2.s.p0104;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.Enumeration;
import javafx.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Table extends javax.swing.JFrame {

    private int index;
    private int lastindex;

    public Table() {
        initComponents();
        AddContent();
        EnventControl();

    }

    private void AddContent() {
        DefaultTableModel dt = new DefaultTableModel() {  // create model of table
            @Override
            public boolean isCellEditable(int i, int i1) { // overide to cannot edit cell
                return false;
            }
        };

        // add model to table
        tblContent.setModel(dt);

        //add columns 
        dt.addColumn("StockID");
        dt.addColumn("StockName");
        dt.addColumn("Address");
        dt.addColumn("DateAvailable");
        dt.addColumn("Note");

        tblContent.getColumnModel().getColumn(2).setPreferredWidth(120); // because that collumn content so long :)
        tblContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// cannot select multi selection one time
        tblContent.getTableHeader().setReorderingAllowed(false);
        tblContent.getTableHeader().setResizingAllowed(false);

        // add rows
        dt.addRow(new Object[]{1, "Stock one", "No1-Washington street", "11/05/2010", ""});
        dt.addRow(new Object[]{2, "Stock two", "372 Cave Town-001 Banks", "09/07/2011", ""});
        dt.addRow(new Object[]{3, "Stock three", "Nary angle-890 Number one", "13/05/2010", "Store dangerous"});
        dt.addRow(new Object[]{4, "Stock four", "Twin tower- 01 Main street", "04/07/2015", ""});
        dt.addRow(new Object[]{5, "Stock five", "Victory anniversary distric", "8/12/2014", ""});
        // defaul chose first index
        try {
            tblContent.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(this, "table still not have any row");
        }

    }

    private void EnventControl() {

        // btnFirst action perform event
        btnFirst.addActionListener((java.awt.event.ActionEvent ae) -> { // use lamda express for  functional interface Actionlistner  
            try {
                tblContent.setRowSelectionInterval(0, 0);
               
            } catch (Exception e) {

            }

        });

        // btnFirst action perform event
        btnPrevios.addActionListener((java.awt.event.ActionEvent ae) -> {
            try {
                index = tblContent.getSelectedRow() - 1;
                // catch out bounce 
                if (index == -1) {
                    index = 0; // if index under 0 set index =0
                }
                tblContent.setRowSelectionInterval(index, index);
            } catch (Exception e) {
                
            }

        });

        // btnFirst action perform event
        btnNext.addActionListener((java.awt.event.ActionEvent ae) -> {
            try {
                index = tblContent.getSelectedRow() + 1;
                lastindex = tblContent.getRowCount() - 1;

                if (index > lastindex) {
                    index = lastindex; // if over last index set index = lastindex
                }
                tblContent.setRowSelectionInterval(index, index);
            } catch (Exception e) {

            }

        });

        btnLast.addActionListener((java.awt.event.ActionEvent ae) -> {
            try {
                lastindex = tblContent.getRowCount() - 1;
                tblContent.setRowSelectionInterval(lastindex, lastindex);
            } catch (Exception e) {
                
            }

        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblContent = new javax.swing.JTable();
        btnFirst = new javax.swing.JButton();
        btnPrevios = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblContent);

        btnFirst.setText("Move First");

        btnPrevios.setText("Move Previous");

        btnNext.setText("Move Next");

        btnLast.setText("Move Last");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnPrevios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrevios, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContent;
    // End of variables declaration//GEN-END:variables
}
