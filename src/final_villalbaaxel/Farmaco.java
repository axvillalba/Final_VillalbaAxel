
package final_villalbaaxel;


import java.io.Serializable;

public abstract class Farmaco implements Serializable {
    private String id; // ID del fármaco
    private String codigoBarra; // Código de barra
    private String monodroga; // Monodroga
    private double precio; // Precio
    private double dosis; // Dosis
    private int cantidadCajas; // Cantidad de cajas

    public Farmaco(String id, String codigoBarra, String monodroga, double precio, double dosis, int cantidadCajas) {
        this.id = id;
        this.codigoBarra = codigoBarra;
        this.monodroga = monodroga;
        this.precio = precio;
        this.dosis = dosis;
        this.cantidadCajas = cantidadCajas;
    }

    // Métodos getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

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
