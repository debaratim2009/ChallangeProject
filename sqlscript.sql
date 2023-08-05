CREATE TABLE Product (
    ID INT NOT NULL AUTO_INCREMENT,
    Name varchar(255),
    Status varchar(255),
    price float(10,2),
    created Date,
    stat varchar(30),
    PRIMARY KEY (ID)
);

ALTER TABLE Product AUTO_INCREMENT=100;

select * from product;




CREATE TABLE Queue (
    ID Long
   );
   
   INSERT INTO Queue
VALUES ('1001');
commit;
   
   select * from product,approvalqueue where product.id = approvalqueue.id;
   select * from product  where id ='1001' order by created;
    select * from product;