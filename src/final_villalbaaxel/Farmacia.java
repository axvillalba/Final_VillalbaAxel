
package final_villalbaaxel;

import java.io.*;
import java.util.*;

public class Farmacia {
    private String nombre;
    private List<Farmaco> farmacos;

    public Farmacia(String nombre) {
        this.nombre = nombre;
        this.farmacos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Farmaco> getMedicamentos() {
        return farmacos;
    }

    // Método para delegar la gestión de farmaco a FarmaciaGestion
    public void gestionarMedicamentos(FarmaciaGestion gestion) {
        gestion.gestionarFarmacia(this);
    }

    // Método para agregar farmaco
    public void agregarMedicamento(Farmaco farmaco) {
        // Aquí puedes agregar validación si quieres evitar duplicados
        if (!farmacos.contains(farmaco)) {
            farmacos.add(farmaco);
            System.out.println("Medicamento agregado: " + farmaco.getMonodroga());
        } else {
            System.out.println("Medicamento ya existe en el inventario.");
        }
    }
}
