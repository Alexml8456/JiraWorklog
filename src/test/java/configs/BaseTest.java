package configs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static config.PropertyReader.getConfig;

public class BaseTest {

    private static final String USER_NAME = "user";
    private static final String PASSWORD = "password";
    private static final String APP_URL = "app.url";
    private static final String TEST_BROWSER = "test.browser";
    private static final String BROWSER_SIZE = "browser.size";
    private static final String TEST_TIMEOUT = "test.timeout";
    private static final String START_TIME = "start.time";
    private static final String END_TIME = "end.time";
    private static final String PROJECT = "project";
    private static final String GROUP = "group";


    private static Properties config;

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        if (config == null) {
            config();
        }
        openPage();
    }

    private static void config() {
        config = getConfig();

        Configuration.baseUrl = config.getProperty(APP_URL);
        Configuration.browser = config.getProperty(TEST_BROWSER);
        Configuration.browserSize = config.getProperty(BROWSER_SIZE);
        Configuration.timeout = Long.valueOf(config.getProperty(TEST_TIMEOUT));
    }

    private static void openPage() {
        Selenide.open("/");
    }


    public static String getUserName() {
        return config.getProperty(USER_NAME);
    }

    public static String getPassword() {
        return config.getProperty(PASSWORD);
    }

    public static String getStartTime() {
        return config.getProperty(START_TIME);
    }

    public static String getEndTime() {
        return config.getProperty(END_TIME);
    }

    public static String getProject() {
        return config.getProperty(PROJECT);
    }

    public static String getGroup() {
        return config.getProperty(GROUP);
    }

    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File testResultScreenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(testResultScreenshot);
    }
}
