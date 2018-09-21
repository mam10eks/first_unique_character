package com.github.mam10eks.unique_char_test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 
 * @author Maik Fröbe
 *
 */
public class InputsWithUniqueCharacterTest
{
	private static Stream<Arguments> parameters()
	{
		return Stream.of(
			Arguments.of("abcd", 'a'),
			Arguments.of("e", 'e'),
			Arguments.of("aab", 'b'),
			Arguments.of("aacbb", 'c'),
			Arguments.of("ababe", 'e'),
			Arguments.of("hello", 'h'),
			Arguments.of("helloh", 'e'),
			Arguments.of("heleloh", 'o'),
			Arguments.of("abqba", 'q'));
	}
	
	@ParameterizedTest
	@MethodSource("parameters")
	public void checkThatMemorySavingSolutionFindsTheExpectedCharacter(String input, char expectedCharacter)
	{
		Assertions.assertEquals(expectedCharacter, MemorySavingSolution.determineFirstUniqueCharacter(input));
	}

	@ParameterizedTest
	@MethodSource("parameters")
	public void checkThatTimeSavingSolutionFindsTheExpectedCharacter(String input, char expectedCharacter)
	{
		Assertions.assertEquals(expectedCharacter, TimeSavingSolution.determineFirstUniqueCharacter(input));
	}
}
