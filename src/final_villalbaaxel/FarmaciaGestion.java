
package final_villalbaaxel;

import java.util.ArrayList;
import java.util.List;

public class FarmaciaGestion implements CRUD<Farmaco> {
    private List<Farmaco> farmacos = new ArrayList<>();

    @Override
    public void crear(Farmaco f) {
        farmacos.add(f);
    }

    @Override
    public Farmaco leer(String id) {
        for (Farmaco f : farmacos) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Farmaco f) {
        Farmaco fToUpdate = leer(f.getId());
        if (fToUpdate != null) {
            farmacos.remove(fToUpdate);
            farmacos.add(f);
        }
    }

    @Override
    public void eliminar(String id) {
        Farmaco fToRemove = leer(id);
        if (fToRemove != null) {
            farmacos.remove(fToRemove);
        }
    }

    // Método para mostrar todos los fármacos
    public void mostrarFarmacos() {
        for (Farmaco f : farmacos) {
            f.mostrarDetalles();
        }
    }
}
