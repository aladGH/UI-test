package TestCases;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class OverviewPageTest {
    
    @BeforeTest
    public void Login() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;

        //executeJavaScript("window.open('your URL', '_blank');");
        open("https://id-auto.netease.im/external/page/autologinbyproduct");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[1]/input")).setValue("16531765267");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[2]/input")).setValue("w123456");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[4]/input")).setValue("media");

        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/button")).click();
        sleep(2000);

        //executeJavaScript("window.open('https://apptest.netease.im', '_blank');");
        open("https://apptest.netease.im");
        sleep(9000);

        //关闭反垃圾弹窗
        $(byXpath("//*[@id=\"app\"]/div[4]/div/div[2]/a/i")).should(exist).click();

        //关闭子账号弹窗
        $(byXpath("//*[@id=\"app\"]/div[3]/div/div[2]/a")).should(exist).click();
    }

    //右上角hover
    @Test
    public void UpperRightCorner(){

        //基本信息存在
        $(byXpath("//*[@id=\"myHeader\"]/div/div/div[3]/div[2]/ul/li[1]/a")).should(exist).shouldHave(href("/index#/user/info"));

        //实名认证存在
        $(byXpath("//*[@id=\"myHeader\"]/div/div/div[3]/div[2]/ul/li[2]/a")).should(exist).shouldHave(href("/index#/user/verify"));

        //账号管理存在
        $(byXpath("//*[@id=\"myHeader\"]/div/div/div[3]/div[2]/ul/li[3]/a")).should(exist).shouldHave(href("/index#/user/account"));

        //权限管理存在
        $(byXpath("//*[@id=\"myHeader\"]/div/div/div[3]/div[2]/ul/li[4]/a")).should(exist).shouldHave(href("/index#/user/authority"));

        //用户组管理存在
        $(byXpath("//*[@id=\"myHeader\"]/div/div/div[3]/div[2]/ul/li[5]/a")).should(exist).shouldHave(href("/index#/user/usergroup"));
    }

    //概览页广告轮播图
    @Test
    public void Carousel() {

        //轮播图存在
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[2]/div/div[1]/a/img")).should(exist).shouldHave(image).shouldHave(attribute("src","https://nim.nosdn.127.net/d714b141c7d3342f9abff2e5fad5712a.png"));

        //轮播图跳转地址正确
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[2]/div/div[1]/a")).shouldHave(href("https://netease.im/promotion/recommend?from=bdjj2006t62712"));
    }

    //概览页服务监控平台入口
    @Test
    public void Qs () {

        //文案正确
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[2]/div/div[3]/div[1]/div[1]")).shouldBe(text("服务监控平台"));

        //跳转入口正确
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[2]/div/div[3]/div[1]/div[2]/a")).shouldHave(href("/index#/qs"));
    }

    //应用概览及已开通服务
    @Test
    public void OverviewApp() {

        //大卡片存在
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[1]/div[3]")).should(exist);
    }


}
