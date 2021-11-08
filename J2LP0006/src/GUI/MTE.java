/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controler.EditControler;
import Controler.FileControler;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class MTE extends javax.swing.JFrame {

  
   
    public MTE() {
        initComponents();
        FileControler fc = new FileControler(this);
        EditControler ec = new EditControler(this);
        
    }

    public JMenu getMenuEdit() {
        return MenuEdit;
    }

    public JMenu getMenuFile() {
        return MenuFile;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JMenuItem getMniCopy() {
        return mniCopy;
    }

    public JMenuItem getMniCut() {
        return mniCut;
    }

    public JMenuItem getMniExit() {
        return mniExit;
    }

    public JMenuItem getMniFind() {
        return mniFind;
    }

    public JMenuItem getMniFont() {
        return mniFont;
    }

    public JMenuItem getMniNew() {
        return mniNew;
    }

    public JMenuItem getMniOpen() {
        return mniOpen;
    }

    public JMenuItem getMniPaste() {
        return mniPaste;
    }

    public JMenuItem getMniRedo() {
        return mniRedo;
    }

    public JMenuItem getMniReplace() {
        return mniReplace;
    }

    public JMenuItem getMniSave() {
        return mniSave;
    }

    public JMenuItem getMniSaveAs() {
        return mniSaveAs;
    }

    public JMenuItem getMniSelectAll() {
        return mniSelectAll;
    }

    public JMenuItem getMniUndo() {
        return mniUndo;
    }

    public JTextArea getTxtMain() {
        return txtMain;
    }

  

   

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtMain = new javax.swing.JTextArea();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        mniNew = new javax.swing.JMenuItem();
        mniOpen = new javax.swing.JMenuItem();
        mniSave = new javax.swing.JMenuItem();
        mniSaveAs = new javax.swing.JMenuItem();
        mniExit = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        mniSelectAll = new javax.swing.JMenuItem();
        mniCut = new javax.swing.JMenuItem();
        mniCopy = new javax.swing.JMenuItem();
        mniPaste = new javax.swing.JMenuItem();
        mniUndo = new javax.swing.JMenuItem();
        mniRedo = new javax.swing.JMenuItem();
        mniFind = new javax.swing.JMenuItem();
        mniReplace = new javax.swing.JMenuItem();
        mniFont = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Text Editor (MTE)");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtMain.setColumns(20);
        txtMain.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        txtMain.setRows(5);
        jScrollPane1.setViewportView(txtMain);

        MenuFile.setText("File");

        mniNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniNew.setText("New");
        MenuFile.add(mniNew);

        mniOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mniOpen.setText("Open");
        mniOpen.setToolTipText("");
        MenuFile.add(mniOpen);

        mniSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniSave.setText("Save");
        MenuFile.add(mniSave);

        mniSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniSaveAs.setText("Save as");
        MenuFile.add(mniSaveAs);

        mniExit.setText("Exit");
        MenuFile.add(mniExit);

        MenuBar.add(MenuFile);

        MenuEdit.setText("Edit");

        mniSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mniSelectAll.setText("Select all");
        MenuEdit.add(mniSelectAll);

        mniCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mniCut.setText("Cut");
        MenuEdit.add(mniCut);

        mniCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mniCopy.setText("Copy");
        MenuEdit.add(mniCopy);

        mniPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mniPaste.setText("Paste");
        MenuEdit.add(mniPaste);

        mniUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mniUndo.setText("Undo");
        MenuEdit.add(mniUndo);

        mniRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        mniRedo.setText("Redo");
        MenuEdit.add(mniRedo);

        mniFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mniFind.setText("Find");
        MenuEdit.add(mniFind);

        mniReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mniReplace.setText("Replace");
        MenuEdit.add(mniReplace);

        mniFont.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniFont.setText("Font");
        MenuEdit.add(mniFont);

        MenuBar.add(MenuEdit);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(MTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MTE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mniCopy;
    private javax.swing.JMenuItem mniCut;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniFind;
    private javax.swing.JMenuItem mniFont;
    private javax.swing.JMenuItem mniNew;
    private javax.swing.JMenuItem mniOpen;
    private javax.swing.JMenuItem mniPaste;
    private javax.swing.JMenuItem mniRedo;
    private javax.swing.JMenuItem mniReplace;
    private javax.swing.JMenuItem mniSave;
    private javax.swing.JMenuItem mniSaveAs;
    private javax.swing.JMenuItem mniSelectAll;
    private javax.swing.JMenuItem mniUndo;
    private javax.swing.JTextArea txtMain;
    // End of variables declaration//GEN-END:variables
}
