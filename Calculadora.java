import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora implements ActionListener{

    private static JTextField val1 = new JTextField(10);
    private static JTextField val2 = new JTextField(10);
    private static JTextField resultField = new JTextField(10);
    private static JButton btSoma = new JButton("+");
    private static JButton btSub = new JButton("-");
    private static JButton btMult = new JButton("*");
    private static JButton btDiv = new JButton("/");
    private static JButton btSair = new JButton("Sair");
    private static JFrame jan1 = new JFrame("Calculadora");
    private static CriaJan cj = new CriaJan();
    private static JLabel rot1 = new JLabel("val1");
    private static JLabel rot2 = new JLabel("val2");
    private static JLabel rotResult = new JLabel("resultado");

    public static void main(String[] args) {
        
        int larg = 300, alt = 250;
        jan1.setSize(larg,alt);

        jan1.add(rot1);
        jan1.add(val1);

        jan1.add(rot2);
        jan1.add(val2);

        jan1.add(rotResult);
        jan1.add(resultField);

        // btSoma.setMnemonic('+'); // Ativa o botão ao clicar +
        jan1.add(btSoma);
        jan1.add(btSub);
        jan1.add(btMult);
        jan1.add(btDiv);
        jan1.add(btSair);

        jan1.setLayout(new FlowLayout());
        jan1.setVisible(true);      
        
        btSoma.addActionListener(cj);
        btSub.addActionListener(cj);
        btMult.addActionListener(cj);
        btDiv.addActionListener(cj);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        int num1 = Integer.parseInt(val1.getText().toString());
        int num2 = Integer.parseInt(val2.getText().toString());
        String resultStr = "";

        if( evt.getSource().equals(btSoma) ) {          
            int soma = num1 + num2;
            resultStr = Integer.toString(soma);
            resultField.setText(resultStr);
            // JOptionPane.showMessageDialog(null, "Você escolheu a opção "+frase,"Exibição de Dados", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if( evt.getSource().equals(btSub) ) {
            int sub = num1 - num2;
            resultStr = Integer.toString(sub);
            resultField.setText(resultStr);
        }
        else if( evt.getSource().equals(btMult) ) {
            int mult = num1 * num2;
            resultStr = Integer.toString(mult);
            resultField.setText(resultStr);
        }
        else if( evt.getSource().equals(btDiv) ) {
            int div = num1 / num2;
            resultStr = Integer.toString(div);
            resultField.setText(resultStr);
        }
        else {
            resultStr = "";
            resultField.setText(resultStr);
        }
    }
}