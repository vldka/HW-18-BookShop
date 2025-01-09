package data;

import config.AuthConfig;
import lombok.Data;
import org.aeonbits.owner.ConfigFactory;

@Data
public class TestData {
    public static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    public static String isbn  ="9781449331818";
}
