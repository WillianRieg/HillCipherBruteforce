import util.CifradorHill;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.math.*;

 public class Main {
  public static void main(String[] args) {
    
String cifrado = "abdoqubvfa";
	  
	  String PalavraOriginal = "helloworld";
		
      ArrayList<int[][]> keys = new ArrayList<int[][]>();
	  
	  ArrayList<int[][]> dirtyKeys = new ArrayList<int[][]>();

      for(int a=0;a<10; a++) {
        
        for(int b=0;b<10; b++) {
          
          for(int c=0;c<10; c++) {
            
            for(int d=0;d<10; d++) {
				
				int[][] key1 = {{a,b},{c,d}};
				int[][] key2 = {{a,b},{d,c}};
				int[][] key3 = {{a,c},{b,d}};
				int[][] key4 = {{a,c},{d,b}};
				int[][] key5 = {{a,d},{b,c}};
				int[][] key6 = {{a,d},{c,b}};
				int[][] key7 = {{b,a},{c,d}};
				int[][] key8 = {{b,a},{d,c}};
				int[][] key9 = {{b,c},{a,d}};
				int[][] key10 = {{b,c},{d,a}};
				int[][] key11 = {{b,d},{a,c}};
				int[][] key12 = {{b,d},{c,a}};
				int[][] key13 = {{c,a},{b,d}};
				int[][] key14 = {{c,a},{d,b}};
				int[][] key15 = {{c,b},{a,d}};
				int[][] key16 = {{c,b},{d,a}};
				int[][] key17 = {{c,d},{a,b}};
				int[][] key18 = {{c,d},{b,a}};
				int[][] key19 = {{d,a},{b,c}};
				int[][] key20 = {{d,a},{c,b}};
				int[][] key21 = {{d,b},{a,c}};
				int[][] key22 = {{d,b},{c,a}};
				int[][] key23 = {{d,c},{a,b}};
				int[][] key24 = {{d,c},{b,a}};
				
              	dirtyKeys.add(key1);
				dirtyKeys.add(key2);
				dirtyKeys.add(key3);
				dirtyKeys.add(key4);
				dirtyKeys.add(key5);
				dirtyKeys.add(key6);
				dirtyKeys.add(key7);
				dirtyKeys.add(key8);
				dirtyKeys.add(key9);
				dirtyKeys.add(key10);
				dirtyKeys.add(key11);
				dirtyKeys.add(key12);
				dirtyKeys.add(key13);
				dirtyKeys.add(key14);
				dirtyKeys.add(key15);
				dirtyKeys.add(key16);
				dirtyKeys.add(key17);
				dirtyKeys.add(key18);
				dirtyKeys.add(key19);
				dirtyKeys.add(key20);
				dirtyKeys.add(key21);
				dirtyKeys.add(key22);
				dirtyKeys.add(key23);
				dirtyKeys.add(key24);
            }    
          }
        }
      }
	  
	  System.out.println("Chaves geradas: " + dirtyKeys.size());
	  
	  for (int[][] ecoChave : dirtyKeys){
		  if (!keys.contains(ecoChave)){
			  keys.add(ecoChave);
		  }
	  }
	  
	  System.out.println("Chaves unicas: " + keys.size());
      
      CifradorHill encriptador;
      
      String chaveSaida;
      
      for(int[][] chave : keys) {
        
        chaveSaida = "Chave: {{" + chave[0][0] + "," + chave[0][1] + "},{" + chave[1][0] + "," + chave[1][1] + "}} => ";
        
        try {
 			
          	encriptador = new CifradorHill(chave, 2);
        
        	String decifrado = encriptador.decifrar(cifrado);
          
			if (decifrado == PalavraOriginal) {
				System.out.println(chaveSaida + decifrado);
			}
          
        } catch (Exception ex) {
			//System.out.println(chaveSaida + " error");
        }
      }
	  
		
  }
}