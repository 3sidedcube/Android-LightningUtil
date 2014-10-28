package com.cube.storm.util.lib.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import java.io.IOException;

/**
 * Execute tests on the FileManager
 *
 * @author Matt Allen
 * @project StormUtil
 */
public class FileManagerTest extends ActivityUnitTestCase<TestActivity>
{
	private TestActivity mActivity;

	public FileManagerTest(Class<TestActivity> activityClass)
	{
		super(TestActivity.class);
	}

	@Override
	public void setUp() throws Exception
	{
		super.setUp();
		startActivity(new Intent(getActivity(), TestActivity.class), null, null);
	}

	@MediumTest
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
