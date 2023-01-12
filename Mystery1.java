import java.util.ArrayList;
import java.util.HashMap;

public class Mystery1{


    private HashMap<String, ArrayList<String>> S;

    public Mystery1(){
        S = new HashMap<String, ArrayList<String>>();
    }

    private void addPair(String key, String value) {
		if(!S.containsKey(key)) {
			S.put(key, new ArrayList<String>());
		}
		if(!S.containsKey(value)) {
			S.put(value, new ArrayList<String>());
		}
		if(!S.get(key).contains(value)) {
			S.get(key).add(value);
		}
		
	}

    public void f1(String s1, String s2){

        if(s1 != s2){
            addPair(s1, s2);
        }
    }

    public int f2(String s) {
        int count = 0;
    
        for (String key : S.keySet()) {
            ArrayList<String> list = S.get(key);
            for(String str : list){
                if(str == s){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean f3(String s1, String s2) {
        if(S.containsKey(s1) && S.containsKey(s2)){
            return DFS(s1, s2) && S.get(s2).contains(s1);
        }
        return false;
    }
    
    public boolean DFS(String start, String finish) {
        ArrayList<String> checks = new ArrayList<String>();
        for(ArrayList<String> list : S.values()){
            checks.addAll(list);
        }
        checks = removeDuplicates(checks);
        ArrayList<String> done = new ArrayList<String>();
        for(String s : checks){

            if(S.get(s).contains(finish)){
                return true;
            }

            done.add(s);
            if(done == checks){
                break;
            }
        }
        return false;
    }

    public ArrayList<String> removeDuplicates(ArrayList<String> list){
        ArrayList<String> output = new ArrayList<String>();
        for(String s : list){
            if(!output.contains(s)){
                output.add(s);
            }
        }
        return output;
    }
}