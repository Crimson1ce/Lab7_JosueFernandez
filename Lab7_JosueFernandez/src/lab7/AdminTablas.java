package lab7;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JTable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminTablas  {
    
    private File archivo;
    private JTable[] tablas = new JTable[3];

    public AdminTablas() {
        archivo = new File("./Tablas");
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "AdminBarra{" + '}';
    }
    
    public void cargarTablas(){
        if (archivo.exists()) {
            
            try {
                FileInputStream fi = new FileInputStream(archivo);
                ObjectInputStream oi = new ObjectInputStream(fi);
                JTable tabla;
                tablas = new JTable[3];
                try {
                    
                    int c=0;
                    while ( (tabla = (JTable)oi.readObject()) != null ) {
                        tablas[(c++)] = (tabla);
                    }
                    
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (EOFException ex) {
                    ex.printStackTrace();
                }
                
                
                oi.close();
                fi.close();
                
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
    public void escribirTablas(){
        try {
            FileOutputStream fo = new FileOutputStream(archivo);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            
            try {
                for (JTable tabla : tablas) {
                    oo.writeObject(tabla);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            oo.close();
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JTable[] getTablas() {
        return tablas;
    }

    public void setTablas(JTable[] tablas) {
        this.tablas = tablas;
    }
    
}
