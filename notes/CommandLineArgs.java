

/* Whatever you put after >java CommandLineArgs will be passed into the 
array String[] args */

public class CommandLineArgs {
    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
           sum +=  Integer.valueOf(arg); 
        }        
        System.out.println(sum);
    }
}
