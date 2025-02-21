
package final_villalbaaxel;



import java.util.Scanner;
public class Final_VIllalbaAxel {

    public static void main(String[] args) {
        // Crear una farmacia con un nombre
        Farmacia farmacia = new Farmacia("Farmacia UTN Salud");

        // Crear un objeto FarmaciaGestion para gestionar la farmacia
        FarmaciaGestion gestion = new FarmaciaGestion();

        // Gestionar la farmacia
        farmacia.gestionarMedicamentos(gestion);

        // Agregar un medicamento manualmente
        Farmaco antidep = new Antidepresivo("Fluoxetina", 100.0, 20.0, 15, Antidepresivo.Tipo.SINTOMÁTICO, "Somnolencia");
        farmacia.agregarMedicamento(antidep);

        // Agregar otro medicamento
        Farmaco ansiol = new Ansiolitico("Alprazolam", 150.0, 0.5, 20, Ansiolitico.Dependencia.ALTA, true);
        farmacia.agregarMedicamento(ansiol);

        // Mostrar todos los medicamentos
        for (Farmaco farmaco : farmacia.getMedicamentos()) {
                  farmaco.mostrarInfo();
        }
    }
}

