package header;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class Header {
    private SelenideElement header = $(byAttribute("class", "aui-header aui-dropdown2-trigger-group"));
    private SelenideElement createButton = this.header.$(byId("create_link"));
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

    public SelenideElement getCreateButton() {
        return createButton;
    }
}