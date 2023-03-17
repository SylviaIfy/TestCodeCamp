import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**1. Verify the user input the right url and his on the right webpage*
*2. Verify that when user clicks on the signup button, the user is directed to thesignup page
 * 3. Verify that user cannot signup with username less than 3 characters
 * 4. Verify user cannot signup with invalid email address
 * 5. Verify user cannot login with password less than or equal to one character
 * 6. Verify user cannot signup with either/all of the fields blank
 * 7. Verify that user is successfully signed up when valid details are inputted.
 * 8. Verify that User1 item is present on the item list page.
 * 9. Verify that the item searched for on the User1 page is present - changed to user1 url is present
 * 10. Verify that when the user logout, he/she is directed back to the home page
 **/

public class SeleniumWebSignupTest {

    //Import the Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the Edge driver is
        System.setProperty("WebDriver.Edge.driver", "Resources/msedgedriver.exe");
        //1. Open your Edge browser
        driver = new EdgeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
    // Test1 Verify the user inputs the right url and is on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
        //Pass sequence
            System.out.println("Correct Webpage");
        else
        //Fail sequence
        System.out.println("Wrong Webpage");
        //add a delay after activating page opening, to ensure the page loads well
        Thread.sleep(7000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on the Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

    //Test 2 - Verify that when user clicks on the signup button, the user is directed to thesignup page
        String expectedurl = "https://selenium-blog.herokuapp.com/signup";
        String actualurl = driver.getCurrentUrl();
        if (actualurl.contains(expectedurl))
            //Pass sequence
            System.out.println("Correct Webpage");
        else
            //Fail sequence
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void Positivesignup() throws InterruptedException {
    //Test 7 - Verify that user is successfully signed up when valid details are inputted
        //5. Input your Username on the Username field
        driver.findElement(By.id("user_username")).sendKeys("QueenSyl11");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("queensyl11@mailinator.com");
        //7. Locate the Password field and input your Password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
                Thread.sleep(10000);
    }
    @Test (priority = 1)
    public void clickuseritem1() throws InterruptedException {
      //9. Click on the user "meagan" item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
    //Test 8 - Verify that User1 item is present on the item list page - can use same test above, by checking that the clicking directs us to the for the user's url
        String expectedUser1url = "https://selenium-blog.herokuapp.com/users/1";
        String actualUser1url = driver.getCurrentUrl();
        if (actualUser1url.contains(expectedUser1url))
            //Pass sequence
            System.out.println("Correct - User1 Present");
        else
            //Fail sequence
            System.out.println("Wrong - User1 Absent");
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyitem() throws InterruptedException {
// Test 9 - Verify that the item searched for on the User1 page is on the right pageurl.
        //10. Search for an item (Using Python with Selenium) and confirm if it is present
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        String expectedPageurl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageurl = driver.getCurrentUrl();
        if (actualPageurl.contains(expectedPageurl))
            //Pass sequence
            System.out.println("Correct User1Page");
        else
            //Fail sequence
            System.out.println("Wrong User1Page");
        Thread.sleep(5000);
    }

        @Test (priority = 3)
        public void logoutSuccessfully(){
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    // Test 10 - Verify that when the user logout, he/she is directed back to the home page, by looking for the home page title - homepageUrl can also be used
        String expectedPagetitle = "AlphaBlog";
        String actualPagetitle = driver.getTitle();
        if (expectedPagetitle.contains(actualPagetitle))
            //Pass sequence
            System.out.println("Correct WebHomePage");
        else
            //Fail sequence
            System.out.println("Wrong WebHomePage");

    }
    @Test (priority = 4)
    public void Negativesignup1() throws InterruptedException {
        //Test 3 - Verify that user cannot signup with username less than 3 characters

        //4. Click on the Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();

        //5. Input your Username on the Username field
        driver.findElement(By.id("user_username")).sendKeys("Qu");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("queensyl01@mailinator.com");
        //7. Locate the Password field and input your Password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 5)
    public void Negativesignup2() throws InterruptedException {
        //Test 4 - Verify user cannot signup with invalid email address

        //5. Input your Username on the Username field
        driver.findElement(By.id("user_username")).sendKeys("QueenSyl02");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("queensyl01@mailtor.o");
        //7. Locate the Password field and input your Password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 6)
    public void Negativesignup3() throws InterruptedException {
        //Test 5 - Verify user cannot login with password less than or equal to one character

        //5. Input your Username on the Username field
        driver.findElement(By.id("user_username")).sendKeys("QueenSyl03");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("queensyl03@mailinator.com");
        //7. Locate the Password field and input your Password on the password field
        driver.findElement(By.id("user_password")).sendKeys("a");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 7)
    public void Negativesignup4() throws InterruptedException {
        //Test 6 - Verify user cannot signup with either/all of the fields blank

        //5. Input your Username on the Username field
        driver.findElement(By.id("user_username")).sendKeys("QueenSyl03");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //7. Locate the Password field and input your Password on the password field
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }
    @AfterTest
    public void closebrowser(){
        //12. Quit the browser
        driver.quit();
    }
}
