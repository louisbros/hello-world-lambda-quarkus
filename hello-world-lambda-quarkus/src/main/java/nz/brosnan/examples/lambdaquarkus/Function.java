package nz.brosnan.examples.lambdaquarkus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.UUID;
import javax.inject.Named;
import nz.brosnan.examples.lambdaquarkus.model.Input;
import nz.brosnan.examples.lambdaquarkus.model.Output;
import org.jboss.logging.Logger;

@Named("handler")
public class Function implements RequestHandler<Input, Output> {
    private static final Logger LOGGER = Logger.getLogger("Function");

    @Override
    public Output handleRequest(Input input, Context context) {
        LOGGER.info("Running");

        return new Output().setId(UUID.randomUUID().toString())
            .setMessage(String.format("Hello %s", input.getName()));
    }
}
