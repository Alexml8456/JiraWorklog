package login;

import configs.BaseTest;
import dashboard.Dashboard;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static config.Gherkin.*;

public class SuccessLogin extends BaseTest{
    static LoginPage loginPage = new LoginPage();
    static Dashboard dashboard = new Dashboard();

    @Test
    public void successfulLogin() {
        WHEN("User login");
        loginPage.login(getUserName(), getPassword());

        EXPECT("Logout link and welcome message should be present");
        dashboard.getHeader().shouldBe(visible);
    }
}