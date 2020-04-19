package nz.brosnan.examples.lambdaquarkus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import nz.brosnan.examples.lambdaquarkus.model.Input;
import nz.brosnan.examples.lambdaquarkus.model.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
class FunctionTest {

    @Inject
    Function function;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    void testHandleRequest() {
        // Given
        Input input = new Input().setName("World");

        // When
        Output output = function.handleRequest(input, null);

        // Then
        assertNotNull(output.getId());
        assertEquals(output.getMessage(), "Hello World");
    }
}
