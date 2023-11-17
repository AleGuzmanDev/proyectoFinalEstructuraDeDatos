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


        String id = "001";
        String nombre = "Proceso 1";
        int tiempoMinutos = 5;
        int tiempoMaximo = 10;

        Proceso proceso = app.crearProceso(id,nombre,tiempoMinutos,tiempoMaximo);

        assertNotNull(proceso);
        assertEquals(id,proceso.getId());
        assertEquals(nombre,proceso.getNombre());
        assertEquals(tiempoMinutos,proceso.getTiempoMinimo());
        assertEquals(tiempoMaximo,proceso.getTiempoMaximo());
    }

    @Test
    void eliminarProceso() throws Exception {

            App app = new App();

            // Crear un proceso para probar su eliminación
            String id = "001";
            String nombre = "Proceso de prueba";
            ListaDoble<Actividad> listaActividades = new ListaDoble<>();
            int tiempoMinimo = 1;
            int tiempoMaximo = 10;

            Proceso proceso = app.crearProceso(id, nombre, tiempoMinimo, tiempoMaximo);

            // Verificar que el proceso se ha creado correctamente
            assertNotNull(proceso);

            app.eliminarProceso(proceso);

            // Verificar que el proceso se ha eliminado correctamente de la lista de procesos en App
            assertNull(app.getListaProcesos().obtenerNodo(app.getListaProcesos().obtenerPosicionNodo(proceso)));
        }


    @Test
    void actualizarProceso() {

        App app = new App();

        Proceso proceso1 = app.crearProceso("001","Proceso 1",5,10);
        Proceso proceso2= app.crearProceso("002","Proceso 2",6,12);

        app.getListaProcesos().imprimirLista();

        Proceso procesoActualizado = app.actualizarProceso(proceso2,"001");

        app.getListaProcesos().imprimirLista();

        assertEquals(proceso1.getId(),procesoActualizado.getId());
        assertEquals(proceso2.getNombre(),procesoActualizado.getNombre());
        assertEquals(proceso2.getTiempoMinimo(),procesoActualizado.getTiempoMinimo());
        assertEquals(proceso2.getTiempoMaximo(),procesoActualizado.getTiempoMaximo());

    }

    @Test
    void insertarTareaAlFinal() {
    }

    @Test
    void consultarTiempoDuracionProceso() {

        App app = new App();
        Proceso proceso = new Proceso("001","Proceso 1",5,10);
        app.consultarTiempoDuracionProceso(proceso);

        assertEquals(7.5,app.consultarTiempoDuracionProceso(proceso));
    }

    @Test
    void crearCuentasDeUsuario() {
    }
}