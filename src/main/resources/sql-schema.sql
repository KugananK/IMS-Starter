drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `customers` (
    `customer_id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `Surname` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `order_id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `item_cost` Double,
    FOREIGN KEY(`customer_id`) REFERENCES `customers`(`customer_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY(`order_id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `item_id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `item_name` VARCHAR(40) NOT NULL,
    `item_cost` DOUBLE,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `joining` (
    `order_id` int NOT NULL,
    `item_id` int NOT NULL,
    FOREIGN KEY(`order_id`) REFERENCES `orders`(`order_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(`item_id`) REFERENCES `items`(`item_id`)ON UPDATE CASCADE ON DELETE CASCADE
);