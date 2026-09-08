class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String ans = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            char ch = word.charAt(0);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                
                word = word + "ma";
            } else {
                word = word.substring(1) + word.charAt(0) + "ma";
            }

            for (int j = 0; j <= i; j++) {
                word = word + "a";
            }

            ans = ans + word + " ";
        }

        return ans.trim();
    }

}