import model.Actividad;
import model.App;
import model.Proceso;
import model.Usuario;
import resources.ListaDoble;
import resources.ListaSimple;

public class Main {

    public static void main(String[] args) {

      /*  Proceso proceso = new Proceso("1","Proceso 1",null,1,1);
        Proceso proceso1 = new Proceso("2","Proceso 2",null,1,1);

        Proceso proceso2 = new Proceso("3","Proceso 3",null,1,1);
        ListaSimple<Proceso> listaProcesos = new ListaSimple<>();
        listaProcesos.agregarInicio(proceso);
        listaProcesos.agregarInicio(proceso1);
        listaProcesos.agregarInicio(proceso2);

        ListaSimple<Usuario> listaUsuarios = new ListaSimple<>();

        App app = new App();



        app.crearProceso("0","Proceso 0",null,1,1);

        listaProcesos.imprimirLista();*/

        App app = new App();
        ListaDoble<Actividad> actividads = new ListaDoble<>();
        ListaSimple<Proceso> procesos = new ListaSimple<>();

        Proceso procesox = new Proceso("4","Proceso 4",actividads,1,1);

        procesos.agregarInicio(new Proceso("1","Proceso 1",actividads,1,1));
        procesos.agregarInicio(new Proceso("2","Proceso 2",actividads,1,1));
        procesos.agregarInicio(new Proceso("3","Proceso 3",actividads,1,1));
        procesos.agregarInicio(procesox);

        String id = "10";
        String nombre = "Proceso 10";
        int tiempoMinutos = 1;
        int tiempoMaximo = 1;

        Proceso proceso = new Proceso(id,nombre,actividads,tiempoMinutos,tiempoMaximo);
        app.crearProceso(id,nombre,actividads,tiempoMinutos,tiempoMaximo);
        procesos.agregarInicio(proceso);
        System.out.println(proceso);

     procesos.imprimirLista();
     app.eliminarProceso(proceso);

        procesos.imprimirLista();



    }






}








