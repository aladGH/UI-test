package TestCases.OverseasTest;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class OverviewPageTest {

    private BasePage OverviewPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        OverviewPage = new BasePage("OverviewPage", "OverseasTest/OverviewPage.xml");
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
    }

    //应用概览及已开通服务
    @Test(priority = 2)
    public void OverviewApp() throws Exception {

        //大卡片存在
        $(OverviewPage.byElement("应用功能大卡片存在")).should(exist);
    }

}
