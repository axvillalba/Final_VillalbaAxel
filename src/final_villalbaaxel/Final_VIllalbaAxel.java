
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
        Farmaco antidep = new Antidepresivo("Fluoxetina", 100.0, 20.0, 15, TipoAntidepresivo.ISRS, "Somnolencia");
        farmacia.agregarMedicamento(antidep);

        // Agregar otro medicamento
        Farmaco ansiol = new Ansiolitico("Alprazolam", 150.0, 0.5, 20, Dependencia.ALTA, true);
        farmacia.agregarMedicamento(ansiol);
// Agregar un medicamento antiepiléptico de primera línea
        Farmaco antiepileptico1 = new Antiepileptico    ("Valproato", 180.0, 200.0, 18, ClasificacionAntiepileptico.CARBOXAMIDAS, TipoReceta.CONTROLADA);  // Tratamiento primario
        farmacia.agregarMedicamento(antiepileptico1);

        // Agregar un medicamento antiepiléptico de segunda línea
        Farmaco antiepileptico2 = new Antiepileptico("Lamotrigina", 220.0, 50.0, 25, ClasificacionAntiepileptico.TRIAZINAS, TipoReceta.CONTROLADA);
        farmacia.agregarMedicamento(antiepileptico2);

        // Mostrar todos los medicamentos
        for (Farmaco farmaco : farmacia.getMedicamentos()) {
                  farmaco.mostrarInfo();
        }
    }
}

//Para mejorar: agregar setters necesarios, modificar metodos con el for y varios return (utilizar el simple)
//Cambiar las List por ArrayList... Si el for tiene que mostrar es decir recorrerlo en su totalidad está bien 
//usar el foreach, en cambio si es para buscar un valor y cortarlo es preferible usar el for con un while que se
//encargue de cortarlo 


