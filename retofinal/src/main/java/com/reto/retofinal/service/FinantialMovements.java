package com.reto.retofinal.service;

public class FinantialMovements {
	
	public float finantialMovements (float value, float balance, String movementType) {
		
		
		float Result = 0 ;
		
		if (movementType.equalsIgnoreCase("credit")) {
			
			Result = balance + value ;
			
		} 
		else if (movementType.equalsIgnoreCase("debit")) {
			
			Result = balance - value ;
				
			}

		
		return Result;
		
	}
	
}
