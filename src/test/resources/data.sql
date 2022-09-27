-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 82.209.231.190    Database: coffeeshop
-- ------------------------------------------------------
-- Server version	8.0.25 /*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities`
VALUES ('user', 'ROLE_USER'),
       ('admin', 'ROLE_USER'),
       ('admin', 'ROLE_ADMIN'),
       ('test1', 'ROLE_USER'),
       ('test1', 'ROLE_USER'),
       ('test1', 'ROLE_USER'),
       ('qwer', 'ROLE_USER'),
       ('username1', 'ROLE_USER'),
       ('ipetr', 'ROLE_USER'),
       ('ipetr1', 'ROLE_USER'),
       ('1234 aef ', 'ROLE_USER'),
       ('111', 'ROLE_USER'),
       ('321', 'ROLE_USER'),
       ('user22', 'ROLE_USER'),
       ('atest', 'ROLE_USER'),
       ('ipetr123', 'ROLE_USER'),
       ('testuser321', 'ROLE_USER'),
       ('testuser333', 'ROLE_USER'),
       ('admina', 'ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
;
;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart`
VALUES (83, NULL, '62c96ded1d73b77c1639bed3', 1),
       (84, NULL, '62c96faa21fcaafe5f23b705', 1),
       (85, NULL, '62c96faa21fcaafe5f23b705', 1),
       (86, NULL, '62c970b021fcaafe5f23b706', 1),
       (89, NULL, '62c96faa21fcaafe5f23b705', 1),
       (90, NULL, '62c970b021fcaafe5f23b706', 1),
       (91, NULL, '62c970b021fcaafe5f23b706', 1),
       (92, NULL, '62c970ea21fcaafe5f23b707', 1),
       (93, NULL, '62c96faa21fcaafe5f23b705', 1),
       (164, 'e58540b0-1841-4377-ab76-5ec09224c903', '62c96ded1d73b77c1639bed3', 2),
       (165, 'e58540b0-1841-4377-ab76-5ec09224c903', '62c96faa21fcaafe5f23b705', 1),
       (166, 'e58540b0-1841-4377-ab76-5ec09224c903', '62c970b021fcaafe5f23b706', 5),
       (174, '23bb5a58-8f08-4ada-a5e5-ec2377720a9a', '62c96faa21fcaafe5f23b705', 2),
       (175, '23bb5a58-8f08-4ada-a5e5-ec2377720a9a', '62c970b021fcaafe5f23b706', 2),
       (176, '23bb5a58-8f08-4ada-a5e5-ec2377720a9a', '62c970ea21fcaafe5f23b707', 1),
       (184, '2137ec06-6d64-4006-acd4-37bbe0e777c9', '62c96ded1d73b77c1639bed3', 1),
       (193, 'bcb284ef-2353-4924-bcbf-c05d7c461eb7', '62c96faa21fcaafe5f23b705', 1),
       (194, 'bcb284ef-2353-4924-bcbf-c05d7c461eb7', '62c970b021fcaafe5f23b706', 1),
       (200, 'aff05cef-043c-434a-94b0-da6278a29cd5', '62c96ded1d73b77c1639bed3', 1),
       (201, 'aff05cef-043c-434a-94b0-da6278a29cd5', '62c96faa21fcaafe5f23b705', 1),
       (204, '6a3690e8-3328-4d4e-9be1-2d8da4709aed', '62c96ded1d73b77c1639bed3', 1),
       (205, '6a3690e8-3328-4d4e-9be1-2d8da4709aed', '62c96faa21fcaafe5f23b705', 1),
       (219, '68a396e8-4025-4ba2-9694-69e9ee5c9a7b', '62c96faa21fcaafe5f23b705', 2),
       (224, '68a396e8-4025-4ba2-9694-69e9ee5c9a7b', '62c96ded1d73b77c1639bed3', 1),
       (225, '5bc8db65-01d1-11ed-adb1-b42e99aeb6ff', '62c96ded1d73b77c1639bed3', 3),
       (226, '5bc8db65-01d1-11ed-adb1-b42e99aeb6ff', '62c96faa21fcaafe5f23b705', 1),
       (227, '425e55b3-ee73-40e2-b116-d1118964a802', '62c96faa21fcaafe5f23b705', 1),
       (228, '425e55b3-ee73-40e2-b116-d1118964a802', '62c970b021fcaafe5f23b706', 1),
       (229, '824f8127-0f77-4fb1-9990-21f63cab4f2e', '62c970b021fcaafe5f23b706', 1),
       (230, '824f8127-0f77-4fb1-9990-21f63cab4f2e', '62c96faa21fcaafe5f23b705', 1),
       (231, '824f8127-0f77-4fb1-9990-21f63cab4f2e', '62c970ea21fcaafe5f23b707', 1),
       (235, '7102c289-e7dc-4633-b611-da40ee8cecb0', '62c96ded1d73b77c1639bed3', 1),
       (236, '7102c289-e7dc-4633-b611-da40ee8cecb0', '62c96faa21fcaafe5f23b705', 1),
       (237, '7102c289-e7dc-4633-b611-da40ee8cecb0', '62c970b021fcaafe5f23b706', 1),
       (249, '9d76f228-a918-4c43-98e7-07274e5560f6', '62c96faa21fcaafe5f23b705', 1),
       (250, '9d76f228-a918-4c43-98e7-07274e5560f6', '62c970b021fcaafe5f23b706', 1),
       (251, '9d76f228-a918-4c43-98e7-07274e5560f6', '62c970ea21fcaafe5f23b707', 1),
       (264, '36277e33-718c-4382-a722-385797d79e35', '62c970b021fcaafe5f23b706', 2),
       (265, '36277e33-718c-4382-a722-385797d79e35', '62c96faa21fcaafe5f23b705', 1),
       (266, 'e9ded07c-bf17-451b-95e0-caae54b5c011', '62c96ded1d73b77c1639bed3', 1),
       (276, 'bb2d8fa0-18fa-45af-a874-b5aeb616bd8a', '62c96ded1d73b77c1639bed3', 1),
       (277, '05177229-7e94-4a6c-9662-8134dc680d29', '62c970b021fcaafe5f23b706', 1),
       (278, '05177229-7e94-4a6c-9662-8134dc680d29', '62c970ea21fcaafe5f23b707', 1),
       (279, '05177229-7e94-4a6c-9662-8134dc680d29', '62c96ded1d73b77c1639bed3', 1),
       (280, '97595056-421e-4a85-9f00-d8813b26643a', '62c96faa21fcaafe5f23b705', 1),
       (281, '97595056-421e-4a85-9f00-d8813b26643a', '62c970b021fcaafe5f23b706', 1),
       (285, 'a45f696a-726e-4617-89a2-67586a1b0b6b', '62c96faa21fcaafe5f23b705', 3),
       (286, 'a45f696a-726e-4617-89a2-67586a1b0b6b', '62c970b021fcaafe5f23b706', 1),
       (287, 'a45f696a-726e-4617-89a2-67586a1b0b6b', '62c96ded1d73b77c1639bed3', 2),
       (291, 'ed8e1906-4533-4087-a5e6-989b30aea8b1', '62c970b021fcaafe5f23b706', 2),
       (292, 'ed8e1906-4533-4087-a5e6-989b30aea8b1', '62c970ea21fcaafe5f23b707', 6),
       (294, 'f8755da0-ccff-4782-aaba-8c01fbf9019c', '62c970b021fcaafe5f23b706', 5),
       (295, 'f8755da0-ccff-4782-aaba-8c01fbf9019c', '62c970ea21fcaafe5f23b707', 1),
       (299, '9ac9eeec-678e-4c14-a48f-0b946ef61d02', '62c96ded1d73b77c1639bed3', 6),
       (300, '9ac9eeec-678e-4c14-a48f-0b946ef61d02', '62c96faa21fcaafe5f23b705', 3),
       (301, '314eedaa-7649-4435-8c8c-4de7a7b17ff8', '62c96faa21fcaafe5f23b705', 1),
       (302, '314eedaa-7649-4435-8c8c-4de7a7b17ff8', '62c970b021fcaafe5f23b706', 1),
       (305, 'ac47fbbb-8db7-4246-90e4-824d1432551b', '62c96faa21fcaafe5f23b705', 2),
       (306, '5bc8db65-01d1-11ed-adb1-b42e99aeb6ff', '6305d83902bd6928c2ce2919', 1),
       (307, '183f85fc-422b-4a24-9a7d-5b869637c4ac', '6305d83902bd6928c2ce2919', 1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
;
;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations`
VALUES (1, 'Coffee shop ТЦ Европа', 'улица Сурганова, 57Б', '53.928994, 27.582053'),
       (2, 'Coffee shop ТЦ Галерея', 'проспект Победителей, 9', '53.908743, 27.549018');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
;

INSERT INTO `users`
VALUES ('044d7f87-1d86-11ed-9604-b42e99aeb6ff', 1, '$2a$10$uHtTaGXLGTeSRff0eBXmp.mr18DDg5yhmJxONOuEnFwLwF8BgOfNO', 'user22', 'user'
       , 0, 'masdf@adsf.ee', 0, '1233213'),
       ('0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', 1, '$2a$10$g8YBTr0I12JSr3eHN.flyey/QtYgAAR4Cmi5o8NG2CKPib2jlY/Pq', 'user', 'mike'
       , 10, 'asdf@asd.ss', 0, '375331112323'),
       ('31c5719b-1d5d-11ed-9604-b42e99aeb6ff', 1, '$2a$10$cfG8IitD4Cb5ED6cdM0yV.ZHtzCjPn3v0H9420vYAStR6JcLfmqKS', 'test1', 'mike1'
       , 0, 'asd@adsf.ru', 0, '375334324321'),
       ('32df287e-1d84-11ed-9604-b42e99aeb6ff', 1, '$2a$10$4fWU8BeARzJ8rJaJ8oK8qu5Fq1HFoV6bQbrLH1ethb5npajzBZbK2', '111', ''
       , 0, '', 0, ''),
       ('3894c790-1eca-11ed-b648-b42e99aeb6ff', 1, '$2a$10$uZvv75caQru.zvtubqWqHuPX7IjTAr7zupN9g885egKEVutbZ.vh2', 'atest', 'test'
       , 0, 'qwer@adsf.ru', 0, '375443423241'),
       ('5bc8db65-01d1-11ed-adb1-b42e99aeb6ff', 1, '$2a$10$OwOF39MiDn9YT5ymGV0s7OXjJcQa0IJKoWANmeP6kM/uI/Mz9Ol8G', 'admin', NULL
       , 20, 'admin@asd.ss', 0, NULL),
       ('5d9217a5-1d84-11ed-9604-b42e99aeb6ff', 1, '$2a$10$pw/Ru/sQ6fUluL/3fIcT/OIb2EyjLMmc8zBmNwZZI6BHOgbTp9BXK', '321', ''
       , 0, '', 0, ''),
       ('71a893b2-1d68-11ed-9604-b42e99aeb6ff', 1, '$2a$10$5vybVABceiMK4zoZEC1PPur5nJXMbX9hA84p6nLEov6gcGRTvOQ/q', 'ipetr1', ''
       , 0, '', 0, ''),
       ('7950a8bd-1d67-11ed-9604-b42e99aeb6ff', 1, '$2a$10$GxvG.VrCj7ndwrF/wtxpoOlQLImFoZQ0RPCaidFqX/M7PUAzDRZfm', 'ipetr', 'ivan petrov'
       , 0, 'ipetr@mail.ru', 0, '3753312332111'),
       ('7bec1f48-1ecc-11ed-b648-b42e99aeb6ff', 1, '$2a$10$PiPWU5.y3Yj.rKWSGyt/zu0bz1dOTJsLydnECvnzlRQsSyq8YyE4i', 'ipetr123', 'iven petroc'
       , 0, 'asdf@asd.ru', 0, '80336584587'),
       ('7d82a03e-2165-11ed-9bf8-b42e99aeb6ff', 1, '$2a$10$N5hoHFHoU12kzgHBXHA1lO4KB2TWKfSfHaCeMt0fweAfof5/QvGxi', 'admina', ''
       , 0, '', 0, ''),
       ('8322a56d-1d5f-11ed-9604-b42e99aeb6ff', 1, 'adsf', 'qwer', 'asdf'
       , 0, 'zxcv', 0, 'qwer'),
       ('9d34f877-1fc3-11ed-b648-b42e99aeb6ff', 1, '$2a$10$pk9GEA5Zf3zr8ET5KQOeJur.Q3U5I7pzsmaMWUwlKyCkVDHuw7I5e', 'testuser333', 'ivan petrov'
       , 0, 'petrov@mail.ru', 0, '375331234321'),
       ('d9a3b802-1d5f-11ed-9604-b42e99aeb6ff', 1, '$2a$10$m.f/bjqrP1xlI2F6VSQhnu377F42q7vBPdkAY979hu2ijtmmTUVNW', 'username1', 'name1'
       , 0, 'mail@adsf.ee', 0, '375332323231'),
       ('e4fa81b0-1d82-11ed-9604-b42e99aeb6ff', 1, '$2a$10$NT3PBj6CV.9lChjXWyHauOIQeJYAIkm2dPanEXnTBoJmmzPn1.UOS', '1234 aef ', ''
       , 0, '', 0, ''),
       ('f45017dd-1fba-11ed-b648-b42e99aeb6ff', 1, '$2a$10$.dT.naH0DvhdysEToIEdT.Y3QR8blgZJ/RpVSqWrV75Esl.bFDdVK', 'testuser321', 'testuser321'
       , 0, 'sas@qw.qq', 0, '21321'),
       ('guest', 0, 'guest', 'guest', NULL
       , 0, 'guest@guest.by', 1, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders`
VALUES (228, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-12 16:32:27', 25.00, 1
       , 0, 1),
       (231, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-12 23:51:03', 90.00, 2
       , 5, 2),
       (237, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-17 15:51:26', 0.00, 0
       , 0, 1),
       (245, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-17 16:05:36', 45.00, 0
       , 10, 1),
       (246, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-17 16:14:19', 25.00, 0
       , 15, 1),
       (247, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-17 22:32:52', 77.00, 1
       , 15, 1),
       (248, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-17 22:53:37', 69.00, 2
       , 15, 1),
       (258, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-18 00:57:28', 36.00, 3
       , 10, 1),
       (259, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-18 01:01:06', 51.00, 0
       , 15, 2),
       (260, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-18 01:05:04', 48.00, 0
       , 15, 2),
       (261, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-18 01:06:30', 36.00, 3
       , 10, 1),
       (262, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-18 01:12:22', 50.00, 2
       , 10, 2),
       (264, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-20 20:06:51', 123.00, 2
       , 10, 1),
       (265, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-22 14:49:40', 36.00, 0
       , 10, 1),
       (266, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 09:58:09', 50.00, 0
       , 10, 2),
       (273, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 10:47:48', 23.00, 0
       , 10, 1),
       (274, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 10:48:56', 23.00, 0
       , 10, 1),
       (275, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 10:49:48', 23.00, 0
       , 10, 1),
       (276, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 10:50:31', 25.00, 0
       , 10, 1),
       (282, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 10:59:50', 25.00, 0
       , 10, 1),
       (283, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 11:00:45', 11.00, 0
       , 10, 1),
       (284, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 11:12:41', 23.00, 2
       , 15, 1),
       (285, '5bc8db65-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-25 11:16:51', 23.00, 0
       , 20, 1),
       (290, 'guest', '2022-07-26 08:35:13', 36.00, 0
       , 0, 1),
       (291, 'guest', '2022-07-26 08:46:22', 36.00, 2
       , 0, 1),
       (292, 'guest', '2022-07-26 08:46:34', 39.00, 0
       , 0, 1),
       (293, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-26 08:47:51', 47.00, 0
       , 10, 1),
       (294, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-27 11:51:51', 143.00, 0
       , 10, 1),
       (295, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-07-27 11:51:51', 0.00, 0
       , 10, 1),
       (296, 'guest', '2022-07-27 12:01:17', 36.00, 0
       , 0, 1),
       (297, 'guest', '2022-07-27 12:02:27', 23.00, 0
       , 0, 1),
       (298, 'guest', '2022-07-27 12:04:00', 36.00, 0
       , 0, 1),
       (299, 'guest', '2022-08-16 08:00:10', 36.00, 0
       , 0, 1),
       (300, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-08-16 08:09:53', 49.00, 0
       , 10, 2),
       (301, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-08-16 08:19:09', 39.00, 0
       , 10, 1),
       (302, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-08-16 08:24:16', 36.00, 0
       , 10, 1),
       (303, 'guest', '2022-08-16 08:26:01', 36.00, 0
       , 0, 1),
       (304, 'd9a3b802-1d5f-11ed-9604-b42e99aeb6ff', '2022-08-16 12:35:42', 36.00, 0
       , 15, 1),
       (305, '3894c790-1eca-11ed-b648-b42e99aeb6ff', '2022-08-18 07:50:41', 36.00, 0
       , 0, 1),
       (306, '7bec1f48-1ecc-11ed-b648-b42e99aeb6ff', '2022-08-18 08:05:32', 37.00, 0
       , 0, 1),
       (307, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-08-20 13:50:19', 49.00, 0
       , 10, 1),
       (308, 'guest', '2022-08-20 18:04:39', 40.00, 0
       , 0, 1),
       (310, 'guest', '2022-08-21 11:26:24', 0.00, 0
       , 0, 1),
       (311, 'guest', '2022-08-21 11:27:59', 0.00, 0
       , 0, 1),
       (312, 'guest', '2022-08-21 11:32:08', 68.00, 0
       , 0, 1),
       (314, 'guest', '2022-08-22 21:46:06', 28.00, 0
       , 15, 1),
       (315, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-08-24 07:51:11', 12.11, 2
       , 10, 1),
       (316, '0b9fad84-01d1-11ed-adb1-b42e99aeb6ff', '2022-08-24 07:51:54', 27.00, 0
       , 10, 1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
;
;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

;
/*!40000 ALTER TABLE `order_userinfo` DISABLE KEYS */;
INSERT INTO `order_userinfo`
VALUES (228, '375331234567', 'mike'),
       (231, '375331234567', 'mike'),
       (237, '375331234567', 'mike'),
       (245, '375331234567', 'mike'),
       (246, '375331234567', 'mike'),
       (247, '375331234567', 'mike'),
       (248, '375331234567', 'mike'),
       (258, '375331234567', 'mike'),
       (259, '375331234567', 'mike'),
       (260, '375331234567', 'mike'),
       (261, '375331234567', 'mike'),
       (262, '375331234567', 'mike'),
       (264, '375331234567', 'mike'),
       (265, '375331234567', 'mike'),
       (266, '375331234567', 'mike'),
       (273, '375331234567', 'mike'),
       (274, '375331234567', 'mike'),
       (275, '375331234567', 'mike'),
       (276, '375331234567', 'mike'),
       (282, '375331234567', 'mike'),
       (283, '375331234567', 'mike'),
       (284, '375331234567', 'mike'),
       (285, '375331234567', 'mike'),
       (290, '375291545875', 'олег'),
       (291, '375296877854', 'виктория'),
       (292, '375295687454', 'мария'),
       (293, '375333625445', 'dima'),
       (294, '375295874589', 'natasha'),
       (295, '375251547854', 'oleg'),
       (296, '375291515154', 'olga'),
       (297, '375291751515', 'marina'),
       (298, '375258554515', 'nikita'),
       (299, '375296565655', 'alex'),
       (300, '375331234567', 'mike'),
       (301, '375331234567', 'mike'),
       (302, '331234567', 'mike'),
       (303, '80293332211', 'nick'),
       (304, '375332323231', 'name1'),
       (305, '375443423241', 'test'),
       (306, '80336584587', 'iven petroc'),
       (307, '375331112323', 'mike'),
       (308, '12341234', 'шыук'),
       (310, '321', '321123'),
       (311, '321123', 'test111'),
       (312, '321123321', 'test123'),
       (314, '123321123321', 'luke'),
       (315, '', ''),
       (316, '', '');
/*!40000 ALTER TABLE `order_userinfo` ENABLE KEYS */;
;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail`
VALUES (53, 228, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (54, 228, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (60, 231, '62c970b021fcaafe5f23b706', 2, 13.00
       , 'latte'),
       (61, 231, '62c970ea21fcaafe5f23b707', 2, 14.00
       , 'cappuccino'),
       (62, 231, '62c96faa21fcaafe5f23b705', 3, 12.00
       , 'black'),
       (71, 237, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (72, 237, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino'),
       (73, 237, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (96, 245, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (97, 245, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (98, 245, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino'),
       (99, 245, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (100, 246, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (101, 246, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (102, 247, '62c970b021fcaafe5f23b706', 2, 13.00
       , 'latte'),
       (103, 247, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (104, 247, '62c970ea21fcaafe5f23b707', 2, 14.00
       , 'cappuccino'),
       (105, 247, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (106, 248, '62c971b921fcaafe5f23b709', 1, 16.00
       , 'mocha'),
       (107, 248, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (108, 248, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (109, 248, '62c971f121fcaafe5f23b70a', 1, 17.00
       , 'latte macchiato'),
       (110, 248, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (138, 258, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (139, 258, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (140, 258, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (141, 259, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (142, 259, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (143, 259, '62c9718521fcaafe5f23b708', 1, 15.00
       , 'espresso'),
       (144, 259, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (145, 260, '62c971b921fcaafe5f23b709', 1, 16.00
       , 'mocha'),
       (146, 260, '62c971f121fcaafe5f23b70a', 1, 17.00
       , 'latte macchiato'),
       (147, 260, '62c9718521fcaafe5f23b708', 1, 15.00
       , 'espresso'),
       (148, 261, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (149, 261, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (150, 261, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (151, 262, '62c970b021fcaafe5f23b706', 3, 13.00
       , 'latte'),
       (152, 262, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (156, 264, '62c971b921fcaafe5f23b709', 1, 16.00
       , 'mocha'),
       (157, 264, '62c970b021fcaafe5f23b706', 2, 13.00
       , 'latte'),
       (158, 264, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (159, 264, '62c971f121fcaafe5f23b70a', 1, 17.00
       , 'latte macchiato'),
       (160, 264, '62c9718521fcaafe5f23b708', 1, 15.00
       , 'espresso'),
       (161, 264, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino'),
       (162, 264, '62c96faa21fcaafe5f23b705', 2, 12.00
       , 'black'),
       (163, 265, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (164, 265, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (165, 265, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (166, 266, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (167, 266, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (168, 266, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino'),
       (169, 266, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (170, 273, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (171, 273, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (172, 274, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (173, 274, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (174, 275, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (175, 275, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (176, 276, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (177, 276, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (178, 282, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (179, 282, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (180, 283, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (181, 284, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (182, 284, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (183, 285, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (184, 285, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (197, 290, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (198, 290, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (199, 290, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (200, 291, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (201, 291, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (202, 291, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (203, 292, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (204, 292, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino'),
       (205, 292, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (206, 293, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (207, 293, '62c96ded1d73b77c1639bed3', 2, 11.00
       , 'frappe'),
       (208, 293, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (209, 294, '62c971b921fcaafe5f23b709', 1, 16.00
       , 'mocha'),
       (210, 294, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (211, 294, '62c96ded1d73b77c1639bed3', 4, 11.00
       , 'frappe'),
       (212, 294, '62c971f121fcaafe5f23b70a', 1, 17.00
       , 'latte macchiato'),
       (213, 294, '62c9718521fcaafe5f23b708', 1, 15.00
       , 'espresso'),
       (214, 294, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino'),
       (215, 294, '62c96faa21fcaafe5f23b705', 2, 12.00
       , 'black'),
       (216, 296, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (217, 296, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (218, 296, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (219, 297, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (220, 297, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (221, 298, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (222, 298, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (223, 298, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (224, 299, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (225, 299, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (226, 299, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (227, 300, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (228, 300, '62c96faa21fcaafe5f23b705', 3, 12.00
       , 'black'),
       (229, 301, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (230, 301, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino'),
       (231, 301, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (232, 302, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (233, 302, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (234, 302, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (235, 303, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (236, 303, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (237, 303, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (238, 304, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (239, 304, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (240, 304, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (241, 305, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (242, 305, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (243, 305, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (244, 306, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (245, 306, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino'),
       (246, 306, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (247, 307, '62c970b021fcaafe5f23b706', 2, 13.00
       , 'latte'),
       (248, 307, '62c96ded1d73b77c1639bed3', 1, 11.00
       , 'frappe'),
       (249, 307, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (250, 308, '62c970ea21fcaafe5f23b707', 2, 14.00
       , 'cappuccino'),
       (251, 308, '62c96faa21fcaafe5f23b705', 1, 12.00
       , 'black'),
       (252, 312, '62c96ded1d73b77c1639bed3', 4, 11.00
       , 'frappe'),
       (253, 312, '62c96faa21fcaafe5f23b705', 2, 12.00
       , 'black'),
       (256, 314, '62c96ded1d73b77c1639bed3', 1, 13.00
       , 'frappe'),
       (257, 314, '62c96faa21fcaafe5f23b705', 1, 15.00
       , 'black'),
       (258, 315, '6305d83902bd6928c2ce2919', 1, 12.11
       , 'testcoffe'),
       (259, 316, '62c970b021fcaafe5f23b706', 1, 13.00
       , 'latte'),
       (260, 316, '62c970ea21fcaafe5f23b707', 1, 14.00
       , 'cappuccino');
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
;