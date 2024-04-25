## Build Application
#FROM maven:3.8.6-openjdk-18 AS build
#
#WORKDIR /app
#
#COPY . .
##COPY .env .
#
#RUN #chmod 755 mvnw
## RUN ./mvnw clean install -P quick
#
#RUN mvn package -DskipTests
#
## Serve Application
#FROM openjdk:20-bullseye
#
#WORKDIR /app
#COPY --from=build /app/.env .
#COPY --from=build /app/target/*.jar app.jar
#
#EXPOSE 6060
#
#CMD [ "java", "--enable-preview", "-jar", "app.jar" ]
# Stage 1: Build Application
FROM maven:3.8.4-openjdk-20-slim AS build

WORKDIR /app

# Copy the entire project to the container
COPY . .

# Build your application, skipping tests
RUN mvn package -DskipTests

# Stage 2: Serve Application
FROM openjdk:20-bullseye

WORKDIR /app

# Copy the necessary files from the build stage
COPY --from=build /app/target/*.jar app.jar

# Set the environment variables here
#ENV YOUR_ENV_VARIABLE_NAME_1=your_value_1 \
#    YOUR_ENV_VARIABLE_NAME_2=your_value_2

# Expose the port
EXPOSE 6060

# Start the application
CMD ["java", "-jar", "app.jar"]
