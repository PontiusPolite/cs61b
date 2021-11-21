public class Dog {
    public int weightInPounds; // Instance variable
    public static String binomen = "Canis familiaris";

    public Dog(int w) { // Constructor
        weightInPounds = w;
    }

    // Class Method
    public void makeNoise() { // Non-static method, aka instance method
        if (weightInPounds < 10) {
            System.out.println("yip");
        } else if (weightInPounds < 30) {
            System.out.println("bark.");
        } else {
            System.out.println("wooof!");
        }
    }

    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }

    public Dog maxDog(Dog d2) {
        if (this.weightInPounds > d2.weightInPounds) {
            return this;
        }
        return d2;
    }

    // Returns a new array that contains every Dog that is larger than its 4 closest neighbors
    // i.e., the two left and right in the array. 
    // largerThanFourNeighbors(dogs with size [10, 20, 30, 25, 20, 40, 10]) -> dogs with size [30, 40]

    public static Dog[] largerThanFourNeighbors(Dog[] dogs){
        Dog[] returnDogs = new Dog[dogs.length];
        int cnt = 0;
        
        for (int i = 0; i < dogs.length; i +=1) {
            
            if (isBiggestOfFour(dogs, i)) {
                returnDogs[cnt] = dogs[i];
                cnt = cnt + 1;
            }
        }

        

        return returnDogs;
    }

    // The below if a helper method.
    /** Returns true if dogs[i] is larger than its four neighbors */
    public static boolean isBiggestOfFour(Dog[] dogs, int i){
        boolean isBiggest = true;
        for (int j = -2; j <= 2; j += 1){
            if (j == 0) {
                continue;
            }
            if (validIndex(dogs, i + j)){
                if (dogs[i + j].weightInPounds >= dogs[i].weightInPounds){
                    isBiggest = false;
                }
            }
        }
        return isBiggest;
    }

    public static boolean validIndex(Dog[] dogs, int i) { 
        return (i >= 0) || (i < dogs.length);
    }
}