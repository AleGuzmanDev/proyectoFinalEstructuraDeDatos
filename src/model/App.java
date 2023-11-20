package model;

import resources.ListaDoble;
import resources.ListaSimple;
import resources.Nodo;

import java.util.Scanner;
import java.util.function.Predicate;

public class App {

    private ListaSimple <Proceso>listaProcesos;

    Scanner leer = new Scanner(System.in);

    private ListaSimple<Usuario> listaUsuarios;

    public App() {
        this.listaProcesos = new ListaSimple<>();
        this.listaUsuarios = new ListaSimple<>();
    }

    public Usuario iniciarSesion(Usuario usuario) throws Exception {
        Nodo<Usuario> nodoUsuario = listaUsuarios.buscarNodo(usuario);

        if (nodoUsuario != null) {
            Usuario usuarioEnLista = nodoUsuario.getValorNodo();

            if (usuarioEnLista != null &&
                    usuarioEnLista.getUserId().equals(usuario.getUserId()) &&
                    usuarioEnLista.getPassword().equals(usuario.getPassword())) {
                System.out.println("Sesion iniciada con exito");
                return usuarioEnLista;

            }
        }

        return null;
    }

    public Proceso crearProceso(String id, String nombre) {
        Proceso procesoEncontrado = null;
        for (int i = 0; i < listaProcesos.getTamano(); i++) {
            Proceso proceso = listaProcesos.obtenerNodo(i).getValorNodo();

            if(proceso.getId().equals(id)){
                procesoEncontrado = proceso;
            }
        }

        if (procesoEncontrado != null) {
            throw new RuntimeException("Ya existe un proceso con ese ID");
        }

        Proceso nuevoProceso = new Proceso(id, nombre);
        listaProcesos.agregarInicio(nuevoProceso);
        System.out.println("Proceso creado con éxito");
        return nuevoProceso;
    }

    public void eliminarProceso(Proceso proceso) throws Exception {

        if(!listaProcesos.estaVacia()){
            listaProcesos.eliminar(proceso);
            System.out.println("Proceso eliminado con éxito");
        }

        else {
            throw new RuntimeException("No hay procesos para eliminar");
        }

    }

    public Proceso actualizarProceso(Proceso proceso, String id) {

        for (int i = 0; i < listaProcesos.getTamano(); i++) {
            Proceso proceso1 = listaProcesos.obtenerNodo(i).getValorNodo();
            if(proceso1.getId().equals(id)){
             //  listaProcesos.obtenerNodo(i).setValorNodo(proceso);
                proceso1.setNombre(proceso.getNombre());
                proceso1.setTiempoMinimo(proceso.getTiempoMinimo());
                proceso1.setTiempoMaximo(proceso.getTiempoMaximo());
                proceso1.setListaActividades(proceso.getListaActividades());

                System.out.println("Proceso actualizado con éxito");
                return proceso1;

            }
        }

        return null;
    }

    public Tarea insertarTareaAlFinal(Proceso proceso, Actividad actividad, Tarea tarea) {
        if (proceso == null || actividad == null || tarea == null) {
            throw new IllegalArgumentException("Argumentos nulos no permitidos");
        }

        for (int i = 0; i < listaProcesos.getTamano(); i++) {
            Proceso proceso1 = listaProcesos.obtenerValorNodo(i);
            if (proceso1 != null && proceso1.getId().equals(proceso.getId())) {
                ListaDoble<Actividad> listaActividades = proceso1.getListaActividades();
                if (listaActividades != null) {
                    for (int j = 0; j < listaActividades.getTamano(); j++) {
                        Actividad actividad1 = listaActividades.obtenerValorNodo(j);
                        if (actividad1 != null && actividad1.getNombre().equals(actividad.getNombre())) {
                            if (actividad1.getTareas() != null) {
                                actividad1.getTareas().encolar(tarea);
                                System.out.println("Tarea insertada con éxito");
                                return tarea;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public double consultarTiempoDuracionProceso(Proceso proceso) {
        if (proceso != null) {
            return (proceso.getTiempoMaximo() + proceso.getTiempoMinimo()) / 2.0;
        }

        return 0;
    }

    public Usuario crearCuentasDeUsuario (String userId,String password,Rol rol){

        Usuario usuarioEncontrado = null;
        for (int i = 0; i < listaUsuarios.getTamano(); i++) {
            Usuario usuario = listaUsuarios.obtenerNodo(i).getValorNodo();

            if(usuario.getUserId().equals(userId)){
                usuarioEncontrado = usuario;
            }
        }

        if (usuarioEncontrado != null) {
            throw new RuntimeException("Ya existe un usuario con ese ID");
        }

    Usuario usuario = new Usuario(userId,password,rol);
    listaUsuarios.agregarInicio(usuario);
    return usuario;
    }

    public Usuario buscarUsuario(Usuario usuario) {

        if (listaUsuarios.buscarNodo(usuario) != null) {
            System.out.println("Usuario encontrado");
            return usuario;
        }
        return null;
    }


    private String notificarRecordatorios(){
        return null;
    }
    private String importarYExportarInformacion(){
        return null;
    }

    public ListaSimple getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ListaSimple listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public ListaSimple getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ListaSimple listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


}
