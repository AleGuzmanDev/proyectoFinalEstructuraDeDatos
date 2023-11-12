package model;

import resources.Cola;
import resources.ListaSimple;
import resources.Nodo;
import resources.NodoCola;

import java.util.Objects;

public class Proceso {

    private String id;
    private String nombre;

    ListaSimple<Actividad> listaActividades = new ListaSimple<>();
    private int tiempoMinimo;
    private int tiempoMaximo;

    public Proceso(String id, String nombre, ListaSimple<Actividad> listaActividades, int tiempoMinimo, int tiempoMaximo) {
        this.id = id;
        this.nombre = nombre;
        this.listaActividades = listaActividades;
        this.tiempoMinimo = tiempoMinimo;
        this.tiempoMaximo = tiempoMaximo;
    }

    public Actividad buscarActividad(Actividad actividad) {

        if (listaActividades.buscarNodo(actividad) != null) {
            return actividad;
        }
        return null;
    }

    public Tarea buscarTarea(Actividad actividad,Tarea tarea) {

        if (listaActividades.buscarNodo(actividad) != null) {
            return listaActividades.buscarNodo(actividad).getValorNodo().getTareas().buscarNodoCola(tarea).getValorNodo();
        }
        return null;
    }

    private void intercambiarActividadesSinSusTareas(Actividad actividad1, Actividad actividad2) {

        Nodo<Actividad> nodoActividad1 = listaActividades.buscarNodo(actividad1);
        Nodo<Actividad> nodoActividad2 = listaActividades.buscarNodo(actividad2);

        Actividad actividadAuxiliar = nodoActividad1.getValorNodo();
        nodoActividad1.setValorNodo(nodoActividad2.getValorNodo());
        nodoActividad2.setValorNodo(actividadAuxiliar);
    }

    private void intercambiarActividadesConSusListasDeTareas(Actividad actividad1, Actividad actividad2) {
        Nodo<Actividad> nodoActividad1 = listaActividades.buscarNodo(actividad1);
        Nodo<Actividad> nodoActividad2 = listaActividades.buscarNodo(actividad2);

        Cola<Tarea> listaTareasAuxiliar = nodoActividad1.getValorNodo().getTareas();
        nodoActividad1.getValorNodo().setTareas(nodoActividad2.getValorNodo().getTareas());
        nodoActividad2.getValorNodo().setTareas(listaTareasAuxiliar);
    }

    private void crearActividadAlFinal(Actividad actividad){

        listaActividades.agregarFinal(actividad);
    }

    private void crearActividadDespuesDeUltima(Actividad actividad1, Actividad actividad2){

        listaActividades.crearDespuesDeUltimo(listaActividades, actividad1, actividad2);
    }

    private void crearActividadPosicionDeterminada(Actividad actividad, int posicion){

        listaActividades.insertarEnPosicion(actividad,posicion);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoMinimo() {
        return tiempoMinimo;
    }

    public void setTiempoMinimo(int tiempoMinimo) {
        this.tiempoMinimo = tiempoMinimo;
    }

    public int getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(int tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public ListaSimple<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(ListaSimple<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaActividades=" + listaActividades +
                ", tiempoMinimo=" + tiempoMinimo +
                ", tiempoMaximo=" + tiempoMaximo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proceso proceso = (Proceso) o;
        return tiempoMinimo == proceso.tiempoMinimo && tiempoMaximo == proceso.tiempoMaximo && Objects.equals(id, proceso.id) && Objects.equals(nombre, proceso.nombre) && Objects.equals(listaActividades, proceso.listaActividades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, listaActividades, tiempoMinimo, tiempoMaximo);
    }
}
