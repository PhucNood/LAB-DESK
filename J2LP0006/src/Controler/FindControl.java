/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.FindDialog;
import GUI.MTE;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;

/**
 *
 * @author ACER
 */
public class FindControl {

    private FindDialog find;
    private MTE mte;

    public FindControl(FindDialog find, MTE mte) {
        this.find = find;
        this.mte = mte;

        controler();
    }

    private void controler() {
        CheckEmtyFind();
        FindAction();
        Cancel();
    }

    private void CheckEmtyFind() {
        find.getBtnFind().setEnabled(false);
        find.getTxtFind().addCaretListener((CaretEvent ce) -> {
            if (find.getTxtFind().getText().trim().isEmpty()) {
                find.getBtnFind().setEnabled(false);
            } else {
                find.getBtnFind().setEnabled(true);

            }

        });
    }

    private void FindAction() {

        find.getBtnFind().addActionListener((ae) -> {
            String findText = find.getTxtFind().getText();
            int curentPosion;
            int indexTextFind = -1;

            if (find.getCkbMatch().isSelected() == false) {
                findText = find.getTxtFind().getText().toLowerCase();
                curentPosion = mte.getTxtMain().getSelectionEnd();
                indexTextFind = mte.getTxtMain().getText().indexOf(findText.toLowerCase(), curentPosion);
            } else {

                curentPosion = mte.getTxtMain().getSelectionEnd();

                indexTextFind = mte.getTxtMain().getText().indexOf(findText, curentPosion);
            }

            if (find.getRdbDown().isSelected()) {

                curentPosion = mte.getTxtMain().getSelectionEnd();

                indexTextFind = mte.getTxtMain().getText().indexOf(findText, curentPosion);
                if (find.getCkbWrap().isSelected()) {
                    if (indexTextFind == -1) {

                        indexTextFind = mte.getTxtMain().getText().indexOf(findText, 0);
                    }
                }

            } else {
                try {

                    curentPosion = mte.getTxtMain().getSelectionStart();
                    String textCurentCheck = mte.getTxtMain().getText(0, curentPosion);
                    indexTextFind = textCurentCheck.lastIndexOf(findText);

                    if (find.getCkbWrap().isSelected()) {
                        if (indexTextFind == -1) {
                            curentPosion = mte.getTxtMain().getText().length();
                            textCurentCheck = mte.getTxtMain().getText(0, curentPosion);
                            indexTextFind = textCurentCheck.lastIndexOf(findText);
                        }
                    }

                } catch (Exception e) {
                }
            }

            if (indexTextFind != -1) {
                mte.getTxtMain().select(indexTextFind, indexTextFind + findText.length());

            } else {
                JOptionPane.showMessageDialog(find, "Cant not find  \"" + findText + "\"");
            }

        });

    }

    private void Cancel() {
        find.getBtnCancel().addActionListener((ae) -> {
            find.dispose();
        });
    }

}
