import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void CardTest() {
        $("[data-test-id=city] input").setValue("Иркутск");
        $("[data-test-id=name] input").setValue("Иванович Иван");
        $("[data-test-id=phone] input").setValue("+73215646546");
        $("[data-test-id=agreement]").click();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now().plusDays(5);
        Date date = java.sql.Date.valueOf(currentDate);
        String result = formatter.format(date);
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(result);
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }

/*    @Test
    void actionComplexTest() {
        $("[data-test-id=city] input").setValue("Мо");
        $$(".menu-item__control").find(exactText("Москва")).click();
        $("[data-test-id=name] input").setValue("Иванович Иван");
        $("[data-test-id=phone] input").setValue("+73215646546");
        $("[data-test-id=agreement]").click();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(currentDate);
        long realtime = date.getTime() + 604800000;
        String number = String.valueOf(realtime);
        $("[data-test-id=date] input").doubleClick();
        $x("[data-day]").shouldBe(exactValue(number)).click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));

        >fail
    }*/
}

