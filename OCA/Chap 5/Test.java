abstract class A {

    abstract void show();

}

public class Test {

    public static void main(String[] args) {

        A obj = new A() {

            void show() {

                System.out.println("Hello");

            }

        };

        obj.show();

    }

}