CREATE TABLE Product (
    ID varchar(25),
    Name varchar(255),
    Status varchar(255),
    price float(10,2),
    City varchar(255)
    prod_state varchar(30)
);

select * from product;

INSERT INTO product
VALUES (1001, 'chair', 'active',2000);

ALTER TABLE product RENAME COLUMN prod_state TO stat;



CREATE TABLE Queue (
    ID Varchar(25)
   );
   
   INSERT INTO Queue
VALUES ('1001');
commit;
   
   select * from product,approvalqueue where product.id = approvalqueue.id;
   select * from product  where id ='1001' order by created;
    select * from product where product.name = 'table';