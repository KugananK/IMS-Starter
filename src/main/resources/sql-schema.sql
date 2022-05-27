drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `Surname` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `order_id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `item_cost` Double NOT NULL,
    FOREIGN KEY(`customer_id`) REFERENCES `customers`(`customer_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY(`order_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `item_id` INT NOT NULL UNIQUE AUTO_INCREMENT,
    `item_name` VARCHAR(40) NOT NULL,
    `item_cost` DOUBLE NOT NULL,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`joining` (
    `order_id` int NOT NULL,
    `item_id` int NOT NULL,
    FOREIGN KEY(`order_id`) REFERENCES `orders`(`order_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(`item_id`) REFERENCES `items`(`item_id`)ON UPDATE CASCADE ON DELETE CASCADE
);