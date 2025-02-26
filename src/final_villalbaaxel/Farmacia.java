package final_villalbaaxel;

import java.util.*;

public class Farmacia {

    private String nombre;
    private ArrayList<Farmaco> farmacos;

    // Constructor de la clase Farmacia usando los setters
    public Farmacia(String nombre) {
        this.setNombre(nombre);  // Usar el setter para el atributo 'nombre'
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

    // Método para agregar un medicamento solo si el código no existe
    public void agregarMedicamento(Farmaco medicamento) {
        if (codigoExiste(medicamento.getCodigo())) {
            System.out.println("Error: El código " + medicamento.getCodigo() + " ya está en uso.");
        } else {
            farmacos.add(medicamento);
            System.out.println("Medicamento agregado: " + medicamento.getCodigo());
        }
    }

    // Método para verificar si un código ya existe en la lista de medicamentos
    public boolean codigoExiste(String codigo) {
        for (Farmaco medicamento : farmacos) {
            if (medicamento.getCodigo().equals(codigo)) {
                return true;  // El código ya existe
            }
        }
        return false;  // El código no existe
    }
}
