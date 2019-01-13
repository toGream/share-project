--Create Table
create table p_share_topic_t(
topic_id number(10),
topic_type number(2),
topic_title varchar2(500),
topic_content clob,
topic_link varchar2(4000),
topic_author varchar2(100),
created_by number(10),
creation_date date,
last_updated_by number(10),
last_update_date date
);

alter table p_share_topic_t add constraint pk_topic_id primary key(topic_id); 

--Add Commnet
comment on table p_share_topic_t is '博客表';
comment on column p_share_topic_t.topic_type is '博客ID';
comment on column p_share_topic_t.topic_title is '类型: 0-日记 1-博客 2-转发博客';
comment on column p_share_topic_t.topic_content is '博客内容';
comment on column p_share_topic_t.topic_link is '转发博客链接';
comment on column p_share_topic_t.topic_author is '作者';
comment on column p_share_topic_t.created_by is '创建人';
comment on column p_share_topic_t.creation_date is '创建时间';
comment on column p_share_topic_t.last_updated_by is '更新人';
comment on column p_share_topic_t.last_update_date is '更新时间';

--Create Sequence
create sequence p_share_topic_s 
minvalue 1
maxvalue 99999999999999999999999999
start with 1
increment by 1
cache 10;


select * from p_share_topic_t for update;





