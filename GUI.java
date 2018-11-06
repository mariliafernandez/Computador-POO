import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    // private GUI gui = new GUI();
    private JFrame mainWindow = new JFrame("Registro de Computadores");
    private JFrame celWindow = new JFrame("Registro de Celular");
    private JFrame noteWindow = new JFrame("Registro de Notebook");
    private JLabel labelMarca = new JLabel("Marca");
    private JLabel labelRam = new JLabel("Memória RAM");
    private JLabel labelPreco = new JLabel("Preço");
    private JLabel labelOperadora = new JLabel("Operadora");
    private JLabel labelUsb = new JLabel("Quantidade de portas USB");
    private JButton btnCelular = new JButton("Registrar um celular");
    private JButton btnNotebook = new JButton("Registrar um notebook");
    private JButton btnSalvarCelular = new JButton("Salvar");
    private JButton btnSalvarNotebook = new JButton("Salvar");
    private JButton btnLimpar = new JButton("Limpar Tudo");
    private JButton btnSair = new JButton("Sair");

    public JTextField valMarca = new JTextField(10);
    public JTextField valRam = new JTextField(5);
    public JTextField valPreco = new JTextField(5);
    public JTextField valOperadora = new JTextField(10);
    public JTextField valUsb = new JTextField(2);

    public void openJanelaPrincipal() {
        mainWindow.setDefaultCloseOperation(mainWindow.EXIT_ON_CLOSE);
        mainWindow.setSize(300, 300);

        mainWindow.add(btnCelular);
        mainWindow.add(btnNotebook);

        btnCelular.addActionListener(this);
        btnNotebook.addActionListener(this);
        btnSair.addActionListener(this);

        mainWindow.setLayout(new FlowLayout());
        mainWindow.setVisible(true); 
    }

    public void openJanelaCelular() {
        celWindow.setDefaultCloseOperation(celWindow.DISPOSE_ON_CLOSE);
        celWindow.setSize(1000,500);

        celWindow.add(labelOperadora);
        celWindow.add(valOperadora);
        celWindow.add(labelMarca);
        celWindow.add(valMarca);
        celWindow.add(labelRam);
        celWindow.add(valRam);
        celWindow.add(labelPreco);
        celWindow.add(valPreco);
        celWindow.add(btnSalvarCelular);

        btnSalvarCelular.addActionListener(this);
        btnLimpar.addActionListener(this);

        celWindow.setLayout(new FlowLayout());
        celWindow.setVisible(true); 

    }

    public void openJanelaNotebook() {
        noteWindow.setDefaultCloseOperation(noteWindow.DISPOSE_ON_CLOSE);
        noteWindow.setSize(1000,500);

        noteWindow.add(labelUsb);
        noteWindow.add(valUsb);
        noteWindow.add(labelMarca);
        noteWindow.add(valMarca);
        noteWindow.add(labelRam);
        noteWindow.add(valRam);
        noteWindow.add(labelPreco);
        noteWindow.add(valPreco);
        noteWindow.add(btnSalvarNotebook);

        btnSalvarNotebook.addActionListener(this);
        btnLimpar.addActionListener(this);

        noteWindow.setLayout(new FlowLayout());
        noteWindow.setVisible(true); 

    }

    public void actionPerformed(ActionEvent evt) {

        String message = "";

        if( evt.getSource().equals(btnCelular) ) {
            openJanelaCelular();
        }   
        else if( evt.getSource().equals(btnNotebook))  {
            openJanelaNotebook();
        }   
        else if( evt.getSource().equals(btnSalvarCelular) ) {
            setValues("celular");
        }
        else if(  evt.getSource().equals(btnSalvarNotebook) ) {
            setValues("notebook");
        }
        else if( evt.getSource().equals(btnLimpar) ) {
            valMarca.setText("");
            valRam.setText("");
            valPreco.setText("");   
            valOperadora.setText("");
            valUsb.setText("");         
        }
        else if( evt.getSource().equals(btnSair) ) {
            System.exit(0);
        }
    }

    public void setValues(String tipo) {

        switch(tipo) {
            case "celular":
                Computador comp1 = new Celular(); 
                Celular cel = ( Celular ) comp1;
                cel.setMarca( valMarca.getText() ); 
                cel.setRam( Integer.parseInt(valRam.getText() ) );
                
                try {
                    cel.setPreco( Integer.parseInt(valPreco.getText())  );
                } catch( UnderPriceException upe ) {
                    upe.retry( cel );
                } catch( OverPriceException ope ) {
                    ope.retry( cel );
                }

                cel.setOperadora( valOperadora.getText() );

                showValues(cel);
            break;

            case "notebook":
                Computador comp2 = new Notebook(); 
                Notebook note = ( Notebook ) comp2;
                note.setMarca( valMarca.getText() );
                note.setRam( Integer.parseInt( valRam.getText() ) );

                try {
                    note.setPreco( Integer.parseInt(valPreco.getText()) );
                } catch( UnderPriceException upe ) {
                    upe.retry( note );
                } catch( OverPriceException ope ) {
                    ope.retry( note );
                }

                note.setQtdPortasUsb( Integer.parseInt( valUsb.getText() ) );

                showValues(note);
            break;
        }

    }

    public void showValues(Computador comp) {

        String tipo = comp.getClass().getName();

        String message = "";
        if(tipo.equals("Celular")) {
            Celular cel = ( Celular ) comp;
            message += "Celular " + cel.getMarca() + ":\n" + cel.getRam() + "GB de RAM\nR$ " + cel.getPreco();
        } 
        else if( tipo.equals("Notebook") ) {
            Notebook note = ( Notebook ) comp;
            message += "Notebook " + note.getMarca() + ":\n" + note.getRam() + "GB de RAM\nR$ " + note.getPreco();
        }

        JOptionPane.showMessageDialog(null, message);
    }

}