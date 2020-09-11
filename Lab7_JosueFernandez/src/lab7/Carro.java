package lab7;

import java.io.File;
import java.io.Serializable;

public class Carro implements Serializable{
    private int numeroPlaca;
    private String tamaño;
    private int cantidadPuertas;
    private int nivelSuciedad;

    private static final long serialVersionUID = 1L;
    
    public Carro() {
    }

    public Carro(int numeroPlaca, String tamaño, int cantidadPuertas, int nivelSuciedad) {
        this.numeroPlaca = numeroPlaca;
        this.tamaño = tamaño;
        this.cantidadPuertas = cantidadPuertas;
        this.nivelSuciedad = nivelSuciedad;
    }

    public int getNivelSuciedad() {
        return nivelSuciedad;
    }

    public void setNivelSuciedad(int nivelSuciedad) {
        this.nivelSuciedad = nivelSuciedad;
    }

    public int getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(int numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String toString() {
        return numeroPlaca + "";
    }
    
}
