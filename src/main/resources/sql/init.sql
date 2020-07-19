create table short_url
(
   id bigint not null auto_increment ,
   code varchar(255) not null unique,
   url varchar(500) not null,
   primary key(id)
);