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

//账单
public class BillTest {
    private BasePage Bill;

    @BeforeTest
    public void CreatPages() throws Exception{
        Bill = new BasePage("Bill", "ChineseOnlineOld/Bill.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test(priority = 1)
    public void Bill() throws Exception{
        //入口存在
        $(Bill.byElement("账单-按钮")).hover();
        $(Bill.byElement("账单-账单总览")).should(exist);
        $(Bill.byElement("账单-账单明细")).should(exist);

    }
}
