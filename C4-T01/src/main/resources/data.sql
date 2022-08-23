use heroku_0d3d9a2e88b6da5;

DROP table IF EXISTS `messages`;
DROP table IF EXISTS `partys`;
DROP table IF EXISTS `videogames`;
DROP TABLE IF EXISTS `games`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
	`id` int NOT NULL auto_increment,
    `name` nvarchar(25) NOT NULL,
    `email` nvarchar(25) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `games` (
	`id` int NOT NULL auto_increment,
    `name` nvarchar(25) NOT NULL,
    `description` nvarchar(255) NOT NULL,
    `idusers` int NOT NULL,
    CONSTRAINT `games_fk_1` FOREIGN KEY (`idusers`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE, 
    PRIMARY KEY (`id`)
);

CREATE TABLE `videogames` (
	`id` int NOT NULL auto_increment,
    `title` nvarchar(25) NOT NULL,
    `idgames` int NOT NULL,
 	CONSTRAINT `videogames_fk_1` FOREIGN KEY (`idgames`) REFERENCES `games` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (`id`)
);

CREATE TABLE `partys` (
	`id` int NOT NULL auto_increment,
    `title` nvarchar(25) NOT NULL,
    `idusers` int NOT NULL,
    CONSTRAINT `partys_fk_1` FOREIGN KEY (`idusers`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE, 
    PRIMARY KEY (`id`) 
);

CREATE TABLE `messages` (
	`id` int NOT NULL auto_increment,
    `shipping` date NOT NULL,
    `text` nvarchar(255) NOT NULL,
    `idpartys` int NOT NULL,
    `idusers` int NOT NULL,
	CONSTRAINT `messages_fk_1` FOREIGN KEY (`idpartys`) REFERENCES `partys` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `messages_fk_2` FOREIGN KEY (`idusers`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (`id`)
);
