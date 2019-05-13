public class Main {
    public static void main(String... args) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        new Thread(new TypingThread()).start();
    }
}
