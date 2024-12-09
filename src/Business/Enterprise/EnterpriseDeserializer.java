/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import com.google.gson.*;

import java.lang.reflect.Type;
/**
 *
 * @author anushaprakash
 */
public class EnterpriseDeserializer implements JsonDeserializer<Enterprise> {
    @Override
    public Enterprise deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();

        switch (type) {
            case "HealthCenterEnterprise":
                return context.deserialize(json, HealthCenterEnterprise.class);
            case "GovernmentEnterprise":
                return context.deserialize(json, GovernmentEnterprise.class);
            case "InsuranceCompanyEnterprise":
                return context.deserialize(json, InsuranceCompanyEnterprise.class);
            case "PharmacyEnterprise":
                return context.deserialize(json, PharmacyEnterprise.class);
            default:
                throw new JsonParseException("Unknown type: " + type);
        }
    }
}
