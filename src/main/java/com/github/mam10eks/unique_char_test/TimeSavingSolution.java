package com.github.mam10eks.unique_char_test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import lombok.experimental.UtilityClass;

/**
 * 
 * @author Maik Fröbe
 *
 */
@UtilityClass
public class TimeSavingSolution
{
	public static char determineFirstUniqueCharacter(String input)
	{
		var charactersToCount = mapCharactersAfterTheirFirstOccurenceToCount(input);
		
		return determineFirstCharacterWithCountOneOrFail(charactersToCount);
	}
	
	private static LinkedHashMap<Character, Integer> mapCharactersAfterTheirFirstOccurenceToCount(String input)
	{
		var ret = new LinkedHashMap<Character, Integer>();
		
		for(char c : input.toCharArray())
		{
			if(!ret.containsKey(c))
			{
				ret.put(c, 0);
			}
			
			ret.put(c, ret.get(c) +1);
		}
		
		return ret;
	}
	
	private static char determineFirstCharacterWithCountOneOrFail(LinkedHashMap<Character, Integer> charactersToCount)
	{
		for(Entry<Character, Integer> characterToCount : charactersToCount.entrySet())
		{
			if(characterToCount.getValue() == 1)
			{
				return characterToCount.getKey();
			}
		}
		
		throw new IllegalArgumentException("Illegal input!");
	}
}
