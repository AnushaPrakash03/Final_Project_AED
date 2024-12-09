/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDeserializer;
import Business.Enterprise.EnterpriseSerializer;
import Business.Enterprise.HealthCenterEnterprise;
import Business.Enterprise.GovernmentEnterprise;
import Business.Enterprise.InsuranceCompanyEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationSerializer;
import Business.Organization.OrganizationDeserializer;
import Business.Role.Role;
import Business.Role.RoleSerializer;
import Business.Role.RoleDeserializer;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.WorkRequestSerializer;
import Business.WorkQueue.WorkRequestDeserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 *
 * @author anushaprakash
 */
public class GsonFactory {
    
     public static Gson getGson() {
        return new GsonBuilder()
                // Register custom (de)serializers for Enterprise
                .registerTypeAdapter(Enterprise.class, new EnterpriseSerializer())
                .registerTypeAdapter(Enterprise.class, new EnterpriseDeserializer())

                // Register custom (de)serializers for Organization
                .registerTypeAdapter(Organization.class, new OrganizationSerializer())
                .registerTypeAdapter(Organization.class, new OrganizationDeserializer())
                
                // Register custom serializers and deserializers for Role
                .registerTypeAdapter(Role.class, new RoleSerializer())
                .registerTypeAdapter(Role.class, new RoleDeserializer())
                
                .registerTypeAdapter(WorkRequest.class, new WorkRequestSerializer())
                .registerTypeAdapter(WorkRequest.class, new WorkRequestDeserializer())

                .setPrettyPrinting() // Optional: Formats JSON for readability
                .create();
    }
}
   
