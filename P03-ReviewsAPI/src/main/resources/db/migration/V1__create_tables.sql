create table product (
                         id int not null auto_increment,
                         product_name varchar(300) not null,
                         description varchar(1024) not null,
                         primary key (id)
);

CREATE TABLE review (
                        id INT NOT NULL auto_increment,
                        title VARCHAR ( 1000 ) NOT NULL,
                        content VARCHAR ( 3000 ),
                        product_id INT NOT NULL,
                        PRIMARY KEY ( id ),
                        FOREIGN KEY ( product_Id ) REFERENCES product ( id )
);

CREATE TABLE comment (
                         id INT NOT NULL auto_increment,
                         title VARCHAR ( 1000 ) NOT NULL,
                         content VARCHAR ( 3000 ),
                         review_id INT NOT NULL,
                         PRIMARY KEY ( id ),
                         FOREIGN KEY ( review_id ) REFERENCES review ( id )
);

insert into product(product_name, description) values ('iphone', 'brand new one');
insert into product(product_name, description) values ('iphone2', 'brand new one2');
insert into product(product_name, description) values ('iphone3', 'brand new one3');