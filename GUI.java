import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Container;


public class GUI implements ActionListener {

    // private GUI gui = new GUI();
    private JFrame mainWindow = new JFrame("Computadores");
    public JFrame celWindow = new JFrame("Registro de Celular");
    public JFrame noteWindow = new JFrame("Registro de Notebook");
    public JFrame pesquisa = new JFrame("Pesquisa de produto");
    public JPanel panelTop = new JPanel();
    public JPanel panelBottom = new JPanel();

    private JLabel labelMarca = new JLabel("Marca:");
    private JLabel labelRam = new JLabel("RAM (GB):");
    private JLabel labelPreco = new JLabel("Preço (R$):");
    private JLabel labelCodigo = new JLabel("Código do produto: ");
    private JLabel labelOperadora = new JLabel("Operadora:");
    private JLabel labelUsb = new JLabel("Quantidade de portas USB:");
    private JLabel labelNomeRegiao = new JLabel("Nome da Região:");
    private JLabel labelCodRegiao = new JLabel("Código da Região:");
    private JLabel labelNomePais = new JLabel("Nome do País:");
    private JLabel labelCodPais = new JLabel("Código do País:");
    private JLabel labelResposta = new JLabel("");


    private JButton btnCelular = new JButton("Encontrar um celular");
    private JButton btnNotebook = new JButton("Encontrar um notebook");
    private JButton btnSalvarCelular = new JButton("Salvar");
    private JButton btnSalvarNotebook = new JButton("Salvar");
    private JButton btnLimpar = new JButton("Limpar Tudo");
    private JButton btnSair = new JButton("Sair");
    private JButton btnPesquisarCel = new JButton("Pesquisar");
    private JButton btnPesquisarNote = new JButton("Pesquisar");



    public JTextField valMarca = new JTextField(10);
    public JTextField valRam = new JTextField(10);
    public JTextField valPreco = new JTextField(10);
    public JTextField valCodigo = new JTextField(10);
    public JTextField valOperadora = new JTextField(10);
    public JTextField valUsb = new JTextField(2);
    public JTextField valNomeRegiao = new JTextField(10);
    public JTextField valCodRegiao = new JTextField(2);
    public JTextField valNomePais = new JTextField(10);
    public JTextField valCodPais = new JTextField(2);
    public JTextField valPesquisaCod = new JTextField(10);

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu();
    private JMenu subMenu = new JMenu();

    private JMenuItem menuItemSair = new JMenuItem();
    private JMenuItem menuItemCelular = new JMenuItem();
    private JMenuItem menuItemNotebook = new JMenuItem();

    private StorageComputador bd = new StorageComputador();
    

    public void openJanelaPrincipal() {
        mainWindow.setDefaultCloseOperation(mainWindow.EXIT_ON_CLOSE);
        mainWindow.setSize(300, 200);

        menu.setText("Menu");
        subMenu.setText("Adicionar novo");
        menuItemSair.setText("Sair");
        menuItemCelular.setText("Celular");
        menuItemNotebook.setText("Notebook");

        subMenu.add(menuItemCelular);
        subMenu.add(menuItemNotebook);
        
        menuBar.add(menu);
        menu.add(subMenu);
        menu.add(menuItemSair);

        mainWindow.setJMenuBar(menuBar);

        mainWindow.add(btnCelular);
        mainWindow.add(btnNotebook);

        btnCelular.addActionListener(this);
        btnNotebook.addActionListener(this);
        menuItemCelular.addActionListener(this);
        menuItemNotebook.addActionListener(this);
        menuItemSair.addActionListener(this);

        mainWindow.setLayout(new FlowLayout());
        mainWindow.setVisible(true); 
    }

    public void openJanelaCelular() {
        celWindow.setDefaultCloseOperation(celWindow.DISPOSE_ON_CLOSE);
        celWindow.setSize(400,600);

        setLayoutWindow(celWindow);
        limparCampos();

        btnSalvarCelular.addActionListener(this);
        btnLimpar.addActionListener(this);

        celWindow.setVisible(true); 

    }

    public void openJanelaNotebook() {
        noteWindow.setDefaultCloseOperation(noteWindow.DISPOSE_ON_CLOSE);
        noteWindow.setSize(400,600);

        setLayoutWindow(noteWindow);
        limparCampos();

        btnSalvarNotebook.addActionListener(this);
        btnLimpar.addActionListener(this);

        noteWindow.setVisible(true); 

    }


    public void janelaPesquisar(String tipo) {
        pesquisa.setDefaultCloseOperation(mainWindow.DISPOSE_ON_CLOSE);

        pesquisa.setSize(400, 400);

        pesquisa.add(labelCodigo);
        pesquisa.add(valPesquisaCod);

        if(tipo.equals("celular")) {
            pesquisa.add(btnPesquisarCel);
            btnPesquisarCel.addActionListener(this);
        }
        else {
            pesquisa.add(btnPesquisarNote);
            btnPesquisarNote.addActionListener(this);
        }

        pesquisa.setLayout(new FlowLayout());
        pesquisa.setVisible(true);
    }

    public void setLayoutWindow(JFrame frame) {

        JPanel panel = new JPanel();
        JPanel panelButtons = new JPanel();
        JPanel panelFrame = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelFrame.setLayout(new BoxLayout(panelFrame, BoxLayout.Y_AXIS));

        if(frame.equals(celWindow)) {
            panel.add(labelOperadora);
            panel.add(valOperadora);

            panelButtons.add(btnSalvarCelular);
        }

        else {
            panel.add(labelUsb);
            panel.add(valUsb);

            panelButtons.add(btnSalvarNotebook);
        }

        panel.add(labelCodigo);
        panel.add(valCodigo);
        panel.add(labelMarca);
        panel.add(valMarca);
        panel.add(labelRam);
        panel.add(valRam);
        panel.add(labelPreco);
        panel.add(valPreco);

        panel.add(labelNomeRegiao);
        panel.add(valNomeRegiao);
        panel.add(labelCodRegiao);
        panel.add(valCodRegiao);
        panel.add(labelNomePais);
        panel.add(valNomePais);
        panel.add(labelCodPais);
        panel.add(valCodPais);

        panelFrame.add(panel);
        panelFrame.add(panelButtons);

        frame.add(panelFrame);
    }

    public void actionPerformed(ActionEvent evt) {

        if( evt.getSource().equals(menuItemCelular) ) {
            openJanelaCelular();
        }   

        else if( evt.getSource().equals(menuItemNotebook) )  {
            openJanelaNotebook();
        }   

        else if( evt.getSource().equals(btnNotebook) ){
            janelaPesquisar( "notebook" );
        }

        else if( evt.getSource().equals(btnCelular) ) {
            janelaPesquisar( "celular" );
        }

        else if( evt.getSource().equals(btnSalvarCelular) ) {

            if( popUpConfirmar(celWindow) ) {
                Computador comp1 = new Celular(); 
                Celular cel = ( Celular ) comp1;
                cel.setMarca( valMarca.getText() ); 
                cel.setRam( Integer.parseInt(valRam.getText() ) );
                cel.setCodigo( valCodigo.getText() );
                    
                try {
                    cel.setPreco( Integer.parseInt(valPreco.getText())  );
                } catch( UnderPriceException upe ) {
                    upe.retry( cel );
                } catch( OverPriceException ope ) {
                    ope.retry( cel );
                }
    
                cel.setOperadora( valOperadora.getText() );
                
                bd.inserirComp(cel);
            }

        }

        else if(  evt.getSource().equals(btnSalvarNotebook) ) {

            if( popUpConfirmar(noteWindow) ) {
                Computador comp2 = new Notebook(); 
                Notebook note = ( Notebook ) comp2;
                note.setMarca( valMarca.getText() );
                note.setRam( Integer.parseInt( valRam.getText() ) );
                note.setCodigo(valCodigo.getText());
                
                try {
                    note.setPreco( Integer.parseInt(valPreco.getText()) );
                } catch( UnderPriceException upe ) {
                    upe.retry( note );
                } catch( OverPriceException ope ) {
                    ope.retry( note );
                }
                
                note.setQtdPortasUsb( Integer.parseInt( valUsb.getText() ) );    

                bd.inserirComp(note);
            }
        }

        else if( evt.getSource().equals(btnPesquisarCel) ) {
            Celular cel = (Celular) bd.consultaComp(valPesquisaCod.getText());
            if( cel != null) {
                labelResposta.setText("Produto encontrado");
                pesquisa.add(labelResposta);
                pesquisa.setVisible(false);
                pesquisa.setVisible(true);
                popUpAlterar(cel);
            }
            else {
                labelResposta.setText("Produto não cadastrado");
                System.out.println("Produto nao encontrado");
            }
        }

        else if( evt.getSource().equals(btnLimpar) ) {
            limparCampos();        
        }
        else if( evt.getSource().equals(menuItemSair) ) {
            System.exit(0);
        }
    }

    public void limparCampos() {
        valMarca.setText("");
        valRam.setText("");
        valPreco.setText("");   
        valOperadora.setText("");
        valUsb.setText(""); 
        valNomePais.setText("");
        valCodPais.setText("");
        valNomeRegiao.setText("");
        valCodRegiao.setText("");
    }

    public boolean popUpConfirmar(JFrame frame) {
        // celWindow.setVisible(false);
        String mensagem = "\nMarca: " + valMarca.getText() + "\n" + valRam.getText() + "GB de RAM\nR$ " + valPreco.getText();

        if(frame.equals(celWindow)) 
            mensagem += "\nOperadora: " + valOperadora.getText();
        else if(frame.equals(noteWindow))
            mensagem += "\n" + valUsb.getText() + " Portas USB";

        mensagem += "\n\nConfimar valores?";

        int action = JOptionPane.showConfirmDialog(null, mensagem, "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if(action == JOptionPane.OK_OPTION) 
            return true;            
        else
            return false;
    }

    public void popUpExcluir(Celular cel) {
        String msg = strDados(cel) + "\n\nExcluir item?";

        int action = JOptionPane.showConfirmDialog(null, msg, "Excluir?", JOptionPane.YES_NO_OPTION);

        if(action == JOptionPane.YES_OPTION) 
            bd.excluiComp(cel);
    }

    public void popUpExcluir(Notebook note) {
        String msg = strDados(note) + "\n\nExcluir item?";

        int action = JOptionPane.showConfirmDialog(null, msg, "Excluir?", JOptionPane.YES_NO_OPTION);

        if(action == JOptionPane.YES_OPTION) 
            bd.excluiComp(note);
    }

    public void popUpAlterar(Celular cel) {
        String msg = strDados(cel) + "\n\nAlterar valores?";

        int action = JOptionPane.showConfirmDialog(null, msg, "Alterar", JOptionPane.OK_CANCEL_OPTION);

        if(action == JOptionPane.OK_OPTION) {

            openJanelaCelular();

            Integer intRam = (Integer) cel.getRam();
            Integer intPreco = (Integer) cel.getPreco();
            Integer intCodRegiao = (Integer) cel.getRegiao().getCodigo();
            Integer intCodPais = (Integer) cel.getRegiao().getPais().getCodigo();
    
            valOperadora.setText( cel.getOperadora() );
            valMarca.setText( cel.getMarca() );
            valRam.setText( intRam.toString() );
            valPreco.setText( intPreco.toString() );
            valNomeRegiao.setText( cel.getRegiao().getNome() );
            valCodRegiao.setText( intCodRegiao.toString() );
            valNomePais.setText(cel.getRegiao().getPais().getNome() );
            valCodPais.setText( intCodPais.toString() );              
            
            bd.alteraComp(cel);
        }
    }

    public void popUpAlterar (Notebook note) {
        String msg = strDados(note) + "\n\nAlterar valores?";

        int action = JOptionPane.showConfirmDialog(null, msg, "Alterar", JOptionPane.OK_CANCEL_OPTION);

        if(action == JOptionPane.OK_OPTION) {

            openJanelaNotebook();

            Integer intRam = (Integer) note.getRam();
            Integer intPreco = (Integer) note.getPreco();
            Integer intCodRegiao = (Integer) note.getRegiao().getCodigo();
            Integer intCodPais = (Integer) note.getRegiao().getPais().getCodigo();
            Integer intUsb = (Integer) note.getQtdPortasUsb();

            valUsb.setText( intUsb.toString() );
            valMarca.setText( note.getMarca() );
            valRam.setText( intRam.toString() );
            valPreco.setText( intPreco.toString() );
            valNomeRegiao.setText( note.getRegiao().getNome() );
            valCodRegiao.setText( intCodRegiao.toString() );
            valNomePais.setText(note.getRegiao().getPais().getNome() );
            valCodPais.setText( intCodPais.toString() );

            bd.alteraComp(note);
        }
    }

    public String strDados(Celular cel) {
        return "\nMarca: " + cel.getMarca() + "\n" + cel.getRam() +  "GB de RAM\nOperadora: " + cel.getOperadora() + "\n" + cel.getPreco() + "R$";
    }

    public String strDados(Notebook note) {

        return ("\nMarca: " + note.getMarca() + "\n" + note.getRam() + "GB de RAM\n" + note.getQtdPortasUsb() + "Portas USB\n" + note.getPreco() + "R$");

    }

}