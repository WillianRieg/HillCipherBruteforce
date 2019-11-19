package util;

import java.util.ArrayList;

public class ConversorPalavraMatriz {
	
	// Converte uma combinação de letras em uma matriz
	// e uma matriz em uma combinação de letras:
	// word = ABZ  <--->  matriz = |0 |
	//					           |1 |
	// 							   |25|
	
	// int[linha][coluna]
	
	public static int[][] toMatriz(char[] letras) {
		int[][] matriz = new int[letras.length][1];		
		for(int i = 0; i < letras.length; i++) {
			matriz[i][0] = ConversorLetraValor.asValor(letras[i]);
		}
		return matriz;
	}
	
	public static char[] toLetras(int[][] matriz) {		
		char[] letras = new char[matriz.length];		
		for(int i = 0; i < matriz.length; i++) {
			letras[i] = ConversorLetraValor.asLetra(matriz[i][0]);			
		}
		return letras;		
	}
	
	public static String[] toLetras(ArrayList<int[][]> matrizes){
		String[] subPalavras = new String[matrizes.size()];
		for(int i = 0; i < matrizes.size(); i++) {
			char[] letras = toLetras(matrizes.get(i));
			subPalavras[i] = String.copyValueOf(letras);
		}
		return subPalavras;
	}
	
	// Retorna um conjunto de matrizes de valores
	public static ArrayList<int[][]> toMatriz(String[] palavras){
		ArrayList<int[][]> result = new ArrayList<>();
		for(String palavra : palavras) {
			result.add(toMatriz(palavra.toCharArray()));
		}
		return result;
	}
	
}
