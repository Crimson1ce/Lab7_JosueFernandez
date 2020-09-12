package lab7;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HiloLavado extends Thread {

    private JTable tabla;
    private JProgressBar barra;
    private Empleado empleado;
    private int i;

    public HiloLavado(JTable tabla, JProgressBar barra, Empleado empleado, int i) {
        this.tabla = tabla;
        this.barra = barra;
        this.empleado = empleado;
        this.i = i;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    @Override
    public String toString() {
        return "Lavado " + empleado;
    }

    @Override
    public void run() {
        try {

            for (Carro carro : empleado.getCarrosPorLimpiar()) {
                double mult;
                if (carro.getTamaño().equals("Grande")) {
                    mult = 2.2;
                } else if (carro.getTamaño().equals("Mediano")) {
                    mult = 1.8;
                } else {
                    mult = 1.2;
                }

                double tiempo = carro.getNivelSuciedad() * mult;
                barra.setMaximum((int) (tiempo * 100.0));
                boolean vive = true;

                while (vive) {
                    barra.setValue(barra.getValue() + 10);
                    if (barra.getValue() == barra.getMaximum()) {
                        vive = false;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                DefaultTableModel tmodel = (DefaultTableModel) tabla.getModel();
                Object[] row = new Object[]{
                    carro,
                    carro.getTamaño(),
                    carro.getNivelSuciedad(),
                    tiempo
                };

                tmodel.addRow(row);
                tabla.setModel(tmodel);

                try {
                    Thread.sleep(0);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                barra.setValue(0);
                
                
                carro.setNivelSuciedad(0);
                Carwash.carrosLavados.addElement(carro);
                Carwash.carrosAsignados.removeElement(carro);
                
            }
            empleado.setCarrosPorLimpiar(new ArrayList<>());
            Carwash.ae.escribirEmpleados();

            Carwash.at.getTablas()[i] = tabla;
        } catch (Exception e) {
        }
    }
}
