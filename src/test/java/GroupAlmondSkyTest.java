import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupAlmondSkyTest extends Utility {

    @Test
    public void testTatianaChueva() throws InterruptedException {

        final String expectedResultPageHeader = "CONTACT US";

        driver.get("https://www.loganparkapartments.com/");

        WebElement popButtonClose = driver.findElement(By.xpath("//a[@id='popBtnClose']"));
        popButtonClose.click();

        WebElement pushMenu = driver.findElement(By.xpath("//div[@id='menuHeader']"));
        pushMenu.click();
        Thread.sleep(3000);

        WebElement inputContactButton = driver.findElement(
                By.xpath("//div[@id='mainNavHeader']/ul[@id='menuElem']/li[@class='contact']/a[@href='/Contact.aspx']"));
        inputContactButton.click();

        WebElement pageHeader = driver.findElement(By.xpath("//h1[@class='pageHeader']"));
        String actualResultPageHeader = pageHeader.getText();

        Assert.assertEquals(actualResultPageHeader, expectedResultPageHeader);
    }

    @Test
    public void testLizaSh() {
        driver.get("https://www.cactusandtropicals.com/");

        WebElement button = driver.findElement(By.xpath("//a[text()='View our services.']"));
        button.click();

        WebElement result = driver.findElement(By.className("page-title"));

        Assert.assertEquals(result.getText(), "PLANT SERVICES");
    }
}
