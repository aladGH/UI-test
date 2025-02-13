package TestCases.ChineseTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.SetValueOptions.withText;

public class HomePopupTest {

    private BasePage loginPageYD;
    private BasePage HomePopup;

    @BeforeTest
    public void CreatPages() throws Exception{
        loginPageYD = new BasePage("YiDunLoginPage","ChineseTestOld/YiDunLoginPage.xml");
        HomePopup = new BasePage("HomePopup", "ChineseTestOld/HomePopup.xml");
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
        open("https://qa-nis.netease.im/yunlogin.html");

//        $(loginPageYD.byElement("用户名")).setValue(withText("19521619180"));
//        $(loginPageYD.byElement("密码")).setValue(withText("w123456"));
        $(loginPageYD.byElement("用户名")).setValue(withText("aladwy@126.com"));
        $(loginPageYD.byElement("密码")).setValue(withText("aladwy@123"));
        $(loginPageYD.byElement("域名")).setValue(withText("apptest.netease.im"));
        $(loginPageYD.byElement("登录按钮")).click();
        sleep(2000);

        //executeJavaScript("window.open('https://apptest.netease.im', '_blank');");
        open("http://apptest.netease.im");
        sleep(3000);

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
        $(byXpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/div[1]/a/u")).getOwnText().equals("查看升级文档");

        //关闭新版介绍弹窗
        $(byXpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/button/span")).should(exist).click();


        //打开新标签页后一定要切换，不然进程还停留在前一个标签页
        //switchTo().window(1);

        //关闭反垃圾弹窗
        $(HomePopup.byElement("反垃圾弹窗")).shouldBe(text("产品更新"));
        $(HomePopup.byElement("反垃圾弹窗-关闭按钮")).should(exist).click();

        //关闭子账号弹窗
        $(HomePopup.byElement("子账号弹窗")).shouldBe(text("云信控制台子账号及权限管理上线啦"));
        $(HomePopup.byElement("子账号弹窗-关闭按钮")).should(exist).click();
    }
}
