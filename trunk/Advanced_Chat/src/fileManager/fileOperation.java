package fileManager;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class fileOperation {

        public boolean createFile(String path){  
            
                boolean created = new File(path).mkdirs();
                return created;               
        }

        public static boolean exist(String file){  //metodo per controllare l'esistenza di un file;ritorna vero se esiste;

            File check = new File(file);
            boolean value = check.exists();
            return value;
        }
               
        public void writeFile(File file) throws FileNotFoundException, IOException{
            
            FileInputStream fis;
            FileOutputStream fos;
            byte[] buffer;
            int i = 0;    
            
            fis = new FileInputStream(file);
            fos = new FileOutputStream(new File(/*"./"+*/file.getName()));           
            buffer = new byte[1024];                                                                                         
            while((i=fis.read(buffer))!=-1) {// riga per riga leggo il file originale per 
                fos.write(buffer, 0, i);    // scriverlo nello stram del file destinazione
            }
            fos.flush();
            fis.close();
            fos.close();           
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
           
        public ImageIcon loadImage(File selectedFile) throws IOException{
 
            Image image = ImageIO.read(selectedFile);
            Image newimg = image.getScaledInstance(182, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);   
            return icon;   
        }  

}




