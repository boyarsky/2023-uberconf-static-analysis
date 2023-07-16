FROM sonarqube:latest

COPY --chown=sonarqube:sonarqube target/custom-sonar-1.0.0-SNAPSHOT.jar /opt/sonarqube/extensions/plugins/

RUN chmod -R o+x /opt/sonarqube/extensions/plugins/custom-sonar-1.0.0-SNAPSHOT.jar
