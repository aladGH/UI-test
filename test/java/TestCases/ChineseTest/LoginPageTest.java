package TestCases.ChineseTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Configuration;

import Object.BasePage;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    private BasePage loginPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        loginPage = new BasePage("loginPage","ChineseTestOld/LoginPage.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //登录页可以切换登录方式
    @Test(priority = 1)
    public void SwitchLoginMethod() throws Exception{
        Configuration.browser = "chrome";
        open("https://apptest.netease.im");
        sleep(3000);
        //判断登录切换按钮是否存在
        $(loginPage.byElement("登录切换按钮")).should(exist);
    }

    //登录页元素是否存在的判断
    @Test(priority = 2)
    public void LoginPageElement() throws Exception{
        Configuration.browser = "chrome";
        open("https://apptest.netease.im");
        sleep(3000);
        //点击登录切换按钮
        $(loginPage.byElement("登录切换按钮")).should(exist).click();

        //注册按钮
        $(loginPage.byElement("注册按钮")).should(exist);
        //切换子账号按钮
        $(loginPage.byElement("切换子账号按钮")).should(exist);
        //忘记密码
        $(loginPage.byElement("忘记密码")).should(exist);
    }
}
