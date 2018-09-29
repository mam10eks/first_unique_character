package com.github.mam10eks.unique_char_test;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import com.google.common.primitives.Chars;

/**
 * 
 * @author Maik Fröbe
 *
 */
public class StreamingApiSolution
{
	public static char determineFirstUniqueCharacter(String input)
	{
		return Chars.asList(input.toCharArray()).stream()
				.collect(Collectors.toMap(c -> c, c -> 1, (a,b) -> a+b, () -> new LinkedHashMap<>()))
				.entrySet().stream()
				.filter(e -> e.getValue() == 1)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Illegal input!"))
				.getKey();
	}
}
