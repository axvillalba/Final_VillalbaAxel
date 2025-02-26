package final_villalbaaxel;

public class Antiepileptico extends Farmaco {

    private ClasificacionAntiepileptico clasificacion;
    private TipoReceta tipoReceta;

    public Antiepileptico(String codigo, String monodroga, double precio, double dosis, int cantidad,
            ClasificacionAntiepileptico clasificacion, TipoReceta tipoReceta) {
        super(codigo, monodroga, precio, dosis, cantidad);
        this.setClasificacion(clasificacion);
        this.setTipoReceta(tipoReceta);
    }

    public void setClasificacion(ClasificacionAntiepileptico clasificacion) {
        if (clasificacion != null) {
            this.clasificacion = clasificacion;
        } else {
            throw new IllegalArgumentException("La clasificación no puede ser nula.");
        }
    }

    public ClasificacionAntiepileptico getClasificacion() {
        return clasificacion;
    }

    public void setTipoReceta(TipoReceta tipoReceta) {
        if (tipoReceta != null) {
            this.tipoReceta = tipoReceta;
        } else {
            throw new IllegalArgumentException("El tipo de receta no puede ser nulo.");
        }
    }

    public TipoReceta getTipoReceta() {
        return tipoReceta;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Antiepileptico: " + getMonodroga() + "(Codigo: " + getCodigo() + "), Clasificación: " + clasificacion
                + ", Tipo de receta: " + tipoReceta
                + ", Precio: $" + getPrecio() + ", Dosis: " + getDosis() + "mg, Cantidad: " + getCantidad());
    }
}
