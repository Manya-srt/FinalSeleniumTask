package steps;

import Pages.MarketPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketPageSteps {

    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 30);
    MarketPage marketPage = new MarketPage(BaseSteps.getDriver());

    @Step("ожидаем загрузки страницы и проверяем заголовок")
    public void waitToLoadAndCheckTitle() {
        wait.until(ExpectedConditions.visibilityOf(marketPage.ExpectedHeader));
        String title = BaseSteps.getDriver().getTitle();
        Assert.assertTrue("Получен заголовок - " + title + "Ожидалось - Яндекс Маркет", title.contains("Маркет"));
    }
    @Step("Выбран раздел \"{0}\" и подраздел \"{0}\"")
    public void stepSelectMainMenu(String menuItem, String submenuitem) {
        new MarketPage(BaseSteps.getDriver()).selectMenu(menuItem, submenuitem);
    }
    @Step("Выбор города \"{0}\"")
    public void selectCity() {
        marketPage.disableWindow();
    }



}


