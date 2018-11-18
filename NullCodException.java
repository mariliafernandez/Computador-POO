import javax.swing.JOptionPane;

public class NullCodException extends Exception {

    public void retry(Computador comp) {

        JOptionPane.showMessageDialog(null, "Código não pode ser nulo!", "Erro", JOptionPane.ERROR_MESSAGE);

        // try {
        //     comp.setCodigo(JOptionPane.showInputDialog(null, "Informe o código do produto", "Entrada de dados", JOptionPane.PLAIN_MESSAGE));
        // } catch(NullCodException nce) {
        //     nce.retry(comp);
        // }
    }
}
