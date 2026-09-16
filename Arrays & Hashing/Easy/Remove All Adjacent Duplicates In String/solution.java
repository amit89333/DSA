class Solution {
    public String removeDuplicates(String s) 
    {
        StringBuilder prevChar = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
        {
            char currentChar = s.charAt(i);

            if(prevChar.length() > 0 && prevChar.charAt(prevChar.length()- 1) == currentChar)
            {
                prevChar.deleteCharAt(prevChar.length()- 1);
            }
            else {
                prevChar.append(currentChar);
            }
            
        }
        return prevChar.toString();
    }
}