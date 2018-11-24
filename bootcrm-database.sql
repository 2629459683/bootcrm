-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.20-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 boot_crm 的数据库结构
DROP DATABASE IF EXISTS `boot_crm`;
CREATE DATABASE IF NOT EXISTS `boot_crm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `boot_crm`;

-- 导出  表 boot_crm.base_dict 结构
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE IF NOT EXISTS `base_dict` (
  `dict_id` varchar(32) NOT NULL DEFAULT '',
  `dict_type_code` varchar(10) NOT NULL DEFAULT '',
  `dict_type_name` varchar(50) NOT NULL DEFAULT '',
  `dict_item_name` varchar(50) NOT NULL DEFAULT '',
  `dict_item_code` varchar(10) NOT NULL DEFAULT '',
  `dict_sort` int(10) NOT NULL,
  `dict_enable` char(1) NOT NULL DEFAULT '',
  `dict_memo` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  boot_crm.base_dict 的数据：~9 rows (大约)
DELETE FROM `base_dict`;
/*!40000 ALTER TABLE `base_dict` DISABLE KEYS */;
INSERT INTO `base_dict` (`dict_id`, `dict_type_code`, `dict_type_name`, `dict_item_name`, `dict_item_code`, `dict_sort`, `dict_enable`, `dict_memo`) VALUES
	('1', '002', '客户来源', '网络营销', '', 1, '1', ''),
	('2', '002', '客户来源', '电话营销', '', 1, '1', ''),
	('3', '001', '客户所属行业', '教育培训', '', 1, '1', ''),
	('4', '001', '客户所属行业', '对外贸易', '', 1, '1', ''),
	('5', '001', '客户所属行业', '电子商务', '', 1, '1', ''),
	('6', '001', '客户所属行业', '酒店旅游', '', 1, '1', ''),
	('7', '001', '客户所属行业', '房地产', '', 1, '1', ''),
	('8', '006', '客户级别', 'VIP客户', '', 1, '1', ''),
	('9', '006', '客户级别', '普通客户', '', 1, '1', '');
/*!40000 ALTER TABLE `base_dict` ENABLE KEYS */;

-- 导出  表 boot_crm.customer 结构
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `cust_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(50) NOT NULL DEFAULT '',
  `cust_user_id` int(11) unsigned NOT NULL,
  `cust_create_id` int(10) unsigned NOT NULL,
  `cust_source` varchar(50) NOT NULL DEFAULT '',
  `cust_industry` varchar(50) NOT NULL DEFAULT '',
  `cust_level` varchar(32) NOT NULL DEFAULT '',
  `cust_linkman` varchar(50) NOT NULL DEFAULT '',
  `cust_phone` varchar(64) NOT NULL DEFAULT '',
  `cust_mobile` varchar(16) NOT NULL DEFAULT '',
  `cust_zipcode` varchar(10) NOT NULL DEFAULT '',
  `cust_address` varchar(100) NOT NULL DEFAULT '',
  `cust_createtime` datetime NOT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- 正在导出表  boot_crm.customer 的数据：~4 rows (大约)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`cust_id`, `cust_name`, `cust_user_id`, `cust_create_id`, `cust_source`, `cust_industry`, `cust_level`, `cust_linkman`, `cust_phone`, `cust_mobile`, `cust_zipcode`, `cust_address`, `cust_createtime`) VALUES
	(1, '小张', 15, 1, '1', '3', '9', '1', '010-88888887', '13848399998', '430000', '湖北武汉光谷大道', '2018-10-09 13:51:31'),
	(2, '小韩', 16, 1, '2', '5', '8', '1', '010-88888888', '13848399998', '430000', '', '2018-10-11 10:50:51'),
	(3, '小李', 17, 1, '1', '3', '9', '1', '027-88888887', '13608888888', '430000', '', '2018-10-11 00:00:00'),
	(5, '王五', 18, 1, '1', '3', '8', '1', '027-88888888', '13333333333', '430000', '武汉', '2018-10-16 14:09:40'),
	(6, '王四', 1, 1, '1', '6', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(7, '赵三', 1, 1, '1', '3', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(8, '李四', 1, 1, '2', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(9, '王三', 1, 1, '1', '7', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(10, '赵三', 1, 1, '2', '3', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(11, '李四', 1, 1, '1', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(12, '李四', 1, 1, '1', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(13, '王三', 1, 1, '2', '4', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(14, '赵六', 1, 1, '1', '4', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:49'),
	(15, '张三', 1, 1, '1', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(16, '赵四', 1, 1, '1', '4', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(17, '李四', 1, 1, '1', '7', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(18, '王四', 1, 1, '1', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(19, '李三', 1, 1, '1', '5', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(20, '赵五', 1, 1, '2', '5', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(21, '赵六', 1, 1, '1', '5', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(22, '李三', 1, 1, '2', '4', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(23, '王三', 1, 1, '1', '6', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(24, '张四', 1, 1, '2', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(25, '王三', 1, 1, '2', '5', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(26, '李五', 1, 1, '2', '7', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(27, '王三', 1, 1, '2', '7', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(28, '赵三', 1, 1, '1', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(29, '赵五', 1, 1, '2', '4', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(30, '李六', 1, 1, '1', '7', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(31, '张三', 1, 1, '1', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(32, '赵四', 1, 1, '1', '4', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(33, '李三', 1, 1, '2', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(34, '王四', 1, 1, '1', '5', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(35, '赵四', 1, 1, '2', '7', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(36, '李六', 1, 1, '1', '4', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(37, '王六', 1, 1, '2', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(38, '张五', 1, 1, '2', '6', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(39, '王四', 1, 1, '1', '4', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(40, '张四', 1, 1, '1', '5', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(41, '李五', 1, 1, '1', '3', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(42, '赵三', 1, 1, '1', '4', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(43, '王三', 1, 1, '1', '4', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(44, '李四', 1, 1, '1', '4', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(45, '张六', 1, 1, '1', '7', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(46, '张五', 1, 1, '2', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(47, '赵三', 1, 1, '1', '4', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(48, '张三', 1, 1, '1', '6', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(49, '张五', 1, 1, '2', '5', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(50, '李三', 1, 1, '1', '5', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(51, '王四', 1, 1, '2', '4', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(52, '赵五', 1, 1, '2', '7', '9', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(53, '王六', 1, 1, '1', '7', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(54, '王四', 1, 1, '1', '7', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50'),
	(55, '李六', 1, 1, '2', '3', '8', '1', '027-83625877', '1360000000', '430000', '湖北武汉', '2018-10-16 14:47:50');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 导出  表 boot_crm.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `user_id` int(32) unsigned NOT NULL AUTO_INCREMENT,
  `user_code` varchar(32) NOT NULL DEFAULT '',
  `user_name` varchar(50) NOT NULL DEFAULT '',
  `user_password` varchar(32) NOT NULL DEFAULT '',
  `user_state` varchar(1) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  boot_crm.sys_user 的数据：~0 rows (大约)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`user_id`, `user_code`, `user_name`, `user_password`, `user_state`) VALUES
	(1, 'admin', '管理员', '123456', '1');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;