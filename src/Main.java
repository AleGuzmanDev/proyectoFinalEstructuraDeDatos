import model.Actividad;
import model.App;
import model.Proceso;
import model.Usuario;
import resources.ListaDoble;
import resources.ListaSimple;

public class Main {

    public static void main(String[] args) throws Exception {

      /*  ListaDoble<Actividad> actividades = new ListaDoble<>();
        App app = new App();
        Proceso proceso = new Proceso("001","Proceso 1",5,10);
        app.crearProceso("001","Proceso 1",5,10);

        Proceso proceso2 = new Proceso("001","Proceso 2",5,10);

       // app.actualizarProceso(proceso2,"001");
        System.out.println(app.actualizarProceso(proceso2,"001"));

       // app.eliminarProceso(proceso);

      //  System.out.println(proceso2.crearActividad("001","Actividad 1",true));
        Actividad actividad = new Actividad("001","Actividad 1",true);
        actividades.agregarInicio(actividad);
        Actividad actividad1 = new Actividad("002","Actividad 2",true);

        actividades.agregarInicio(actividad1);
        System.out.println(actividad);
     //   actividades.imprimirLista();

        Actividad actividad2 = new Actividad("003","Actividad 3",true);
        proceso.actualizarActividad(actividad2,"001");

        System.out.println(actividad);

        actividades.agregarInicio(actividad2);

        proceso.actualizarActividad(actividad2,"001");

        // actividades.imprimirLista();

*/
                // Crear una lista de actividades y agregar algunas actividades de ejemplo
                ListaDoble<Actividad> listaActividades = new ListaDoble<>();


                Actividad actividad1 = new Actividad("Actividad1", "Descripción primera actividad", true);
                Actividad actividad2 = new Actividad("Actividad2", "Descripción segunda actividad", false);

                listaActividades.agregarInicio(actividad1);
                listaActividades.agregarInicio(actividad2);

                // Crear un proceso con la lista de actividades
                Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);

                // Imprimir la lista de actividades antes de la actualización
                System.out.println("Lista de actividades antes de la actualización:");
                listaActividades.imprimirLista();

                // Crear una nueva actividad para la actualización
                Actividad nuevaActividad = new Actividad("Actividad2", "Nueva descripción", true);

                // Actualizar la actividad
                proceso.actualizarActividad(nuevaActividad, "Actividad2");

                // Imprimir la lista de actividades después de la actualización
                System.out.println("\nLista de actividades después de la actualización:");
                listaActividades.imprimirLista();





    }




}








