/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.25-log : Database - selectcourse
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`selectcourse` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `selectcourse`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(20) DEFAULT NULL,
  `tid` int(20) DEFAULT NULL,
  `message` varchar(40) DEFAULT NULL,
  `selectednum` int(11) DEFAULT NULL,
  `maxnum` int(11) DEFAULT NULL COMMENT '最大容纳人数',
  `status` int(11) DEFAULT NULL,
  `begintime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `credit` int(11) DEFAULT NULL COMMENT '学分',
  `hours` int(11) DEFAULT NULL COMMENT '学时',
  `category` varchar(20) DEFAULT NULL COMMENT '类别',
  `departmentid` int(11) DEFAULT NULL COMMENT '开设院系',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`cid`,`coursename`,`tid`,`message`,`selectednum`,`maxnum`,`status`,`begintime`,`endtime`,`credit`,`hours`,`category`,`departmentid`) values (2,'java',1,'java程序设计',NULL,NULL,1,'2019-07-01','2019-07-19',5,NULL,'编程',1);

/*Table structure for table `leavemessage` */

DROP TABLE IF EXISTS `leavemessage`;

CREATE TABLE `leavemessage` (
  `authorid` int(11) DEFAULT NULL COMMENT '发布者',
  `replyid` int(11) DEFAULT NULL COMMENT '回复者',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT '0' COMMENT '状态',
  `content` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `leavemessage` */

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tittle` varchar(40) DEFAULT NULL,
  `content` varchar(120) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `authorid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

/*Table structure for table `privilege` */

DROP TABLE IF EXISTS `privilege`;

CREATE TABLE `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilegename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `privilege` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`rolename`) values (1,'student'),(2,'teacher'),(3,'admin');

/*Table structure for table `rolpriv` */

DROP TABLE IF EXISTS `rolpriv`;

CREATE TABLE `rolpriv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolId` int(11) DEFAULT NULL,
  `privId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rolpriv` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL COMMENT '学号',
  `username` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `sex` varchar(20) NOT NULL,
  `the_Class` varchar(20) DEFAULT NULL,
  `college` varchar(20) DEFAULT NULL,
  `head` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`sid`,`username`,`password`,`sex`,`the_Class`,`college`,`head`) values (1,1504012015,'刘先生','123','man','计本1502','计算机科学与技术',NULL),(2,1132030132,'张三','123','man','计本1501','计算机科学与技术',NULL),(3,1237242343,'lisi','123','man','汉本1602','汉语言文学',NULL),(4,23435435,'王五','123','woman','汉本1302','汉语言文学',NULL),(5,2334342,'xiaoming','123','man','新本1202','汉语言文学',NULL),(6,234234535,'jiajia','123','woman','风景1302','风景园林',NULL);

/*Table structure for table `studentcourse` */

DROP TABLE IF EXISTS `studentcourse`;

CREATE TABLE `studentcourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) DEFAULT NULL,
  `courseid` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studentcourse` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `departmentid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`name`,`username`,`password`,`sex`,`title`,`departmentid`) values (1,'李老师','li','123','女','',NULL);

/*Table structure for table `userlogin` */

DROP TABLE IF EXISTS `userlogin`;

CREATE TABLE `userlogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `salt` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `userlogin` */

insert  into `userlogin`(`id`,`username`,`password`,`userid`,`role`,`salt`) values (1,'刘先生','294e4386519cd648fbb876f06fd7fcb1',1504012015,1,'91698a91b32dfbdc81ddbfcd11d76a2a'),(2,'li','16b81a96dc756e64f5348e8f972ea633',1,2,'c43cc333a964f599f1af4fc4d3bf9eb9'),(3,'张三','e372ce92a5606f64f1ab311d0dd39c81',1132030132,1,'f6255630541842ddb37eaa4b310168d8'),(4,'lisi','53f33a55055512236f9b03e022485227',1237242343,1,'773cdba5893a445d83773234b167e7f2'),(5,'王五','f25d1f56d4a4141fb4033f4683826e8d',23435435,1,'3e2ed1b010adf126191afc312e0e32d0'),(6,'xiaoming','52d16240dd58368fc6df14f67a222b20',2334342,1,'169527541c9e8f042c8baf268aa40ebd'),(7,'jiajia','a0db8338e6069d776edd24dd3e051639',234234535,1,'b939e82502166809a2db9e0835295c80');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
