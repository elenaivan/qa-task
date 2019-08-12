package test;

import org.junit.Test;
import pages.MainPage;

public class FirstTest {

    @Test
    public void display() {
        System.out.println("Hello world. This is Elena here");

        MainPage mp = new MainPage();
        mp.openMainPage("http://xing.com");

        mp.closeBrowser();
    }
}
