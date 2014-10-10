package com.cube.storm.util.lib.processor;

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
	public JsonElement preInflate(JsonElement json)
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
	public T postInflate(T instance)
	{
		return instance;
	}

	@Override public abstract T deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException;
}
