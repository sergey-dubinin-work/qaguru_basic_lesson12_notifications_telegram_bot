package guru.qa.demoqa.helpers;

import com.codeborne.selenide.Configuration;

import static guru.qa.demoqa.config.ConfigurationManager.getSelenoidConfig;
import static guru.qa.demoqa.config.ConfigurationManager.getWebDriverConfig;

public class DriverSettings {

    public static void configure(){

        Browser browser =  Browser.valueOf(getWebDriverConfig().webBrowser().toUpperCase());

        Configuration.browser = browser.getBrowserName();

        if (getSelenoidConfig().selenoidUrl() != null){
            Configuration.remote = String.format(
                    "%s:%s/wd/hub",
                    getSelenoidConfig().selenoidUrl(),
                    getSelenoidConfig().selenoidPort()
            );

            browser.setupBrowserSelenoidOptions();
        } else {
           browser.setupBrowserManager();
        }

    }

}
