package com.github.mam10eks.unique_char_test;

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
public class IllegalInputTest
{
	static Stream<Arguments> parameters()
	{
		return Stream.of(
			Arguments.of((String) null),
			Arguments.of(""),
			Arguments.of("aa"),
			Arguments.of("aabb"),
			Arguments.of("abab"),
			Arguments.of("abba"));
	}
	
	@ParameterizedTest
	@MethodSource("parameters")
	public void checkThatIllegalInputCausesExceptionForMemorySavingSolution(String illegalInput)
	{
		Assertions.assertThrows(Exception.class,
				() -> MemorySavingSolution.determineFirstUniqueCharacter(illegalInput));
	}
	
	@ParameterizedTest
	@MethodSource("parameters")
	public void checkThatIllegalInputCausesExceptionForTimeSavingSolution(String illegalInput)
	{
		Assertions.assertThrows(Exception.class,
				() -> TimeSavingSolution.determineFirstUniqueCharacter(illegalInput));
	}
	
	@ParameterizedTest
	@MethodSource("parameters")
	public void checkThatIllegalInputCausesExceptionForStreamingApiSolution(String illegalInput)
	{
		Assertions.assertThrows(Exception.class,
				() -> StreamingApiSolution.determineFirstUniqueCharacter(illegalInput));
	}
}
