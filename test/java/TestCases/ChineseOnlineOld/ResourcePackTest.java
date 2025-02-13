package TestCases.ChineseOnlineOld;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResourcePackTest {
    private BasePage ResourcePack;

    @BeforeTest
    public void CreatPages() throws Exception{
        ResourcePack = new BasePage("ResourcePack", "ChineseOnlineOld/ResourcePack.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //资源包
    @Test(priority = 1)
    public void ResourcePack() throws Exception{

        //按钮存在
        $(ResourcePack.byElement("资源包-按钮")).should(exist).click();

    }

}
