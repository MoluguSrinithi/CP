// import java.time.*;
// import java.time.format.*;
// class Test1 {

//   public static void main(String[] args) {

//     LocalDateTime dt = LocalDateTime.now();

    

//    DateTimeFormatter f1 =

//       DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);



//     DateTimeFormatter f2 =

//       DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);



//     System.out.println(f1.format(dt));

//     System.out.println(f2.format(dt));

//   }

// }

// public class Test1 {
//     static int x = 5;

//     public static void main(String[] args) {
//         int x = (x = 3);
//         System.out.println(x);
//     }
// }

import java.util.*;
class Test1 {
    String s;

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = t1;
        t1 = null;
        System.out.println(t2.s);
    }
}
