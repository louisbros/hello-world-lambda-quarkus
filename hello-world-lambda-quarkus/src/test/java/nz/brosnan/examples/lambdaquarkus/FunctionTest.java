package nz.brosnan.examples.lambdaquarkus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(function.handleRequest(null, null), "Output");
    }
}