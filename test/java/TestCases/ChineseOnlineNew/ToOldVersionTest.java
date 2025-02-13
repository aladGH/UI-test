package TestCases.ChineseOnlineNew;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ToOldVersionTest {
    private BasePage ToOldVersion;
    @BeforeTest
    public void CreatPages() throws Exception{
        ToOldVersion = new BasePage("ToOldVersion", "ChineseOnlineNew/ToOldVersion.xml");
    }
    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test(priority = 1)
    public void ToOldVersion() throws Exception {
        //返回首页并切换到旧版
        $(ToOldVersion.byElement("左上角LOGO")).should(exist).click();
        sleep(500);
        $(ToOldVersion.byElement("切换旧版按钮")).should(exist).shouldHave(text("切换旧版")).click();
        sleep(1000);
    }
}
