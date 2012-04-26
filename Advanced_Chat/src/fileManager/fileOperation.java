/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fileManager;

import java.awt.Image;
import java.util.Properties;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 * @author enrico  classe per gestire creare e cancellare le cartelle che servono al software
 */
public class fileOperation {


        public boolean createDirectory(String dir){  //crea una cartella nel percorso specificato in dir
            
                boolean created = new File(dir).mkdirs();
                return created;
                
        }

        public static boolean exist(String file){  //metodo per controllare l'esistenza di un file;ritorna vero se esiste;

            File check = new File(file);

            boolean value = check.exists();


            return value;

        }

        public String getOS(){       //metodo che mi dice se il sistema ospitante è Microsoft o altro;

            Properties x = System.getProperties();
            boolean value = x.contains("Windows");
            if(value){
                    return "Windows";
            }
            else{
                return "others";
            }

        }
       
      
     public static ImageIcon loadImage(File selectedFile) throws IOException{

    
        Image image = ImageIO.read(selectedFile);
        Image newimg = image.getScaledInstance(182, 200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);
    
        return icon;
    
}  
        
        


        public boolean deleteDirectory(File toDelete){  //metodo per cancellare cartelle;


               if(toDelete.isDirectory()){
                        String[] content = toDelete.list();
                        for(int index=0;index < content.length;index++){
                            deleteDirectory(new File(toDelete,content[index]));
                        }                        
        }
        return toDelete.delete();
    }

}




