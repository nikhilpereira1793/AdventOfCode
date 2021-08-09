package com.nikhil.challenge.aoc1;

public class NumberPair {
	private int number1;
	private int number2;
	
	public NumberPair(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public int getTotal() {
		return this.number1 + this.number2;
	}
	
	public int getProduct() {
		return this.number1 * this.number2;
	}

	@Override
	public String toString() {
		return "NumberPair [number1=" + number1 + ", number2=" + number2 + "]";
	}
	
}
