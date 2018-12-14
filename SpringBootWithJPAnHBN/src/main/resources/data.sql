insert into Course(id,name,isdn,created_date,last_updated_date) values (101,'Advance JPA','111111',sysdate(),sysdate());
insert into Course(id,name,isdn,created_date,last_updated_date) values (102,'Micro Services Architecture','222222',sysdate(),sysdate());
insert into Course(id,name,isdn,created_date,last_updated_date) values (103,'Design Patterns Architecture','333333',sysdate(),sysdate());
insert into Course(id,name,isdn,created_date,last_updated_date) values (104,'Angular JS ','444444',sysdate(),sysdate());
insert into Course(id,name,isdn,created_date,last_updated_date) values (105,'Anti Patterns and Significance','555555',sysdate(),sysdate());

/*
#insert into Course_Details(id,name) values (101,'Advance JPA');
#insert into Course_Details(id,name) values (102,'Microservices Architecture');
#insert into Course_Details(id,name) values (103,'Design Patterns Architecture');
#insert into Course_Details(id,name) values (104,'Angular JS ');
#insert into Course_Details(id,name) values (105,'Anti Patterns and Significance');
*/


insert into Passport(id,number,created_date,last_updated_date)values(111,'A-101',sysdate(),sysdate());
insert into Passport(id,number,created_date,last_updated_date)values(222,'A-102',sysdate(),sysdate());
insert into Passport(id,number,created_date,last_updated_date)values(333,'S-103',sysdate(),sysdate());
insert into Passport(id,number,created_date,last_updated_date)values(444,'J-104',sysdate(),sysdate());
insert into Passport(id,number,created_date,last_updated_date)values(555,'M-105',sysdate(),sysdate());


/*
Course into Student is having MANY TO MANY Relationship.
Student can join many courses and A Course can have multiple student.
*/

insert into Student(id,name,passport_id,created_date,last_updated_date)values(1001,'Abhilash','111',sysdate(),sysdate());
insert into Student(id,name,passport_id,created_date,last_updated_date)values(2001,'Ankita','222',sysdate(),sysdate());
insert into Student(id,name,passport_id,created_date,last_updated_date)values(3001,'Sarthak','333',sysdate(),sysdate());
insert into Student(id,name,passport_id,created_date,last_updated_date)values(4001,'Julius Ceaser','444',sysdate(),sysdate());
insert into Student(id,name,passport_id,created_date,last_updated_date)values(5001,'Mark Antony','555',sysdate(),sysdate());




insert into Review (id,Course_Rating,review_description,created_date,last_updated_date) values (5001,'5','5 Star',sysdate(),sysdate());
insert into Review (id,Course_Rating,review_description,created_date,last_updated_date) values (6001,'4','4 Star',sysdate(),sysdate());
insert into Review (id,Course_Rating,review_description,created_date,last_updated_date) values (7001,'3','3 Star',sysdate(),sysdate());
insert into Review (id,Course_Rating,review_description,created_date,last_updated_date) values (8001,'2','2 Star',sysdate(),sysdate());
insert into Review (id,Course_Rating,review_description,created_date,last_updated_date) values (9001,'1','1 Star',sysdate(),sysdate());
