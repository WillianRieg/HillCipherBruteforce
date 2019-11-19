package util;

import java.math.BigInteger;
import java.util.ArrayList;

public class CifradorHill {
	
	int[][] key;
	int[][] inverseKey;
	int blocoSize;
	
	public CifradorHill(int[][] key, int blocoSize) {	
		this.key = key;
		this.inverseKey = getInverseKey(key);
		this.blocoSize = blocoSize;
	}
	
	public String cifrar(String palavra) {
		
		// Quebrando palavra em blocos
		// helloworld ---> he ll ow or ld
		String[] subPalavras = quebrarPalavra(palavra);
		
		// Transformando blocos de letras em matriz de valores
		// he --> {{7},{4}} , ll --> {{11}, {11}} ...
		ArrayList<int[][]> valores = ConversorPalavraMatriz.toMatriz(subPalavras);
		
		// Multiplicando matriz de valores pela chave
		// K * {{7},{4}} --> {{26},{27}}
		ArrayList<int[][]> criptValores = MultiplicadorDeMatriz.multiplicar(key, valores);
		
		// Transformando valores gerados em blocos de letras
		// {{26},{27}} --> ab , {{55}, {66}} --> do ...
		String[] criptSubPalavras = ConversorPalavraMatriz.toLetras(criptValores);
		
		// formando palavra cifrada apartir dos blocos cifrados
		// ab do qu bv fa --> abdoqubvfa
		String cript = formarPalavra(criptSubPalavras);
		
		return cript;
	}
	
	public String decifrar(String palavra) {
	
		// Mudando a chave pela chave inversa para
		// cifrar de forma contraria, ou seja, decifrar
		int[][] backupKey = key;
		this.key = this.inverseKey;
		
		String decifrado = cifrar(palavra);
		
		// Retornando valor da chave pelo valor original
		this.key = backupKey;
		
		return decifrado;
	}
	
	// quebra palavra em blocos de tamanho blocoSize
	public String[] quebrarPalavra(String palavra) {
			
		String palavraCompleta = completarPalavra(palavra);
		
		int quantBloco = palavraCompleta.length() / this.blocoSize;
		String[] blocos = new String[quantBloco];
		
		int beginIndex = 0;
		int endIndex = blocoSize;
		for(int i = 0; i < quantBloco; i++) {
			blocos[i] = palavraCompleta.substring(beginIndex, endIndex);
			beginIndex += blocoSize;
			endIndex += blocoSize;
		}
		
		return blocos;
	}	
	
	private String formarPalavra(String[] subPalavras) {
		String result = "";
		for(String subPalavra : subPalavras) {
			result += subPalavra;
		}
		return result;
	}
	
	private String completarPalavra(String palavra) {
		
		int mod = palavra.length() % this.blocoSize;
		if(mod == 0) {
			return palavra;
		}
		
		String newPalavra = palavra;
		for(int i = 0; i < this.blocoSize - mod; i++) {
			newPalavra += "h";
		}
		return newPalavra;
		
	}	
	
	private int[][] getInverseKey(int[][] key){
		BigInteger[][] bigKey = ConversorIntBigMatriz.toBig(key);
		ModMatrix keyMatriz = new ModMatrix(bigKey);
		ModMatrix inverseMatriz = keyMatriz.inverse(keyMatriz);
		BigInteger[][] bigInverserKey = inverseMatriz.getData();
		int[][] inverseKey = ConversorIntBigMatriz.toInt(bigInverserKey);
		return inverseKey;
	}
}
