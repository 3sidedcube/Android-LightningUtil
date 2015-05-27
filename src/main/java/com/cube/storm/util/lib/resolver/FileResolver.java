package com.cube.storm.util.lib.resolver;

import android.net.Uri;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

/**
 * Resolves a file from an absolute file path
 *
 * @author Callum Taylor
 * @project StormUtil
 */
public class FileResolver extends Resolver
{
	@Override public Uri resolveUri(@NonNull Uri uri)
	{
		if ("file".equalsIgnoreCase(uri.getScheme()))
		{
			return uri;
		}

		return null;
	}

	@Override public InputStream resolveFile(@NonNull Uri uri)
	{
		try
		{
			return new FileInputStream(new File(URI.create(uri.toString())));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
