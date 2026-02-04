import javax.swing.JOptionPane;

public class Calcolatrice {
    public static void main(String[] args) {
        try {
            // Finestra per il primo numero
            String s1 = JOptionPane.showInputDialog("Inserisci il primo numero:");
            if (s1 == null) return; // Gestisce il tasto Annulla
            double n1 = Double.parseDouble(s1);

            // Finestra per l'operatore
            String op = JOptionPane.showInputDialog("Operazione (+, -, *, /, ^):");
            if (op == null) return;

            // Finestra per il secondo numero
            String s2 = JOptionPane.showInputDialog("Inserisci il secondo numero:");
            if (s2 == null) return;
            double n2 = Double.parseDouble(s2);

            double risultato = 0;
            boolean operazioneValida = true;

            // Logica potenziata
            switch (op) {
                case "+": risultato = n1 + n2; break;
                case "-": risultato = n1 - n2; break;
                case "*": risultato = n1 * n2; break;
                case "/": 
                    if (n2 != 0) risultato = n1 / n2; 
                    else { JOptionPane.showMessageDialog(null, "Errore: Divisione per zero!"); operazioneValida = false; }
                    break;
                case "^": risultato = Math.pow(n1, n2); break; // Aggiunta potenza
                default:
                    JOptionPane.showMessageDialog(null, "Operatore non valido!");
                    operazioneValida = false;
            }

            if (operazioneValida) {
                JOptionPane.showMessageDialog(null, "Il risultato di " + n1 + " " + op + " " + n2 + " è: " + risultato);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Errore: Inserisci solo numeri validi!");
        }
    }
}