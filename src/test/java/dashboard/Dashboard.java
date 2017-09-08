package dashboard;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class Dashboard {
    private SelenideElement header = $(byId("header-details-user-fullname"));

    public SelenideElement getHeader() {
        return header;
    }
}