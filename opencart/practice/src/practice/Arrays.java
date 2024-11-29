package practice;

public class Arrays {

	public static void main(String[] args) {
		String s="naveen";
		String b="";
		System.out.println();
		char[] ch=s.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
//			System.out.println(ch[i]);
			b=String.valueOf(ch[i]);  
//			System.out.println(b);
			
		}
		if(s.equals(b)) {
			System.out.println("plandrome");
		}
		else {
			System.out.println("not plaindrome");
		}
			

	}

}
