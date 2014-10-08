package com.cube.storm.util.lib.resolver;

import android.net.Uri;

/**
 * Abstract resolver class that helps to resolve a Uri to its correct Uri (in case of custom Uri schemes)
 * and to resolve files from a Uri
 *
 * @author Callum Taylor
 * @project StormUtil
 */
public abstract class Resolver
{
	public Uri resolveUri(String uri)
	{
		return resolveUri(Uri.parse(uri));
	}

	public abstract Uri resolveUri(Uri uri);

	public abstract byte[] resolveFile(Uri uri);
}
