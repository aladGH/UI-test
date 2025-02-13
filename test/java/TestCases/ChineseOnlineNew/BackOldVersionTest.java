package TestCases.ChineseOnlineNew;
import Object.BasePage;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class BackOldVersionTest {

    private BasePage BackOldVersion;
    @BeforeTest
    public void CreatPages() throws Exception{
        BackOldVersion = new BasePage("BackOldVersion", "ChineseOnlineNew/BackOldVersion.xml");
    }
    @Test(priority = 1)
    public void BackOldVersion() throws Exception {
        //新版本引导
        $(byCssSelector("#rc-tabs-0-panel-1 > div > svg > g > g:nth-child(2) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-1 > div > svg > g > g:nth-child(3) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-1 > div > svg > g > g:nth-child(4) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-1 > div > svg > g > g:nth-child(5) > image")).should(exist);
        sleep(500);
        //切换为自助化功能配置介绍
        $(byXpath("//*[@id=\"rc-tabs-0-tab-2\"]/div/div[2]")).should(exist).click();
        $(byCssSelector("#rc-tabs-0-panel-2 > div > svg > g > g:nth-child(2) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-2 > div > svg > g > g:nth-child(3) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-2 > div > svg > g > g:nth-child(4) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-2 > div > svg > g > g:nth-child(5) > image")).should(exist);

        sleep(500);

        //切换为清晰的账单费用介绍
        $(byXpath("//*[@id=\"rc-tabs-0-tab-3\"]/div/div[1]")).should(exist).click();
        $(byCssSelector("#rc-tabs-0-panel-3 > div > svg > g > g:nth-child(2) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-3 > div > svg > g > g:nth-child(3) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-3 > div > svg > g > g:nth-child(4) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-3 > div > svg > g > g:nth-child(5) > image")).should(exist);
        sleep(500);

        //切换为清晰的账单费用介绍
        $(byXpath("//*[@id=\"rc-tabs-0-tab-4\"]/div/div[1]")).should(exist).click();
        $(byCssSelector("#rc-tabs-0-panel-4 > div > svg > g > g:nth-child(2) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-4 > div > svg > g > g:nth-child(3) > image")).should(exist);
        $(byCssSelector("#rc-tabs-0-panel-4 > div > svg > g > g:nth-child(4) > image")).should(exist);
        sleep(500);
        //判断升级文档文案和地址
        $(byXpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/div[1]/a/u")).getText().equals("查看升级文档");
        $(byXpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/div[1]/a/u")).click();
        switchTo().window(1).getCurrentUrl().equals("https://doc.yunxin.163.com/console/docs/Tg4NjM0MjE?platform=console");
        Selenide.closeWindow();
        switchTo().window(0);

        //关闭新版介绍弹窗然后关闭切换提示
        $(byXpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/div[2]/button/span")).should(exist).click();
//        $(byXpath("//*[@id='root-master']/section/main/aside/div/div/button/div/div/div/div/div[2]/div/div[2]/button/span")).should(exist).click();


        $(byCssSelector("#root-master > section > main > aside > div > div > button")).should(exist).shouldHave(text("切换旧版")).click();
    }
}
