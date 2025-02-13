package TestCases.ChineseOnlineOld;

import Object.BasePage;
import com.codeborne.selenide.Selenide;
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
        OverviewPage = new BasePage("OverviewPage", "ChineseOnlineOld/OverviewPage.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //右上角hover
    @Test(priority = 2)
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
    @Test(priority = 1)
    public void Carousel() throws Exception {
        List<String> URL = new ArrayList<>();
        URL.add("https://doc.yunxin.163.com/console/docs/Tg4NjM0MjE?platform=console");
        URL.add("https://yunxin.163.com/global/social");
        URL.add("https://yunxin.163.com/promotion/recommend");
        URL.add("http://yunxin.163.com/social-1v1");
        URL.add("https://doc.yunxin.163.com/campass/docs/zY3MDk3MjU?platform=console");
        //轮播图存在
        $(OverviewPage.byElement("轮播图存在")).should(exist).hover().getAttribute("src").equals("https://nim.nosdn.127.net/d53c46fc1ad4d735e038f0396146e1b5.png");
        // 移动到指定坐标
//        Selenide.actions().moveToElement($(OverviewPage.byElement("轮播图跳转地址正确"))).click().perform();
        //轮播图跳转地址正确
        $(OverviewPage.byElement("轮播图跳转地址正确")).click();
        String url = switchTo().window(1).getCurrentUrl();
        if (URL.contains(url)) {
            System.out.println("断言通过");
        } else {
            System.out.println("断言失败");
        }
        Selenide.closeWindow();
        switchTo().window(0);
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
