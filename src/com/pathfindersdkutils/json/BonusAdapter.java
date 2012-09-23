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
import com.pathfindersdk.bonus.Bonus;

/**
 * This class allows read/write of Bonus objects into JSON, even when using polymorphism.
 * 
 */
public class BonusAdapter implements JsonSerializer<Bonus>,
    JsonDeserializer<Bonus>
{

  @Override
  public JsonElement serialize(Bonus bonus, Type type,
      JsonSerializationContext context)
  {
    JsonObject retValue = new JsonObject();
    String className = bonus.getClass().getCanonicalName();
    retValue.addProperty("CLASSNAME", className);
    JsonElement elem = context.serialize(bonus); 
    retValue.add("INSTANCE", elem);
    return retValue;
  }

  @Override
  public Bonus deserialize(JsonElement element, Type type,
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
