package TestCases.ChineseOnlineNew;

import Object.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OverviewPageTest {

    private BasePage OverviewPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        OverviewPage = new BasePage("OverviewPage", "ChineseOnlineNew/OverviewPage.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //右上角hover
    @Test(priority = 2)
    public void UpperRightCorner() throws Exception{

        String v ="";
        //右上角存在并hover
        $(OverviewPage.byElement("右上角存在")).should(exist).hover();
        sleep(1000);

        if ($(OverviewPage.byElement("基本信息存在-8")).exists()){
            v = "8";
        } else if ($(OverviewPage.byElement("基本信息存在-9")).exists()) {
            v = "9";
        } else if ($(OverviewPage.byElement("基本信息存在-13")).exists()) {
            v = "13";
        } else if ($(OverviewPage.byElement("基本信息存在-15")).exists()) {
            v = "15";
        }
        //基本信息存在
        $(OverviewPage.byElement("基本信息存在-"+v)).should(exist).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/profile");
        sleep(500);
        $(OverviewPage.byElement("右上角存在")).hover();
        sleep(500);

        //实名认证存在
        $(OverviewPage.byElement("实名认证存在-"+v)).should(exist).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/verify/info");
        sleep(500);
        $(OverviewPage.byElement("右上角存在")).hover();
        sleep(500);

        //账号权限存在
        $(OverviewPage.byElement("账号权限存在-"+v)).should(exist).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/account/user");
        sleep(500);
        $(OverviewPage.byElement("右上角存在")).hover();
        sleep(500);

        //预警设置存在
        $(OverviewPage.byElement("预警设置存在-"+v)).should(exist).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/warn");
        sleep(500);
        $(OverviewPage.byElement("右上角存在")).hover();
        sleep(500);

        //工单存在
        $(OverviewPage.byElement("工单存在-"+v)).should(exist).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/service/ticket/list");
        sleep(500);
        $(OverviewPage.byElement("右上角存在")).hover();
        sleep(500);

        //退出按钮存在
        $(OverviewPage.byElement("退出账号存在-"+v)).should(exist);

        //点击左上角LOGO返回首页
        $(OverviewPage.byElement("左上角LOGO存在")).should(exist).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/home");

    }

    //概览页广告轮播图
    @Test(priority = 1)
    public void Carousel() throws Exception {
        List<String> URL = new ArrayList<>();
        URL.add("https://doc.yunxin.163.com/console/docs/Tg4NjM0MjE?platform=console");
        URL.add("https://doc.yunxin.163.com/campass/docs/zY3MDk3MjU?platform=console");
        URL.add("https://yunxin.163.com/global/social");
        URL.add("https://yunxin.163.com/promotion/recommend");
        URL.add("http://yunxin.163.com/social-1v1");
        //轮播图存在
        $(OverviewPage.byElement("轮播图存在")).should(exist).hover().getAttribute("src").equals("https://nim.nosdn.127.net/d53c46fc1ad4d735e038f0396146e1b5.png");
        // 移动到指定坐标
        sleep(500);
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
        sleep(2000);
    }

    //概览页指南针入口
    @Test(priority = 3)
    public void Qs () throws Exception {

        //文案正确
        $(OverviewPage.byElement("QS文案正确")).shouldBe(text("指南针"));

    }

    //应用概览及已开通服务
    @Test(priority = 4)
    public void OverviewApp() throws Exception {

        //大卡片存在
        $(OverviewPage.byElement("应用管理大卡片存在")).should(exist);
    }

}
