import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
import javax.swing.text.JTextComponent;

import java.awt.Container;


public class GUI implements ActionListener {

    private JFrame mainWindow = new JFrame("Computadores");
    private JFrame pesquisa = new JFrame("Pesquisa de produto");
    private JFrame cadastro = new JFrame("Cadastro");

    private JPanel panelCelular = new JPanel();
    private JPanel panelNotebook = new JPanel();

    private JLabel labelMarca = new JLabel("Marca:");
    private JLabel labelRam = new JLabel("* RAM (GB):");
    private JLabel labelPreco = new JLabel("* Preço (R$):");
    private JLabel labelCodigoCadastro = new JLabel("* Código do produto: ");
    private JLabel labelCodigoPesquisa = new JLabel("* Código do produto: ");
    private JLabel labelOperadora = new JLabel("Operadora:");
    private JLabel labelUsb = new JLabel("* Quantidade de portas USB:");
    private JLabel labelNomeRegiao = new JLabel("Nome da Região:");
    private JLabel labelCodRegiao = new JLabel("* Código da Região:");
    private JLabel labelNomePais = new JLabel("Nome do País:");
    private JLabel labelCodPais = new JLabel("* Código do País:");

    private JButton btnCelular = new JButton("Encontrar um celular");
    private JButton btnNotebook = new JButton("Encontrar um notebook");
    private JButton btnSalvarCelular = new JButton("Salvar Celular");
    private JButton btnSalvarNotebook = new JButton("Salvar Notebook");
    private JButton btnLimpar = new JButton("Limpar Tudo");
    private JButton btnPesquisarCel = new JButton("Pesquisar Celular");
    private JButton btnPesquisarNote = new JButton("Pesquisar Notebook");
    private JButton btnAlterarCel = new JButton("Alterar Celular");
    private JButton btnAlterarNote = new JButton("Alterar Notebook");

    private JTextField valMarca = new JTextField(10);
    private JTextField valRam = new JTextField(10);
    private JTextField valPreco = new JTextField(10);
    private JTextField valCodigo = new JTextField(10);
    private JTextField valOperadora = new JTextField(10);
    private JTextField valUsb = new JTextField(2);
    private JTextField valNomeRegiao = new JTextField(10);
    private JTextField valCodRegiao = new JTextField(2);
    private JTextField valNomePais = new JTextField(10);
    private JTextField valCodPais = new JTextField(2);
    private JTextField valPesquisaCod = new JTextField(10);

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu();
    private JMenu subMenuAdd = new JMenu();

    private JMenuItem menuItemSair = new JMenuItem();
    private JMenuItem menuItemCelular = new JMenuItem();
    private JMenuItem menuItemNotebook = new JMenuItem();

    private StorageComputador bd = new StorageComputador();

    private Celular celOriginal;
    private Notebook noteOriginal;


    public void openJanelaPrincipal() {
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(300, 200);

        menu.setText("Menu");
        subMenuAdd.setText("Adicionar novo");
        menuItemSair.setText("Sair");
        menuItemCelular.setText("Celular");
        menuItemNotebook.setText("Notebook");

        subMenuAdd.add(menuItemCelular);
        subMenuAdd.add(menuItemNotebook);
        
        menuBar.add(menu);
        menu.add(subMenuAdd);
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

        setLayoutJanela(cadastro);
        setLayoutJanela(pesquisa);
    }

    public void openJanelaCadastro(String tipo) {
        cadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cadastro.setSize(400,600);

        btnAlterarCel.setVisible(false);
        btnAlterarNote.setVisible(false);
        
        limparCampos();

        if( tipo == "celular" ) {
            panelCelular.setVisible(true);
            panelNotebook.setVisible(false);
            btnSalvarCelular.setVisible(true);
            btnSalvarNotebook.setVisible(false);
        }
        else if( tipo == "notebook" ) {
            panelCelular.setVisible(false);
            panelNotebook.setVisible(true);
            btnSalvarCelular.setVisible(false);
            btnSalvarNotebook.setVisible(true);
        }

        cadastro.setVisible(true); 
    }

    public void janelaPesquisar(String tipo) {
        pesquisa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pesquisa.setSize(300, 200);

        if(tipo == "celular" ) {
            pesquisa.setTitle("Procurar Celular");

            btnPesquisarCel.setVisible(true);
            btnPesquisarNote.setVisible(false);
        }
        else if(tipo == "notebook" ) {
            pesquisa.setTitle("Procurar Notebook");

            btnPesquisarCel.setVisible(false);
            btnPesquisarNote.setVisible(true);
        }

        pesquisa.setVisible(true);
    }

    public void setLayoutJanela(JFrame frame) {

        if(frame.equals(cadastro)) {
            
            JPanel panel = new JPanel();
            JPanel panelButtons = new JPanel();
            JPanel panelFrame = new JPanel();
            
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panelFrame.setLayout(new BoxLayout(panelFrame, BoxLayout.Y_AXIS));
            
            panelCelular.add(labelOperadora);
            panelCelular.add(valOperadora);
            
            panelNotebook.add(labelUsb);
            panelNotebook.add(valUsb);
            
            panel.add(labelCodigoCadastro);
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
            
            panelButtons.add(btnSalvarCelular);
            panelButtons.add(btnSalvarNotebook);
            panelButtons.add(btnLimpar);
            panelButtons.add(btnAlterarCel);
            panelButtons.add(btnAlterarNote);
            
            panelFrame.add(panelCelular);
            panelFrame.add(panelNotebook);
            panelFrame.add(panel);
            panelFrame.add(panelButtons);
            
            frame.add(panelFrame);

            btnSalvarCelular.addActionListener(this);
            btnSalvarNotebook.addActionListener(this);
            btnAlterarCel.addActionListener(this);
            btnAlterarNote.addActionListener(this);
            btnLimpar.addActionListener(this);
        }

        else if( frame.equals( pesquisa )) {
            pesquisa.add(labelCodigoPesquisa);
            pesquisa.add(valPesquisaCod);

            pesquisa.add(btnPesquisarCel);
            pesquisa.add(btnPesquisarNote);

            btnPesquisarCel.addActionListener(this);
            btnPesquisarNote.addActionListener(this);

            pesquisa.setLayout(new FlowLayout());

        }
    }

    public void actionPerformed(ActionEvent evt) {

        if( evt.getSource().equals(menuItemCelular) ) {
            openJanelaCadastro("celular");
        }   

        else if( evt.getSource().equals(menuItemNotebook) )  {
            openJanelaCadastro("notebook");
        }   

        else if( evt.getSource().equals(btnNotebook) ){
            janelaPesquisar( "notebook" );
        }

        else if( evt.getSource().equals(btnCelular) ) {
            janelaPesquisar( "celular" );
        }

        else if( evt.getSource().equals(btnSalvarCelular) ) {

            if( (Celular) bd.consultaComp( valCodigo.getText(), "celular" ) == null) {

                    Celular cel = new Celular(); 

                    try {
                        cel.setPreco( Integer.parseInt(valPreco.getText())  );
                        cel.setCodigo( valCodigo.getText() );
                        cel.setRam( Integer.parseInt(valRam.getText() ) );
                        cel.setRegiao(new Regiao(valNomeRegiao.getText(), Integer.parseInt(valCodRegiao.getText()), new Pais(valNomePais.getText(), Integer.parseInt(valCodPais.getText()) )));
                        cel.setMarca( valMarca.getText() ); 
                        cel.setOperadora( valOperadora.getText() );

                        if(popUpConfirmar("celular")) {

                            bd.inserirComp(cel);
                            popUpSucesso();
                            cadastro.dispose();
                        } 

                    } catch( UnderPriceException upe ) {
                        upe.retry( cel );
                    } catch( OverPriceException ope ) {
                        ope.retry( cel );
                    } catch(NumberFormatException num) {
                        JOptionPane.showMessageDialog(null, "Os campos marcados com (*) não podem ser nulos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch( NullCodException nce ) {
                        nce.retry( cel );
                    } 
            }
            else {
                JOptionPane.showMessageDialog(null, "Já existe um produto cadastrado com este código.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if(  evt.getSource().equals(btnSalvarNotebook) ) {

            if( (Notebook) bd.consultaComp(valCodigo.getText(), "notebook") == null ) {
                    
                Notebook note = new Notebook();
                        
                    try {
                            note.setPreco( Integer.parseInt(valPreco.getText()) );
                            note.setCodigo(valCodigo.getText() );
                            note.setMarca( valMarca.getText() );
                            note.setRam( Integer.parseInt( valRam.getText() ) );                    
                            note.setQtdPortasUsb( Integer.parseInt( valUsb.getText() ) );
                            note.setRegiao(new Regiao(valNomeRegiao.getText(), Integer.parseInt(valCodRegiao.getText()), new Pais(valNomePais.getText(), Integer.parseInt(valCodPais.getText()) )));
                        
                            if( popUpConfirmar( "notebook" )) {

                                bd.inserirComp(note);
                                popUpSucesso();
                                cadastro.dispose();
                            }
                        
                    } catch( UnderPriceException upe ) {
                            upe.retry( note );
                        } catch( OverPriceException ope ) {
                            ope.retry( note );
                        } catch(NumberFormatException num) {
                            JOptionPane.showMessageDialog(null, "Campos numéricos não podem ser nulos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        } catch( NullCodException nce ) {
                            nce.retry( note );
                        }
            }
            else {
                JOptionPane.showMessageDialog(null, "Já existe um produto cadastrado com este código.", "Erro", JOptionPane.ERROR_MESSAGE);

            }
            
        }

        else if( evt.getSource().equals(btnPesquisarCel) ) {
            Celular cel = (Celular) bd.consultaComp(valPesquisaCod.getText(), "celular");
            popUpMostrar(cel);
        }

        else if( evt.getSource().equals(btnPesquisarNote) ) {
            Notebook note = (Notebook) bd.consultaComp(valPesquisaCod.getText(), "notebook");
            popUpMostrar(note);
        }

        else if( evt.getSource().equals(btnAlterarCel) ) {
            Celular consulta = (Celular) bd.consultaComp(valCodigo.getText(), "celular");

            // Novo código deve ser diferente dos demais ou igual ao código antigo referente ao mesmo produto 
            if(( consulta == null ) || (  consulta.getCodigo().equals( valCodigo.getText().toString()) )){
                if( popUpConfirmar("celular") ) {
                    
                    Celular novoCel = new Celular();

                    novoCel.setMarca( valMarca.getText() ); 
                    novoCel.setRam( Integer.parseInt(valRam.getText() ) );
                        
                    try {
                        novoCel.setCodigo( valCodigo.getText() );
                        novoCel.setPreco( Integer.parseInt(valPreco.getText())  );
                    } catch( UnderPriceException upe ) {
                        upe.retry( novoCel );
                    } catch( OverPriceException ope ) {
                        ope.retry( novoCel );
                    } catch( NullCodException nce ) {
                        nce.retry( novoCel );
                    }
        
                    novoCel.setOperadora( valOperadora.getText() );

                    novoCel.setRegiao(new Regiao(valNomeRegiao.getText(), Integer.parseInt(valCodRegiao.getText()), new Pais(valNomePais.getText(), Integer.parseInt(valCodPais.getText()) )));
                    
                    if( bd.alteraComp(celOriginal, novoCel) != null)
                        popUpSucesso();

                    cadastro.dispose();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Já existe um produto cadastrado com este código.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if( evt.getSource().equals(btnAlterarNote) ) {

            Notebook consulta = (Notebook) bd.consultaComp(valCodigo.getText(), "notebook");
            
            // Novo código deve ser diferente dos demais ou igual ao código antigo referente ao mesmo produto 
            if(( consulta == null) || ( consulta.getCodigo().equals( valCodigo.getText().toString() ) ) ){
                if( popUpConfirmar("notebook") ) {
                    
                    Notebook novoNote = new Notebook();

                    novoNote.setMarca( valMarca.getText() ); 
                    novoNote.setRam( Integer.parseInt(valRam.getText() ) );
                    // novoNote.setCodigo( valCodigo.getText() );
                        
                    try {
                        novoNote.setCodigo( valCodigo.getText() );
                        novoNote.setPreco( Integer.parseInt(valPreco.getText())  );
                    } catch( UnderPriceException upe ) {
                        upe.retry( novoNote );
                    } catch( OverPriceException ope ) {
                        ope.retry( novoNote );
                    } catch( NullCodException nce) {
                        nce.retry(novoNote);
                    }
        
                    novoNote.setQtdPortasUsb( Integer.parseInt(valUsb.getText()) );

                    novoNote.setRegiao(new Regiao(valNomeRegiao.getText(), Integer.parseInt(valCodRegiao.getText()), new Pais(valNomePais.getText(), Integer.parseInt(valCodPais.getText()) )));
                    
                    if( bd.alteraComp(noteOriginal, novoNote) != null)
                        popUpSucesso();
                    


                    cadastro.dispose();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Já existe um produto cadastrado com este código.", "Erro", JOptionPane.ERROR_MESSAGE);
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
        valCodigo.setText("");  
        valOperadora.setText("");
        valUsb.setText(""); 
        valNomePais.setText("");
        valCodPais.setText("");
        valNomeRegiao.setText("");
        valCodRegiao.setText("");
    }

    public boolean popUpConfirmar(String tipo) {
        String mensagem = "";
        
        if(tipo == "celular")  
            mensagem = "\nProduto #" + valCodigo.getText() + ": Celular\n\nMarca: " + valMarca.getText() + "\nRAM: " + valRam.getText() + " GB\nOperadora: " + valOperadora.getText();
        else if(tipo == "notebook")
            mensagem = "\nProduto #" + valCodigo.getText() + ": Notebook\n\nMarca: " + valMarca.getText() + "\nRAM: " + valRam.getText() + " GB\nPortas USB: " + valUsb.getText();

        mensagem += "\n\nPaís: " + valNomePais.getText() + " (" + valCodPais.getText() + ")\nRegião: " + valNomeRegiao.getText() + " (" + valCodRegiao.getText() + ")\n\nR$ " + valPreco.getText();

        mensagem += "\n\nConfimar valores?";

        int action = JOptionPane.showConfirmDialog(null, mensagem, "Confirmar", JOptionPane.OK_CANCEL_OPTION);

        if(action == JOptionPane.OK_OPTION) 
            return true;            
        else
            return false;
    }

    public void popUpMostrar(Celular cel) {

        if( cel == null ) 
            JOptionPane.showMessageDialog(null, "Código não cadastrado", "Erro", JOptionPane.OK_OPTION);
        else {

            DecimalFormat df = new DecimalFormat("#.00");

            Object[] options = {"Alterar", "Excluir", "Voltar"};

            String msg = strDados(cel) +"\nUSD: " + df.format(cel.precoEmDolar()) + "\nImpostos: R$ " + df.format(cel.calculaImposto()); 
            
            int option = JOptionPane.showOptionDialog(null, msg, "Produto encontrado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[2]);
        
            // Alterar
            if(option == JOptionPane.YES_OPTION) {
                pesquisa.dispose();

                openJanelaCadastro("celular");
                btnAlterarCel.setVisible(true);
                btnAlterarNote.setVisible(false);
                
                btnSalvarCelular.setVisible(false);
                btnSalvarNotebook.setVisible(false);
        
                valOperadora.setText( cel.getOperadora() );
                valCodigo.setText( cel.getCodigo() );
                valMarca.setText( cel.getMarca() );
                valRam.setText( Integer.toString( cel.getRam() ) );
                valPreco.setText( Integer.toString( cel.getPreco() ) );
                valNomeRegiao.setText( cel.getRegiao().getNome() );
                valCodRegiao.setText( Integer.toString(  cel.getRegiao().getCodigo() ) );
                valNomePais.setText(cel.getRegiao().getPais().getNome() );
                valCodPais.setText( Integer.toString( cel.getRegiao().getPais().getCodigo() ) );              
                
                celOriginal = cel;
            }

            // Excluir
            else if( option == JOptionPane.NO_OPTION ) {
                int excluir = JOptionPane.showConfirmDialog(null, "Excluir Celular #" + cel.getCodigo() + " ?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           
                if( excluir == JOptionPane.YES_OPTION) {
                    bd.excluiComp(cel);
                    popUpSucesso();
                }

                pesquisa.dispose();
           
            }

            // Voltar
            else {
                pesquisa.dispose();
            }
        }
    }

    public void popUpMostrar(Notebook note) {
        if( note == null )
            JOptionPane.showMessageDialog(null, "Código não cadastrado", "Erro", JOptionPane.OK_OPTION);

        else {

            DecimalFormat df = new DecimalFormat("#.00");

            Object[] options = {"Alterar", "Excluir", "Voltar"};

            String msg = strDados(note) +"\nUSD: " + df.format(note.precoEmDolar()) + "\nImpostos: R$ " + df.format(note.calculaImposto());
            
            int option = JOptionPane.showOptionDialog(null, msg, "Produto encontrado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[2]);
            
            // Alterar
            if(option == JOptionPane.YES_OPTION) {
                pesquisa.dispose();

                openJanelaCadastro("notebook");
                btnAlterarNote.setVisible(true);
                btnAlterarCel.setVisible(false);
                btnSalvarCelular.setVisible(false);
                btnSalvarNotebook.setVisible(false);

                valUsb.setText( Integer.toString( note.getQtdPortasUsb() ) );
                valCodigo.setText( note.getCodigo() );
                valMarca.setText( note.getMarca() );
                valRam.setText( Integer.toString( note.getRam() ) );
                valPreco.setText( Integer.toString( note.getPreco() ) );
                valNomeRegiao.setText( note.getRegiao().getNome() );
                valCodRegiao.setText( Integer.toString(  note.getRegiao().getCodigo() ) );
                valNomePais.setText(note.getRegiao().getPais().getNome() );
                valCodPais.setText( Integer.toString( note.getRegiao().getPais().getCodigo() ) );

                noteOriginal = note;
            }

            // Excluir
            else if( option == JOptionPane.NO_OPTION ) {
                int excluir = JOptionPane.showConfirmDialog(null, "Excluir Notebook #" + note.getCodigo() + " ?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
                if( excluir == JOptionPane.YES_OPTION) {
                    bd.excluiComp( note );
                    popUpSucesso();
                }

                pesquisa.dispose();
            }

            // Voltar
            else {
                pesquisa.dispose();
            }
        }
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

    public void popUpSucesso () {
        JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public String strDados(Celular cel) {

        return "Produto #" + cel.getCodigo() + ": Celular\n\nMarca: " + cel.getMarca() + "\nRAM: " + cel.getRam() +  " GB\nOperadora: " + cel.getOperadora() + "\n\n"  + 
        "País: " + cel.getRegiao().getPais().getNome() + " (" + cel.getRegiao().getPais().getCodigo() + ")" + 
        "\nRegião: " + cel.getRegiao().getNome() + " (" + cel.getRegiao().getCodigo() + ")\n\nR$ " + cel.getPreco();
    }

    public String strDados(Notebook note) {

        return "Produto #" + note.getCodigo() + ": Notebook\n\nMarca: " + note.getMarca() + "\nRAM: " + note.getRam() + " GB\n" + note.getQtdPortasUsb() + " Portas USB\n\n" + 
        "País: " + note.getRegiao().getPais().getNome() + " (" + note.getRegiao().getPais().getCodigo() + ")" + 
        "\nRegião: " + note.getRegiao().getNome() + " (" + note.getRegiao().getCodigo() + ")\n\nR$ " + note.getPreco();

    }

}