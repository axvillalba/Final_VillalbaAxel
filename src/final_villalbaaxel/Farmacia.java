package final_villalbaaxel;

import java.io.*;
import java.util.*;

public class Farmacia {

    private String nombre;
    private ArrayList<Farmaco> listaFarmacos;

    // Constructor de la clase Farmacia usando los setters
    public Farmacia(String nombre) {
        this.setNombre(nombre);
        this.listaFarmacos = new ArrayList<>();
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {

        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre no puede ser vacío.");
        }
    }

    // Cambiar List a ArrayList en el tipo de retorno y variable
    public ArrayList<Farmaco> getListaFarmacos() {
        return listaFarmacos;
    }

    public void agregarFarmaco(Farmaco farmaco) {
        if (farmaco != null) {
            listaFarmacos.add(farmaco);
        } else {
            throw new IllegalArgumentException("El fármaco no puede ser nulo.");
        }
    }

    public void mostrarInventario() {
        System.out.println("\n--- Inventario de " + nombre + " ---");
        if (listaFarmacos.isEmpty()) {
            System.out.println("No hay fármacos registrados.");
        } else {
            for (Farmaco farmaco : listaFarmacos) {
                farmaco.mostrarInfo();
            }
        }
    }
}
