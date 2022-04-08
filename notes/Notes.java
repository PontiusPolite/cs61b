
/* === CS61B DATA STRUCTURES AND ALGORITHMS === */

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

- TDD is an extreme departure from naive workflow, so for this class we can be somewhere in between the two.
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
- When you declare a reference variable, Java always allocates 64 bits (the size of the location address)

THE GOLDEN RULE OF EQUALS:
- Saying y = x copies the bits at location x into location y
    - They both don't point to the same box
- Saying obj1 = obj2 copies the bits that are the location in memory, so they both point to the same location

PARAMETER PASSING:
- When you pass a variable into a function, the bits are copied as the new parameter
- So, passing a reference variable and manipulating it will also manipulate it  outside the frame of the function
*/

/*
LECTURE 5: SLLISTS, NESTED CLASSES, SENTINEL NODES

LISTS
- See IntList class for an example of a recursive list data structure
- We use StuffNode and then SLList (Single Linked List) as an intermediary, so that we don't have this naked recursive data (might be harder for someone to understand)

PRIVATE KEYWORD
- We can use the private keyword to prevent using class members from outside
the class
- The private keyword lets you hide implementation
- This is 'access control', but it's a soft restriction
- If you make something public, the expectation is you will never remove it

NESTED CLASSES
- We can put the IntNode class inside SLList, since it is obviously subordinate to it


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
- OR, we could just have ONE sentinel pointing to the front and back

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

- We also want to null out deleted objects, which makes sure the memory that object occupied is recovered
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
- Suppose we have an object with compile-time type X and run-time type Y. If Y overrides a method, Y's method is used instead.

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
    - if you are the user behind the layer of abstraction, you might not know f calls g. You just know the description and results of calling f and g
    - if you write a subclass that extends this superclass, and write an override of g that calls super.f (or doesn't implement any override of f), then you've created an infinite loop
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
- We take advantage of the fact that we can pass in an instance of the interface into the function, which itself has an 'apply' method. That apply method can be specified in any subclasses of that interface. So, f(f(x)) will be f.apply(f.apply(x)).

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
- The implementation of toString() in the Object class is the object name, an @ sign, and its memory location
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
    - The rest is used to label a file in that folder which contains the compressed contents of the commit
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
- Count Operations: machine independent, scalable, but hard to compute and doesn't necessarily measure time
- Count Operations in terms of input size N: tells you how algorithm scales, but even more tedious to compute

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
    - With this approach, isConnected is constant, but connect is still linear since you have to add items to the array.

- Quick Union: assign each item a parent instead of an id. So our new array looks like:
values: [-1, 0, 1, -1, 0, 3, -1]
indexes:  0  1  2   3  4  5   6
    - if an item has no parent, it is assigned -1
    - starts to look like a tree ;)
    - Suppose we want to connect 5 to 2. We find the root of 5, and connect that to the root of 2.
        - This can become expensive though if the tree is really tall
        - Finding the root is Q(N)
        - see QuickUnionDS for an implementation

- Weighted Quick Union: modified to avoid tall trees
    - we need to track tree size
    - new rule: always link root of smaller tree (by weight, not height) to larger tree
    - to track sizes, we can use the root parent value
        - a root parent of -6 means the tree has size 6
    - now the worst case tree height is Q(log N)
        - think about how the tree grows as quickly as possible

PATH COMPRESSION
- What if, when we determine the root, we set the parent of all items on the path we take to the root
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
    - Since == is Q(N), the whole method is Q(N^2)
    - We can draw a grid with side lengths i and j, and color in the section that == will happen for a geometric understanding
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
    - Too small, move to left side. Adjust high pointer to be one below the previous mid, and move mid to the middle of our selection
    - Too big, move to right side. Adjust low pointer to be one above previous mid, and move mid to middle of new selection
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

- Arbitrary Unit of Time: we can just say an operation takes a certain amount of AU units of time. For selection sort, we might say for N = 6 it takes 36 AU, then for N = 64, it takes 2048 AU.

Array Merging:
- We can glue two sorted arrays together by comparing the first items, and taking the smallest one, then repeating on the rest
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
    - every node N except the root has one parent, defined as the first node on the path from N to the root
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

/*
LECTURE 17: B-TREES

BST HEIGHT
- trees can be 'bushy' or 'spindly'
    - the difference is logarithmic vs linear operation times

- The Depth of a node is its distance from the root, where the root is depth 0
- The Height is the depth of the deepest leaf
- The Average Depth is, well, the average of all the node depths

- If you add N items randomly, the expected average depth and expected height are Q(logN)
    - the problem then is how to randomly add data: hence B-trees

B-TREES
- avoid adding new leaves by 'overstuffing' the leaf nodes, such that they become lists
    - set a limit for the number of items in each node
    - if we go above that limit, pass one of the middle items to the parent node
        - split the node down the middle, so that now the parent has pointers to each from the middle of its item list
            - this is to stay logically consistent: suppose we're searching for 16 and reach a leaf with items [12, 14, 20]. We know to check if there's a tree pointer between 14 and 20. If not, we add it to the items, which then need to be split, etc.

- adding items to a node that isn't a leaf can start a chain reaction
- what if the root is too full?
    - take a middle item and make it the new root
        - this maintains a perfectly balanced tree - all leaves are same depth

- our limit of 3 items is called a 2-3-4 Tree, since nodes can have 2-4 children
- B trees of order L=2 are 2-3 trees.

B-Tree Invariants:
- all leaves are same depth
- a non leaf node with k items must have k+1 children

B-Tree Runtime:
- worst case: height grows with log_L+1(N)
- best case: log_2(N)
- overall height is Q(logN)

 */

/*
LECTURE 18: RED BLACK TREES

B Trees suffer from some problems:
- maintaining different node types
- converting between nodes

BST Structure and Tree Rotation:
- for N items, there are Catalan(N) different BSTs
- we can 'rotate' between different BSTs
    - let P be the right child of R. To rotate R to the left, make R the new left child of P.
    - Now P might have 3 children. Take the middle child k, and make it the right child of R.
        - we can also think of this as merging P with R, then R goes down to the left and carries k with it as its right child
    - So now by rotating to the right, G has become the right child of its former left child x.

Red Black Tree:
- suppose we have a 2-3 tree, but we want the advantages of a normal balanced B-tree
- we can split up our 2 item nodes and use a 'red' glue link to tie them together
    - the red links are typically on the left just for consistency
        - an LLRB, or left leaning rb tree
        - suppose we have a 3 node XY. Take the left item X in the node, and make it the left child.
        of Y. The former left and middle children of XY become the children of X.
            - this adds one link, so an LLRB has no more than 2H+1 the height of a 2-3 tree

LLRB Properties:
- there's always a corresponding 2-3 tree
- no node has two red links, otherwise it would be a 4 node
- every path from root to a leaf has same number of black links, since 2-3 tree mapping
must be balanced

Implementation:
- we insert as usual into a BST, then use rotations to maintain the 1-1 mapping with a LLRB
    - this avoids the problems of implementing a 2-3 B Tree
Insertion Color:
- new values are always added using a red link, since in we always insert new values int a leaf node in a 2-3 tree
Inserting to the right:
- if when we insert an item that goes on the right, we need to rotate the parent to the left
- this keeps the red link on the left
Double Insertion on the Left:
- say we need to insert on the left, and the left child is already a red link
- we allow temporary 4 nodes when two red links are added
- rotate the top of the first red link to the right, so both the children are red links
- then we flip the links (see below)
Splitting Temporary 4 Nodes:
- flip the colors of all links touching the parent of the two red links

It's possible that the rotation or flip operation will cascade into other fixes
 */

/*
LECTURE 19: HASHING

DATA AS THE INDEX:
- lets start with an array of booleans indexed by our data
- initially all values are false
- when an integer is added, set that index to true
Problems:
- very memory wasteful, need 2 billion booleans for just positive ints
- need to generalize beyond integers

To solve the generalization problem, we can come up with a function that converts data to an integer index. However, we need to avoid collisions.

STRING EXAMPLE:
For strings, we can convert them into a base 27 number:
- "bee" converted to digits is 2-5-5
- (2 * 27^2) + (5 * 27^1) + (5 * 27^0) = 1598, which is our new index
- we used a base >= 26, since that guarantees with 26 letters there will never be a collision
    - makes sense if you think about it, if we think of the letters as digits in base 27
We'll need a bigger base for all string characters though.
- The largest printable character in ASCII is char 126, so we could do base 126
- unicode would base 40959
- this gets unfeasible, because our index is overflowing the max int
    - there's a ridiculous number of unique strings
- what we need is a hash code that projects to a smaller set

HASH CODE: projects a value from a set with many members to a value from a set with a fixed number
of fewer members
Pigeonhole Principle: if there's more items in our set than we can index, we'll have collisions
- we need a way to handle collisions

BUCKETS:
Suppose N items have numerical representation h:
- Instead of storing true at position h, let's store a "bucket" of N items at position h
- Every array value starts with an empty bucket
- When item x gets added at index h:
    - if bucket h is empty, we create a new list at h containing x
    - if bucket h is already a list, we add x to it if it isn't already present
- might call it a 'separate chaining data indexed array'
- worst case performance is Q(M), where M is the longest bucket size

HASH TABLE:
- data is converted by a hash function into int representation called a hash code
- hash code is then reduced to a valid index, usually with the mod operator
    - use the Math.floorMod() op in java to handle negative numbers better
- Load factor: for M buckets and N items in our table, load is N/M
    - we can resize and increase M for better performance
    - we'll change the mod amount to our new size and move items around
    - good default load is <=1.5

HASHMAPS IN JAVA:

- Implemented as the HashMap and HashSet classes in java.util
- the Object class has a hashCode() function
    - this is overwritten in other classes like String

Warnings:
- never store objects that can change - it's hash code changes
- never override equals without also overriding hashCode

 */

/*
LECTURE 20: HEAPS AND PQs

THE MIN PRIORITY QUEUE INTERFACE:
- a bag that only lets you interact with the smallest item
- lets say we only care about the 'most harmonious' text strings M from our snooping
    - we add the string, then removeSmallest() from our PQ once its size is >M
    - at the end, we have M most harmonious strings
Implementations:
- ordered array: adding and removeSmallest are Q(N)
- bushy BST: handling duplicates is hard
- hash table: items go to random places, no good
- we need a heap

HEAPS
- a binary min-heap is a binary tree that is complete and obeys min-heap property
    - min-heap: every node is <= to both of its children
    - complete: missing items only at the bottom level if any, and all nodes
    are as far left as possible. By 'missing' just mean only one child.

OPERATIONS WITH HEAP:
- getSmallest(): always at root
- add(): temporarily add item to bottom of heap. Then 'swim' it up until it's in the correct spot.
- removeSmallest(): swap the last item in the heap into the root. Then sink that new root, swapping with the smaller child, until it's in the right place.

TREE REPRESENTATIONS OF HEAP:
- could have attributes of key and left_child, right_child
- could also have key and array Tree[] children
- Sibling Tree: the parent points to a favored child node, and that node points at
its sibling and its child

- we could store our keys in an array, and our parents in an array as well, much like the
Disjoint Sets data structure, where the parent of keys[i] is at index parents[i]
    - if we assume the tree is complete, then the parents array is actually redundant. It will always look like: [-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, ...]
    - so we only need a Key[] array
    - the parent() method: takes index k and returns its parent index
        public int parent(k) {
            return (k - 1) / 2;
        }

- Other version of the above is to leave an empty space at index 0 to simplify operations:
    - then parent is k/2, leftChild is k*2, and rightChild is k*2 + 1
    - root is at index 1

PERFORMANCE:
- heap is logN time amortized
- can have a constant getSmallest
- handles duplicate priorities more naturally than BST
- array based heaps take less memory

DATA STRUCTURES SUMMARY
- all of our structures are trying to solve the search problem
SETS AND MAPS:
    - BST, 2-3 Tree, LLRBs
    - Hash Tables
STACKS:
    - linked list
    - resizing array
LISTS:
    - linked list
    - resizing arrays
PRIORITY QUEUE:
    - ordered array
    - balanced tree
    - Heap
DISJOINT SETS:
    - Quick find
    - Quick union
    - Weighted quick union
    - WQU with path compression
 */

/*
LECTURE 21: TREE AND GRAPH TRAVERSALS

- There are many orders in which we might visit the tree nodes

    D
   / \
  B   F
 / \ / \
A  C E  G
Level Order: visit top to bottom, left to right across nodes of each depth
Depth First Traversal: traverse deep nodes before shallow ones
- Preorder: 'visit' a node, then traverse its children (DBACFEG)
    - this is like tracing a path around graph from top going counter-clockwise. 'Visit' every time
    we pass the left of a node
    $ preOrder (BSTNode x) {
        if (x == null) return;
        print(x.key);
        preOrder(x.left);
        preOrder(x.right);
    }
- In order: traverse left child, visit, then traverse right child (ABCDEFG)
    - ... "Visit" every time you cross the bottom of a node
    $ inOrder (BSTNode x) {
        if (x == null) return;
        inOrder(x.left);
        print(x.key);
        inOrder(x.right);
    }
- Post order: traverse left, traverse right, then visit (ACBEGFD)
     ... "Visit" every time you cross the right of a node

Example: let's say our tree is a file directory
- preorder would be good for printing the file structure neatly
- post order would be good for gathering all the file sizes

GRAPHS
A simple graph is a graph with:
    - no edges that connect a vertex to itself
    - no two edges that connect the same vertices
In this class, we'll assume we're always talking about simple graphs unless specified.

Terminology:
- Directed: each edge has a direction
- Cyclic: multiple paths between nodes (note that a non-cyclic graph isn't necessarily a tree, it can have disconnected nodes)
- Graph:
    - set of vertices
    - set of edges (pairs of vertices)
    - vertices connected by an edge are adjacent
    - vertices may have labels or weights
- path: a sequence of vertices connected by edges

GRAPH PROBLEM DIFFICULTY
Euler Tour: is there a cycle that uses every edge once?
Hamilton Tour: is there a cycle that uses every vertex once?
    - an efficient euler algorithm O(# of edges) has been known since 1873
    - no efficient hamilton tour algo exists

S-T CONNECTIVITY
- given source s and target t, is there a path between them?
     - mark s
     - does s == t? if so return true
     - otherwise, if connected(v, t) for any unmarked neighbor v of s, return true
     - return false
- the above is an example of depth first traversal: we explore the entire neighbor's subgraph before moving to the next neighbor

DEPTH-FIRST PATHS:
dfs(v) {
- maintain an array of edges, and an array of marks
    - mark v
    - for each unmarked adjacent vertex w:
        - set edgeTo[w] = v
        - dfs(w) (recursive call)
}

- the above is called DFS Preorder: we do an action before traversing to the neighbors

BREADTH FIRST SEARCH:
- analogous to level-order tree search

 */

/*
LECTURE 22: GRAPH TRAVERSALS AND IMPLEMENTATIONS

SHORTEST PATH
Breadth First Search:
- initialize a queue with starting vertex s and mark it
    - a queue is a list with two ops: enqueue (addLast) and dequeue (removeFirst)
    - we'll call this queue our 'fringe' (it's the edge of what we're exploring)
- repeat until queue is empty:
    - remove vertex v from the front of queue
    - for each unmarked neighbor n of v:
        - mark n
        - add n to our fringe
        - set edgeTo[n] = v, optionally set distanceTo[n] = distanceTo[v] + 1


Princeton Graph API:
public class Graph
    public Graph(int V):               create an empty graph with v vertices
    public void addEdge(int v, int w): add an edge v-w
    Iterable<Integer> adj(int):        vertices adjacent to v
    int V():                           number of vertices
    int E():                           number of edges

- the choice of API has big implications for runtime and memory

GRAPH REPRESENTATIONS

List of Edges

Adjacency Matrix:
- matrix of 0's and 1's determining edges
- each edge represented twice in undirected graphs

Adjacency List:
- maintain an array of lists indexed by vertex number
    - kind of like our hash table, but the bucket index is the vertex #, not the hashcode
- most popular approach
- good since most graphs are sparse, there's not a lot of edges
- also the best runtime for adj(v) which many algos rely heavily on
- The runtime to print every edge in an adjacency list is Q(V + E) for V vertices and E edges
    - We create V iterators, one for each vertex that we're checking the adjacency 'bucket' of
    - We print E times, one for each edge in every bucket
    - E could be at most V^2, so worst case is Q(V^2)
 */

/*
LECTURE 23: SHORTEST PATHS
BFS vs DFS for path finding:
- both will find same path, but BFS always gives back the shortest paths
- DFS is worse for spindly graphs, very deep call stack
- BFS is worse for bushy graphs for memory
- say we're finding a street route - we need to account for the length of the street, what we can refer to 'edge weight'

- the solution of shortest paths from a given source is always a tree
    - it won't contain any cycles, unless there's a negative weight for some edge!

Bad Algorithm:
- mark every node as having infinite distance initially, our start has 0.
- perform a depth first search. When you visit v:
    - for each edge from v to w, add edge to our shortest path tree only if that edge yields a better distance. This process is called relaxation, that is, only using the edge that yields a better distance to the neighbor node.
    - the problem is if we mark a node trying one path, we need to unmark it for doing some other path that could touch it. This is do-able but slow.

DIJKSTRA's ALGORITHM
- perform a best first search (closest first). When you visit v:
    - for each edge from v to w, relax that edge

Implementation:
- insert all vertices into a fringe PQ, storing vertices in order from distance from source.
    - they all start out as infinity, but we do a change priority operation when we update a distance
- repeat: remove closest vertex v from PQ and relax all edges pointing from v

Dijkstra's Pseudocode:
PQ.add(source, 0)
For other vertices v, PQ.add(v, infinity)
While PQ is not empty:
    p = PQ.removeSmallest()
    Relax all edges from p

Relaxing an edge p->q with weight w:
    if distTo[p] + w < distTo[q]:
        distTo[q] = distTo[p] + w
        edgeTo[q] = p
        PQ.changePriority(q, distTo[q])

Key Invariants:
- edgeTo[v] is the best known predecessor of v
- distTo[v] is the best known total distance from source to v
- PQ contains all unvisited vertices in order of distTo

Why does it work?:
- assume there are no negative edges
- at start, distTo[source] = 0, which is optimal. After relaxing all edges from source, let vertex v1 be the vertex with minimum weight. Thus distTo[v1] is optimal, since any other path would require another edge. By induction, this holds true for all vertices after dequeueing.

DIJKSTRA'S RUNTIME:
PQ Operation count:
- add: V times, each costing O(logV)
- removeSmallest: V times, each costing O(logV)
- changePriority: E times, each costing O(logV)
So overall runtime is O(VlogV + VlogV + ElogV). Assuming E>V for a connected graph, overall is
O(ElogV)

What if we have only a single target in mind?

A* PATHFINDING
- we can visit vertices in order of d(source, v) + h(v, goal) where h(v, goal) is an estimate
of the distance from v to our goal.
    - whereas Dijkstra's only considers d(source, v)
- this will give us to shortest path to our destination, but not a valid shortest paths tree
- h(v, goal) is a heuristic - doesn't have to be perfect, it's a best guess
    - example, if we were pathfinding between cities, we could use the latitude/longitude straight
    line distance
    - if we set it to a constant, it's just dijkstra's

 */

/*
LECTURE 24: MINIMUM SPANNING TREES

SPANNING TREES
- given an undirected graph, a spanning tree T is a subgraph of G where T:
    - is connected  } make it a tree
    - is acyclic    }
    - includes all vertices  } makes it spanning
- if there are V vertices, there will be V-1 edges in the ST

- a MINIMUM spanning tree is one with total minimum edge weight
- SPT depends on the start vertex, but for an MST there is no source. It is a global property of the entire graph.

The Cut Property:
- a cut is an assignment of a graph's node to two non-empty sets (think two different colors)
- a crossing edge is an edge which connects a node from one set to the other
- given any cut, minimum weight crossing edge must be part of the MST
Proof:
- suppose that a minimum crossing edge e were not in the MST
    - adding e to the MST creates a cycle
    - some other edge f must also be a crossing edge
    - removing f and adding e is a lower weight spanning tree
    - contradiction!

PRIM'S ALGORITHM
- start from arbitrary start node
    - add shortest edge that has one node to the MST under construction
    - now we consider everything in our MST (two nodes rn) as one set in our cut
    - use cut property to add a new edge
        - the cut property assumed all edges are unique, but if we have a duplicate edge we just select one of them
    - repeat until V-1 edges
- this is a conceptual, inefficient version - we can use a fringe PQ to speed things up

PRIM's IMPLEMENTATION WITH PQ
- insert all vertices into PQ in order of distance from our current tree (our start vertex is 0
while everything else is infinite)
- repeat: remove closest vertex v from PQ, and relax all edges pointing from v
- it's like dijkstra's, but rather than relaxing according to distance from source, we're relaxing
according to distance from our current vertex (and thus our current MST under construction)

KRUSKAL'S ALGORITHM
- sort all edges by weight
- go through edges and add each one as long as it doesn't cause a cycle
Implementation:
- add all edges to priority queue in order of weight
- we can determine if there is a cycle by using a weighted quick union object of vertices
- repeat: remove smallest weight edge. Check if its vertices are already connected in our WQU
    - if not, union them and add the edge to our MST

- works due to same cut principle, if we consider our cut to be the tree so far vs. everything else

 */

/*
LECTURE 25: RANGE SEARCHING AND MULTI-DIMENSIONAL DATA

- our previous data structures are very fast to insert, remove, and delete, but relied
on data being comparable
- suppose we have 2-dimensional data, like x and y coordinates - we would need a BST to
track each. While some operations would work, others like nearest(x) would not be fun

QUADTREE
- In a QuadTree, every node has four children
    - Top left, aka northwest
    - Top right, aka northeast
    - Bottom right, aka southeast
    - Bottom left, aka southwest
- Quadtrees are a form of spatial partitioning:
    - each node owns 4 subspaces, and those are divided into their own subspaces with other points
        - areas with more points are more finely divided
- With 3D data, we could use an Octree

K-D TREE:
- generalized to arbitrary dimensional data (k dimensions)
- Example in 2-d:
    - root partitions left and right
    - depth 1 nodes partition down and up
    - depth 2 nodes partition left and right
K-D Tree Traversal:
- suppose we want to find the nearest(x)
- you should always consider the best space first, that is, the best child
- keep track of the best distance so far, whatever that metric might be
- difficult to explain without a pic, but see the pseudocode below and vid 7 of lecture
- we can check if there's a possible closer point on the bad side. If not, we don't consider it.

Nearest Pseudocode
nearest(Node n, Point goal, Node best):
- if n is null, return best
- if n.distance(goal) < best.distance(goal), best = n
- if goal < n (according to n's comparator):
    - goodSide = n.leftChild  // leftChild could also be directionally down, and right could be
    - badSide = n.rightChild  // directionally up
- else:
    - goodSide = n.rightChild
    - badSide = n.leftChild
- best = nearest(goodSide, goal, best)
- if badSide could still have something useful: // see lecture for purple vs. green line approach
    - best = nearest(badSide, goal, best)
- return best

UNIFORM PARTITIONING
- we could partition the space of data into buckets of points
- finding points that fall into a range would mean only considering a few buckets (rectangles on grid)

Uniform partitioning: analogous to hashing
Quadtree: generalized 2D BST where each node owns 4 subspaces
K-d tree: generalized k-d BST where each node owns 2 subspaces

Spacial partitioning allows for pruning of the search space.

 */

/*
LECTURE 26: PREFIX OPERATIONS AND TRIES

TRIES

The sets we've made are great:
Balanced Search Tree: contains(x) is logN and add(x) is logN
Resizing Separate Chaining Hash Table: contains(x) is constant and add(x) is constant 

Supose we know that our keys are always strings:
- can use a Trie data structure
    - store each letter of the string as a node in a tree
    - great performance for get and add, as well as special string ops

This is the Trie for 'sam', 'sad', 'sap', and 'a':
         0
        / \
       a   s
            \
             a--
            / \ \
           d   m p
When then mark the nodes that denote the end of the word, so the left a, d, m and p.
These final letters can map to a value. 

Trie is terrible short name for Retrieval Tree. 

See vid for implementation and instance variables: https://www.youtube.com/watch?v=DqfZ4BEVDgk&list=PL8FaHk7qbOD7eyAcACitG8neRNL2rsvng&index=3

Runtime: contains(x) and add(x) are constant, because the worst case number of links is the length of the longest key.

Tracking Children in a Trie:
We can use a DataIndexedCharMap (array with 128 slots, each referring to ascii char value), but this is very memory hungry since there will be a bunch of nulls. 
Can also use a hash table or a binary search tree:
- thus we have data abstraction: we just need a map<child, node> implementation to keep track of children
- these are technically slower than the char map (still constant), but less memory hogging

TRIE STRING OPERATIONS
- examples: keysWithPrefix("sa"), longestPrefixOf("sa')

collect(): returns a list of all keys in the Trie.
    > create empty list x
    > for character c in root.next.keys():
        > colHelp("c", x, root.next.get(c))
    > return x

colHelp(String s, List<String> x, Node n):
    > if n.isKey, then x.add(s)
    > for character c in n.next.keys():
        > call colHelp(s + c, x, n.next.get(c))

- keysWithPrefix(x) is similar to collect, but with a specific starting node besides the root

AUTOCOMPLETE
- We can use a Trie based map from strings to values - the value is how important the word is to our autocomplete
- If the user types s, we call keysWithPrefix('s')
- However, it's inefficient to retrieve everything prefixed by s and only display 10 results.

- To solve this, each node can store its own value along with the value of the best substring below it.
    - The search will consider nodes in the order of 'best'
    - We can stop when all three matches are better than the best remaining
    - hint: use a PQ
    

*/


}