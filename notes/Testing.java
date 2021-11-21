
public class Testing {
   
   /** Tests the Sort.sort method */
   public static void testSort() {
      String[] input = {"i", "have", "an", "egg"};
      String[] expected = {"an", "egg", "have", "i"};

      Sort.sort(input);
      org.junit.Assert.assertArrayEquals(expected, input);
   } 

   /** Test the Sort.findSmallest method */
   public static void testFindSmallest() {
      String[] input = {"i", "have", "an", "egg"};
      String expected = "an";
      String actual = Sort.findSmallest(input);
      
      org.junit.Assert.assertArrayEquals(expected, actual);
   } 

   public static void main( String[] args ) {
      testFindSmallest();
   }

}