package com.nikhil.challenge.aoc1;

import java.util.Collections;
import java.util.List;

public class SearchList {

	public NumberPair findNumberPairThatAddUpToTotal(int total, List<Integer> numbers) {
		if(!numbers.isEmpty()) {
			Collections.sort(numbers);
			int smallestNumber = numbers.get(0);
			int largestNumber = numbers.get(numbers.size() - 1);
			for(int number: numbers) {
				System.out.println("Iteration "+number);
				int difference = total - number;
				if(difference >= smallestNumber 
						&& difference <= largestNumber 
						&& search(difference, numbers)) {
					return new NumberPair(number, difference);
				}
			}
		}
		return null;
	}

	private boolean search(int difference, List<Integer> numbers) {
		System.out.println("Search "+difference);
		int middleIndex = numbers.size()/2;
		int lowIndex = 0;
		int highIndex = numbers.size() - 1;
		while(lowIndex <= highIndex) {
			if(numbers.get(middleIndex) == difference) {
				return true;
			}
			else {
				if(difference < numbers.get(middleIndex)) {
					highIndex = middleIndex - 1;
				}
				if(difference > numbers.get(middleIndex)) {
					lowIndex = middleIndex + 1;
				}
				middleIndex = (lowIndex + highIndex)/2; 
			}
		}
		return false;
	}
}
