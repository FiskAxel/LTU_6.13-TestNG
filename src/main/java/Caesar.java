public class Caesar {

    public static String getLastName() {
        return "Caesar";
    }

    public static String getFirstName() {
        return "Julius";
    }

    public static String getDinner() {
        return "Sallad";
    }

    public static String encrypt(String plainText, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            int u = c; // Unicode representation
            // Only changes letters (english)
            if (65 <= u && u <= 90) { // Upper case
                int f = (u + key - 65);
                u = modulo(u + key -65, 26) + 65;
            }
            if (97 <= u && u <= 122) { // Lower case
                u = modulo(u + key - 97, 26) + 97;
            }
            encrypted.append((char) u);
        }
        return encrypted.toString();
    }

    public static String decrypt(String encrypted, int key) {
        return encrypt(encrypted, -key);
    }

    // Positive modulo method because Java :)
    private static int modulo(int x, int mod) {
        int r = x % mod;
        if (r < 0)
        {
            r += mod;
        }
        return r;
    }
}