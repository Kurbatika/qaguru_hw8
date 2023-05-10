package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String state = new String();

    public static String getRandomName() {

        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {

        return new Faker().name().lastName();
    }

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomPhone() {
        Faker faker = new Faker();
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomBirthDay() {
        Faker faker = new Faker();

        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String getRandomBirthMonth() {
        return new Faker().options().option("January", "February",
                "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getRandomBirthYear() {
        Faker faker = new Faker();
        return String.valueOf(faker.number().numberBetween(1900, 2023));
    }

    public static String getRandomSubject() {
        return new Faker().options().option("Computer Science", "Hindi", "Arts", "Biology", "English");
    }

    public static String getRandomHobbies() {

        return new Faker().options().option("Music", "Sports", "Reading");
    }

    public static String getPicture() {
        String userAvatar = "src/test/resources/pictures/michael.jpg";

        return userAvatar;
    }

    public static String getRandomAddress() {

        return new Faker().address().fullAddress();
    }

    public static String getRandomState() {
        state = new Faker().options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        return state;
    }

    public static String getRandomCity() {
        Faker faker = new Faker();

        String city = new String();

        if (state.equals("NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Haryana")) {
            city = faker.options().option("Karnal", "Panipat");
        } else if (state.equals("Rajasthan")) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }

        return city;
    }
}
