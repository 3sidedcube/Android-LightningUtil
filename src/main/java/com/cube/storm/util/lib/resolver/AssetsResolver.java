package com.cube.storm.util.lib.resolver;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resolves a file from the assets directory of the app
 *
 * @author Callum Taylor
 * @project StormUtil
 */
public class AssetsResolver extends Resolver
{
	/**
	 * The context used to access the assets
	 */
	private Context context;

	/**
	 * Main constructor
	 *
	 * @param context The context to access the application's assets
	 */
	public AssetsResolver(Context context)
	{
		this.context = context;
	}

	@Override public Uri resolveUri(@NonNull Uri uri)
	{
		if ("assets".equalsIgnoreCase(uri.getScheme()))
		{
			return uri;
		}

		return null;
	}

	@Override public InputStream resolveFile(@NonNull Uri uri)
	{
		String filePath = "";

		if (!TextUtils.isEmpty(uri.getHost()))
		{
			filePath += uri.getHost();
		}

		if (!TextUtils.isEmpty(uri.getPath()))
		{
			filePath += uri.getPath();
		}

		try
		{
			return context.getAssets().open(filePath);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
