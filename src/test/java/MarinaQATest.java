import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class MarinaQATest extends Utility{

    @Test
    public void testMarinaQA() throws InterruptedException {

        driver.get("https://us.etrade.com/");

        WebElement logOnMenuLink = driver.findElement(
                By.xpath("//div[@class='nav-desktop']/div/div/a[@aria-label='log on to etrade']"));
        logOnMenuLink.click();
        Thread.sleep(2000);

        WebElement userIDField = driver.findElement(By.xpath("//input[@id='user_orig']"));
        userIDField.sendKeys("Tester1");

        WebElement passWordField = driver.findElement(By.xpath("//div[@class='row']/div/div/input[@type='password']"));
        passWordField.sendKeys("Privet!");

        WebElement logOnField = driver.findElement(By.xpath("//button[@id='logon_button']"));
        logOnField.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='row']/div[@class='col-centered-4']/div[@class='universal-message universal-message-danger']"));
        System.out.println(errorMessage.getText());

        Assert.assertEquals(errorMessage.getText(), "Sorry! We're having trouble logging you on right now.\n" +
                "Please call 800-ETRADE-1 (800-387-2331) and mention status code 942 and IP:174.48.146.238.");
    }
}
