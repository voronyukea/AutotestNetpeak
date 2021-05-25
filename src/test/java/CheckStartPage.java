import Pages.Constants;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class CheckStartPage {


    @Before
    public void setup() {
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
    }


    @Test
    public void checkOnPage() {
        //1. Перейти по ссылке на главную страницу сайта Netpeak. (https://netpeak.ua/).
        Constants.openSource("https://netpeak.ua/");
        sleep(2000);

//        2. Перейдите на страницу "Работа в Netpeak", нажав на кнопку "Карьера".
        Constants.openWorkInNetpeak();
        sleep(3000);


//        3. Перейти на страницу заполнения анкеты, нажав кнопку - "Я хочу работать в Netpeak".
        Constants.openWontInNetpeak();
        sleep(3000);

        //П.4. Загрузить файл с недопустимым форматом в блоке "Резюме",
        // например png, и проверить что на странице появилось сообщение,
        //  о том что формат изображения неверный.
        //Не смог реализовать выбор файла, шел по след. пути:

       //1. Хотел сделать видимым html-элемент input для дальнейшего его использования
////      Selenide.executeJavaScript("$(getElementsByClassName('uploaded-file').val('04')");
//      2. Загружал файл с недопустимым расширением.
//        $(".file").uploadFile(new File("src/test/impossible.jpg"));
//      3. При появлении ошибки сверял сожержимое текста.
//        $(By.cssSelector("#up_file_name > label:nth-child(1)")).shouldHave(Condition.text("Ошибка: неверный формат файла (разрешённые форматы: doc, docx, pdf, txt, odt, rtf)."));


//        5. Заполнить случайными данными блок "3. Личные данные".

        Constants.setPrivateData();
        sleep(3000);

//        6. Нажать на кнопку отправить резюме.

       Constants.sendResume();
        sleep(3000);

//        7. Проверить что сообщение на текущей странице - "Все поля являются обязательными для заполнения" - подсветилось красным цветом.


        Constants.checkRedMessage();
        sleep(3000);

//        8. Перейти на страницу "Курсы" нажав соответствующую кнопку в меню и убедиться что открылась нужная страница.

      Constants.navigateToCoursePage();
       sleep(3000);
    }
}