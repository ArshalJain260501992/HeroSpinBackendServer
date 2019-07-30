# HeroSpinBackendServer

Sometimes, having too many options can be overwhelming. We’ve all been there. Restaurants with long menus, a piece of clothing in many different colors, and of course, a quiet evening in front of the TV, not knowing what to watch. Especially with the last one, sometimes it would be great if someone could make that call for us. And since most of us, are also playing with our phone, while in front of the TV (if not also controlling the TV), what could be better than an app, that randomly picks a show for you. Because we are geeks, and we love superheroes, our app is going to be picking random superhero movies. If you really feel like you want to take the situation in your hands, you can select your hero.

## Swagger

- [Swagger URL](https://herospindev.cfapps.io/swagger-ui.html#/ )


Kindly note, the hybrid app is working and one has to deploy the UI project locally or use the APK file to check the functionality. 
## Features
* It is a Spring Boot project, very light weight
* It uses reddis cache, so the processing time of request is very less and the performance is good.

## Feature Debt
* Cache eviction policy is not set
* Java-Docs for the project are in Progress

## Getting Started

To successfully get this project up and running one has to clone the repository. The Server side is a Spring Boot 2.0 application. Please follow all the instructions mentioned below:

### Prerequisites
* [Java 8](https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html) - Server side language
* [Maven](https://maven.apache.org/) - Dependency Management
* [Lombok](https://projectlombok.org/) - Java library for reducing boiler plate code
* [Reddis 5.0.5](https://redis.io/) - Cache

### Application deployment

#### Server side
* Make sure that lombok is successfully configured.
* To Build the project with Maven: 
  > mvn clean install
* To run the reddis cache
  > install latest reddis
  > run the reddis.server.exe file (double clicking will work)
* To run the project
  > mvn spring-boot:run

## Authors

* **Arshal jain** - [GitHub](https://github.com/ArshalJain260501992)

