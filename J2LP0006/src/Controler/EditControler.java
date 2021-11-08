/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.FindDialog;
import GUI.FontDialog;
import GUI.MTE;
import GUI.ReplaceDialog;
import java.awt.event.ActionEvent;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;

/**
 *
 * @author ACER
 */
public class EditControler {

    private MTE mte;
    private UndoManager um;

    public EditControler(MTE mte) {
        this.mte = mte;
        this.um = new UndoManager();

        controler();
    }

    private void controler() {
        selectAll();
        Cut();
        Copy();
        Patse();
        Undo();
        Redo();
        addEdit();
        fontEdit();
        findEdit();
        ReplaceEdit();
        Editable();
    }

    private void Editable() {
        mte.getMniCopy().setEnabled(false);
        mte.getMniCut().setEnabled(false);
        mte.getMniRedo().setEnabled(false);
        mte.getMniUndo().setEnabled(false);
        mte.getMniFind().setEnabled(false);

        mte.getTxtMain().addCaretListener((ce) -> {
            if (!mte.getTxtMain().getText().isEmpty()) {
                mte.getMniFind().setEnabled(true);
            }
            if (mte.getTxtMain().getSelectedText() != null) {
                mte.getMniCopy().setEnabled(true);
                mte.getMniCut().setEnabled(true);
            }

            if (um.canUndo()) {
                mte.getMniUndo().setEnabled(true);
            }
            if (um.canRedo()) {
                mte.getMniRedo().setEnabled(true);
            }

        });

    }

    private void selectAll() {
        mte.getMniSelectAll().addActionListener((ae) -> {
            mte.getTxtMain().selectAll();  // inherence of textcomponent 
        });

    }

    private void Cut() {
        mte.getMniCut().addActionListener((ae) -> {
            mte.getTxtMain().cut();
        });
    }

    private void Copy() {
        mte.getMniCopy().addActionListener((ae) -> {
            mte.getTxtMain().copy();
        });
    }

    private void Patse() {
        mte.getMniPaste().addActionListener((ae) -> {
            mte.getTxtMain().paste();
        });
    }

    private void Undo() {
        mte.getMniUndo().addActionListener((ae) -> {
            
            if(um.canUndo()){
                um.undo();
            }
        });
    }

    private void Redo() {
        mte.getMniRedo().addActionListener((ae) -> {
           if(um.canRedo()){
                um.redo();
            }
        });
    }

    private void addEdit() {
        mte.getTxtMain().getDocument().addUndoableEditListener(um); // undoManger manager list of UndoableEdit
    }

    private void fontEdit() {
        mte.getMniFont().addActionListener((ae) -> {
            FontDialog fontDialog = new FontDialog(mte, false);
            FontControler fc = new FontControler(mte, fontDialog);
            fontDialog.setResizable(false);
            fontDialog.setVisible(true);
        });
    }

    private void findEdit() {
        mte.getMniFind().addActionListener((ActionEvent ae) -> {
            FindDialog findDialog = new FindDialog(mte, false);
            findDialog.setResizable(false);
            findDialog.setVisible(true);
            FindControl fc = new FindControl(findDialog, mte);

        });
    }

    private void ReplaceEdit() {
        mte.getMniReplace().addActionListener((ae) -> {
            ReplaceDialog replaceDialog = new ReplaceDialog(mte, false);
            replaceDialog.setResizable(false);
            replaceDialog.setVisible(true);

            ReplaceControler rc = new ReplaceControler(mte, replaceDialog);
        });
    }

}
