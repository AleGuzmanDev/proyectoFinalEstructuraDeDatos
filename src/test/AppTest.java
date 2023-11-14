package test;

import model.Actividad;
import model.App;
import model.Proceso;
import org.junit.jupiter.api.Test;
import resources.ListaDoble;
import resources.ListaSimple;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void iniciarSesion() {

    }

    @Test
    void crearProceso() {


        App app = new App();
        ListaDoble<Actividad> actividads = new ListaDoble<>();

        String id = "001";
        String nombre = "Proceso 1";
        int tiempoMinutos = 5;
        int tiempoMaximo = 10;

        Proceso proceso = app.crearProceso(id,nombre,actividads,tiempoMinutos,tiempoMaximo);

        assertNotNull(proceso);
        assertEquals(id,proceso.getId());
        assertEquals(nombre,proceso.getNombre());
        assertEquals(tiempoMinutos,proceso.getTiempoMinimo());
        assertEquals(tiempoMaximo,proceso.getTiempoMaximo());
        assertEquals(actividads,proceso.getListaActividades());

    }

    @Test
    void eliminarProceso() {

            App app = new App();

            // Crear un proceso para probar su eliminación
            String id = "001";
            String nombre = "Proceso de prueba";
            ListaDoble<Actividad> listaActividades = new ListaDoble<>();
            int tiempoMinimo = 1;
            int tiempoMaximo = 10;

            Proceso proceso = app.crearProceso(id, nombre, listaActividades, tiempoMinimo, tiempoMaximo);

            // Verificar que el proceso se ha creado correctamente
            assertNotNull(proceso);

            // Intentar eliminar el proceso
            app.eliminarProceso(proceso);

            // Verificar que el proceso se ha eliminado correctamente de la lista de procesos en App
            assertNull(app.getListaProcesos().obtenerNodo(app.getListaProcesos().obtenerPosicionNodo(proceso)));
        }




    @Test
    void actualizarProceso() {
    }

    @Test
    void insertarTareaAlFinal() {
    }

    @Test
    void consultarTiempoDuracionProceso() {
    }

    @Test
    void crearCuentasDeUsuario() {
    }
}