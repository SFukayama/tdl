create table todo (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(256) NOT NULL
);

create table detail (
todo_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
content VARCHAR(256) NOT NULL,
todo_tag VARCHAR(256) NOT NULL
);

create table tag (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
tag VARCHAR(256) NOT NULL
);