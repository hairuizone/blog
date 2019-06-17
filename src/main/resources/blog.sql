DROP TABLE artical;
CREATE TABLE artical (ID int NOT NULL AUTO_INCREMENT COMMENT '自增主键', AUTHOR varchar(255) COMMENT '作者', ORIGINAUTHOR varchar(255) COMMENT '原文作者', ORIGINURL varchar(255) COMMENT '原文URL', TITTLE varchar(255) COMMENT '标题', IMGPATH varchar(50) COMMENT '背景图片路径', CONTENT longtext COMMENT '内容', TAGS varchar(255) COMMENT '标签', NAVID int COMMENT '导航编号', TOPICID varchar(255) COMMENT '专题编号', CATEGORIES int COMMENT '分类', TYPE varchar(255) COMMENT '类型（原创/转载）', CREATEDATE varchar(50) COMMENT '创建日期', UPDATEDATE varchar(50) COMMENT '更新日期', ARTICALURL varchar(100) COMMENT '文章URL', SUMMARY varchar(500) COMMENT '摘要', LASTARTICALID bigint COMMENT '上一篇文章编号', NEXTARTICALID bigint COMMENT '下一篇文章编号', LIKENUMS int COMMENT '喜欢', DISSNUMS int COMMENT '不喜欢', INTOP varchar(1) COMMENT '是否置顶', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci COMMENT='文章';
INSERT INTO artical (ID, AUTHOR, ORIGINAUTHOR, ORIGINURL, TITTLE, IMGPATH, CONTENT, TAGS, NAVID, TOPICID, CATEGORIES, TYPE, CREATEDATE, UPDATEDATE, ARTICALURL, SUMMARY, LASTARTICALID, NEXTARTICALID, LIKENUMS, DISSNUMS, INTOP) VALUES (1, '老干部', '不详', 'http://blog.sina.com.cn/s/blog_b2f22e8b0101b3r0.html', '拥有梦想的时候 拿出勇气和行动', 'images/2.jpg', '> 我们常常听到人们各种各样的梦想，每一个梦想听起来都很美好，但在现实中，我们却很少见到真正坚韧不拔、全力以赴去实现梦想的人。人们热衷于谈论梦想，把它当作一句口头禅，一种对日复一日、枯燥贫乏生活的安慰。很多人带着梦想活了一辈子，却从来没有认真地去尝试实现梦想。

> 只有人类能够去梦想，并把梦想变成现实。没有梦想就没有精彩的生活，梦想是人们对未来的向往。它意味着还没有体会过的生活，意味着无穷的可能性，意味着意想不到的惊喜，意味着对自己的信心。

> 可是什么阻止人们去实现自己的梦想呢？

> 我们听到的理由多如牛毛。比如说想去某地旅游，但没有足够的钱；想学习英语，但没有足够的时间；想要追求某人，但觉得条件还不够成熟等等。人们对于做不成的，或者还没有做的事情，很少把原因归结到自己身上，往往都是习惯性地寻找某个外在的理由，为自己开脱一下，舒口气，然后继续过自己平庸的日子，让梦想躺在身体里的某个角落呼呼大睡。

> 其实，能否实现自己的梦想，外在因素只占小部分原因，主观因素才是能否实现自己梦想的主要原因。

> 一个人要实现自己的梦想，最重要的是要具备以下两个条件：勇气和行动。勇气，是指放弃和投入的勇气。一个人要为某个梦想而奋斗，就一定要放弃目前自己坚守的某些东西。既想经历大海的风浪，又想保持小河的平静；既想攀登无限风光的险峰，又想散步平坦舒适的平原，是不太可能的事情。投入，是指一旦确定了值得自己去追求的梦想，就一定要全身心投入。心想不一定事成。事成的前提是全力以赴去做，比如一个人想学游泳，惟一的办法就是一头扎到游泳池里去，也许开始会呛几口水，但最后一定能够学会游泳。

> 因此，实现梦想的关键是能否果断地采取行动。行动才是最强大的力量。

> 有一个学生曾经说，他以后想要走遍全世界，变成像徐霞客、马可·波罗那样的旅行家和冒险家，去感受大海一望无际的壮阔，体会沙漠高低起伏的雄浑，探索落日下尼罗河畔金字塔的奥秘，追寻云雾中喜马拉雅之巅的神圣。但是他说现在还没有钱，要等到成了百万富翁以后再去做这些事情。我问了他两个问题，一是如果这辈子没有成为百万富翁还去不去旅行？二是如果成为百万富翁的时候已经老得走不动路了还去不去旅行？我告诉他，最好的办法是现在就上路，拿根棍子拿只碗，一路要饭也能实现自己的梦想。梦想是不能等待的，尤其不能以实现另外一个条件为前提。很多人正是因为陷入了要做这个就必须先做那个的定势思维，最后一辈子在原地转圈，生活再也没有走出过精彩来。

> 所以，当我们拥有梦想的时候，就要拿出勇气和行动来，穿过岁月的迷雾，让生命展现别样的色彩。', '#梦想#/#勇气#', 2, '请选择', 5, 'ZZ', '2019-06-17', null, null, '我们常常听到人们各种各样的梦想，每一个梦想听起来都很美好，但在现实中，我们却很少见到真正坚韧不拔、全力以赴去实现梦想的人。人们热衷于谈论梦想，把它当作一句口头禅，一种对日复一日、枯燥贫乏生活的安慰。很多人带着梦想活了一辈子，却从来没有认真地去尝试实现梦想。', null, null, 0, 0, null);
INSERT INTO artical (ID, AUTHOR, ORIGINAUTHOR, ORIGINURL, TITTLE, IMGPATH, CONTENT, TAGS, NAVID, TOPICID, CATEGORIES, TYPE, CREATEDATE, UPDATEDATE, ARTICALURL, SUMMARY, LASTARTICALID, NEXTARTICALID, LIKENUMS, DISSNUMS, INTOP) VALUES (2, '老干部', '戴登国', 'http://blog.sina.com.cn/s/articlelist_1237731013_10_1.html', '好的心态，是最大的财富', 'images/6.jpg', '## 烦恼的根源都在自己
生气，是因为你不够大度；

郁闷，是因为你不够豁达；

焦虑，是因为你不够从容；

悲伤，是因为你不够坚强；

惆怅，是因为你不够阳光；

嫉妒，是因为你不够优秀。

凡此种种烦恼的根源都在自己这里，

所以，每一次烦恼的出现，

都是一个给我们寻找自己缺点的机会。

## 越计较越痛苦
人生，

有多少计较，就有多少痛苦；

有多少宽容，就有多少欢乐。

痛苦与欢乐都是心灵的折射，

就像镜子里面有什么，

决定于镜子面前的事物。

心里放不下，自然成了负担，

负担越多，人生越不快乐。

计较的心如同口袋，宽容的心犹如漏斗。

复杂的心爱计较，简单的心易快乐。

## 抱怨是一种毒药。
它摧毁你的意志，削减你的热情。

抱怨命运不如改变命运，

抱怨生活不如改善生活，

毕竟抱怨≠解决。

凡事多找方法，少找借口，

强者不是没有眼泪，

而是含着眼泪在奔跑!

## 无怨无悔
人生无悔便是道，人生无怨便是德。

得到的要珍惜；失去的就放弃。

过多的在乎会将人生的乐趣减半，

看淡了，一切也就释然了。

执着其实是一种负担，甚至是一种苦楚，

计较得太多就成了一种羁绊，迷失太久便成了一种痛苦。

放弃，不是放弃追求，

而是让我们以豁达的心去面对生活。

## 心好，一切都好
心态好，人缘就好，因为懂得宽容；

心态好，做事顺利，因为不拘小节；

心态好，生活愉快，因为懂得放下。

别让脾气和本事一样大，越有本事的人越没脾气。

心态好的人，处处圆融，处处圆满。

好的心态，能激发人生最大的潜能，是你最大的财富。', '#心态#/#财富#', 2, '请选择', 5, 'ZZ', '2019-06-17', '2019-06-17', null, '烦恼的根源都在自己。生气，是因为你不够大度；郁闷，是因为你不够豁达；焦虑，是因为你不够从容；悲伤，是因为你不够坚强；惆怅，是因为你不够阳光；嫉妒，是因为你不够优秀。凡此种种烦恼的根源都在自己这里，所以，每一次烦恼的出现，都是一个给我们寻找自己缺点的机会。', null, null, 0, 0, null);
DROP TABLE artical_categories;
CREATE TABLE artical_categories (ID int NOT NULL AUTO_INCREMENT COMMENT '编号', CATEGORY_NAME varchar(50) COMMENT '分类名称', IS_SHOW varchar(1) COMMENT '是否首页展示', SHOW_ORDER int COMMENT '展示序号', ARTICAL_COUNT int COMMENT '文章数量', introduction varchar(1000), PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci COMMENT='分类';
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (1, '随笔感悟', 'N', null, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (2, '日常积累', 'Y', 3, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (3, '智慧生活', 'Y', 4, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (4, '名家佳作', 'Y', 2, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (5, '博文转载', 'Y', null, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (6, '天下杂谈', 'N', null, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (7, '十个冷笑话', 'N', null, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (8, 'Java随笔', 'Y', 1, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (9, '操作系统', 'N', null, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (10, '数据库', 'N', null, 0, '');
INSERT INTO artical_categories (ID, CATEGORY_NAME, IS_SHOW, SHOW_ORDER, ARTICAL_COUNT, introduction) VALUES (11, '金融行业', 'N', null, 0, '');
DROP TABLE artical_topics;
CREATE TABLE artical_topics (ID int NOT NULL AUTO_INCREMENT COMMENT '专题编号', TOPIC_NAME varchar(50) COMMENT '专题名称', ARTICAL_COUNT int COMMENT '内容数量', introduction varchar(1000), PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci COMMENT='专题';
INSERT INTO artical_topics (ID, TOPIC_NAME, ARTICAL_COUNT, introduction) VALUES (1, 'Java基础知识大全', 0, '');
DROP TABLE books;
CREATE TABLE books (ID int NOT NULL AUTO_INCREMENT COMMENT '序号', BOOK_NAME varchar(255) COMMENT '书籍名称', AUTHOR varchar(255) COMMENT '作者', PUBLISH_DATE varchar(20) COMMENT '发布日期', URL varchar(255) COMMENT '书籍所在网络URL', LOCAL_PATH varchar(255) COMMENT '本地存放地址', ADD_DATE varchar(20), PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (1, '普罗旺斯的一年', '（英）彼得·梅尔', '2011-05-01', null, 'E:/myblog/普罗旺斯的一年.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (2, '不抱怨的世界', '威尔 鲍温', '2009-04-01', null, 'E:/myblog/不抱怨的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (3, '钢铁是怎样炼成的', '保尔·柯察金', '1996-10-01', null, 'E:/myblog/钢铁是怎样炼成的.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (4, '平凡的世界', '路遥', '1986-01-01', null, 'E:/myblog/平凡的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (5, '苏菲的世界', '乔斯坦·贾德', '1991-01-01', null, 'E:/myblog/苏菲的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (6, '围城', '钱钟书', '1947-01-01', null, 'E:/myblog/围城.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (7, '普罗旺斯的一年', '（英）彼得·梅尔', '2011-05-01', null, 'E:/myblog/普罗旺斯的一年.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (8, '不抱怨的世界', '威尔 鲍温', '2009-04-01', null, 'E:/myblog/不抱怨的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (9, '钢铁是怎样炼成的', '保尔·柯察金', '1996-10-01', null, 'E:/myblog/钢铁是怎样炼成的.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (10, '平凡的世界', '路遥', '1986-01-01', null, 'E:/myblog/平凡的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (11, '苏菲的世界', '乔斯坦·贾德', '1991-01-01', null, 'E:/myblog/苏菲的世界.pdf', '2019-06-17');
INSERT INTO books (ID, BOOK_NAME, AUTHOR, PUBLISH_DATE, URL, LOCAL_PATH, ADD_DATE) VALUES (12, '围城', '钱钟书', '1947-01-01', null, 'E:/myblog/围城.pdf', '2019-06-17');
DROP TABLE editmd;
CREATE TABLE editmd (id int NOT NULL AUTO_INCREMENT COMMENT '序号', content longtext COMMENT '文本内容', PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;
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
CREATE TABLE my_info (ID int NOT NULL AUTO_INCREMENT COMMENT '编号', NICKNAME varchar(30) COMMENT '网名', WEBNAME varchar(40) COMMENT '网站名称', OCCUPATION varchar(80) COMMENT '职业', ADDRESS varchar(120) COMMENT '地址', EMAIL varchar(60) COMMENT '邮箱', WEBSITE varchar(200) COMMENT '网址', QQ varchar(20) COMMENT 'QQ号码', WECHAT varchar(30) COMMENT '微信号', WEBROOT varchar(100), PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci COMMENT='个人信息';
INSERT INTO my_info (ID, NICKNAME, WEBNAME, OCCUPATION, ADDRESS, EMAIL, WEBSITE, QQ, WECHAT, WEBROOT) VALUES (1, '骑鱼的猫 | 老干部', '老干部的咖啡屋', '程序员、软件工程师、艺术家', '陕西省-西安市', 'LIHAIRUIZONE@SINA.COM', 'WWW.NERSSIA.CN', null, null, '/myblog');
DROP TABLE nav_index;
CREATE TABLE nav_index (ID int NOT NULL AUTO_INCREMENT COMMENT '编号', NAME varchar(50) COMMENT '名称', SHOW_HOMEPAGE varchar(1) COMMENT '是否首页展示 Y-展示 N/null-不展示', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci COMMENT='首页索引';
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (1, '个人随笔', 'Y');
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (2, '美文鉴赏', 'Y');
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (3, '天下杂谈', 'Y');
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (4, '每日一乐', 'Y');
INSERT INTO nav_index (ID, NAME, SHOW_HOMEPAGE) VALUES (5, '技术专栏', 'Y');
DROP TABLE online_tools;
CREATE TABLE online_tools (ID int NOT NULL AUTO_INCREMENT COMMENT '序号', TOOL_NAME varchar(50) COMMENT '工具名称', URL varchar(255) COMMENT '网址', INTRODUCE longtext COMMENT '工具介绍', ADD_DATE varchar(20) COMMENT '添加日期', PRIMARY KEY (ID)) ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;
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
