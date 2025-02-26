package final_villalbaaxel;

public class Ansiolitico extends Farmaco {

    private Dependencia dependencia;
    private boolean trazabilidad;

    public Ansiolitico(String codigo, String monodroga, double precio, double dosis, int cantidad,
            Dependencia dependencia, boolean trazabilidad) {
        super(codigo, monodroga, precio, dosis, cantidad);
        this.setDependencia(dependencia);
        this.setTrazabilidad(trazabilidad);
    }

    public void setDependencia(Dependencia dependencia) {
        if (dependencia != null) {
            this.dependencia = dependencia;
        } else {
            throw new IllegalArgumentException("La dependencia no puede ser nula.");
        }
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setTrazabilidad(boolean trazabilidad) {
        this.trazabilidad = trazabilidad;
    }

    public boolean isTrazabilidad() {
        return trazabilidad;
    }

@Override
public void mostrarInfo() {
    System.out.println("Ansiolitico: " + getMonodroga() + " (Codigo: " + getCodigo() + "), Dependencia: " + dependencia
            + ", Trazabilidad: " + (trazabilidad ? "Si" : "No")
            + ", Precio: $" + getPrecio() + ", Dosis: " + getDosis() + "mg, Cantidad: " + getCantidad());
}

}
