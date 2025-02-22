
package final_villalbaaxel;

public class Antidepresivo extends Farmaco {

    private TipoAntidepresivo tipo;
    private String efectoSecundario;

    // Constructor utilizando setters
    public Antidepresivo(String monodroga, double precio, double dosis, int cantidad, TipoAntidepresivo tipo, String efectoSecundario) {
        super(monodroga, precio, dosis, cantidad); // Llamada al constructor de la clase base
        this.setTipo(tipo); // Usar el setter para tipo
        this.setEfectoSecundario(efectoSecundario); // Usar el setter para efectoSecundario
    }

    // Getter para tipo
    public TipoAntidepresivo getTipo() {
        return tipo;
    }

    // Setter para tipo
    public void setTipo(TipoAntidepresivo tipo) {
        this.tipo = tipo;
    }

    // Getter para efectoSecundario
    public String getEfectoSecundario() {
        return efectoSecundario;
    }

    // Setter para efectoSecundario
    public void setEfectoSecundario(String efectoSecundario) {
        this.efectoSecundario = efectoSecundario;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Antidepresivo: Monodroga: " + monodroga + " - Precio: " + precio + " - Dosis: " + dosis + "mg - Cantidad: " + cantidad);
        System.out.println("Tipo: " + tipo + " - Efecto Secundario: " + efectoSecundario);
    }
}

