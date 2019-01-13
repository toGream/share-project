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
comment on table p_share_topic_t is '���ͱ�';
comment on column p_share_topic_t.topic_type is '����ID';
comment on column p_share_topic_t.topic_title is '����: 0-�ռ� 1-���� 2-ת������';
comment on column p_share_topic_t.topic_content is '��������';
comment on column p_share_topic_t.topic_link is 'ת����������';
comment on column p_share_topic_t.topic_author is '����';
comment on column p_share_topic_t.created_by is '������';
comment on column p_share_topic_t.creation_date is '����ʱ��';
comment on column p_share_topic_t.last_updated_by is '������';
comment on column p_share_topic_t.last_update_date is '����ʱ��';

--Create Sequence
create sequence p_share_topic_s 
minvalue 1
maxvalue 99999999999999999999999999
start with 1
increment by 1
cache 10;


select * from p_share_topic_t for update;





