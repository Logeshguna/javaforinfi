package programmingpractice;

import java.util.LinkedHashSet;

public class Remove_duplicates {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     //Create LinkedHashSet of type character   
		String str="javaTpoint is the best learning website";
        LinkedHashSet<Character> set = new LinkedHashSet<>();   
        //Add each character of the string into LinkedHashSet   
        for(int i=0;i<str.length();i++)   
            set.add(str.charAt(i)); 
        
        for(Character ch : set)   
            System.out.print(ch);   
		        
	}

}
