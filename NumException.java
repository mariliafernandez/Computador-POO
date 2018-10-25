import java.lang.NumberFormatException;

public class NumException extends Exception{
    public void reEnt(Computador comp) throws NumException {

        try {
            comp.setPreco(Integer.parseInt(in.leitura("\nEntre com o preco: ")));
        } catch(NumException ne) {
            ne.reEnt(comp);
        }
    } 
}