package nz.brosnan.examples.lambdaquarkus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import javax.inject.Inject;
import javax.inject.Named;
import org.jboss.logging.Logger;

@Named("handler")
public class Function implements RequestHandler<Object, Object> {
    private static final Logger LOGGER = Logger.getLogger("Function");

    @Override
    public Object handleRequest(Object input, Context context) {
        LOGGER.info("Running");

        return "Output";
    }
}
