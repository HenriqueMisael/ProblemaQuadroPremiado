package main;

public class CasoTeste {

    private Quadro quadro;
    private LinhaCombinacao[] padroes;
    
    public CasoTeste(Quadro quadro, LinhaCombinacao[] padroes) {
        this.quadro = quadro;
        this.padroes = padroes;
    }
    
    public int getMelhorValor() {
        return getMelhorValor(0);
    }
    
    public int getMelhorValor(int linhaQuadro) {
        
        CasoTeste caso;
        int melhorValor = 0;
        
        if(linhaQuadro < quadro.length())        
            for (int i = 0; i < padroes.length; i++) {
                if(linhaQuadro == 0 || !padroes[i].isConflitante(quadro.getLinha(linhaQuadro-1).getCombinacao())) {
                    caso = new CasoTeste(quadro, padroes);
                    melhorValor = Integer.max(melhorValor, quadro.getLinha(linhaQuadro).setCombinacao(padroes[i]) + caso.getMelhorValor(linhaQuadro+1));
                }
            }
        
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
