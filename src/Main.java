import model.*;
import resources.Cola;
import resources.ListaDoble;
import resources.ListaSimple;

public class Main {

    public static void main(String[] args) throws Exception {

        App app = new App();
        // Suponiendo que tienes una instancia de listaProcesos
        ListaDoble<Proceso> listaProcesos = new ListaDoble<>();

        // Suponiendo que tienes instancias de Proceso, Actividad y Tarea
        Proceso proceso = new Proceso ("001", "Proceso 1", 5, 10);
        Actividad actividad = new Actividad("Actividad 1", "Descripción de la actividad 1", true);
        Tarea tarea = new Tarea("Tarea 1", "Descripción de la tarea 1", true);

        // Luego agregas los procesos, actividades y tareas a tu lista de procesos

        // Llamada al método insertarTareaAlFinal
        Main main = new Main();
        Tarea tareaInsertada = app.insertarTareaAlFinal(proceso, actividad, tarea);

        if (tareaInsertada != null) {
            System.out.println("Tarea insertada exitosamente.");
        } else {
            System.out.println("No se pudo insertar la tarea.");
        }
    }




}








