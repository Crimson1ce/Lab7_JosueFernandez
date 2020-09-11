package lab7;

import java.util.ArrayList;

public class Empleado extends Persona {

    private ArrayList<Carro> carrosPorLimpiar;

    public Empleado() {
        carrosPorLimpiar = new ArrayList();
    }

    public Empleado(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        carrosPorLimpiar = new ArrayList();
    }
    
    public Carro getCarroPorLimpiar(int i) {
        return carrosPorLimpiar.get(i);
    }
    
    public void setCarroPorLimpiar(Carro carroPorLimpiar) {
        if (this.carrosPorLimpiar.size()<5) {
            this.carrosPorLimpiar.add(carroPorLimpiar);
        }
    }
    
    public void removeCarroPorLimpiear(int i){
        if (this.carrosPorLimpiar.size()>1) {
            try {
                this.carrosPorLimpiar.remove(i);
            } catch (Exception e) {
            }
        }
    }
    
    public void removeCarroPorLimpiear(Carro carroPorLimpiar){
        if (this.carrosPorLimpiar.size()>1) {
            try {
                this.carrosPorLimpiar.remove(carroPorLimpiar);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
