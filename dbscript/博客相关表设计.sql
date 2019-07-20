--���ͱ�
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

comment on column share_article_t.article_id is '����';
comment on column share_article_t.title is '����';
comment on column share_article_t.user_id is '����ID';
comment on column share_article_t.creation_date is '����ʱ��';
comment on column share_article_t.last_update_date is '������ʱ��';
comment on column share_article_t.poll_count is '������';
comment on column share_article_t.comment_count is '������';
comment on column share_article_t.class_id is '����ID';
comment on column share_article_t.is_essence is '�Ƿ񾫻�';
comment on column share_article_t.is_top is '�Ƿ��ö�';
comment on column share_article_t.valid_flag is '�Ƿ���Ч';

create sequence share_article_s
increment by 1 -- ÿ�μӼ���
start with 1 -- ��1��ʼ����
nomaxvalue -- ���������ֵ
nocycle -- һֱ�ۼӣ���ѭ��
cache 10; --����

--���������
create table share_article_detail_t(
       article_detail_id number(15),
       article_id number(15),
       content clob
);

comment on column share_article_detail_t.article_detail_id is '����';
comment on column share_article_detail_t.article_id is '����ID';
comment on column share_article_detail_t.content is '��������';

create sequence share_article_detail_s
increment by 1 -- ÿ�μӼ���
start with 1 -- ��1��ʼ����
nomaxvalue -- ���������ֵ
nocycle -- һֱ�ۼӣ���ѭ��
cache 10; --����

--�����
create table share_classfication_t(
       class_id number(15),
       name varchar2(500)
);
comment on column share_classfication_t.class_id is '����';
comment on column share_classfication_t.name is '������';

create sequence share_classfication_s
increment by 1 -- ÿ�μӼ���
start with 1 -- ��1��ʼ����
nomaxvalue -- ���������ֵ
nocycle -- һֱ�ۼӣ���ѭ��
cache 10; --����


create table share_article_poll_t(
       poll_id number(15),
       creation_date date,
       article_id number(15),
       user_id number(15),
       is_positive number(1)
);
comment on column share_article_poll_t.poll_id is '����';
comment on column share_article_poll_t.creation_date is '����ʱ��';
comment on column share_article_poll_t.article_id is '����ID';
comment on column share_article_poll_t.user_id is '������ID';
comment on column share_article_poll_t.is_positive is '����or��';

create table share_comment_t(
       comment_id number(15),
       creation_date date,
       content varchar2(4000),
       user_id number(15),
       article_id number(15)
);
comment on column share_comment_t.comment_id is '����';
comment on column share_comment_t.creation_date is '����ʱ��';
comment on column share_comment_t.content is '��������';
comment on column share_comment_t.user_id is '������ID';
comment on column share_comment_t.article_id is '����ID';






























