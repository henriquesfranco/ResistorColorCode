package com.rcc.resistorcolorcode;

import java.util.ArrayList;

public class Code {
	private int Digit1;
	private int Digit2;
	private int Digit3;
	
	private int multiplier;
	private int tolerance;
	private int temperatureCoefficient;
	
	private int type;
	
	private ArrayList<Float>	MultiplierList					= new ArrayList<Float>();
	private ArrayList<Float> 	toleranceList 					= new ArrayList<Float>();
	private ArrayList<Integer> 	TemperatureCoefficienteList 	= new ArrayList<Integer>();
	
	public Code(int type, int Digit1, int Digit2, int multiplier, int tolerance){ /*Type 4 constructor*/
		this.type		= type;
		this.Digit1 	= Digit1;
		this.Digit2 	= Digit2;
		this.multiplier = multiplier;
		this.tolerance 	= tolerance;
	}

	public Code(int type, int Digit1, int Digit2, int Digit3, int multiplier, int tolerance){ /*Type 5 constructor*/
		this.type		= type;
		this.Digit1 	= Digit1;
		this.Digit2 	= Digit2;
		this.Digit3 	= Digit3;
		this.multiplier = multiplier;
		this.tolerance 	= tolerance;
	}
	
	public Code(int type, int Digit1, int Digit2, int Digit3, int multiplier, int tolerance, int temperatureCoefficient){ /*Type 6 constructor*/
		this.type 					= type;
		this.Digit1 				= Digit1;
		this.Digit2 				= Digit2;
		this.Digit3					= Digit3;
		this.multiplier 			= multiplier;
		this.tolerance 				= tolerance;
		this.temperatureCoefficient = temperatureCoefficient;
	}

	public String getResistance(){
		InitArrays();
		
		String value = "";
		
		if(getType()==4) value = getResistance4();
		if(getType()==5) value = getResistance5();
		if(getType()==6) value = getResistance6();

		return value;
	}
	
	private String getResistance4(){
		float resistance = 0;
		String value = "";
		
		resistance = (getDigit1()*10 + getDigit2())*(MultiplierList.get(multiplier));
		value = "Resistance: " + resistance + "\nTolerance: " + toleranceList.get(tolerance) + "%\n";
		
		return value;
	}
	
	private String getResistance5(){
		float resistance = 0;
		String value = "";
		
		resistance = (getDigit1()*100 + getDigit2()*10 + getDigit3())*(MultiplierList.get(multiplier));
		value = "Resistance: " + resistance + "\nTolerance: " + toleranceList.get(tolerance) + "%\n";

		return value;
	}

	private String getResistance6(){
		float resistance = 0;
		String value = "";
		
		resistance = (getDigit1()*100 + getDigit2()*10 + getDigit3())*(MultiplierList.get(multiplier));
		value = "Resistance: " + resistance + "\nTolerance: " + toleranceList.get(tolerance) + "%\nTemperature Coefficient: " + TemperatureCoefficienteList.get(temperatureCoefficient) + "ppm";

		return value;
	}

	private void InitArrays(){
		MultiplierList.add((float) 0.01);
		MultiplierList.add((float) 0.1);
		MultiplierList.add((float) 1);
		MultiplierList.add((float) 10);
		MultiplierList.add((float) 100);
		MultiplierList.add((float) 1000);
		MultiplierList.add((float) 10000);
		MultiplierList.add((float) 100000);
		MultiplierList.add((float) 1000000);
		MultiplierList.add((float) 10000000);
		
		toleranceList.add((float) 10);
		toleranceList.add((float) 5);
		toleranceList.add((float) 1);
		toleranceList.add((float) 2);
		toleranceList.add((float) 0.5);
		toleranceList.add((float) 0.25);
		toleranceList.add((float) 0.1);
		
		TemperatureCoefficienteList.add(100);
		TemperatureCoefficienteList.add(50);
		TemperatureCoefficienteList.add(15);
		TemperatureCoefficienteList.add(25);
	}
	
	/*
	 * Generated Getters and Setters
	 */
	
	private int getDigit1() {
		return Digit1;
	}

	private int getDigit2() {
		return Digit2;
	}

	private int getDigit3() {
		return Digit3;
	}

	private int getType() {
		return type;
	}
}