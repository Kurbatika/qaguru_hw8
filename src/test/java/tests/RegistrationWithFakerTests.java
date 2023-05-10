package tests;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;

public class RegistrationWithFakerTests extends TestBase {

    @Test
    void formFulfillmentTest() {

        String userFirstName = getRandomName(),
                userLastName = getRandomLastName(),
                userEmail = getRandomEmail(),
                userGender = getRandomGender(),
                userPhone = getRandomPhone(),
                userBirthDay = getRandomBirthDay(),
                userBirthMonth = getRandomBirthMonth(),
                userBirthYear = getRandomBirthYear(),
                userSubjects = getRandomSubject(),
                userHobbies = getRandomHobbies(),
                userAvatar = getPicture(),
                userAddress = getRandomAddress(),
                userState = getRandomState(),
                userCity = getRandomCity();

        registrationPage.openPage()
                .closeBannerAndFooter()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(userSubjects)
                .setHobbies(userHobbies)
                .setAvatar(userAvatar)
                .setAddress(userAddress)
                .pageScrollDown()
                .setState(userState)
                .setCity(userCity)
                .submitUserInfo();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);

    }
}
