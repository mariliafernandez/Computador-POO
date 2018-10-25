import javax.swing.JOptionPane;

public class OverPriceException extends Exception{

    InData in = new InData(); 

    public OverPriceException() {
        System.out.println("\nGerou um objeto do tipo OverPriceException.");
    }

    public void retry(Computador comp) {

        JOptionPane.showMessageDialog(null, "Preço muito alto, deve ser menor que 25000", "Erro", JOptionPane.ERROR_MESSAGE);

        try {
            comp.setPreco(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o preço do produto", "Entrada de dados", JOptionPane.PLAIN_MESSAGE)));
        } catch(OverPriceException ope) {
            ope.retry(comp);
        } catch(UnderPriceException upe) {
            upe.retry(comp);
        }
    }
}