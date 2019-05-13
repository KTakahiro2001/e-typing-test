import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TypingThread implements Runnable{

    private WebDriver webDriver;

    TypingThread() {
        this.webDriver = new ChromeDriver();
    }

    @Override
    public void run() {
        try {
            webDriver.get("https://www.e-typing.ne.jp/");
            webDriver.findElement(By.id("level_check_btn")).click();
            Thread.sleep(500);
            webDriver.findElement(By.id("level_check_btn")).click();
            Thread.sleep(500);
            webDriver.switchTo().frame(webDriver.findElement(By.id("typing_content")));
            webDriver.findElement(By.id("start_btn")).click();
            WebElement body = webDriver.findElement(By.tagName("body"));
            Thread.sleep(1000);
            body.sendKeys(" ");
            Thread.sleep(3500);
            for (int i = 0; i < 15; ++i) {
                String sentence = webDriver.findElement(By.id("sentenceText")).getText();
                for (int j = 0, k = sentence.length() ; j < k; ++j) {
                    body.sendKeys(String.valueOf(sentence.charAt(j)));
                    Thread.sleep(0, 500);
                }
                Thread.sleep(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webDriver.quit();
        }
    }
}
