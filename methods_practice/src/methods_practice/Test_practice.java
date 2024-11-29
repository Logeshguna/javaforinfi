package methods_practice;

import java.util.HashSet;

public class Test_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="this is java interview";
		String b=s.replace(" ", "");
		  char[] ch = b.toCharArray();
		  String j="";
		 String m=""; 
//		System.out.print(b);
		for (int i=ch.length-1;i>=0;i--) {
			m=m+ch[i];
			
			}
		System.out.println(m);
		int count=0;
	  for (int l=0;l<m.length()-1;l++) {
		  for (int k=l;k<m.length()-1;k++) {
			  if (m.charAt(l)==m.charAt(k) && count>0) {
				  count++;
				  j=j+m.charAt(k);
				  k=0;
				  
			  }
		  }
		  
	  }
	  System.out.print(j);
	}

}
