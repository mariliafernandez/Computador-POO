import javax.swing.JOptionPane;

public class UnderPriceException extends Exception {

    public UnderPriceException() {
        System.out.println("\nGerou um objeto do tipo UnderPriceException.");
    }

    public void retry(Computador comp) {
        JOptionPane.showMessageDialog(null, "Preço muito baixo, deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
        
    }
}