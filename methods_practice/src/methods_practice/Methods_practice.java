package methods_practice;

public class Methods_practice {

    static String reverseString(String s) {
        char[] c = s.toCharArray();
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += c[i];
        }
        return reversed;
    }

    public static void main(String[] args) {
        // Example usage
        String original = "test";
        String reversed = reverseString(original);

        System.out.println("Original string: " + original);
        System.out.println("Reversed string: " + reversed);
    }
}
