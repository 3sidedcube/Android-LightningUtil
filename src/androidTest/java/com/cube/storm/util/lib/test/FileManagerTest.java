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
	private static final String TEST_FILE_NAME = "File";
	private static final String TEST_FILE_CONTENTS = "Test file !|?><~ZX~±!_+-=§1";
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

	public void testFileWrite() throws Exception
	{
		try
		{
			FileManager.getInstance().writeFile(TEST_FILE_NAME, TEST_FILE_CONTENTS);
			if (!FileManager.getInstance().fileExists(TEST_FILE_NAME))
			{
				fail("File not found on filesystem");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
