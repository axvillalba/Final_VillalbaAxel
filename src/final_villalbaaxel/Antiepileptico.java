package final_villalbaaxel;


public class Antiepileptico extends Farmaco{
    public enum Clasificacion {
        INICIAL, MANTENIMIENTO;
    }

    public enum TipoReceta {
        CONTROLADA, NORMAL;
    }

    private Clasificacion clasificacion;
    private TipoReceta tipoReceta;

    public Antiepileptico(String monodroga, double precio, double dosis, int cantidad, Clasificacion clasificacion, TipoReceta tipoReceta) {
        super(monodroga, precio, dosis, cantidad);
        this.clasificacion = clasificacion;
        this.tipoReceta = tipoReceta;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Antiepileptico: Monodroga: " + monodroga + " - Precio: " + precio + " - Dosis: " + dosis + "mg - Cantidad: " + cantidad);
        System.out.println("Clasificación: " + clasificacion + " - Tipo de Receta: " + tipoReceta);
    }
}
