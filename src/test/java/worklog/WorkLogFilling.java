package worklog;

import configs.BaseTest;
import dashboard.Dashboard;
import login.LoginPage;
import org.junit.AfterClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static config.Gherkin.*;

public class WorkLogFilling extends BaseTest {
    static LoginPage loginPage = new LoginPage();
    static Dashboard dashBoard = new Dashboard();
    static WorkLogPage workLogPage = new WorkLogPage();

    @AfterClass
    public static void logOut() {
        dashBoard.clickLogOut();
    }

    @Test
    public void workLogFilling() {
        WHEN("User login");
        loginPage.login(getUserName(), getPassword());
        dashBoard.openWorkLog();
        for (int i = 0; i < workLogPage.getWorkLogRows().size(); i++) {
            if (!workLogPage.getColumnDates().get(i).getText().contains("Sat") && !workLogPage.getColumnDates().get(i).getText().contains("Sun")) {
                if (workLogPage.getWorkLogRows().get(i).$$("td").get(2).getText().isEmpty()) {
                    workLogPage.getWorkLogButtons().get(i).click();
                    workLogPage.workLogDialog.getStartTime().setValue(getStartTime());
                    workLogPage.workLogDialog.getEndTime().setValue(getEndTime());
                    workLogPage.workLogDialog.getProject().selectOptionContainingText(getProject());
                    workLogPage.workLogDialog.getGroup().selectOptionContainingText(getGroup());
                    workLogPage.workLogDialog.clickSaveButton();
                    workLogPage.getWorkLogRows().get(i).$$("td").get(2).waitUntil(text(getStartTime()), 5000);
                }
            }
        }


        EXPECT("Logout link and welcome message should be present");
        dashBoard.avatar().shouldBe(visible);
    }
}