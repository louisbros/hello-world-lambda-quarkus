package nz.brosnan.examples.lambdaquarkus.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import nz.brosnan.examples.lambdaquarkus.config.Configuration;
import nz.brosnan.examples.lambdaquarkus.factory.LambdaClientFactory;
import org.junit.Before;
import org.junit.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;

public class LambdaServiceTest {
    private LambdaClient lambdaClientMock;
    private LambdaClientFactory lambdaClientFactoryMock;
    private LambdaService lambdaService;

    @Before
    public void setUp() throws IOException {

        this.lambdaClientMock = mock(LambdaClient.class);
        this.lambdaClientFactoryMock = mock(LambdaClientFactory.class);
        this.lambdaService = new LambdaService(new Configuration(), this.lambdaClientFactoryMock);
    }

    @Test
    public void testInvoke() {
        InvokeResponse invokeResponse = InvokeResponse.builder()
            .payload(SdkBytes.fromUtf8String("Test"))
            .build();

        when(this.lambdaClientMock.invoke(any(InvokeRequest.class)))
            .thenReturn(invokeResponse);
        when(this.lambdaClientFactoryMock.create())
            .thenReturn(this.lambdaClientMock);

        this.lambdaService.invoke("Test");
    }
}
