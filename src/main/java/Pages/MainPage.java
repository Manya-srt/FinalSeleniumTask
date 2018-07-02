package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;


public class MainPage {
    @FindBy(xpath = "//a[contains(@class,'home-tabs__search')]")
    WebElement mainMenu;

    @FindBy(xpath = "//a[contains(@class,'home-tabs__search')]")
    WebElement subMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath("//a[contains(text(), '" + menuItem + "')]")).click();
    }

    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath("//a[text()='" + menuItem + "']")).click();
    }
}
