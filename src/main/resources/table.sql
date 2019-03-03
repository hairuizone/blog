CREATE TABLE
    my_info
    (
        pk INT NOT NULL AUTO_INCREMENT,
        nickname VARCHAR(30),
        webname varchar(40),
        Occupation VARCHAR(80),
        address VARCHAR(120),
        email VARCHAR(60),
        website VARCHAR(200),
        qq VARCHAR(20),
        wechat VARCHAR(30),
        PRIMARY KEY (pk)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci COMMENT='我的名片';
  INSERT INTO my_info (pk, nickname, Occupation, address, email, website, qq, wechat) VALUES (1, '骑鱼的猫 | 老干部', '老干部的咖啡屋',''程序员、软件工程师、需求分析师', '陕西省-西安市', 'lihairuizone@sina.com.com', 'www.nerssia.cn', '599062183', 'hairui623986');
