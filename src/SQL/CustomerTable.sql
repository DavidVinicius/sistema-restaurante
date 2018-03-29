/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ht3000052
 * Created: 20/03/2018
 */

CREATE TABLE Customer(
    id int auto_increment primary key not null,
    name varchar(100) not null,
    document varchar(20) unique not null,
    email varchar(100) unique not null,
    phone varchar(20)  
);            


INSERT INTO Customer(name,document,email,phone) VALUES('David','44444444444','email@email.com','18999999999'),('Sara','2222222222','sara@sara.com','77777777777');


