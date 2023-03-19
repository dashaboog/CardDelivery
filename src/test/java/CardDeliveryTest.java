import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    void shouldApply() {
        Configuration.holdBrowserOpen = true;
                open("http://localhost:9999/");
        $("[data-test-id='city'] input.input__control").sendKeys("Майкоп");
        $("[data-test-id='date'] input.input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        String meetingDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id='date'] input.input__control").sendKeys(meetingDate);
        $("[data-test-id='name'] input.input__control").sendKeys("Высоконогая Ирина");
        $("[data-test-id='phone'] input.input__control").sendKeys("+79997773344");
        $(".checkbox_size_m").click();
        $x("//*[contains(text(),'Забронировать')]").click();

        $x("//*[contains(text(),'Успешно!')]").should(appear, Duration.ofSeconds(15));
    }
}
