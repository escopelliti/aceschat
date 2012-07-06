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

/*Classe di supporto alla creazione,gestione,scrittura di file semplici*/
public class fileOperation {
        //creazione di un file e/o cartella
        public boolean createFile(String path){  
            
                boolean created = new File(path).mkdirs();
                return created;               
        }
        //controlla l'esistenza di un file al path specificato
        public static boolean exist(String file){  

            File check = new File(file);
            boolean value = check.exists();
            return value;
        }
        //Metodo che passato un file lo scrive su uno stream fisico di dati.     
        public void writeFile(File file) throws FileNotFoundException, IOException{
            
            FileInputStream fis;
            FileOutputStream fos;
            byte[] buffer;
            int i = 0;    
            
            fis = new FileInputStream(file);
            fos = new FileOutputStream(new File(file.getName()));           
            buffer = new byte[1024];                                                                                         
            while((i=fis.read(buffer))!=-1) {
                fos.write(buffer, 0, i);   
            }
            fos.flush();
            fis.close();
            fos.close();           
        }
        
        /*Controllo su quale sistema operativo "gira" l'applicazione*/
        public String getOS(){
            
            Properties x = System.getProperties();
            boolean value = x.contains("Windows");
            if(value){
                return "Windows";
            }
            else{
                return "others";
            }
        }
        
        /*Dato un file carica un oggetto della classe ImageIcon che restituisce*/
        public ImageIcon loadImage(File selectedFile) throws IOException{
 
            Image image = ImageIO.read(selectedFile);
            Image newimg = image.getScaledInstance(182, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);   
            return icon;   
        }  
}




