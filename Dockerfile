FROM registry.access.redhat.com/openjdk/openjdk-11-rhel7
WORKDIR /deployments/
COPY target/*.jar /deployments/application.jar
EXPOSE 8080