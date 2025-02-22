package final_villalbaaxel;

import java.util.*;

public class Farmacia {
    private String nombre;
    private ArrayList<Farmaco> farmacos;

    // Constructor de la clase Farmacia usando los setters
    public Farmacia(String nombre) {
       this. setNombre(nombre);  // Usar el setter para el atributo 'nombre'
        this.farmacos = new ArrayList<>();  // El setter no es necesario para la lista, ya que se inicializa directamente
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
    public ArrayList<Farmaco> getMedicamentos() {
        return farmacos;
    }

    // Método para delegar la gestión de medicamentos a FarmaciaGestion
    public void gestionarMedicamentos(FarmaciaGestion gestion) {
        gestion.gestionarFarmacia(this);
    }

    // Método para agregar medicamento con validación de duplicados
    public void agregarMedicamento(Farmaco farmaco) {
        // Validación para evitar duplicados
        boolean exists = false;
        for (Farmaco f : farmacos) {
            if (f.equals(farmaco)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            farmacos.add(farmaco);
            System.out.println("Medicamento agregado: " + farmaco.getMonodroga());
        } else {
            System.out.println("Medicamento ya existe en el inventario.");
        }
    }
}
