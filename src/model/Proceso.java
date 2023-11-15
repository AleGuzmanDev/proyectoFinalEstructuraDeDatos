package model;

import resources.*;

import java.util.Objects;

public class Proceso {

    private String id;
    private String nombre;

    ListaDoble<Actividad> listaActividades = new ListaDoble<>();
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
        NodoDoble<Actividad> nodoActividad1 = listaActividades.buscarNodo(actividad1);
        NodoDoble<Actividad> nodoActividad2 = listaActividades.buscarNodo(actividad2);

        if (nodoActividad1 != null && nodoActividad2 != null) {
            // Intercambiar actividades solo si ambas actividades existen en la lista
            Actividad actividadAuxiliar = nodoActividad1.getValorNodo();
            nodoActividad1.setValorNodo(nodoActividad2.getValorNodo());
            nodoActividad2.setValorNodo(actividadAuxiliar);
        } else {
            System.out.println("Una o ambas actividades no existen en la lista.");
        }
    }


    public void intercambiarActividadesConSusListasDeTareas(Actividad actividad1, Actividad actividad2) {
        NodoDoble<Actividad> nodoActividad1 = listaActividades.buscarNodo(actividad1);
        NodoDoble<Actividad> nodoActividad2 = listaActividades.buscarNodo(actividad2);

        if (nodoActividad1 != null && nodoActividad2 != null) {
            // Intercambiar actividades solo si ambas actividades existen en la lista
            Actividad valorActividad1 = nodoActividad1.getValorNodo();
            Actividad valorActividad2 = nodoActividad2.getValorNodo();

            // Intercambiar colas de tareas
            Cola<Tarea> colaTareasAuxiliar = valorActividad1.getTareas();
            valorActividad1.setTareas(valorActividad2.getTareas());
            valorActividad2.setTareas(colaTareasAuxiliar);

            // Intercambiar posiciones en la lista
            nodoActividad1.setValorNodo(valorActividad2);
            nodoActividad2.setValorNodo(valorActividad1);
        } else {
            System.out.println("Una o ambas actividades no existen en la lista.");
        }
    }




    public void eliminarActividad(Actividad actividad) {


        if(!listaActividades.estaVacia()){
            listaActividades.eliminar(actividad);
        }

        else {
            throw new RuntimeException("No hay procesos para eliminar");
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
