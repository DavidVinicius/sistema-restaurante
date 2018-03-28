/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ht3000052
 * Created: 27/03/2018
 */

create table admin(
    id       int primary key auto_increment not null,     
    document varchar(20) not null, 
    password varchar(20) not null
);


INSERT INTO admin(document, password) VALUES ('123456','123456');


