package main;

public class LinhaNumeros {
    
    private int[] numeros;
    private LinhaCombinacao combinacao;
    
    public LinhaNumeros( int[] numeros ) {
        this.numeros = numeros;
        this.combinacao = null;
    }
    
    public void setCombinacao( LinhaCombinacao combinacao ) {
        if( combinacao.length() == numeros.length ) {
            this.combinacao = combinacao;
        }
    }
    
    public int getNumero(int i) {
    	return numeros[i];
    }
    
    public LinhaCombinacao getCombinacao() {
        return combinacao;
    }
    
    public int length() {
        return numeros.length;
    }
    
    public String toString() {
        
        String string = "";
        
        for(int i = 0; i < length(); i++)
            string += String.format("(%d %c)", numeros[i], combinacao.getOperador(i));
        
        return string;
    }
}
