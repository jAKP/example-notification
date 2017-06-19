# example-notification

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
