package worklog;

import com.codeborne.selenide.SelenideElement;
import configs.BaseTest;
import header.Header;
import login.LoginPage;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static config.Gherkin.*;

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


        workLogPage.getWorkLogRows().forEach(element->{
            boolean condition = !(element.getText().contains("Sat") || element.getText().contains("Sun"));
            if (condition){
                element.find((By) $$("td").get(2));
//                if (element.$$("td").get(2).getText().isEmpty()) {
//                    workLogPage.getWorkLogButtons().get(i).click();
//                    workLogPage.workLogDialog.getStartTime().setValue(getStartTime());
//                    workLogPage.workLogDialog.getEndTime().setValue(getEndTime());
//                    workLogPage.workLogDialog.getProject().selectOptionContainingText(getProject());
//                    workLogPage.workLogDialog.getGroup().selectOptionContainingText(getGroup());
//                    workLogPage.workLogDialog.clickSaveButton();
//                    element.$$("td").get(2).waitUntil(text(getStartTime()), 5000);
//                }
            }
        });
        
//        for (int i = 0; i < workLogPage.getWorkLogRows().size(); i++) {
//            if (!workLogPage.getColumnDates().get(i).getText().contains("Sat") && !workLogPage.getColumnDates().get(i).getText().contains("Sun")) {
//                if (workLogPage.getWorkLogRows().get(i).$$("td").get(2).getText().isEmpty()) {
//                    workLogPage.getWorkLogButtons().get(i).click();
//                    workLogPage.workLogDialog.getStartTime().setValue(getStartTime());
//                    workLogPage.workLogDialog.getEndTime().setValue(getEndTime());
//                    workLogPage.workLogDialog.getProject().selectOptionContainingText(getProject());
//                    workLogPage.workLogDialog.getGroup().selectOptionContainingText(getGroup());
//                    workLogPage.workLogDialog.clickSaveButton();
//                    workLogPage.getWorkLogRows().get(i).$$("td").get(2).waitUntil(text(getStartTime()), 5000);
//                }
//            }
//        }


        EXPECT("Logout link and welcome message should be present");
        header.avatar().shouldBe(visible);
    }
}