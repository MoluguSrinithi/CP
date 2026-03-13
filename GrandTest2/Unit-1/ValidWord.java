import java.util.*;
class ValidWord{
    public static boolean isValid(String abbr, String word){
        int pa = 0;
        int pw = 0;

        while(pa <abbr.length() && pw < word.length()){
            if(Character.isLetter(abbr.charAt(pa))){
                if(abbr.charAt(pa) != word.charAt(pw)){
                    return false;
                }
                pa++;
                pw++;
            }
            else{
                if(abbr.charAt(pa) == '0'){
                    return false;
                }

                int num = 0;
                while(pa< abbr.length() && Character.isDigit(abbr.charAt(pa))){
                    num = num*10 + (abbr.charAt(pa) - '0');
                    pa++;
                }
                pw+=num;
                if(pw > word.length()){
                    return false;
                }
            }            
        }
        return (pa == abbr.length() && pw == word.length());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String abbr = sc.next();

        System.out.println(isValid(abbr, word));
    }
}