import model.*;
import resources.Cola;
import resources.ListaDoble;
import resources.ListaSimple;

public class Main {

    public static void main(String[] args) throws Exception {

        ListaDoble<Actividad> actividades = new ListaDoble<>();
        ListaSimple<Proceso> procesos = new ListaSimple<>();

        App app = new App();

       Proceso proceso = app.crearProceso("1", "Proceso 1", 1, 2);
       Proceso proceso2 = app.crearProceso("2","proceso 2",2,5);

       procesos.agregarInicio(proceso);
       procesos.agregarInicio(proceso2);

       procesos.imprimirLista();


       app.eliminarProceso(proceso2);

       procesos.imprimirLista();



       Actividad actividad = proceso.crearActividad("Actividad 1", "Descripcion 1", true);

       Actividad actividad1 = new Actividad("Actividad2","Descripcion A2",false);

       Actividad actividad2 = proceso.crearActividad("Actividad 3", "Descripcion A3", true);

       actividades.agregarInicio(actividad);
       actividades.agregarInicio(actividad2);

       proceso.eliminarActividad(actividad2);

       actividades.imprimirLista();

    }




}








