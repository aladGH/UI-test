package TestCases.ChineseOnlineNew;

import Object.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LeftMenuBarTest {

    private BasePage loginPage;
    private BasePage LeftMenuBar;

    @BeforeTest
    public void CreatPages() throws Exception{
        loginPage = new BasePage("loginPage","ChineseOnlineNew/LoginPage.xml");
        LeftMenuBar = new BasePage("LeftMenuBar", "ChineseOnlineNew/LeftMenuBar.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //左侧菜单栏按钮
    @Test(priority = 1)
    public void LeftMenuBar() throws Exception{

        //首页
        $(LeftMenuBar.byElement("首页")).should(exist);

        //费用中心
        $(LeftMenuBar.byElement("费用中心")).should(exist).click();
        //资金管理存在
        $(LeftMenuBar.byElement("资金管理")).should(exist).shouldHave(text("资金管理")).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/cost-center/capital/account");

        //收支明细存在
        $(LeftMenuBar.byElement("收支明细")).should(exist).shouldHave(text("收支明细")).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/cost-center/transaction-flow");

        //账单管理存在
        $(LeftMenuBar.byElement("账单管理")).should(exist).shouldHave(text("账单管理")).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/cost-center/bill/overview");
        //账单总览存在
        $(LeftMenuBar.byElement("账单总览存在")).should(exist).shouldHave(text("账单总览"));
        //账单明细存在
        $(LeftMenuBar.byElement("账单明细存在")).should(exist).shouldHave(text("账单明细"));

        //订单管理存在
        $(LeftMenuBar.byElement("订单管理")).should(exist).shouldHave(text("订单管理")).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/cost-center/order");

        //合同管理存在
        $(LeftMenuBar.byElement("合同管理")).should(exist).shouldHave(text("合同管理")).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/cost-center/contract");


        //发票管理存在
        $(LeftMenuBar.byElement("发票管理")).should(exist).shouldHave(text("发票管理")).click();
        switchTo().window(0).getCurrentUrl().equals("https://app.yunxin.163.com/global/cost-center/invoice");

    }

    //指南针
    @Test(priority = 5)
    public void ServiceMonitoringPlatform() throws Exception{

        //点击进入指南针
        $(LeftMenuBar.byElement("指南针-按钮")).should(exist).click();
        sleep(2000);
        switchTo().window(1).getCurrentUrl().equals("https://compass.yunxin.163.com/static/nim/insight/quality");
        Selenide.closeWindow();
        switchTo().window(0);


    }
    //合同管理
    @Test(priority = 10)
    public void contract() throws Exception{

        //点击进入合同管理
        $(LeftMenuBar.byElement("合同管理")).should(exist).click();
        sleep(700);
        //申请合同入口
        $(LeftMenuBar.byElement("合同管理-申请合同入口")).should(exist).shouldHave(text("申请合同"));

    }


    //发票管理
    @Test(priority = 11)
    public void Invoice() throws Exception{

        //按钮存在，点击按钮进入
        $(LeftMenuBar.byElement("发票管理")).should(exist).click();

        //申请开票入口
        $(LeftMenuBar.byElement("发票管理-申请开票入口")).should(exist).shouldHave(text("申请开票"));

        //开票信息
        $(LeftMenuBar.byElement("发票管理-修改开票信息")).should(exist).shouldHave(text("修改开票信息"));

        //邮寄信息

        if ($(LeftMenuBar.byElement("发票-添加邮寄信息")).is(exist)){
            $(LeftMenuBar.byElement("发票-添加邮寄信息")).should(exist).shouldHave(text("马上添加"));}
        else{
            $(LeftMenuBar.byElement("发票-修改地址信息")).should(exist).shouldHave(text("修改地址信息"));}

        $(LeftMenuBar.byElement("费用中心")).should(exist).click();

    }

}
