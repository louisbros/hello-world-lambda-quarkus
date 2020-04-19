package nz.brosnan.examples.lambdaquarkus;

import io.cucumber.guice.ScenarioScoped;
import java.util.HashMap;

@ScenarioScoped
public class ResultHolder<K, V> extends HashMap<K, V> {
    private static final long serialVersionUID = 1L;
}
