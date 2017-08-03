package com.rcc.resistorcolorcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ColorArrays {
	private ArrayList<String> Digit1 					= new ArrayList<String>();
	private ArrayList<String> Digit2 					= new ArrayList<String>();
	private ArrayList<String> Digit3 					= new ArrayList<String>();
	private ArrayList<String> Multiplier 				= new ArrayList<String>();
	private ArrayList<String> Tolerance 				= new ArrayList<String>();
	private ArrayList<String> TemperatureCoefficient 	= new ArrayList<String>();

	/*
	 * Definitions
	 */
	
	public ColorArrays() {
		Digit1.addAll(Arrays.asList("Black","Brown","Red","Orange","Yellow","Green","Blue","Purple","Gray","White"));
		Digit2.addAll(Arrays.asList("Black","Brown","Red","Orange","Yellow","Green","Blue","Purple","Gray","White"));
		Digit3.addAll(Arrays.asList("Black","Brown","Red","Orange","Yellow","Green","Blue","Purple","Gray","White"));
		Multiplier.addAll(Arrays.asList("Silver","Gold","Black","Brown","Red","Orange","Yellow","Green","Blue","Purple"));
		Tolerance.addAll(Arrays.asList("Silver","Gold","Brown","Red","Green","Blue","Purple"));
		TemperatureCoefficient.addAll(Arrays.asList("Brown","Red","Orange","Yellow"));
	}

	
	/*
	 * Generated Getters
	 */
	
	
	public List<String> getDigit1() {
		return Digit1;
	}
	public List<String> getDigit2() {
		return Digit2;
	}
	public List<String> getDigit3() {
		return Digit3;
	}
	public List<String> getMultiplier() {
		return Multiplier;
	}
	public List<String> getTolerance() {
		return Tolerance;
	}
	public List<String> getTemperatureCoefficient() {
		return TemperatureCoefficient;
	}
}