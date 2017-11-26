package worklog;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorkLogPage {
    private SelenideElement tBody = $("tbody");
    private ElementsCollection workLogRows = this.tBody.$$("tr");
    private ElementsCollection columnDates = this.tBody.$$(byClassName("column_date"));
    private ElementsCollection workLogButtons = this.tBody.$$(byAttribute("class", "aui-icon aui-icon-small aui-iconfont-add"));
    private SelenideElement date = $$("td").get(0);
    private SelenideElement startTime = $$("td").get(2);

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

    public SelenideElement getStartTime() {
        return startTime;
    }

    public void filling (){
        this.workLogRows.forEach(selenideElement -> {
            selenideElement.$$("td").get(2).click();
        });
    }


}
