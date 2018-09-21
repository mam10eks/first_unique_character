package com.github.mam10eks.unique_char_test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lombok.Data;

/**
 * 
 * @author Maik Fröbe
 *
 */
@Data
@RunWith(Parameterized.class)
public class InputsWithUniqueCharacterTest
{
	private final String input;
	
	private final char expectedCharacter;
	
	@Parameters
	public static Collection<Object[]> parameters()
	{
		return Arrays.asList(
				new Object[] {"abcd", 'a'},
				new Object[] {"e", 'e'},
				new Object[] {"aab", 'b'},
				new Object[] {"aacbb", 'c'},
				new Object[] {"ababe", 'e'},
				new Object[] {"hello", 'h'},
				new Object[] {"helloh", 'h'},
				new Object[] {"heleloh", 'o'},
				new Object[] {"abqba", 'q'}
				);
	}
	
	@Test
	public void checkThatMemorySavingSolutionFindsTheExpectedCharacter()
	{
		Assert.assertEquals(expectedCharacter, MemorySavingSolution.determineFirstUniqueCharacter(input));
	}
}
