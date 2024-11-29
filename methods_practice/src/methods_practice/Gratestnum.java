package methods_practice;

public class Gratestnum {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {9, 1, 77, 4, 88};
		int max=a[0];
		int min=a[0];
		int b=a.length;
		for (int i=1;i<=b-1;i++) {
			if(a[i]>max) {
				max=a[i];
				
			}
			else if(a[i]<min) {
				min=a[i];
			}
		}
		System.out.println("gratest number is"+" "+max);
		System.out.println("smllesnumber is"+" "+min);
	}

}
