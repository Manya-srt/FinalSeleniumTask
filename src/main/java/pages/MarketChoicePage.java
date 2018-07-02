package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class MarketChoicePage {
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 30);

    public MarketChoicePage(WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//button[@role='listbox']")
    public WebElement listBox;

    @FindBy(xpath = "//span[text()='Показывать по 12']")
    WebElement show12Items;

    @FindBy(xpath = "//a[text()='Перейти ко всем фильтрам']")
    WebElement showFilters;

    @FindBy(xpath = "//input[contains(@name,'pricefrom')]")
    WebElement priceFrom;

    @FindBy(xpath = "//div[contains(@class,'filter-block')]")
    WebElement menu;

    @FindBy(xpath = "//span[contains(text(), 'Показать подходящие')]")
    WebElement showResult;

    @FindBy(xpath = "//div[contains(@class,'n-snippet-list ')]")
    WebElement shopItems;

    @FindBy(xpath = "//span[@class='search2__button']//button[@role='button']")
    WebElement findButton;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchField;

    @FindBy(xpath = "//*[contains(@class,'link n-link_theme_blue')]/ancestor-or-self::div[@class='n-snippet-card2__title']")
    WebElement foundItem;

    @FindBy(xpath = "//*[@value='list'][@type='radio']")
    WebElement listButton;

    public void select12Items() {
                (listBox).click();
                (show12Items).click();
        new Actions(BaseSteps.getDriver()).pause(3000).build().perform();

    }

    public void showAllFilters() {
        wait.until(ExpectedConditions.elementToBeClickable(showFilters)).click();
    }

    public void fillMinPrice(String price) {
        priceFrom.sendKeys(price);
    }

    public void chooseCompany(String name) {
        menu.findElement(By.xpath("//label[contains(text(), '" + name + "')]")).click();
    }

    public void accept() {
        Actions builder = new Actions(BaseSteps.getDriver());
        builder.moveToElement(showResult).click().perform();
        }
    public void setViewList() {
        Actions mouseOver=new Actions(BaseSteps.getDriver());
        mouseOver.moveToElement(listButton).click().perform();
        ExpectedConditions.elementToBeClickable(listButton);
        new Actions(BaseSteps.getDriver()).pause(3000).build().perform();
    }
    public int countShopItems() {
        return shopItems.findElements(By.xpath("//*[contains(@class, 'n-snippet-card2__part_type_center')]")).size();
    }
    public void сompare(Integer countShopItems){
        Assert.assertTrue("Элементов на странице - " + countShopItems + "Ожидалось - 12", countShopItems == 12);
    }
    private String getElement() {
        return shopItems.findElements(By.xpath("//*[contains(@class, 'n-snippet-card2__part_type_center')]")).get(0)
                .findElement(By.xpath(".//div[contains(@class,'n-snippet-card2__title')]/a")).getText();
    }

    public String findFirst() {
        String firstName = getElement();
        searchField.clear();
        searchField.sendKeys(firstName);
        findButton.click();
        return firstName;
    }

    private String foundElement() {
        return foundItem.getText();
    }

    public void comparison(String oldName) {
        String foundName = foundElement();
        Assert.assertTrue(String.format("Ожидаемый товар - [%s]. Найденный товар - [$s]", oldName, foundName), oldName.equals(foundName));
    }

}


