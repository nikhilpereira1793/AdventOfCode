package com.nikhil.challenge.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.nikhil.challenge.aoc1.NumberPair;
import com.nikhil.challenge.aoc1.SearchList;

public class ExecuteChallenge {
	
    public static void main( String[] args ) throws IOException
    {
    	ExecuteChallenge executeChallenge = new ExecuteChallenge();
    	executeChallenge.execute();
    }
    
    public void execute() throws IOException {
    	List<Integer> numbers = new ArrayList<>();
    	Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("challenge-1-input.txt").getPath()))
		.forEach(line -> numbers.add(Integer.parseInt(line)));
    	int total = 2020;
    	SearchList searchList = new SearchList();
		NumberPair sumElements = searchList.findNumberPairThatAddUpToTotal(total, numbers);
		System.out.println(sumElements);
    }
}
