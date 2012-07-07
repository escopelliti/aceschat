package fileManager;


import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class fileOperation {

    //Permette la creazione di files e directory;
    public boolean createFiles(String dir){  //crea una cartella nel percorso specificato in dir
            
        boolean created = new File(dir).mkdirs();
        return created;        
    }

    public static boolean exist(String file){

        File check = new File(file);
        boolean value = check.exists();
        
        return value;
    }
    
    /*Scrittura di un file fisico*/
    public void writeFile(int idUser,InputStream reader) throws IOException{
        
        int flag;
        OutputStream writer;
        File im;
        byte[] buf;
        
        im = new File("Utenti/"+idUser+"/Immagini/"+idUser);
        writer = new FileOutputStream(im);
        buf = new byte[1024];
        
        while ((flag = reader.read(buf)) > 0){
            writer.write(buf, 0, flag);
        }
        
        reader.close();
        writer.close();               
    }   
        
    /*Ritorna un oggetto ImageIcon dato un file; l'oggetto ritornato può essere utilizzato
     * per utilizzare new JLabel.setIcon(imagicon);
     */
    public ImageIcon loadImage(File selectedFile) throws IOException{

        Image image = ImageIO.read(selectedFile);
        Image newimg = image.getScaledInstance(182, 200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);    
        return icon;
     }
     
    /*Permette al server di eliminare eventuali File e Cartelle*/    
    public boolean deleteFiles(File toDelete){  //metodo per cancellare cartelle;
    
        if(toDelete.isDirectory()){
            String[] content = toDelete.list();
            for(int index=0;index < content.length;index++)
                deleteFiles(new File(toDelete,content[index]));
        }
        return toDelete.delete();
    }

    /*Attualmente non usato ma possibile uso in futuri aggiornamenti dell'applicazione soprattutto nel
     * caso di inserimenti di "Limitazioni" nell'uso di alcune risorse da parte dell'utente;
     */
    public long fileSize(String path){
	
        File f;
        long file_size;
        file_size = 0;
        f = new File(path);
            if(f.exists()){
                file_size = f.length();
                return file_size;
            }else{
                return 0;
            }
     }

}


