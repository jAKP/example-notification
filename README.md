# example-notification

> Solutions:

Situation
I had a situation where different people are editing the same notification data using the web application.

Due to this the message being compiled updated was lost or overwritten.
I considered structural ways to solve this, either 
1. Use Observer design pattern where the update event may trigger and notifies/displays all the users that the record is locked for changes
2. Version-based Optimistic concurrency method: A single record or a group update is done based on the last updated old value of version field
3. One user at a time: Only one user can edit the message at a time. 

I have chosen option 3, because option 1 would make the solution complex and use case of notifying users is not required and with option 2 users can still overwrite notification message.

I created 2 additional columns in database table of notifications table for storing user who locked the message and the timestamp when its locked.
I created additional services to fetch lock info, lock and unlock message. A LockNotificationUtil class to execute the shared functions.
Features implemented:
1. When the message is open first the user locks the message for further use and would be available readonly to others. On screen, a lock icon on message provides user who locked and when.
2. When the message is saved and , message is unlocked.
3. In case of inactivity of message for 60 mins, the message gets unlocked automatically.


> Used Design Patterns

Chain of Responsibility pattern

Herein if one object cannot handle the request then it passes the same to the next receiver and so on.
I have used it in exception handling in a java-based application, I handle all exceptions/errors at the top level and depending on instanceof the exception a 
specific custom message containing account type, error message, location, server-info needs to be displayed in screen or logged depending on the severity of
 error/exception and requirements. As an example, in case of any JDBC/Hibernate exception at DAO layer, throw an ApplicationException to the service layer.

Builder pattern

I had many classes with lots of fields and to create the objects it requires a lots of parameters to be created and multiple setters. This makes our code ugly,
 hard to understand and maintain.
I have simply utilised it because I wanted to make my code more readable, maintainable and verbose. I can now get rid of creating multiple constructors, setters.
 If I have to add any parameter, I do not have to alter/create constructor and just add it to the builder object. 

Data Acess Object (DAO) pattern

I have used this to create an interface that provides access to an underlying database.
I have an Notification entity corresponding to Notification table in database. I have created and NotificationDao to handle all the database operations (findById, update, deleteById)
and NotificationDaoImpl for its the concrete implementation. I have used Hibernate/iBATIS ORM framework.

Factory method pattern together with Decorator pattern

Herein the superclass (interface or abstract class or normal java class) define the object but subclasses decide which class to instantiate.
Subclasses are responsible to create the instance of the class. 
The web application I worked on initialises, creates, enriches and sends notifications. I have an NotificationFactory abstract class with createNotification which creates NotificationMessage
based on NotificationType (email or sms).

Singleton

The class would be declared with a private constructor so that it can not be instantiates from outside the class.
method getInstance() assures that only one instance of this class is created at runtime.
I had used it for maintaining cache of frequently used static data, maintaining configurations and properties (PropertyUtil). The getInstance() method ensures a single global access to the class.

Template method

I had a situation wherein more than one service handlers follow similar tasks and the sequence in which they are executed. Also, the behaviour of algorithm may vary
which means subclasses can override or skip the method implementation as per need but the invocation is to be in the same way.
I have an abstract AbstractHandler class that exposes defined methods to execute its methods init, performValidations, enrichRequest, sendResponse in sequence. It
is also possible for example in  certain algorithm performValidations and enrichRequest are not necessary.

Adapter pattern

I have simply utilised the object adapter because I needed a translation mechanism of requests between two incompatible interfaces. To convert from one interface of a class to another that client required to make the incompatible objects interact.
The web application is a middleware application where I had multiple front-end interfaces, interfaces for fetching market prices, customer information from CRM systems (and other interfaces). I used and Adapter class to convert from the com.frontend.MailNotification (implements com.frontend.Notification) to the com.backend.MailNotification (implements com.backend.Notification), as being middleware it is required to mimic like a com.backend.Notification type of object I created NotificationAdapter class which does the translation.

Proxy pattern

The proxy (simple) class represents functionality of another (complex) class and could be used to hide the real object.
I have a main class MailNotificationSender which implements NotificationSender interface wherein the notification message needs to be first validated and sent to multiple focus groups depending on the Notification type and roles of Relation Managers in ABN bank.
I have created a proxy MailNotificationSenderProxy class which also implements NotificationSender wherein the validation, roles etc are done within the proxy itself and privately it uses MailNotificationSender object.

> Usage of iBATIS over plain JDBC or Hibernate

The database schema used is legacy and certain complex queries were required to be written in SQL
Hibernate internally would load entire object graph
The select statements are faster in iBatis than Hibernate.

> Manage conflicts in a web application when different people are editing the same message data?

Record is locked for changes and a admin user can unlock it OR use Version-based Optimistic concurrency method.
I have implemented both of these in different applications wherein an application for maintaining static data and have used Hibernate ORM, the database table has a Version (Integer/Timestamp) column.
A single record or a group update is done based on the last updated old value of version field and implemented with a good exceptional handling (message on screen) for user experience.
 
 > Using REST
 
System components remain properly decoupled by creating an API
Discovery is far easier in REST (using tools like swagger can expose to world)

//TODO
> Use Spring Boots

Spring Boot offers a fast way to build applications. It looks at your classpath and at beans you have configured, makes reasonable assumptions about what you’re missing, and adds it. With Spring Boot you can focus more on business features and less on infrastructure.

At start up of your application, Spring Boot dynamically wires up beans and settings and applies them to your application context.

> Upgrade Spring 4.3
Use new annotations and features like @GetMapping, @PostMapping, @PutMapping and @DeleteMapping instead of standard @RequestMapping etc.
