package com.pathfindersdkutils.json;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.pathfindersdk.bonus.BonusStrategy;

/**
 * This class allows read/write of Bonus objects into JSON, even when using polymorphism.
 * 
 */
public class BonusStrategyAdapter implements JsonSerializer<BonusStrategy>,
    JsonDeserializer<BonusStrategy>
{

  @Override
  public JsonElement serialize(BonusStrategy strategy, Type type,
      JsonSerializationContext context)
  {
    JsonObject retValue = new JsonObject();
    String className = strategy.getClass().getCanonicalName();
    retValue.addProperty("CLASSNAME", className);
    JsonElement elem = context.serialize(strategy); 
    retValue.add("INSTANCE", elem);
    return retValue;
  }

  @Override
  public BonusStrategy deserialize(JsonElement element, Type type,
      JsonDeserializationContext context) throws JsonParseException
  {
    JsonObject jsonObject =  element.getAsJsonObject();
    JsonPrimitive prim = (JsonPrimitive) jsonObject.get("CLASSNAME");
    String className = prim.getAsString();

    Class<?> klass = null;
    try {
        klass = Class.forName(className);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new JsonParseException(e.getMessage());
    }
    return context.deserialize(jsonObject.get("INSTANCE"), klass);
  }

}
