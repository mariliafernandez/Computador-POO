import javax.swing.JOptionPane;

public class UnderPriceException extends Exception {

    InData in = new InData();

    public UnderPriceException() {
        System.out.println("\nGerou um objeto do tipo UnderPriceException.");
    }

    public void retry(Computador comp) {
        JOptionPane.showMessageDialog(null, "Preço muito baixo, deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
        try {
            comp.setPreco(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o preço do produto", "Entrada de dados", JOptionPane.PLAIN_MESSAGE)));
        } catch(UnderPriceException upe) {
            upe.retry(comp);
        } catch(OverPriceException ope) {
            ope.retry(comp);
        }
    }
}