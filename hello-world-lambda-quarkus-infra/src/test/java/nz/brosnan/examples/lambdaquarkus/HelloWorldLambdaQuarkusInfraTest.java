package nz.brosnan.examples.lambdaquarkus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import nz.brosnan.examples.lambdaquarkus.config.StackConfig;
import org.junit.jupiter.api.Test;
import software.amazon.awscdk.core.App;

public class HelloWorldLambdaQuarkusInfraTest {
    private final static ObjectMapper JSON = new ObjectMapper()
        .configure(SerializationFeature.INDENT_OUTPUT, true);

    @Test
    public void testStack() throws IOException {
        // Given
        App app = new App();
        StackConfig config = new StackConfig().setId("test").setLambdaId("test")
                .setLambdaArtifactPath("./src/test/resources/function");

        HelloWorldLambdaQuarkusInfraStack stack = new HelloWorldLambdaQuarkusInfraStack(app, config);

        // When
        JsonNode actual = JSON.valueToTree(app.synth().getStackArtifact(stack.getArtifactId()).getTemplate());

        // Then
        JsonNode expected = JSON.readTree(this.getClass().getResourceAsStream("/stack.json"));

        assertEquals(expected, actual);
    }
}
