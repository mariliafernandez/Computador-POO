// Marília Machado Fernandez

public final class Celular extends Computador { // Herança
  private String operadora;

  public Celular () {
    operadora = "";
  }

  public Celular(String operadora) {
    this.operadora = operadora;
  }

  public void imprimeTipo() {
    System.out.println("\n\nCelular:");
  }

  public void imprimeDados() {
    super.imprimeDados();
    System.out.println("Operadora: " + this.getOperadora());
  }

  public String getOperadora() {
    return operadora;
  }

  public void setOperadora(String operadora) {
    this.operadora = operadora;
  }
}
