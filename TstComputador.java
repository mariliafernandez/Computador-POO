// Marília Machado Fernandez

public class TstComputador {
  public static void main(String arg[]) {

    Leitura leitura = new Leitura();

    // Setando atributos da classe Notebook
    Computador comp1 = new Notebook(); 
    Notebook notebook = ( Notebook ) comp1;
    notebook.imprimeTipo();
    notebook.setQtdPortasUsb( leitura.readQtdPortasUsb() );
    notebook.setMarca( leitura.readMarca() );
    notebook.setRam( leitura.readRam() );
    
    while( notebook.getPreco() <= 0 ) {
      try {
        notebook.setPreco( leitura.readPreco() );
      } catch( UnderPriceException erro ) {
        erro.printException();
      } catch( OverPriceException erro ) {
        erro.printException();
      }
    }
    
    notebook.setRegiao( 
      new Regiao( 
        leitura.readNomeRegiao(), 
        leitura.readCodRegiao(), 
        new Pais(
          leitura.readNomePais(),
          leitura.readCodPais()
        )
      )
    );

    // Setando atributos da classe Celular
    System.out.println("Celular");

    Computador comp2 = new Celular();
    Celular celular = ( Celular ) comp2;
    celular.imprimeTipo();
    celular.setOperadora( leitura.readOperadora() );
    celular.setMarca( leitura.readMarca() );
    celular.setRam( leitura.readRam() );
    
    try {
      celular.setPreco( leitura.readPreco() );
    } catch( UnderPriceException erro ) {
      erro.printException();
    } catch( OverPriceException erro ) {
      erro.printException();
    }

    celular.getRegiao().setNome( leitura.readNomeRegiao() );
    celular.getRegiao().setCodigo( leitura.readCodRegiao() ); 
    celular.getRegiao().getPais().setNome( leitura.readNomePais() );
    celular.getRegiao().getPais().setCodigo( leitura.readCodPais() );


    //  Imprime os dados na tela
    notebook.imprimeTipo();
    notebook.imprimeDados(); 

    celular.imprimeTipo();
    celular.imprimeDados();
  }
}
