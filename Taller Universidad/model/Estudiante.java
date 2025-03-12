import java.util.Arrays;

public class Estudiante {

    private String nombre;
    private String identificacion;
    private Nota[] listaNotas = new Nota[5];

    public Estudiante(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Nota[] getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(Nota[] listaNotas) {
        this.listaNotas = listaNotas;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", listaNotas=" + Arrays.toString(listaNotas) +
                '}';
    }

    public String registrarNota(String nombreNota, float valorNota) {
        int posDisponible = buscarPosicion();
        if (posDisponible == -1) {
            return "No hay espacio para más notas";
        } else {
            Nota nota = new Nota(nombreNota, valorNota);
            listaNotas[posDisponible] = nota;
            return "La nota fue registrada";
        }
    }

    private int buscarPosicion() {
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public float calcularDefinitiva() {
        float sumatoria = 0;
        int contador = 0;
        for (Nota notaAux : listaNotas) {
            if (notaAux != null) {
                sumatoria += notaAux.getValor();
                contador++;
            }
        }
        return contador == 0 ? 0 : sumatoria / contador;
    }

    public String actualizarNota(String nombreNota, float nuevoValorNota) {
        Nota notaEncontrada = buscarNota(nombreNota);
        if (notaEncontrada != null) {
            return notaEncontrada.actualizarNota(nuevoValorNota); // Usando el metodo de Nota
        } else {
            return "La nota no está registrada";
        }
    }

    private Nota buscarNota(String nombreNota) {
        for (Nota nota : listaNotas) {
            if (nota != null && nota.getNombre().equals(nombreNota)) {
                return nota;
            }
        }
        return null;
    }


    public String mostrarNotas() {
        String mensaje = "Notas de " + nombre + ":\n";
        for (Nota nota : listaNotas) {
            if (nota != null) {
                mensaje += nota.getNombre() + ": " + nota.getValor() + "\n";
            }
        }
        return mensaje;
    }


    public String mostrarPromedio() {
        return "Promedio de " + nombre + ": " + calcularDefinitiva() + "\n";
    }
}