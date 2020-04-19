package nz.brosnan.examples.lambdaquarkus.model;

public class Output {
    private String id;
    private String message;

    public String getId() {
        return this.id;
    }

    public Output setId(String id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Output setMessage(String message) {
        this.message = message;
        return this;
    }
}
