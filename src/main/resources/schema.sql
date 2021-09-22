CREATE ALIAS IF NOT EXISTS GET_CHARGE_DAYS FOR "com.rentaldepot.demo.util.Function.getChargeDays";

CREATE TABLE IF NOT EXISTS `TOOLS` (
    `id`      INTEGER PRIMARY KEY AUTO_INCREMENT,
    `tool_type`    VARCHAR(50) NOT NULL,
    `tool_brand`   VARCHAR(50) NOT NULL,
    `tool_code`    VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `CHARGES` (
    `id`      INTEGER PRIMARY KEY AUTO_INCREMENT,
    `tool_type`    VARCHAR(50) NOT NULL,
    `daily_charge`   DECIMAL(5,2),
    `weekday_charge` BOOLEAN,
    `weekend_charge` BOOLEAN,
    `holiday_charge` BOOLEAN
);

CREATE TABLE IF NOT EXISTS `CHECKOUTS` (
    `id`                INTEGER PRIMARY KEY AUTO_INCREMENT,
    `tool_code`         VARCHAR(50) NOT NULL,
    `rental_days`  INTEGER,
    `discount_percent`  INTEGER,
    `checkout_date`     DATE
);

CREATE TABLE IF NOT EXISTS `RENTAL_AGREEMENTS` (
    `id`                    INTEGER PRIMARY KEY AUTO_INCREMENT,
    `tool_code`             VARCHAR(50) NOT NULL,
    `tool_type`             VARCHAR(50) NOT NULL,
    `tool_brand`            VARCHAR(50) NOT NULL,
    `rental_days`           INTEGER,
    `checkout_date`         DATE,
    `due_date`              DATE,
    `daily_rental_charge`   DECIMAL(5,2),
    `charge_days`           INTEGER,
    `pre_discount_charge`   DECIMAL(5,2),
    `discount_percent`      INTEGER,
    `discount_amount`       DECIMAL(5,2),
    `final_charge`          DECIMAL(5,2)
);