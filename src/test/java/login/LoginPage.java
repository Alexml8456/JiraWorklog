package login;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginPage {
    private SelenideElement frame = $(byId("gadget-0"));
    private SelenideElement loginForm = $(byId("loginform"));
    private SelenideElement userName = this.loginForm.$(byId("login-form-username"));
    private SelenideElement password = this.loginForm.$(byId("login-form-password"));
    private SelenideElement logInButton = this.loginForm.$(byId("login"));

    @Step
    public void inputUserName(String user) {
        this.userName.setValue(user);
    }

    @Step
    public void inputPassword(String password) {
        this.password.setValue(password);
    }

    @Step
    public void clickLogInButton() {
        this.logInButton.click();
    }

    @Step
    public void login(String user, String password) {
        switchTo().frame(this.frame);
        this.inputUserName(user);
        this.inputPassword(password);
        this.clickLogInButton();
    }

}