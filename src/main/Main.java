package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StringTokenizer tokenizer;
    
    public static void main(String args[]) {
        
        ArrayList<CasoTeste> casosTeste = new ArrayList<CasoTeste>();
        int quantidadeLinhas, quantidadeColunas;
        
        while(true) {
            /*
                Pegamos o tamanho do quadro
            */
            System.out.println("Digite as dimensões da matriz (0 0 para finalizar)");
            String entrada = scanner.nextLine();
            tokenizer = new StringTokenizer(entrada);
            
            quantidadeLinhas = Integer.parseInt(tokenizer.nextToken());
            quantidadeColunas = Integer.parseInt(tokenizer.nextToken());
            
            if(quantidadeLinhas+quantidadeColunas > 0)
                casosTeste.add(geraCasoTeste(quantidadeLinhas, quantidadeColunas));
            else
                break;
        }
        
        for(CasoTeste c:casosTeste) {
            System.out.println(c.getMelhorValor());
        }
    }
    
    public static CasoTeste geraCasoTeste(int quantidadeLinhas, int quantidadeColunas) {
        
        String entrada;
        Quadro quadro = new Quadro(quantidadeLinhas,quantidadeColunas);
        LinhaCombinacao[] padroes;
        int quantidadePadroes;
                
        /*
            Lemos os dados da matriz do quadro premiado
        */
        for(int i = 0; i < quantidadeLinhas; i++) {
            
            int[] numerosLinha;
            String[] tokenized;
            
            entrada = scanner.nextLine();
            
            numerosLinha = new int[quantidadeColunas];
            tokenized = entrada.split(" ");
            for (int j = 0; j < tokenized.length; j++) {
                numerosLinha[j] = Integer.parseInt(tokenized[j]);
            }
            
            quadro.addLinha(new LinhaNumeros(numerosLinha));            
        }
        
        quantidadePadroes = scanner.nextInt();
        padroes = new LinhaCombinacao[quantidadePadroes];
        
        /*
            Lemos os padrões
        */
        scanner.nextLine();
        for(int j = 0; j < quantidadePadroes; j++) {
            
            entrada = scanner.nextLine();
            
            padroes[j] = new LinhaCombinacao(entrada.toCharArray());
        }
                
        return new CasoTeste(quadro, padroes);
    }

}
