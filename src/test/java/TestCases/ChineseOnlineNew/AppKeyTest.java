package TestCases.ChineseOnlineNew;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AppKeyTest {

    private BasePage AppKeyPage;
    private BasePage ApplicationDetailsPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        AppKeyPage = new BasePage("AppKeyPage", "ChineseOnlineNew/AppKeyPage.xml");
        ApplicationDetailsPage = new BasePage("ApplicationDetailsPage", "ChineseOnlineNew/ApplicationDetailsPage.xml");
        //打开应用详情页面
        open("https://app.yunxin.163.com/global/application/overview/appkey?appid=25126789");
        sleep(500);
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //AppKey 管理
    @Test(priority = 1)
    public void AppKey() throws Exception{
        sleep(500);
        $(ApplicationDetailsPage.byElement("应用配置-AppKey 管理")).should(exist).click();
        //AppKey 管理
        $(AppKeyPage.byElement("AppKey 管理")).should(exist).shouldHave(text("AppKey 管理"));

        //说明文案
        $(AppKeyPage.byElement("说明文案")).should(exist).shouldHave(text("此为该应用唯一对应的AppKey，请妥善保管！"));

        //AppKey 管理
        $(AppKeyPage.byElement("应用配置-AppKey")).should(exist).shouldHave(text("AppKey"));

        //消息抄送
        $(AppKeyPage.byElement("应用配置-AppSecret")).should(exist).shouldHave(text("AppSecret"));

        //标识管理
        $(AppKeyPage.byElement("自动刷新按钮")).should(exist).shouldHave(text("自动刷新"));

        //证书管理
        $(AppKeyPage.byElement("手动设置按钮")).should(exist).shouldHave(text("手动设置"));
    }
}
