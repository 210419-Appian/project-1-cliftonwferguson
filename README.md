# Banking API
The Banking API will manage the bank accounts of its users. The Bank has three types of users: Admins, Employees, and Standard Users.  Admins and Employees are both considered standard users with additional functionality.  All users are able to log in and out using their username and password.  Standard users are only able to see their accounts. All users are able to transfer funds within their owned accounts.  Admin users are able to transfer funds between different user accounts.  

## Technologies Used
* Spring Tool Suite
* Maven Repository
* DBeaver
* Postman

### **Features**
* Employees can view all customer information, but not modify in any way.
* Admins can both view all user information, as well as directly modify it.
* Standard users should be able to login to see their account information.They can have either Checking or Savings accounts.
* Accounts owned by users must support withdrawal, deposit, and transfer.
* Transfer of funds are be allowed between accounts owned by the same user, as well as between accounts owned by different users.

### **T0-do List**
* Password Hashing
* Creating New Users
* Updating User Information
* Support Delete Requests for Users and Accounts

### **Getting Started**
* Install Apache Tomcat 9.
* Install Java 8 Runtime Environment.
* git clone https://github.com/210419-Appian/project-1-cliftonwferguson.git 

### **Contributors**
* Clifton Ferguson
