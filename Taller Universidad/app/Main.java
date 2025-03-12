// La verdad me ayude de Deepseek para hacer este main profe, no entendia bien la
// manera de utilizar el Joption para todos los metodos que tuve que tuvimos que hacer.
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Uniquindio", "Calle 23 Norte");


        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante");
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante");
        String mensaje = universidad.registrarEstudiante(nombre, identificacion);
        JOptionPane.showMessageDialog(null, mensaje);


        identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante para registrar una nota");
        String nombreNota = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nota");
        float valorNota = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el valor de la nota"));
        mensaje = universidad.registrarNota(identificacion, nombreNota, valorNota);
        JOptionPane.showMessageDialog(null, mensaje);


        identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante para ver sus notas");
        String notas = universidad.mostrarNotasEstudiante(identificacion);
        JOptionPane.showMessageDialog(null, notas);


        identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del estudiante para ver su promedio");
        String promedio = universidad.mostrarPromedioEstudiante(identificacion);
        JOptionPane.showMessageDialog(null, promedio);
    }
}