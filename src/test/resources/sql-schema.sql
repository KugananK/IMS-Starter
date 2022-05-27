DROP SCHEMA testIMS;
CREATE SCHEMA `testIMS`;
USE `testIMS`;

DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);


DROP IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
    `order_id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `item_cost` Double,
    FOREIGN KEY(`customer_id`) REFERENCES `customers`(`customer_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY(`order_id`)
);

DROP IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
    `item_id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `item_name` VARCHAR(40) NOT NULL,
    `item_cost` DOUBLE,
    PRIMARY KEY (`item_id`)
);

DROP IF EXISTS `joining`;
CREATE TABLE IF NOT EXISTS `joining` (
    `order_id` int NOT NULL,
    `item_id` int NOT NULL,
    FOREIGN KEY(`order_id`) REFERENCES `orders`(`order_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(`item_id`) REFERENCES `items`(`item_id`)ON UPDATE CASCADE ON DELETE CASCADE
);