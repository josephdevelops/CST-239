package topic1_1;

public class HelloWorld {


    // Private method sayHello
    private void sayHello(String name) {
        System.out.println("Hello, my name is " + name + ".");
    }
    
    public static void main(String[] args) {
        // Create an instance of HelloWorld
        HelloWorld helloWorld = new HelloWorld();

        // Call the sayHello method
        helloWorld.sayHello("Joseph Moses Abraham");

    }
}