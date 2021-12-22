
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
LECTURE 3: TESTING

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
LECTURE 4: REFERENCES, RECURSION, AND LISTS

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
LECTURE 5: SLLISTS, NESTED CLASSES, SENTINEL NODES

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
LECTURE 6: DLLISTS, ARRAYS

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
LECTURE 7: ALISTS, RESIZING

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


/*
LECTURE 8: INHERITANCE AND IMPLEMENTS

INHERITANCE
- Overloading methods works, but is a crude solution
    - Messy source files, repeated code, more code to maintain
- Both ALists and SLists are Lists - list is a hypernym
    - We can use an Interface to capture this

INTERFACE
- An interface is a list of all method signatures
- It specifies what the thing should be able to do, but not how they should do it
- The 'implements' keyword points the class to that interface
    - If a method overrides what the interface specifies, we can add an @Override tag
        - See AList for examples
        - @Override isn't necessary, but it does catch name typos and is a helpful reminder
- Using our example of List61B and AList, the following code does compile and run fine:
    > List61B<String> someList = new AList<String>();
    > someList.addFirst("elk");

DEFAULT KEYWORD
- We can write code within the implementation that is used by its children
    - Use 'default' in the method signature
- These default methods can use methods we've already listed in our interface
- This is a new, albeit controversial feature, to run code inside an interface
- You can override these default methods too

STATIC VS DYNAMIC TYPE
- The static type is determined by the variable declaration (compile-time type)
- the dynamic type is specified at instantiation (run-time type)
- Suppose we have an object with compile-time type X and run-time type Y. If Y overrides a method,
Y's method is used instead.

JAVA LIST
- When writing actual code, we use java's built-in java.util.List and java.util.ArrayList
> List<Integer> L = new ArrayList<>();

 */

/*
LECTURE 9: EXTENDS, CASTING, HIGHER ORDER FUNCTIONS

IMPLEMENTATION INHERITANCE
- We can use a 'extends' when we want a class to be a hyponym of another
    - Poodle extends Dog, Poodle 'is a' Dog
    - See RotatingSLList.java for example
- Extends mean the subclass will inherit all of the following that are public:
    - instance and static variables
    - methods
    - nested classes
- The 'super' keyword lets you refer to methods/variables in the superclass
    - super() will call the superclass' constructor
- You can override methods the exact same way as interfaces
- Your subclass constructor will always call the superclass constructor silently with super()
    - HOWEVER, if you need to pass in a parameter, you need to call super(parm) in your constructor

- Every class by default extends the Object class

- Implementation Inheritance can break our understanding of abstraction
    - suppose you have a superclass with methods f and g, and f calls g
    - if you are the user behind the layer of abstraction, you might not know f calls g. You just
    know the description and results of calling f and g
    - if you write a subclass that extends this superclass, and write an override of g that calls
    super.f (or doesn't implement any override of f), then you've created an infinite loop
    - For this reason, it's sometimes something to avoid

CASTING
- casting forces an expression to have a certain compile-time type
- it effectively tells java to ignore its type checking duties
- We'll run into problems at run-time, rather than compile-time, if we cast incorrectly
- Casting only 'lasts' for the one line it is in. You're forcing the compiler to accept a type

HIGHER ORDER FUNCTIONS
- functions couldn't be passed as variables in old versions of java
    - there isn't a 'function' type
    - This is allowed after Java 7
- See IntUnaryInterface / TenX / HoFDemo for example
- We take advantage of the fact that we can pass in an instance of the interface
into the function, which itself has an 'apply' method. That apply method can be specified
in any subclasses of that interface. So, f(f(x)) will be f.apply(f.apply(x)).

 */

/*
LECTURE 10: SUBTYPE POLYMORPHISM VS. HoFs
- There's no need to override static methods or use same-name variables in a subclass
    - This is called 'hiding' and is bad practice

POLYMORPHISM
- providing a single interface to entities of different types
- Suppose we want to have a single 'compare' function for objects
    - We created an interface OurComparable.java
    - We made ComparableDog implement OurComparable
    - We created a max method in Maximizer.java that uses the compareTo method
    of OurComparable objects
- There are some problems with the above implementation
    - Strange casting to compare Dogs
    - no existing classes implement OurComparable, we made it up
- We can use the built-in Comparable<T> interface

COMPARATOR
- The 'natural order' sometimes refers to the ordering implied by compareTo

-These comparison interfaces let us make 'callbacks' to functions like compareTo
- Java doesn't have explicit function passing like python, so this is what we use

 */
