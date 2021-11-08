/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.MTE;
import GUI.ReplaceDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.text.DefaultHighlighter;

/**
 *
 * @author ACER
 */
public class ReplaceControler {

    private MTE mte;
    private ReplaceDialog replace;

    public ReplaceControler(MTE mte, ReplaceDialog replace) {
        this.mte = mte;
        this.replace = replace;

        controler();

    }

    private void controler() {
        Cancel();
        Replaceable();
        Replace();
        Replaceall();
        FindNextAction();
    }

    private void Cancel() {
        replace.getBtnCancel().addActionListener((ae) -> {
            replace.dispose();
        });
    }

    private void Replaceable() {

        replace.getBtnReplace().setEnabled(false);
        replace.getBtnReplaceall().setEnabled(false);
        replace.getTxtFind().addCaretListener((CaretEvent ce) -> {
            if (replace.getTxtFind().getText().trim().isEmpty()) {

                replace.getBtnReplace().setEnabled(false);
                replace.getBtnReplaceall().setEnabled(false);
            } else {

                replace.getBtnReplace().setEnabled(true);
                replace.getBtnReplaceall().setEnabled(true);
            }

        });
    }

    private void Find() {

        String findText;
        int curentPosion;
        int indexTextFind = -1;

        if (replace.getCkbMatch().isSelected() == false) {
            findText = replace.getTxtFind().getText().toLowerCase();
            curentPosion = mte.getTxtMain().getSelectionEnd();
            String contentText = mte.getTxtMain().getText().toLowerCase();
            indexTextFind = contentText.indexOf(findText, curentPosion);
            if (replace.getCkbWrap().isSelected()) {
                if (indexTextFind == -1) {
                    mte.getTxtMain().setCaretPosition(0);

                    indexTextFind = mte.getTxtMain().getText().indexOf(findText, 0);
                }

            }
        } else {
            findText = replace.getTxtFind().getText();

            curentPosion = mte.getTxtMain().getSelectionEnd();

            indexTextFind = mte.getTxtMain().getText().indexOf(findText, curentPosion);
            if (replace.getCkbWrap().isSelected()) {
                if (indexTextFind == -1) {
                    mte.getTxtMain().setCaretPosition(0);

                    indexTextFind = mte.getTxtMain().getText().indexOf(findText, 0);
                }

            }
        }

        if (indexTextFind != -1) {
            mte.getTxtMain().select(indexTextFind, indexTextFind + findText.length());

        } else {
            JOptionPane.showMessageDialog(replace, "Cant not find  \"" + replace.getTxtFind().getText() + "\"");

        }

    }

    private void FindNextAction() {

        replace.getBtnFindNext().addActionListener((ae) -> {

            Find();

        });
    }

    private void Replace() {

        replace.getBtnReplace().addActionListener((ae) -> {
            boolean selected = false;
            String selectext = mte.getTxtMain().getSelectedText();

            if (replace.getCkbMatch().isSelected()) {

            }

            if (selectext == null) {
                selectext = "";
            }

            if (replace.getCkbMatch().isSelected()) {
                if (selectext.equals(replace.getTxtFind().getText())) {
                    selected = true;
                } else {
                    selected = false;
                }
            } else { // if not match ignorecase of findtext
                if (selectext.equalsIgnoreCase(replace.getTxtFind().getText())) {
                    selected = true;
                } else {
                    selected = false;
                }
            }

            if (selected == false) {
                Find();
            }

            if (selected == true) {
                try {
                    //mte.getTxtMain().replaceRange(replace.getTxtReplace().getText(), mte.getTxtMain().getSelectionStart(), mte.getTxtMain().getSelectionEnd());
                    mte.getTxtMain().replaceSelection(replace.getTxtReplace().getText());;
                    Find();
                } catch (Exception e) {
                }
            }

        });

    }

    private void Replaceall() {
        replace.getBtnReplaceall().addActionListener((ae) -> {
            if(replace.getCkbMatch().isSelected()){
                String replaceAllText = mte.getTxtMain().getText().replace(replace.getTxtFind().getText(), replace.getTxtReplace().getText());
            mte.getTxtMain().setText(replaceAllText);
            }else{
                String ContentToreplace = mte.getTxtMain().getText();  // change all to lowercase to findtext
               String replaceAllText  = ContentToreplace.replaceAll("(?i)"+replace.getTxtFind().getText(), replace.getTxtReplace().getText()); // using regex (?i) mean find match egnor case
               mte.getTxtMain().setText(replaceAllText);
               
            }
            
            
            
        });
        
    }

}
