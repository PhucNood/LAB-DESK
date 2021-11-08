/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.FontDialog;
import GUI.MTE;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author ACER
 */
public class FontControler {

    private MTE mte;
    private FontDialog fontDialog;
    private Font changeFont;
    private String sampleFont;
    private int sampleStyle;
    private int sampleSize;

    public FontControler(MTE mte, FontDialog fontDialog) {
        this.mte = mte;
        this.fontDialog = fontDialog;

        controler();

    }

    private void controler() {
        show();
        ActionOk();
        Cancel();
        changeFont();
    }

    private void show() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        String[] style = {"Plain", "Bold", "Italic", "Bold Italic"};
        Integer sizes[] = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 36, 40, 72};

        fontDialog.getLstFont().setModel(new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return fonts.length;   // overide to set lenght of list
            }

            @Override
            public String getElementAt(int i) { // overide to set element of list
                return fonts[i];
            }
        });

        fontDialog.getLstStyle().setModel(new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return style.length;   // overide to set lenght of list
            }

            @Override
            public String getElementAt(int i) { // overide to set element of list
                return style[i];
            }
        });

        fontDialog.getLstSize().setModel(new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return sizes.length;   // overide to set lenght of list
            }

            @Override
            public String getElementAt(int i) { // overide to set element of list
                return String.valueOf(sizes[i]);
            }
        });

        Font curentFont = mte.getTxtMain().getFont();
        String curentFamily = curentFont.getFamily();
        String curentStyle = style[curentFont.getStyle()];
        String curentSize = String.valueOf(curentFont.getSize());

        fontDialog.getLstFont().setSelectedValue(curentFamily, true);
        fontDialog.getLstStyle().setSelectedValue(curentStyle, true);
        fontDialog.getLstSize().setSelectedValue(curentSize, true);

        fontDialog.getTxtFont().setText(curentFamily);
        fontDialog.getTxtStyle().setText(curentStyle);
        fontDialog.getTxtSize().setText(curentSize);

        fontDialog.getLblSample().setFont(curentFont);

    }

    private void Cancel() {
        fontDialog.getBtnCancel().addActionListener((ae) -> {
            fontDialog.dispose();
        });
    }

    private void changeFont() {

        fontDialog.getLstFont().addListSelectionListener((ListSelectionEvent lse) -> {
            sampleFont = fontDialog.getLblSample().getFont().getFamily();
            sampleStyle = fontDialog.getLblSample().getFont().getStyle();
            sampleSize = fontDialog.getLblSample().getFont().getSize();

            fontDialog.getLblSample().setFont(new Font(fontDialog.getLstFont().getSelectedValue(), sampleStyle, sampleSize));
            changeFont = fontDialog.getLblSample().getFont();
            fontDialog.getTxtFont().setText(changeFont.getFamily());
            
        });
        fontDialog.getLstStyle().addListSelectionListener((ListSelectionEvent lse) -> {
            sampleFont = fontDialog.getLblSample().getFont().getFamily();
            sampleStyle = fontDialog.getLblSample().getFont().getStyle();
            sampleSize = fontDialog.getLblSample().getFont().getSize();
            
            fontDialog.getLblSample().setFont(new Font(sampleFont, fontDialog.getLstStyle().getSelectedIndex(), sampleSize));
            changeFont = fontDialog.getLblSample().getFont();
            fontDialog.getTxtStyle().setText(fontDialog.getLstStyle().getSelectedValue());
        });
        fontDialog.getLstSize().addListSelectionListener((ListSelectionEvent lse) -> {
            sampleFont = fontDialog.getLblSample().getFont().getFamily();
            sampleStyle = fontDialog.getLblSample().getFont().getStyle();
            sampleSize = fontDialog.getLblSample().getFont().getSize();
            
            int fontsize = Integer.parseInt(fontDialog.getLstSize().getSelectedValue());
            fontDialog.getTxtSize().setText(String.valueOf(fontsize));
            fontDialog.getLblSample().setFont(new Font(sampleFont, sampleStyle, fontsize));
            changeFont = fontDialog.getLblSample().getFont();
        });

        fontDialog.getTxtSize().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        String sampleFont = fontDialog.getLblSample().getFont().getFamily();
                        sampleStyle = fontDialog.getLblSample().getFont().getStyle();
                        sampleSize = fontDialog.getLblSample().getFont().getSize();
                        int size = Integer.parseInt(fontDialog.getTxtSize().getText());

                        fontDialog.getLblSample().setFont(new Font(sampleFont, sampleStyle, size));
                        changeFont = fontDialog.getLblSample().getFont();
                        mte.getTxtMain().setFont(changeFont);
                        fontDialog.dispose();

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(fontDialog, "Size must be number", "alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

        });
    }

    private void ActionOk() {
        fontDialog.getBtnOk().addActionListener((ae) -> {
            mte.getTxtMain().setFont(changeFont);
            fontDialog.dispose();

        });

    }

}
