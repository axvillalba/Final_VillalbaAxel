package final_villalbaaxel;
  

public class Ansiolitico extends Farmaco {
    private boolean dependencia;
    private boolean trazabilidad;

    public Ansiolitico(String id, String codigoBarra, String monodroga, double precio, double dosis, int cantidadCajas, boolean dependencia, boolean trazabilidad) {
        super( monodroga, precio, dosis, cantidadCajas);
        this.dependencia = dependencia;
        this.trazabilidad = trazabilidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Ansiolitico: " + getMonodroga() + ", Dependencia: " + dependencia + ", Trazabilidad: " + trazabilidad);
    }
}
