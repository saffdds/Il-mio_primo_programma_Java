import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Calcolatrice {

    public static void main(String[] args) {
        ArrayList<String> cronologia = new ArrayList<>();
        boolean continua = true;

        // Messaggio di benvenuto grafico
        JOptionPane.showMessageDialog(null, "--- Calcolatricejava---\nMemoria Attiva", "Calcolatricejava", JOptionPane.INFORMATION_MESSAGE);

        while (continua) {
            String[] opzioni = {"+", "-", "*", "/", "sqrt", "pow", "history", "exit"};
            
            // Creiamo il menù a tendina grafico
            String scelta = (String) JOptionPane.showInputDialog(null, 
                    "Cosa vuoi fare?", 
                    "Menù Calcolatrice", 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, opzioni, opzioni[0]);

            if (scelta == null || scelta.equals("exit")) {
                continua = false;
                break;
            }

            if (scelta.equals("history")) {
                StringBuilder historyText = new StringBuilder("--- Cronologia ---\n");
                if (cronologia.isEmpty()) {
                    historyText.append("Vuota.");
                } else {
                    for (String riga : cronologia) {
                        historyText.append(riga).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, historyText.toString(), "Memoria", JOptionPane.PLAIN_MESSAGE);
                continue;
            }

            try {
                double risultato = 0;
                String operazioneEffettuata = "";

                if (scelta.equals("sqrt")) {
                    String input = JOptionPane.showInputDialog("Inserisci il numero per la radice:");
                    double num = Double.parseDouble(input);
                    if (num < 0) throw new ArithmeticException("Radice di numero negativo!");
                    risultato = Math.sqrt(num);
                    operazioneEffettuata = "√" + num + " = " + risultato;
                } 
                else if (scelta.equals("pow")) {
                    double base = Double.parseDouble(JOptionPane.showInputDialog("Inserisci la base:"));
                    double esp = Double.parseDouble(JOptionPane.showInputDialog("Inserisci l'esponente:"));
                    risultato = Math.pow(base, esp);
                    operazioneEffettuata = base + " ^ " + esp + " = " + risultato;
                } 
                else {
                    double n1 = Double.parseDouble(JOptionPane.showInputDialog("Primo numero:"));
                    double n2 = Double.parseDouble(JOptionPane.showInputDialog("Secondo numero:"));

                    switch (scelta) {
                        case "+": risultato = n1 + n2; operazioneEffettuata = n1 + " + " + n2 + " = " + risultato; break;
                        case "-": risultato = n1 - n2; operazioneEffettuata = n1 + " - " + n2 + " = " + risultato; break;
                        case "*": risultato = n1 * n2; operazioneEffettuata = n1 + " * " + n2 + " = " + risultato; break;
                        case "/": 
                            if (n2 == 0) throw new ArithmeticException("Divisione per zero!");
                            risultato = n1 / n2; 
                            operazioneEffettuata = n1 + " / " + n2 + " = " + risultato; 
                            break;
                    }
                }

                JOptionPane.showMessageDialog(null, "Risultato: " + risultato);
                cronologia.add(operazioneEffettuata);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage(), "Ops!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}