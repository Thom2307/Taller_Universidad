import java.util.ArrayList;

public class Universidad {

    private String nombre;
    private String ubicacion;
    private ArrayList<Estudiante> listaEstudiantes;

    public Universidad(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaEstudiantes = new ArrayList<Estudiante>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }

    public String registrarEstudiante(String nombre, String identificacion) {
        String mensaje = "";
        Estudiante encontrado = buscarEstudiante(identificacion);
        if (encontrado != null) {
            mensaje = "El estudiante " + encontrado.getNombre() + " ya existe en la universidad";
            return mensaje;
        }
        Estudiante nuevoEstudiante = new Estudiante(nombre, identificacion);
        listaEstudiantes.add(nuevoEstudiante);
        mensaje = "El estudiante fue registrado exitosamente";
        return mensaje;
    }

    private Estudiante buscarEstudiante(String identificacion) {
        for (Estudiante estudianteAux : listaEstudiantes) {
            if (estudianteAux.getIdentificacion().equals(identificacion)) {
                return estudianteAux;
            }
        }
        return null;
    }

    public String registrarNota(String identificacion, String nombreNota, float valorNota) {
        String mensaje = "";
        Estudiante estudianteEncontrado = buscarEstudiante(identificacion);
        if (estudianteEncontrado != null) {
            mensaje = estudianteEncontrado.registrarNota(nombreNota, valorNota);
        } else {
            mensaje = "El estudiante no está registrado en la universidad";
        }
        return mensaje;
    }


    public String actualizarNota(String identificacion, String nombreNota, float nuevoValorNota) {
        String mensaje = "";
        Estudiante estudianteEncontrado = buscarEstudiante(identificacion);
        if (estudianteEncontrado != null) {
            mensaje = estudianteEncontrado.actualizarNota(nombreNota, nuevoValorNota);
        } else {
            mensaje = "El estudiante no está registrado en la universidad";
        }
        return mensaje;
    }


    public String mostrarNotasEstudiante(String identificacion) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            return estudiante.mostrarNotas();
        } else {
            return "Estudiante no encontrado.";
        }
    }


    public String mostrarPromedioEstudiante(String identificacion) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            return estudiante.mostrarPromedio();
        } else {
            return "Estudiante no encontrado.";
        }
    }
}
