import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    void shouldApply() {
        CardDelivery delivery = new CardDelivery();
        Configuration.holdBrowserOpen = true;
        String planningDate = CardDelivery.generateDate(5, "dd.MM.yyyy");
                open("http://localhost:9999/");
        $("[data-test-id='city'] input.input__control").sendKeys("Майкоп");
        $("[data-test-id='date'] input.input__control").doubleClick().sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        $("[data-test-id='date'] input.input__control").sendKeys(planningDate);
        $("[data-test-id='name'] input.input__control").sendKeys("Высоконогая Ирина");
        $("[data-test-id='phone'] input.input__control").sendKeys("+79997773344");
        $(".checkbox_size_m").click();
        $x("//*[contains(text(),'Забронировать')]").click();

        $x("//*[contains(text(),'Успешно!')]").should(appear, Duration.ofSeconds(15));
        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}
