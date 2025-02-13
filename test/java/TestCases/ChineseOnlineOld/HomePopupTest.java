package TestCases.ChineseOnlineOld;

import Object.BasePage;
import TestCases.ChineseOnlineNew.BackOldVersionTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class HomePopupTest {
    BackOldVersionTest Back = new TestCases.ChineseOnlineNew.BackOldVersionTest();

    private BasePage loginPageYD;
    private BasePage HomePopupOld;

    @BeforeTest
    public void CreatPages() throws Exception{
        loginPageYD = new BasePage("YiDunLoginPage","ChineseOnlineOld/YiDunLoginPage.xml");
        HomePopupOld = new BasePage("HomePopupOld", "ChineseOnlineOld/HomePopupOld.xml");
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
        open("https://qa-nis.163.com/yunlogin.html");

        $(loginPageYD.byElement("用户名")).setValue("19521619180");
        $(loginPageYD.byElement("密码")).setValue("w12345678");
        $(loginPageYD.byElement("域名")).setValue("app.yunxin.163.com");
        $(loginPageYD.byElement("登录按钮")).click();
        sleep(5000);

        //executeJavaScript("window.open('https://apptest.netease.im', '_blank');");
        open("https://app.yunxin.163.com");
        sleep(6000);
        String url = switchTo().window(0).getCurrentUrl();
        if(url.equals("https://app.yunxin.163.com/global/home")) {
            Back.BackOldVersion();

            //关闭反垃圾弹窗
            $(HomePopupOld.byElement("反垃圾弹窗")).shouldBe(text("产品更新"));
            $(HomePopupOld.byElement("反垃圾弹窗-关闭按钮")).should(exist).click();

            //关闭子账号弹窗
            $(HomePopupOld.byElement("子账号弹窗")).shouldBe(text("云信控制台子账号及权限管理上线啦"));
            $(HomePopupOld.byElement("子账号弹窗-关闭按钮")).should(exist).click();
        }
        else {
            //新版本引导
            $(HomePopupOld.byElement("第一页底图")).should(exist);
            $(HomePopupOld.byElement("内容多不好找？")).should(exist);
            $(HomePopupOld.byElement("新手上路？")).should(exist);
            $(HomePopupOld.byElement("一眼找重点？")).should(exist);
            $(HomePopupOld.byElement("简洁入口一览无余")).should(exist).shouldHave(text("简洁入口 一览无余"));

            sleep(1000);

            //切换为自助化功能配置介绍
            $(HomePopupOld.byElement("自助化功能配置")).should(exist).click();
            $(HomePopupOld.byElement("第二页底图")).should(exist);
            $(HomePopupOld.byElement("不同产品快捷切换")).should(exist);
            $(HomePopupOld.byElement("功能类型重新整合")).should(exist);
            $(HomePopupOld.byElement("高频功能一键点亮")).should(exist);
            $(HomePopupOld.byElement("自由开通便捷收藏")).should(exist).shouldHave(text("自由开通 便捷收藏"));
            sleep(1000);

            //切换为清晰的账单费用介绍
            $(HomePopupOld.byElement("清晰的账单费用")).should(exist).click();
            $(HomePopupOld.byElement("第三页底图")).should(exist);
            $(HomePopupOld.byElement("费用相关内容聚合")).should(exist);
            $(HomePopupOld.byElement("余额情况清晰明了")).should(exist);
            $(HomePopupOld.byElement("账单构成一览无余")).should(exist);
            $(HomePopupOld.byElement("消耗占比明细清晰")).should(exist).shouldHave(text("消耗占比 明细清晰"));
            sleep(1000);

            //切换为清晰的账单费用介绍
            $(HomePopupOld.byElement("灵活的消息订阅")).should(exist).click();
            $(HomePopupOld.byElement("第四页底图")).should(exist);
            $(HomePopupOld.byElement("消息和接收人双维度设置")).should(exist);
            $(HomePopupOld.byElement("不同消息类型灵活配置接收人及方式")).should(exist);
            $(HomePopupOld.byElement("多种角色随意组合")).should(exist).shouldHave(text("多种角色 随意组合"));
            sleep(1000);

            //查看升级文档文案并校验链接地址
            $(HomePopupOld.byElement("查看升级文档")).getOwnText().equals("查看升级文档");
            $(HomePopupOld.byElement("查看升级文档")).click();
            switchTo().window(1).getCurrentUrl().equals("https://doc.yunxin.163.com/console/docs/Tg4NjM0MjE?platform=console");
            switchTo().window(1).close();
            switchTo().window(0);


            //暂不体验按钮存在并点击关闭窗口
            $(HomePopupOld.byElement("暂不体验")).should(exist).click();


            //打开新标签页后一定要切换，不然进程还停留在前一个标签页
            //switchTo().window(1);

            //关闭反垃圾弹窗
            $(HomePopupOld.byElement("反垃圾弹窗")).shouldBe(text("产品更新"));
            $(HomePopupOld.byElement("反垃圾弹窗-关闭按钮")).should(exist).click();

            //关闭子账号弹窗
            $(HomePopupOld.byElement("子账号弹窗")).shouldBe(text("云信控制台子账号及权限管理上线啦"));
            $(HomePopupOld.byElement("子账号弹窗-关闭按钮")).should(exist).click();

        }
        //打开新标签页后一定要切换，不然进程还停留在前一个标签页
        //switchTo().window(1);


    }
}
