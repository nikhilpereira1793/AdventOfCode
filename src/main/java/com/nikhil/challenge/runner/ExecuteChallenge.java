package com.nikhil.challenge.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.nikhil.challenge.aoc1.SearchList;

public class ExecuteChallenge {
	
    public static void main( String[] args ) throws IOException
    {
    	ExecuteChallenge executeChallenge = new ExecuteChallenge();
    	executeChallenge.execute();
    }
    
    public void execute() throws IOException {
    	// challenge 1 1st half
    	List<Integer> numbers = new ArrayList<>();
    	Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("challenge-1-input.txt").getPath()))
		.forEach(line -> numbers.add(Integer.parseInt(line)));
    	int total = 2020;
    	SearchList searchList = new SearchList();
		List<Integer> sumElements = searchList.findNumberPairThatAddUpToTotal(total, numbers);
		int result = sumElements.stream().reduce((product, number) -> product * number).get();
		System.out.println(result);
		// challenge 1 2nd half
		
    }
}
