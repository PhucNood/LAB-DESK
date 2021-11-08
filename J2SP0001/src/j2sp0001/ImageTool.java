package j2sp0001;

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

    private ImageIcon ic;
    public ImageTool(ImageIcon ic) {
        this.ic=ic;
    }
    
   private javax.swing.ImageIcon getImageIcon(String path){
       
       return new javax.swing.ImageIcon(getClass().getResource(path));
   }
      
   private void scaleImage(){
       
   }
      
    
}
