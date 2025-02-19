package final_villalbaaxel;


public class Antiepileptico extends Farmaco {
    private String clasificacion;
    private String tipoReceta;

    public Antiepileptico(String id, String codigoBarra, String monodroga, double precio, double dosis, int cantidadCajas, String clasificacion, String tipoReceta) {
        super(id, codigoBarra, monodroga, precio, dosis, cantidadCajas);
        this.clasificacion = clasificacion;
        this.tipoReceta = tipoReceta;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Antiepileptico: " + getMonodroga() + ", Clasificación: " + clasificacion + ", Tipo de Receta: " + tipoReceta);
    }
}