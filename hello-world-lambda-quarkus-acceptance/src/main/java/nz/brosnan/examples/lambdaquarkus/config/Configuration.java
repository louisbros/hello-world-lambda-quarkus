package nz.brosnan.examples.lambdaquarkus.config;

import io.cucumber.guice.ScenarioScoped;
import java.io.IOException;
import java.util.Properties;

@ScenarioScoped
public class Configuration {
    private Properties properties;

    public Configuration() throws IOException {
        this.properties = new Properties();
        this.properties.load(this.getClass().getResourceAsStream("/application.properties"));
    }

    public String get(String key) {
        return this.properties.getProperty(key);
    }
}