package TestCases;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

import Object.BasePage;

import java.io.File;
import java.io.IOException;


public class LoginPageTest1 {

    private BasePage loginPage;

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //登录页元素是否存在的判断
    @Test
    public void LoginPageElement() throws Exception {
//        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\wb.anliao01\\.cache\\selenium\\chromedriver\\win64\\130.0.6723.117\\chromedriver.exe");
        Configuration.browserBinary = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        System.setProperty("selenide.browser", "Chrome");
        open("https://apptest.netease.im");
        //点击登录切换按钮
        $(byXpath("切换按钮")).should(exist).click();

        //注册按钮
        $(byXpath("注册按钮")).should(exist);
        //切换子账号按钮
        $(byXpath("切换子账号按钮")).should(exist);
        //忘记密码
        $(byXpath("忘记密码")).should(exist);
    }

    @Test
    public void Login() throws Exception {
        loginPage = new BasePage("163loginPage","163LoginPage.xml");

//        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\wb.anliao01\\.cache\\selenium\\chromedriver\\win64\\130.0.6723.117\\chromedriver.exe");
        Configuration.browserBinary = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        System.setProperty("selenide.browser", "Chrome");


        Configuration.holdBrowserOpen = true;

        //executeJavaScript("window.open('your URL', '_blank');");
        open("https://qa-nis.netease.im/yunlogin.html");

        $(loginPage.byElement("用户名")).setValue("aladwy@126.com");
        $(loginPage.byElement("密码")).setValue("aladwy@123");
        $(loginPage.byElement("产品名")).setValue("apptest.netease.im");
        $(loginPage.byElement("登录按钮")).click();
        sleep(5000);

        //executeJavaScript("window.open('https://apptest.netease.im', '_blank');");
        open("https://apptest.netease.im");
        sleep(2000);
        $(byCssSelector("#rc-tabs-0-panel-1 > div > svg > g > g:nth-child(2) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-1 > div > svg > g > g:nth-child(3) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-1 > div > svg > g > g:nth-child(4) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-1 > div > svg > g > g:nth-child(5) > image")).should(exist);
        sleep(500);
        //切换为自助化功能配置介绍
        $(byXpath("//*[@id=\"rc-tabs-0-tab-2\"]/div/div[2]")).should(exist).click();
        $(byCssSelector("#rc-tabs-0-panel-2 > div > svg > g > g:nth-child(2) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-2 > div > svg > g > g:nth-child(3) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-2 > div > svg > g > g:nth-child(4) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-2 > div > svg > g > g:nth-child(5) > image")).should(exist);

        sleep(500);

        //切换为清晰的账单费用介绍
        $(byXpath("//*[@id=\"rc-tabs-0-tab-3\"]/div/div[1]")).should(exist).click();
        $(byCssSelector("#rc-tabs-0-panel-3 > div > svg > g > g:nth-child(2) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-3 > div > svg > g > g:nth-child(3) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-3 > div > svg > g > g:nth-child(4) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-3 > div > svg > g > g:nth-child(5) > image")).should(exist);
        sleep(500);

        //切换为清晰的账单费用介绍
        $(byXpath("//*[@id=\"rc-tabs-0-tab-4\"]/div/div[1]")).should(exist).click();
        $(byCssSelector("#rc-tabs-0-panel-4 > div > svg > g > g:nth-child(2) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-4 > div > svg > g > g:nth-child(3) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-4 > div > svg > g > g:nth-child(4) > image")).should(exist);
        sleep(500);
        //判断升级文档文案
        $(byXpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/div[1]/a/u")).getOwnText().equals("查看升级文档");

        //关闭新版介绍弹窗
        $(byXpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/button/span")).should(exist).click();

        //打开应用详情页面
        open("https://apptest.netease.im/global/application/overview/basic?appid=146289677");
        closeWebDriver();
    }

    @AfterClass
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}