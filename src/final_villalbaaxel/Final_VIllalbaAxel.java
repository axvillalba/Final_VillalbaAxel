
package final_villalbaaxel;



import java.util.Scanner;
public class Final_VIllalbaAxel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear una farmacia
        System.out.print("Ingrese el nombre de la farmacia: ");
        String nombreFarmacia = scanner.nextLine();
        Farmacia farmacia = new Farmacia(nombreFarmacia);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones disponibles:");
            System.out.println("1. Agregar fármaco");
            System.out.println("2. Buscar fármaco por ID");
            System.out.println("3. Actualizar fármaco");
            System.out.println("4. Eliminar fármaco");
            System.out.println("5. Mostrar todos los fármacos");
            System.out.println("6. Guardar fármacos");
            System.out.println("7. Cargar fármacos");
            System.out.println("8. Exportar fármacos a TXT");
            System.out.println("9. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    farmacia.agregarFarmaco();
                    break;
                case 2:
                    farmacia.obtenerFarmaco();
                    break;
                case 3:
                    farmacia.actualizarFarmaco();
                    break;
                case 4:
                    farmacia.eliminarFarmaco();
                    break;
                case 5:
                    farmacia.mostrarFarmacos();
                    break;
                case 6:
                    farmacia.guardarFarmacos();
                    break;
                case 7:
                    farmacia.cargarFarmacos();
                    break;
                case 8:
                    farmacia.exportarFarmacos();
                    break;
                case 9:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}

}
