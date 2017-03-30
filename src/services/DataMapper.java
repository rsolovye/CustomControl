package services;

import java.util.HashMap;

/**
 * Created by bobsol on 30.03.17.
 */
public class DataMapper {
    public static void saveToDB(HashMap<String, String> dataMap, String tableName){
        System.out.print("Saving to table : " + tableName);
        for (String s: dataMap.keySet()){
            System.out.println(s + " : " + dataMap.get(s));
        }
    }
}
