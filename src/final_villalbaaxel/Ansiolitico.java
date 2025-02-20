package final_villalbaaxel;
  
public class Ansiolitico extends Farmaco {
    public enum Dependencia {
        BAJA, MEDIA, ALTA;
    }

    private Dependencia dependencia;
    private boolean trazabilidad;

    public Ansiolitico(String monodroga, double precio, double dosis, int cantidad, Dependencia dependencia, boolean trazabilidad) {
        super(monodroga, precio, dosis, cantidad);
        this.dependencia = dependencia;
        this.trazabilidad = trazabilidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Ansiolítico: Monodroga: " + monodroga + " - Precio: " + precio + " - Dosis: " + dosis + "mg - Cantidad: " + cantidad);
        System.out.println("Dependencia: " + dependencia + " - Trazabilidad: " + (trazabilidad ? "Sí" : "No"));
    }
}
