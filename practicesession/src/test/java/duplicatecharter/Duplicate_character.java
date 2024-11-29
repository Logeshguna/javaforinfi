package duplicatecharter;

public class Duplicate_character {
    public static void main(String[] args) {
        String s = "selenium interview";
        char[] string1 = s.toCharArray();
        
        System.out.print("Duplicate characters: ");
        for (int i = 0; i < string1.length; i++) {
            int count = 1;
            for (int j = i + 1; j < string1.length; j++) {
                if (string1[i] == string1[j] && string1[i] != ' ') {
                    count++;
                    string1[j] = '0'; // Marking character as counted
                }
            }
            if (string1[i] != '0' && count > 1) {
                System.out.print(string1[i] + " ");
            }
        }
    }
}



