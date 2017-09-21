package dashboard;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class Dashboard {
    private SelenideElement headerDetails = $(byId("header-details-user-fullname"));
    private SelenideElement optionContent = $(byId("user-options-content"));
    private SelenideElement logOut = this.optionContent.$(byId("log_out"));
    private SelenideElement workLogs = this.optionContent.$(byId("worklog"));

    public void clickLogOut(){
        this.headerDetails.click();
        this.logOut.click();
    }

    public void openWorkLog(){
        this.headerDetails.click();
        this.workLogs.click();
    }

    public SelenideElement avatar() {
        return headerDetails;
    }
}