# ball-bearings-with-quarkus Project

This project was implemented by a student of the course "Computer Science" (year 2020) at the [DHBW Mosbach](https://www.mosbach.dhbw.de/). The task was completed as part of a project work.
## Table of Contents
1. [What is the project about?](#what-is-the-project-about)
2. [Technologies](#technologies)
3. [Documentation](#documentation)
4. [Dev Container - Prerequisites](#dev-container---prerequisites)
5. [Running the application in dev mode](#running-the-application-in-dev-mode)
6. [Packaging and running the application](#packaging-and-running-the-application)
7. [Creating a native executable](#creating-a-native-executable)
8. [Contribution](#contribution)


## What is the project about? 
In this project, a [Reactive RESTful Web Service](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources) was implemented, which calculates the life time of ball bearings in an O-arrangement. The usual CRUD operations (Create, Read, Update and Delete) are available.

## Technologies
This project uses **Quarkus**, the Supersonic Subatomic **Java** Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/.

Additional technologies used:
- Gradle as a build tool 
- PostgreSQL database
- *Hibernate* as an object-relational mapper
- Docker (used for development containers)
- *quarkus-junit5* and *rest-assured* for testing the application

> Have a look at the dependencies in [`build.gradle`](build.gradle) for a complete overview. 

## Documentation
There is also a detailed documentation (written in latex) for this project. Have a look at the file [content.tex](docs/include/content.tex). 

The corresponding PDF file can be found in this repo under the tab "Actions". Select the top pass of *compile-latex* and then navigate to *Artifacts*. There you can download the associated PDF with the name *INF20B_Max_4706893_T3101*.

The Github workflow always generates a new PDF if there is a change in the */docs* folder during a pull request (see [Contribution](#contribution)).

## Dev Container - Prerequisites 
You can develop the application in a development container, in which all necessary dependencies have already been resolved. You can start right away with coding. 

To do this, the following tools must be installed:
1. [Docker Desktop](https://www.docker.com/products/docker-desktop/)
2. [Visual Studio Code](https://code.visualstudio.com/download)
3. [Remote Development Extension for VSCode](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.vscode-remote-extensionpack)

> Also have a look at chapter 3 (*Remote development*) in the latex documentation for more information.  
## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/ball-bearings-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Contribution
> **[Here](./contributing.md), you will find the contribution guide.** 