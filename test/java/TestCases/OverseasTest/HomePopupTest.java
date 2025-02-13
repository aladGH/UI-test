package TestCases.OverseasTest;

import Object.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomePopupTest {

    private BasePage loginPageYD;
    private BasePage HomePopup;

    @BeforeTest
    public void CreatPages() throws Exception{
        loginPageYD = new BasePage("YiDunLoginPage","OverseasTest/YiDunLoginPage.xml");
        HomePopup = new BasePage("HomePopup", "OverseasTest/HomePopup.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //登录用户后台并关闭弹窗
    @Test(priority = 1)
    public void Popup() throws Exception{
        Configuration.browser = "chrome";

        //executeJavaScript("window.open('your URL', '_blank');");
        open("https://qa-nis.commsease.com/yunlogin.html");

        $(loginPageYD.byElement("用户名")).setValue("zcprbq30846@chacuo.net");
        $(loginPageYD.byElement("密码")).setValue("aladwy123");
        $(loginPageYD.byElement("域名")).setValue("consoletest.commsease.com");
        $(loginPageYD.byElement("登录按钮")).click();
        sleep(2000);

        //executeJavaScript("window.open('https://apptest.netease.im', '_blank');");
        open("https://consoletest.commsease.com/overview");
        sleep(9000);

        //打开新标签页后一定要切换，不然进程还停留在前一个标签页
        //switchTo().window(1);

    }
}
