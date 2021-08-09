package com.nikhil.challenge.aoc1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchList {

	public List<Integer> findSumElementsThatAddUpToTotal(int total, List<Integer> numbers) {
		List<Integer> sumElements = new ArrayList<>();
		if(!numbers.isEmpty()) {
			Collections.sort(numbers);
			for(int number: numbers) {
				int difference = total - number;
				List<Integer> differenceSumElements = findSumElementsThatAddUpToDifference(difference, numbers);
				if(!differenceSumElements.isEmpty()) {
					sumElements.addAll(differenceSumElements);
					sumElements.add(number);
					return sumElements;
				}
			}
		}
		return null;
	}

	private List<Integer> findSumElementsThatAddUpToDifference(int total, List<Integer> numbers) {
		List<Integer> sumElements = new ArrayList<>();
		if(!numbers.isEmpty()) {
			int smallestNumber = numbers.get(0);
			int largestNumber = numbers.get(numbers.size() - 1);
			for(int number: numbers) {
				int difference = total - number;
				if(difference >= smallestNumber 
						&& difference <= largestNumber 
						&& search(difference, numbers)) {
					sumElements.add(difference);
					sumElements.add(number);
					return sumElements;
				}
			}
		}
		return null;
	}

	private boolean search(int difference, List<Integer> numbers) {
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
