/**
 * @brief x lib is the library which includes the commonly used functions in 3 Sided Cube Android applications
 *
 * @author Callum Taylor
 **/
package com.cube.storm.util.lib.debug;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cube.storm.util.BuildConfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

/**
 * Class used for debugging throughout the application
 *
 * @author Callum Taylor
 * @project StormUtil
 */
public class Debug
{
	@Retention(RetentionPolicy.SOURCE)
	@IntDef({LEVEL_VERBOSE, LEVEL_DEBUG, LEVEL_WARNING, LEVEL_ERROR})
	public @interface DebugLevel {}

	public static final int LEVEL_VERBOSE = 2;
	public static final int LEVEL_DEBUG = 3;
	public static final int LEVEL_WARNING = 5;
	public static final int LEVEL_ERROR = 6;

	/**
	 * Default tag to use when logging
	 */
	public static String LOG_TAG = "DEBUG";

	/**
	 * Level to log out to
	 */
	@DebugLevel
	public static int LOG_LEVEL = LEVEL_ERROR;

	/**
	 * If the class is in debug mode. If this is false, then nothing will be outputted
	 */
	public static boolean DEBUG = BuildConfig.DEBUG;

	/**
	 * Logs out a collection of items
	 *
	 * @param args The collection to loop through and output
	 */
	public static void out(@Nullable Collection args)
	{
		if (!DEBUG) return;

		String output = "";

		if (args != null)
		{
			for (Object object : args)
			{
				if (object == null)
				{
					output += "[null]";
					continue;
				}

				output += String.valueOf(object) + ", ";
			}
		}

		longInfo(getCallingMethodInfo() + " " + output);
	}

	/**
	 * Logs out an array of objects
	 *
	 * @param args The array of objects to loop through and output
	 */
	public static void out(@Nullable Object... args)
	{
		if (!DEBUG) return;

		String output = "";

		if (args != null)
		{
			for (Object object : args)
			{
				if (object == null)
				{
					output += "[null]";
					continue;
				}

				output += String.valueOf(object) + ", ";
			}
		}

		longInfo(getCallingMethodInfo() + " " + output);
	}

	/**
	 * Outputs a string with an array of arguments for the strings placeholders
	 *
	 * @param str The string with % placeholders
	 * @param args The arguments for the placeholders
	 */
	public static void out(@NonNull String str, @Nullable Object... args)
	{
		if (!DEBUG) return;

		longInfo(getCallingMethodInfo() + " " + String.format(str, args));
	}

	/**
	 * Outputs an object
	 *
	 * @param obj The object to output
	 */
	public static void out(@Nullable Object obj)
	{
		if (!DEBUG) return;

		if (obj == null)
		{
			obj = "[null]";
		}

		longInfo(getCallingMethodInfo() + " " + obj.toString());
	}

	/**
	 * Logs a stacktrace to console (Overrides {@link #LOG_LEVEL}
	 *
	 * @param e The exception to output
	 */
	public static void out(@NonNull Exception e)
	{
		if (!DEBUG) return;

		e.printStackTrace();
	}

	/**
	 * Gets the calling method from where Debug was called
	 *
	 * @return The string file name and line number of where the method was called from
	 */
	private static String getCallingMethodInfo()
	{
		Throwable fakeException = new Throwable();
		StackTraceElement[] stackTrace = fakeException.getStackTrace();

		if (stackTrace != null && stackTrace.length >= 2)
		{
			StackTraceElement s = stackTrace[2];
			if (s != null)
			{
				return s.getFileName() + "(" + s.getMethodName() + ":" + s.getLineNumber() + "):";
			}
		}

		return null;
	}

	/**
	 * Cuts an output into smaller chunks to prevent the logger from cutting it off
	 *
	 * @param str The string to process
	 */
	private static void longInfo(@Nullable String str)
	{
		if (str == null) str = "[null]";

		if (str.length() > 4000)
		{
			Log.println(LOG_LEVEL, LOG_TAG, str.substring(0, 4000));
			longInfo(str.substring(4000));
		}
		else
		{
			Log.println(LOG_LEVEL, LOG_TAG, str);
		}
	}
}
