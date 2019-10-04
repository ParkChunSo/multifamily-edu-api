package com.cosmos.multifamily.config;

import com.cosmos.multifamily.domain.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class UserAdapter implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", src.getUserId());
        jsonObject.addProperty("userPw", src.getUserPw());
        jsonObject.addProperty("level", src.getLevel());
        jsonObject.addProperty("mobile", src.getMobile());
        jsonObject.addProperty("name", src.getName());
        jsonObject.addProperty("response", src.getResponse());
        return jsonObject;
    }
}
