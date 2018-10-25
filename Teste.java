import java.io.IOError;
import java.io.IOException;
import java.lang.NumberFormatException;

import javax.swing.JOptionPane;

public class Teste {
   
    public static void main(String arg[])  {

        InData in = new InData();
        Computador comp = new Notebook();

        try {
            comp.setPreco(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o preço do produto", "Entrada de dados", JOptionPane.PLAIN_MESSAGE)));
        } catch(UnderPriceException upe) {  
            // JOptionPane.showMessageDialog(null, "Preço muito baixo, deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);          
            upe.retry(comp);
        } catch(OverPriceException ope) {
            // JOptionPane.showMessageDialog(null, "Preço muito alto, deve ser menor que 25000", "Erro", JOptionPane.ERROR_MESSAGE);
            ope.retry(comp);
        } 
        catch(NumberFormatException nfe) {
            System.out.println("\nO valor deve ser numerico");
        }
        finally{
            JOptionPane.showConfirmDialog(null, "preço = " + preco + "?", "Confirmação",JOptionPane.YES_NO_CANCEL_OPTION );
        }
    }

}