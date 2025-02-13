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

public class CouponTest {
    private BasePage Coupon;

    @BeforeTest
    public void CreatPages() throws Exception{
        Coupon = new BasePage("Coupon", "ChineseOnlineOld/Coupon.xml");
    }

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    //代金券
    @Test(priority = 1)
    public void Coupon() throws Exception{

        //按钮存在
        $(Coupon.byElement("代金券-按钮")).should(exist).click();
    }

}
