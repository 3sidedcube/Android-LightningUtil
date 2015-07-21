package com.cube.storm.util.lib.processor;

import android.support.annotation.Nullable;

/**
 * Abstract class to deal with processing objects
 *
 * @author Callum Taylor
 * @project StormUtil
 */
public abstract class Processor<Input, Output>
{
	/**
	 * Processes a given input into an output
	 *
	 * @param input The input to process
	 *
	 * @return The output processed from the input
	 */
	@Nullable
	public abstract Output process(@Nullable Input input);
}
