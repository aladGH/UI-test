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
import static com.codeborne.selenide.Selenide.sleep;

//订单
public class OrderTest {
    private BasePage Order;

    @BeforeTest
    public void CreatPages() throws Exception{
        Order = new BasePage("Order", "ChineseOnlineOld/Order.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test(priority = 1)
    public void Order() throws Exception{

        //点击进入订单
        $(Order.byElement("订单-按钮")).should(exist).click();
        sleep(3000);

        //申请合同入口
        $(Order.byElement("订单-申请合同入口")).should(exist).shouldHave(text("申请合同"));

        //申请开票入口
        $(Order.byElement("订单-申请开票入口")).should(exist).shouldHave(text("申请开票"));

    }

}
