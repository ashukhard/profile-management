/*
MySQL Database - profile_management_db
*********************************************************************
*/

CREATE DATABASE /*!32312 IF NOT EXISTS*/`profile_management_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `profile_management_db`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birthdate` datetime DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `user_address` */

DROP TABLE IF EXISTS `user_address`;

CREATE TABLE `user_address` (
  `user_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`address_id`),
  KEY `FKdaaxogn1ss81gkcsdn05wi6jp` (`address_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`name`,`type`) values (1,'ay@gmail.com',2),(2,'4, Corell St., Melbourne',0);

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'ADMIN'),(2,'USER');

/*Data for the table `user` */

insert  into `user`(`id`,`birthdate`,`firstname`,`lastname`,`password`,`username`) values (1,'1990-02-20 09:45:38','testFN','testLN','$2a$10$9PmsNNON9/LXMGC/vUOrqun5AP.RbHNDsmBa51zV7c6QSaGZVHrli','admin');

/*Data for the table `user_address` */

insert  into `user_address`(`user_id`,`address_id`) values (1,1),(1,2);

/*Data for the table `user_roles` */

insert  into `user_roles`(`user_id`,`role_id`) values (1,1);
