package main;

public class LinhaNumeros {
    
    private int[] numeros;
    private LinhaCombinacao combinacao;
    
    public LinhaNumeros( int[] numeros ) {
        this.numeros = numeros;
        this.combinacao = null;
    }
    
    public int setCombinacao( LinhaCombinacao combinacao ) {
        if( combinacao.length() == numeros.length ) {
            this.combinacao = combinacao;
            return combinacao.calcula(numeros);
        }
        return 0;
    }
    
    public LinhaCombinacao getCombinacao() {
        return combinacao;
    }
    
    public int length() {
        return numeros.length;
    }
    
    public String toString() {
        
        String string = "";
        
        for(Integer i:numeros)
            string += i.toString() + " ";
        
        return string;
    }
}
