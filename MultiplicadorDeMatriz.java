package util;

import java.util.ArrayList;

public class MultiplicadorDeMatriz {

	// int[linha][coluna]

	// considerando que os tamanhos das matrizes estao corretos
	public static int[][] multiplicar(int[][] matrizA, int[][]matrizB){
		
		int numLinhas = matrizA.length;
		int numColunas = matrizB[0].length;
		
		// O num de linhas e colunas na matriz resultante e trocado
 		int[][] result = new int[numLinhas][numColunas];
		
		// para cada linha de A...
		for(int linhaA = 0; linhaA < matrizA.length; linhaA++) {
			
			// e para cada coluna de B...
			for(int colunaB = 0; colunaB < matrizB[0].length; colunaB++) {
				
				int sum = 0;
						
				// multiplicando cada elemento da linha de A
				// com cada linha da coluna de B
				for(int element = 0; element < matrizA[linhaA].length; element++) {
					int mult = matrizA[linhaA][element] * matrizB[element][colunaB];
					sum += mult;
				}
				
				result[linhaA][colunaB] = sum;
					
			}	
		}
		return result;
	}
	
	public static ArrayList<int[][]> multiplicar(int[][] matrizA, ArrayList<int[][]> matrizesB){
		ArrayList<int[][]> result = new ArrayList<>();
		for(int[][] matrizB : matrizesB) {
			result.add(multiplicar(matrizA, matrizB));
		}
		return result;
	}
	
}
