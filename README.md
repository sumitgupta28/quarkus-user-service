# getting-started project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `getting-started-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/getting-started-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/getting-started-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide.


## Test Commands 

Create a new user 

```
curl -v -X POST http://localhost:8080/user/add -d "@data.json" -H "Content-Type: application/json"
```

List all the users

```
curl localhost:8080/user/get

[{"username":"firlas132835675","firstName":"firstName","lastName":"lastName","emailAddress":"TestEmail@mail.com","userActive":true},{"username":"firlas-177061322","firstName":"firstName1","las
tName":"lastName1","emailAddress":"TestEmail@mail.com","userActive":true}]
```

List User by Id
```
curl localhost:8080/user/get/firlas132835675

{"username":"firlas132835675","firstName":"firstName","lastName":"lastName","emailAddress":"TestEmail@mail.com","userActive":true}

```

Delete User

```
curl -X DELETE localhost:8080/user/delete/firlas-177061322
{"username":"firlas-177061322","firstName":"firstName1","lastName":"lastName1","emailAddress":"TestEmail@mail.com","userActive":true}

curl -X DELETE localhost:8080/user/delete/firlas-177061322
{"statusCode":"400","errorMessage":"User Not Found"}
```