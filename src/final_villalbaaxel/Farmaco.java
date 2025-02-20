
package final_villalbaaxel;


import java.io.Serializable;

public abstract class Farmaco implements Serializable {
    private String monodroga; // Monodroga
    private double precio; // Precio
    private double dosis; // Dosis
    private int cantidadCajas; // Cantidad de cajas

    public Farmaco(String monodroga, double precio, double dosis, int cantidadCajas) {
        this.monodroga = monodroga;
        this.precio = precio;
        this.dosis = dosis;
        this.cantidadCajas = cantidadCajas;
    }

    // Métodos getter y setter
    public String getMonodroga() {
        return monodroga;
    }

    public void setMonodroga(String monodroga) {
        this.monodroga = monodroga;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    public int getCantidadCajas() {
        return cantidadCajas;
    }

    public void setCantidadCajas(int cantidadCajas) {
        this.cantidadCajas = cantidadCajas;
    }

    // Método abstracto que deben implementar las clases derivadas
    public abstract void mostrarDetalles();
}
