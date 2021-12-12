
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
LECTURE 3

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
LECTURE 4

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
*/

/*
LECTURE 5

LISTS
- See IntList class for an example of a recursive list data structure
- We use IntNode and then SLList (Single Linked List) as an intermediary, so that we don't
have this naked recursive data (might be harder for someone to understand)

PRIVATE KEYWORD
- We can use the private keyword to prevent using class members from outside
the class
- The private keyword lets you hide implementation
- This is 'access control', but it's a soft restriction
- If you make something public, the expectation is you will never remove it

NESTED CLASSES
- We can put the IntNode class inside SLList, since it is obviously suboordinate
to it


ARRAYS
- Instantiating an array is similar to instantiating an object, and the GROE still applies

INVARIANTS
- An invariant is a condition guaranteed to be true
- The SLList has the following invariants:
    - the sentinel reference always points to the sentinel node
    - the first node is always sentinel.next
    - the size variable is always the total number of items added
*/

/*
LECTURE 6

DLLIST
- Doubly Linked List: has pointers to next and prev
- We could have two sentinels then: at the front and back
- OR, we could just have ONE sentinel at the front and back

- We can parametrize the List class to take any type of variable as the item in the list
    - See the SLList class definition for a parameter


ARRAY LISTS
- The Array List: orthogonally stored info rather than recursive
- Arrays are a special object which consists of a numbered sequence of memory boxes
    - Unlike other objects which have named memory boxes
- Arrays also have a length that cannot change
 */

    public void ArrayBasics() {
        // Three valid notations for creating array
        int[] y = new int[3];
        int[] x = new int[]{1, 2, 3, 4};
        int[] w = {9, 10, 11}; // only works when declaring a variable

        // 2D arrays
        int[][] y2;
        int[][] x2 = new int[4][]; // this line creates one array
        int[][] w2 = new int[4][]; // this line creates five arrays
    }

/*
LECTURE 7

ALIST
- DLList has a problem of items far from sentinel node being inefficient to get
- We can use arrays to solve this, since the get time for any item is constant
- Resizing an array means creating a copy of the array, and making items point to that
    - Arrays can be copies with System.arraycopy or with a simple loop

Speed Analysis:
- Adding new items to the AList is slow, because N(N+1)/2 memory boxes have to be created
- Our SLList was only constant time
- Instead of resize(size + RFACTOR), we can use resize(size * RFACTOR)
    - This is a geometric resizing, which works much better
- ALists often have a usage ratio R = size / items.length, to make them efficient in space as well

- We also want to null out deleted objects, which makes sure the memory that object occupied
is recovered
 */

}
