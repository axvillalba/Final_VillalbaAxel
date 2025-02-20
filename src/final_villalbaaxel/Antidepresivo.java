
package final_villalbaaxel;


public class Antidepresivo extends Farmaco {
    private TipoAntidepresivo tipo;
    private String efectosSecundarios;

    public Antidepresivo(String id, String codigoBarra, String monodroga, double precio, double dosis, int cantidadCajas, TipoAntidepresivo tipo, String efectosSecundarios) {
        super(monodroga, precio, dosis, cantidadCajas);
        this.tipo = tipo;
        this.efectosSecundarios = efectosSecundarios;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Antidepresivo: " + getMonodroga() + ", Tipo: " + tipo + ", Efectos Secundarios: " + efectosSecundarios);
    }
}