package final_villalbaaxel;

public class Antiepileptico extends Farmaco {

    private ClasificacionAntiepileptico clasificacion;
    private TipoReceta tipoReceta;

    // Constructor utilizando setters
    public Antiepileptico(String monodroga, double precio, double dosis, int cantidad, ClasificacionAntiepileptico clasificacion, TipoReceta tipoReceta) {
        super(monodroga, precio, dosis, cantidad); // Llamada al constructor de la clase base
       this. setClasificacion(clasificacion); // Usar el setter para clasificacion
        this.setTipoReceta(tipoReceta); // Usar el setter para tipoReceta
    }

    // Getter para clasificacion
    public ClasificacionAntiepileptico getClasificacion() {
        return clasificacion;
    }

    // Setter para clasificacion
    public void setClasificacion(ClasificacionAntiepileptico clasificacion) {
        this.clasificacion = clasificacion;
    }

    // Getter para tipoReceta
    public TipoReceta getTipoReceta() {
        return tipoReceta;
    }

    // Setter para tipoReceta
    public void setTipoReceta(TipoReceta tipoReceta) {
        this.tipoReceta = tipoReceta;
    }

   @Override
    public void mostrarInfo() {
        System.out.println("Antiepileptico: Monodroga: " + monodroga + " - Precio: " + precio + " - Dosis: " + dosis + "mg - Cantidad: " + cantidad);
        System.out.println("Clasificación: " + clasificacion + " - Tipo de Receta: " + tipoReceta);
    }
}
