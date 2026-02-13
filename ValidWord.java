// Given a non-empty string s and an abbreviation abbr, return whether the string 
// matches with the given abbreviation.
// A string such as "word" contains only the following valid abbreviations:
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", 
// "w1r1", "1o2", "2r1", "3d", "w3", "4"]

// Notice that only the above abbreviations are valid abbreviations of the string 
// "word". 
// Any other string is not a valid abbreviation of "word".

// Note: Assume s contains only lowercase letters and abbr contains only lowercase 
// letters and digits.
// Example 1:
// Given s = "internationalization", abbr = "i12iz4n":

// Return true.

// Example 2:
// Given s = "apple", abbr = "a2e":

// Return false.

// Time Complexity: O(n) where n=max(len(word),len(abbr))
// Auxiliary Space:  O(1).

import java.util.*;

class ValidWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String abbr = sc.next();

        System.out.println(isValid(abbr, word));
    }

    public static boolean isValid(String abbr, String word) {
        int pa = 0, pw = 0;

        while (pa < abbr.length() && pw < word.length()) {

            if (Character.isLetter(abbr.charAt(pa))) {
                if (abbr.charAt(pa) != word.charAt(pw)) {
                    return false;
                }
                pa++;
                pw++;
            } else {
                if (abbr.charAt(pa) == '0') return false;

                int num = 0;
                while (pa < abbr.length() && Character.isDigit(abbr.charAt(pa))) {
                    num = num * 10 + (abbr.charAt(pa) - '0');
                    pa++;
                }

                pw += num;
                // if (pw > word.length()) return false;
            }
        }

        return pa == abbr.length() && pw == word.length();
    }
}
