package docs;

import static utils.RandomUtils.*;

public class RandomUtilsExample {
    public static void main(String[] args) {
        System.out.println("Random string of 10 letters:" + getRandomString(10));
        System.out.println("Random int between 2345 and 99999:" + getRandomInt(2345, 99999));
        System.out.println("Random email:" + getRandomEmail());


    }
}
