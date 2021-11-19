package com.cube.storm.util.lib.resolver;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.InputStream;

/**
 * Abstract resolver class that helps to resolve a Uri to its correct Uri (in case of custom Uri schemes)
 * and to resolve files from a Uri
 *
 * @author Callum Taylor
 * @project StormUtil
 */
public abstract class Resolver
{
	/**
	 * Resolves a string uri into a correct uri. Use this method to convert from a custom uri scheme
	 * into a standard one such as `cache://` to `file://` or `assets://`
	 *
	 * @param uri The uri to resolve
	 *
	 * @deprecated use {@link #resolveUri(Uri)} instead. This is a convenience method.
	 * @return The resolved uri or null
	 */
	@Nullable @Deprecated
	public Uri resolveUri(@NonNull String uri)
	{
		return resolveUri(Uri.parse(uri));
	}

	/**
	 * Resolves a string uri into a correct uri. Use this method to convert from a custom uri scheme
	 * into a standard one such as `cache://` to `file://` or `assets://`
	 *
	 * @param uri The uri to resolve
	 *
	 * @return The resolved uri or null
	 */
	@Nullable
	public abstract Uri resolveUri(@NonNull Uri uri);

	/**
	 * Resolves a file from the given uri. This will load the file synchronously.
	 *
	 * @param uri The uri to resolve
	 *
	 * @return The input stream to the file. You can use {@link com.cube.storm.util.lib.manager.FileManager#readFile(java.io.InputStream)} to resolve the stream
	 * into a byte array
	 */
	@Nullable
	public abstract InputStream resolveFile(@NonNull Uri uri);
}
