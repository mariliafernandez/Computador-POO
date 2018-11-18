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
        System.out.println("codigo: " + vetNotebook[idNote].getCodigo());
        idNote++;
    }

    public Notebook alteraComp( Notebook antigo, Notebook novo) {
        int i = 0;
        for( i = 0; i < vetNotebook.length; i++ ) {
            if( vetNotebook[i] != null ) {
                if( vetNotebook[i].equals( antigo ) ) {
                    vetNotebook[i] = novo;
                    antigo = null;
                    return novo;
                }
            }
        }
        return null;
    }

    public Celular alteraComp( Celular antigo, Celular novo ) {
        int i = 0;
        for( i = 0; i < vetCelular.length; i++ ) {
            if( vetCelular[i] != null ) {
                if( vetCelular[i].equals( antigo ) ) {
                    vetCelular[i] = novo;
                    antigo = null;
                    return novo;
                }
            }
        }
        return null;
    }

    public Computador consultaComp( String codigo, String tipo ) {

        if( tipo.equals("celular") ) {
            for( int j = 0; j < vetCelular.length; j++ ) {

                if( vetCelular[j] != null ) {
                    if( vetCelular[j].getCodigo().equals(codigo ) ) {
                        return vetCelular[j];
                    }
                }
            }
            return null;
        }
        else if( tipo.equals("notebook") ) {
            for( int i = 0; i < vetNotebook.length; i++ ) {

                if( vetNotebook[i] != null ) {
                    if( vetNotebook[i].getCodigo().equals(codigo) ) {
                        return vetNotebook[i];
                    }
                }
            }
            return null;
        }

        else return null;
    }

    public void excluiComp( Notebook note ) {
        for ( int i = 0; i < vetNotebook.length; i++ ) {
            if( vetNotebook[i] != null ) {
                if( vetNotebook[i].equals( note ) ) 
                    vetNotebook[i] = null;
            }
        }
    }

    public void excluiComp( Celular cel ) {
        for( int i = 0; i < vetCelular.length; i++ ) {
           if( vetCelular[i] != null) {
                if(vetCelular[i].equals( cel ) ) 
                    vetCelular[i] = null;
           }
        }
    }
        
}
