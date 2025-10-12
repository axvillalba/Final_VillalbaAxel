package final_villalbaaxel;

public class Ansiolitico extends Farmaco implements InformacionDetallada {

    private Dependencia dependencia;
    private boolean trazabilidad;

    public Ansiolitico(String codigo, String monodroga, double precio, double dosis, int cantidad,
            Dependencia dependencia, boolean trazabilidad) {
        super(codigo, monodroga, precio, dosis, cantidad);
        if (dependencia == null) {
            throw new IllegalArgumentException("Dependencia no puede ser nula.");
        }
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
        System.out.println("Ansiolítico: " + getMonodroga());
    }

    @Override
    public void mostrarInfoDetallada() {
        System.out.println("Ansiolítico: " + getMonodroga() + ", Dependencia: " + dependencia
                + ", Trazabilidad: " + (trazabilidad ? "Sí" : "No"));
    }
}
