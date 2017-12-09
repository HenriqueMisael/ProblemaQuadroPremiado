package main;

public class LinhaCombinacao {

    char[] combinacao;
    
    public LinhaCombinacao(char[] combinacao) {
        this.combinacao = combinacao;
    }
    
    public char getOperador(int posicao) {
        return combinacao[posicao];
    }
    
    public int length() {
        return combinacao.length;
    }
    
    public boolean isConflitante(LinhaCombinacao linha) {
        
        for(int i = 0; i < combinacao.length; i++) {
            if(this.getOperador(i) == linha.getOperador(i))
                return false;
        }
        return true;
    }
    
    public String toString() {
        String string = "";
        
        for(char c:combinacao)
            string += c;
        
        return string + " ";
    }

    public int calcula(int[] numeros) {

        int valor = 0;
        
        for(int i = 0; i < numeros.length; i++)
            switch(combinacao[i]) {
            case '+': valor += numeros[i];break;
            case '-': valor -= numeros[i];break;
            default: valor += 0;
            }
            
        return valor;
    }
}
