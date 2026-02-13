
@FunctionalInterface interface MathOperation{
    String operation(String a, String b);
    // void m1();
}

class Lambda{
    public static void main(String[] args) {
        // MathOperation concatenation = (String a, String b) -> {return a.concat(b);};
        // MathOperation concatenation = ( a,  b) -> {return a.concat(b);};
        MathOperation concatenation = ( a, b) ->  a.concat(b);
        // MathOperation concatenation = ( a, b) ->  System.out.println("a.concat(b)");


        System.out.println(concatenation.operation("Hello", "All"));
    }
}