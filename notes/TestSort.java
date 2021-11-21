import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
   
   /** Tests the Sort.sort method */
   @Test
   public void testSort() {
      // Test 1
      String[] input = {"i", "have", "an", "egg"};
      String[] expected = {"an", "egg", "have", "i"};
      Sort.sort(input);
      assertArrayEquals(expected, input);

      // Test 2
      String[] input2 = {"north", "east", "south", "west"};
      String[] expected2 = {"east", "north", "south", "west"};
      Sort.sort(input2);
      assertArrayEquals(expected2, input2);
   } 

   /** Test the Sort.findSmallest method */
   @Test
   public void testFindSmallest() {
      // Test 1
      String[] input = {"i", "have", "an", "egg"};
      int expected = 2;
      int actual = Sort.findSmallest(input, 0);
      assertEquals(expected, actual);

      // Test 2
      String[] input2 = {"there", "are", "many", "apigs"};
      int expected2 = 3;
      int actual2 = Sort.findSmallest(input2, 2);
      assertEquals(expected2, actual2);
   }

   /** Test the Sort.swap method */
   @Test
   public void testSwap(){
      // Test 1
      String[] input = {"i", "have", "an", "egg"};
      String[] expected = {"an", "have", "i", "egg"};
      Sort.swap(input, 0, 2);
      assertArrayEquals(expected, input);

      // Test 1
      String[] input2 = {"i", "have", "an", "egg"};
      String[] expected2 = {"egg", "have", "an", "i"};
      Sort.swap(input2, 0, 3);
      assertArrayEquals(expected2, input2);
   }

}