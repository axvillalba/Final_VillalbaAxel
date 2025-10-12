package final_villalbaaxel;

public class Antiepileptico extends Farmaco implements InformacionDetallada {

    private ClasificacionAntiepileptico clasificacion;
    private TipoReceta tipoReceta;

    public Antiepileptico(String codigo, String monodroga, double precio, double dosis, int cantidad,
            ClasificacionAntiepileptico clasificacion, TipoReceta tipoReceta) {
        super(codigo, monodroga, precio, dosis, cantidad);
        if (clasificacion == null) {
            throw new IllegalArgumentException("Clasificación no puede ser nula.");
        }
        if (tipoReceta == null) {
            throw new IllegalArgumentException("Tipo de receta no puede ser nulo.");
        }
        this.clasificacion = clasificacion;
        this.tipoReceta = tipoReceta;
    }

    public void setClasificacion(ClasificacionAntiepileptico clasificacion) {
        if (clasificacion != null) {
            this.clasificacion = clasificacion;
        } else {
            throw new IllegalArgumentException("La clasificacion no puede ser nula.");
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
        System.out.println("Antiepiléptico: " + getMonodroga());
    }

    @Override
    public void mostrarInfoDetallada() {
        System.out.println("Antiepiléptico: " + getMonodroga() + ", Clasificación: " + clasificacion
                + ", Tipo de receta: " + tipoReceta);
    }
}
