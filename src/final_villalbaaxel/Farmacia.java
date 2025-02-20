
package final_villalbaaxel;

import java.io.*;
import java.util.*;

public class Farmacia {
    private String nombre;
    private FarmaciaGestion gestion;
    private Scanner scanner;

    // Constructor de la farmacia
    public Farmacia(String nombre) {
        this.nombre = nombre;
        this.gestion = new FarmaciaGestion(new ArrayList<>()); // Inicializa FarmaciaGestion con una lista vacía
        this.scanner = new Scanner(System.in);
    }

    // Métodos CRUD
    public void agregarFarmaco() {
        // Solicitamos al usuario que ingrese los detalles del fármaco
        System.out.print("Ingrese ID del fármaco: ");
        String id = scanner.nextLine();
        
        System.out.print("Ingrese Código de Barra: ");
        String codigoBarra = scanner.nextLine();
        
        System.out.print("Ingrese Monodroga: ");
        String monodroga = scanner.nextLine();
        
        System.out.print("Ingrese Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Ingrese Dosis: ");
        double dosis = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Ingrese Cantidad de Cajas: ");
        int cantidadCajas = Integer.parseInt(scanner.nextLine());

        // Preguntar el tipo de medicamento
        System.out.println("Seleccionar tipo de fármaco: ");
        System.out.println("1. Ansiolítico");
        System.out.println("2. Antidepresivo");
        System.out.println("3. Antiepiléptico");
        System.out.print("Ingrese el número de opción: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        Farmaco f = null;

        switch (tipo) {
            case 1:  // Ansiolítico
                System.out.print("¿Tiene dependencia? (true/false): ");
                boolean dependencia = Boolean.parseBoolean(scanner.nextLine());
                System.out.print("¿Tiene trazabilidad? (true/false): ");
                boolean trazabilidad = Boolean.parseBoolean(scanner.nextLine());
                f = new Ansiolitico(id, codigoBarra, monodroga, precio, dosis, cantidadCajas, dependencia, trazabilidad);
                break;
            case 2:  // Antidepresivo
                System.out.print("Ingrese efectos secundarios: ");
                String efectosSecundarios = scanner.nextLine();
                System.out.println("Seleccionar tipo de antidepresivo: ");
                System.out.println("1. Selectivo");
                System.out.println("2. No Selectivo");
                System.out.print("Ingrese el número de opción: ");
                int tipoAntidepresivo = Integer.parseInt(scanner.nextLine());
                TipoAntidepresivo tipoDepresivo = (tipoAntidepresivo == 1) ? TipoAntidepresivo.SELECTIVO : TipoAntidepresivo.NO_SELECTIVO;
                f = new Antidepresivo(id, codigoBarra, monodroga, precio, dosis, cantidadCajas, tipoDepresivo, efectosSecundarios);
                break;
            case 3:  // Antiepiléptico
                System.out.print("Ingrese clasificación: ");
                String clasificacion = scanner.nextLine();
                System.out.print("Ingrese tipo de receta: ");
                String tipoReceta = scanner.nextLine();
                f = new Antiepileptico(id, codigoBarra, monodroga, precio, dosis, cantidadCajas, clasificacion, tipoReceta);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        // Agregar el fármaco a la gestión
        gestion.crear(f);
        System.out.println("Fármaco agregado exitosamente.");
    }

    public void obtenerFarmaco() {
        System.out.print("Ingrese el ID del fármaco a buscar: ");
        String id = scanner.nextLine();
        Farmaco f = gestion.leer(id);
        if (f != null) {
            f.mostrarDetalles();
        } else {
            System.out.println("Fármaco no encontrado.");
        }
    }

    public void actualizarFarmaco() {
        System.out.print("Ingrese el ID del fármaco a actualizar: ");
        String id = scanner.nextLine();
        Farmaco f = gestion.leer(id);
        if (f != null) {
            System.out.println("Actualizando fármaco...");
            // Puedes pedirle al usuario que ingrese los nuevos datos del fármaco aquí
            // Para simplificar, se actualiza el nombre solo como ejemplo
            System.out.print("Ingrese nuevo nombre de la monodroga: ");
            String nuevoMonodroga = scanner.nextLine();
            f.setMonodroga(nuevoMonodroga);
            gestion.actualizar(f);
            System.out.println("Fármaco actualizado.");
        } else {
            System.out.println("Fármaco no encontrado.");
        }
    }

    public void eliminarFarmaco() {
        System.out.print("Ingrese el ID del fármaco a eliminar: ");
        String id = scanner.nextLine();
        gestion.eliminar(id);
        System.out.println("Fármaco eliminado.");
    }

    // Guardar los fármacos a un archivo
    public void guardarFarmacos() {
        System.out.print("Ingrese el nombre del archivo para guardar los fármacos: ");
        String filename = scanner.nextLine();
        Persistencia.guardarFarmacos(gestion.getFarmacos(), filename);
        System.out.println("Fármacos guardados en el archivo " + filename);
    }

    // Cargar los fármacos desde un archivo
    public void cargarFarmacos() {
        System.out.print("Ingrese el nombre del archivo para cargar los fármacos: ");
        String filename = scanner.nextLine();
        farmaciaGestion.cargarFarmacos(filename);
        System.out.println("Fármacos cargados desde el archivo " + filename);
    }

    // Exportar listado de fármacos a archivo TXT
    public void exportarFarmacos() {
        System.out.print("Ingrese el nombre del archivo para exportar los fármacos: ");
        String filename = scanner.nextLine();
        ExportarTXT.exportarFarmacos(gestion.getFarmacos(), filename);
        System.out.println("Fármacos exportados al archivo " + filename);
    }

    // Mostrar todos los fármacos
    public void mostrarFarmacos() {
        gestion.mostrarFarmacos();
    }

    // Getter para el nombre de la farmacia
    public String getNombre() {
        return nombre;
    }
}

