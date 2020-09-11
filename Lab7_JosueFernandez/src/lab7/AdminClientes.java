package lab7;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminClientes {

    private File archivo;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public AdminClientes() {
        archivo = new File("./Clientes.cli");
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<Cliente> getClientes() {
        System.out.println("CLientres");
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void escribirClientes() {

        try {
            FileOutputStream fo = new FileOutputStream(archivo);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            
            try {
                for (Cliente cliente : clientes) {
                    oo.writeObject(cliente);
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
    
    public void cargarClientes(){
        
        if (archivo.exists()) {
            
            try {
                
                FileInputStream fi = new FileInputStream(archivo);
                ObjectInputStream oi = new ObjectInputStream(fi);
                Cliente cliente;
                try {
                    while( (cliente = (Cliente) oi.readObject()) != null ){
                        clientes.add(cliente);
                    }
                } catch (EOFException e) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                oi.close();
                fi.close();
                
            } catch (FileNotFoundException ex) {
                System.out.println("CLientes not found.");
            } catch (IOException ex) {
                Logger.getLogger(AdminClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}
