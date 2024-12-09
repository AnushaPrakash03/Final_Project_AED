/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.OperatingSystem;

import com.google.gson.Gson;

/**
 *
 * @author anushaprakash
 */
public class OperatingSystem {
    private String name;
    private String version;

    // Default Constructor
    public OperatingSystem() {}

    // Parameterized Constructor
    public OperatingSystem(String name, String version) {
        this.name = name;
        this.version = version;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    // Serialize to JSON
    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Deserialize from JSON
    public static OperatingSystem deserialize(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, OperatingSystem.class);
    }
}
