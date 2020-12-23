/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/12/23 18:45:02                          */
/*==============================================================*/


drop table if exists admin;

drop table if exists article;

drop table if exists article_kind;

drop table if exists article_tag;

drop table if exists comment;

drop table if exists front;

drop table if exists kind;

drop table if exists link;

drop table if exists menu;

drop table if exists statistics;

drop table if exists tag;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   id                   int(11) not null auto_increment comment '主键ID',
   open_id              varchar(255) default NULL comment '绑定QQ登录的ID',
   img                  varchar(255) default NULL comment '头像地址',
   name                 varchar(20) default NULL comment '作者昵称',
   password             varchar(255) default NULL comment '登录密码',
   salt                 varchar(255) default NULL comment '加密盐',
   sex                  varchar(2) default NULL comment '性别：男、女、保密',
   birthday             date default NULL comment '出生年月日',
   address              varchar(50) default NULL comment '地区',
   email                varchar(50) default NULL comment '邮箱',
   phone                varchar(20) default NULL comment '手机号码',
   qq                   varchar(20) default NULL comment 'QQ号码',
   wechat               varchar(255) default NULL comment '微信号图片地址',
   public_wechat        varchar(255) default NULL comment '微信公众号图片地址',
   career               varchar(20) default NULL comment '职业',
   info                 varchar(500) default NULL comment '信息',
   recent_login         datetime default NULL comment '最近登录',
   primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   id                   int(11) not null auto_increment comment '文章的主键ID',
   title                varchar(255) default NULL comment '文章标题',
   content              longtext comment '正文',
   publish_time         datetime default NULL comment '发布时间',
   recent_edit          datetime default NULL comment '最近编辑时间',
   status               int(11) default NULL comment '文章状态。0：草稿，1：发布，2：回收站，3：加密',
   read_count           int(11) default NULL comment '阅读量',
   introduce            varchar(500) default NULL comment '文章介绍，引言',
   img                  varchar(255) default NULL comment '头图地址',
   primary key (id),
   key article_status (status),
   key article_read_count (read_count),
   key article_publish_time (publish_time)
)
ENGINE=InnoDB AUTO_INCREMENT=446863 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: article_kind                                          */
/*==============================================================*/
create table article_kind
(
   article_id           int(11) not null default 0 comment '文章ID',
   kind_id              int(11) not null default 0 comment '类别ID',
   primary key (article_id, kind_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: article_tag                                           */
/*==============================================================*/
create table article_tag
(
   article_id           int(11) not null default 0 comment '文章ID',
   tag_id               int(11) not null default 0 comment '标签ID',
   primary key (article_id, tag_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   id                   int(11) not null auto_increment comment '主键ID',
   article_id           int(11) default NULL comment '文章ID',
   name                 varchar(255) default NULL comment '评论者昵称',
   email                varchar(255) default NULL comment '邮箱地址',
   content              longtext comment '留言正文',
   reply_id             int(11) default NULL comment '作者回复的留言ID',
   img                  varchar(255) default NULL comment '随机的头像地址',
   time                 datetime default NULL comment '留言时间',
   type                 int(11) default NULL comment '评论类型【0：读者评论】【1：作者回复】',
   ip                   varchar(50) default NULL comment '留言者的IP地址',
   status               int(11) default NULL comment '评论的状态【0：未读】【1：已读】',
   primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: front                                                 */
/*==============================================================*/
create table front
(
   id                   int(11) not null auto_increment comment '主键ID',
   background           varchar(255) default NULL comment '背景图片',
   notice               varchar(500) default NULL comment '公告',
   img_target           varchar(255) default NULL comment '公告图片的URL',
   notice_img           varchar(255) default NULL comment '公告图片',
   title                varchar(255) default NULL comment '站点标题',
   sub_title            varchar(255) default NULL comment '副标题',
   primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: kind                                                  */
/*==============================================================*/
create table kind
(
   id                   int(11) not null auto_increment comment '类别的主键ID',
   name                 varchar(50) default NULL comment '名称',
   introduce            varchar(255) default NULL comment '类别的介绍',
   img                  varchar(255) default NULL comment '类别头图地址',
   primary key (id),
   key kind_name (name)
)
ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: link                                                  */
/*==============================================================*/
create table link
(
   id                   int(11) not null auto_increment comment '主键ID',
   name                 varchar(255) default NULL comment '名称',
   url                  varchar(255) default NULL comment '链接地址',
   primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   int(11) not null auto_increment comment '主键ID',
   name                 varchar(255) default NULL comment '名称',
   url                  varchar(255) default NULL comment '链接地址',
   location             int(1) default NULL comment '位置【0：左】【1：右】',
   primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: statistics                                            */
/*==============================================================*/
create table statistics
(
   id                   int(11) not null auto_increment comment '主键ID',
   ip                   varchar(255) default NULL comment 'ip地址',
   request_count        int(11) default NULL comment '访问次数',
   request_date         date default NULL comment '日期',
   article_id           int(11) default NULL comment '访问的文章id。如果为-1表示访问主页',
   primary key (id)
)
ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: tag                                                   */
/*==============================================================*/
create table tag
(
   id                   int(11) not null auto_increment comment '标签的主键ID',
   name                 varchar(50) default NULL comment '名称',
   introduce            varchar(255) default NULL comment '标签的介绍',
   img                  varchar(255) default NULL comment '标签头图地址',
   primary key (id),
   key tag_name (name)
)
ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

