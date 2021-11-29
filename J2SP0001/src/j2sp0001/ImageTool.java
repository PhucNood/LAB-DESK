package resizeimage;

import java.awt.*;
import javax.swing.*;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class ImageTool {
    
    
      public javax.swing.ImageIcon getImageIcon(String path){
          return new  javax.swing.ImageIcon(path);
      }
    
     
      public void setImagesforButton(JButton jb,javax.swing.ImageIcon ic) {
          
          Image image = ic.getImage().getScaledInstance(jb.getWidth()-20 , jb.getHeight()-20, Image.SCALE_SMOOTH); // creat a image scale size
          jb.setIcon(new javax.swing.ImageIcon(image)); //add it to jbuton
        
      }
      
      public void setImagesforLable(JLabel jl, javax.swing.ImageIcon ic) {
          
         Image image = ic.getImage().getScaledInstance(jl.getWidth(), jl.getHeight(),  Image.SCALE_SMOOTH);    /*same Image button*/
        jl.setIcon(new javax.swing.ImageIcon(image));
      }
      
      
     
      
    
}
