# hello-world-lambda-quarkus

This repository contains some example code for testing, building and deploying a [Quarkus](https://quarkus.io/vision/continuum) Lambda function.

It contains three modules:

 - **hello-world-lambda-quarkus**: Function implementation
 - **hello-world-lambda-quarkus-infra**: Deployment configuration
 - **hello-world-lambda-quarkus-acceptance**: BDD acceptance tests

## Requirements

- Java 11
- Docker
- AWS CDK CLI

## Unit Test

```
mvn clean test
```

## Build

The following command will build a native image archive for use within Lambda:

```
mvn clean package -Pnative -Dnative-image.docker-build=true
```

The command will run the build for all of the project modules:

- hello-world-lambda-quarkus
- hello-world-lambda-quarkus-infra
- hello-world-lambda-quarkus-acceptance

The `hello-world-lambda-quarkus` will be built into a deployable lambda archive. This archive will contain the quarkus native image.

Because this is a binary, it needs to be built for the environment that it will run run within, to support this the binary is created within a docker container.

## Deploy

The AWS CDK is a framework that allows AWS infrastructure to be defined using classes in many common languages. In this case Java has been used.

Because the Quarkus native image is being deployed instead of the traditional Java Lambda deployment, a custom Lambda environment is used.

To deploy the function run the following command:

```
cd hello-world-lambda-quarkus-infra && cdk deploy; cd -
```

## Acceptance Test

```
mvn clean test -Pacceptance
```

## TODO
 - acceptance unit tests