/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.View;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Controller {
    
    private View view;
    
    public Controller(View view) {
        this.view = view;
        
        dataNDisplay();
        actionBatch();
    }
    
    private void dataNDisplay() {
        DefaultTableModel dt = new DefaultTableModel() {  // create model of table
          
        };
        
        view.getTable().setModel(dt);
        view.getTable().getTableHeader().setReorderingAllowed(false);
        dt.addColumn("StockID");
        dt.addColumn("StockName");
        dt.addColumn("Address");
        dt.addColumn("DateAvailable");
        dt.addColumn("Note");
        
        dt.addRow(new Object[]{1, "Stock one", "No1-Washington street", "11/05/2010", ""});
        dt.addRow(new Object[]{2, "Stock two", "372 Cave Town-001 Banks", "09/07/2011", ""});
        dt.addRow(new Object[]{3, "Stock three", "Nary angle-890 Number one", "13/05/2010", "Store Dangerous"});
        dt.addRow(new Object[]{4, "Stock four", "Twin tower- 01 Main street", "04/07/2015", ""});
        dt.addRow(new Object[]{5, "Stock five", "Victory anniversary distric", "8/12/2014", ""});
        
    }
    
    private void actionBatch() {
        view.getBtnInsert().addActionListener((ae) -> { 
            
            try {
                batchUpdate();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "Loi ");
            }
            
        });
    }
    
    private void batchUpdate() throws SQLException{
        Connection conn = new dal.Dataconnection().getConnection();
        
        try {
            String sql = " \n"
                    + "INSERT INTO [FU_DB].[dbo].[Stocks]( [StockID]\n"
                    + "      ,[StockName]\n"
                    + "      ,[Address]\n"
                    + "      ,[DateAvailable]\n"
                    + "      ,[Note])\n"
                    + "VALUES (?,?,?,?,?)\n"
                    ;
            
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            JTable table = view.getTable(); 
            
            for (int i = 0; i < table.getRowCount(); i++) { // get seqence row value of table
                ps.setString(1, table.getValueAt(i, 0).toString());
                ps.setString(2, table.getValueAt(i, 1).toString());
                ps.setString(3, table.getValueAt(i, 2).toString());
                ps.setString(4, table.getValueAt(i, 3).toString());
                ps.setString(5, table.getValueAt(i, 4).toString());
                ps.addBatch(); // add to batch
                ps.executeBatch(); // executeBatch
                
            }
            
            conn.commit();
            JOptionPane.showMessageDialog(view, "Success insert ");
            
            
        } catch (SQLException ex) {
            conn.rollback();        // rollback data if  catch exception 
            JOptionPane.showMessageDialog(view, ex.getMessage());        
        } finally {
            conn.close();
        }
        
    }
    
}
