package com.cube.storm.util.lib.test;

import android.app.Activity;
import android.os.Bundle;

import com.cube.storm.util.lib.manager.FileManager;

import java.io.IOException;

/**
 * Test activity to give all test cases a Context in which to run
 *
 * @author Matt Allen
 * @project Storm
 */
public class TestActivity extends Activity
{
	private static final String TEST_FILE_NAME = "testfile.txt";
	private static final String TEST_FILE_CONTENTS = "Test file !|?><~ZX~±!_+-=§1";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	public void writeFileToDisk() throws IOException
	{
		FileManager.getInstance().writeFile(getExternalCacheDir().getAbsolutePath()+TEST_FILE_NAME, TEST_FILE_CONTENTS);

		if (!FileManager.getInstance().fileExists(getExternalCacheDir().getAbsolutePath()+TEST_FILE_NAME))
		{
			throw new IOException("File not found on disk");
		}
	}

	public void readFileFromDisk() throws IOException
	{
		//FileManager.getInstance().readFile();
	}
}
