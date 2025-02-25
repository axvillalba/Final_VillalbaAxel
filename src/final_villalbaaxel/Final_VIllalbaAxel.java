package final_villalbaaxel;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Final_VIllalbaAxel {

         public static void main(String[] args) {
                  // Crear una farmacia con un nombre
                  Farmacia farmacia = new Farmacia("Farmacia UTN Salud");

                  // Crear un objeto FarmaciaGestion para gestionar la farmacia
                  FarmaciaGestion gestion = new FarmaciaGestion();        
                  Scanner scanner = new Scanner(System.in);
                  int opcion = -1;
                  // Inicializar medicamentos predeterminados
                  inicializarMedicamentos(farmacia, gestion);
                  // Menú de gestión de productos
                  do {
                          // Mostrar el menú
                           System.out.println("\n--- MENU DE GESTION DE PRODUCTOS ---");
                           System.out.println("1. Crear Medicamento");
                           System.out.println("2. Modificar Medicamento");
                           System.out.println("3. Eliminar Medicamento");
                           System.out.println("4. Listar Medicamentos");
                           System.out.println("5. Consultar Medicamento");
                           System.out.println("0. Salir");
                           System.out.print("Seleccione una opción: ");

                           // Validar que la entrada sea un número entero                        
                          boolean entradaValida = false;
                            // Bucle para asegurar que se ingrese un número entero válido
                          while (!entradaValida) {
                                    try {
                                            opcion = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                    if (opcion >= 0 && opcion <= 5) {
                                            entradaValida = true;  // Salir del bucle si la opción es válida
                                    } else {
                                            System.out.println("Opción no válida. Intente de nuevo.");
                                    }
                                    } catch (InputMismatchException e) { //se produce cuando el tipo de dato que ingresa el usuario no coincide con el que espera el programa
                                            System.out.println("Por favor ingrese un valor válido.");
                                            scanner.nextLine(); // Limpiar el buffer para que no quede el valor no válido
                                    }
                           }

                          switch (opcion) {
                                    case 1: // CREAR
                                            crearMedicamento(farmacia, gestion, scanner);
                                            break;
                                    case 2: // MODIFICAR
                                            modificarMedicamento(farmacia, gestion, scanner);
                                            break;
                                    case 3: // ELIMINAR
                                            eliminarMedicamento(farmacia, gestion, scanner);
                                            break;
                                    case 4: // LISTAR
                                            listarMedicamentos(farmacia, gestion);
                                            break;
                                    case 5: // CONSULTAR
                                            consultarMedicamento(farmacia, gestion, scanner);
                                            break;
                                    case 0: // Salir
                                            System.out.println("¡Hasta luego!");
                                            break;
                                    default:
                                            System.out.println("Opción no válida. Intente de nuevo.");
                                            break;
                                   }
                           } while (opcion != 0); // Continuar hasta que el usuario elija salir

                           scanner.close();
        }


         // Método para inicializar algunos medicamentos de ejemplo
         private static void inicializarMedicamentos(Farmacia farmacia, FarmaciaGestion gestion) {
            // Agregar medicamentos manualmente
                  Farmaco antidep = new Antidepresivo("AD001", "Fluoxetina", 100.0, 20.0, 15, TipoAntidepresivo.ISRS, "Somnolencia");
                  farmacia.agregarMedicamento(antidep);
                  Farmaco ansiol = new Ansiolitico("A002", "Alprazolam", 150.0, 0.5, 20, Dependencia.ALTA, true);
                  farmacia.agregarMedicamento(ansiol);
                  Farmaco antiepileptico1 = new Antiepileptico("AE003", "Valproato", 180.0, 200.0, 18, ClasificacionAntiepileptico.CARBOXAMIDAS, TipoReceta.CONTROLADA);
                  farmacia.agregarMedicamento(antiepileptico1);
                  Farmaco antiepileptico2 = new Antiepileptico("AE004", "Lamotrigina", 220.0, 50.0, 25, ClasificacionAntiepileptico.TRIAZINAS, TipoReceta.CONTROLADA);
                  farmacia.agregarMedicamento(antiepileptico2);
         }

         // Método para crear un nuevo medicamento
         private static void crearMedicamento(Farmacia farmacia, FarmaciaGestion gestion, Scanner scanner) {
                  System.out.println("\n--- CREAR MEDICAMENTO ---");
                  // Pedir código del medicamento
                  String codigo = obtenerCodigoUnico(scanner, farmacia);
                  // Pedir los demás datos y crear el medicamento
                  Farmaco nuevoMedicamento = gestion.obtenerDatosMedicamento(scanner, farmacia, codigo);
                  // Agregar el medicamento a la farmacia
                  if (nuevoMedicamento != null) {
                          gestion.agregarMedicamento(farmacia, nuevoMedicamento);
                  }
         }

        // Método para obtener un código único para el medicamento
        private static String obtenerCodigoUnico(Scanner scanner, Farmacia farmacia) {
                  String codigo;
                  while (true) {
                          System.out.print("Ingrese el código del medicamento: ");
                          codigo = scanner.nextLine();
                           
                          if (!farmacia.codigoExiste(codigo)) {
                                   break;  // El código es único, salir del bucle
                          } else {
                                   System.out.println("Error: El código " + codigo + " ya está en uso. Ingrese un código único.");                  
                          }
                 }
                  return codigo;
        }

         // Método para modificar un medicamento
         private static void modificarMedicamento(Farmacia farmacia, FarmaciaGestion gestion, Scanner scanner) {
                  System.out.println("\n--- MODIFICAR MEDICAMENTO ---");
                  System.out.print("Ingrese el código del medicamento a modificar: ");
                  String codigoModificar = scanner.nextLine();
                  gestion.modificarMedicamento(farmacia, codigoModificar);
         }

        // Método para eliminar un medicamento
        private static void eliminarMedicamento(Farmacia farmacia, FarmaciaGestion gestion, Scanner scanner) {
                  System.out.println("\n--- ELIMINAR MEDICAMENTO ---");
                  System.out.print("Ingrese el código del medicamento a eliminar: ");
                  String codigoEliminar = scanner.nextLine();
                  gestion.eliminarMedicamento(farmacia, codigoEliminar);
        }

            // Método para listar los medicamentos
         private static void listarMedicamentos(Farmacia farmacia, FarmaciaGestion gestion) {
                 System.out.println("\n--- LISTAR MEDICAMENTOS ---");
                 gestion.listarMedicamentos(farmacia);
         }

            // Método para consultar un medicamento
         private static void consultarMedicamento(Farmacia farmacia, FarmaciaGestion gestion, Scanner scanner) {
                  System.out.println("\n--- CONSULTAR MEDICAMENTO ---");
                  System.out.print("Ingrese el código del medicamento a consultar: ");
                  String codigoConsultar = scanner.nextLine();
                  gestion.consultarMedicamento(farmacia, codigoConsultar);
         }
}

/*
gestion.buscarMedicamentoPorCodigo(farmacia, codigo)  -- 
gestion.consultarMedicamento(farmacia, codigoConsultar) --
gestion.listarMedicamentos(farmacia) --
gestion.eliminarMedicamento(farmacia, codigoEliminar) --
gestion.modificarMedicamento(farmacia, codigoModificar) --



*/