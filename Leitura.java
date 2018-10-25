// Marília Machado Fernandez

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura {
  int valor;
  public String inDados(String rotulo) {
    InputStreamReader teclado = new InputStreamReader(System.in);
    BufferedReader mem = new BufferedReader(teclado);

    System.out.println(rotulo);

    String entrada = "";

    try {
      entrada = mem.readLine();
    }
    catch(IOException ioe) {
      System.out.println("\nErro no sistema.");
    }
    return entrada;
  }

  public int readRam()  {
    return Integer.parseInt( inDados("Informe a memoria RAM: ") ); 
  }

  public int readPreco() {
    return Integer.parseInt( inDados("Informe o preco: ") );
  }

  public String readMarca() {
    return inDados("Informe a marca:");
  }

  public String readNomeRegiao() {
    return inDados("Informe o nome da regiao: ");
  }

  public int readCodRegiao() {
    return Integer.parseInt( inDados("Informe o codigo da regiao: ") );
  }

  public String readNomePais() {
    return inDados("Infome o nome do pais");
  }

  public int readCodPais() {
    return Integer.parseInt( inDados("Informe o codigo do pais: ") );
  }

  public int readQtdPortasUsb() {
    return Integer.parseInt( inDados("Informe a quantidade de portas USB: ") );
  }

  public String readOperadora() {
    return inDados("Informe a operadora: ");
  }
}
