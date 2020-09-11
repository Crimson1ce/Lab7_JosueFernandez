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

public class AdminEmpleados {
    
    private File archivo;
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public AdminEmpleados() {
        archivo = new File("./Empleados.emp");
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<Empleado> getEmpleados() {
        System.out.println("Agregar");
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void escribirEmpleados() {

        try {
            FileOutputStream fo = new FileOutputStream(archivo);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            
            try {
                for (Empleado empleado : empleados) {
                    oo.writeObject(empleado);
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
    
    public void cargarEmpleados(){
        
        if (archivo.exists()) {
            
            try {
                
                FileInputStream fi = new FileInputStream(archivo);
                ObjectInputStream oi = new ObjectInputStream(fi);
                Empleado empleado;
                try {
                    while( (empleado = (Empleado) oi.readObject()) != null ){
                        empleados.add(empleado);
                    }
                } catch (EOFException e) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                oi.close();
                fi.close();
                
            } catch (FileNotFoundException ex) {
                System.out.println("Empleados not found.");
            } catch (IOException ex) {
                Logger.getLogger(AdminClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}
