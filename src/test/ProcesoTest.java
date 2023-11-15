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
    }

    @org.junit.jupiter.api.Test
    void buscarTarea() {
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
        Cola<Tarea> tareas = new Cola<>();
        Tarea tarea1 = new Tarea("Tarea1", "Descripcion primera tarea", true);
        Tarea tarea2 = new Tarea("Tarea2", "Descripcion segunda tarea", false);
        Tarea tarea3 = new Tarea("Tarea3", "Descripcion tercera tarea", true);
        tareas.encolar(tarea1);
        tareas.encolar(tarea2);
        tareas.encolar(tarea3);

        String nombre = "Actividad4";
        String descripcion = "Descripcion cuarta actividad";
        boolean obligatoriedad = true;

        Proceso proceso = new Proceso("001", "Proceso 1", 5, 10);
        Actividad nuevaActividad = proceso.crearActividad(nombre, descripcion, obligatoriedad);

// Asegurar que la nueva actividad no sea nula
        assertNotNull(nuevaActividad);

// Asegurar que los atributos de la nueva actividad sean iguales a los esperados
        assertEquals(nombre, nuevaActividad.getNombre());
        assertEquals(descripcion, nuevaActividad.getDescripcion());
        assertEquals(obligatoriedad, nuevaActividad.isObligatoriedad());

// Asegurar que las tareas de la nueva actividad sean iguales a las esperadas
        assertEquals(tareas, nuevaActividad.getTareas());

    }

    @org.junit.jupiter.api.Test
    void eliminarActividad() {
    }

    @org.junit.jupiter.api.Test
    void actualizarActividad() {
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