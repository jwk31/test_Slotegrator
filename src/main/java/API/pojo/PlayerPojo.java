package API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dataProviders.MockDataGenerator;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerPojo {
    private String username;
    private String password_change;
    private String password_repeat;
    private String email;
    private String name;
    private String surname;
    private String currency_code;

    MockDataGenerator mockData = new MockDataGenerator();

    public PlayerPojo() {
        this.username = mockData.generateMockUserName();
        this.password_change = mockData.generateMockPassword();
        this.password_repeat = this.password_change;
        this.email = mockData.generateMockEmail();
        this.name = mockData.generateMockName();
        this.surname = mockData.generateMockLastName();
    }
}
