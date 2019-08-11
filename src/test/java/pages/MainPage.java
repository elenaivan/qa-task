package pages;

public class MainPage extends BaseClass{

    public void openMainPage(String url) {
        driver.get(url);
    }

    public void quitTest() {
        driver.quit();
    }

}
