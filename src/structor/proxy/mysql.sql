drop table tbl_user;
drop table tbl_dep;

create table tbl_dep
(
    depid varchar(20) not null
        primary key,
    name  varchar(20) null
);

create table tbl_user
(
    name        varchar(20) not null,
    depid       varchar(20) not null,
    userid      varchar(20) not null
        primary key,
    sex         varchar(10) null,
    constraint tbl_user_fk
        foreign key (depid) references tbl_dep (depid)
);


insert into tbl_dep values('01','总公司');
insert into tbl_dep values('0101','一分公司');
insert into tbl_dep values('0102','二分公司');
insert into tbl_dep values('010101','开发部');
insert into tbl_dep values('010102','测试部');
insert into tbl_dep values('010201','开发部');
insert into tbl_dep values('010202','客户部');
insert into tbl_user values('user0001','010101','张三1', '男');
insert into tbl_user values('user0002','010101','张三2', '男');
insert into tbl_user values('user0003','010102','张三3', '男');
insert into tbl_user values('user0004','010201','张三4', '男');
insert into tbl_user values('user0005','010201','张三5', '男');
insert into tbl_user values('user0006','010202','张三6', '男');
commit;
