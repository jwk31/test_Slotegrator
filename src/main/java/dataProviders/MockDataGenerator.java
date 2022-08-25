package dataProviders;

import com.github.javafaker.Faker;
import org.bouncycastle.util.encoders.Base64;

import java.util.Locale;

public class MockDataGenerator {

    protected static final Locale locale = new Locale("EN");
    protected static Faker faker = new Faker(locale);

    public String generateMockUserName() {
        return faker.name().username();
    }

    public String generateMockPassword() {
        return Base64.toBase64String(faker.internet().password(7, 15).getBytes());
    }

    public String generateMockEmail() {
        return faker.internet().emailAddress();
    }

    public String generateMockName() {
        return faker.name().firstName();
    }

    public String generateMockLastName() {
        return faker.name().lastName();
    }
}
