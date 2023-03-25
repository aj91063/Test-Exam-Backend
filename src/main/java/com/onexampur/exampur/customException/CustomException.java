package com.onexampur.exampur.customException;

import org.json.JSONObject;

public class CustomException extends Exception{
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("message","user detail");

        System.out.println(jsonObject);
    }
}
