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
    private SelenideElement stTime = $$("td").get(2);

    public WorkLogDialog workLogDialog = new WorkLogDialog();

    public ElementsCollection getWorkLogRows() {
        return workLogRows;
    }

    public ElementsCollection getColumnDates() {
        return columnDates;
    }


    public ElementsCollection getWorkLogButtons() {
        return workLogButtons;
    }

    public SelenideElement getStTime() {
        return stTime;
    }
}
