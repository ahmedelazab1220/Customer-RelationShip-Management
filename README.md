# IoC & Dependency Injection in Spring Boot

Before we dive into IOC & DI, let's take a moment to have a clear understanding of what is SPRING 👇:

- Spring is a popular open-source framework for building enterprise applications in Java. Developed by Pivotal Software (a division of VMware).
- the Spring Framework provides comprehensive infrastructure support, making it easier to develop robust and maintainable Java applications.
- It provide many Key features and components such as : Inversion of Control (IoC), Dependency Injection (DI), Data Access, Transaction Management, Data Access, Model-View-Controller (MVC), Security, Spring         Boot ... .

# Spring-Dependency-Injection

![Dependency Injection](https://github.com/ahmedelazab1220/SpringBootIoC-DI/assets/105994948/7714a154-60f5-4123-895f-a7761f4332f0)

Dependency Injection is a design pattern (way) of passing the dependencies of an object to that object, rather than having the object create its own dependencies.

let's have a general overall view of What is Dependecy Injection in a simple and general terms :

First of all DI is a design pattern and a fundamental concept in software development, particularly in object-oriented programming.

- It's a technique that promotes loose coupling between different components or classes in a software system, making the code more modular, maintainable, and easier to test.

- dependency injection refers to the process of providing the required dependencies (objects or services) that a class or component needs to function correctly, rather than letting the class create those dependencies itself.

- These dependencies are typically passed to the class from an external source, such as a configuration file, a framework, or another class responsible for managing the dependencies

Tight Coupling:

- Definition: Tight coupling refers to a situation where classes or components are highly dependent on each other's concrete implementations. Example: Directly instantiating objects or referencing concrete classes within another class.

Loose Coupling:
- Definition: Loose coupling refers to reducing dependencies between components by relying on abstractions, interfaces, or dependency injection. Example: Using interfaces, abstractions, or DI containers to decouple components.

![Loose Coupling](https://github.com/ahmedelazab1220/SpringBootIoC-DI/assets/105994948/43aa0bfd-2be6-43b0-84f3-d37d2c511287)

Dependency injection can be used to achieve a number of benefits, including:

- Loose coupling : Dependency injection makes the code more loosely coupled, which means that the code is less dependent on other parts of the code. This makes the code more flexible and easier to test.

- Testability : Dependency injection makes the code more testable, because the dependencies of an object can be mocked or stubbed out in unit tests.

- Reusability : Dependency injection makes the code more reusable, because the dependencies of an object can be injected at runtime. This means that the same object can be used in different contexts, without having to modify the code of the object.


## Without Dependency Injection : 

``` 
   public class TennisCoach {
      private FortuneService fortuneService;

      public TennisCoach() {
         this.fortuneService = new FortuneService(); // Direct instantiation
      }

      public FortuneService getFortuneService(){
        //  ........
        return fortuneService;
      }
   }

```

``` 
   public class FortuneService {

      public FortuneService() {

      }
   }
   
```

## With Dependency Injection :

``` 
   public class TennisCoach {
      private FortuneService fortuneService;

      public TennisCoach(FortuneService fortuneService) {
         this.fortuneService = fortuneService; <!-- Dependency injection through constructor -->
      }

      public FortuneService getFortuneService(){
        //  ........
        return fortuneService;
      }
   }

```

## What is Inversion of Control (IoC) ❓:

Inversion of control (IoC) is a design pattern that shifts the responsibility of creating and managing objects from the code that uses them to a separate entity, known as the IoC container. The IoC container is responsible for instantiating, configuring, and assembling objects, as well as managing their life cycles.

The Spring IoC container can be used to achieve a number of benefits, including:

- Loose coupling: The Spring IoC container allows you to decouple the code that uses an object from the code that creates and manages the object. This makes the code more flexible and easier to test.

- Testability: The Spring IoC container makes it easy to mock or stub out dependencies in unit tests. This makes the code more testable.

- Reusability: The Spring IoC container allows you to reuse beans in different contexts. This makes the code more reusable.

- Extensibility: The Spring IoC container is extensible, so you can customize it to meet your specific needs.

Here are some of the ways to use the IoC container in Spring:

- To instantiate objects: The IoC container can be used to instantiate objects. This is done by specifying the bean definition in the configuration file.

- To configure objects: The IoC container can be used to configure objects. This is done by specifying the configuration properties for the bean in the configuration file.

- To assemble objects: The IoC container can be used to assemble objects. This is done by specifying the dependencies of the bean in the configuration file.

- To manage the life cycles of objects: The IoC container can be used to manage the life cycles of objects. This includes creating, destroying, and pooling objects.

## How spring dependency injection works

Dependency injection in the Java Spring framework works by using the Spring IoC container to instantiate, configure, and assemble objects. The Spring IoC container can be configured to inject dependencies into objects in a variety of ways, including:

- Constructor injection: This is the most common type of dependency injection in Spring. In constructor injection, the dependencies of an object are passed to its constructor.

``` 
   public class TennisCoach {
     
      private FortuneService fortuneService;

      public TennisCoach(FortuneService fortuneService) {
         this.fortuneService = fortuneService; <!-- Dependency injection through constructor -->
      }

      public FortuneService getFortuneService(){
        //  ........ 
        return fortuneService;
      }
   }

```


- Setter injection: In setter injection, the dependencies of an object are passed to its setters.

``` 
   public class TennisCoach {

      private FortuneService fortuneService;

      public FortuneService getFortuneService(){
        //  ........
        return fortuneService;
      }

      @Autowired
      public FortuneService setFortuneService(FortuneService fortuneService){
         this.fortuneService = fortuneService(); 
      }
   }

```

- Field injection: In field injection, the dependencies of an object are injected into its fields.

``` 
   public class TennisCoach {

      @Autowired
      private FortuneService fortuneService;

      public FortuneService getFortuneService(){
        //  ........
        return fortuneService;
      }
   }

```

## Why do we use Annotation ❓

- Annotations in Java, and specifically in the context of the Spring framework, serve various purposes to enhance and simplify the development of applications.

## @Component

- Marks a class as a Spring component, enabling automatic detection and registration as a bean in the Spring context.

## @Autowired

- Used for automatic dependency injection. It can be applied to fields, methods, and constructors.

## @Qualifier

- is used in conjunction with @Autowired to specify which bean should be injected when there are multiple beans of the same type.

## @Scope 

- annotation is used to specify the scope of a bean. It allows you to define the lifecycle and visibility of the bean within the Spring.

## Bean scope 

refers to the lifecycle and visibility of a bean within the Spring.

There are several standard bean scopes provided by Spring, each serving different purposes and suitable for different scenarios. Here's an overview of the common bean scopes :

Singleton:

 - Singleton scope (default scope) means that only one instance of the bean is created per Spring IoC container.

Prototype:

 - Prototype scope means that a new instance of the bean is created each time it is requested.
 - The Spring container does not manage the lifecycle of prototype beans; it's the responsibility of the caller to manage them.

Request:

 - Request scope means that a new instance of the bean is created for each HTTP request in a web application.
 - The bean instance is bound to the lifecycle of an HTTP request.

Session:

 - Session scope means that a new instance of the bean is created for each HTTP session in a web application.

 - The bean instance is bound to the lifecycle of an HTTP session.

WebSocket:

 - WebSocket scope means that a new instance of the bean is created for each WebSocket connection.
 - The bean instance is bound to the lifecycle of a WebSocket connection.


## Concluion
 - Understanding IoC, DI, and leveraging the Spring framework empowers developers to create software that is modular, maintainable, and scalable 💯.
 - See the Project https://github.com/ahmedelazab1220/SpringBootIoC-DI and train it with yourself.
