/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.12 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=''NO_AUTO_VALUE_ON_ZERO'' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `artical` */

DROP TABLE IF EXISTS `artical`;

CREATE TABLE `artical` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ''自增主键'',
  `ARTICALID` bigint(20) NOT NULL COMMENT ''文章编号'',
  `AUTHOR` varchar(255) DEFAULT NULL COMMENT ''作者'',
  `ORIGINAUTHOR` varchar(255) DEFAULT NULL COMMENT ''原文作者'',
  `ORIGINURL` varchar(255) DEFAULT NULL COMMENT ''原文URL'',
  `TITTLE` varchar(255) DEFAULT NULL COMMENT ''标题'',
  `IMGPATH` varchar(50) DEFAULT NULL COMMENT ''背景图片路径'',
  `CONTENT` longtext COMMENT ''内容'',
  `TAGS` varchar(255) DEFAULT NULL COMMENT ''标签'',
  `NAVID` int(11) DEFAULT NULL COMMENT ''导航编号'',
  `TOPICID` varchar(255) DEFAULT NULL COMMENT ''专题编号'',
  `CATEGORIES` int(11) DEFAULT NULL COMMENT ''分类'',
  `TYPE` varchar(255) DEFAULT NULL COMMENT ''类型（原创/转载）'',
  `CREATEDATE` varchar(50) DEFAULT NULL COMMENT ''创建日期'',
  `UPDATEDATE` varchar(50) DEFAULT NULL COMMENT ''更新日期'',
  `ARTICALURL` varchar(100) DEFAULT NULL COMMENT ''文章URL'',
  `SUMMARY` varchar(500) DEFAULT NULL COMMENT ''摘要'',
  `LASTARTICALID` bigint(20) DEFAULT NULL COMMENT ''上一篇文章编号'',
  `NEXTARTICALID` bigint(20) DEFAULT NULL COMMENT ''下一篇文章编号'',
  `LIKENUMS` int(11) DEFAULT NULL COMMENT ''喜欢'',
  `DISSNUMS` int(11) DEFAULT NULL COMMENT ''不喜欢'',
  `INTOP` varchar(1) DEFAULT NULL COMMENT ''是否置顶'',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT=''文章'';

/*Data for the table `artical` */

insert  into `artical`(`ID`,`ARTICALID`,`AUTHOR`,`ORIGINAUTHOR`,`ORIGINURL`,`TITTLE`,`IMGPATH`,`CONTENT`,`TAGS`,`NAVID`,`TOPICID`,`CATEGORIES`,`TYPE`,`CREATEDATE`,`UPDATEDATE`,`ARTICALURL`,`SUMMARY`,`LASTARTICALID`,`NEXTARTICALID`,`LIKENUMS`,`DISSNUMS`,`INTOP`) values (1,1,''李海瑞'',NULL,NULL,''1个人博客，属于我的个人小世界！'',''images/1.jpg'',NULL,''#原创#/#大数据#'',7,NULL,1,NULL,''2019-03-04'',NULL,NULL,''人生中有太多的过客，不管你有多么的不舍，过客始终都是过客，总有一天会离开的，你要学会放手，别等到变成一种伤害再去后悔。记住：是你的跑不了，不是你的再怎么挽留也没用。'',NULL,NULL,NULL,NULL,NULL),(2,2,''李海瑞'',NULL,NULL,''1如何快速建立自己的个人博客网站'',''images/2.jpg'',NULL,''#原创#'',1,NULL,1,NULL,''2019-03-05'',NULL,NULL,''为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。'',NULL,NULL,NULL,NULL,NULL),(3,3,''李海瑞'',NULL,NULL,''1别让这些闹心的套路，毁了你的人生'',''images/3.jpg'',NULL,''#原创#'',1,NULL,1,NULL,''2019-03-06'',NULL,NULL,''如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... '',NULL,NULL,NULL,NULL,''Y''),(4,4,''李海瑞'',NULL,NULL,''1怎样才算一个合格的程序员'',''images/4.jpg'',NULL,''#原创#'',1,NULL,1,NULL,''2019-03-07'',NULL,NULL,''曾有一个妇人，经常为生活中一些琐碎的小事情生气。她也知道自己这样不好，却总也打不开这个心结，便去求一位高僧为自己谈禅说道，解开心结。高僧听了他的讲述，一言不发地把她领到一间禅房中。锁上门就走了。妇人气得大骂。骂了许久，高僧也不理会。妇人又开始哀求，高僧仍置之不理。妇人终于沉默了。这时高僧在门外问她；“你还生气吗？”妇人说；“我在对自己生气，我怎么会到这地方来受这份罪？”“连自己都不原谅的人怎么能心如止水？”高僧佛袖而去。过了一会而高僧又来问她；“还生气吗？”“不生气了”妇人说。“为什么”“气也没有办法呀。”“你的气并未消，还压在心理，爆发后将会更加剧烈。”高僧又离开了。高僧第三次来到门前，妇人告诉他；“我不生气了，因为不值得气。”“既然衡量值不值得，可见心中还是有气。”高僧笑道。当高僧的身影迎着夕阳立在门外时，妇人问高僧；“大师，什么是气？”高僧将手中的茶水倾洒于地，妇人视之良久，顿悟，叩谢而去。'',NULL,NULL,NULL,NULL,NULL),(5,5,''李海瑞'',NULL,NULL,''1职业发展何去何从？'',''images/1.jpg'',NULL,''#原创#'',1,NULL,2,NULL,''2019-03-08'',NULL,NULL,''谁都没有能力去改写历史，我们要做的就是把握现在，展望未来，接受生活带给你的种种考验。  　　人生的每个抉择都像是一个赌局，输赢都是自己的。不同的是赌注的大小，选择了就没有反悔的机会。  　　败给谁都不能败给自己，如果败给了自己，那么，你的人生也就彻彻底底的败了。  　　我们要学会适当的采纳别人的意见。  　　人需要经常自我反省，善于学习，如果仅仅是在自己的固定方式下一意孤行，其实是挺悲哀的。'',NULL,NULL,NULL,NULL,NULL),(6,6,''李海瑞'',NULL,NULL,''1为人处事，遵循一个“妙”字！'',''images/2.jpg'',NULL,''#原创#'',1,NULL,4,NULL,''2019-03-09'',NULL,NULL,''很多时候，与朋友或同事发生的一些大的矛盾或分歧在最起初时也许只是小小的意见不合，而人们为了所谓的“面子”都不愿意退让，怕从此被人看低，最终把小小的不合演变成了不可收拾的争端，两败俱伤。如果当初懂得让步，就能够避免之后的若干麻烦。正所谓“忍一时风平浪静，退一步海阔天空”。  　　古时某人在朝为官，一天突然接到老家书信。折开一看，原来是家人与邻居发生争执，起因是隔开两家院子的墙塌了，重新砌墙时都想多占些地皮而寸土不让。家人于是写信来请他出面说话，以便让邻居退缩。不久，官员的家人收到了盼望已久的回信，里面却只有一首打油诗；千里捎书为打墙，让他三尺又何妨。万里长城今尚在，不见当年秦始皇。家人于是明白了其中的道理，主动往后退三尺，邻居一见也不甘落后，也往后退三尺，于是中间出现了一条六尺宽的故同，可供村民行走。村人后来将胡同命为“仁义胡同”。'',NULL,NULL,NULL,NULL,NULL),(7,7,''李海瑞'',NULL,NULL,''3个人博客，属于我的个人小世界！'',''images/3.jpg'',NULL,''#操作系统#'',7,NULL,3,NULL,''2019-03-04'',NULL,NULL,''潇洒一点，让自己有一个好的心态，做人拿得起，做事放得下。人生在世，有得就有失，有付出就有回报，鱼和熊不能兼掌的。有时你的付出不一定能得到回报，但自己要想明白一些，不要太苛求自己，生命总有它的轮回，上帝是公平的，它对每个人都是一样的垂青。  　　人生苦短，就好好的潇洒走一回吧。  　　快乐一点，珍惜自己的生活，珍惜自己的生命，享受自己的人生，过去的就让它永远的成为过去吧，希望总在未来，做人就快乐一点，让心自由的飞翔，忘记所有的痛与爱，做一个快乐的自己。  　　忘记年龄，不要让自己的年龄成为自己变老的理由，不管我们多老，只要有一个好的心理，只要我们自己不觉得老，别人怎么看是他们的事。'',NULL,NULL,NULL,NULL,NULL),(8,8,''李海瑞'',NULL,NULL,''3如何快速建立自己的个人博客网站'',''images/4.jpg'',NULL,''#原创#'',3,NULL,3,NULL,''2019-03-05'',NULL,NULL,''别总是拿自己的不幸来博取他人的同情，时间久了会让人反感的，会让别人感到你很龌龊，不如做出点什么让别人尤其是伤害你的人来崇拜你。  　　心情不好了，你可以哭泣，不过哭过之后记得擦干眼泪继续朝着你的目标走。  　　别人对你的帮助要学会说谢谢，别人对你的付出要学会回报，不要把别人对你的好当做是一种理所应当的，没人欠你的。'',NULL,NULL,NULL,NULL,NULL),(9,9,''李海瑞'',NULL,NULL,''3我是怎么评价自己的？'',''images/1.jpg'',NULL,''#IDEA#/#开发工具#/#eclipse#'',3,NULL,1,NULL,''2019-03-06'',NULL,NULL,''很多时候，与朋友或同事发生的一些大的矛盾或分歧在最起初时也许只是小小的意见不合，而人们为了所谓的“面子”都不愿意退让，怕从此被人看低，最终把小小的不合演变成了不可收拾的争端，两败俱伤。如果当初懂得让步，就能够避免之后的若干麻烦。正所谓“忍一时风平浪静，退一步海阔天空”。  　　古时某人在朝为官，一天突然接到老家书信。折开一看，原来是家人与邻居发生争执，起因是隔开两家院子的墙塌了，重新砌墙时都想多占些地皮而寸土不让。家人于是写信来请他出面说话，以便让邻居退缩。不久，官员的家人收到了盼望已久的回信，里面却只有一首打油诗；千里捎书为打墙，让他三尺又何妨。万里长城今尚在，不见当年秦始皇。家人于是明白了其中的道理，主动往后退三尺，邻居一见也不甘落后，也往后退三尺，于是中间出现了一条六尺宽的故同，可供村民行走。村人后来将胡同命为“仁义胡同”。'',NULL,NULL,NULL,NULL,NULL),(10,10,''李海瑞'',NULL,NULL,''3怎样才算一个合格的程序员'',''images/2.jpg'',NULL,''#原创#'',3,NULL,1,NULL,''2019-03-07'',NULL,NULL,''一些事情争或不争并不会对我们的生活甚至整个人生有什么影响，这时我们不妨大度一些，退让一些。  　　很多时候，与朋友或同事发生的一些大的矛盾或分歧在最起初时也许只是小小的意见不合，而人们为了所谓的“面子”都不愿意退让，怕从此被人看低，最终把小小的不合演变成了不可收拾的争端，两败俱伤。如果当初懂得让步，就能够避免之后的若干麻烦。正所谓“忍一时风平浪静，退一步海阔天空”。'',NULL,NULL,NULL,NULL,NULL),(11,11,''李海瑞'',NULL,NULL,''3职业发展何去何从？'',''images/3.jpg'',NULL,''#原创#'',3,NULL,1,NULL,''2019-03-08'',NULL,NULL,''为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。'',NULL,NULL,NULL,NULL,NULL),(12,12,''李海瑞'',NULL,NULL,''3为人处事，遵循一个“妙”字！'',''images/4.jpg'',NULL,''#原创#'',3,NULL,1,NULL,''2019-03-09'',NULL,NULL,''很多时候，与朋友或同事发生的一些大的矛盾或分歧在最起初时也许只是小小的意见不合，而人们为了所谓的“面子”都不愿意退让，怕从此被人看低，最终把小小的不合演变成了不可收拾的争端，两败俱伤。如果当初懂得让步，就能够避免之后的若干麻烦。正所谓“忍一时风平浪静，退一步海阔天空”。  　　古时某人在朝为官，一天突然接到老家书信。折开一看，原来是家人与邻居发生争执，起因是隔开两家院子的墙塌了，重新砌墙时都想多占些地皮而寸土不让。家人于是写信来请他出面说话，以便让邻居退缩。不久，官员的家人收到了盼望已久的回信，里面却只有一首打油诗；千里捎书为打墙，让他三尺又何妨。万里长城今尚在，不见当年秦始皇。家人于是明白了其中的道理，主动往后退三尺，邻居一见也不甘落后，也往后退三尺，于是中间出现了一条六尺宽的故同，可供村民行走。村人后来将胡同命为“仁义胡同”。'',NULL,NULL,NULL,NULL,NULL),(13,13,''李海瑞'',NULL,NULL,''2个人博客，属于我的个人小世界！'',''images/1.jpg'',NULL,''#原创#'',7,NULL,1,NULL,''2019-03-04'',NULL,NULL,''不要去报复任何人，那样只会两败俱伤，尽量用法律手段来解决。\''<br/>\''时间会毫不留情的把一切毫无痕迹的带走，留给我们的只是回忆！谁也没有能力留住自己想要的，赶走不喜欢的。我们只有学会珍惜、满足和面对。  　　人总在不知不觉中伤害着别人，同时也在不知不觉中被别人伤害着。  　　心情再坏也别忘记对他人微笑，还是那句话，没人欠你的。  　　用行动向所有人证明自己（行动胜过言语）虽然要付出很多却是最令人信服的。  　　凡事都有两面，有好也有坏，有喜也有悲，是好是坏，是悲是喜这就要看你站在什么样的角度来看待这件事了！'',NULL,NULL,NULL,NULL,NULL),(14,14,''李海瑞'',NULL,NULL,''2如何快速建立自己的个人博客网站'',''images/2.jpg'',NULL,''#原创#'',2,NULL,3,NULL,''2019-03-05'',NULL,NULL,''曾有一个妇人，经常为生活中一些琐碎的小事情生气。她也知道自己这样不好，却总也打不开这个心结，便去求一位高僧为自己谈禅说道，解开心结。高僧听了他的讲述，一言不发地把她领到一间禅房中。锁上门就走了。妇人气得大骂。骂了许久，高僧也不理会。妇人又开始哀求，高僧仍置之不理。妇人终于沉默了。这时高僧在门外问她；“你还生气吗？”妇人说；“我在对自己生气，我怎么会到这地方来受这份罪？”“连自己都不原谅的人怎么能心如止水？”高僧佛袖而去。过了一会而高僧又来问她；“还生气吗？”“不生气了”妇人说。“为什么”“气也没有办法呀。”“你的气并未消，还压在心理，爆发后将会更加剧烈。”高僧又离开了。高僧第三次来到门前，妇人告诉他；“我不生气了，因为不值得气。”“既然衡量值不值得，可见心中还是有气。”高僧笑道。当高僧的身影迎着夕阳立在门外时，妇人问高僧；“大师，什么是气？”高僧将手中的茶水倾洒于地，妇人视之良久，顿悟，叩谢而去。'',NULL,NULL,NULL,NULL,NULL),(15,15,''李海瑞'',NULL,NULL,''2我是怎么评价自己的？'',''images/3.jpg'',NULL,''#原创#/#开发工具#'',2,NULL,5,NULL,''2019-03-06'',NULL,NULL,''古时某人在朝为官，一天突然接到老家书信。折开一看，原来是家人与邻居发生争执，起因是隔开两家院子的墙塌了，重新砌墙时都想多占些地皮而寸土不让。家人于是写信来请他出面说话，以便让邻居退缩。不久，官员的家人收到了盼望已久的回信，里面却只有一首打油诗；千里捎书为打墙，让他三尺又何妨。万里长城今尚在，不见当年秦始皇。家人于是明白了其中的道理，主动往后退三尺，邻居一见也不甘落后，也往后退三尺，于是中间出现了一条六尺宽的故同，可供村民行走。村人后来将胡同命为“仁义胡同”。  　　可见，一些事情争还是不争并不会对我们的生活甚至整个人生有什么影响，这时我们不妨大度一些，退让一些。'',NULL,NULL,NULL,NULL,NULL),(16,16,''李海瑞'',NULL,NULL,''2怎样才算一个合格的程序员'',''images/4.jpg'',NULL,''#原创#/#eclipse#'',2,NULL,4,NULL,''2019-03-07'',NULL,NULL,''潇洒一点，让自己有一个好的心态，做人拿得起，做事放得下。人生在世，有得就有失，有付出就有回报，鱼和熊不能兼掌的。有时你的付出不一定能得到回报，但自己要想明白一些，不要太苛求自己，生命总有它的轮回，上帝是公平的，它对每个人都是一样的垂青。  　　人生苦短，就好好的潇洒走一回吧。  　　快乐一点，珍惜自己的生活，珍惜自己的生命，享受自己的人生，过去的就让它永远的成为过去吧，希望总在未来，做人就快乐一点，让心自由的飞翔，忘记所有的痛与爱，做一个快乐的自己。  　　忘记年龄，不要让自己的年龄成为自己变老的理由，不管我们多老，只要有一个好的心理，只要我们自己不觉得老，别人怎么看是他们的事。'',NULL,NULL,NULL,NULL,NULL),(17,17,''李海瑞'',NULL,NULL,''2职业发展何去何从？'',''images/1.jpg'',NULL,''#原创#'',2,NULL,5,NULL,''2019-03-08'',NULL,NULL,''不要去报复任何人，那样只会两败俱伤，尽量用法律手段来解决。\''<br/>\''时间会毫不留情的把一切毫无痕迹的带走，留给我们的只是回忆！谁也没有能力留住自己想要的，赶走不喜欢的。我们只有学会珍惜、满足和面对。  　　人总在不知不觉中伤害着别人，同时也在不知不觉中被别人伤害着。  　　心情再坏也别忘记对他人微笑，还是那句话，没人欠你的。  　　用行动向所有人证明自己（行动胜过言语）虽然要付出很多却是最令人信服的。  　　凡事都有两面，有好也有坏，有喜也有悲，是好是坏，是悲是喜这就要看你站在什么样的角度来看待这件事了！'',NULL,NULL,NULL,NULL,NULL),(18,18,''李海瑞'',NULL,NULL,''2为人处事，遵循一个“妙”字！'',''images/2.jpg'',NULL,''#eclipse#/#设计模式#/#点滴生活#/#感悟#/#当下时光#'',2,NULL,4,NULL,''2019-03-09'',NULL,NULL,''古时某人在朝为官，一天突然接到老家书信。折开一看，原来是家人与邻居发生争执，起因是隔开两家院子的墙塌了，重新砌墙时都想多占些地皮而寸土不让。家人于是写信来请他出面说话，以便让邻居退缩。不久，官员的家人收到了盼望已久的回信，里面却只有一首打油诗；千里捎书为打墙，让他三尺又何妨。万里长城今尚在，不见当年秦始皇。家人于是明白了其中的道理，主动往后退三尺，邻居一见也不甘落后，也往后退三尺，于是中间出现了一条六尺宽的故同，可供村民行走。村人后来将胡同命为“仁义胡同”。  　　可见，一些事情争还是不争并不会对我们的生活甚至整个人生有什么影响，这时我们不妨大度一些，退让一些。'',NULL,NULL,NULL,NULL,NULL),(19,19,''李海瑞'',NULL,NULL,''4个人博客，属于我的个人小世界！'',''images/3.jpg'',NULL,''#原创#/#爱情地铁#'',7,NULL,5,NULL,''2019-03-04'',NULL,NULL,''有个朋友，财富不是一个人一生的朋友，而朋友有时则是你一生的财富，人人都希望有朋友，没有朋友的人是可怜的，但有一个真心的朋友是很难的，朋友不在多而在精，所谓“人生得一知己足以”“君子之交淡如水”就是这个道理吧。  　　记住新生活准则：  　　做一个快乐的人！做一个幸福的人！做一个知足的人！'',NULL,NULL,NULL,NULL,NULL),(20,20,''李海瑞'',NULL,NULL,''4如何快速建立自己的个人博客网站'',''images/4.jpg'',NULL,''#Map#/#技术#/#数据类型#'',4,NULL,5,NULL,''2019-03-05'',NULL,NULL,''曾有一个妇人，经常为生活中一些琐碎的小事情生气。她也知道自己这样不好，却总也打不开这个心结，便去求一位高僧为自己谈禅说道，解开心结。高僧听了他的讲述，一言不发地把她领到一间禅房中。锁上门就走了。妇人气得大骂。骂了许久，高僧也不理会。妇人又开始哀求，高僧仍置之不理。妇人终于沉默了。这时高僧在门外问她；“你还生气吗？”妇人说；“我在对自己生气，我怎么会到这地方来受这份罪？”“连自己都不原谅的人怎么能心如止水？”高僧佛袖而去。过了一会而高僧又来问她；“还生气吗？”“不生气了”妇人说。“为什么”“气也没有办法呀。”“你的气并未消，还压在心理，爆发后将会更加剧烈。”高僧又离开了。高僧第三次来到门前，妇人告诉他；“我不生气了，因为不值得气。”“既然衡量值不值得，可见心中还是有气。”高僧笑道。当高僧的身影迎着夕阳立在门外时，妇人问高僧；“大师，什么是气？”高僧将手中的茶水倾洒于地，妇人视之良久，顿悟，叩谢而去。'',NULL,NULL,NULL,NULL,NULL),(21,21,''李海瑞'',NULL,NULL,''4我是怎么评价自己的？'',''images/1.jpg'',NULL,''#原创#/#程序员#/#技术联盟#'',4,NULL,3,NULL,''2019-03-06'',NULL,NULL,''谁都没有能力去改写历史，我们要做的就是把握现在，展望未来，接受生活带给你的种种考验。  　　人生的每个抉择都像是一个赌局，输赢都是自己的。不同的是赌注的大小，选择了就没有反悔的机会。  　　败给谁都不能败给自己，如果败给了自己，那么，你的人生也就彻彻底底的败了。  　　我们要学会适当的采纳别人的意见。  　　人需要经常自我反省，善于学习，如果仅仅是在自己的固定方式下一意孤行，其实是挺悲哀的。'',NULL,NULL,NULL,NULL,NULL),(22,22,''李海瑞'',NULL,NULL,''4怎样才算一个合格的程序员'',''images/2.jpg'',NULL,''#原创#'',4,NULL,4,NULL,''2019-03-07'',NULL,NULL,''忘记名利，名利是身外之外，我们都是平凡的人，每个人都希望有自己的一份名，也有自己的一份利，遇到不开心的事，总以为上帝对自己是不公平的，其实我一直以为，简单平凡的生活才是最大的幸福。  　　忘记怨恨，人活在世上，不可能没有爱恨，也不可能没有矛盾，但只要你好好的想想，那个人值得你恨吗？那个人值得你爱吗？那个人值得你去怨吗？我只能告诉你，没必要浪费自己的宝贵时间去憎恨一个不值得的人？'',NULL,NULL,NULL,NULL,NULL),(23,23,''李海瑞'',NULL,NULL,''4职业发展何去何从？'',''images/3.jpg'',NULL,''#原创#/#感悟人生#'',4,NULL,5,NULL,''2019-03-08'',NULL,NULL,''有个朋友，财富不是一个人一生的朋友，而朋友有时则是你一生的财富，人人都希望有朋友，没有朋友的人是可怜的，但有一个真心的朋友是很难的，朋友不在多而在精，所谓“人生得一知己足以”“君子之交淡如水”就是这个道理吧。  　　记住新生活准则：  　　做一个快乐的人！做一个幸福的人！做一个知足的人！'',NULL,NULL,NULL,NULL,NULL),(24,24,''李海瑞'',NULL,NULL,''4为人处事，遵循一个“妙”字！'',''images/4.jpg'',NULL,''#设计模式#'',4,NULL,2,NULL,''2019-03-09'',NULL,NULL,''如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... '',NULL,NULL,NULL,NULL,NULL),(25,25,''李海瑞'',NULL,NULL,''5个人博客，属于我的个人小世界！'',''images/1.jpg'',NULL,''#原创#/#随笔#'',7,NULL,4,NULL,''2019-03-04'',NULL,NULL,''不要去报复任何人，那样只会两败俱伤，尽量用法律手段来解决。\''<br/>\''时间会毫不留情的把一切毫无痕迹的带走，留给我们的只是回忆！谁也没有能力留住自己想要的，赶走不喜欢的。我们只有学会珍惜、满足和面对。  　　人总在不知不觉中伤害着别人，同时也在不知不觉中被别人伤害着。  　　心情再坏也别忘记对他人微笑，还是那句话，没人欠你的。  　　用行动向所有人证明自己（行动胜过言语）虽然要付出很多却是最令人信服的。  　　凡事都有两面，有好也有坏，有喜也有悲，是好是坏，是悲是喜这就要看你站在什么样的角度来看待这件事了！'',NULL,NULL,NULL,NULL,NULL),(26,26,''李海瑞'',NULL,NULL,''5如何快速建立自己的个人博客网站'',''images/2.jpg'',NULL,''#原创#'',5,NULL,1,NULL,''2019-03-05'',NULL,NULL,''一些事情争或不争并不会对我们的生活甚至整个人生有什么影响，这时我们不妨大度一些，退让一些。  　　很多时候，与朋友或同事发生的一些大的矛盾或分歧在最起初时也许只是小小的意见不合，而人们为了所谓的“面子”都不愿意退让，怕从此被人看低，最终把小小的不合演变成了不可收拾的争端，两败俱伤。如果当初懂得让步，就能够避免之后的若干麻烦。正所谓“忍一时风平浪静，退一步海阔天空”。'',NULL,NULL,NULL,NULL,NULL),(27,27,''李海瑞'',NULL,NULL,''5我是怎么评价自己的？'',''images/3.jpg'',NULL,''#老干部#/#青春片刻#'',5,NULL,2,NULL,''2019-03-06'',NULL,NULL,''别总是拿自己的不幸来博取他人的同情，时间久了会让人反感的，会让别人感到你很龌龊，不如做出点什么让别人尤其是伤害你的人来崇拜你。  　　心情不好了，你可以哭泣，不过哭过之后记得擦干眼泪继续朝着你的目标走。  　　别人对你的帮助要学会说谢谢，别人对你的付出要学会回报，不要把别人对你的好当做是一种理所应当的，没人欠你的。'',NULL,NULL,NULL,NULL,NULL),(28,28,''李海瑞'',NULL,NULL,''5怎样才算一个合格的程序员'',''images/4.jpg'',NULL,''#原创#'',5,NULL,3,NULL,''2019-03-07'',NULL,NULL,''人生中有太多的过客，不管你有多么的不舍，过客始终都是过客，总有一天会离开的，你要学会放手，别等到变成一种伤害再去后悔。记住：是你的跑不了，不是你的再怎么挽留也没用。'',NULL,NULL,NULL,NULL,NULL),(29,29,''李海瑞'',NULL,NULL,''5职业发展何去何从？'',''images/1.jpg'',NULL,''#咖啡屋#/#励志故事#'',5,NULL,2,NULL,''2019-03-08'',NULL,NULL,''为了挨打轻一些，问我哪里来的，我瞎说了一个说那个谁家的，结果，打得更凶。最后事情还原了真相，我妈说，你要说说奶奶家的，都不会打你了。从此以后，我知道撒谎是会付出更惨痛的代价的，我不再撒谎，也不喜欢爱撒谎的人。'',NULL,NULL,NULL,NULL,NULL),(30,30,''李海瑞'',NULL,NULL,''5为人处事，遵循一个“妙”字！'',''images/2.jpg'',NULL,''#原创#'',5,NULL,2,NULL,''2019-03-09'',NULL,NULL,''如图，要实现上图效果，我采用如下方法：1、首先在数据库模型，增加字段，分别是图片2，图片3。2、增加标签模板，用if，else if 来判断，输出。思路已打开，样式调用就可以多样化啦！... '',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `artical_categories` */

DROP TABLE IF EXISTS `artical_categories`;

CREATE TABLE `artical_categories` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ''编号'',
  `CATEGORY_NAME` varchar(50) DEFAULT NULL COMMENT ''分类名称'',
  `IS_SHOW` varchar(1) DEFAULT NULL COMMENT ''是否首页展示'',
  `SHOW_ORDER` int(11) DEFAULT NULL COMMENT ''展示序号'',
  `ARTICAL_COUNT` int(11) DEFAULT NULL COMMENT ''文章数量'',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT=''分类'';

/*Data for the table `artical_categories` */

insert  into `artical_categories`(`ID`,`CATEGORY_NAME`,`IS_SHOW`,`SHOW_ORDER`,`ARTICAL_COUNT`) values (1,''JAVA基础知识'',NULL,NULL,NULL),(2,''SpringBoot'',''Y'',3,NULL),(3,''微服务架构'',''Y'',2,NULL),(4,''分布式缓存技术'',''Y'',1,NULL),(5,''大数据'',''Y'',4,NULL),(6,''操作系统'',NULL,NULL,NULL);

/*Table structure for table `artical_topics` */

DROP TABLE IF EXISTS `artical_topics`;

CREATE TABLE `artical_topics` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ''专题编号'',
  `TOPIC_NAME` varchar(50) DEFAULT NULL COMMENT ''专题名称'',
  `ARTICAL_COUNT` int(11) DEFAULT NULL COMMENT ''内容数量'',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT=''专题'';

/*Data for the table `artical_topics` */

insert  into `artical_topics`(`ID`,`TOPIC_NAME`,`ARTICAL_COUNT`) values (1,''专题1'',0),(2,''专题2'',0),(3,''专题3'',0),(4,''专题4'',0);

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ''序号'',
  `BOOK_ID` int(11) NOT NULL COMMENT ''书籍编号'',
  `BOOK_NAME` varchar(255) DEFAULT NULL COMMENT ''书籍名称'',
  `AUTHOR` varchar(255) DEFAULT NULL COMMENT ''作者'',
  `PUBLISH_DATE` varchar(20) DEFAULT NULL COMMENT ''发布日期'',
  `URL` varchar(255) DEFAULT NULL COMMENT ''书籍所在网络URL'',
  `LOCAL_PATH` varchar(255) DEFAULT NULL COMMENT ''本地存放地址'',
  `ADD_DATE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`ID`,`BOOK_ID`,`BOOK_NAME`,`AUTHOR`,`PUBLISH_DATE`,`URL`,`LOCAL_PATH`,`ADD_DATE`) values (1,1,''EasyUI+1.3中文帮助手册'',NULL,NULL,NULL,NULL,''2019-02-28''),(2,2,''J2EE API 帮助文档'',NULL,NULL,NULL,NULL,''2019-02-28''),(3,3,''javascript正则表达式'',NULL,NULL,NULL,NULL,''2019-02-28''),(4,4,''jQuery[1].validate.js+API中文'',NULL,NULL,NULL,NULL,''2019-02-28''),(5,5,''JSTL标签说明文档'',NULL,NULL,NULL,NULL,''2019-02-28''),(6,6,''JDK_API_1_6_zh_CN帮助文档(中文版)'',NULL,NULL,NULL,NULL,''2019-02-28''),(7,7,''Struts2.0中文教程'',NULL,NULL,NULL,NULL,''2019-02-28''),(8,8,''Thinking.in.Java'',NULL,NULL,NULL,NULL,''2019-02-28''),(9,9,''w3cschool菜鸟教程20141021'',NULL,NULL,NULL,NULL,''2019-02-28''),(10,10,''EasyUI+1.3中文帮助手册'',NULL,NULL,NULL,NULL,''2019-02-28'');

/*Table structure for table `my_info` */

DROP TABLE IF EXISTS `my_info`;

CREATE TABLE `my_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ''编号'',
  `NICKNAME` varchar(30) DEFAULT NULL COMMENT ''网名'',
  `WEBNAME` varchar(40) DEFAULT NULL COMMENT ''网站名称'',
  `OCCUPATION` varchar(80) DEFAULT NULL COMMENT ''职业'',
  `ADDRESS` varchar(120) DEFAULT NULL COMMENT ''地址'',
  `EMAIL` varchar(60) DEFAULT NULL COMMENT ''邮箱'',
  `WEBSITE` varchar(200) DEFAULT NULL COMMENT ''网址'',
  `QQ` varchar(20) DEFAULT NULL COMMENT ''QQ号码'',
  `WECHAT` varchar(30) DEFAULT NULL COMMENT ''微信号'',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT=''个人信息'';

/*Data for the table `my_info` */

insert  into `my_info`(`ID`,`NICKNAME`,`WEBNAME`,`OCCUPATION`,`ADDRESS`,`EMAIL`,`WEBSITE`,`QQ`,`WECHAT`) values (1,''骑鱼的猫 | 老干部'',''老干部的咖啡屋'',''程序员、软件工程师、艺术家'',''陕西省-西安市'',''LIHAIRUIZONE@SINA.COM'',''WWW.NERSSIA.CN'',NULL,NULL);

/*Table structure for table `nav_index` */

DROP TABLE IF EXISTS `nav_index`;

CREATE TABLE `nav_index` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ''编号'',
  `NAME` varchar(50) DEFAULT NULL COMMENT ''名称'',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT=''首页索引'';

/*Data for the table `nav_index` */

insert  into `nav_index`(`ID`,`NAME`) values (1,''个人博客''),(2,''工作日记''),(3,''心路历程''),(4,''我的原创''),(5,''技术专题'');

/*Table structure for table `online_tools` */

DROP TABLE IF EXISTS `online_tools`;

CREATE TABLE `online_tools` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT ''序号'',
  `TOOL_ID` int(11) DEFAULT NULL COMMENT ''工具编号'',
  `TOOL_NAME` varchar(50) DEFAULT NULL COMMENT ''工具名称'',
  `URL` varchar(255) DEFAULT NULL COMMENT ''网址'',
  `INTRODUCE` longtext COMMENT ''工具介绍'',
  `ADD_DATE` varchar(20) DEFAULT NULL COMMENT ''添加日期'',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `online_tools` */

insert  into `online_tools`(`ID`,`TOOL_ID`,`TOOL_NAME`,`URL`,`INTRODUCE`,`ADD_DATE`) values (1,NULL,''JSON格式转款器'',NULL,NULL,''2019-03-08''),(2,NULL,''组织机构代码在线生成器'',NULL,NULL,''2019-03-08''),(3,NULL,''HTML转PDF在线工具'',NULL,NULL,''2019-03-08''),(4,NULL,''SpringBoot项目快速生成工具'',NULL,NULL,''2019-03-08''),(5,NULL,''屏幕拾色器'',NULL,NULL,''2019-03-08'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
