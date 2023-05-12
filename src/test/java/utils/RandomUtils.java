package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String state = new String();

    private static Faker faker = new Faker();

    static Date fakerDateOfBirthday = faker.date().birthday();

    public static String getRandomName() {

        return faker.name().firstName();
    }

    public static String getRandomLastName() {

        return faker.name().lastName();
    }

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
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
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomBirthMonth() {
        return new SimpleDateFormat("MMMM", Locale.ENGLISH).format(fakerDateOfBirthday);
    }

    public static String getRandomBirthYear() {
        return new SimpleDateFormat("y", Locale.ENGLISH).format(fakerDateOfBirthday);
    }

    public static String getRandomBirthDay() {
        return new SimpleDateFormat("dd", Locale.ENGLISH).format(fakerDateOfBirthday);
    }

    public static String getRandomSubject() {
        return faker.options().option("Computer Science", "Hindi", "Arts", "Biology", "English");
    }

    public static String getRandomHobbies() {

        return faker.options().option("Music", "Sports", "Reading");
    }

    public static String getPicture() {
        String userAvatar = "src/test/resources/pictures/michael.jpg";

        return userAvatar;
    }

    public static String getRandomAddress() {

        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        return state;
    }

    public static String getRandomCity() {

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
