package com.nikhil.challenge.aoc1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchListTest {
	
	SearchList searchList = new SearchList();
	List<Integer> numbers = new ArrayList<>();
	
	@BeforeEach
	public void init() throws IOException {
		Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("challenge-1-input.txt").getPath()))
		.forEach(line -> numbers.add(Integer.parseInt(line)));
	}

	@DisplayName("Given a list of numbers and a number, find the two numbers in the list that add up to the given number")
	@Test
	void testFindNumberPairThatAddUpToTotal() {
		int total = 2020;
		List<Integer> sumElements = searchList.findNumberPairThatAddUpToTotal(total, numbers);
		assertNotNull(sumElements);
		int sumTotal = sumElements.stream().reduce((sum, number) -> sum + number).get();
		assertEquals(total, sumTotal);
		int productTotal = sumElements.stream().reduce((product, number) -> product * number).get();
		assertEquals(877971, productTotal);
	}
}
