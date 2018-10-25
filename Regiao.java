// Marília Machado Fernandez

public final class Regiao {
  private int codigo;
  private String nome;
  private Pais pais;

  // Construtor
  public Regiao() {
    codigo = 0;
    nome = "";
    pais = new Pais();
  }

  public Regiao(String nome, int codigo, Pais pais) {
    this.codigo = codigo;
    this.nome = nome;
    this.pais = pais;
  }

  public Pais getPais() {
    return pais;
  }

  public void setPais(Pais pais) {
    this.pais = pais;
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
