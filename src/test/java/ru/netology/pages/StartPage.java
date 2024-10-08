package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.netology.testUtils.Cards;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StartPage {

    protected String host = System.getProperty("test.host");
    protected SelenideElement header = $(By.cssSelector("h3"));
    protected SelenideElement payButton = $(byText("Купить")).parent().parent();
    protected SelenideElement creditButton = $(byText("Купить в кредит")).parent().parent();
    protected SelenideElement continueButton = $(byText("Продолжить")).parent().parent();
    protected SelenideElement cardNumberField = $(byText("Номер карты")).parent().parent();
    protected SelenideElement monthField = $(byText("Месяц")).parent().parent();
    protected SelenideElement yearField = $(byText("Год")).parent().parent();
    protected SelenideElement ownerField = $(byText("Владелец")).parent().parent();
    protected SelenideElement cvcField = $(byText("CVC/CVV")).parent().parent();
    protected SelenideElement notificationApproved = $(".notification_status_ok ");
    protected SelenideElement notificationDeclined = $(".notification_status_error");

    public StartPage() {
        open(host);
        header.shouldBe(visible);
        payButton.click();
    }

    public void inputData(Cards card) {
        cardNumberField.$(".input__control").setValue(card.getNumber());
        monthField.$(".input__control").setValue(card.getMonth());
        yearField.$(".input__control").setValue(card.getYear());
        ownerField.$(".input__control").setValue(card.getCardholder());
        cvcField.$(".input__control").setValue(card.getCvc());
    }

    public void cleanNumberAndInputNewData(String data) {
        cardNumberField.$(".input__control").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        cardNumberField.$(".input__control").setValue(data);
    }

    public void cleanMonthAndInputNewData(String data) {
        monthField.$(".input__control").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        monthField.$(".input__control").setValue(data);
    }

    public void cleanYearAndInputNewData(String data) {
        yearField.$(".input__control").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        yearField.$(".input__control").setValue(data);
    }

    public void cleanOwnerAndInputNewData(String data) {
        ownerField.$(".input__control").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        ownerField.$(".input__control").setValue(data);
    }

    public void cleanCvcAndInputNewData(String data) {
        cvcField.$(".input__control").sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        cvcField.$(".input__control").setValue(data);
    }

    public static StartPage payButtonClick() {
        StartPage payPage = page(StartPage.class);
        payPage.payButton.click();
        return payPage;
    }

    public static StartPage creditPayButtonClick() {
        StartPage creditPayPage = page(StartPage.class);
        creditPayPage.creditButton.click();
        return creditPayPage;
    }

    public void continueButtonClick() {
        continueButton.click();
    }

    public void checkNotificationApprovedVisible() {
        notificationApproved.shouldBe(visible, Duration.ofMillis(15000));
    }

    public void checkNotificationDeclinedNotVisible() {
        notificationDeclined.shouldBe(hidden, Duration.ofMillis(15000));
    }

    public void checkNotificationDeclinedVisible() {
        notificationApproved.shouldBe(visible, Duration.ofMillis(15000));
    }

    public void checkNotificationApprovedNotVisible() {
        notificationDeclined.shouldBe(hidden, Duration.ofMillis(15000));
    }

    public void checkCardNumberFormatErrorHave() {
        cardNumberField.$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    public void checkCardNumberFormatErrorNotHave() {
        cardNumberField.$(".input__sub").shouldNotHave(Condition.exactText("Неверный формат"));
    }

    public void checkMonthFormatErrorHave() {
        monthField.$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    public void checkMonthFormatErrorNotHave() {
        monthField.$(".input__sub").shouldNotHave(Condition.exactText("Неверный формат"));
    }

    public void checkMonthDateErrorHave() {
        monthField.$(".input__sub").shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void checkMonthDateErrorNotHave() {
        monthField.$(".input__sub").shouldNotHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void checkYearErrorHave() {
        yearField.$(".input__sub").shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void checkDateErrorHave() {
        $(".input__sub").shouldHave(Condition.exactText("Истёк срок действия карты"));
    }

    public void checkYearFormatErrorHave() {
        yearField.$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    public void checkYearFormatErrorNotHave() {
        yearField.$(".input__sub").shouldNotHave(Condition.exactText("Неверный формат"));
    }

    public void checkOwnerErrorHave() {
        ownerField.$(".input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void checkOwnerErrorNotHave() {
        ownerField.$(".input__sub").shouldNotHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void checkOwnerFormatErrorHave() {
        ownerField.$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    public void checkOwnerFormatErrorNotHave() {
        ownerField.$(".input__sub").shouldNotHave(Condition.exactText("Неверный формат"));
    }

    public void checkCvcErrorHave() {
        cvcField.$(".input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    public void checkCvcErrorNotHave() {
        cvcField.$(".input__sub").shouldNotHave(Condition.exactText("Неверный формат"));
    }

}