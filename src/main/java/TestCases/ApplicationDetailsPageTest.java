package TestCases;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ApplicationDetailsPageTest {

    @BeforeTest
    public void Login() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;

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

        //关闭反垃圾弹窗
        $(byXpath("//*[@id=\"app\"]/div[4]/div/div[2]/a/i")).should(exist).click();

        //关闭子账号弹窗
        $(byXpath("//*[@id=\"app\"]/div[3]/div/div[2]/a")).should(exist).click();

        //打开应用详情页面
        open("http://apptest.netease.im/index#/app/146287295");
    }

    //IM
    @Test
    public void IM() {

        //易盾入口
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[1]/div[2]/a[1]")).should(exist);

        //API调试入口
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[1]/div[2]/a[2]")).should(exist);

        //功能配置
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[1]/div[2]/a[3]")).should(exist);

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[1]/div[2]/a[4]")).should(exist);
    }

    //G1
    @Test
    public void Netcall1() {

        //功能配置
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[3]/div[2]/a[1]")).should(exist);

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[3]/div[2]/a[2]")).should(exist);
    }
    //G2
    @Test
    public void Netcall2() {

        //安全通
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[4]/div[2]/a[1]")).should(exist);

        //功能配置
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[4]/div[2]/a[2]")).should(exist);

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[4]/div[2]/a[3]")).should(exist);
    }

    //直播
    @Test
    public void Live() {

        //安全通
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[5]/div[2]/a[1]")).should(exist);

        //域名管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[5]/div[2]/a[2]")).should(exist);

        //直播管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[5]/div[2]/a[3]")).should(exist);

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[5]/div[2]/a[4]")).should(exist);
    }

    //点播
    @Test
    public void Vod() {

        //安全通
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[1]")).should(exist);

        //域名管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[2]")).should(exist);

        //文件管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[3]")).should(exist);

        //转码
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[4]")).should(exist);

        //水印
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[5]")).should(exist);

        //分类
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[6]")).should(exist);

        //上传
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[7]")).should(exist);

        //短视频
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[8]")).should(exist);

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[8]/div[2]/a[9]")).should(exist);
    }
    //互动直播1.0
    @Test
    public void InteractiveNetcall1() {

        //功能配置
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[6]/div[2]/a[1]")).should(exist);

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[6]/div[2]/a[2]")).should(exist);
    }

    //互动直播2.0
    @Test
    public void InteractiveNetcall2() {

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[7]/div[2]/a")).should(exist);
    }

    //教学白板
    @Test
    public void EducationWhiteboard() {

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[9]/div[2]/a")).should(exist);

    }

    //短信
    @Test
    public void SMS() {

        //已开通功能
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[11]/div[2]/a[1]")).should(exist);

        //短信模板管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[11]/div[2]/a[2]")).should(exist);

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[11]/div[2]/a[3]")).should(exist);
    }

    //专线电话
    @Test
    public void DedicatedTelephone() {

        //开发手册
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[11]/div[2]/a")).should(exist);
    }

    //隐私号码保护
    @Test
    public void SmallPhone() {

        //小号管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[9]/div[2]/a")).should(exist);
    }

    //5G消息
    @Test
    public void RCS5GSMS() {

        //素材管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[13]/div[2]/a[1]")).should(exist);

        //模板管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[13]/div[2]/a[2]")).should(exist);

        //消息管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[13]/div[2]/a[3]")).should(exist);

        //回复管理
        $(byXpath("//*[@id=\"app\"]/div[1]/div/div/div/ul/li[13]/div[2]/a[4]")).should(exist);
    }

}
