package final_villalbaaxel;

public class Antidepresivo extends Farmaco implements InformacionDetallada {

    private TipoAntidepresivo tipoAntidepresivo;
    private String efectoSecundario;

    public Antidepresivo(String codigo, String monodroga, double precio, double dosis, int cantidad,
                         TipoAntidepresivo tipoAntidepresivo, String efectoSecundario) {
        super(codigo, monodroga, precio, dosis, cantidad);
        if (tipoAntidepresivo == null) throw new IllegalArgumentException("Tipo no puede ser nulo.");
        if (efectoSecundario == null || efectoSecundario.isBlank()) throw new IllegalArgumentException("Efecto no válido.");
        this.tipoAntidepresivo = tipoAntidepresivo;
        this.efectoSecundario = efectoSecundario;
    }

    public void setTipoAntidepresivo(TipoAntidepresivo tipoAntidepresivo) {
        if (tipoAntidepresivo != null) {
            this.tipoAntidepresivo = tipoAntidepresivo;
        } else {
            throw new IllegalArgumentException("El tipo de antidepresivo no puede ser nulo.");
        }
    }

    public TipoAntidepresivo getTipoAntidepresivo() {
        return tipoAntidepresivo;
    }

    public void setEfectoSecundario(String efectoSecundario) {
        if (efectoSecundario != null && !efectoSecundario.trim().isEmpty()) {
            this.efectoSecundario = efectoSecundario;
        } else {
            throw new IllegalArgumentException("El efecto secundario no puede estar vacio.");
        }
    }

    public String getEfectoSecundario() {
        return efectoSecundario;
    }

 @Override
public void mostrarInfo() {
System.out.println("Antidepresivo: " + getMonodroga());
}


@Override
public void mostrarInfoDetallada() {
System.out.println("Antidepresivo: " + getMonodroga() + ", Tipo: " + tipoAntidepresivo +
", Efecto Secundario: " + efectoSecundario);
}
}
