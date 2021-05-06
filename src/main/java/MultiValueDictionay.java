import java.io.IOException;
import java.util.*;

public class MultiValueDictionay {

    public static void main(String[] args) {
        String ADD = "ADD";
        String KEYS = "KEYS";
        String MEMBERS = "MEMBERS";
        String REMOVE = "REMOVE";
        String REMOVEALL = "REMOVEALL";
        String CLEAR = "CLEAR";
        String KEYEXISTS = "KEYEXISTS";
        String VALUEEXISTS = "VALUEEXISTS";
        String ALLMEMBERS = "ALLMEMBERS";
        String ITEMS = "ITEMS";
        String EXIT = "EXIT";

        HashMap<String, String> map = new HashMap();

        Scanner reader = new Scanner(System.in).useDelimiter("\\n");
        try{
            while(true){
                String operationAndValue = reader.nextLine();
                ArrayList<String> inputList = new ArrayList<String>();
                String[] oprAndValArray = operationAndValue.trim().split(" ");
                if(oprAndValArray.length != 0){
                    int i = 0;
                    for(String s : oprAndValArray)
                        inputList.add(i++, s);
                    // call methods based on operation
                    String operation = oprAndValArray[0];
                    DictionaryOperations op = new DictionaryOperations();

                    if (ADD.equalsIgnoreCase(operation) && oprAndValArray.length == 3) {
                        op.add(map,oprAndValArray[1],oprAndValArray[2]);
                    }

                    if(KEYS.equalsIgnoreCase(operation)){
                        op.keys(map);
                    }
                    if(MEMBERS.equalsIgnoreCase(operation) && oprAndValArray.length == 2){
                        op.members(map,oprAndValArray[1]);
                    }
                    if(REMOVE.equalsIgnoreCase(operation) && oprAndValArray.length > 1 ){
                        if(oprAndValArray.length == 2 ){
                            op.removeKey(map,oprAndValArray[1]);
                        }else{
                            op.removeValue(map, oprAndValArray[1],oprAndValArray[2]);
                        }

                    }
                    if(REMOVEALL.equalsIgnoreCase(operation) && oprAndValArray.length == 2){
                        op.removeAll(map,oprAndValArray[1]);
                    }
                    if(CLEAR.equalsIgnoreCase(operation) && oprAndValArray.length == 1){
                        op.clear(map);
                    }
                    if(KEYEXISTS.equalsIgnoreCase(operation) && oprAndValArray.length == 2){
                        op.keyExists(map, oprAndValArray[1]);
                    }
                    if(VALUEEXISTS.equalsIgnoreCase(operation) && oprAndValArray.length == 3){
                        op.valueExists(map, oprAndValArray[1], oprAndValArray[2]);
                    }
                    if(ALLMEMBERS.equalsIgnoreCase(operation) && oprAndValArray.length == 1){
                        op.allMembers(map);
                    }
                    if(ITEMS.equalsIgnoreCase(operation) && oprAndValArray.length == 1){
                        op.items(map);
                    }
                    if(EXIT.equalsIgnoreCase(operation)){
                        System.exit(0);
                    }
                }
                else{
                    System.out.println("Enter valid Input");
                }
            }
        } catch(Exception e) {
            // System.in has been closed
            System.out.println("System.in was closed; exiting");
        }

    }

}
