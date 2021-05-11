use toeiconline;
create table listenguidelineEntity (
                                 listenguidelineid bigint not null primary key auto_increment,
                                 title varchar(512) null,
                                 image varchar(255) null,
                                 content text null,
                                 creareddate timestamp null,
                                 modifieddate timestamp null
);
create table comment (
                         commonid bigint not null primary key auto_increment,
                         content text null,
                         useridEntity bigint null ,
                         listenguidelineid bigint null ,
                         creareddate timestamp null
);

