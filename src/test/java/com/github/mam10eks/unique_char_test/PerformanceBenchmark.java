package com.github.mam10eks.unique_char_test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import lombok.Data;

public class PerformanceBenchmark
{
	@Data
	@State(Scope.Thread)
	public static class BenchmarkData
	{
		private List<String> exampleInputs = Collections.unmodifiableList(Arrays.asList(
				"e",
				"aab",
				"aacbb",
				"ababe",
				"i"+ "aab".repeat(10),
				"i"+ "aacbb".repeat(10),
				"i"+ "ababe".repeat(10),
				"aab".repeat(100) +"i",
				"aacbb".repeat(100) +"i",
				"ababe".repeat(100) +"i",
				"aab".repeat(10000) +"i",
				"aacbb".repeat(10000) +"i",
				"ababe".repeat(10000) +"i"
				));
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void timeOfStreamingApiSolution(BenchmarkData benchmarkData, Blackhole blackHole)
	{
		executeWorkForBenchmark(StreamingApiSolution::determineFirstUniqueCharacter, benchmarkData, blackHole);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void timeOfMemorySavingSolution(BenchmarkData benchmarkData, Blackhole blackHole)
	{
		executeWorkForBenchmark(MemorySavingSolution::determineFirstUniqueCharacter, benchmarkData, blackHole);
	}
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void timeOfTimeSavingSolution(BenchmarkData benchmarkData, Blackhole blackHole)
	{
		executeWorkForBenchmark(TimeSavingSolution::determineFirstUniqueCharacter, benchmarkData, blackHole);
	}
	
	private static void executeWorkForBenchmark(Function<String, Character> function, BenchmarkData benchmarkData, Blackhole blackHole)
	{
		for(String input : benchmarkData.exampleInputs)
		{
			blackHole.consume(function.apply(input));
		}
	}
}
