package final_villalbaaxel;

public abstract class Farmaco {
            private String codigo;
            private String monodroga;
            private double precio;
            private double dosis;
            private int cantidad;

            public Farmaco(String codigo, String monodroga, double precio, double dosis, int cantidad) {
                this.setCodigo(codigo);
                this.setMonodroga(monodroga);
                this.setPrecio(precio);
                this.setDosis(dosis);
                this.setCantidad(cantidad);
            }

            // Setter con validación para código
            public void setCodigo(String codigo) {
                if (codigo != null && !codigo.trim().isEmpty()) {
                    this.codigo = codigo;
                } else {
                    throw new IllegalArgumentException("El código no puede estar vacío.");
                }
            }

            public String getCodigo() {
                return codigo;
            }

            // Setter con validación para monodroga
            public void setMonodroga(String monodroga) {
                if (monodroga != null && !monodroga.trim().isEmpty()) {
                    this.monodroga = monodroga;
                } else {
                    throw new IllegalArgumentException("La monodroga no puede estar vacía.");
                }
            }

            public String getMonodroga() {
                return monodroga;
            }

            // Setter con validación para precio
            public void setPrecio(double precio) {
                if (precio > 0) {
                    this.precio = precio;
                } else {
                    throw new IllegalArgumentException("El precio debe ser mayor a 0.");
                }
            }

            public double getPrecio() {
                return precio;
            }

            // Setter con validación para dosis
            public void setDosis(double dosis) {
                if (dosis > 0) {
                    this.dosis = dosis;
                } else {
                    throw new IllegalArgumentException("La dosis debe ser mayor a 0.");
                }
            }

            public double getDosis() {
                return dosis;
            }

            // Setter con validación para cantidad
            public void setCantidad(int cantidad) {
                if (cantidad >= 0) {
                    this.cantidad = cantidad;
                } else {
                    throw new IllegalArgumentException("La cantidad no puede ser negativa.");
                }
            }

            public int getCantidad() {
                return cantidad;
            }

            // Método abstracto para mostrar la información del medicamento
            public abstract void mostrarInfo();
    }
