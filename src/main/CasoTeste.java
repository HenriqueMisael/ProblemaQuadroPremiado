package main;

public class CasoTeste {

    private Quadro quadro;
    private LinhaCombinacao[] padroes;
    
    public CasoTeste(Quadro quadro, LinhaCombinacao[] padroes) {
        this.quadro = adicionaLinhaAuxiliar(quadro);
        this.padroes = padroes;
    }
    
    private Quadro adicionaLinhaAuxiliar(Quadro quadro) {
    	
    	LinhaNumeros linhaAuxiliar;
    	int[] numeros = new int[quadro.getLinha(0).length()];
    	char[] combinacao = new char[quadro.getLinha(0).length()];
    	
    	for(int n : numeros) {
    		n = 0;
    	}    	
    	for(char c : combinacao) {
    		c = '.';    	
    	}
    	
    	linhaAuxiliar = new LinhaNumeros(numeros);
    	linhaAuxiliar.setCombinacao(new LinhaCombinacao(combinacao));
    	
    	quadro.addLinha(linhaAuxiliar);
    	
		return quadro;
	}

	public int getMelhorValor() {
        return getMelhorValor(quadro.last());
    }
    
    public int getMelhorValor(int linhaQuadro) {
        
        int melhorValor = 0;
        
        if(linhaQuadro >= 0)
        	for(LinhaCombinacao padrao:padroes)
        		if(!padrao.isConflitante(quadro.getLinha(linhaQuadro+1).getCombinacao())) {
        			quadro.getLinha(linhaQuadro).setCombinacao(padrao);
        			melhorValor = Integer.max(melhorValor, padrao.calcula(quadro.getLinha(linhaQuadro)) + this.getMelhorValor(linhaQuadro-1));
        		}        			
        System.out.println(quadro);
        return melhorValor;
    }
    
    public String toString() {
        
        String padroesToString, string = "";
        
        padroesToString = "";
        for(LinhaCombinacao l:padroes)
            padroesToString += l.toString();
        
        string += "Quadro: " + quadro.toString() + "\n--------------";
        string += "Padroes: " + padroesToString + "\n--------------";
        
        return string;
    }
}
