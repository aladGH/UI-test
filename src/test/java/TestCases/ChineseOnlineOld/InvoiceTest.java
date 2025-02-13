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

public class InvoiceTest {
    private BasePage Invoice;

    @BeforeTest
    public void CreatPages() throws Exception{
        Invoice = new BasePage("Invoice", "ChineseOnlineOld/Invoice.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //发票
    @Test(priority = 1)
    public void Invoice() throws Exception{

        //按钮存在，点击按钮进入
        $(Invoice.byElement("发票-按钮")).should(exist).click();

        //申请开票按钮存在
        $(Invoice.byElement("发票-申请开票按钮存在")).should(exist).shouldHave(text("申请开票"));

        //修改开票信息
        $(Invoice.byElement("发票-修改开票信息")).should(exist).shouldHave(text("修改开票信息"));

        //修改地址信息
        $(Invoice.byElement("发票-修改地址信息")).should(exist).shouldHave(text("修改地址信息"));

    }

}
