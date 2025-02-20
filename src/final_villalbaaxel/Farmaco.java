
package final_villalbaaxel;


public abstract class Farmaco {
    protected String monodroga;  // Solo la monodroga, sin nombre comercial
    protected double precio;
    protected double dosis;
    protected int cantidad;

    // Constructor
    public Farmaco(String monodroga, double precio, double dosis, int cantidad) {
        this.monodroga = monodroga;
        this.precio = precio;
        this.dosis = dosis;
        this.cantidad = cantidad;
    }

    // Getters y setters con validaciones
    public String getMonodroga() {
        return monodroga;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("Precio no válido.");
        }
    }

    public void setDosis(double dosis) {
        if (dosis > 0) {
            this.dosis = dosis;
        } else {
            System.out.println("Dosis no válida.");
        }
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            System.out.println("Cantidad no válida.");
        }
    }

    public abstract void mostrarInfo();  // Método abstracto para mostrar la información específica de cada tipo de medicamento
}
