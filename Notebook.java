// Marília Machado Fernandez

public final class Notebook extends Computador implements Calcula, Converte { // Herança
  private int qtdPortasUsb;
  
  // Método Construtor sobrecarregado
  public Notebook() {
    qtdPortasUsb = 0;
  }

  public Notebook( int qtdPortasUsb ) {
    this.qtdPortasUsb = qtdPortasUsb;
  }

  public final void imprimeTipo() {
    System.out.println("\n\nNotebook:");
  }

  public void imprimeDados() {
    super.imprimeDados();
    System.out.println("Quantidade de portas USB: " + this.getQtdPortasUsb());
    System.out.println("Imposto sobre o produto: " + this.calculaImposto());
    System.out.println("Preco em dolar: " + this.precoEmDolar());
    System.out.println("\n\n");
  }

  public int getQtdPortasUsb() {
    return qtdPortasUsb;
  }

  public void setQtdPortasUsb(int qtdPortasUsb) {
    this.qtdPortasUsb = qtdPortasUsb;
  }

  // Método da interface Calcula 
  public double calculaImposto() {
    return fator * this.getPreco();
  }

  // Método da interface Converte
  public double precoEmDolar() {
    return cotacao * this.getPreco();
  }
}