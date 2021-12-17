/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Worker;

/**
 *
 * @author ACER
 */
public class WorkerDAO {
    
  private Connection conn = new DataProvider().getConnection();
    
    public ArrayList<Worker> getWorkers() {
        ArrayList<Worker> workers = new ArrayList<Worker>();
        String sql = "select * from Worker";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Worker worker = new Worker();
                
                worker.setId(rs.getInt("id"));
                worker.setName(rs.getString("name"));
                worker.setGender(rs.getBoolean("gender"));
                worker.setRole(rs.getString("role"));
                worker.setImage(rs.getString("image"));
                
                workers.add(worker);
                
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return workers;
    }
    
    public void addWorker(Worker worker) {
        String sql = "insert into Worker(name,gender,role,image) values (?,?,?,?)";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, worker.getName());
            ps.setBoolean(2, worker.isGender());
            ps.setString(3, worker.getRole());
            ps.setString(4, worker.getImage());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void updateWorker(Worker worker) {
        String sql = "update Worker set name=?,gender=?,role=?,image=? where id =?";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, worker.getName());
            ps.setBoolean(2, worker.isGender());
            ps.setString(3, worker.getRole());
            ps.setString(4, worker.getImage());
            ps.setInt(5, worker.getId());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
