import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupBugBustersTest {

        @BeforeClass
        public void before() {
            WebDriverManager.chromedriver().setup();
        }
        private WebDriver driver;

        @BeforeMethod
        public void beforeTest() {
            driver = new ChromeDriver();
        }

        @Test
        public void ludaPetkelTest() {

            driver.get("https://www.flooringliquidators.ca/");
            driver.findElement(By.linkText("About")).click();
            WebElement result = driver.findElement(By.xpath("//strong[.='About Us']"));
            Assert.assertTrue(result.isDisplayed());
            WebElement phone = driver.findElement(By.className("show-phones"));
            Assert.assertEquals(phone.getText(), "1 (866) 473-7222");

        }

        @Test

        public void AndreyTeterinTest() throws InterruptedException {
            driver.get("https://www.btcsatoshi.com/");
            Thread.sleep(3000);
            WebElement price = driver.findElement(By.xpath("//label[@id='oneBitcoin']"));
            Assert.assertEquals(price.getText(), driver.getTitle().substring(1, 9));
            Thread.sleep(3000);
        }

        public void mikhailMirTest() throws InterruptedException {

            driver.get("https://www.wasserstrom.com/");
            String parentHandle = driver.getWindowHandle();
            driver.findElement(By.id("Header_GlobalLogin_signInQuickLink")).click();

            for(String childHandle : driver.getWindowHandles()){
                if (!childHandle.equals(parentHandle)){
                    driver.switchTo().window(childHandle);
                    break;
                }
            }

            Thread.sleep(1000);
            driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1")).sendKeys("userWasserStrom");
            driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")).sendKeys("WasserStrom4321!");
            driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_rememberMe_In_Logon_1_img")).click();
            driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_links_2")).click();
            Thread.sleep(5000);

            WebElement iconUser = driver.findElement(By.id("Header_GlobalLogin_signOutQuickLink"));
            Assert.assertTrue(iconUser.isDisplayed());

        }

        @AfterMethod
        public void afterTest() {
            driver.quit();
        }
}
