package com.agomez.competidor.utils;


import com.agomez.competidor.model.Competidor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;

public class JsonConverter {
    
    private final Gson gson;
    
    public JsonConverter() {
        
        gson = new GsonBuilder().create();
    }

    public String convertToJson(List<Competidor> competidores) {
        
        JsonArray jarray = gson.toJsonTree(competidores).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("competidores", jarray);

        return jsonObject.toString();
    }
}