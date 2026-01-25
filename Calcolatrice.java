import javax.swing.JOptionPane;

public class Calcolatrice {
    public static void main(String[] args) {
        // Finestra per il primo numero
        String s1 = JOptionPane.showInputDialog("Inserisci il primo numero:");
        double n1 = Double.parseDouble(s1);

        // Finestra per l'operatore
        String op = JOptionPane.showInputDialog("Inserisci l'operazione (+, -, *, /):");

        // Finestra per il secondo numero
        String s2 = JOptionPane.showInputDialog("Inserisci il secondo numero:");
        double n2 = Double.parseDouble(s2);

        double risultato = 0;

        if (op.equals("+")) risultato = n1 + n2;
        else if (op.equals("-")) risultato = n1 - n2;
        else if (op.equals("*")) risultato = n1 * n2;
        else if (op.equals("/")) risultato = n1 / n2;

        // Finestra finale con il risultato
        JOptionPane.showMessageDialog(null, "Il risultato è: " + risultato);
    }
}