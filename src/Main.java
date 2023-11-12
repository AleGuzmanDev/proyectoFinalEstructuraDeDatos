import model.*;
import resources.Cola;
import resources.ListaSimple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ListaSimple procesos = new ListaSimple();

        ListaSimple usuarios = new ListaSimple();

        ListaSimple<Actividad> actividades = new ListaSimple<>();

        Cola <Tarea>tareas = new Cola<>();
        Actividad actividad = new Actividad("Evaluaciones","Evaluar",true,tareas);
        Actividad actividad2 = new Actividad("Proyectos", "Desarrollar", true,tareas);
        Actividad actividad3 = new Actividad("Presentaciones", "Presentar", true,tareas);
        Actividad actividad4 = new Actividad("Investigación", "Investigar", false,tareas);

        actividades.agregarFinal(actividad);
        actividades.agregarFinal(actividad2);
        actividades.agregarFinal(actividad3);
        actividades.agregarFinal(actividad4);



        Usuario usuario1 = new Usuario("alejaguz", "1234", Rol.ADMINISTRADOR);
        Usuario usuario2 = new Usuario("juanito", "clave5678", Rol.USUARIO_REGULAR);
        Usuario usuario3 = new Usuario("maria33", "passWord789", Rol.USUARIO_REGULAR);
        Usuario usuario4 = new Usuario("carlitos", "secreto4321", Rol.USUARIO_REGULAR);

        usuarios.agregarFinal(usuario1);
        usuarios.agregarFinal(usuario2);
        usuarios.agregarFinal(usuario3);
        usuarios.agregarFinal(usuario4);


        App app = new App(procesos, usuarios);
       /* System.out.println("Ingresa Usuario");
        String user = new Scanner(System.in).nextLine();
        System.out.println("Ingresa contraseña");
        String pass = new Scanner(System.in).nextLine();
        Usuario usuario = new Usuario(user, pass, Rol.ADMINISTRADOR);

        app.iniciarSesion(usuario);*/

      // app.crearProceso("001","Gestion de calidad",actividades,5,10);

        Proceso proceso = new Proceso("001","Gestion de calidad",actividades,5,10);
        Proceso proceso1 = new Proceso("002", "Desarrollo de software", actividades, 8, 15);
        Proceso proceso2 = new Proceso("003", "Campaña de marketing", actividades, 7, 12);
        Proceso proceso3 = new Proceso("004", "Logística de distribución", actividades, 6, 10);
        Proceso proceso4 = new Proceso("005", "Investigación y desarrollo", actividades, 9, 20);
        Proceso proceso5 = new Proceso("006", "Gestión de recursos humanos", actividades, 4, 8);




        Tarea tarea = new Tarea("Calificar","Dar una calificación",true);
        Tarea tarea1 = new Tarea("Revisar código", "Revisar el código fuente del proyecto", true);
        Tarea tarea2 = new Tarea("Actualizar informes", "Actualizar los informes mensuales", false);
        Tarea tarea3 = new Tarea("Entrenamiento", "Participar en sesiones de entrenamiento", true);
        Tarea tarea4 = new Tarea("Investigación", "Realizar investigación sobre tendencias del mercado", false);


        tareas.encolar(tarea);
        tareas.encolar(tarea1);
        tareas.encolar(tarea2);
        tareas.encolar(tarea3);

        app.insertarTareaAlFinal(proceso,actividad, tarea4);
        tareas.imprimir();
        procesos.agregarFinal(proceso);
        procesos.agregarFinal(proceso1);
        procesos.agregarFinal(proceso2);
        procesos.agregarFinal(proceso3);
        procesos.agregarFinal(proceso4);
        procesos.agregarFinal(proceso5);



        double tiempoDuracion = app.consultarTiempoDuracionProceso(proceso);

        // Imprimir el resultado
        System.out.println("El tiempo de duración del proceso es: " + tiempoDuracion);




        // Crear una instancia de la lista de procesos
        ListaSimple<Proceso> listaProcesos = new ListaSimple<>();

        // Crear instancias de Tarea, Proceso y Actividad
        Tarea tareaNueva = new Tarea("Tarea1", "Descripción de la Tarea1", true);



        // Agregar la actividad al proceso
        proceso.getListaActividades().agregarFinal(actividad);

        // Llamar al método para insertar la tarea
       // app.insertarTareaAlFinal( proceso, actividad, tareaNueva);

        // Imprimir el estado actual de la lista de procesos y actividades
        listaProcesos.imprimirLista();


        app.insertarTareaAlFinal(proceso,actividad,tareaNueva);
        tareas.imprimir();

        Usuario usuario = new Usuario("maria","0001",Rol.ADMINISTRADOR);
        usuarios.agregarFinal(usuario1);


       app.crearCuentasDeUsuario("alejaguz","1234",Rol.ADMINISTRADOR);

     //  app.iniciarSesion(usuario1);
      //  app.iniciarSesion(usuario);

        Actividad resultado1 = proceso.buscarActividad(actividad);
        Actividad resultado2 = proceso.buscarActividad(new Actividad("A1","Ninguna",true,tareas));

        // Imprimir resultados
        System.out.println("¿Actividad1 encontrada?: " + resultado1);
        System.out.println("¿ActividadNoExistente encontrada?: " + resultado2);

        Tarea tare = proceso.buscarTarea(actividad,tarea2);
        Tarea tare1 = proceso.buscarTarea(actividad,new Tarea ("Tareita","Una tarea",true));

        System.out.println("¿Actividad1 encontrada?: " + tarea);
        System.out.println("¿ActividadNoExistente encontrada?: " + tarea1);

    }





}