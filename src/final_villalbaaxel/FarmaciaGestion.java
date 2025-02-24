package final_villalbaaxel;

import java.util.*;

public class FarmaciaGestion {

        // Método para gestionar la farmacia y mostrar sus medicamentos
        public void gestionarFarmacia(Farmacia farmacia) {
            System.out.println("Gestionando la farmacia: " + farmacia.getNombre());
            mostrarMedicamentos(farmacia);
        }

        // Método para agregar un medicamento a la farmacia
        public void agregarMedicamento(Farmacia farmacia, Farmaco medicamento) {
            if (!farmacia.getMedicamentos().contains(medicamento)) {
                farmacia.getMedicamentos().add(medicamento);
                System.out.println("Medicamento agregado: " + medicamento.getMonodroga());
            } else {
                System.out.println("Este medicamento ya existe en el inventario.");
            }
        }

        // Método para obtener los datos de un medicamento
        public Farmaco obtenerDatosMedicamento(Scanner scanner) {
            System.out.print("Ingrese la monodroga: ");
            String monodroga = scanner.nextLine();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese la dosis (mg): ");
            double dosis = scanner.nextDouble();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Preguntar tipo de medicamento y crear según corresponda
            System.out.println("Seleccione el tipo de medicamento:");
            System.out.println("1. Antidepresivo");
            System.out.println("2. Ansiolitico");
            System.out.println("3. Antiepileptico");
            int tipoMedicamento = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Crear según tipo
            Farmaco nuevoMedicamento = null;
            switch (tipoMedicamento) {
                case 1:
                    nuevoMedicamento = crearAntidepresivo(monodroga, precio, dosis, cantidad, scanner);
                    break;
                case 2:
                    nuevoMedicamento = crearAnsiolitico(monodroga, precio, dosis, cantidad, scanner);
                    break;
                case 3:
                    nuevoMedicamento = crearAntiepileptico(monodroga, precio, dosis, cantidad, scanner);
                    break;
                default:
                    System.out.println("Tipo de medicamento no válido.");
                    break;
            }
            return nuevoMedicamento;
        }

        // Métodos para crear tipos específicos de medicamentos
        private Farmaco crearAntidepresivo(String monodroga, double precio, double dosis, int cantidad, Scanner scanner) {
            // Datos específicos para antidepresivo
            System.out.println("Seleccione el tipo de antidepresivo:");
            System.out.println("1. ISRS");
            System.out.println("2. ISRN");
            System.out.println("3. IMAO");
            TipoAntidepresivo tipoAntidepresivo = seleccionarTipoAntidepresivo(scanner);
            System.out.print("Ingrese el efecto secundario: ");
            String efectoSecundario = scanner.nextLine();
            return new Antidepresivo(monodroga, precio, dosis, cantidad, tipoAntidepresivo, efectoSecundario);
        }

        private Farmaco crearAnsiolitico(String monodroga, double precio, double dosis, int cantidad, Scanner scanner) {
            // Datos específicos para ansiolítico
            System.out.println("Seleccione el nivel de dependencia:");
            System.out.println("1. ALTA");
            System.out.println("2. MEDIA");
            System.out.println("3. BAJA");
            Dependencia dependencia = seleccionarDependencia(scanner);
            System.out.print("¿Es trazable? (true/false): ");
            boolean trazabilidad = scanner.nextBoolean();
            return new Ansiolitico(monodroga, precio, dosis, cantidad, dependencia, trazabilidad);
        }

        private Farmaco crearAntiepileptico(String monodroga, double precio, double dosis, int cantidad, Scanner scanner) {
            // Datos específicos para antiepiléptico
            System.out.println("Seleccione la clasificación de antiepiléptico:");
            System.out.println("1. CARBOXAMIDAS");
            System.out.println("2. TRIAZINAS");
            ClasificacionAntiepileptico clasificacion = seleccionarClasificacionAntiepileptico(scanner);
            System.out.println("Seleccione el tipo de receta:");
            System.out.println("1. CONTROLADA");
            System.out.println("2. NO_CONTROLADA");
            TipoReceta tipoReceta = seleccionarTipoReceta(scanner);
            return new Antiepileptico(monodroga, precio, dosis, cantidad, clasificacion, tipoReceta);
        }

        // Métodos para seleccionar enumeraciones

        private TipoAntidepresivo seleccionarTipoAntidepresivo(Scanner scanner) {
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (tipo) {
                case 1:
                    return TipoAntidepresivo.ISRS;
                case 2:
                    return TipoAntidepresivo.ISRN;
                case 3:
                    return TipoAntidepresivo.IMAO;
                default:
                    System.out.println("Selección inválida, se asignará ISRS por defecto.");
                    return TipoAntidepresivo.ISRS;
            }
        }

        private Dependencia seleccionarDependencia(Scanner scanner) {
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (tipo) {
                case 1:
                    return Dependencia.ALTA;
                case 2:
                    return Dependencia.MEDIA;
                case 3:
                    return Dependencia.BAJA;
                default:
                    System.out.println("Selección inválida, se asignará ALTA por defecto.");
                    return Dependencia.ALTA;
            }
        }

        private ClasificacionAntiepileptico seleccionarClasificacionAntiepileptico(Scanner scanner) {
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (tipo) {
                case 1:
                    return ClasificacionAntiepileptico.CARBOXAMIDAS;
                case 2:
                    return ClasificacionAntiepileptico.TRIAZINAS;
                default:
                    System.out.println("Selección inválida, se asignará CARBOXAMIDAS por defecto.");
                    return ClasificacionAntiepileptico.CARBOXAMIDAS;
            }
        }

        private TipoReceta seleccionarTipoReceta(Scanner scanner) {
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (tipo) {
                case 1:
                    return TipoReceta.CONTROLADA;
                case 2:
                    return TipoReceta.NORMAL;
                default:
                    System.out.println("Selección inválida, se asignará CONTROLADA por defecto.");
                    return TipoReceta.CONTROLADA;
            }
        }

        // Método para mostrar todos los medicamentos en la farmacia
        public void mostrarMedicamentos(Farmacia farmacia) {
            if (farmacia.getMedicamentos().isEmpty()) {
                System.out.println("No hay medicamentos en el inventario.");
            } else {
                System.out.println("Medicamentos en el inventario de la farmacia " + farmacia.getNombre() + ":");
                for (Farmaco farmaco : farmacia.getMedicamentos()) {
                    farmaco.mostrarInfo();
                }
            }
        }
}
