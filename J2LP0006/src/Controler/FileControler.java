/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import GUI.MTE;
import java.awt.FileDialog;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;

/**
 *
 * @author ACER
 */
public class FileControler {

    private MTE mte;
    private String filename;
    private String fileAdress;
    private boolean saved;
    private String title;

    public FileControler(MTE mte) {
        this.mte = mte;

        controler();
    }

    private void controler() {
        checkSave();
        ActionNew();
        ActionOpen();
        ActionSaveAndSaveAs();
        ActionExit();
        askSavewhenClose();
    }

    private void Open() {
        FileDialog fd = new FileDialog(mte, "Open", FileDialog.LOAD);

        fd.setFile("*.txt");
        fd.setVisible(true);

        if (fd.getFile() != null) {
            filename = fd.getFile();
            fileAdress = fd.getDirectory();

        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAdress + filename));
            mte.getTxtMain().setText("");
            String line;
            while ((line = br.readLine()) != null) {
                mte.getTxtMain().append(line + "\n");
            }
            saved = true;
            mte.setTitle(filename);
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mte, "Cant open this files");
        }
    }

    private void saveAs() {
        FileDialog fd = new FileDialog(mte, "Open", FileDialog.SAVE);
        fd.setFile("*.txt");
        fd.setVisible(true);

        if (fd.getFile() != null) {
            filename = fd.getFile();

            if (!filename.endsWith(".txt")) {
                filename += ".txt";
                fileAdress = fd.getDirectory();
            }
        }
        
        try {
          File saveFile = new File(fileAdress + filename);
          if(saveFile.exists()){
              JOptionPane.showMessageDialog(null, "Cant overwrite this files");            
          };
            FileWriter fw = new FileWriter(saveFile);
            fw.write(mte.getTxtMain().getText());
            title = filename;
            mte.setTitle(title);

            saved = true;
            fw.close();

        } catch (IOException ex) {

        }

    }

    private void save() {
        if (filename == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAdress + filename);
                fw.write(mte.getTxtMain().getText());
                saved = true;
                fw.close();
            } catch (Exception e) {
            }

        }
    }

    private void checkSave() {
        saved = true;
        String curentText = mte.getTxtMain().getText();
        title = mte.getTitle();
        mte.getTxtMain().addCaretListener((CaretEvent ce) -> {
            String updateText = mte.getTxtMain().getText();
            if (curentText.equals(updateText) == false) {
                saved = false;
                mte.setTitle("*" + title);
            } else {
                mte.setTitle(title);
            }
        });
    }

    private void New() {
        mte.dispose();
        new MTE().setVisible(true);
    }

    private void ActionNew() {
        mte.getMniNew().addActionListener((ae) -> {
            if (saved == true) {
                New();
            } else {
                int choice = JOptionPane.showConfirmDialog(mte, "Do you want to save changes", "Alert", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    save();
                } else if (choice == JOptionPane.NO_OPTION) {
                    New();
                }
            }
        });
    }

    private void ActionOpen() {
        mte.getMniOpen().addActionListener((ae) -> {
            if (saved == true) {
                Open();
                title = mte.getTitle();
            } else {
                int choice = JOptionPane.showConfirmDialog(mte, "Do you want to save changes", "Alert", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    save();
                } else if (choice == JOptionPane.NO_OPTION) {
                    Open();
                    title = mte.getTitle();
                }
            }

        });
    }

    private void ActionSaveAndSaveAs() {
        mte.getMniSave().addActionListener((ae) -> { // save
            save();
        });

        mte.getMniSaveAs().addActionListener((ae) -> { // save
            saveAs();
        });
    }

    private void ActionExit() {
        mte.getMniExit().addActionListener((ae) -> {
            if (saved == true) {
                System.exit(0);
            } else {
                int choice = JOptionPane.showConfirmDialog(mte, "Do you want to save changes", "Alert", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    save();
                } else if (choice == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void askSavewhenClose() {
        mte.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (saved == true) {
                    System.exit(0);
                } else {
                    int choice = JOptionPane.showConfirmDialog(mte, "Do you want to save changes", "Alert", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        save();
                    } else if (choice == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    } else {
                        mte.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }

                }
            }

        });
    }

}
