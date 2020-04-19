package nz.brosnan.examples.lambdaquarkus.config;

import java.util.Objects;

public class StackConfig {
    private String id;
    private String lambdaId;
    private String lambdaArtifactLocation;

    public String getId() {
        return Objects.requireNonNull(this.id, "Id is required");
    }

    public StackConfig setId(String id) {
        this.id = id;
        return this;
    }

    public String getLambdaId() {
        return Objects.requireNonNull(this.lambdaId, "Id is required");
    }

    public StackConfig setLambdaId(String lambdaId) {
        this.lambdaId = lambdaId;
        return this;
    }

    public String getLambdaArtifactPath() {
        return Objects.requireNonNull(this.lambdaArtifactLocation,
                "LambdaArtifactLocation is required");
    }

    public StackConfig setLambdaArtifactPath(String lambdaArtifactLocation) {
        this.lambdaArtifactLocation = lambdaArtifactLocation;
        return this;
    }
}
