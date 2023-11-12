package model;

import java.util.Iterator;
import java.util.Objects;

import resources.Cola;

public class Tarea {
    private String nombre;
    private String descripcion;
    private boolean obligatoriedad;

    Cola<Tarea> cola = new Cola<>();

    public Tarea(String nombre, String descripcion, boolean obligatoriedad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.obligatoriedad = obligatoriedad;
    }

    private void insertarTareaPosicionDeterminada(Tarea tarea, int posicion) {

        cola.insertarEnPosicion(tarea,posicion);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isObligatoriedad() {
        return obligatoriedad;
    }

    public void setObligatoriedad(boolean obligatoriedad) {
        this.obligatoriedad = obligatoriedad;
    }


    @Override
    public String toString() {
        return "Tarea{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", obligatoriedad=" + obligatoriedad +
                ", cola=" + cola +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return obligatoriedad == tarea.obligatoriedad && Objects.equals(nombre, tarea.nombre) && Objects.equals(descripcion, tarea.descripcion) && Objects.equals(cola, tarea.cola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, obligatoriedad, cola);
    }
}