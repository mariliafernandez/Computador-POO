// Marília Machado Fernandez
public abstract class Computador { // abstract -> Não pode ser instanciada diretamente

  // Atributos da Classe
  private String marca;
  private int preco; //R$
  private int ram; //GB
  private String codigo;
  private Regiao regiao;

  public Computador() {
    marca = "";
    ram = 0;
    preco = 0;
    codigo = "";
    regiao = new Regiao();
  }

  // Método Construtor sobrecarregado
  public Computador(String marca, int ram, int preco, String codigo, Regiao regiao) {
    this.marca = marca;
    this.ram = ram;
    this.preco = preco;
    this.codigo = codigo;
    this.regiao = regiao;
  }

/*
   Método abstrato somente contém a assinatura, 
   não tem corpo e é obrigado a ser implementado na classe filha.
   Somente implementado em classe abstrata
*/  
  public abstract void imprimeTipo(); 

  public void imprimeDados() {
    System.out.println("\nMarca: " + marca);
    System.out.println("Ram: " + ram);
    System.out.println("Preco: " + preco);
    System.out.println("Regiao: " + regiao.getNome());
    System.out.println("Codigo da Regiao: " + regiao.getCodigo());
    System.out.println("Pais: " + regiao.getPais().getNome());
    System.out.println("Codigo do Pais: " + regiao.getPais().getCodigo());
  }

  // Métodos
  public Regiao getRegiao() {
    return regiao;
  }

  public void setRegiao(Regiao regiao) {
    this.regiao = regiao;
  }

  public String getMarca() {
    return marca;
  }

  public int getRam() {
    return ram;
  }

  public int getPreco() {
    return preco;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setRam(int ram) {
      this.ram = ram;
  } 

  public void setCodigo( String codigo ) {
    this.codigo = codigo;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setPreco(int preco) throws UnderPriceException, OverPriceException{
    if(preco <= 0) {
      throw new UnderPriceException();
    }
    else if(preco > 25000){
      throw new OverPriceException();
    }
    else {
      this.preco = preco;
    }
  }
}
