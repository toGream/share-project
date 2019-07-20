--博客表
create table share_article_t(
       article_id number(15) primary key,
       title varchar2(500),
       user_id number(15),
       creation_date date,
       last_update_date date,
       poll_count number(10),
       comment_count number(10),
       class_id number(15),
       is_essence number(1),
       is_top number(1),
       valid_flag varchar2(1)
);

comment on column share_article_t.article_id is '主键';
comment on column share_article_t.title is '标题';
comment on column share_article_t.user_id is '作者ID';
comment on column share_article_t.creation_date is '创建时间';
comment on column share_article_t.last_update_date is '最后更新时间';
comment on column share_article_t.poll_count is '点赞数';
comment on column share_article_t.comment_count is '评论数';
comment on column share_article_t.class_id is '分类ID';
comment on column share_article_t.is_essence is '是否精华';
comment on column share_article_t.is_top is '是否置顶';
comment on column share_article_t.valid_flag is '是否有效';

create sequence share_article_s
increment by 1 -- 每次加几个
start with 1 -- 从1开始计数
nomaxvalue -- 不设置最大值
nocycle -- 一直累加，不循环
cache 10; --缓存

--博客详情表
create table share_article_detail_t(
       article_detail_id number(15),
       article_id number(15),
       content clob
);

comment on column share_article_detail_t.article_detail_id is '主键';
comment on column share_article_detail_t.article_id is '文章ID';
comment on column share_article_detail_t.content is '文章内容';

create sequence share_article_detail_s
increment by 1 -- 每次加几个
start with 1 -- 从1开始计数
nomaxvalue -- 不设置最大值
nocycle -- 一直累加，不循环
cache 10; --缓存

--分类表
create table share_classfication_t(
       class_id number(15),
       name varchar2(500)
);
comment on column share_classfication_t.class_id is '主键';
comment on column share_classfication_t.name is '分类名';

create sequence share_classfication_s
increment by 1 -- 每次加几个
start with 1 -- 从1开始计数
nomaxvalue -- 不设置最大值
nocycle -- 一直累加，不循环
cache 10; --缓存


create table share_article_poll_t(
       poll_id number(15),
       creation_date date,
       article_id number(15),
       user_id number(15),
       is_positive number(1)
);
comment on column share_article_poll_t.poll_id is '主键';
comment on column share_article_poll_t.creation_date is '点赞时间';
comment on column share_article_poll_t.article_id is '文章ID';
comment on column share_article_poll_t.user_id is '点赞人ID';
comment on column share_article_poll_t.is_positive is '点赞or踩';

create table share_comment_t(
       comment_id number(15),
       creation_date date,
       content varchar2(4000),
       user_id number(15),
       article_id number(15)
);
comment on column share_comment_t.comment_id is '主键';
comment on column share_comment_t.creation_date is '评论时间';
comment on column share_comment_t.content is '评论内容';
comment on column share_comment_t.user_id is '评论人ID';
comment on column share_comment_t.article_id is '文章ID';






























