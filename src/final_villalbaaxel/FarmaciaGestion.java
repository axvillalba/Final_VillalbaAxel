package final_villalbaaxel;

import java.io.*;
import java.util.*;

public class FarmaciaGestion {

    // Método para gestionar la farmacia y mostrar sus medicamentos
    public void gestionarFarmacia(Farmacia farmacia) {
        System.out.println("Gestionando la farmacia: " + farmacia.getNombre());

        // Mostrar todos los medicamentos en la farmacia
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

    // Método para actualizar un medicamento en la farmacia
    public void actualizarMedicamento(Farmacia farmacia, int index, Farmaco medicamento) {
        if (index >= 0 && index < farmacia.getMedicamentos().size()) {
            farmacia.getMedicamentos().set(index, medicamento);
            System.out.println("Medicamento actualizado: " + medicamento.getMonodroga());
        } else {
            System.out.println("Índice no válido. No se pudo actualizar el medicamento.");
        }
    }

    // Método para eliminar un medicamento de la farmacia
    public void eliminarMedicamento(Farmacia farmacia, int index) {
        if (index >= 0 && index < farmacia.getMedicamentos().size()) {
            Medicamento medicamento = farmacia.getMedicamentos().remove(index);
            System.out.println("Medicamento eliminado: " + medicamento.getMonodroga());
        } else {
            System.out.println("Índice no válido. No se pudo eliminar el medicamento.");
        }
    }

    // Método para mostrar todos los medicamentos en la farmacia
    public void mostrarMedicamentos(Farmacia farmacia) {
        if (farmacia.getMedicamentos().isEmpty()) {
            System.out.println("No hay medicamentos en el inventario.");
        } else {
            System.out.println("Medicamentos en el inventario de la farmacia " + farmacia.getNombre() + ":");
            for (Medicamento medicamento : farmacia.getMedicamentos()) {
                medicamento.mostrarInfo();
            }
        }
    }

    // Método para exportar los medicamentos a un archivo TXT
    public void exportarMedicamentos(Farmacia farmacia) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("medicamentos.txt"))) {
            writer.write("Inventario de Medicamentos en la farmacia: " + farmacia.getNombre() + "\n");
            writer.write("--------------------------------------------\n");
            for (Medicamento medicamento : farmacia.getMedicamentos()) {
                medicamento.mostrarInfo();
                writer.write("\n");
            }
            System.out.println("Medicamentos exportados a 'medicamentos.txt'");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    // Método para buscar un medicamento por su monodroga
    public Farmaco buscarMedicamentoPorMonodroga(Farmacia farmacia, String monodroga) {
    List<Farmaco> medicamentos = farmacia.getMedicamentos(); // Obtener la lista de medicamentos
    int i = 0; // Inicializar el índice
    Farmaco medicamentoEncontrado = null; // Variable para almacenar el medicamento encontrado

    while (i < medicamentos.size()) { // Usamos while en lugar de for
        Farmaco medicamento = medicamentos.get(i); // Obtener el medicamento en el índice i
        if (medicamento.getMonodroga().equalsIgnoreCase(monodroga)) {
            medicamentoEncontrado = medicamento; // Si se encuentra, almacenamos el medicamento
            medicamento.mostrarInfo(); // Mostramos la información
            break; // Salimos del bucle una vez que encontramos el medicamento
        }
        i++; // Incrementamos el índice
    }

    if (medicamentoEncontrado == null) {
        System.out.println("Medicamento con monodroga '" + monodroga + "' no encontrado.");
    }

    return medicamentoEncontrado; // Devolvemos el medicamento encontrado o null
}


}
