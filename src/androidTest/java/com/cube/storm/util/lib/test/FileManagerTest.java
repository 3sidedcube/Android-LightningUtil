package com.cube.storm.util.lib.test;

import android.test.ActivityInstrumentationTestCase2;

import java.io.IOException;

/**
 * Execute tests on the FileManager
 *
 * @author Matt Allen
 * @project StormUtil
 */
public class FileManagerTest extends ActivityInstrumentationTestCase2<TestActivity>
{
	private TestActivity mActivity;

	public FileManagerTest(Class<TestActivity> activityClass)
	{
		super(activityClass);
	}

	@Override public void setUp() throws Exception
	{
		super.setUp();
		mActivity = getActivity();
	}

	public void testWriteFile()
	{
		try
		{
			mActivity.writeFileToDisk();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
