package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.MainScreen;
import screens.ResultScreen;
import screens.SearchScreen;
import screens.components.OnboardingScreenComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


@Tag("Mobile")

public class LocalTests extends TestBase {
    OnboardingScreenComponent onboardingScreenComponent = new OnboardingScreenComponent();
    MainScreen mainScreen = new MainScreen();
    SearchScreen searchScreen = new SearchScreen();
    ResultScreen resultScreen = new ResultScreen();

    @Test
    @DisplayName("Проверка онбординг-экранов")
    @Owner("Тётушкин К.И.")
    void onBoardingPagesTest() {


        step("Первый экран", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Второй экран", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Третий экран", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Четвертый экран", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Data & Privacy"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
    }

    @Test
    @DisplayName("Проверка размера поисковой выдачи")
    @Owner("Тётушкин К.И.")
    void openArticleTest() {
        onboardingScreenComponent.closeOnboardingScreen();
        mainScreen.searchLineClick();
        searchScreen.searchLineSendKeys("Appium");
        resultScreen.checkSizeResult(0);

    }


    @Test
    @DisplayName("Соответствие поисковой выдачи запросу")
    @Owner("Тётушкин К.И.")
    void searchPageTest() {
        onboardingScreenComponent.closeOnboardingScreen();
        mainScreen.searchLineClick();
        searchScreen.searchLineSendKeys("Riesling");
        resultScreen.checkResult("Riesling");


    }
}

