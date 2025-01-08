package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "classpath:properties/${env}.properties",
        "classpath:properties/local.properties"
})

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browser.version")
    @DefaultValue("125.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    URL getRemoteURL();
}
