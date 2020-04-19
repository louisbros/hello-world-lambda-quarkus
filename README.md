# hello-world-lambda-quarkus

This repository contains some example code for testing, building and deploying a Quarkus Lambda function.

It contains three modules:

 - **hello-world-lambda-quarkus**: Function implementation using [Quarkus](https://quarkus.io/vision/continuum)
 - **hello-world-lambda-quarkus-infra**: Deployment configuration using the [AWS CDK](https://docs.aws.amazon.com/cdk/latest/guide/home.html)
 - **hello-world-lambda-quarkus-acceptance**: BDD acceptance tests using [Cucumber](https://cucumber.io/)

## Requirements

- Docker
- AWS CDK CLI
- Java & Maven

## Unit Test

To run the unit tests of each module:

```
mvn clean test
```

## Build

To build a native image archive for use within a custom Lambda environment:

```
mvn clean package -Pnative -Dnative-image.docker-build=true
```

The command will run the build for all of the project modules:

- hello-world-lambda-quarkus
- hello-world-lambda-quarkus-infra
- hello-world-lambda-quarkus-acceptance

The `hello-world-lambda-quarkus` will be built into a deployable lambda archive. This archive will contain the quarkus native image.

Because this is binary file, it needs to be built for the environment that it will run run within, to support this the binary is created within a docker container that matches the Lambda runtime.

## Deploy

The AWS CDK is a framework that allows AWS infrastructure to be defined using classes in many common languages. In this case Java has been used.

Because the Quarkus native image is being deployed instead of the traditional Java Lambda deployment, a custom Lambda environment is used.

To deploy the function run the following command. This command assumes that AWS credentials are in the environment.

```
cd hello-world-lambda-quarkus-infra && cdk deploy; cd -
```

## Acceptance Test

These tests will run against the deployed Lambda function and assume that AWS credentials are in the environment.

```
mvn clean test -Pacceptance
```
