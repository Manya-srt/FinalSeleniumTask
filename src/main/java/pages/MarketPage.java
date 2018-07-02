package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.Set;

public class MarketPage {

    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 30);
    public MarketPage(WebDriver driver) {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


    @FindBy(xpath ="//span[contains(text(),'Маркет')]")
    public WebElement ExpectedHeader;

    @FindBy(xpath = "//span[contains(@class, 'ok')]/parent::div")
    public WebElement annoyingStuff;

    @FindBy(xpath = "//a[contains(@class,'link topmenu__link')]")
    WebElement mainMenu;

    public void disableWindow(){
        Actions builder = new Actions(BaseSteps.getDriver());
        builder.moveToElement(annoyingStuff).click().perform();
    }

    public void selectMenu(String menuItem, String submenuitem) {
        Actions builder = new Actions(BaseSteps.getDriver());
        builder.moveToElement(mainMenu.findElement(By.xpath("//a[contains(text(), '" + menuItem + "')]"))).build().perform();
        Set<String> oldWindowsSet = BaseSteps.getDriver().getWindowHandles();
        wait.until(ExpectedConditions.elementToBeClickable(mainMenu.findElement(By.xpath("//A[text()='" + submenuitem + "']")))).click();
        Set<String> newWindowsSet = BaseSteps.getDriver().getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        if (newWindowsSet.iterator().hasNext()) {
            String newWindowHandle = newWindowsSet.iterator().next();
            BaseSteps.getDriver().switchTo().window(newWindowHandle);
    }}

}


