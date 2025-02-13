package TestCases.OverseasTest;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LeftMenuBarTest {

    private BasePage LeftMenuBar;

    @BeforeTest
    public void CreatPages() throws Exception{
        LeftMenuBar = new BasePage("LeftMenuBar", "OverseasTest/LeftMenuBar.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //左侧菜单栏按钮
    @Test(priority = 1)
    public void LeftMenuBar() throws Exception{

        //数据统计
        $(LeftMenuBar.byElement("数据统计")).should(exist);

        //服务监控平台
        $(LeftMenuBar.byElement("服务监控平台")).should(exist);

        //资源包
        $(LeftMenuBar.byElement("资源包")).should(exist);

    }

    //数据统计
    @Test(priority = 2)
    public void Statistics() throws Exception{

        //跳转链接存在
        $(LeftMenuBar.byElement("数据统计-按钮")).should(exist).click();

        //用户
        $(LeftMenuBar.byElement("数据统计-用户")).should(exist);

        //IM
        $(LeftMenuBar.byElement("数据统计-IM")).should(exist);

        //信令
        $(LeftMenuBar.byElement("数据统计-信令")).should(exist);

        //G2
        $(LeftMenuBar.byElement("数据统计-G2")).should(exist);

        //直播
        $(LeftMenuBar.byElement("数据统计-直播")).should(exist);

        //短信
        $(LeftMenuBar.byElement("数据统计-短信")).should(exist);

    }

    //服务监控平台
    @Test(priority = 3)
    public void ServiceMonitoringPlatform() throws Exception{

        //点击进入QS
        $(LeftMenuBar.byElement("服务监控平台-按钮")).should(exist).click();
        sleep(3000);

    }

    //资源包
    @Test(priority = 4)
    public void ResourcePack() throws Exception{

        //按钮存在
        $(LeftMenuBar.byElement("资源包-按钮")).should(exist).click();

    }

}
