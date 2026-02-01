package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData_Generator {

    public String firstNameGenerator(){
        String firstName = RandomStringUtils.randomAlphabetic(5);
        return firstName;
    }

    public String lasttNameGenerator(){
        String lastName = RandomStringUtils.randomAlphabetic(5);
        return lastName;
    }

    public String emailGenerator(){
        String alphabaticsUpper = RandomStringUtils.randomAlphabetic(2);
        String alphabaticsLower = RandomStringUtils.randomAlphabetic(2);
        String numbers = RandomStringUtils.randomNumeric(2);

        String email = (alphabaticsUpper.toUpperCase() + alphabaticsLower.toLowerCase() + numbers + "@gmail.com");
        return email;
    }

    public String passwordGenerator(){
        String alphabaticsUpper = RandomStringUtils.randomAlphabetic(2);
        String alphabaticsLower = RandomStringUtils.randomAlphabetic(4);
        String numbers = RandomStringUtils.randomNumeric(3);

        String totalPass = (alphabaticsUpper.toUpperCase() + alphabaticsLower.toLowerCase() + numbers + "@");
        return totalPass;
    }
}
