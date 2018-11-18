import javax.swing.JOptionPane;

public class OverPriceException extends Exception{

    public void retry(Computador comp) {

        JOptionPane.showMessageDialog(null, "Preço muito alto, deve ser menor que 25000", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}