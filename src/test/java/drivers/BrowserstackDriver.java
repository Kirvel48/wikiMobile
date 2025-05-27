package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserstackDriver implements WebDriverProvider {
    protected static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", browserstackConfig.getUsername());
        bstackOptions.put("accessKey", browserstackConfig.getAuthkey());
        bstackOptions.put("projectName", "My Project");
        bstackOptions.put("buildName", "Build 1");
        bstackOptions.put("sessionName", "Test Session");

        caps.setCapability("app", browserstackConfig.getApp());
        caps.setCapability("deviceName", browserstackConfig.getDevice());
        caps.setCapability("osVersion", browserstackConfig.getPlatformVersion());

        caps.setCapability("bstack:options", bstackOptions);
        try {
            return new RemoteWebDriver(new URL(browserstackConfig.getUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
