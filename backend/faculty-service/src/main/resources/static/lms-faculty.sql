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
INSERT INTO `faculty` (id, description, email, name, address_id, dean_id) VALUES (1,'ADD ME','technical.sciences@utoronto.ca','Faculty of Technical Sciences',1,1),(2,'ADD ME','agriculture@utoronto.ca','Faculty of Agriculture',2,2),(3,'ADD ME','law@utoronto.ca','Faculty of Law',3,3),(4,'ADD ME','technology@utoronto.ca','Faculty of Technology',4,4),(5,'ADD ME','economics@utoronto.ca','Faculty of Economics',5,5),(6,'ADD ME','philosophy@utoronto.ca','Faculty of Philosophy',6,6),(7,'ADD ME','medicine@utoronto.ca','Faculty of Medicine',7,7),(8,'ADD ME','sciences@utoronto.ca','Faculty of Sciences',8,8),(9,'ADD ME','civil.engineering@utoronto.ca','Faculty of Civil Engineering',9,9),(10,'ADD ME','sport.and.physcial.education@utoronto.ca','Faculty of Sport and Physical Education',10,10);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (id, name) VALUES (1,'ROLE_ADMIN'),(2,'ROLE_TEACHER'),(3,'ROLE_STUDENT'),(4,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
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
INSERT INTO `study_program` (id, description, name, faculty_id, manager_id) VALUES (1,'ADD ME','Software Engineering and Information Technologies',1,11),(2,'ADD ME','Information Systems Engineering',1,12),(3,'ADD ME','Information Engineering',1,13),(4,'ADD ME','Power Software Engineering',1,14),(5,'ADD ME','Industrial Engineering',1,15),(6,'ADD ME','Traffic and Transport Engineering',1,16),(7,'ADD ME','Mechatronics',1,17),(8,'ADD ME','Graphic Engineering and Design',1,18),(9,'ADD ME','Engineering Animation',1,19),(10,'ADD ME','Clean Energy Technologies',1,20);
/*!40000 ALTER TABLE `study_program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (id, teacher_title_id, user_id) VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12),(13,1,13),(14,1,14),(15,1,15),(16,1,16),(17,1,17),(18,1,18),(19,1,19),(20,1,20),(21,1,21),(22,1,22),(23,1,23),(24,1,24),(25,1,25),(26,1,26),(27,1,27),(28,1,28),(29,1,29),(30,1,30),(31,1,31),(32,1,32),(33,1,33),(34,1,34),(35,1,35),(36,1,36),(37,1,37),(38,1,38),(39,1,39),(40,1,40),(41,2,41),(42,2,42),(43,2,43),(44,2,44),(45,2,45),(46,2,46),(47,2,47),(48,2,48),(49,2,49),(50,2,50),(51,2,51),(52,2,52),(53,2,53),(54,2,54),(55,2,55),(56,2,56),(57,2,57),(58,2,58),(59,2,59),(60,2,60);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher_title`
--

LOCK TABLES `teacher_title` WRITE;
/*!40000 ALTER TABLE `teacher_title` DISABLE KEYS */;
INSERT INTO `teacher_title` (id, title) VALUES (1,'prof.'),(2,'ass.');
/*!40000 ALTER TABLE `teacher_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `thesis`
--

LOCK TABLES `thesis` WRITE;
/*!40000 ALTER TABLE `thesis` DISABLE KEYS */;
INSERT INTO `thesis` (id, application_date, defense_date, description, name, grade, url, mentor_id, student_id) VALUES (1,'2021-06-01','2021-06-25','ADD ME','Specification and implementation of social network web application - \"Facebok\"',10,'https://www.utoronto.ca/thesis/social-network-facebook',11,41);
/*!40000 ALTER TABLE `thesis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (id, email, first_name, hashed_password, last_name, role_id) VALUES (1,'dfitch@utoronto.ca','Deena','password','Fitch',2),(2,'o1@businessweek.com','Odelia','T49NLDsq9','Vittet',2),(3,'j2@prweb.com','Jennie','dkh4gelBwu','Brayshay',2),(4,'n3@jigsy.com','Noami','Rr0hQm','Goering',2),(5,'l4@live.com','Laverna','X9DhpgXM','Fradgley',2),(6,'m5@bravesites.com','Margaretta','x0HLfeZh1c7m','Foddy',2),(7,'h6@twitpic.com','Herbert','nWso6FgumpRl','Yates',2),(8,'a7@deliciousdays.com','Andriette','J6jyBaNhe','Risby',2),(9,'t8@bizjournals.com','Tani','iwiDTe5lv','Schoenleiter',2),(10,'g9@lulu.com','Geralda','YAoj6wi393','O\'Regan',2),(11,'pa@ucoz.com','Papageno','r6V7a7kXTt','Haggith',2),(12,'cb@pbs.org','Claus','Q18MN05alofZ','Batchelar',2),(13,'vc@godaddy.com','Vlad','c0hsDT','Camamile',2),(14,'cd@qq.com','Cordell','F6ikVg','Ridd',2),(15,'me@istockphoto.com','Megan','sJnZS9z','Dowzell',2),(16,'ff@deviantart.com','Felisha','YO4WtL3bWrn','Helwig',2),(17,'fg@newyorker.com','Filmore','VF8J74gK3HC','Islep',2),(18,'oh@icio.us','Orin','v5o1HaCdv4U','Jarmaine',2),(19,'oi@parallels.com','Onfroi','8siTtpx','Sandhill',2),(20,'dj@netvibes.com','Darius','Tmq9y9FEbv','Blunderfield',2),(21,'rk@guardian.co.uk','Roselin','fWYXFNSmmH','Terney',2),(22,'nl@bizjournals.com','Nye','TdduTY4SdpdX','Butte',2),(23,'tm@wired.com','Terri','iicfQFxsEw','Flecknoe',2),(24,'nn@e-recht24.de','Nissy','taesNJH','Woodrooffe',2),(25,'jo@amazonaws.com','Joan','4JrRiMgw','Norledge',2),(26,'tp@smh.com.au','Tomlin','Zmd1h9U3mvZ','Colbert',2),(27,'cq@example.com','Colver','aM9jiy','Sare',2),(28,'tr@prlog.org','Tomi','zzDXJYYSSE','Menzies',2),(29,'js@ezinearticles.com','James','rcm3RIU3si','Yggo',2),(30,'it@feedburner.com','Ileane','N7YmeYetv','Foster-Smith',2),(31,'lu@yahoo.co.jp','Lorne','jSVT1r','Jeness',2),(32,'wv@wsj.com','Waylan','KhrQPT5rI','Alan',2),(33,'aw@businesswire.com','Alberta','c7IUbnT','Mackleden',2),(34,'vx@umn.edu','Van','FHTg0rbfY9','Pittwood',2),(35,'ry@nymag.com','Rhianon','zA5UfgguSqh','Barefoot',2),(36,'rz@mediafire.com','Rollo','n1DnIAgC','Girardeau',2),(37,'l10@yelp.com','Lorinda','S4zi50A','Oleszcuk',2),(38,'m11@slate.com','Marvin','zXUSpK0uA','Dayley',2),(39,'a12@redcross.org','Annice','ZuLeOOcp','Cady',2),(40,'k13@si.edu','Kati','3Gj0c5pRVl','Bauduin',2),(41,'s14@bloomberg.com','Sharia','MHS3skSXo8u','Fantonetti',2),(42,'r15@cisco.com','Rozanna','gGJM8B','Djakovic',2),(43,'t16@bing.com','Tamarah','zz5pzsSJzLN','Budleigh',2),(44,'g17@senate.gov','Guthrey','YjoxESCp9','Stirzaker',2),(45,'g18@google.nl','Gallagher','dTJfSYc52','Liffe',2),(46,'r19@bing.com','Robert','vUzT3o1','Bowdler',2),(47,'k1a@jimdo.com','Keeley','cgReayKnkYz','Nellis',2),(48,'c1b@amazon.co.jp','Carey','KETyv1IZ','Ockwell',2),(49,'w1c@tinyurl.com','Willem','xEeJDiaqSW','Dolden',2),(50,'a1d@bloglovin.com','Aindrea','XDWFUSdL','Risen',2),(51,'r1e@paginegialle.it','Rosanne','AU2fjqjvU','Alenikov',2),(52,'p1f@samsung.com','Pepi','ox6iKLN','Kedslie',2),(53,'o1g@github.com','Omar','618IZNS2a','Baudy',2),(54,'j1h@acquirethisname.com','Jephthah','kZmw8ZGb','Foran',2),(55,'n1i@shutterfly.com','Nikos','M1x7eeafCjQ','Elster',2),(56,'m1j@cdbaby.com','Melodie','F30sbX70DpY','Pleven',2),(57,'w1k@nymag.com','Weidar','SCU5XRvm','Bullas',2),(58,'n1l@tumblr.com','Ninon','M8abhajq','Byham',2),(59,'k1m@altervista.org','Kelsy','FukvnzOmWz','Beacon',2),(60,'g1n@bloglines.com','Griz','4mh0mHY','Hazard',2),(61,'m1o@fda.gov','Minnie','usWR5d7T0r51','Blakeborough',3),(62,'t1p@eepurl.com','Talyah','5l4s33','Brodeau',3),(63,'l1q@stumbleupon.com','Leann','nRt3A30c8','Bener',3),(64,'d1r@cyberchimps.com','Dom','j6YF8k6','Westmacott',3),(65,'l1s@google.fr','Leese','fvMUMeoV9F','Alway',3),(66,'b1t@bloomberg.com','Babbette','xKZ5g7AZ','Gell',3),(67,'c1u@artisteer.com','Curtis','zdWCODKlP','O\'Dooghaine',3),(68,'c1v@com.com','Corrie','ChZFSsA','Domingues',3),(69,'m1w@mozilla.com','Melania','XHp2UokXLyd','Rosenberg',3),(70,'b1x@google.it','Benton','CuLZv8ie5d','Zuker',3),(71,'e1y@infoseek.co.jp','Essa','vW7WdwM9q','D\'Aubney',3),(72,'e1z@oakley.com','Elsworth','JZclTB3cUH','Musico',3),(73,'f20@irs.gov','Fowler','gXBXTN8j','Gaynsford',3),(74,'v21@exblog.jp','Veronique','bdWdrgkF','Bowdler',3),(75,'e22@who.int','Elnora','pOwuZlA','Lilleycrop',3),(76,'b23@samsung.com','Bonni','FxXJJcTsC','O\'Bradane',3),(77,'f24@netlog.com','Fair','GvAI54','Willford',3),(78,'b25@xing.com','Bette-ann','9H3ucIhi','Cantero',3),(79,'d26@aboutads.info','Dulcine','Yq8BJwLCEPe','Westcar',3),(80,'m27@wikia.com','Marney','Rkrk55','Saffran',3),(81,'m28@facebook.com','Massimo','TspkBJUCPqKp','Greggersen',3),(82,'t29@wired.com','Trescha','xkpZC4','Blasiak',3),(83,'d2a@woothemes.com','Doria','93wosOYS61Lq','Patry',3),(84,'b2b@godaddy.com','Benoit','w7XsS8','Allgood',3),(85,'k2c@sciencedirect.com','Katerina','c5dztz','Flewin',3),(86,'g2d@scientificamerican.com','George','0gMr622Sqy7z','Seide',3),(87,'s2e@jiathis.com','Stefania','fktXwjLM','Braithwaite',3),(88,'g2f@php.net','Gerianne','d8PZy5','Pietruschka',3),(89,'s2g@taobao.com','Sascha','wjNyezFvinE','Whitten',3),(90,'r2h@odnoklassniki.ru','Rori','oninNXmE','Boow',3),(91,'i2i@springer.com','Issy','fwugHxZ','Mompesson',3),(92,'j2j@indiegogo.com','Jamil','KSdsZXJ6L','Mattingson',3),(93,'a2k@ca.gov','Alwyn','akuF3tTO','Flux',3),(94,'l2l@phpbb.com','Lucian','vBFwD3IB108','Hoffner',3),(95,'c2m@phpbb.com','Crystal','3AEgGSJQfL','Abbyss',3),(96,'r2n@lulu.com','Robby','tW5POuyalPsF','Rawsen',3),(97,'z2o@hubpages.com','Zelma','XjHznNHol','Troup',3),(98,'j2p@cdbaby.com','Jaimie','i0lgYmFQQAY','Boeter',3),(99,'l2q@umich.edu','Laurel','K98FJCjd','Goathrop',3),(100,'m2r@mail.ru','Marlon','CCZkMfbzJj0','Padly',3),(101,'kpendre0@aboutads.info','Kattie','and5lSmoX','Pendre',4),(102,'acushworth1@google.com','Abbey','06Si0GnJUf','Cushworth',4),(103,'fmerrin2@xinhuanet.com','Fiorenze','fQr7ZOLokC78','Merrin',4),(104,'skettley3@github.io','Skipp','th2UyKfh1','Kettley',4),(105,'caudibert4@washington.edu','Catina','olE4vtQl','Audibert',4),(106,'aabramovitz5@newyorker.com','Angel','Awfn19xy1Hz','Abramovitz',4),(107,'ebarbisch6@tiny.cc','Edan','eSi4xtGes6y','Barbisch',4),(108,'dlenihan7@topsy.com','Darb','FFN0ZzC','Lenihan',4),(109,'cgerrard8@goo.ne.jp','Christye','7MEaFUg','Gerrard',4),(110,'fworman9@fema.gov','Falito','8pZiEjQPcM','Worman',4),(111,'ncheshera@reddit.com','Nadine','Um52fK','Chesher',4),(112,'dlempennyb@surveymonkey.com','Domenic','k8IzjhoZ9','Lempenny',4),(113,'wbeethamc@biglobe.ne.jp','Waiter','OMfxVZJRDU2d','Beetham',4),(114,'cgrahamd@nationalgeographic.com','Codi','LuW7a8','Graham',4),(115,'caguilare@i2i.jp','Cookie','HWVk1qm3','Aguilar',4),(116,'bwikeyf@over-blog.com','Benedicto','Lk9PoHl','Wikey',4),(117,'nclinchg@house.gov','Nichole','03PkJKWe12io','Clinch',4),(118,'rbankesh@boston.com','Rivkah','AA3WM06','Bankes',4),(119,'echasmoori@stumbleupon.com','Elbertina','lLBb7bthQbE','Chasmoor',4),(120,'messamej@ucsd.edu','Micheil','JwMsa0R6oOUf','Essame',4),(121,'jmerveillek@cafepress.com','Joleen','PYRlGNyd5h','Merveille',4),(122,'nhruskal@ask.com','Nata','DetzM2r','Hruska',4),(123,'djacobovitzm@goo.gl','Dag','Iu1AKBMez','Jacobovitz',4),(124,'ebrosiusn@ask.com','Emmey','R8haWWoNQqnJ','Brosius',4),(125,'evoako@qq.com','Erasmus','wCo7gbSTCox','Voak',4),(126,'mfidelep@google.com.br','Merrili','PGMnyN','Fidele',4),(127,'mwarlockq@amazon.co.jp','Matthew','gRVA3foX','Warlock',4),(128,'amizenr@drupal.org','Ardisj','TxbJUEsCJS','Mizen',4),(129,'nmiddles@wikimedia.org','Niel','QD04SzPT4K','Middle',4),(130,'mheggmant@google.com.hk','Mady','7ux5Fju24M','Heggman',4),(131,'ccharku@dell.com','Cornie','oEwhNVSsR','Chark',4),(132,'skingwellv@altervista.org','Stanly','7cWZlD','Kingwell',4),(133,'rpulsfordw@exblog.jp','Raffarty','oyUFqBvcz','Pulsford',4),(134,'egawenx@cmu.edu','Elliott','OlMET91wJ','Gawen',4),(135,'klimpennyy@icq.com','Kimmie','eT7Pyy2TcD','Limpenny',4),(136,'vhalkyardz@123-reg.co.uk','Valentino','qB47pYHjP7','Halkyard',4),(137,'dlammenga10@fotki.com','Deirdre','TYtVHbAeclKr','Lammenga',4),(138,'bduggleby11@utexas.edu','Baxy','Zjg3H1','Duggleby',4),(139,'wweich12@mapy.cz','Wendell','APoiqN','Weich',4),(140,'eantonowicz13@yellowpages.com','Ettore','Vedr2X55jY','Antonowicz',4),(141,'ttrendle14@businessinsider.com','Tanhya','prUhL4k6D0wS','Trendle',4),(142,'ipattillo15@wordpress.com','Ives','AC93HoHRW','Pattillo',4),(143,'rdiego16@posterous.com','Rainer','D3FT1J','Diego',4),(144,'kcoxon17@gmpg.org','Kelcy','nYhde4OGjJN','Coxon',4),(145,'hmundwell18@issuu.com','Hewitt','VRsWchM','Mundwell',4),(146,'tnormand19@fema.gov','Terence','TVfa0zlwF7Fk','Normand',4),(147,'mpepon1a@unesco.org','Margo','o89j9BcK','Pepon',4),(148,'alapthorn1b@patch.com','Artemas','HYLjGeh','Lapthorn',4),(149,'vweddup1c@merriam-webster.com','Valaree','7iCI5W','Weddup',4),(150,'rfoystone1d@google.it','Rowney','01Mp2f5','Foystone',4),(151,'ajochanany1e@twitpic.com','Adria','Z1ttAG','Jochanany',4),(152,'mchallis1f@gov.uk','Merralee','4PRwU1goSj','Challis',4),(153,'ascantlebury1g@wikipedia.org','Alair','QO46kBU5iCwc','Scantlebury',4),(154,'nshire1h@zdnet.com','Natividad','2fPk5wv','Shire',4),(155,'bgyford1i@jigsy.com','Bale','Cx873IxDU4Y','Gyford',4),(156,'jlindenman1j@xinhuanet.com','Janek','MfJXmmYta','Lindenman',4),(157,'jdawtrey1k@apple.com','Judie','zZgeaPGhl','Dawtrey',4),(158,'jrean1l@icq.com','Jackquelin','Aqajws','Rean',4),(159,'dgrishin1m@ox.ac.uk','Dukie','gFqSmm','Grishin',4),(160,'lbeningfield1n@oaic.gov.au','Lamar','ixjQTH','Beningfield',4),(161,'aghost1o@tiny.cc','Alford','8S2QSc9xNZ','Ghost',4),(162,'edunsford1p@flavors.me','Elwood','ilzJ4Vcan','Dunsford',4),(163,'mbussen1q@sphinn.com','Mikey','nQnKxMb1KE','Bussen',4),(164,'sanderl1r@opensource.org','Sean','tplsWXIzA','Anderl',4),(165,'castupenas1s@dyndns.org','Cherlyn','hNjnXDFTXbT','Astupenas',4),(166,'rpedron1t@example.com','Rorie','FxkMoI','Pedron',4),(167,'mlinzey1u@fc2.com','Minnnie','n2s7PwYDc','Linzey',4),(168,'pcockshutt1v@newsvine.com','Pete','rx7tVjOZq','Cockshutt',4),(169,'gmole1w@phpbb.com','Georgia','gQOVZuV','Mole',4),(170,'cjanous1x@cocolog-nifty.com','Concettina','A5d4VtbVurp6','Janous',4),(171,'akimm1y@linkedin.com','Alard','13ljQGSSGtS','Kimm',4),(172,'fconnors1z@tumblr.com','Fancy','SNSsVMYZdI5','Connors',4),(173,'ebowditch20@nationalgeographic.com','Esme','QDtwrtb','Bowditch',4),(174,'torr21@taobao.com','Tod','P2DkiHTp','Orr',4),(175,'ngarvey22@prlog.org','Nanette','gGuJgxJljM','Garvey',4),(176,'akobpal23@sourceforge.net','Alessandro','Ef8sl7n','Kobpal',4),(177,'imcgowran24@prweb.com','Ichabod','3XbyDrvZ56H','McGowran',4),(178,'sredsell25@ed.gov','Sybila','rw2SaVT','Redsell',4),(179,'cbeardall26@canalblog.com','Cary','t6PLasQpF6','Beardall',4),(180,'dverduin27@harvard.edu','Dodi','DrIAQDTnM','Verduin',4),(181,'jgovett28@smugmug.com','Jereme','3TyUqb4MkA','Govett',4),(182,'cswigger29@hud.gov','Cecilio','8hlxJ6NJNqU9','Swigger',4),(183,'ssoreau2a@weebly.com','Skelly','Yg4vW8','Soreau',4),(184,'bboullen2b@google.co.uk','Brenda','BDapFONXBhY','Boullen',4),(185,'uwoodrooffe2c@macromedia.com','Umberto','84653qFH','Woodrooffe',4),(186,'dscurfield2d@vk.com','Darbie','gjpbx9','Scurfield',4),(187,'mhencke2e@microsoft.com','Maye','gXuEACM','Hencke',4),(188,'cwhardley2f@google.com','Camel','CJYxu4z6','Whardley',4),(189,'lgrimbleby2g@dailymotion.com','Locke','zvhFUKwR4g','Grimbleby',4),(190,'tbudik2h@rakuten.co.jp','Tuck','EvS3CQr6','Budik',4),(191,'rwaszczykowski2i@github.com','Ranice','NftYPaGtTyP8','Waszczykowski',4),(192,'bbransom2j@ucla.edu','Bartie','zN1DNzGXpiA','Bransom',4),(193,'colivo2k@prnewswire.com','Cristal','9r7fBp5yb93','Olivo',4),(194,'agrolmann2l@freewebs.com','Arvie','VDbigeQianh','Grolmann',4),(195,'rrudolph2m@sogou.com','Ronnie','oUnm9Af7b8','Rudolph',4),(196,'cpethick2n@sciencedaily.com','Culley','5NlNXd','Pethick',4),(197,'mfeatherstonhalgh2o@cornell.edu','Marjy','w54sfV6zb4','Featherstonhalgh',4),(198,'pmurrow2p@baidu.com','Pepi','YIXPAGp','Murrow',4),(199,'ohasluck2q@squarespace.com','Orsa','eDLtu7GF9u','Hasluck',4),(200,'abyne2r@cisco.com','Arlee','SuJKIYymih','Byne',4),(420,'admin@utoronto.ca','Bojan','password','Zdelar',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-06 11:09:06
