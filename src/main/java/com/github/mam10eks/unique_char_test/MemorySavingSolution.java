package com.github.mam10eks.unique_char_test;

import lombok.experimental.UtilityClass;

/**
 * 
 * @author Maik Fröbe
 *
 */
@UtilityClass
public class MemorySavingSolution
{
	public static char determineFirstUniqueCharacter(String input)
	{
		for(char c : input.toCharArray())
		{
			if(countOccurrencesOfCharacterInString(c, input) == 1)
			{
				return c;
			}
		}
		
		throw new IllegalArgumentException("Illegal input '"+ input +"'!");
	}
	
	private static int countOccurrencesOfCharacterInString(char c, String input)
	{
		var ret = 0;
		
		for(char charInInput : input.toCharArray())
		{
			if(c == charInInput)
			{
				ret++;
			}
		}
		
		return ret;
	}
}
