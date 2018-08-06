FROM openjdk:8-jdk-alpine

LABEL maintainer="steliomo@gmail.com" 

VOLUME [ "/opt/msaude/data" ]

EXPOSE 8080

ARG jar_file

ADD ${jar_file} msaude-integ.jar

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "msaude-integ.jar" ]