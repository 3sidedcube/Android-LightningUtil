package com.cube.storm.util.lib.resolver;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.cube.storm.util.lib.manager.FileManager;

import java.io.File;
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

	@Override public byte[] resolveFile(@NonNull Uri uri)
	{
		return FileManager.getInstance().readFile(new File(URI.create(uri.toString())));
	}
}
