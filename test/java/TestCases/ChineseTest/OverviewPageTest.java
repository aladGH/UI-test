package TestCases.ChineseTest;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OverviewPageTest {

    private BasePage OverviewPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        OverviewPage = new BasePage("OverviewPage", "ChineseTestOld/OverviewPage.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //右上角hover
    @Test(priority = 1)
    public void UpperRightCorner() throws Exception{

        //右上角存在并hover
        $(OverviewPage.byElement("右上角存在")).should(exist).hover();

        //基本信息存在
        $(OverviewPage.byElement("基本信息存在")).should(exist).shouldHave(href("/user-new/index"));

        //实名认证存在
        $(OverviewPage.byElement("实名认证存在")).should(exist).shouldHave(href("/user#/verify"));

        //角色存在
        $(OverviewPage.byElement("用户存在")).should(exist).shouldHave(href("/user-new/account"));

        //角色组存在
        $(OverviewPage.byElement("用户组存在")).should(exist).shouldHave(href("/user-new/usergroup"));

        //角色权限存在
        $(OverviewPage.byElement("角色权限存在")).should(exist).shouldHave(href("/user-new/role"));

        //资源管理存在
        $(OverviewPage.byElement("资源管理存在")).should(exist).shouldHave(href("/user#/resourcesManage"));
    }

    //概览页广告轮播图
    @Test(priority = 2)
    public void Carousel() throws Exception {


        //轮播图存在
        $(OverviewPage.byElement("轮播图存在")).should(exist).hover().getAttribute("src").equals("https://nim.nosdn.127.net/3e4552929c8f404ce250eb55fad8707c.png");

        //轮播图跳转地址正确
        $(OverviewPage.byElement("轮播图跳转地址正确")).click();
        switchTo().window(1).getCurrentUrl().equals("https://www.taobao.com/");
        List<String> windowHandles = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(windowHandles.get(0));
    }

    //概览页服务监控平台入口
    @Test(priority = 3)
    public void Qs () throws Exception {

        //文案正确
        $(OverviewPage.byElement("QS文案正确")).shouldBe(text("服务监控平台"));
    }

    //应用概览及已开通服务
    @Test(priority = 4)
    public void OverviewApp() throws Exception {

        //大卡片存在
        $(OverviewPage.byElement("应用功能大卡片存在")).should(exist);
    }

}
