# demo
A simple application that receives, stores, lists and searches resources.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software

```
You need jdk 11, Maven 3.6 and postgresql 10.10 installed.
You also need the git installed if you want following some tips bellow.
The steps below assume that postgresql is running and listening on port 5432 
and has also created a database called demo_db.
```

### Installing

A step by step series of examples that tell you how to get a development env running.
This show you how to install it in a linux environment, but it's works similar in another OS

Choose an appropriate directory and clone the project using the CLI interface
```
$ git clone https://github.com/Andre-Ferraz/demo.git
```

Change into the project folder
```
$ cd demo
```

Run the following command to generate a jar file
```
$ mvn package
```
If no errors were reported, you have a folder called "target" in the project. Inside it, there is a jar file that can be executed using the following command
```
$ java -jar target/jarFile.jar
```

The postman can be used to send requests to app. You can install postman to running some tests.
```
/medias POST (create media)
/medias GET (list medias)
/medias/{id} GET (return a specific media)
```

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JAVA](https://www.oracle.com/technetwork/java/javase/overview/index.html) - Programming Language
