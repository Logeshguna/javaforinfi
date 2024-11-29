package arrays;

public class Strings_pracice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="malayalam";
		String m="";
		for(int i=s.length()-1;i>=0;i--) {
			m=m+s.charAt(i);
			
		}
		System.out.println("the reversed string is"+" "+m);
		if(s.equalsIgnoreCase(m)) {
			System.out.println("the given string is plaindrome");
			
		}
		else {
			System.out.println("the given sting is not palindrome");
		}

		
		
	//Duplicate charcters in string
		String r="Selenium interview";
		int count=0;
		System.out.println(r.length());
		for(int i=0;i<r.length()-1;i++) {
			for(int j=i+1; j<r.length()-2;j++) {
				
				if(r.charAt(i)==r.charAt(j)) {
					System.out.print(r.charAt(j));
					
				}
			}
		}
		
		
		
	}

}
