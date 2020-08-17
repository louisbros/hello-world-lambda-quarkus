package nz.brosnan.examples.lambdaquarkus.config;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StackConfig {
    private String id;
}
