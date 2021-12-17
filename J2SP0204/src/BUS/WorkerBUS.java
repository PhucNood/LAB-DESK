/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.WorkerDAO;
import GUI.Adddlg;
import GUI.MainFrm;
import GUI.Updatedlg;
import GUI.Viewdlg;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Worker;

/**
 *
 * @author ACER
 */
public class WorkerBUS {

    private final MainFrm mainFrm;
    private final WorkerDAO db;
    private final Adddlg adddlg;
    private final Viewdlg viewdlg;
    private final Updatedlg updatedlg;

    public WorkerBUS(MainFrm mainFrm) {
        this.mainFrm = mainFrm;
        adddlg = new Adddlg(mainFrm, true);
        viewdlg = new Viewdlg(mainFrm, true);
        updatedlg = new Updatedlg(mainFrm, true);
        db = new WorkerDAO();

        //call function
        controller();
        loadTable();

    }

    private void controller() {
        mainFrm.setVisible(true);
        AddAction();
        ViewAction();
        UpdateAction();
    }

    private void loadTable() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnindex) {
                return (columnindex == 2) ? Icon.class : Object.class; //  if columnindex == 2 get class is icon class
            }

        };

        mainFrm.gettblMain().setModel(dtm);
        mainFrm.gettblMain().getTableHeader().setReorderingAllowed(false);
        mainFrm.gettblMain().getTableHeader().setResizingAllowed(false);
        mainFrm.gettblMain().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        dtm.addColumn("Name");
        dtm.addColumn("Gender");
        dtm.addColumn("Image");

        ArrayList<Worker> workers = db.getWorkers();

        mainFrm.gettblMain().setRowHeight(60);
        mainFrm.gettblMain().getColumn("Image").setPreferredWidth(50);

        for (Worker worker : workers) {

            Image im = new ImageIcon("src/Image/" + worker.getImage()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(im);

            String gender = worker.isGender() ? "Male" : "Female";
            dtm.addRow(new Object[]{worker.getName(), gender, ic});
        }

    }

    private void AddAction() {
        mainFrm.getBtnAdd().addActionListener((ActionEvent ae) -> {  // add in mainfrm
           
            adddlg.setVisible(true);
            //reset form
            adddlg.getTxtName().setText("");
            adddlg.getLblImage().setText("");
            adddlg.getLblImage().setIcon(null);
            adddlg.getCbxRole().setSelectedIndex(0);
            adddlg.getRbdMale().setSelected(true);
           
        });

        
        adddlg.getLblImage().addMouseListener(new MouseAdapter() { // choose path of image
            @Override
            public void mousePressed(MouseEvent me) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Only picture", "png", "jpg");
                fc.setFileFilter(filter);

                int open = fc.showOpenDialog(adddlg);
                if (open == JFileChooser.APPROVE_OPTION) {
                    File imageChoice = fc.getSelectedFile();

                    int id;
                    if (db.getWorkers().isEmpty()) {
                        id = 1;
                    } else {
                        int last = mainFrm.gettblMain().getRowCount() - 1;

                        Worker worker = db.getWorkers().get(last);
                        id = worker.getId() + 1;
                    }

                    if (imageChoice.getName().toLowerCase().endsWith(".png") || imageChoice.getName().toLowerCase().endsWith(".jpg")) {
                        String tag  = imageChoice.getName().toLowerCase().endsWith(".png") ? ".png":".jpg";
                        File imageCopy = new File("src/Image/" + id + tag);
                        try {
                            Files.copy(imageChoice.toPath(), imageCopy.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
                            adddlg.getLblImage().setText(imageCopy.getName());

                            JLabel lblImage = adddlg.getLblImage();

                            Image image = new ImageIcon("src/Image/" + imageCopy.getName()).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);

                            lblImage.setIcon(new ImageIcon(image));

                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(adddlg, "Cannot copy your selected image try again");
                            adddlg.getLblImage().setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(fc, "Just only choose image file");
                    }

                }
            }

        });
        
        adddlg.getBtnAdd().addActionListener((ActionEvent ae) -> {
            Worker worker = new Worker();

            String name = adddlg.getTxtName().getText().trim();
            boolean gender = adddlg.getRbdMale().isSelected();
            String role = adddlg.getCbxRole().getSelectedItem().toString();
            String image = adddlg.getLblImage().getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(adddlg, "Name field emty");
            } else if (!name.matches("[a-zA-Z ]{2,}")) {
                JOptionPane.showMessageDialog(adddlg, "Name is alphabets and minimum 2 character");
            } else if (image.isEmpty()) {
                JOptionPane.showMessageDialog(adddlg, "Image field emty");
            } else {
                worker.setName(name);
                worker.setGender(gender);
                worker.setRole(role);
                worker.setImage(image);

                db.addWorker(worker);
                adddlg.dispose();
                loadTable();
              
            }

        });


    }

    private void ViewAction() {

        mainFrm.getBtnView().addActionListener((ActionEvent ae) -> {
            try {

                int index = mainFrm.gettblMain().getSelectedRow();
                Worker worker = db.getWorkers().get(index);  // take the worker who was choice         
                viewdlg.getTxtID().setText(String.valueOf(worker.getId()));
                viewdlg.getTxtName().setText(worker.getName());
                String gender = worker.isGender() ? "Male" : "Female";
                viewdlg.getTxtGender().setText(gender);
                viewdlg.getTxtRole().setText(worker.getRole());

                JLabel lblImage = viewdlg.getLblImage();
                Image image = new ImageIcon("src/Image/" + worker.getImage()).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);

                lblImage.setIcon(new ImageIcon(image));

                viewdlg.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrm, "You still haven't choice worker who you want to view");
            }

        });

    }

    private void UpdateAction() {
        mainFrm.getBtnUpdate().addActionListener((ActionEvent ae) -> {
            try {
                int index = mainFrm.gettblMain().getSelectedRow();
                Worker worker = db.getWorkers().get(index);
                updatedlg.getTxtName().setText(worker.getName());
                if (worker.isGender()) {
                    updatedlg.getRbdMale().setSelected(true);
                } else {
                    updatedlg.getRbdFemale().setSelected(true);
                }

                if (worker.getRole().equalsIgnoreCase("Admin")) {
                    updatedlg.getCbxRole().setSelectedIndex(0);
                } else {
                    updatedlg.getCbxRole().setSelectedIndex(1);
                }
                JLabel lblImage = updatedlg.getLblImage();

                Image image = new ImageIcon("src/Image/" + worker.getImage()).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),
                        Image.SCALE_SMOOTH);

                lblImage.setIcon(new ImageIcon(image));

                updatedlg.getLblImage().setText(worker.getImage());

                updatedlg.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrm, "You still haven't choice worker who you want to view");
            }
        });

        // update 
        updatedlg.getBtnUpdate().addActionListener((ae) -> {
            int index = mainFrm.gettblMain().getSelectedRow();
            Worker worker = db.getWorkers().get(index);     //still the worker
            String name = updatedlg.getTxtName().getText().trim();
            String image = updatedlg.getLblImage().getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(adddlg, "Name field emty");
            } else if (!name.matches("[a-zA-Z ]{2,}")) {
                JOptionPane.showMessageDialog(adddlg, "Name is alphabets and minimum 2 character");
            } else if (image.isEmpty()) {
                JOptionPane.showMessageDialog(adddlg, "Image field emty");
            } else {

                worker.setName(name);
                worker.setGender(updatedlg.getRbdMale().isSelected()); // becuase add butongruop before
                worker.setRole(updatedlg.getCbxRole().getSelectedItem().toString());
                worker.setImage(updatedlg.getLblImage().getText());
                db.updateWorker(worker); // update in database 
                updatedlg.dispose(); // dispose the dialog
                // reload table
                loadTable();
            }
        });

        //update anh
        updatedlg.getLblImage().addMouseListener(new MouseAdapter() { // choose path of image
            @Override
            public void mousePressed(MouseEvent me) {
                int index = mainFrm.gettblMain().getSelectedRow();
                Worker worker = db.getWorkers().get(index);  // take the worker who was choice  
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Only picture", "png", "jpg");
                fc.setFileFilter(filter);

                int open = fc.showOpenDialog(updatedlg);
                if (open == JFileChooser.APPROVE_OPTION) {
                    File imageChoice = fc.getSelectedFile();

                    // set name of file copy to image is id +.jpg or png;
                    if (imageChoice.getName().endsWith(".png") || imageChoice.getName().endsWith(".jpg")) {
                         String tag  = imageChoice.getName().toLowerCase().endsWith(".png") ? ".png":".jpg";
                        File imageCopy = new File("src/Image/" + worker.getId() + tag);
                        try {
                            Files.copy(imageChoice.toPath(), imageCopy.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
                            updatedlg.getLblImage().setText(imageCopy.getName());
                            //xu ly hien thi anh
                            //config kich thuoc anh
                            JLabel lblImage = updatedlg.getLblImage();

                            Image image = new ImageIcon("src/Image/" + imageCopy.getName()).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
                            //set icon image
                            lblImage.setIcon(new ImageIcon(image));

                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(updatedlg, "Cannot copy your selected image try again");
                            adddlg.getLblImage().setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(fc, "Just only choose image file");

                    }

                }
            }
        });

    }

}
