package TestCases;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Configuration;

import org.testng.annotations.Test;

public class LoginPageTest {

    //登录页可以切换登录方式
    @Test
    public void SwitchLoginMethod() {
        Configuration.browser = "chrome";
        open("https://apptest.netease.im");
        //判断登录切换按钮是否存在
        //$(byXpath("//*[@id=\"bg\"]/div[2]/div/div/div/div/div[2]/div/div[2]")).should(exist);
        $(byXpath("/html/body/div/div/div/div[2]/div/div/div/div/div[2]/div/div[2]")).should(exist);
    }

    //登录页元素是否存在的判断
    @Test
    public void LoginPageElement() {
        Configuration.browser = "chrome";
        open("https://apptest.netease.im");
        //点击登录切换按钮
        $(byXpath("//*[@id=\"bg\"]/div[2]/div/div/div/div/div[2]/div/div[2]")).should(exist).click();

        //注册按钮
        $(byXpath("//*[@id=\"bg\"]/div[2]/div/div/div/div/div/form/div[7]/div[1]/a")).should(exist);
        //切换子账号按钮
        $(byXpath("//*[@id=\"bg\"]/div[2]/div/div/div/div/div[2]/form/div[5]/div[3]/a")).should(exist);
        //忘记密码
        $(byXpath("//*[@id=\"bg\"]/div[2]/div/div/div/div/div[2]/form/div[7]/div[2]/a")).should(exist);
    }

}
