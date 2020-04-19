package nz.brosnan.examples.lambdaquarkus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
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
        // When
        Object output = function.handleRequest(null, null);

        // Then
        assertEquals(output, "Output");
    }
}