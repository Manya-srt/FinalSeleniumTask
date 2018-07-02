package steps;

import Pages.MarketChoicePage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketChoicePageSteps {
    private String firstSearchName;

    @Step("выбрано отображение 12 результатов")
    public void select12Items() {
        new MarketChoicePage(BaseSteps.getDriver()).select12Items();
    }
    @Step("произведен переход в расширенный поиск")
    public void showAllFilters() {
        new MarketChoicePage(BaseSteps.getDriver()).showAllFilters();
    }

    @Step("указываем минимальную цену \"{0}\" ")
    public void setMinPrice(String price){
        new MarketChoicePage(BaseSteps.getDriver()).fillMinPrice(price);
    }

    @Step("выбираем в фильтре производителя \"{0}\" ")
    public void setCompany(String name){
        new MarketChoicePage(BaseSteps.getDriver()).chooseCompany(name);
    }

    @Step("нажимаем кнопку применить")
    public void acceptFilter(){
        new MarketChoicePage(BaseSteps.getDriver()).accept();
    }

    @Step("выбираем отображение в виде списка")
    public void makeViewList(){
        new MarketChoicePage(BaseSteps.getDriver()).setViewList();
    }
    @Step("проверяем кол-во выводимых результатов")
    public void compareResults()
    {
        new MarketChoicePage(BaseSteps.getDriver()).сompare(new MarketChoicePage(BaseSteps.getDriver()).countShopItems());
    }

    @Step("Находим первый товар")
    public void stepFindFirst() {
        firstSearchName = new MarketChoicePage(BaseSteps.getDriver()).findFirst();
    }

    @Step("Проверяем работу поиска")
    public void CheckFirst() {
        new MarketChoicePage(BaseSteps.getDriver()).comparison(firstSearchName);
    }
}



