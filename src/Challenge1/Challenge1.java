package Challenge1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Challenge1 {

	//2a
		public String random (String type) {
			
			
			
			String num = "0123456789";
			Random mRandom = new Random();
			String Result = "";		
			String Result1 = "";	
			
			
			for (int i = 0; i < 10; i++) {
				
				int posicion = mRandom.nextInt(num.length());
				char caracter = num.charAt(posicion);
				Result += caracter;
			}
				
				if (type == "Tipo A") {
					
					Result1="54"+Result.substring(2);
					
					
				}
				else if (type == "Tipo B") {
					
					Result1 = "08" + Result.substring(2);
					
				}

			
			
			return Result1;
			
			
		}
		
		
		//2b
		
		public boolean verify (String word, List<String> list) {
			
			boolean result= list.contains(word);
			
			if (result == false) {
				return true;
			}
			else return false;
			
			
		}
		
		
		
		
		
		public static void main(String[] args) {
			
			Challenge1 mChallenge1 = new Challenge1();
			System.out.println(mChallenge1.random("Tipo A"));
			
			
			String word = "a";
			List<String> list = Arrays.asList("a","b","c");
			System.out.println(mChallenge1.verify(word,list));
			
			
		}
	
}
