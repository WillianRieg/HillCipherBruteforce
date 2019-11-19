package util;

import java.math.BigInteger;

public class ConversorIntBigMatriz {

	public static int[][] toInt(BigInteger[][] big){
		
		int nrow = big.length;
		int ncol = big[0].length;
		
		int[][] result = new int[nrow][ncol];
		
		for(int row = 0; row < nrow; row ++) {
			for(int col = 0; col < ncol; col++) {
			
				result[row][col] = new Integer(big[row][col].intValue()); 
				
			}			
		}
		
		return result;		
	}
	
	public static BigInteger[][] toBig(int[][] inte){
		
		int nrow = inte.length;
		int ncol = inte[0].length;
		
		BigInteger[][] result = new BigInteger[nrow][ncol];
		
		for(int row = 0; row < nrow; row ++) {
			for(int col = 0; col < ncol; col++) {
			
				result[row][col] = BigInteger.valueOf(inte[row][col]); 
				
			}			
		}
		
		return result;		
	}
	
}
