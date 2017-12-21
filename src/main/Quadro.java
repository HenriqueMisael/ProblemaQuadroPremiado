package main;

public class Quadro {

    private LinhaNumeros[] linhas;
    private int proximo, quantidadeLinhas;
    
    public Quadro(int quantidadeLinhas) {
        this.quantidadeLinhas = quantidadeLinhas;
    	this.proximo = 0;
        this.linhas = new LinhaNumeros[quantidadeLinhas+1];
    }

    public void addLinha(LinhaNumeros linha) {
        linhas[proximo++] = linha;
    }
    
    public LinhaNumeros getLinha(int i) {
        return this.linhas[i];
    }
    
    public int last() {
    	return quantidadeLinhas-1;
    }
    
    public String toString() {
        
        String string = "";
        
        for(LinhaNumeros linha:linhas) {
            string += linha.toString() + "\n";
        }
        
        return string;
    }

    public int length() {
        return linhas.length;
    }
}
