# Quasar_JSF_Demo
Creating a JSF project using Quasar Comsat

Comsat project helps integrate Quasar Fibers with Servlets
This project was an attempt to evaluate if using Fibers helps JSF capability and service asynchrounous calls. Ability to do this will help leverage advanced JQuery UI libraries like Primefaces with asynchronous calls like Node
This would actually mean a new trend in UI space with Java development.

More details on Comsat and Quasar at http://docs.paralleluniverse.co/comsat/

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

# Findings on performance
Unfortunately the Fibers were not found to have impacted any postively when tested from JMeter(server capped to 50 threads and JMeter test running 3000 users). The response was exactly same as javax.faces.webapp.FacesServlet upto 500 users. For 3000 users, the error rate of the requests failure was almost the same and the response time was higher than normal FacesServlet.

If you happen to work on this thread further and have any better results, please contact me Sanket Sangwikar (sanketsw@au1.ibm.com)



