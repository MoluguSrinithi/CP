import java.util.*;
import java.util.function.Predicate;
class Predicates{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3,5,10,14,20,22,25));
        // Predicate<Integer> predicate = num->num%2!=0;
        Predicate<Integer> predicate = num-> num > 4;
        // list.removeIf(num -> num % 2!=0);
        list.removeIf(predicate);

        // for(Integer num: list){
        //     // if(predicate.test(num)){
        //         System.out.println(num);
        //     // }
        // }

        System.out.println(list);
    }

}