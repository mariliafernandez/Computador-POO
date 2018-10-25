// Marília Machado Fernandez

public final class Pais {
  private int codigo;
  private String nome;

  // Construtor
  public Pais() {
      codigo = 0;
      nome = "";
  }

  public Pais (String nome, int codigo) {
    this.nome = nome;
    this.codigo = codigo;
  }

  public int getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
