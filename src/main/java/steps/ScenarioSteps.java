package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    MarketPageSteps marketPageSteps = new MarketPageSteps();
    MarketChoicePageSteps marketChoicePageSteps = new MarketChoicePageSteps();

    @When("^выбран пункт меню \"([^\"]*)\"$")
    public void SelectMainMenu(String menuItem) {
        mainPageSteps.stepSelectMainMenu(menuItem);
    }
    @When("^пользователь находится на странице Яндекс Маркета$")
    public void пользователь_находится_на_странице_Яндекс_Маркета()  {
        marketPageSteps.waitToLoadAndCheckTitle();
    }
    @Then("^выбран город$")
    public void SelectCity()  {
        marketPageSteps.selectCity();
    }
    @When("^выбран раздел в Маркете \"([^\"]*)\" \"([^\"]*)\"$")
    public void SelectSubMenu(String menuItem, String submenuitem)  {
        marketPageSteps.stepSelectMainMenu(menuItem, submenuitem);
    }
    @Then("^выбрано количество элементов товара 12$")
    public void SelectItems() {
        marketChoicePageSteps.select12Items();
    }
    @When("^выбрано отображение в виде списка$")
    public void MakeViewList()  {
        marketChoicePageSteps.makeViewList();
    }
    @When("^произведен переход в расширенный поиск$")
    public void ShowAllFilters()  {
        marketChoicePageSteps.showAllFilters();
    }
    @Then("^указана минимальная цена \"([^\"]*)\"$")
    public void SelectMinPrice(String price) {
        marketChoicePageSteps.setMinPrice(price);
    }
    @When("^выбран производитель \"([^\"]*)\"$")
    public void SelectCompany(String name) {
        marketChoicePageSteps.setCompany(name);
    }
    @When("^нажата кнопка Показать подходящие$")
    public void AcceptFilter()  {
        marketChoicePageSteps.acceptFilter();
    }
    @Then("^проверено количество выводимых результатов$")
    public void CompareResults(){
        marketChoicePageSteps.compareResults();
    }
    @When("^найден первый товар$")
    public  void SelectFirstItem() {
        marketChoicePageSteps.stepFindFirst();
    }
    @Then("^проверена работа поиска$")
    public void CheckFilter()  {
        marketChoicePageSteps.CheckFirst();
    }
  }
