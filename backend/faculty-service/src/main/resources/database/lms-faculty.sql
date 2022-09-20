-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: lms-faculty
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (id, number, street, city_id) VALUES (1,4,'Portage',1),(2,90,'Summer Ridge',1),(3,50,'Tennyson',1),(4,51003,'Pepper Wood',1),(5,14,'Butternut',1),(6,3,'Dakota',1),(7,95528,'Buhler',1),(8,7,'Meadow Valley',1),(9,862,'Glacier Hill',1),(10,96143,'Dryden',1),(11,1994,'Hoffman',7),(12,2,'Marquette',8),(13,1488,'Glacier Hill',1),(14,8,'Menomonie',4),(15,7,'Westerfield',5),(16,4097,'Crest Line',7),(17,5456,'Armistice',2),(18,1382,'Little Fleur',7),(19,3,'Northwestern',8),(20,695,'Nelson',9);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` (id, first_name, last_name, user_id) VALUES (1,'Faye','Fellowes',102),(2,'Tailor','Pinches',103),(3,'Darsey','Capper',104),(4,'Nicolis','Geraldini',105),(5,'Jaye','Masurel',106);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (id, name, country_id) VALUES (1,'Toronto',1),(2,'Montreal',1),(3,'Vancouver',1),(4,'Ottawa',1),(5,'Calgary',1),(6,'Edmonton',1),(7,'Quebec City',1),(8,'Winnipeg',1),(9,'Hamilton',1),(10,'Kitchener',1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (id, name) VALUES (1,'Canada');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (id, description, email, name, address_id, dean_id) VALUES (1,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','technical.sciences@utoronto.ca','Faculty of Technical Sciences',1,1),(2,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','agriculture@utoronto.ca','Faculty of Agriculture',2,2),(3,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','law@utoronto.ca','Faculty of Law',3,3),(4,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','technology@utoronto.ca','Faculty of Technology',4,4),(5,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','economics@utoronto.ca','Faculty of Economics',5,5),(6,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','philosophy@utoronto.ca','Faculty of Philosophy',6,6),(7,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','medicine@utoronto.ca','Faculty of Medicine',7,7),(8,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','sciences@utoronto.ca','Faculty of Sciences',8,8),(9,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','civil.engineering@utoronto.ca','Faculty of Civil Engineering',9,9),(10,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugiat recusandae dolorem ea amet, quas laboriosam temporibus quibusdam eligendi? Voluptatibus nulla quos aliquam aliquid veniam tempore, autem voluptates ex facere ipsa nostrum molestias iure blanditiis. Atque natus odio quisquam. Magni pariatur, error nemo temporibus fugit quos quo quisquam, impedit recusandae a eligendi culpa facilis provident non minus distinctio exercitationem quas esse ea odio quidem iusto aperiam repudiandae consequatur? Hic, laboriosam asperiores maiores qui, eius ipsum fugit odit expedita tempora quibusdam nobis similique ut! Cupiditate, beatae exercitationem illum ipsum sit debitis omnis sed autem aperiam eligendi placeat molestiae aliquid delectus accusamus maiores.','sport.and.physcial.education@utoronto.ca','Faculty of Sport and Physical Education',10,10);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (id, first_name, s_index, last_name, user_id, year_of_enrollment, study_program_id, thesis_id) VALUES (1,'Winnah','2021/270001','Matschek',61,2021,1,NULL),(2,'Maiga','2021/270002','Voaden',62,2021,1,NULL),(3,'Gerty','2021/270003','Weine',63,2021,1,NULL),(4,'Reed','2021/270004','Sandeman',64,2021,1,NULL),(5,'Katrina','2021/270005','Braney',65,2021,1,NULL),(6,'Galina','2021/270006','Durning',66,2021,1,NULL),(7,'Mirna','2021/270007','Demer',67,2021,1,NULL),(8,'Maxy','2021/270008','Urien',68,2021,1,NULL),(9,'Manon','2021/270009','Fant',69,2021,1,NULL),(10,'Ivan','2021/270010','Tice',70,2021,1,NULL),(11,'Tiffie','2021/270011','Fitchett',71,2021,1,NULL),(12,'Mollie','2021/270012','Nials',72,2021,1,NULL),(13,'Sheelagh','2021/270013','Bonnick',73,2021,1,NULL),(14,'Ilka','2021/270014','Bewsey',74,2021,1,NULL),(15,'Leora','2021/270015','Burdoun',75,2021,1,NULL),(16,'Creight','2021/270016','Marquese',76,2021,1,NULL),(17,'Tori','2021/270017','Rappport',77,2021,1,NULL),(18,'Justus','2021/270018','Ivashkov',78,2021,1,NULL),(19,'Esma','2021/270019','Yedy',79,2021,1,NULL),(20,'Humphrey','2021/270020','Fidelli',80,2021,1,NULL),(21,'Hesther','2021/270021','Grishechkin',81,2021,1,NULL),(22,'Felisha','2021/270022','Thackray',82,2021,1,NULL),(23,'Kerrill','2021/270023','Gilloran',83,2021,1,NULL),(24,'Meredithe','2021/270024','Velte',84,2021,1,NULL),(25,'Natty','2021/270025','Edy',85,2021,1,NULL),(26,'Emelia','2021/270026','Sebring',86,2021,1,NULL),(27,'Eugene','2021/270027','Mates',87,2021,1,NULL),(28,'Laryssa','2021/270028','Burtwistle',88,2021,1,NULL),(29,'Taffy','2021/270029','Stopp',89,2021,1,NULL),(30,'Erek','2021/270030','Brobeck',90,2021,1,NULL),(31,'Hilda','2021/270031','Ewins',91,2021,1,NULL),(32,'Bertrand','2021/270032','Krug',92,2021,1,NULL),(33,'Sharona','2021/270033','Adamou',93,2021,1,NULL),(34,'Shoshanna','2021/270034','Starkey',94,2021,1,NULL),(35,'Brynne','2021/270035','Teek',95,2021,1,NULL),(36,'Dollie','2021/270036','Willison',96,2021,1,NULL),(37,'Worthington','2021/270037','Dietmar',97,2021,1,NULL),(38,'Donn','2021/270038','Hunte',98,2021,1,NULL),(39,'Pearline','2021/270039','Lehon',99,2021,1,NULL),(40,'Cort','2021/270040','Kimmons',100,2021,1,NULL),(41,'Constantine','2017/270001','Ohollegan',101,2017,1,1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `study_program`
--

LOCK TABLES `study_program` WRITE;
/*!40000 ALTER TABLE `study_program` DISABLE KEYS */;
INSERT INTO `study_program` (id, acronym, description, name, faculty_id, manager_id) VALUES (1,'SEIT','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Software Engineering and Information Technologies',1,11),(2,'ISE','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Information Systems Engineering',1,12),(3,'IE','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Information Engineering',1,13),(4,'PSE','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Power Software Engineering',1,14),(5,'PE','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Industrial Engineering',1,15),(6,'TTE','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Traffic and Transport Engineering',1,16),(7,'M','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Mechatronics',1,17),(8,'GED','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Graphic Engineering and Design',1,18),(9,'EA','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Engineering Animation',1,19),(10,'CET','Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Clean Energy Technologies',1,20);
/*!40000 ALTER TABLE `study_program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (id, first_name, last_name, user_id) VALUES (1,'Teena','Gridley',1),(2,'Arlie','Anglish',2),(3,'Correna','Slatten',3),(4,'Vera','Etchell',4),(5,'Arlen','Adamek',5),(6,'Adan','Cocozza',6),(7,'Edie','Cadwell',7),(8,'Cristina','Tanslie',8),(9,'Hadria','Siveyer',9),(10,'Les','Catley',10),(11,'Viki','Cowderay',11),(12,'Skell','Wray',12),(13,'Mahmud','Luciani',13),(14,'Kennith','Clohisey',14),(15,'Holli','Fassum',15),(16,'Alexina','Vasilevich',16),(17,'Ichabod','Joskovitch',17),(18,'Dorrie','Willshear',18),(19,'Win','Geyton',19),(20,'Vinny','Filpi',20),(21,'Bidget','Janczewski',21),(22,'Vaughan','Biles',22),(23,'Letty','MacKay',23),(24,'Jacquie','Kewish',24),(25,'Vivianna','Gally',25),(26,'Vonnie','Normabell',26),(27,'Wallache','Priddie',27),(28,'Bendick','Adamec',28),(29,'Elisabetta','Ambrose',29),(30,'Carroll','Parkin',30),(31,'Garvin','Erricker',31),(32,'Cameron','Hilary',32),(33,'Prentice','Oseman',33),(34,'Sheeree','Ranklin',34),(35,'Joell','Smalecombe',35),(36,'Ayn','Glassard',36),(37,'Cleon','Fouch',37),(38,'Gamaliel','Benmore',38),(39,'Lynett','Whistlecroft',39),(40,'Carree','Gunn',40),(41,'Gillan','Mizzen',41),(42,'Shannah','Kaming',42),(43,'Alisun','Lampkin',43),(44,'Ram','Kersting',44),(45,'Donall','Creany',45),(46,'Lorraine','Wishart',46),(47,'Nicol','Claypoole',47),(48,'Wadsworth','Voaden',48),(49,'Neron','Maginot',49),(50,'Jolene','Dumsday',50),(51,'Katusha','Lambeth',51),(52,'Sasha','Allberry',52),(53,'Marie-jeanne','Lendon',53),(54,'Jaimie','Hugues',54),(55,'Rachelle','Nellies',55),(56,'Roxie','Du Hamel',56),(57,'Drew','Boyd',57),(58,'Anstice','Kynge',58),(59,'Lonnie','Scatchard',59),(60,'Belita','Coghill',60);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `thesis`
--

LOCK TABLES `thesis` WRITE;
/*!40000 ALTER TABLE `thesis` DISABLE KEYS */;
INSERT INTO `thesis` (id, application_date, defense_date, description, name, grade, url, mentor_id, student_id) VALUES (1,'2021-06-01','2021-06-25','Lorem ipsum dolor sit amet consectetur adipisicing elit. Quae quia commodi alias impedit obcaecati quasi facilis eum fugit dicta, voluptatum in molestiae accusantium, minus nam qui quos minima pariatur laborum. Aut voluptatum, culpa quae rerum a sequi velit quisquam beatae praesentium! Tempora, sapiente sed earum quia numquam placeat sequi expedita!','Specification and implementation of social network web application - \"Facebok\"',10,'https://www.utoronto.ca/thesis/social-network-facebook',11,41);
/*!40000 ALTER TABLE `thesis` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-06 11:09:06
