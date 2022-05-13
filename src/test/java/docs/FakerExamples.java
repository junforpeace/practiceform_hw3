package docs;

import com.github.javafaker.Faker;

public class FakerExamples {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.lordOfTheRings().character());
        System.out.println(faker.lebowski().quote());
    }
}
