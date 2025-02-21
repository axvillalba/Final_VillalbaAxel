
package final_villalbaaxel;

public class Antidepresivo extends Farmaco{


    private TipoAntidepresivo tipo;
    private String efectoSecundario;

    public Antidepresivo(String monodroga, double precio, double dosis, int cantidad, TipoAntidepresivo tipo, String efectoSecundario) {
        super(monodroga, precio, dosis, cantidad);
        this.tipo = tipo;
        this.efectoSecundario = efectoSecundario;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Antidepresivo: Monodroga: " + monodroga + " - Precio: " + precio + " - Dosis: " + dosis + "mg - Cantidad: " + cantidad);
        System.out.println("Tipo: " + tipo + " - Efecto Secundario: " + efectoSecundario);
    }
}
