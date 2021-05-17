import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroupStepInJavaTeamTest {

    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void testKirillRazzhigaev() {

        driver.get("https://www.selenium.dev/");
        driver.findElement(By.xpath("//nav/a[3]")).click();
        driver.findElement(By.id("search-by")).sendKeys("element");
        driver.findElement(By.xpath("//div[@data-title=\"Web element\"]")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Web element");
    }

    @Test
    public void testMarianaLuchynets() {

        driver.get("https://www.cvs.com/");
        WebElement checkTestingOptionsButton = driver.findElement(By.xpath("//a[contains(text(),'Check testing options')]"));
        checkTestingOptionsButton.click();
        WebElement updatesFromCdcArrow = driver.findElement(By.xpath("//strong[contains(text(),'Get COVID-19 vaccine updates from the CDC')]"));
        updatesFromCdcArrow.click();
        WebElement possibleSideEffectsListItem = driver.findElement(By.xpath("//a[contains(text(),'Possible side effects')]"));
        possibleSideEffectsListItem.click();
        WebElement possibleSideEffectsText = driver.findElement(By.xpath("//div[contains(text(),'To reduce pain and discomfort where you got the shot')]"));
        Assert.assertEquals(possibleSideEffectsText.getText(), "To reduce pain and discomfort where you got the shot");
    }

    @Test
    public void testVitalyZverev() {

        String value = "Selenium";

        driver.get("https://ya.ru/");

        WebElement input = driver.findElement(By.xpath("//span[@class='input__box']/input"));
        input.sendKeys(value + "\n");

        WebElement result = driver.findElement(By.xpath("//div[contains(@class, 'serp-title_font')]"));

        Assert.assertEquals(result.getText(), value);
    }

    @Test
    public void testAleksAn() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("dresses");
        driver.findElement(By.name("submit_search")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//ul[contains(@class, 'product_list')]/li"));
        Assert.assertEquals(elementList.size(), 7);
    }

    @Test
    public void testVladVysotski() throws InterruptedException {

        driver.get("https://www.paypal.com/");
        driver.manage().window().maximize();
        Thread.sleep(500);

        WebElement button = driver.findElement(By.xpath("//*[@id='signup-button']"));
        button.click();
        Thread.sleep(500);

        String text = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/div/h1")).getText();
        Assert.assertEquals(text, "PayPal is a secure, easy way to pay and get paid - sign up for free");
    }

    @Test
    public void testHaidukLibrary() throws InterruptedException {
        driver.get("https://www.merriam-webster.com/");
        Thread.sleep(10000);
        driver.findElement(By.id("s-term")).sendKeys("anything");
        driver.findElement(By.className("search-icon")).click();
        Assert.assertEquals(driver.findElement(By.className("learn-more-header")).getText(),
                "Learn More about anything");
    }

    @Test
    public void testLarisaMalushkina() throws InterruptedException {

        driver.get("https://marshalls.com/");
        WebElement modalClose = driver.findElement(By.xpath("//*[@id='modal-close']"));
        modalClose.click();
        WebElement inputField = driver.findElement(By.xpath("//input[@id='search-text-input']"));
        inputField.sendKeys("dress");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='search-submit-button']"));
        searchButton.click();
        WebElement result = driver.findElement(By.xpath("//h1[contains(text(),'Dresses')]"));
        Assert.assertEquals(result.getText(), "Dresses");
        Thread.sleep(2000);
    }

    @Test
    public void testEvgeniyaPiskunova() {
        driver.get("https://www.teamunify.com/team/recccvscdhost/page/home");
        driver.findElement(By.xpath("//div[@id='menuBar']//a")).click();
        WebElement searchResult = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back Otters!')]"));
        String searchResultText = searchResult.getText();
        Assert.assertEquals(searchResultText, "Welcome Back Otters!");
    }

    @Test
    public void testVitaliiDmitrenko() {

        driver.get("https://www.gismeteo.ua/weather-kharkiv-5053/");
        WebElement tenDaysButton = driver.findElement(By.xpath("//a[@href='/weather-kharkiv-5053/10-days/']"));
        tenDaysButton.click();

        WebElement tenDaysTitle = driver.findElement(By.xpath("//div[@class='pageinfo_title index-h1']//h1"));
        Assert.assertEquals(tenDaysTitle.getText(), "Погода в Харькове на 10 дней");

        WebElement monthButton = driver.findElement(By.xpath("//a[@href='/weather-kharkiv-5053/month/']"));
        monthButton.click();

        WebElement monthTitle = driver.findElement(By.xpath("//div[@class='pageinfo_title index-h1']//h1"));
        Assert.assertEquals(monthTitle.getText(), "Погода в Харькове на месяц");
    }

    @Test
    public void testNettMax() {
        driver.get("https://www.keyfood.com/");
        WebElement input = driver.findElement(By.className("js-site-search-input"));
        input.sendKeys("meat\n");
        WebElement result = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(result.getText(), "You Searched for \"MEAT\"");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
