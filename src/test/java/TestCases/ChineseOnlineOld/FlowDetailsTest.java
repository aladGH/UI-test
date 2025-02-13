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

//流水明细
public class FlowDetailsTest {
    private BasePage FlowDetails;

    @BeforeTest
    public void CreatPages() throws Exception{
        FlowDetails = new BasePage("FlowDetails", "ChineseOnlineOld/FlowDetails.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }


    @Test(priority = 1)
    public void FlowDetails() throws Exception{

        //按钮存在
        $(FlowDetails.byElement("流水明细-按钮")).should(exist).click();

    }

}
