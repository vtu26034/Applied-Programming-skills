 class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;
        String vowels = "aeiouAEIOU";
        int count = 0;

        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1)
                count++;
            if (vowels.indexOf(s.charAt(i + mid)) != -1)
                count--;
        }

        return count == 0;
    }
}
