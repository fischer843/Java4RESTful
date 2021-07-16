# Java4RESTful

The main Class is: com.unblu.assessments.Starter()

This Project has following dependencies:
========================================
- jackson-3.3.0.jar
- jackson-annotations-2.12.4.jar
- jackson-core-2.12.4.jar
- jackson-databind-2.12.4.jar
- jackson-datatype-jdk8-2.12.4.jar
- jackson-datatype-jsr310-2.12.4.jar
- log4j-api-2.14.1.jar
- log4j-core-2.14.1.jar
- utils-3.2.0.jar

Configuration of this Application:
=========================================

The configuration could be done by adding parameter

-DrestServiceURL=
-DrestServiceExport=
-Dusername=
-Dpassword=
-Dfilter=

or by using a properties-File. standard configuration file: starter.cfg
if you want passthrough another config-File, please use the parameter -DconfigFile=<Filename>

Parameter inside of your Properties-File:

restServiceURL=
restServiceExport=
username=
password=
filter=

delivered Parameter will be not overwritten by configFile Properties.


