package TestCases.ChineseOnlineOld;

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

public class ToNewVersionTest {
    private BasePage ToNewVersion;
    @BeforeTest
    public void CreatPages() throws Exception{
        ToNewVersion = new BasePage("ToNewVersion", "ChineseOnlineOld/ToNewVersion.xml");
    }
    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test(priority = 1)
    public void ToNewVersion() throws Exception {
        //返回首页并切换到新版
        $(ToNewVersion.byElement("概览")).should(exist).click();
        sleep(500);
        $(ToNewVersion.byElement("切换到新版按钮")).should(exist).shouldHave(text("即刻体验新版")).click();
        sleep(500);
        if ($(ToNewVersion.byElement("知道了")).exists()){
            $(ToNewVersion.byElement("知道了")).should(exist).click();
        }

    }
}
