-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: lms
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
INSERT INTO `administrator` (id, user_id) VALUES (1,196),(2,197),(3,198),(4,199),(5,200);
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
INSERT INTO `student` (id, s_index, year_of_enrollment, study_program_id, thesis_id, user_id) VALUES (1,'2021/270001',2021,1,NULL,61),(2,'2021/270002',2021,1,NULL,62),(3,'2021/270003',2021,1,NULL,63),(4,'2021/270004',2021,1,NULL,64),(5,'2021/270005',2021,1,NULL,65),(6,'2021/270006',2021,1,NULL,66),(7,'2021/270007',2021,1,NULL,67),(8,'2021/270008',2021,1,NULL,68),(9,'2021/270009',2021,1,NULL,69),(10,'2021/270010',2021,1,NULL,70),(11,'2021/270011',2021,1,NULL,71),(12,'2021/270012',2021,1,NULL,72),(13,'2021/270013',2021,1,NULL,73),(14,'2021/270014',2021,1,NULL,74),(15,'2021/270015',2021,1,NULL,75),(16,'2021/270016',2021,1,NULL,76),(17,'2021/270017',2021,1,NULL,77),(18,'2021/270018',2021,1,NULL,78),(19,'2021/270019',2021,1,NULL,79),(20,'2021/270020',2021,1,NULL,80),(21,'2021/270021',2021,1,NULL,81),(22,'2021/270022',2021,1,NULL,82),(23,'2021/270023',2021,1,NULL,83),(24,'2021/270024',2021,1,NULL,84),(25,'2021/270025',2021,1,NULL,85),(26,'2021/270026',2021,1,NULL,86),(27,'2021/270027',2021,1,NULL,87),(28,'2021/270028',2021,1,NULL,88),(29,'2021/270029',2021,1,NULL,89),(30,'2021/270030',2021,1,NULL,90),(31,'2021/270031',2021,1,NULL,91),(32,'2021/270032',2021,1,NULL,92),(33,'2021/270033',2021,1,NULL,93),(34,'2021/270034',2021,1,NULL,94),(35,'2021/270035',2021,1,NULL,95),(36,'2021/270036',2021,1,NULL,96),(37,'2021/270037',2021,1,NULL,97),(38,'2021/270038',2021,1,NULL,98),(39,'2021/270039',2021,1,NULL,99),(40,'2021/270040',2021,1,NULL,100),(41,'2017/270001',2017,1,1,101);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `study_program`
--

LOCK TABLES `study_program` WRITE;
/*!40000 ALTER TABLE `study_program` DISABLE KEYS */;
INSERT INTO `study_program` (id, description, name, faculty_id, manager_id) VALUES (1,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Software Engineering and Information Technologies',1,11),(2,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Information Systems Engineering',1,12),(3,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Information Engineering',1,13),(4,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Power Software Engineering',1,14),(5,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Industrial Engineering',1,15),(6,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Traffic and Transport Engineering',1,16),(7,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Mechatronics',1,17),(8,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Graphic Engineering and Design',1,18),(9,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Engineering Animation',1,19),(10,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sit possimus sed ex hic laudantium. Molestias suscipit sed sint, perferendis ratione, dolorum eum rerum totam ad autem architecto? Fugit neque optio aspernatur eligendi, accusamus asperiores amet reprehenderit est ducimus ex maiores ratione id error quae facere quia reiciendis architecto placeat earum.','Clean Energy Technologies',1,20);
/*!40000 ALTER TABLE `study_program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (id, user_id) VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20),(21,21),(22,22),(23,23),(24,24),(25,25),(26,26),(27,27),(28,28),(29,29),(30,30),(31,31),(32,32),(33,33),(34,34),(35,35),(36,36),(37,37),(38,38),(39,39),(40,40),(41,41),(42,42),(43,43),(44,44),(45,45),(46,46),(47,47),(48,48),(49,49),(50,50),(51,51),(52,52),(53,53),(54,54),(55,55),(56,56),(57,57),(58,58),(59,59),(60,60);
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
