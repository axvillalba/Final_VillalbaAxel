package final_villalbaaxel;

         public class Antidepresivo extends Farmaco {
            private TipoAntidepresivo tipoAntidepresivo;
            private String efectoSecundario;

            public Antidepresivo(String codigo, String monodroga, double precio, double dosis, int cantidad, 
                                 TipoAntidepresivo tipoAntidepresivo, String efectoSecundario) {
                super(codigo, monodroga, precio, dosis, cantidad);
                this.setTipoAntidepresivo(tipoAntidepresivo);
                this.setEfectoSecundario(efectoSecundario);
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
                    throw new IllegalArgumentException("El efecto secundario no puede estar vacío.");
                }
            }

            public String getEfectoSecundario() {
                return efectoSecundario;
            }

            @Override
            public void mostrarInfo() {
                System.out.println("Antidepresivo: " + getMonodroga() + ", Tipo: " + tipoAntidepresivo + 
                                   ", Efecto Secundario: " + efectoSecundario + 
                                   ", Precio: $" + getPrecio() + ", Dosis: " + getDosis() + "mg, Cantidad: " + getCantidad());
            }
}
