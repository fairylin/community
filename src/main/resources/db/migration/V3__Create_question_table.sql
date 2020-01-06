create table question
(
	id int auto_increment primary key,
	title varchar(50),
	description text,
	gmt_create bigint,
	gmt_modified bigint,
	creator int,
	view_count int default 0,
	like_count int default 0,
	comment_count int default 0,
	tag varchar(256)
);

