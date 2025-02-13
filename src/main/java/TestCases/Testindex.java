package TestCases;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Object.BasePage;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Testindex {

    private BasePage TestindexPage;

    @BeforeTest
    public void CreatPages() throws Exception{
        TestindexPage = new BasePage("TestindexPage", "TestindexPage.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //登录用户后台并关闭弹窗
    @Test
    public void index() throws Exception{
        Configuration.browser = "chrome";

        //executeJavaScript("window.open('your URL', '_blank');");
        open("http://localhost:8888/index.html");

        sleep(2000);

        //打开新标签页后一定要切换，不然进程还停留在前一个标签页
        //switchTo().window(1);

        //百度图片
//        $(by("nim-data","111")).shouldHave(image).shouldHave(attribute("src","https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png"));
//
//        $(by("nim-data","112")).shouldHave(image).shouldHave(attribute("src","https://www.bejson.com/static/bejson/img/logo.png"));

//        $(TestindexPage.byElement("百度图片")).shouldHave(image).shouldHave(attribute("src","https://www.bejson.com/static/bejson/img/logo.png"));
        $(TestindexPage.byElement("117文字")).shouldBe(exist).shouldHave(text("test117"));

        $(TestindexPage.byElement("117文字")).click();
        $(TestindexPage.byElement("下拉框")).selectOption("Cat");

    }
}
