package nz.brosnan.examples.lambdaquarkus.model;

import java.util.Objects;

public class Input {
    private String name;

    public Input() {
    }

    public String getName() {
        return Objects.requireNonNull(this.name, "Name is required");
    }

    public Input setName(String name) {
        this.name = name;
        return this;
    }
}
