package main;

public class Quadro {

    private LinhaNumeros[] linhas;
    private int quantidadeLinhas, quantidadeColunas, proximo;
    
    public Quadro(int quantidadeLinhas, int quantidadeColunas) {
        this.quantidadeLinhas = quantidadeLinhas;
        this.quantidadeColunas = quantidadeColunas;
        this.proximo = 0;
        this.linhas = new LinhaNumeros[quantidadeLinhas];
    }

    public void addLinha(LinhaNumeros linha) {
        if(quantidadeLinhas != proximo && linha.length() == quantidadeColunas)
            linhas[proximo++] = linha;
    }
    
    public LinhaNumeros getLinha(int i) {
        return this.linhas[i];
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
