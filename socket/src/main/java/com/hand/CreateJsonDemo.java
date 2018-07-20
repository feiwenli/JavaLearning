package com.hand;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateJsonDemo {
    public static void main(String [] args){
        JsonObject object = new JsonObject();
        object.addProperty("cat","it");

        JsonArray array = new JsonArray();
        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id",1);
        lan1.addProperty("name","java");
        lan1.addProperty("ide","Eclipse");
        array.add(lan1);

        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id",2);
        lan2.addProperty("name","Swift");
        lan2.addProperty("ide","XCode");
        array.add(lan2);

        object.add("languages",array);

        object.addProperty("pop",true);

        System.out.println(object.toString());
    }
}
