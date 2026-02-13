// Given a string s, reverse only all the vowels in the 
// string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
// appear in both lower and upper cases, more than once.

// Sample Input-1:
// ---------------
// hello

// Sample Output-1:
// ----------------
// holle

// Sample Input-2:
// ----------------
// Keshavmemorial

// Sample Output-2:
// ----------------
// Kashivmomerael
import java.util.*;

class ReverseVowels{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int left = 0;
        int right = str.length-1;
      
        while(left< right){
            if(isVowel(str[left])){
                if(isVowel(str[right])){
                    char temp = str[left];
                    str[left] = str[right];
                    str[right] = temp;
                    left++;
                    right--;
                }
                else{
                    right--;
                }
            }
            else{
                left++;
            }
        }
        System.out.println(str);
          
            
    }
    
    public static boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch)!=-1;
    }
    
    
}