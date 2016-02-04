# Quasar_JSF_Demo
Creating a JSF project using Quasar Comsat

Comsat project helps integrate Quasar Fibers with Servlets
This project was an attempt to evaluate if using Fibers helps JSF capability and service asynchrounous calls. Ability to do this will help leverage advanced JQuery UI libraries like Primefaces with asynchronous calls like Node
This would actually mean a new trend in UI space with Java development.

# Strategy
JSF demo project created here uses its own ComsatFacesServlet instread of javax.faces.webapp.FacesServlet 
It extends HttpFiberServlet but preserves all the functionality of FacesServlet

# Code changes
Entry in web.xml
```
	<servlet>
		<servlet-name>Faces Servlet</servlet-name>
    <!-- 		<servlet-class>javax.faces.webapp.FacesServlet</servlet-class> -->
		<servlet-class>com.tutorial.ComsatFacesServlet</servlet-class>
		<load-on-startup>1</load-on-startup>
		<enabled>true</enabled>
		<async-supported>true</async-supported>
	</servlet>
```
```
public final class ComsatFacesServlet extends FiberHttpServlet 
```

Your pom.xml needs to import several packages for Quasar and also packages below since we dont use FacesServlet
```
		<dependency>
			<groupId>javax.faces</groupId>
			<artifactId>jsf-api</artifactId>
			<version>2.1</version>
		</dependency>
		<dependency>
		  <groupId>javax.servlet</groupId>
		  <artifactId>javax.servlet-api</artifactId>
		  <version>3.0.1</version>
		  <scope>provided</scope>
		</dependency>
```
# Configuring Apache Tomcat
I used Apache Tomcat 8.0.30 However i faced issues with Java agent with both tomcat and  Websphere Liberty Profile Server.
I used comsat-tomcat-loader-0.5.0-jdk8.jar, place it in apache-tomcat-8.0.30\lib.
In eclipse -> tomcat server -> content.xml -> add following line:
```
<Loader loaderClass="co.paralleluniverse.comsat.tomcat.QuasarWebAppClassLoader" />
```
