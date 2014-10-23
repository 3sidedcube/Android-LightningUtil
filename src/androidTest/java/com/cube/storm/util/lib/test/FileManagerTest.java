package com.cube.storm.util.lib.test;

import com.cube.storm.util.lib.manager.FileManager;

import junit.framework.TestCase;

/**
 * Execute tests on the FileManager
 *
 * @author Matt Allen
 * @project StormUtil
 */
public class FileManagerTest extends TestCase
{
	@Override public void setUp() throws Exception
	{
		super.setUp();
	}

	public void testNullFileString() throws Exception
	{
		try
		{
			FileManager.getInstance().fileExists(null);
			FileManager.getInstance().getFileAge(null);
			FileManager.getInstance().readFile("");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testReadingFile() throws Exception
	{

	}
}
