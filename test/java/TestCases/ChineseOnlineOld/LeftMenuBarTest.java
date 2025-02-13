package TestCases.ChineseOnlineOld;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LeftMenuBarTest {
    private BasePage LeftMenuBar;

    @BeforeTest
    public void CreatPages() throws Exception{
        LeftMenuBar = new BasePage("LeftMenuBar", "ChineseOnlineOld/LeftMenuBar.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //左侧菜单栏按钮
    @Test(priority = 1)
    public void LeftMenuBar() throws Exception{

        //解决方案
        $(LeftMenuBar.byElement("解决方案")).should(exist);

        //工单
        $(LeftMenuBar.byElement("工单")).should(exist).hover();
        //提交工单存在
        $(LeftMenuBar.byElement("提交工单存在")).should(exist);
        //我的工单存在
        $(LeftMenuBar.byElement("我的工单存在")).should(exist);

        //数据统计
        $(LeftMenuBar.byElement("数据统计")).should(exist);

        //服务监控平台
        $(LeftMenuBar.byElement("服务监控平台")).should(exist);

        //订单
        $(LeftMenuBar.byElement("订单")).should(exist);

        //账单
        $(LeftMenuBar.byElement("账单")).should(exist).hover();
        //账单总览存在
        $(LeftMenuBar.byElement("账单总览存在")).should(exist);
        //账单明细存在
        $(LeftMenuBar.byElement("账单明细存在")).should(exist);

        //流水明细
        $(LeftMenuBar.byElement("流水明细")).should(exist);

        //代金券
        $(LeftMenuBar.byElement("代金券")).should(exist);

        //资源包
        $(LeftMenuBar.byElement("资源包")).should(exist);

        //发票
        $(LeftMenuBar.byElement("发票")).should(exist);
    }
}
