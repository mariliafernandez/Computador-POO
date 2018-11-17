public class StorageComputador {
    private Celular[] vetCelular = new Celular[30];
    private Notebook[] vetNotebook = new Notebook[30];
    private int idCel = 0;
    private int idNote = 0;

    public void inserirComp( Celular cel ) {
        vetCelular[idCel] = cel;

        System.out.println("vetCelular[" + idCel + "]: " + vetCelular[idCel]);
        System.out.println("codigo: " + vetCelular[idCel].getCodigo());
        idCel++;
    }

    public void inserirComp( Notebook note ) {
        vetNotebook[idNote] = note;
        System.out.println("vetNotebook[" + idNote + "]: " + vetNotebook[idNote].getCodigo());

        idNote++;
    }

    public void alteraComp( Notebook note) {
        int i = 0;
        for( i = 0; i < vetNotebook.length; i++ ) {
            if( vetNotebook[i].equals( note ) ) {
            // ALTERA
            }
        }
    }

    public void alteraComp( Celular cel ) {
        int i = 0;
        for( i = 0; i < vetCelular.length; i++ ) {
            if( vetCelular[i].equals(cel) ) {
            //  ALTERA
            }
        }
    }

    public Computador consultaComp( String codigo ) {
        for( int i = 0; i < vetCelular.length; i++ ) {

            // System.out.println("indice: " + i );
            // System.out.println("codigo: " + vetCelular[i].getCodigo());

            if( vetCelular[i].getCodigo().equals(codigo) ) {
                return vetCelular[i];
            }
        }
        for( int i = 0; i < vetNotebook.length; i++ ) {
            if( vetNotebook[i].getCodigo() == codigo ) {
                return vetNotebook[i];
            }
        }
        return null;
    }

    public void excluiComp( Notebook note ) {
        
    }

    public void excluiComp( Celular cel ) {
        int i = 0;
        for( i = 0; i < vetCelular.length; i++ ) {
//         EXCLUI
        }
    }
        
}
