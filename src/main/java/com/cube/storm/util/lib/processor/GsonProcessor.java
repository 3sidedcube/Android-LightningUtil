package com.cube.storm.util.lib.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * View processor class used to process a json object
 *
 * @author Callum Taylor
 * @project StormUtil
 */
public abstract class GsonProcessor<T> implements JsonDeserializer<T>
{
	/**
	 * Called before the model is inflated from the json. Use this method to manipulate the json object.
	 *
	 * @param json The input json element
	 *
	 * @return The output json element. Defaults to return {@param json}
	 */
	@NonNull
	public JsonElement preInflate(@NonNull JsonElement json)
	{
		return json;
	}

	/**
	 * Called after the model is inflated from the json. Use this method to manipulate the created instance.
	 *
	 * @param instance The inflated instance
	 *
	 * @return The output instance. Defaults to return {@param instance}
	 */
	@NonNull
	public T postInflate(@NonNull T instance)
	{
		return instance;
	}

	/**
	 * Deserialises a json object into a java object
	 *
	 * @param jsonElement The JSON element to process
	 * @param typeOf The type of class to use
	 * @param context The context of the json deserialisation
	 *
	 * @return The object created
	 *
	 * @throws JsonParseException
	 */
	@Nullable
	@Override public abstract T deserialize(JsonElement jsonElement, Type typeOf, JsonDeserializationContext context) throws JsonParseException;
}
