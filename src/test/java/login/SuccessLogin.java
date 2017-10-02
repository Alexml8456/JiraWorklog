package login;


import configs.BaseTest;
import header.Header;
import org.junit.AfterClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exist;
import static config.Gherkin.*;

public class SuccessLogin extends BaseTest {
    static LoginPage loginPage = new LoginPage();
    static Header header = new Header();

    @AfterClass
    public static void logOut() {
        header.clickLogOut();
    }

    @Test
    public void successfulLogin() {
        WHEN("User login");
        loginPage.login(getUserName(), getPassword());

        EXPECT("Create button should be present");
        header.getCreateButton().shouldBe(exist);
        header.avatar().shouldBe(exist);
    }
}