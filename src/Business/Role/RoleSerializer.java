/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 *
 * @author anushaprakash
 */
public class RoleSerializer implements JsonSerializer<Role> {

    @Override
    public JsonElement serialize(Role src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(src).getAsJsonObject(); // Serialize Role object
        jsonObject.addProperty("type", src.getType()); // Add the type field to the JSON
        return jsonObject;
    }
}
