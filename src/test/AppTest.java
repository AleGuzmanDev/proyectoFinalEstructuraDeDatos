package test;

import model.*;
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

        Proceso proceso = app.crearProceso(id,nombre);

        assertNotNull(proceso);
        assertEquals(id,proceso.getId());
        assertEquals(nombre,proceso.getNombre());
        assertEquals(tiempoMinutos,proceso.getTiempoMinimo());
        assertEquals(tiempoMaximo,proceso.getTiempoMaximo());
    }

    @Test
    void eliminarProceso() {

            App app = new App();

            // Crear un proceso para probar su eliminación
            String id = "001";
            String nombre = "Proceso de prueba";


            int tiempoMinimo = 1;
            int tiempoMaximo = 10;

            Proceso proceso = app.crearProceso(id, nombre);
            app.crearProceso("002", "Proceso de prueba 2");



            // Verificar que el proceso se ha creado correctamente
            assertNotNull(proceso);

            app.eliminarProceso(proceso);

            // Verificar que el tamaño de la lista despues de3 eliminar una actividad
            assertEquals(app.getListaProcesos().getTamano(),1);
        }


    @Test
    void actualizarProceso() {

        App app = new App();

        Proceso proceso1 = app.crearProceso("001","Proceso 1");
        Proceso proceso2= app.crearProceso("002","Proceso 2");

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
        Proceso proceso = new Proceso("001","Proceso 1");
        app.consultarTiempoDuracionProceso(proceso);

        assertEquals(7.5,app.consultarTiempoDuracionProceso(proceso));
    }

    @Test
    void crearCuentasDeUsuario() {
        App app = new App();
        Usuario usu = app.crearCuentasDeUsuario("Aleja","1234", Rol.ADMINISTRADOR);
        //Para saber si el usuario existe en la lista de usuarios
        assertNotNull(app.buscarUsuario(usu));

    }
}