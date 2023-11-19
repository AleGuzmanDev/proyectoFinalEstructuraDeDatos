package model;

import resources.*;

import java.util.Objects;

public class Proceso {

    private String id;
    private String nombre;

    ListaDoble<Actividad> listaActividades;
    private int tiempoMinimo;
    private int tiempoMaximo;

    public Proceso(String id, String nombre, int tiempoMinimo, int tiempoMaximo) {
        this.id = id;
        this.nombre = nombre;
        this.listaActividades = new ListaDoble<>();
        this.tiempoMinimo = tiempoMinimo;
        this.tiempoMaximo = tiempoMaximo;
    }

    public Actividad buscarActividad(Actividad actividad) {

        if (listaActividades.buscarNodo(actividad) != null) {
            System.out.println("Actividad encontrada");
            return actividad;
        }
        return null;
    }

    public Tarea buscarTarea(Actividad actividad, Tarea tarea) {
        NodoDoble<Actividad> nodoActividad = listaActividades.buscarNodo(actividad);

        if (nodoActividad != null) {
            Cola<Tarea> colaTareas = nodoActividad.getValorNodo().getTareas();
            NodoCola<Tarea> nodoTarea = colaTareas.buscarNodoCola(tarea);

            if (nodoTarea != null) {
                return nodoTarea.getValorNodo();
            }
        }

        return null;
    }

    public void intercambiarActividadesSinSusTareas(Actividad actividad1, Actividad actividad2) {
        int indiceActividad1 = listaActividades.obtenerPosicionNodo(actividad1);
        int indiceActividad2 = listaActividades.obtenerPosicionNodo(actividad2);

        if (indiceActividad1 != -1 && indiceActividad2 != -1) {
            // Encontrar las actividades por sus índices y luego intercambiarlas
            listaActividades.eliminar(actividad1); // Eliminar actividad1
            listaActividades.insertarEnPosicion(actividad1, indiceActividad2); // Insertar actividad1 en la posición de actividad2
            listaActividades.eliminar(actividad2); // Eliminar actividad2
            listaActividades.insertarEnPosicion(actividad2, indiceActividad1); // Insertar actividad2 en la posición de actividad1
        } else {
            System.out.println("Una o ambas actividades no existen en la lista.");
        }
    }



    public void intercambiarActividadesConTareas(Actividad actividad1, Actividad actividad2) {

        int indiceActividad1 = listaActividades.obtenerPosicionNodo(actividad1);
        int indiceActividad2 = listaActividades.obtenerPosicionNodo(actividad2);

        if (indiceActividad1 != -1 && indiceActividad2 != -1) {
            // Guardar las tareas de ambas actividades
            Cola<Tarea> tareasActividad1 = actividad1.getTareas();
            Cola<Tarea> tareasActividad2 = actividad2.getTareas();

            // Intercambiar las posiciones de las actividades en la lista
            listaActividades.eliminar(actividad1);
            listaActividades.insertarEnPosicion(actividad1, indiceActividad2);
            listaActividades.eliminar(actividad2);
            listaActividades.insertarEnPosicion(actividad2, indiceActividad1);

            // Intercambiar las tareas entre las actividades
            actividad1.setTareas(tareasActividad2);
            actividad2.setTareas(tareasActividad1);


        } else {
            System.out.println("Una o ambas actividades no existen en la lista.");
        }
    }


    public void eliminarActividad(Actividad actividad) {

        if(!listaActividades.estaVacia()){
            listaActividades.eliminar(actividad);
            System.out.println("Se ha eliminado la actividad");
        }
        else {
            throw new RuntimeException("La actividad no existe en la lista");
        }
    }
    public Actividad crearActividad (String nombre, String descripcion, boolean obligatoriedad){

       Actividad actividadEncontrada = null;

       for (int i =0; i<listaActividades.getTamano();i++){
           Actividad actividad = listaActividades.obtenerValorNodo(i);

           if(actividad.getNombre().equals(nombre)){
               actividadEncontrada = actividad;
           }
       }

       if (actividadEncontrada != null){
           throw new RuntimeException("La actividad ya existe en la lista");}

        Actividad nuevaActividad = new Actividad(nombre, descripcion, obligatoriedad);
        listaActividades.agregarInicio(nuevaActividad);
        System.out.println("Actividad creada con éxito");
        return nuevaActividad;
    }


    public Actividad actualizarActividad(Actividad actividad, String nombre) {
        Actividad actividadActualizada = null;

        for (int i = 0; i < listaActividades.getTamano(); i++) {
            Actividad actividadExistente = listaActividades.obtenerValorNodo(i);

            if (actividadExistente.getNombre().equals(nombre)) {
                // Se encontró la actividad que coincide con el nombre proporcionado
                actividadActualizada = actividadExistente;
                actividadActualizada.setDescripcion(actividad.getDescripcion());
                actividadActualizada.setObligatoriedad(actividad.isObligatoriedad());
                actividadActualizada.setTareas(actividad.getTareas());
                break;  // Terminar el bucle después de encontrar la actividad
            }
        }

        if (actividadActualizada != null) {
            System.out.println("Actividad actualizada con éxito");
        } else {
            System.out.println("No se encontró ninguna actividad con el nombre proporcionado");
        }

        return actividadActualizada;
    }



    public Actividad crearActividadAlFinal(String nombre, String descripcion, boolean obligatoriedad) {

        Actividad actividadEncontrada = null;

        for (int i = 0; i < listaActividades.getTamano(); i++) {
            Actividad actividadActual = listaActividades.obtenerValorNodo(i);

            if (actividadActual.getNombre().equals(nombre)) {
                actividadEncontrada = actividadActual;
            }
        }
        if (actividadEncontrada != null) {
            throw new RuntimeException("La actividad ya existe en la lista.");
        }

        // Si no existe, agregar la nueva actividad al final de la lista
        Actividad nuevaActividad = new Actividad(nombre, descripcion, obligatoriedad);
        listaActividades.agregarFinal(nuevaActividad);
        System.out.println("Actividad creada con éxito");

        return nuevaActividad;
    }


        //Este metodo hay que arreglarlo, porque tiene un error
        public void crearDespuesDeUltimo(Actividad actividadExistente, Actividad nuevaActividad) {
            NodoDoble<Actividad> nodoActual = listaActividades.getNodoPrimero();
            NodoDoble<Actividad> ultimoNodoConActividad = null;

            // Iterar sobre la lista para encontrar la última ocurrencia de la actividad existente
            while (nodoActual != null) {
                if (nodoActual.getValorNodo().equals(actividadExistente)) {
                    ultimoNodoConActividad = nodoActual;
                }
                nodoActual = nodoActual.getSiguienteNodo();
            }

            // Verificar si se encontró alguna ocurrencia de la actividad existente
            if (ultimoNodoConActividad != null) {
                // Crear el nuevo nodo y asignarle la nueva actividad
                NodoDoble<Actividad> nuevoNodo = new NodoDoble<>(nuevaActividad);

                // Insertar el nuevo nodo después del último nodo con la actividad existente
                nuevoNodo.setSiguienteNodo(ultimoNodoConActividad.getSiguienteNodo());
                ultimoNodoConActividad.setSiguienteNodo(nuevoNodo);
            } else {
                // La actividad existente no se encontró en la lista
                System.out.println("La actividad existente no se encuentra en la lista.");
            }
        }

        // Otros métodos de la clase Proceso


    public Actividad crearActividadPosicionDeterminada(Actividad actividad, int posicion) {

        Actividad actividadEncontrada = null;

        for (int i =0; i<listaActividades.getTamano();i++){
            actividad = listaActividades.obtenerValorNodo(i);

            if(actividad.getNombre().equals(nombre)){
                actividadEncontrada = actividad;
            }
        }

        if (actividadEncontrada != null){
            throw new RuntimeException("La actividad ya existe en la lista");}

        // Verificar si la posición proporcionada es válida
        if (posicion < 0 || posicion > listaActividades.getTamano()) {
            throw new IllegalArgumentException("Posición inválida");
        }

        // Insertar la actividad en la posición determinada
        listaActividades.insertarEnPosicion(actividad, posicion);
        System.out.println("Actividad creada con exito en posición determinada");
        return actividad;
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

    public ListaDoble<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(ListaDoble<Actividad> listaActividades) {
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
