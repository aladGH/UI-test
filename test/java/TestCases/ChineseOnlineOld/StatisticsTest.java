package TestCases.ChineseOnlineOld;

import Object.BasePage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

//数据统计
public class StatisticsTest {

    private BasePage Statistics;
    @BeforeTest
    public void CreatPages() throws Exception{
        Statistics = new BasePage("Statistics", "ChineseOnlineOld/Statistics.xml");
    }
    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test(priority = 1)
    public void Statistics() throws Exception {

        //跳转链接存在
        $(Statistics.byElement("数据统计-按钮")).should(exist).click();

        //用户
        $(Statistics.byElement("数据统计-用户")).should(exist);

        //IM
        $(Statistics.byElement("数据统计-IM")).should(exist);

        //信令
        $(Statistics.byElement("数据统计-信令")).should(exist);

        //G1
        $(Statistics.byElement("数据统计-G1")).should(exist);

        //G2
        $(Statistics.byElement("数据统计-G2")).should(exist);

        //教学白板
        $(Statistics.byElement("数据统计-教学白板")).should(exist);

        //直播
        $(Statistics.byElement("数据统计-直播")).should(exist);

        //点播
        $(Statistics.byElement("数据统计-点播")).should(exist);

        //短信
        $(Statistics.byElement("数据统计-短信")).should(exist);

        //云呼叫中心
        $(Statistics.byElement("数据统计-云呼叫中心")).should(exist);

        //电话
        $(Statistics.byElement("数据统计-电话")).should(exist);

        //号码隐私保护
        $(Statistics.byElement("数据统计-号码隐私保护")).should(exist);
    }

}
