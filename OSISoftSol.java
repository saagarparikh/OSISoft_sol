/* Given: hashtable of sender(keys):reciever(value) list; array of keys;
Find way to create new list of sender:reciever that 1) has no circular linking 2) not the same as previous week*/

import java.awt.*;
import java.util.*;
import java.util.Collections;
import java.lang.Object;


class OSISoftSol{

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>(){{
			add("Kevin");
			add("Nick");
			add("Bob");
			add("Greg");
			add("Smith");
			add("Sam");
		
		}};
		
		HashMap<String,String> prevWeek = new HashMap<String,String>(){
		{
			put("Sam","Bob");
			put("Kevin","Greg");
			put("Nick","Kevin");
			put("Bob","Smith");
			put("Greg","Nick");
			put("Smith","Sam");
		}};
		
		HashMap<String,String> newWeek = newList(prevWeek,names);
		for(int i = 0;i<names.size();i++){
			System.out.println(names.get(i)+":"+newWeek.get(names.get(i)));
		}
	}

	public static HashMap<String,String> newList(HashMap<String,String> prevWeek, ArrayList<String> names){
		HashMap<String,String> newWeek = new HashMap<String,String>();

		//randomizing names ArrayList 
		Collections.shuffle(names);

		for(int i = 0;i<names.size()-1;i++){
			if(i!=names.size()-2 && (prevWeek.get(names.get(i)) == names.get(i+1))){
				String temp = names.get(i);
				names.set(i,names.get(i+1));
				names.set(i+1,temp);
			}
			newWeek.put(names.get(i),names.get(i+1));
		}
		newWeek.put(names.get(names.size()-1),names.get(0));

		return newWeek;

	}
	
}