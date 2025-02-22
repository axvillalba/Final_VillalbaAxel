package final_villalbaaxel;

public class Ansiolitico extends Farmaco {

    private Dependencia dependencia;
    private boolean trazabilidad;

    // Constructor utilizando setters
    public Ansiolitico(String monodroga, double precio, double dosis, int cantidad, Dependencia dependencia, boolean trazabilidad) {
        super(monodroga, precio, dosis, cantidad); // Llamada al constructor de la clase base
        this.setDependencia(dependencia); // Usar el setter para dependencia
        this.setTrazabilidad(trazabilidad); // Usar el setter para trazabilidad
    }

    // Getter para dependencia
    public Dependencia getDependencia() {
        return dependencia;
    }

    // Setter para dependencia
    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    // Getter para trazabilidad
    public boolean isTrazabilidad() {
        return trazabilidad;
    }

    // Setter para trazabilidad
    public void setTrazabilidad(boolean trazabilidad) {
        this.trazabilidad = trazabilidad;
    }
    
  @Override
    public void mostrarInfo() {
        System.out.println("Ansiolítico: Monodroga: " + monodroga + " - Precio: " + precio + " - Dosis: " + dosis + "mg - Cantidad: " + cantidad);
        System.out.println("Dependencia: " + dependencia + " - Trazabilidad: " + (trazabilidad ? "Sí" : "No"));
    }
}
