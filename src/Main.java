import model.App;
import model.Proceso;
import model.Usuario;
import resources.ListaSimple;

public class Main {

    public static void main(String[] args) {

        Proceso proceso = new Proceso("1","Proceso 1",null,1,1);
        Proceso proceso1 = new Proceso("2","Proceso 2",null,1,1);

        Proceso proceso2 = new Proceso("3","Proceso 3",null,1,1);
        ListaSimple<Proceso> listaProcesos = new ListaSimple<>();
        listaProcesos.agregarInicio(proceso);
        listaProcesos.agregarInicio(proceso1);
        listaProcesos.agregarInicio(proceso2);

        ListaSimple<Usuario> listaUsuarios = new ListaSimple<>();

        App app = new App(listaProcesos,listaUsuarios);

        app.crearProceso("0","Proceso 0",null,1,1);

        listaProcesos.imprimirLista();
    }






}








