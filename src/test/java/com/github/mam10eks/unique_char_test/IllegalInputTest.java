package com.github.mam10eks.unique_char_test;

import java.util.Arrays;
import java.util.Collection;

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
public class IllegalInputTest
{
	private final String illegalInput;
	
	@Parameters
	public static Collection<String[]> parameters()
	{
		return Arrays.asList(
				new String[] {null},
				new String[] {""},
				new String[] {"aa"},
				new String[] {"aabb"},
				new String[] {"abab"},
				new String[] {"abba"});
	}
	
	@Test(expected=Exception.class)
	public void checkThatIllegalInputCausesExceptionForMemorySavingSolution()
	{
		MemorySavingSolution.determineFirstUniqueCharacter(illegalInput);
	}
	
	@Test(expected=Exception.class)
	public void checkThatIllegalInputCausesExceptionForTimeSavingSolution()
	{
		TimeSavingSolution.determineFirstUniqueCharacter(illegalInput);
	}
}
