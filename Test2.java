// class Test2 {
//     static int x = 10;

//     static {
//         x = 20;
//     }

//     {
//         x = 30;
//     }

//     Test2() {
//         x = 40;
//     }

//     public static void main(String[] args) {
//         new Test2();
//         System.out.println(x);
//     }
// }

class Test2{
    public static void main(String[] args) {
        // int x = 2;
        // int y = 3;
        // int z = ++x * y-- - --y;
        // System.out.println(x + "," + y + "," + z);


        // int x = 3;
        // int y = 4;
        // boolean b = (x++ > 2) && (--y > 3) || (x = 10) > 5;
        // System.out.println(x + "," + y + "," + b);


        // int x = 5;
        // int y = 2;
        // int z = (x-- > 4) 
        //         ? (y++ + --x) 
        //         : (++y + x--);
        // System.out.println(x + "," + y + "," + z);


        int x = 0;
        int y = 3;
        while((x < 2) && (y-- > 0)) {
            x++;
        }
        System.out.println(x + "," + y);

    }
}