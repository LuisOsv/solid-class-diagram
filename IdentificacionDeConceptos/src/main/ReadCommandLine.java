package main;

import java.util.Scanner;

public class ReadCommandLine {
	private Scanner readLine;
	
	public ReadCommandLine(){
		readLine = new Scanner(System.in);
	}
	public String readStringValue(){
		return readLine.next();
	}
	
	public void printMessage(String message){
		System.out.println(message);
	}
	
	private boolean isDecimalNumber(String value){
		try {
			Double.valueOf(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean isDecimalNumberValueGreaterThanZero(double number){
		if(number > 0)
			return true;
		else
			return false;
	}
	
	public double readDoubleValueGreaterThanZero(String message){
		printMessage(message);
		String valueEntered = readStringValue();
		if(isDecimalNumber(valueEntered)){
			
			if(isDecimalNumberValueGreaterThanZero(Double.valueOf(valueEntered))){
				return Double.valueOf(valueEntered);
			}
			else{
				printMessage("El valor introducido debe ser mayor a 0. Pruebe nuevamente");
				return readDoubleValueGreaterThanZero(message);
			}
		}
		else{
			printMessage("El valor introducido no es numerico pruebe nuevamente");
			return readDoubleValueGreaterThanZero(message);
		}
		
			
	}

}
