package TestCases;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePopupTest {

    //登录用户后台并关闭弹窗
    @Test
    public void Popup(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wb.anliao01\\.cache\\selenium\\chromedriver\\win64\\118.0.5993.70\\chromedriver.exe");

        Configuration.browser = "chrome";

        //executeJavaScript("window.open('your URL', '_blank');");
        open("https://id-auto.netease.im/external/page/autologinbyproduct");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[1]/input")).setValue("16531765267");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[2]/input")).setValue("w123456");
        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/div[4]/input")).setValue("media");

        $(byXpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div[2]/button")).click();
        sleep(2000);

        //executeJavaScript("window.open('https://apptest.netease.im', '_blank');");
        open("https://apptest.netease.im");
        sleep(9000);

        //打开新标签页后一定要切换，不然进程还停留在前一个标签页
        //switchTo().window(1);

        //关闭反垃圾弹窗
        $(byXpath("//*[@id=\"modal_bd\"]/div/h3")).shouldBe(text("具有安全属性的云信能力产品"));
        $(byXpath("//*[@id=\"app\"]/div[4]/div/div[2]/a/i")).should(exist).click();

        //关闭子账号弹窗
        $(byXpath("//*[@id=\"app\"]/div[3]/div/div[2]/h3")).shouldBe(text("云信控制台子账号及权限管理上线啦"));
        $(byXpath("//*[@id=\"app\"]/div[3]/div/div[2]/a")).should(exist).click();
    }
}
