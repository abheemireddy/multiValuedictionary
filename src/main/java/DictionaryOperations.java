import java.util.HashMap;
import java.util.Set;

public class DictionaryOperations {

    //Returns all the keys in the dictionary
    public void keys(HashMap<String,String> map){
        Set<String> allKeys = map.keySet();
        if(allKeys.isEmpty()){
            System.out.println("empty set");
        }else{
            int j = 1;
            for (String s : allKeys) {
                System.out.println(j++ +")"+s);
            }
        }
    }

    //add a member to the dictionary if value already exists return an error
    public void add(HashMap<String, String> map, String key, String value){
        if(map.containsKey(key)){
            String existingValue = map.get(key);
            String[] existingValueArray = existingValue.split(",");
            for(String s :existingValueArray){
                if(s.equalsIgnoreCase(value)){
                    System.out.println("ERROR, value already exists");
                    break;
                }
            }
            map.put(key, existingValue+","+value);
        }else{
            map.put(key,value);
        }
        System.out.println("Added");
    }

    //print values for the given key
    public void members(HashMap<String, String> map, String key) {
        if(map.containsKey(key)){
            String value = map.get(key);
            String[] valueMembers = value.split(",");
            int j = 1;
            for(String s : valueMembers){
                System.out.println(j++ +")"+s);
            }
        }else{
            System.out.println("ERROR, key does not exist.");
        }
    }

    //remove all values for the key
    public void removeKey(HashMap<String, String> map, String key) {
        if(map.containsKey(key)){
            map.remove(key);
            System.out.println("Removed");
        }
        else{
            System.out.println("ERROR, key does not exist");
        }
    }

    //remove specific value for specific key
    public void removeValue(HashMap<String, String> map, String key, String value) {
        if(map.containsKey(key)){
            boolean valueFound = false;
            String keyValues = map.get(key);
            String[] valueMembers = keyValues.split(",");
            StringBuilder result = new StringBuilder();
            for(String s : valueMembers){
                if(s.equalsIgnoreCase(value)){
                    valueFound = true;
                    map.remove(key,value);
                }else{
                    result.append(s).append(",");
                }
            }
            if(result.length() != 0){
                map.put(key, result.substring(0,result.length()-1));
            }
            if(valueFound)
                System.out.println("Removed");
            else
                System.out.println("ERROR, value does not exist");
        }
        else{
            System.out.println("ERROR, key does not exist");
        }
    }

    //remove all values for the key from the dictionary
    public void removeAll(HashMap<String, String> map, String key) {
        if(map.containsKey(key)){
            map.remove(key);
            System.out.println("Removed");
        }
        else{
            System.out.println("ERROR, key does not exist");
        }
    }

    //clear the entire dictionary of key and values
    public void clear(HashMap<String, String> map) {
        map.clear();
        System.out.println("Cleared");
    }

    //check if key exists in dictionary
    public void keyExists(HashMap<String, String> map, String key) {
        if(map.containsKey(key))
            System.out.println("True");
        else
            System.out.println("False");
    }

    //check if value exists in dictionary
    public void valueExists(HashMap<String, String> map, String key, String value) {
        if(map.containsKey(key)){
            String existingValue = map.get(key);
            String[] existingValueArray = existingValue.split(",");
            for(String s :existingValueArray){
                if(s.equalsIgnoreCase(value)){
                  System.out.println("True");
                  break;
                }
                System.out.println("False");
            }
        }else {
            System.out.println("False");
        }
    }

    //print all values in the dictionary
    public void allMembers(HashMap<String, String> map) {
        if(map.isEmpty()){
            System.out.println("Empty Set");
        }else{
            int j = 1;
             for(Object s : map.values().toArray()){
                 String[] valueArray= s.toString().split(",");
                 for(int i = 0; i < valueArray.length; i++)
                     System.out.println(j++ +")"+ valueArray[i]);
             }

        }
    }

    //print all keys and values from the dictionary
    public void items(HashMap<String, String> map) {
        if(map.isEmpty()){
            System.out.println("Empty Set");
        }else{
            int j = 1;
            Set<String> keySet = map.keySet();
            for(Object s : keySet.toArray()){
                String value = map.get(s);
                String[] valueArray= value.split(",");
                for(int i = 0; i < valueArray.length; i++)
                    System.out.println(j++ +")"+s+" : "+ valueArray[i]);
            }
        }
    }
}
