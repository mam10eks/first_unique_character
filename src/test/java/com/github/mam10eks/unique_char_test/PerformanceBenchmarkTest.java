package com.github.mam10eks.unique_char_test;

import java.io.File;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;

public class PerformanceBenchmarkTest
{
	private static final String RESULT_DIRECTORY = "target/reports/jmh/";
	
	@Test
	public void executeBenchmarks() throws Exception
	{
		createResultDirectory();
		Options options = new OptionsBuilder()
			.include(PerformanceBenchmark.class.getSimpleName())
			.forks(1)
			.result(RESULT_DIRECTORY+ "result.json")
			.resultFormat(ResultFormatType.JSON)
			.build();
		
		Collection<RunResult> results = new Runner(options).run();
		Assertions.assertFalse(results.isEmpty());
	}
	
	private static void createResultDirectory()
	{
		new File(RESULT_DIRECTORY).mkdirs();
	}
}
