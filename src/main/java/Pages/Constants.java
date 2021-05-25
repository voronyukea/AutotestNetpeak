package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Constants {

    public static void openSource(String URL) {
        open(URL);

    }

    public static void openWorkInNetpeak() {
        $(By.cssSelector("li.main-link:nth-child(4) > a:nth-child(1)")).click();
        switchTo().window(1);
    }

    public static void openWontInNetpeak() {
        $(By.xpath("//a[@class='btn green-btn']")).click();
    }


    public static void setPrivateData() {

        $(By.xpath("//input[@id='inputName']")).setValue("FirstName");
        $(By.xpath("//input[@id='inputLastname']")).setValue("Lastname");
        $(By.xpath("//input[@id='inputEmail']")).setValue("mailemail@gmail.com");

        $(By.xpath("//select[@data-error-name='Birth year']")).click();
        $(By.xpath("//option[@value='2000']")).click();
        $(By.xpath("//select[@data-error-name='Birth year']")).click();

        $(By.xpath("//select[@data-error-name='Birth month']")).click();
        $(By.xpath("//option[@value='03']")).click();
        $(By.xpath("//select[@data-error-name='Birth month']")).click();

        $(By.xpath("//select[@data-error-name='Birth day']")).click();
        $(By.xpath("//option[@value='28']")).click();
        $(By.xpath("//select[@data-error-name='Birth day']")).click();
        $(By.xpath("//input[@id='inputPhone']")).setValue("+38009999999");
    }

    public static void sendResume() {
        $(By.xpath("//button[@id='submit']")).click();
    }

    public static void checkRedMessage() {
        String colorAlert = $(By.xpath("//p[@class='warning-fields help-block']")).getCssValue("color");
        assert colorAlert.equals("rgba(255, 0, 0, 1)");

    }

    public static void navigateToCoursePage() {
        $(By.xpath("//a[@href='https://school.netpeak.group/']")).click();
        String currentUrl = com.codeborne.selenide.WebDriverRunner.currentFrameUrl();
        assert currentUrl.equals("https://school.netpeak.group/");
        //Проверка что assert отработал корректно на последнем шаге
        $(By.xpath("//a[@href='//netpeak.group/']")).click();
    }






}
