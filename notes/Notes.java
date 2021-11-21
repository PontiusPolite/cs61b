
/* CS61B Data Structures and Algorithms */

/*
BASICS

- All Java files must begin with a class, enum, or interface
- We delimit the beginning and end of segments with {}
- All statements end in semicolon

- Before java variables can be used, they must be declared
- Java variables must have a specific type
- Java variable types can never change
- In Java, types are verified before the code runs.
    - If there are type issues,  no code will compile

- All parameters of a function must have a type, and the function itself must have a return type
- All functions must be part of a class in java, so they are all methods
*/

public class Notes {

    // The below is the method signature
    public static int larger(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println("Hello world");

        // Java will find the Dog class in this directory
        // The below method won't work though, because makeNoise is not static
        // Dog.makeNoise()
        Dog d = new Dog(50); // Declaration, instantiation, and assignment of Dog variable
        d.weightInPounds = 25;
        d.makeNoise(); // invocation of the makeNoise method
    }
}

/*
 * COMPILATION
 *
 * Compiling in Terminal: > javac HelloWorld.java - This compiles the java file
 * into a class file > java HelloWorld - Runs the program
 *
 * The Class File: - .class has been type checked - .class files are simpler for
 * the machine to execute
 *
 */

/*
 * DEFINING AND INSTANTIATING CLASSES - See Dog.java for an example class
 *
 * Static vs. Nonstatic - static methods and variables can be accessed without
 * instantiating
 *
 * Helper Methods:
 *
 */

 /*
 * USEFUL TERMINAL COMMANDS
 *
 * - Rm - delete file (remove)
 * - Ls - lists contents of directory
 * - Cat - shows contents of file
 * - Code - opens or creates a new file in vscode (i.e. code Hello.java)
 *
 */

/*
TESTING

- See the Sort and TestSort classes for example
- Use JUnit instead of ad hoc testing methods
- Testing provides stability and scaffolding - use helper functions to manage complexity,
    and test those helper functions to be confident that foundation is solid

Simpler JUnit
- Annotate each test with @org.junit.Test
- No main method needed
- Use import statements to make less verbose, only need @Test then

Test-Driven Development (TDD)
- Identify a new feature
- Write a test for that feature
- Run the test. It should fail. (RED)
- Write code that passes the test. (GREEN)
- Optional: refactor code to make it faster, cleaner, etc. (REFACTOR)
- Some critics will say this leads to unintended project complexity, with lots of dependencies.
    - You may want to build a quick, messy prototype to paint a clearer picture of what you need.

- TDD is an extreme departure from naive workflow, so for this class we can be somewhere
    in between the two.
*/

/* 
PRIMITIVES of Java: byte, short, int, long, float, double, boolean, char

MEMORY
- When you declare a variable, the exact amount of bits for that type is reserved
- Java creates an internal table that maps each name to a location
- Everything besides a primitive is called a Reference Type
- When you instantiate an object, Java creates a table in memory for each instance variable
    - These are assigned default values, until the constructor changes those values
    - The 'new' keyword returns the location that the new object was placed in
- When you declare a reference variable, Java always allocates 64 bits (the size
    of the location address)

THE GOLDEN RULE OF EQUALS:
- Saying y = x copies the bits at location x into location y
    - They both don't point to the same box
- Saying obj1 = obj2 copies the bits that are the location in memory, so they both
    point to the same location

PARAMETER PASSING:
- When you pass a variable into a function, the bits are copied as the new parameter
- So, passing a reference variable and manipulating it will also manipulate it 
    outside the frame of the function

ARRAYS
- Instantiating an array is similar to instantiating an object, and the GROE still applies
*/