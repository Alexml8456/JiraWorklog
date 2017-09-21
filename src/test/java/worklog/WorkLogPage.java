package worklog;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkLogPage {
    private SelenideElement workLogReport = $(byId("worklog-report"));
    private SelenideElement tBody = $("tbody");
    private ElementsCollection workLogRows = this.workLogReport.$$("tbody tr");
    private ElementsCollection columnDates = this.tBody.$$(byClassName("column_date"));
    private ElementsCollection workLogButtons = this.tBody.$$(byAttribute("class", "aui-icon aui-icon-small aui-iconfont-add"));
    private SelenideElement cancelButton = $(byId("cancel"));
    private SelenideElement saveButton = $(byId("submit"));
    private SelenideElement createDialog = $(byId("create-worklog"));
    private SelenideElement startTime = this.createDialog.$(byId("worklog_startTime"));
    private SelenideElement endTime = this.createDialog.$(byId("worklog_endTime"));
    private SelenideElement project = this.createDialog.$(byId("worklog_project"));
    private SelenideElement group = this.createDialog.$(byId("worklog_squad"));
    private SelenideElement stTime = $$("td").get(2);



    public ElementsCollection getWorkLogRows() {
        return workLogRows;
    }

    public ElementsCollection getColumnDates() {
        return columnDates;
    }


    public SelenideElement getCancelButton() {
        return cancelButton;
    }

    public ElementsCollection getWorkLogButtons() {
        return workLogButtons;
    }

    public SelenideElement getStartTime() {
        return startTime;
    }

    public SelenideElement getEndTime() {
        return endTime;
    }

    public SelenideElement getProject() {
        return project;
    }

    public SelenideElement getGroup() {
        return group;
    }

    public SelenideElement getSaveButton() {
        return saveButton;
    }

    public SelenideElement getStTime() {
        return stTime;
    }
}
