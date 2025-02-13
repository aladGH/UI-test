package TestCases.ChineseOnlineNew;

import Object.BasePage;
import TestCases.ChineseOnlineOld.GoToNewVersionTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePopupTest {

    private BasePage loginPageYD;
    private BasePage HomePopupNew;
    GoToNewVersionTest GoToNwe = new TestCases.ChineseOnlineOld.GoToNewVersionTest();

    @BeforeTest
    public void CreatPages() throws Exception{
        loginPageYD = new BasePage("YiDunLoginPage","ChineseOnlineNew/YiDunLoginPage.xml");
        HomePopupNew = new BasePage("HomePopupNew", "ChineseOnlineNew/HomePopupNew.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
    @Test(priority = 1)
    public void LoginHome() throws Exception{
        Configuration.browser = "chrome";

        //executeJavaScript("window.open('your URL', '_blank');");
        open("https://qa-nis.163.com/yunlogin.html");

        $(loginPageYD.byElement("用户名")).setValue("19521619180");
        $(loginPageYD.byElement("密码")).setValue("w12345678");
        $(loginPageYD.byElement("域名")).setValue("app.yunxin.163.com");
        sleep(500);
        $(loginPageYD.byElement("登录按钮")).click();
        sleep(1000);
        $(loginPageYD.byElement("登录按钮")).click();
        sleep(1000);
        //executeJavaScript("window.open('https://apptest.netease.im', '_blank');");
        open("https://app.yunxin.163.com");
        sleep(3000);
    }

    //关闭弹窗
    @Test(priority = 2)
    public void Popup() throws Exception{

        //打开新标签页后一定要切换，不然进程还停留在前一个标签页
        //switchTo().window(1);
        String url = switchTo().window(0).getCurrentUrl();
        if(url.equals("https://app.yunxin.163.com/overview")){
            //老版本切换到新版本
            GoToNwe.GoToNewVersion();
        }
        else if ($(HomePopupNew.byElement("新版页面引导弹窗")).is(exist)){
            $(HomePopupNew.byElement("第一页底图")).should(exist);
            $(HomePopupNew.byElement("内容多不好找？")).should(exist);
            $(HomePopupNew.byElement("新手上路？")).should(exist);
            $(HomePopupNew.byElement("一眼找重点？")).should(exist);
            $(HomePopupNew.byElement("简洁入口一览无余")).should(exist).shouldHave(text("简洁入口 一览无余"));

            sleep(1000);

            //切换为自助化功能配置介绍
            $(HomePopupNew.byElement("自助化功能配置")).should(exist).click();
            $(HomePopupNew.byElement("第二页底图")).should(exist);
            $(HomePopupNew.byElement("不同产品快捷切换")).should(exist);
            $(HomePopupNew.byElement("功能类型重新整合")).should(exist);
            $(HomePopupNew.byElement("高频功能一键点亮")).should(exist);
            $(HomePopupNew.byElement("自由开通便捷收藏")).should(exist).shouldHave(text("自由开通 便捷收藏"));
            sleep(1000);

            //切换为清晰的账单费用介绍
            $(HomePopupNew.byElement("清晰的账单费用")).should(exist).click();
            $(HomePopupNew.byElement("第三页底图")).should(exist);
            $(HomePopupNew.byElement("费用相关内容聚合")).should(exist);
            $(HomePopupNew.byElement("余额情况清晰明了")).should(exist);
            $(HomePopupNew.byElement("账单构成一览无余")).should(exist);
            $(HomePopupNew.byElement("消耗占比明细清晰")).should(exist).shouldHave(text("消耗占比 明细清晰"));
            sleep(1000);

            //切换为清晰的账单费用介绍
            $(HomePopupNew.byElement("灵活的消息订阅")).should(exist).click();
            $(HomePopupNew.byElement("第四页底图")).should(exist);
            $(HomePopupNew.byElement("消息和接收人双维度设置")).should(exist);
            $(HomePopupNew.byElement("不同消息类型灵活配置接收人及方式")).should(exist);
            $(HomePopupNew.byElement("多种角色随意组合")).should(exist).shouldHave(text("多种角色 随意组合"));
            sleep(1000);

            //查看升级文档文案并校验链接地址
            $(HomePopupNew.byElement("查看升级文档")).getOwnText().equals("查看升级文档");
            $(HomePopupNew.byElement("查看升级文档")).click();
            switchTo().window(1).getCurrentUrl().equals("https://doc.yunxin.163.com/console/docs/Tg4NjM0MjE?platform=console");
            switchTo().window(1).close();
            switchTo().window(0);


            //暂不体验按钮存在并点击关闭窗口
            $(HomePopupNew.byElement("跳过教程")).should(exist).click();
            //关闭切换提示
//            $(HomePopupNew.byElement("知道了")).should(exist).click();
        }

    }

}
