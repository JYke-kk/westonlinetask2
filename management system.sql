-- 创建一个学生表 内容包含学号int，学生姓名varchar，性别varchar id是主键
CREATE TABLE IF NOT EXISTS ‘students‘(
‘id‘ INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
’name‘ VARCHAR(20) NOT NULL DEFAULT '小a' COMMENT '姓名',
’sex‘ VARCHAR(2) NOT NULL DEFAULT '男' COMMENT'性别',
PRIMARY KEY(‘id‘)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4

-- show create database management system -- 查看创建数据库语句
-- show create table student -- 查看表的语句
-- dec student -- 显示表的结构

-- 创建一个班级表 内容包含班级编号，学生信息，进入班级时间
CREATE TABLE IF NOT EXISTS ‘class‘(
‘classid‘ INT(4) NOT NULL AUTO_INCREMENT COMMENT '班级编号',
’studentmessage‘ VARCHAR(80) NOT NULL DEFAULT '...' COMMENT '学生信息',
’time‘ DATETIME   DEFAULT NULL COMMENT'到达时间',
PRIMARY KEY(‘id‘)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4

SHOW CREATE DATABASE management SYSTEM -- 查看创建数据库语句
SHOW CREATE TABLE class-- 查看表的语句



INSERT INTO ‘students‘(‘id‘,’name‘,’sex‘) VALUES ('2000','aa','男')
INSERT INTO ‘students‘(‘id‘,’name‘,’sex‘) VALUES ('2500','ab','女')
INSERT INTO ‘students‘(‘id‘,’name‘,’sex‘) VALUES ('1900','ac','男')

INSERT INTO  ‘class‘ (‘classid‘,‘studentmessage‘,‘time‘) VALUES ('1220','是一个聋哑人','2022-12-20')
INSERT INTO  ‘class‘ (‘classid‘,‘studentmessage‘,‘time‘) VALUES ('2525','是一个正常人','2022-2-5')
INSERT INTO  ‘class‘ (‘classid‘,‘studentmessage‘,‘time‘) VALUES ('1219','是一个盲人','2022-12-19')


