# Urban Octo Waddle

This project is an example app with Spring JMS and Apache Artemis using AMQP v1.0 protocol.

## To run locally

To start the client locally
```
mvn clean package
java -jar target/urban-octo-waddle-0.0.1-SNAPSHOT.jar
```

You need a running Apache Artemis broker at localhost:5672 for the app to start properly.

To send a message

```
curl -v http://localhost:8090/send?message=test
```