package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("userName")
    String getUsername();

    @Key("authKey")
    String getAuthkey();


    @Key("url")
   // @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getUrl();

    @Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("platformVersion")
    @DefaultValue("12.0")
    String getPlatformVersion();

    @Key("app")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String getApp();
}
