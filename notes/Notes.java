
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

import java.util.Map;
import java.util.TreeMap;

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
- We can use a 'extends' when we want a class to be a hypernym of another
    - Poodle extends Dog, Poodle 'is a' Dog
    - See RotatingSLList.java for example
- Extends mean the subclass will inherit all the following that are public:
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

- These comparison interfaces let us make 'callbacks' to functions like compareTo
- Java doesn't have explicit function passing like python, so this is what we use
- See project 1 MaxArrayDeque for implementation
 */

/*
LECTURE 11: EXCEPTIONS, ITERATORS, OBJECT METHODS

JAVA LISTS AND SETS
- We use the built-in List interface with several implementations, i.e. ArrayList
- Sets can only have one copy of each item, and have no sense of order
    > Set<String> S = new HashSet<>();

ENHANCED FOR LOOP
> for (int n : list)
- We can enable our home-made lists to use this syntax, see ArraySet
- This syntax uses an iterator and while(hasNext) loop to access each item
    - We need to add an iterator() to the class that returns an Iterator<T>
    - The returned Iterator<T> needs to have hasNext() and next() implemented
    - The class also needs to implement Iterable<T>

OBJECT METHODS: toString() and equals()
- The implementation of toString() in the Object class is the object name, an @ sign, and its
memory location
- STRINGBUILDER: see ArraySet.toString() for example

 */

/*
LAB 4: GIT
$ git init: creates repo
    - starts keeping track of staging area and commits
$ git add: lets git know which files should be made a snapshot of (committed)
    - this adds the files to the staging area
    - the staging area contains the version of the project to be committed
$ git commit: makes a snapshot of the current version
    - the staging area is cleared
    - the first commit creates the master and HEAD pointers
    - on subsequent commit, we clone the previous one
        - the staging area is used to modify the new commit
        - the master and HEAD pointers are moved to the new commit
    - the master pointer always points to the latest commit
$ git checkout: controls the HEAD pointer
    - the HEAD is 'detached' when it's not pointing to the tip of some branch
    - git checkout master returns to the tip of the master branch
    - you can't checkout if your repo isn't in a clean state
    - checkout will automatically stage all changed files from going back to older version
        - you can then commit this older version as the latest snapshot
$ git reset HEAD [file]
    - unstages the specified file, so it is not committed
$ git add [forgotten-file]
$ git commit --amend
    - lets you amend the previous commit by adding a file or changing the commit message

REMOTE REPOS
$ git clone [remote-repo-url]
    - makes a copy of the repository on your computer from the latest commit
    - also records the url for future data transfers
    - gives it the special remote-repo-name 'origin'
$ git remote add [remote-repo-name] [remote-repo-url]
    - records a new location for data transfers
$ git pull [remote-repo] master
    - get the most recent copy of all of the files at the remote repo
$ git push [remote-repo] master
    - pushes the most recent copy of your files to the remote repo

BRANCHES
- Branches allow multiple versions of the code to be worked on/changed and then later merged
$ git branch [new-branch-name]
$ git checkout [new-branch-name]
OR
$ git checkout -b [new-branch-name]
    - both do the same thing

$ git branch -d [branch-to-delete]
$ git branch -v
    - shows which branch you are on

$ git checkout master
$ git merge [branch-to-be-merged-with-current]
    - will merge branch with the master branch

 */

/*
LECTURE 12: COMMAND LINE PROGRAMMING, GIT

COMMAND LINE COMPILATION
- Hello.java -> javac (compiler) -> Hello.class -> java (interpreter) -> program runs
- You can give input from the command line which will be String[] args
    $ java HelloWorld x y z

GIT
- Git is written in C, which is compiled into a binary that doesn't require an interpreter
    - Thus using the $git command calls the git binary and passes the arguments

- Git uses the git-SHA1 hash to label versions of files
    - The first two digits of the hash are used to label a folder in the .git directory
    - The rest is used to label a file in that folder which contains the compressed contents of
    the commit
- Commits
    - A commit has an author, a date, a commitMessage, and a parentID

I/O WITH OBJECTS
- We can read and write java objects into a file as long as the class implements Serializable
- With a file f and object c, we can use Utils.writeObject(f, c);
- Then read it back with Utils.readObject(f, ~.class); where ~ is the name of the class

 */

/*
LECTURE 13: ASYMPTOTICS I

Techniques for Measuring Computational Cost:
- Timing: easy to measure, but may result in lots of time waiting
- Count Operations: machine independent, scalable, but hard to compute and doesn't necessarily
measure time
- Count Operations in terms of input size N: tells you how algorithm scales, but even more tedious
to compute

ASYMPTOTIC BEHAVIOR
- in most cases, we only care about what happens for very large N
- algorithms that scale well have better asymptotic runtimes 

BIG THETA NOTATION (we'll use Q in text)
- theta represents a family of functions which serve as both upper and lower bound
- for a function R(N) (and we're using E to mean 'is an element of'):
    - R(N) E Q(f(N)) if there exists positive constants k1 and k2 such that
    k1 * f(N) <= R(N) <= k2 * f(N)
    - Example:  40sin(N) + 4N^2 E Q(N^2)

BIG O NOTATION
- closely related to big theta, but only for the upper bound
- while N^3 + 3N^4 E Q(N^4) and E O(N^4), it is also an element of say O(N^6)

Q(f(N)): order of growth is f(N)
O(f(N)): order of growth is less than or equal to f(N)

*/

/*
LECTURE 14: DISJOINT SETS

- Disjoint Sets Data Structure has 2 operations
    - connect(x, y)
    - is Connected(x, y) 
        - connections can be transitive, not necessarily direct

- We can think of connecting two items as putting them in the same set
Now we need a way to keep track of these sets:
- Naive: a list of these sets. But this takes O(N) runtime.

- QuickFind: use an array, where the item i belongs to the set int[i]. Example:
        SETS                        ARRAY
{0, 1, 2, 4}, {3, 5}, {6} -> [4, 4, 4, 5, 4, 5, 6]    0 belongs to 4, 1 belongs to 4, etc.
    set4       set5  set6     0  1  2  3  4  5  6
    - With this approach, isConnected is constant, but connect is still linear since you have
to add items to the array.

- QuickUnion: assign each item a parent instead of an id. So our new array looks like:
[-1, 0, 1, -1, 0, 3, -1]
  0  1  2   3  4  5   6
    - if an item has no parent, it is assigned -1
    - starts to look like a tree ;)
    - Suppose we want to connect 5 to 2. We find the root of 5, and connect that to the
     root of 2.
        - This can become expensive though if the tree is really tall
        - Finding the root is Q(N)
        - see QuickUnionDS for an implementation

- WeightedQuickUnion: modified to avoid tall trees
    - we need to track tree size
    - new rule: always link root of smaller tree (by weight, not height) to larger tree
    - to track sizes, we can use the root parent value
        - a root parent of -6 means the tree has size 6
    - now the worst case tree height is Q(log N)
        - think about how the tree grows as quickly as possible

PATH COMPRESSION
- What if, when we determine the root, we set the parent of all items on the path we take to
the root
    - Helps widen our tree and remove height
    - Form of memoization, caching
    - Results in operations that are close to amortized constant time
        - amortized meaning average
    - log* is the iterative logarithm, and is <= 5 for realistic inputs
*/

/*
LECTURE 15: ASYMPTOTICS II

- There's no magic shortcut, but these sums are important to remember:
    - 1 + 2 + 3 + ... + N = N(N+1)/2 = Q(N^2)
    - 1 + 2 + 4 + 8 + ... + N = 2N-1 = Q(N)

EXAMPLES:
 */
    /** Checks if there are duplicates in a sorted array A. */
    boolean dup1(int[] A) {
        int N = A.length;
        for (int i = 0; i < N; i += 1) {
            for (int j = i + 1; j < N; j += 1) {
                if (A[i] == A[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    /*
    - Choosing == as our operation,
    - Worst case number of == operations: N(N-1)/2
    - Since == is Q(N), the whole method is Q(N)
    - We can draw a grid with side lengths i and j, and color in the section that == will happen
    for a geometric understanding
     */

    /** Example of nested loops that isn't Q(N^2). */
    void printParty(int N) {
        for (int i = 1; i <= N; i = i * 2) {
            for (int j = 0; j < i; j += 1) {
                System.out.println("hello");
                int ZUG = 1 + 1;
            }
        }
    }
    /*
    - Cost model C(N), println("hello") calls:
    N     1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18
    C(N)  1  3  3  7  7  7  7  15 15 15  15  15  15  15  15  31  31  31

    - The runtime is Q(N), not Q(N*logN) despite it seeming that way at first
     */

    /** Recursive function example. */
    public static int f3(int n) {
        if (n <= 1) {
            return 1;
        }
        return f3(n-1) + f3(n-1);
    }
    /*
    - Example of tree recursive call - every time you increase N by one, you double the work needed
    - Algebraic approach: we can express the number of calls to f3:
        C(N) = 1 + 2 + 4 + ... + 2^(N-1)
    - We know that 1 + 2 + 4 + ... + P = 2P - 1, so C(N) = 2*2^(N-1) - 1 = 2^N - 1
    - Thus f3 E Q(2^N)

    - Recurrence Relation approach:
    - C(1) = 1, if N equals 1 there's only 1 call to f3
    - C(N) = 2C(N-1) + 1
        - solving the algebra here is harder, but doable
     */

/*
Binary Search Example
- We have an array of sorted items, and a key we want to find. Start with low, high and mid
pointers (mid pointer goes to middle rounded down)
- Compare key against mid pointer
    - Too small, move to left side. Adjust high pointer to be one below the previous mid,
    and move mid to the middle of our selection
    - Too big, move to right side. Adjust low pointer to be one above previous mid, and move
    mid to middle of new selection
    - Equal, found
- The number of entries still left to search is N = high - low + 1
- Quite tricky to implement

- Intuitive worst case runtime: logN
    - We start with N items, then have N/2, then N/4...

 - Algebraically: C(N) = floor(log_2(N)) - 1, where C(N) is the number of function calls
    - We can determine this by just counting function calls for given N in a chart
    - Since floor(f(N)) E Q(f(N)), floor(log_2(N)) E Q(logN)
 */

/*
Selection Sort (Prelude to Merge Sort)
- find the smallest unfixed item, and move it to the front and fix it
- sort the remaining items
- This is Q(N^2)

- Arbitrary Unit of Time: we can just say an operation takes a certain amount of AU
units of time. For selection sort, we might say for N = 6 it takes 36 AU, then for N = 64,
it takes 2048 AU.

Array Merging:
- We can glue two sorted arrays together by comparing the first items, and taking the smallest one,
then repeating on the rest
- This will combine the two sorted arrays into one big sorted array.
- Q(N) runtime for N total elements
- Merging is faster than selection sort, and because sorting is N^2, it's beneficial to
split the array up, sort, and then merge them.
    - Say for N = 64, just selection sort would be 2048 AU
    - If we split into two 32 length arrays, then sorting each would be 512 AU
    - Merging them would be only 64 AU, so the total is 1088 AU for the same sorting
    - This is still Q(N^2), but it's empirically faster than only selection sort.
    - We can do better by splitting it up further, all the way down to arrays of one element
        - At this point, we don't even need selection sort

Merge Sort:
 - if array is size 1, do nothing
 - mergesort the left half
 - mergesort the right half
 - merge the results

Intuitive Analysis:
 - Every layer takes about N AU
 - Top level is N, next level is N/2 + N/2, next level is N/4+N/4+N/4+N/4
 - So the total runtime is Nk for k levels.
 - There are log_2(N) levels
 - Overall runtime is Q(Nlog(N))


 */

/*
PROJECT 2: GITLET NOTES
- See current working directory (CWD) in program: System.getProperty("user.dir");

FILES
$ File f = new File ("dummy.txt");
    - this creates a reference to a file in java, but doesn't actually create the file itself
$ f.createNewFile();
    - this will create the file
$ f.exists();
    - returns true if f now exists
- See Utils.java library for more methods on manipulating files

DIRECTORIES
- directories are also represented as file objects
$ File d = new File("dummy");
$ d.mkdir();
 */

/*
LECTURE 16: ADTs, SETS, MAPS, BSTs

ABSTRACT DATA TYPES
- defined only by its operations, not its implementations (like our List interface)
- The Stack ADT
    - push(): puts x on top of stack
    - pop(): removes and returns the item on top of stack
    - both a linked list or array implementation could work, although linked list is
    a bit cleaner
- The GrabBag ADT
    - insert(x): inserts x into the grab bag
    - remove(): removes a random item
    - sample(): samples a random item without removing
    - size(): number of items in bag
    - an array implementation would be fastest

- List, Set, and Map in java extend the Collection interface

MAPS EXAMPLE (same as dictionary in python):
 */
    void mapExample() {
        Map<String, Integer> m = new TreeMap<>();
        String[] text = {"sumomo", "mo", "momo", "mo", "momo", "no", "uchi"};
        for (String s : text) {
            // get the current count of that word in the map, or 0 if it doesn't
            int currentCount = m.getOrDefault(s, 0);
            m.put(s, currentCount + 1);
        }
    }
/*

BINARY SEARCH TREES
- a tree is a collection of nodes and edges, such that between any two nodes there is only one path
- a rooted tree is a tree where we just call one node the root
    - every node N except the root has one parent, defined as the first node on the path from
    N to the root
    - a node with no child is a leaf
- in a rooted binary tree, every node has either 0, 1, or 2 children

- A Binary Search Tree is a rooted binary tree with the BST property
    - for every node X in the tree, every key in the left subtree is less than X's key
    - every key in the right subtree is greater than X's key
    - no duplicate keys allowed
- A BST Search
    - if searchKey equals T.key, return
        - if searchKey < T.key, search T.left
        - if searchKey > T.key, search T.right

- BST Insert Pseudocode
    static BST insert(BST T, Key ik) {
        if (T == null)
            return new BST(ik);
        if (ik < T.key)
            T.left = insert(T.left, ik);
        else if (ik > T.key)
            T.right = insert(T.right, ik);
        return T;
- trust the base case, don't do something like, if (T.left) == null {T.left = new BST(ik);}

- BST Delete
    - Case 1: deletion key has no children
        - we just get rid of it
    - Case 2: deleting a key with one child
        - move the key's parent pointer to the key's child
    - Case 3: deletion key has two children
        - pick either the predecessor or successor
        - delete it and move the key to the root
 */








}