package TestCases.OverseasTest;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationDetailsPageTest {

    private BasePage ApplicationDetailsPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        ApplicationDetailsPage = new BasePage("ApplicationDetailsPage", "OverseasTest/ApplicationDetailsPage.xml");
        //打开应用详情页面
        open("https://consoletest.commsease.com/application/info?appid=146292687");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //IM
    @Test(priority = 1)
    public void IM() throws Exception{

        //API调试入口
        $(ApplicationDetailsPage.byElement("IM-API调试入口")).should(exist);

        //功能配置
        $(ApplicationDetailsPage.byElement("IM-功能配置")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("IM-开发手册")).should(exist);
    }

    //G2
    @Test(priority = 2)
    public void Netcall2() throws Exception{

        //功能配置
        $(ApplicationDetailsPage.byElement("G2-功能配置")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("G2-开发手册")).should(exist);
    }

    //直播
    @Test(priority = 3)
    public void Live() throws Exception{

        //域名管理
        $(ApplicationDetailsPage.byElement("直播-域名管理")).should(exist);

        //直播管理
        $(ApplicationDetailsPage.byElement("直播-直播管理")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("直播-开发手册")).should(exist);
    }

    //互动直播2.0
    @Test(priority = 4)
    public void InteractiveNetcall2() throws Exception{

        //开发手册
        $(ApplicationDetailsPage.byElement("互动直播2.0-开发手册")).should(exist);
    }

    //短信
    @Test(priority = 5)
    public void SMS() throws Exception{

        //已开通功能
        $(ApplicationDetailsPage.byElement("短信-已开通功能")).should(exist);

        //短信模板管理
        $(ApplicationDetailsPage.byElement("短信-短信模板管理")).should(exist);

        //开发手册
        $(ApplicationDetailsPage.byElement("短信-开发手册")).should(exist);
    }
}
