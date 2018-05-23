# ExerciseV1

SAMPLE CRUD IMPLEMENTATION FOR SPRING MVC


## Prerequisites

1. Eclipse Version: Oxygen.3a Release (4.7.3a)
2. PostgreSQL V3.0. 
3. JDK ( jdk-8u171-windows-x64 )
4. Tomcat V8.5

### Getting Started

1. Install first the PostgreSQL and import the database on the POSTGRESQL inside the database folder( ExerciseV1/database/springexercise.sql ). Make sure that the credentials matches the spring configuration on the bean file. 

```
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="org.postgresql.Driver" />
		<property name="url" value="jdbc:postgresql://localhost/springexercise" />
		<property name="username" value="postgres" />
		<property name="password" value="1234" />
	</bean>
  
```

2. Import the project on the eclipse folder and make sure to run it using maven build. Right click the project and run as maven build. [Sample Screenshot](https://www.screencast.com/t/cmWWXNN4M).
3. A window will appear prompting the configuration, add clean install on the goals and click run. [Sample Screenshot](https://www.screencast.com/t/i4jE6hNE).
4. After all the maven depencies downloaded locally. Download and install Tomcat V8.5 or other servers that you like in order to run the project locally. After installing Tomcat, you can now run the project as Run on Server. 
5. Sample Screenshots of UI after successfully running it on the server. 
	1. [LOGIN] (https://www.screencast.com/t/bagKVXYz2xDx)
	2. [TABLE] (https://www.screencast.com/t/6cPnYSDo)
	3. [UPDATE/ADD UI] (https://www.screencast.com/t/nZBb1Bc4sHSC)



###  Development FAQ

Current Limitation is that current user is still static data and it is not connected to the database yet. 
In order to login, you may update the spring security  xml configuration file or you can use  **ford** as username and password for your credentials. 
```
	<authentication-manager>
		<authentication-provider>
		  <user-service>
			<user name="ford" password="ford" authorities="ROLE_ADMIN" />
		  </user-service>
		</authentication-provider>
	</authentication-manager>

```


