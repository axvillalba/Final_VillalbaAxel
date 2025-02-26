package final_villalbaaxel;

import java.util.*;
import javax.xml.transform.sax.SAXSource;

public class FarmaciaGestion {

    // Método para gestionar la farmacia y mostrar sus medicamentos
    public void gestionarFarmacia(Farmacia farmacia) {
        try {
            System.out.println("Gestionando la farmacia: " + farmacia.getNombre());
            mostrarMedicamentos(farmacia);
        } catch (Exception e) {
            System.out.println("Error al gestionar la farmacia: " + e.getMessage());
        }
    }

    // Método para agregar un medicamento a la farmacia
    public void agregarMedicamento(Farmacia farmacia, Farmaco medicamento) {
        try {
            if (!farmacia.getMedicamentos().contains(medicamento)) {
                farmacia.getMedicamentos().add(medicamento);
                System.out.println("Medicamento agregado: " + medicamento.getMonodroga());
            } else {
                System.out.println("Este medicamento ya existe en el inventario.");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar medicamento: " + e.getMessage());
        }
    }

    // Método para buscar un medicamento por su código
    public Farmaco buscarMedicamentoPorCodigo(Farmacia farmacia, String codigo) {
        try {
            for (Farmaco medicamento : farmacia.getMedicamentos()) {
                if (medicamento.getCodigo().equals(codigo)) {
                    return medicamento;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar medicamento por codigo: " + e.getMessage());
        }
        return null; // No encontrado
    }

    // Método para modificar un medicamento
    public void modificarMedicamento(Farmacia farmacia, String codigoModificar) {
        try {
            Farmaco medicamentoExistente = buscarMedicamentoPorCodigo(farmacia, codigoModificar);
            if (medicamentoExistente != null) {
                // Eliminar el medicamento existente
                this.eliminarMedicamento(farmacia, codigoModificar);
                // Pedir los nuevos datos y crear el nuevo medicamento
                Scanner scanner = new Scanner(System.in);
                System.out.println("Modificar medicamento: " + medicamentoExistente.getMonodroga());
                Farmaco nuevoMedicamento = obtenerDatosMedicamento(scanner, farmacia, codigoModificar);
                // Agregar el nuevo medicamento a la farmacia
                farmacia.agregarMedicamento(nuevoMedicamento);
                System.out.println("Medicamento modificado exitosamente.");
            } else {
                System.out.println("Medicamento con código " + codigoModificar + " no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el medicamento: " + e.getMessage());
        }
    }

    // Método para eliminar un medicamento
    public void eliminarMedicamento(Farmacia farmacia, String codigoEliminar) {
        try {
            Farmaco medicamento = buscarMedicamentoPorCodigo(farmacia, codigoEliminar);
            if (medicamento != null) {
                farmacia.getMedicamentos().remove(medicamento);
                System.out.println("Medicamento " + medicamento.getMonodroga() + " eliminado.");
            } else {
                System.out.println("Medicamento con codigo " + codigoEliminar + " no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar medicamento: " + e.getMessage());
        }
    }

    // Método para listar todos los medicamentos
    public void listarMedicamentos(Farmacia farmacia) {
        try {
            if (farmacia.getMedicamentos().isEmpty()) {
                System.out.println("No hay medicamentos en el inventario.");
            } else {
                System.out.println("Lista de medicamentos en la farmacia " + farmacia.getNombre() + ":");
                for (Farmaco farmaco : farmacia.getMedicamentos()) {
                    farmaco.mostrarInfo();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar medicamentos: " + e.getMessage());
        }
    }

    // Método para consultar un medicamento por código
    public void consultarMedicamento(Farmacia farmacia, String codigoConsultar) {
        try {
            Farmaco medicamento = buscarMedicamentoPorCodigo(farmacia, codigoConsultar);
            if (medicamento != null) {
                System.out.println("Consulta del medicamento: ");
                medicamento.mostrarInfo();
            } else {
                System.out.println("Medicamento con código " + codigoConsultar + " no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al consultar medicamento: " + e.getMessage());
        }
    }

    // Método para obtener los datos de un medicamento
    public Farmaco obtenerDatosMedicamento(Scanner scanner, Farmacia farmacia, String codigo) {
        try {
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

            // Crear el medicamento según tipo
            Farmaco nuevoMedicamento = null;
            switch (tipoMedicamento) {
                case 1:
                    nuevoMedicamento = crearAntidepresivo(codigo, monodroga, precio, dosis, cantidad, scanner, farmacia);
                    break;
                case 2:
                    nuevoMedicamento = crearAnsiolitico(codigo, monodroga, precio, dosis, cantidad, scanner, farmacia);
                    break;
                case 3:
                    nuevoMedicamento = crearAntiepileptico(codigo, monodroga, precio, dosis, cantidad, scanner, farmacia);
                    break;
                default:
                    System.out.println("Tipo de medicamento no válido.");
                    break;
            }
            return nuevoMedicamento;
        } catch (Exception e) {
            System.out.println("Error al obtener datos del medicamento: " + e.getMessage());
        }
        return null;
    }

    // Métodos para crear tipos específicos de medicamentos
    private Farmaco crearAntidepresivo(String codigo, String monodroga, double precio, double dosis, int cantidad, Scanner scanner, Farmacia farmacia) {
        try {
            // Datos específicos para antidepresivo
            System.out.println("Seleccione el tipo de antidepresivo:");
            System.out.println("1. ISRS");
            System.out.println("2. ISRN");
            System.out.println("3. ATIPICOS");
            TipoAntidepresivo tipoAntidepresivo = seleccionarTipoAntidepresivo(scanner);
            System.out.print("Ingrese el efecto secundario: ");
            String efectoSecundario = scanner.nextLine();

            return new Antidepresivo(codigo, monodroga, precio, dosis, cantidad, tipoAntidepresivo, efectoSecundario);
        } catch (Exception e) {
            System.out.println("Error al crear antidepresivo: " + e.getMessage());
        }
        return null;
    }

    private Farmaco crearAnsiolitico(String codigo, String monodroga, double precio, double dosis, int cantidad, Scanner scanner, Farmacia farmacia) {
        try {
            // Datos específicos para ansiolítico
            System.out.println("Seleccione el nivel de dependencia:");
            System.out.println("1. ALTA");
            System.out.println("2. MEDIA");
            System.out.println("3. BAJA");
            Dependencia dependencia = seleccionarDependencia(scanner);
            System.out.print("¿Es trazable? (true/false): ");
            boolean trazabilidad = scanner.nextBoolean();

            return new Ansiolitico(codigo, monodroga, precio, dosis, cantidad, dependencia, trazabilidad);
        } catch (Exception e) {
            System.out.println("Error al crear ansiolítico: " + e.getMessage());
        }
        return null;
    }

    private Farmaco crearAntiepileptico(String codigo, String monodroga, double precio, double dosis, int cantidad, Scanner scanner, Farmacia farmacia) {
        try {
            // Datos específicos para antiepiléptico
            System.out.println("Seleccione la clasificación de antiepileptico:");
            System.out.println("1. CARBOXAMIDAS");
            System.out.println("2. TRIAZINAS");
            System.out.println("3. BENZODIAZEPINAS");
            System.out.println("4. BARBITURICO");
            System.out.println("5. BROMUROS");
            ClasificacionAntiepileptico clasificacion = seleccionarClasificacionAntiepileptico(scanner);
            System.out.println("Seleccione el tipo de receta:");
            System.out.println("1. CONTROLADA");
            System.out.println("2. NORMAL");
            TipoReceta tipoReceta = seleccionarTipoReceta(scanner);

            return new Antiepileptico(codigo, monodroga, precio, dosis, cantidad, clasificacion, tipoReceta);
        } catch (Exception e) {
            System.out.println("Error al crear antiepileptico: " + e.getMessage());
        }
        return null;
    }

    // Métodos para seleccionar enumeraciones
    private TipoAntidepresivo seleccionarTipoAntidepresivo(Scanner scanner) {
        int tipo = -1;
        boolean entradaValida = false;

        // Bucle hasta que se ingrese una opción válida
        while (!entradaValida) {
            try {
                tipo = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (tipo >= 1 && tipo <= 3) {
                    entradaValida = true;  // Opción válida, salir del bucle
                } else {
                    System.out.println("Opción no valida. Debe ser un número entre 1 y 3.");
                }
            } catch (InputMismatchException e) {
                // Captura la excepción si se ingresa un dato no numérico
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar el buffer para que no quede el valor inválido
            }
        }

        // Devuelve el tipo de antidepresivo según la opción seleccionada
        switch (tipo) {
            case 1:
                return TipoAntidepresivo.ISRS;
            case 2:
                return TipoAntidepresivo.ISRN;
            case 3:
                return TipoAntidepresivo.ATIPICOS;
            default:
                // Aunque este caso no debería alcanzarse debido a la validación anterior
                return null;
        }
    }

    private Dependencia seleccionarDependencia(Scanner scanner) {
        int tipo = -1;
        boolean entradaValida = false;

        // Bucle hasta que se ingrese una opción válida
        while (!entradaValida) {
            try {
                tipo = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (tipo >= 1 && tipo <= 3) {
                    entradaValida = true;  // Opción válida, salir del bucle
                } else {
                    System.out.println("Opción no valida. Debe ser un numero entre 1 y 3.");
                }
            } catch (InputMismatchException e) {
                // Captura la excepción si se ingresa un dato no numérico
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar el buffer para que no quede el valor inválido
            }
        }

        // Devuelve la dependencia según el tipo seleccionado
        switch (tipo) {
            case 1:
                return Dependencia.ALTA;
            case 2:
                return Dependencia.MEDIA;
            case 3:
                return Dependencia.BAJA;
            default:
                // Aunque este caso no debería alcanzarse debido a la validación anterior
                return null;
        }
    }

    private ClasificacionAntiepileptico seleccionarClasificacionAntiepileptico(Scanner scanner) {
        int tipo = -1;
        boolean entradaValida = false;
        // Bucle hasta que se ingrese una opción válida
        while (!entradaValida) {
            try {
                tipo = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (tipo >= 1 && tipo <= 5) {
                    entradaValida = true;  // Opción válida, salir del bucle
                } else {
                    System.out.println("Opcion no valida. Debe ser un numero entre 1 y 5.");
                }
            } catch (InputMismatchException e) {
                // Captura la excepción si se ingresa un dato no numérico
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar el buffer para que no quede el valor inválido
            }
        }
        // Devuelve la clasificación según el valor ingresado
        switch (tipo) {
            case 1:
                return ClasificacionAntiepileptico.CARBOXAMIDAS;
            case 2:
                return ClasificacionAntiepileptico.TRIAZINAS;
            case 3:
                return ClasificacionAntiepileptico.BENZODIAZEPINAS;
            case 4:
                return ClasificacionAntiepileptico.BARBITURICO;
            case 5:
                return ClasificacionAntiepileptico.BROMUROS;
            default:
                // Aunque este caso no debería alcanzarse debido a la validación anterior
                return null;
        }
    }

    private TipoReceta seleccionarTipoReceta(Scanner scanner) {
        int tipo = -1;
        boolean entradaValida = false;

        // Bucle hasta que se ingrese una opción válida para el tipo de receta
        while (!entradaValida) {
            try {
                tipo = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (tipo == 1) {
                    entradaValida = true;
                    return TipoReceta.CONTROLADA;
                } else if (tipo == 2) {
                    entradaValida = true;
                    return TipoReceta.NORMAL;
                } else {
                    System.out.println("Opcion no valida. Debe ser 1 (CONTROLADA) o 2 (NORMAL).");
                }
            } catch (InputMismatchException e) {
                // Captura la excepción si se ingresa un dato no numérico
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        return null;  // Este caso no debería alcanzarse debido a la validación
    }

    // Método para mostrar todos los medicamentos en la farmacia
    public void mostrarMedicamentos(Farmacia farmacia) {
        try {
            if (farmacia.getMedicamentos().isEmpty()) {
                System.out.println("No hay medicamentos en el inventario.");
            } else {
                System.out.println("Medicamentos en el inventario de la farmacia " + farmacia.getNombre() + ":");
                for (Farmaco farmaco : farmacia.getMedicamentos()) {
                    farmaco.mostrarInfo();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar medicamentos: " + e.getMessage());
        }
    }
}
