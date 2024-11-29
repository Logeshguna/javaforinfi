package Reverseannumber;

public class Array_prctice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,4};
		
		int s[]= new int[a.length];
		for (int i=a.length-1;i>=0;i--) {
			System.out.print("the value is"+" "+a[i]);
			s=a[i];

		}
		System.out.print(s);

	}

}
