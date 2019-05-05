package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {

    private static final String LOG ="" ;

    public static Sandwich parseSandwichJson(String json) {

        try {
                String mainName;
                JSONArray alsoKnownAs;
                String placeOfOrigin;
                String description;
                String image;
                JSONArray ingredients;
                JSONObject name;

                JSONObject jsonObject = new JSONObject( json );

                 name = jsonObject.getJSONObject( "name" );

                mainName = name.getString( "mainName" );

                alsoKnownAs = name.getJSONArray( "alsoKnownAs" );
                ArrayList <String> list = new ArrayList <>();
                for (int i = 0; i < alsoKnownAs.length(); i++) {
                    list.add( alsoKnownAs.getString( i ) );
                }
                placeOfOrigin = jsonObject.getString( "placeOfOrigin" );

                description = jsonObject.getString( "description" );

                image = jsonObject.getString( "image" );

                ingredients = jsonObject.getJSONArray( "ingredients" );
                ArrayList <String> ingredient = new ArrayList <>();
                for (int i = 0; i < ingredients.length(); i++) {
                    ingredient.add( ingredients.getString( i ) );
                }
                return new Sandwich( mainName, list, placeOfOrigin, description, image, ingredient );
        } catch (Exception e) {
            Log.e(LOG,"there is error on parsing",e);
        }
         return null;
       }
    }



