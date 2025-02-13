package TestCases.ChineseOnlineOld;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

//服务监控平台
public class ServiceMonitoringPlatformTest {

    private BasePage ServiceMonitoringPlatform;
    @BeforeTest
    public void CreatPages() throws Exception{
        ServiceMonitoringPlatform = new BasePage("ServiceMonitoringPlatform", "ChineseOnlineOld/ServiceMonitoringPlatform.xml");
    }
    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test(priority = 1)
    public void ServiceMonitoringPlatform() throws Exception {

        //点击进入QS
        $(ServiceMonitoringPlatform.byElement("服务监控平台-按钮")).should(exist).click();
        sleep(3000);
    }

}
