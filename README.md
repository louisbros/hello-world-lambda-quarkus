hello-world-lambda-quarkus
==========================

## Build

The following command will build a native image archive for use within Lambda:

```
mvn clean package -Pnative -Dnative-image.docker-build=true
```
