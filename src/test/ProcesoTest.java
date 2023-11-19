package test;

import model.Actividad;
import model.Proceso;
import model.Tarea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import resources.Cola;
import resources.ListaDoble;

import static org.junit.jupiter.api.Assertions.*;

class ProcesoTest {

    @org.junit.jupiter.api.Test
    void buscarActividad() {

        Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);
        Actividad actividad = proceso.crearActividad("Actividad 1", "Descripcion 1", true);
        Actividad actividad2 = proceso.crearActividad("Actividad 2", "Descripcion 2", true);
        Actividad actividad3 = proceso.crearActividad("Actividad 3", "Descripcion 3", true);
        Actividad actividad4 = proceso.crearActividad("Actividad 4", "Descripcion 4", true);


        Actividad actividadEncontrada = proceso.buscarActividad(actividad);

        System.out.println(actividad);

        assertNotNull(actividad);

        assertEquals(actividad,actividadEncontrada);

    }

    @org.junit.jupiter.api.Test
    void buscarTarea() {

        Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);

        String nombre = "Actividad 1";
        proceso.crearActividad(nombre, "Descripcion 1", true);

        Tarea tarea = new Tarea("Tarea 1", "Descripcion Tarea", true);
        Actividad actividadActualizar = new Actividad(nombre, "Descripcion actualizada", true);
        actividadActualizar.getTareas().encolar(tarea);

        Actividad actividadActualizada = proceso.actualizarActividad(actividadActualizar, nombre);

        Actividad actividadEncontrada =  proceso.buscarActividad(actividadActualizada);

        assertNotNull(proceso.buscarTarea(actividadEncontrada, actividadEncontrada.getTareas().getPrimero().getValorNodo()));

    }
        @Test
        public void intercambiarActividadesSinSusTareas() {

            Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);
            ListaDoble<Actividad> actividades = proceso.getListaActividades();
            // Crear una lista enlazada de actividades

            Actividad actividad1 = new Actividad("Actividad 1", "Descripción 1", true);
            Actividad actividad2 = new Actividad("Actividad 2", "Descripción 2", true);

            actividades.agregarInicio(actividad1);
            actividades.agregarFinal(actividad2);

            System.out.println("Antes del intercambio:");
            actividades.imprimirLista();

            // Llamar al método para intercambiar actividades
            proceso.intercambiarActividadesSinSusTareas(actividad1,actividad2);

            System.out.println("Después del intercambio:");
            actividades.imprimirLista();

            // Verificar si el intercambio se realizó correctamente
            assertEquals("Actividad 2", actividades.obtenerValorNodo(0).getNombre());
            assertEquals("Actividad 1", actividades.obtenerValorNodo(1).getNombre());
        }


    @Test
    public void testIntercambiarActividadesConTareas() {

        Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);
        Actividad actividad1 = proceso.crearActividad("Actividad 1", "Descripción 1", true);
        Actividad actividad2 = proceso.crearActividad("Actividad 2", "Descripción 2", true);

        proceso.getListaActividades().agregarInicio(actividad1);
        proceso.getListaActividades().agregarFinal(actividad2);

        actividad1.getTareas().encolar(new Tarea("Tarea 1", "Descripción 1", true));
        actividad1.getTareas().encolar(new Tarea("Tarea 2", "Descripción 2", true));

        actividad2.getTareas().encolar(new Tarea("Tarea 3", "Descripción 3", true));
        actividad2.getTareas().encolar(new Tarea("Tarea 4", "Descripción 4", true));

        proceso.getListaActividades().imprimirLista();

        proceso.intercambiarActividadesConTareas(actividad1, actividad2);

        proceso.getListaActividades().imprimirLista();

        // Verificar que las tareas se hayan intercambiado correctamente
        Assertions.assertEquals(2, actividad1.getTareas().getTamano());
        Assertions.assertEquals(2, actividad2.getTareas().getTamano());
        // Añadir más aserciones según tu implementación y lo que esperas que cambie

        // Verificar que las actividades se hayan intercambiado en la lista
        Assertions.assertEquals(actividad1, proceso.getListaActividades().obtener(1));
        Assertions.assertEquals(actividad2, proceso.getListaActividades().obtener(0));
    }

    @org.junit.jupiter.api.Test
    void crearActividad() {

        ListaDoble<Actividad> actividades = new ListaDoble<>();
        String nombre = "Actividad4";
        String descripcion = "Descripcion cuarta actividad";
        boolean obligatoriedad = true;

        Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);
        Actividad nuevaActividad = proceso.crearActividad(nombre, descripcion, obligatoriedad);


        actividades.agregarInicio(nuevaActividad);

        actividades.imprimirLista();
        // Asegurar que la nueva actividad no sea nula
        assertNotNull(nuevaActividad);

        // Asegurar que los atributos de la nueva actividad sean iguales a los esperados
        assertEquals(nombre, nuevaActividad.getNombre());
        assertEquals(descripcion, nuevaActividad.getDescripcion());
        assertEquals(obligatoriedad, nuevaActividad.isObligatoriedad());



    }

    @org.junit.jupiter.api.Test
    void eliminarActividad() {

        Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);

        Actividad actividad = proceso.crearActividad("Actividad 1", "Descripcion 1", true);
        proceso.crearActividad("Actividad 2", "Descripcion 2", true);
        proceso.crearActividad("Actividad 3", "Descripcion 3", true);

        proceso.eliminarActividad(actividad);
        proceso.getListaActividades().imprimirLista();

        assertEquals(proceso.getListaActividades().getTamano(), 2);
    }

    @org.junit.jupiter.api.Test
    void actualizarActividad() {

        Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);

        String nombre = "Actividad 1";
        proceso.crearActividad(nombre, "Descripcion 1", true);

        Actividad actividadActualizar = new Actividad(nombre, "Descripcion actualizada", true);

        Actividad acti = proceso.actualizarActividad(actividadActualizar, nombre );


        assertEquals(acti.getDescripcion(), "Descripcion actualizada");




    }

    @org.junit.jupiter.api.Test
    void crearActividadAlFinal() {
    }

    @org.junit.jupiter.api.Test
    void crearDespuesDeUltimo() {
    }

    @org.junit.jupiter.api.Test
    void crearActividadPosicionDeterminada() {
    }
}