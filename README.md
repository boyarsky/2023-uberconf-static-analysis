## CheckStyle

Get abstract syntax tree for a class

```
java -jar custom-checkstyle/lib/checkstyle-10.12.1-all.jar -T static-analysis/src/main/java/com/jeanneboyarsky/staticanalysis/Denver.java 
```

UI for loading files and expanding/collapsing parts of tree.

```
java -cp custom-checkstyle/lib/checkstyle-10.12.1-all.jar com.puppycrawl.tools.checkstyle.gui.Main
```

Run at command line for ease in debugging

```
java -cp "static-analysis/generated-libs/custom-checkstyle-1.0-SNAPSHOT.jar:custom-checkstyle/lib/checkstyle-10.12.1-all.jar" com.puppycrawl.tools.checkstyle.Main -c static-analysis/config/checkstyle/checkstyle.xml static-analysis
```

## Spotbugs

Just code. See subproject

## PMD

Open rule designer (Note need to download javafx first https://gluonhq.com/products/javafx/)

```
export JAVAFX_HOME="/Library/Java/JavaFx/javafx-sdk-20.0.1"
custom-pmd/lib/bin/pmd designer 
```

## Sonar

Raw Sonar:

```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
```


Sonar with plugin:

```
mvn install
docker build .
docker run -d --name sonarqube-with-plugin -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 <hash>
```


Then
1. Login admin/admin
1. Accept plugin risk
1. Extend Java quality profile and make extended on default
1. Add two rules custom Java quality profile
1. Create new project manually
1. Add token to gradle scanner config

After that

```
docker stop sonarqube
docker start sonarqube
```