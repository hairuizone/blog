CREATE TABLE
    artical
(
    id INT NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    articalId bigint NOT NULL COMMENT '文章编号',
    author VARCHAR(255) COMMENT '作者',
    originAuthor VARCHAR(255) COMMENT '原文作者',
    originUrl VARCHAR(255) COMMENT '原文URL',
    tittle VARCHAR(255) COMMENT '标题',
    content longtext COMMENT '内容',
    tags VARCHAR(255) COMMENT '标签',
    navId INT COMMENT '导航编号',
    topicId VARCHAR(255) COMMENT '专题编号',
    categories VARCHAR(255) COMMENT '分类',
    type VARCHAR(255) COMMENT '类型（原创/转载）',
    createDate VARCHAR(50) COMMENT '创建日期',
    updateDate VARCHAR(50) COMMENT '更新日期',
    articalUrl VARCHAR(100) COMMENT '文章URL',
    summary VARCHAR(500) COMMENT '摘要',
    lastArticalId bigint COMMENT '上一篇文章编号',
    nextArticalId bigint COMMENT '下一篇文章编号',
    likeNums INT COMMENT '喜欢',
    dissNums INT COMMENT '不喜欢',
    intop VARCHAR(1) COMMENT '是否置顶',
    PRIMARY KEY (id)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE
    my_info
(
    id INT NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(30),
    webname VARCHAR(40),
    Occupation VARCHAR(80),
    address VARCHAR(120),
    email VARCHAR(60),
    website VARCHAR(200),
    qq VARCHAR(20),
    wechat VARCHAR(30),
    PRIMARY KEY (id)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人信息';

CREATE TABLE
    nav_index
(
    id INT NOT NULL AUTO_INCREMENT COMMENT '编号',
    name VARCHAR(50) COMMENT '名称',
    PRIMARY KEY (id)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('1', '1', '李海瑞', null, null, '1个人博客，属于我的个人小世界！', null, '#原创#', '7', null, null, null, '2019-03-04', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('2', '2', '李海瑞', null, null, '1如何快速建立自己的个人博客网站', null, '#原创#', '1', null, null, null, '2019-03-05', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('3', '3', '李海瑞', null, null, '1我是怎么评价自己的？', null, '#原创#', '1', null, null, null, '2019-03-06', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('4', '4', '李海瑞', null, null, '1怎样才算一个合格的程序员', null, '#原创#', '1', null, null, null, '2019-03-07', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('5', '5', '李海瑞', null, null, '1职业发展何去何从？', null, '#原创#', '1', null, null, null, '2019-03-08', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('6', '6', '李海瑞', null, null, '1为人处事，遵循一个“妙”字！', null, '#原创#', '1', null, null, null, '2019-03-09', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('7', '7', '李海瑞', null, null, '3个人博客，属于我的个人小世界！', null, '#原创#', '7', null, null, null, '2019-03-04', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('8', '8', '李海瑞', null, null, '3如何快速建立自己的个人博客网站', null, '#原创#', '3', null, null, null, '2019-03-05', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('9', '9', '李海瑞', null, null, '3我是怎么评价自己的？', null, '#原创#', '3', null, null, null, '2019-03-06', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('10', '10', '李海瑞', null, null, '3怎样才算一个合格的程序员', null, '#原创#', '3', null, null, null, '2019-03-07', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('11', '11', '李海瑞', null, null, '3职业发展何去何从？', null, '#原创#', '3', null, null, null, '2019-03-08', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('12', '12', '李海瑞', null, null, '3为人处事，遵循一个“妙”字！', null, '#原创#', '3', null, null, null, '2019-03-09', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('13', '13', '李海瑞', null, null, '2个人博客，属于我的个人小世界！', null, '#原创#', '7', null, null, null, '2019-03-04', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('14', '14', '李海瑞', null, null, '2如何快速建立自己的个人博客网站', null, '#原创#', '2', null, null, null, '2019-03-05', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('15', '15', '李海瑞', null, null, '2我是怎么评价自己的？', null, '#原创#', '2', null, null, null, '2019-03-06', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('16', '16', '李海瑞', null, null, '2怎样才算一个合格的程序员', null, '#原创#', '2', null, null, null, '2019-03-07', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('17', '17', '李海瑞', null, null, '2职业发展何去何从？', null, '#原创#', '2', null, null, null, '2019-03-08', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('18', '18', '李海瑞', null, null, '2为人处事，遵循一个“妙”字！', null, '#原创#', '2', null, null, null, '2019-03-09', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('19', '19', '李海瑞', null, null, '4个人博客，属于我的个人小世界！', null, '#原创#', '7', null, null, null, '2019-03-04', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('20', '20', '李海瑞', null, null, '4如何快速建立自己的个人博客网站', null, '#原创#', '4', null, null, null, '2019-03-05', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('21', '21', '李海瑞', null, null, '4我是怎么评价自己的？', null, '#原创#', '4', null, null, null, '2019-03-06', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('22', '22', '李海瑞', null, null, '4怎样才算一个合格的程序员', null, '#原创#', '4', null, null, null, '2019-03-07', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('23', '23', '李海瑞', null, null, '4职业发展何去何从？', null, '#原创#', '4', null, null, null, '2019-03-08', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('24', '24', '李海瑞', null, null, '4为人处事，遵循一个“妙”字！', null, '#原创#', '4', null, null, null, '2019-03-09', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('25', '25', '李海瑞', null, null, '5个人博客，属于我的个人小世界！', null, '#原创#', '7', null, null, null, '2019-03-04', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('26', '26', '李海瑞', null, null, '5如何快速建立自己的个人博客网站', null, '#原创#', '5', null, null, null, '2019-03-05', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('27', '27', '李海瑞', null, null, '5我是怎么评价自己的？', null, '#原创#', '5', null, null, null, '2019-03-06', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('28', '28', '李海瑞', null, null, '5怎样才算一个合格的程序员', null, '#原创#', '5', null, null, null, '2019-03-07', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('29', '29', '李海瑞', null, null, '5职业发展何去何从？', null, '#原创#', '5', null, null, null, '2019-03-08', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);
INSERT INTO artical (id, articalId, author, originAuthor, originUrl, tittle, content, tags, navId, topicId, categories, type, createDate, updateDate, articalUrl, summary, lastArticalId, nextArticalId, likeNums, dissNums, intop) VALUES ('30', '30', '李海瑞', null, null, '5为人处事，遵循一个“妙”字！', null, '#原创#', '5', null, null, null, '2019-03-09', null, null, '为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。', null, null, null, null, null);


INSERT INTO my_info (id, nickname, webname, Occupation, address, email, website, qq, wechat) VALUES ('1', '骑鱼的猫 | 老干部', '老干部的咖啡屋', '程序员、软件工程师、艺术家', '陕西省-西安市', 'lihairuizone@sina.com.com', 'www.nerssia.cn', null, null);


INSERT INTO nav_index (id, name) VALUES ('1', '个人博客');
INSERT INTO nav_index (id, name) VALUES ('2', '工作日记');
INSERT INTO nav_index (id, name) VALUES ('3', '心路历程');
INSERT INTO nav_index (id, name) VALUES ('4', '我的原创');
INSERT INTO nav_index (id, name) VALUES ('5', '技术专题');


