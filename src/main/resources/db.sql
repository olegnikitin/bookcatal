create table BOOKS (
	ID int primary key not null AUTO_INCREMENT,
	NAMEOFBOOK varchar(128) not null,
	SHORTDESCRIPTION varchar(256) not null,
	YEAROFPUBLISHING int(4) not null
);
 
create table AUTHORS (
	ID int primary key not null AUTO_INCREMENT,
	FIRSTNAME varchar(70) not null,
	LASTNAME varchar(70) not null
);
 
create table BOOKS_AUTHORS (
	BOOK_ID int not null,
	AUTHOR_ID int not null,
	primary key (BOOK_ID, AUTHOR_ID),
	constraint BOOKS_AUTHORS_BOOKS foreign key (BOOK_ID) references BOOKS (ID),
	constraint BOOKS_AUTHORS_AUTHORS foreign key (AUTHOR_ID) references AUTHORS (ID)
);