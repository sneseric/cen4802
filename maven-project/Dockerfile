# Use an official Java 17 runtime as a parent image
FROM openjdk:17-alpine

# Set the working directory inside the Docker container
WORKDIR /app

# Copy the built application JAR file from the target directory to the Docker container
COPY target/*.jar app.jar

# Make port 8085 available to the world outside this container
EXPOSE 8085

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
