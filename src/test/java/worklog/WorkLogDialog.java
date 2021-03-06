package worklog;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static configs.BaseTest.*;

public class WorkLogDialog {
    private SelenideElement createDialog = $(byId("create-worklog"));
    private SelenideElement startTime = this.createDialog.$(byId("worklog_startTime"));
    private SelenideElement endTime = this.createDialog.$(byId("worklog_endTime"));
    private SelenideElement project = this.createDialog.$(byId("worklog_project"));
    private SelenideElement group = this.createDialog.$(byId("worklog_squad"));
    private SelenideElement footer = $(byAttribute("class", "aui-dialog2-footer"));
    private SelenideElement cancelButton = this.footer.$(byId("cancel"));
    private SelenideElement saveButton = this.footer.$(byId("submit"));

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void setStartTime() {
        this.startTime.setValue(getStartTime());
    }

    public void setEndTime() {
        this.endTime.setValue(getEndTime());
    }

    public void selectProject() {
        this.project.selectOptionContainingText(getProject());
    }

    public void selectGroup() {
        this.group.selectOptionContainingText(getGroup());
    }
}
