package test;

import model.Actividad;
import model.Proceso;
import model.Tarea;
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

    @org.junit.jupiter.api.Test
    void intercambiarActividadesSinSusTareas() {
    }

    @org.junit.jupiter.api.Test
    void intercambiarActividadesConSusListasDeTareas() {
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