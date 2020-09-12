package lab7;

import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<Carro> carros;

    public Cliente() {
        carros = new ArrayList();
    }

    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        carros = new ArrayList();
    }

    public Carro getCarro(int i) {
        return carros.get(i);
    }

    public void setCarro(Carro carro) {
        if (carros.size() > 0) {
            this.carros.add(carro);
        }
    }

    public void removeCarroPorLimpiear(int i) {
        if (this.carros.size() > 1) {
            try {
                this.carros.remove(i);
            } catch (Exception e) {
            }
        }
    }

    public void removeCarroPorLimpiear(Carro carroPorLimpiar) {
        if (this.carros.size() > 1) {
            try {
                this.carros.remove(carroPorLimpiar);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }

}
