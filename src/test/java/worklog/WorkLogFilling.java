package worklog;

import configs.BaseTest;
import header.Header;
import login.LoginPage;
import org.junit.AfterClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static config.Gherkin.EXPECT;
import static config.Gherkin.WHEN;

public class WorkLogFilling extends BaseTest {
    static LoginPage loginPage = new LoginPage();
    static Header header = new Header();
    static WorkLogPage workLogPage = new WorkLogPage();

    @AfterClass
    public static void logOut() {
        header.clickLogOut();
    }

    @Test
    public void workLogFilling() {
        WHEN("User login");
        loginPage.login(getUserName(), getPassword());
        header.openWorkLog();

        workLogPage.getWorkLogRows().forEach(element -> {
            boolean condition = !(element.getText().contains("Sat") || element.getText().contains("Sun"));
            if (condition && element.$$("td").get(2).getText().isEmpty()) {
                element.$$("td").get(1).click();
                workLogPage.workLogDialog.setStartTime();
                workLogPage.workLogDialog.setEndTime();
                workLogPage.workLogDialog.selectProject();
                workLogPage.workLogDialog.selectGroup();
                workLogPage.workLogDialog.clickSaveButton();
                element.$$("td").get(2).waitUntil(text(getStartTime()), 5000);
            }
        });

        EXPECT("Logout link and welcome message should be present");
        header.avatar().shouldBe(visible);
    }
}