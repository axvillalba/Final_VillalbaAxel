package final_villalbaaxel;

import java.io.*;
import java.util.*;

public class FarmaciaGestion implements Gestor<Farmaco> {

    private Farmacia farmacia;

    public FarmaciaGestion(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    @Override
    public void agregar(Farmaco f) {
        farmacia.agregarFarmaco(f);
    }

    @Override
    public ArrayList<Farmaco> listar() {
        return farmacia.getListaFarmacos();
    }

    @Override
    public void eliminar(String codigo) {

        for (int i = 0; i < farmacia.getListaFarmacos().size(); i++) {
            Farmaco f = farmacia.getListaFarmacos().get(i);
            if (f.getCodigo().equals(codigo)) {
                farmacia.getListaFarmacos().remove(i);
                i--; // retrocede el índice para no saltarse elementos
            }
        }

    }

    @Override
    public Farmaco buscarPorCodigo(String codigo) {
        for (Farmaco f : farmacia.getListaFarmacos()) {
            if (f.getCodigo().equals(codigo)) {
                return f;
            }
        }
        return null;
    }

}
