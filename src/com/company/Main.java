package com.company;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * This program takes a JSON file as an input and outputs a star bar chart
 * that corresponds to the amount of items listed in the file
 * @author Diana Suankulova
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //JSON parser object to parse read file
        JSONParser parser = new JSONParser();
        try {
            //Read JSON file
            Object obj = parser.parse(new FileReader("src\\com\\company\\test.json"));
            JSONObject jsonObject = (JSONObject) obj;
            //Get xtitle value
            String title = (String)jsonObject.get("xtitle");
            //Get ytitle value
            String title2 = (String)jsonObject.get("ytitle");
            //Get array of objects called items
            JSONArray items = (JSONArray)jsonObject.get("items");
            System.out.println("Title: " + title+ " "+ title2 + "\n");
            //Iterate over the items array
            items.forEach( item -> printItemCount( (JSONObject) item ) );
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method prints a name and star line for each item in the JSONArray
     * @param item key-value pair inside the items array
     */
    private static void printItemCount(JSONObject item)
    {
        //Since every key is different, create an iterator to access item values
        Iterator<String> keys= item.keySet().iterator();
        //For each item in the array there is going to be 1 key and 1 value
        while (keys.hasNext())
        {
            String key = keys.next();
            Long value = (Long) item.get(key);
            System.out.println(key);
            for(int i =0; i<value;i++){
                System.out.print("* ");
            }
            System.out.println("\n");
        }

    }
}


