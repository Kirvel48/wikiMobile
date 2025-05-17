package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${envMobile}.properties"
})
public interface LocalConfig extends Config{
    @Config.Key("deviceName")
    @Config.DefaultValue("Pixel 4 API 30")
    String getDeviceName();

    @Config.Key("platformVersion")
    @Config.DefaultValue("11.0")
    String getPlatformVersion();

    @Config.Key("url")
    @Config.DefaultValue("http://localhost:4723/")
    String getUrl();
}

