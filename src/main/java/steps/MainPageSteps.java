package steps;
import Pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {
    @Step("Выбран раздел \"{0}\"")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

}
