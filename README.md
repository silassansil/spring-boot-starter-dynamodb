# spring-boot-starter-dynamodb
Auto configuration to Spring Data DynamoDb

## Getting Started
#### The main idea
If you would like to use `spring-data-dynamodb`, but you have a lot of troubles during 
the setup or you need use the same configuration in all your microservices.
The main idea behind this project is to use Spring Starter to make it easy this implantation.

#### How does it work?
Basically this project use the concept of Spring Auto Configuration to avoid use the same 
bean definition in your whole projects.  

#### How to use it:
* You must use Spring Version >= 2.2.X 
* Download the JAR though Maven Central:

```xml
<dependency>
    <groupId>br.com.yes</groupId>
    <artifactId>spring-boot-starter-dynamodb</artifactId>
    <version>1.0.0</version>
</dependency>
```

* After this, you must add `@EnableDynamoDBRepositories` in your Application.java file:
```java        
@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "<path-to-repository-packeages>")
public class Application {
public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
}
```

* **Optional** - you can set environments properties to customize DynamoDb values

```properties
aws.dynamodb.table.prefix 
aws.dynamodb.region 
```

## Let's code!!
