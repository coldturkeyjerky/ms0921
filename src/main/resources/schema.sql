CREATE ALIAS IF NOT EXISTS GET_CHARGE_DAYS FOR "com.rentaldepot.demo.util.Function.getChargeDays";

CREATE TABLE IF NOT EXISTS `TOOLS` (
    `id`      INTEGER PRIMARY KEY AUTO_INCREMENT,
    `tooltype`    VARCHAR(50) NOT NULL,
    `toolbrand`   VARCHAR(50) NOT NULL,
    `toolcode`    VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `CHARGES` (
    `id`      INTEGER PRIMARY KEY AUTO_INCREMENT,
    `tooltype`    VARCHAR(50) NOT NULL,
    `dailycharge`   DECIMAL(5,2),
    `weekdaycharge` BOOLEAN,
    `weekendcharge` BOOLEAN,
    `holidaycharge` BOOLEAN
);

CREATE TABLE IF NOT EXISTS `CHECKOUTS` (
    `id`                INTEGER PRIMARY KEY AUTO_INCREMENT,
    `toolcode`          VARCHAR(50) NOT NULL,
    `rentaldays`        INTEGER,
    `discountpercent`   INTEGER,
    `checkoutdate`      DATE
);

CREATE TABLE IF NOT EXISTS `RENTAL_AGREEMENTS` (
    `id`                   INTEGER PRIMARY KEY AUTO_INCREMENT,
    `toolcode`             VARCHAR(50) NOT NULL,
    `tooltype`             VARCHAR(50) NOT NULL,
    `toolbrand`            VARCHAR(50) NOT NULL,
    `rentaldays`           INTEGER,
    `checkoutdate`         DATE,
    `duedate`              DATE,
    `dailyrentalcharge`    DECIMAL(5,2),
    `chargedays`           INTEGER,
    `prediscountcharge`    DECIMAL(5,2),
    `discountpercent`      INTEGER,
    `discountamount`       DECIMAL(5,2),
    `finalcharge`          DECIMAL(5,2)
);