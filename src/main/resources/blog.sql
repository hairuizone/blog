DROP TABLE artical;
CREATE TABLE artical (ID int NOT NULL AUTO_INCREMENT COMMENT '编号', AUTHOR varchar(255) COMMENT '作者', ORIGINAUTHOR varchar(255) COMMENT '原文作者', ORIGINURL varchar(255) COMMENT '原文URL', TITTLE varchar(255) COMMENT '标题', IMGPATH varchar(50) COMMENT '背景图片路径', CONTENT longtext COMMENT '内容', TAGS varchar(255) COMMENT '标签', NAVID int COMMENT '导航编号', TOPICID varchar(255) COMMENT '专题编号', CATEGORIES int COMMENT '分类', TYPE varchar(255) COMMENT '类型（原创/转载）', CREATEDATE varchar(50) COMMENT '创建日期', UPDATEDATE varchar(50) COMMENT '更新日期', ARTICALURL varchar(100) COMMENT '文章URL', SUMMARY varchar(500) COMMENT '摘要', LASTARTICALID bigint COMMENT '上一篇文章编号', NEXTARTICALID bigint COMMENT '下一篇文章编号', LIKENUMS int COMMENT '喜欢', DISSNUMS int COMMENT '不喜欢', INTOP varchar(1) COMMENT '是否置顶', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';
INSERT INTO artical (ID, AUTHOR, ORIGINAUTHOR, ORIGINURL, TITTLE, IMGPATH, CONTENT, TAGS, NAVID, TOPICID, CATEGORIES, TYPE, CREATEDATE, UPDATEDATE, ARTICALURL, SUMMARY, LASTARTICALID, NEXTARTICALID, LIKENUMS, DISSNUMS, INTOP) VALUES (1, '老干部', '', '', '从零开始搭建自己的博客网站', '13.jpg', '#### 前言
> 之前在某笔记网站注册了帐号，并开通了会员，但时间很快，前两天收到网站发送的会员到期的提示，于是想着，自己也是个程序员，为什么不自己写一个博客网站用来积累自己的日常笔记呢，这便萌发了自己写网站的念头。


#### 关于本站
> 以前上学的时候我们化学老师常常在我们耳边唠叨的一句话：“方法对了头，从此才上楼”:tw-1f31a:，借此机会也推广一下这句名言，哈哈。其实我写这边文章并不是想告诉大家，如何从零开始一步一步搭建网站，毕竟，对于懂得人来说很简单了，对于不懂得人来说也许需要学习很懂内容吧。这或许就是程序员的魅力吧，你不懂我我不怪你，毕竟要求你和我一样优秀很难。(*^__^) 嘻嘻。言归正传，下面就讲一下我自己在写这个网站的时候的一些感悟吧：


- **不要盲目的去做一件事情**
我在初期并没有急着去编码，而是在去看一看大佬们的博客网站，都是怎么去写，他们的网站里面会包含哪些内容，然后联想到自己，也许自己在开发网站的时候也需要这些功能内容，那么，这些用什么实现最好，这都是我们需要规划的事情。规划好了再行动，往往在做的过程中会得心应手。

- **多去了解一些新技术，并尝试着运用到自己的项目中。**
我并不是指盲目的使用各种框架各种技术，这些其实都是辅助咱们开发的一些手段罢了，真正的优秀的程序员是不会去关注框架和技术的。之前和朋友也聊过这个问题，在我看来，程序员之间最大的价值区别在于，你是否能够将业务场景转化成实际的功能并带给用户很好的体检效果，价值和转化率成正比。因为没有人关心你运用的是什么框架什么技术。
说到这里肯定有很多人不同意了，也许有人会说，你不是说运用新技术吗？是的，但并不是盲目的，区块链属于新技术，但对自己开发一个博客网站没有任何关系，这样的了解和学习是没有任何意义的。在技术的海洋里，要学习的东西太多太多了，而在我们有限的时间里，做有意义的事情才是正确的。

- **坚持很重要**
凡事预则立不预则废，我们不论做什么都不能只是为了一时的兴起，过了劲头就不再继续，这样也许很难做完一件事情，所以，请坚持下去，坚持每天都能实现一些功能，坚持每天都能充实一些内容，时间长了，会有质的变化的。

*最后，也希望借助这个博客网站能让自己养成写笔记，记录的良好习惯，我相信，多年以后当我回头看这个网站，会发现内容其实还是挺丰富的。嘿嘿。*
', '#个人博客#', 1, '请选择', 2, 'YC', '2019-07-01', null, null, '之前在某笔记网站注册了帐号，并开通了会员，但时间很快，前两天收到网站发送的会员到期的提示，于是想着，自己也是个程序员，为什么不自己写一个博客网站用来积累自己的日常笔记呢，这便萌发了自己写网站的念头。', null, null, 0, 0, null);
INSERT INTO artical (ID, AUTHOR, ORIGINAUTHOR, ORIGINURL, TITTLE, IMGPATH, CONTENT, TAGS, NAVID, TOPICID, CATEGORIES, TYPE, CREATEDATE, UPDATEDATE, ARTICALURL, SUMMARY, LASTARTICALID, NEXTARTICALID, LIKENUMS, DISSNUMS, INTOP) VALUES (2, '老干部', '', '', '转眼已经过了半年了', '7.jpg', '恰逢半年已过，却也还是平平淡淡，好像每天都是这么过来的，也会这样继续下去，但在这中间我好像已经记不清发生过什么了。作罢，这也许不重要，重要的是现在怎样决定你将来会怎样。重要的是，你愿意用什么样的态度去面对当下，面对将来。
', '#时间#', 1, '请选择', 1, 'YC', '2019-07-01', null, null, '恰逢半年已过，却也还是平平淡淡，好像每天都是这么过来的，也会这样继续下去，但在这中间我不知道发生过什么。这也许不重要，重要的是现在怎样决定你将来会怎样。', null, null, 0, 0, null);
INSERT INTO artical (ID, AUTHOR, ORIGINAUTHOR, ORIGINURL, TITTLE, IMGPATH, CONTENT, TAGS, NAVID, TOPICID, CATEGORIES, TYPE, CREATEDATE, UPDATEDATE, ARTICALURL, SUMMARY, LASTARTICALID, NEXTARTICALID, LIKENUMS, DISSNUMS, INTOP) VALUES (3, '老干部', '', '', '那年我在北京', '15.jpg', '毕业季总是漫长而短暂的，夹杂着伤感与憧憬。

> 剑未佩妥,出门已是江湖;千帆过尽,归来仍是少年


2015年的夏天，我告别了大学同居四年的舍友，告别了那个养我4年的地方。带着自己的梦想和我爸爸给我的八千块钱，走上了北漂的道路。
朋友说，北京这座城市是冰冷的。', '#北漂#', 1, '请选择', 1, 'YC', '2019-07-01', '2019-07-01', null, '回想一下，已经是很多年前的事情了，那时候的自己，怀揣着一颗北漂的梦，在家乡和北京之间，毅然决然的选择了北上的道路。', null, null, 0, 0, null);
DROP TABLE artical_categories;
CREATE TABLE artical_categories (ID int NOT NULL AUTO_INCREMENT COMMENT '编号', CATEGORY_NAME varchar(50) COMMENT '分类名称', IS_SHOW varchar(1) COMMENT '是否首页展示', SHOW_ORDER int COMMENT '展示序号', INTRODUCTION varchar(1000) COMMENT '介绍', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类';
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (1, '随笔感悟', 'N', null, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (2, '日常积累', 'Y', 3, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (3, '智慧生活', 'N', null, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (4, '名家佳作', 'Y', 2, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (5, '博文转载', 'Y', 4, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (6, '天下杂谈', 'N', null, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (7, '十个冷笑话', 'N', null, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (8, 'Java随笔', 'Y', 1, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (9, '操作系统', 'N', null, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (10, '数据库', 'N', null, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, INTRODUCTION) VALUES (11, '金融行业', 'N', null, '');
DROP TABLE artical_topics;
CREATE TABLE artical_topics (ID int NOT NULL AUTO_INCREMENT COMMENT '专题编号', TOPIC_NAME varchar(50) COMMENT '专题名称', INTRODUCTION varchar(1000) COMMENT '介绍', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题';
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (1, 'Java基础知识大全', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (2, '分布式开发', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (3, '大数据分析', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (4, '反向代理与负载均衡', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (5, '生活小妙招', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (6, 'Spring帝國', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (7, 'SpringBoot', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (8, '架构师之路', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (9, '如何快速转型', '');
INSERT INTO artical_topics (ID, TOPIC_NAME, INTRODUCTION) VALUES (10, '你不知道的数据模型', '');
DROP TABLE books;
CREATE TABLE books (ID int NOT NULL AUTO_INCREMENT COMMENT '序号', BOOK_NAME varchar(255) COMMENT '书籍名称', AUTHOR varchar(255) COMMENT '作者', PUBLISH_DATE varchar(20) COMMENT '发布日期', URL varchar(255) COMMENT '书籍所在网络URL', LOCAL_PATH varchar(255) COMMENT '本地存放地址', ADD_DATE varchar(20) COMMENT '添加时间', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (1, '普罗旺斯的一年', '（英）彼得·梅尔', '2011-05-01', null, 'E:/myblog/普罗旺斯的一年.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (2, '不抱怨的世界', '威尔 鲍温', '2009-04-01', null, 'E:/myblog/不抱怨的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (3, '钢铁是怎样炼成的', '保尔·柯察金', '1996-10-01', null, 'E:/myblog/钢铁是怎样炼成的.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (4, '平凡的世界', '路遥', '1986-01-01', null, 'E:/myblog/平凡的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (5, '苏菲的世界', '乔斯坦·贾德', '1991-01-01', null, 'E:/myblog/苏菲的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (6, '围城', '钱钟书', '1947-01-01', null, 'E:/myblog/围城.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (8, '不抱怨的世界', '威尔 鲍温', '2009-04-01', null, 'E:/myblog/不抱怨的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (9, '钢铁是怎样炼成的', '保尔·柯察金', '1996-10-01', null, 'E:/myblog/钢铁是怎样炼成的.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (10, '平凡的世界', '路遥', '1986-01-01', null, 'E:/myblog/平凡的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (11, '苏菲的世界', '乔斯坦·贾德', '1991-01-01', null, 'E:/myblog/苏菲的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (12, '围城', '钱钟书', '1947-01-01', null, 'E:/myblog/围城.pdf', '2019-06-17');
DROP TABLE editmd;
CREATE TABLE editmd (id int NOT NULL AUTO_INCREMENT COMMENT '序号', content longtext COMMENT '文本内容', PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO editmd (id, content) VALUES (1, '**asdfa
# Markdown语法
## 一、更改字体、大小、颜色
<font face="黑体">黑体</font>  <font face="微软雅黑">微软雅黑</font>  <font face="宋体">宋体</font>  <font face="STCAIYUN">我是华文彩云</font>
<font color=red>我是红色</font>  <font color=#008000>我是绿色</font>  <font color=Blue>我是蓝色</font>
<font size=5>我是尺寸</font>
<font face="黑体" color=green size=5>我是黑体，绿色，尺寸为5</font>
## 二、为文字添加背景色
<table><tr><td bgcolor=green><font face="黑体" size=5>背景色-green</font></td></tr><tr><td bgcolor=yellow>背景色-yellow</td></tr><tr><td bgcolor=blue>背景色-blue</td></tr></table>');
DROP TABLE my_info;
CREATE TABLE my_info (ID int NOT NULL AUTO_INCREMENT COMMENT '编号', NICKNAME varchar(30) COMMENT '网名', NAME varchar(30), WEBNAME varchar(40) COMMENT '网站名称', OCCUPATION varchar(80) COMMENT '职业', ADDRESS varchar(120) COMMENT '地址', EMAIL varchar(60) COMMENT '邮箱', WEBSITE varchar(200) COMMENT '网址', QQ varchar(20) COMMENT 'QQ号码', WECHAT varchar(30) COMMENT '微信号', WEBROOT varchar(100) COMMENT '网站根目录', WEBICON varchar(50) COMMENT '网站图标', MOTTO varchar(200) COMMENT '座右铭', PROPHOTO varchar(50) COMMENT '头像', GITHUB varchar(100) COMMENT 'github', WEIBO varchar(100) COMMENT '新浪微博', BRANDIMG varchar(50) COMMENT '网站LOGO', SOLIDOT varchar(200), ENDGREETING varchar(100), PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人信息';
INSERT INTO my_info (ID, NICKNAME, NAME, WEBNAME, OCCUPATION, ADDRESS, EMAIL, WEBSITE, QQ, WECHAT, WEBROOT, WEBICON, MOTTO, PROPHOTO, GITHUB, WEIBO, BRANDIMG, SOLIDOT, ENDGREETING) VALUES (1, '老干部', '李海瑞', '李元霸的咖啡屋', '全栈工程师', '陕西省-西安市', 'lihairuizone@sina.com', 'http://localhost:8848/myblog', '599062183', 'hairui623968', null, 'favicon.png', '我从远方走来，路上遇见了花儿，花儿对我说，生活真好，我笑了笑，点了点头！', 'avatar.jpg', '', '', 'brand.jpg', '我一直在坚定不移的在做我认为正确的事情，走我认为正确的道路，并且我还会继续！', '欢迎关注我的微信公众号:老干部的咖啡屋');
DROP TABLE nav_index;
CREATE TABLE nav_index (ID int NOT NULL AUTO_INCREMENT COMMENT '编号', NAME varchar(50) COMMENT '名称', SHOW_HOMEPAGE varchar(1) COMMENT '是否首页展示 Y-展示 N/null-不展示', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页索引';
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (1, '个人随笔', 'Y');
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (2, '美文鉴赏', 'Y');
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (3, '天下杂谈', 'Y');
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (4, '每日一乐', 'Y');
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (5, '技术专栏', 'Y');
DROP TABLE online_tools;
CREATE TABLE online_tools (ID int NOT NULL AUTO_INCREMENT COMMENT '序号', TOOL_NAME varchar(50) COMMENT '工具名称', URL varchar(255) COMMENT '网址', INTRODUCE longtext COMMENT '工具介绍', ADD_DATE varchar(20) COMMENT '添加日期', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (1, '程序员在线工具', 'http://www.ofmonkey.com/', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (2, '在线代码格式化', 'http://tool.oschina.net/codeformat/', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (3, '身份证号码查询验证', 'http://qq.ip138.com/baidu-id/index.asp', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (4, '全国各地车牌查询表', 'http://www.ip138.com/carlist.htm', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (5, '彩票开奖结果查询', 'https://caipiao.ip138.com/', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (6, '邮编查询区号查询', 'http://www.ip138.com/post/', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (7, '有道在线翻译', 'http://fanyi.youdao.com/', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (8, '代码在线运行', 'https://tool.lu/coderunner/', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (9, '在线透明favicon ico图标文件制作', 'http://www.atool9.com/ico.php', '', '2019-06-17');
INSERT INTO online_tools (ID, TOOL_NAME, URL, INTRODUCE, ADD_DATE) VALUES (10, '脚本之家在线工具', 'http://tools.jb51.net/', '', '2019-06-17');
DROP TABLE user;
CREATE TABLE user (ID int NOT NULL AUTO_INCREMENT COMMENT '序号', USERNAME varchar(30) COMMENT '帐号', PASSWORD varchar(100) COMMENT '密码', NICKNAME varchar(50) COMMENT '昵称', PROPHOTO varchar(20) COMMENT '头像', EMAIL varchar(50) COMMENT '邮箱', MOBILE varchar(20) COMMENT '手机号', LOCKFLAG varchar(5) COMMENT '是否锁定', ADMINFLAG varchar(5) COMMENT '是否管理员', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO user (ID, USERNAME, PASSWORD, NICKNAME, PROPHOTO, EMAIL, MOBILE, LOCKFLAG, ADMINFLAG) VALUES (1, 'hairui', '0192023A7BBD73250516F069DF18B500', '骑鱼的猫', 'avatar5.jpg', 'maomao@163.com', '13838381438', 'N', 'N');
INSERT INTO user (ID, USERNAME, PASSWORD, NICKNAME, PROPHOTO, EMAIL, MOBILE, LOCKFLAG, ADMINFLAG) VALUES (2, 'admin', '0192023A7BBD73250516F069DF18B500', '超级管理员', 'avatar.jpg', 'admin@sina.com', '17629261820', 'N', 'Y');
