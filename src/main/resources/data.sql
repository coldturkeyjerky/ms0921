TRUNCATE TABLE TOOLS;
TRUNCATE TABLE CHARGES;
TRUNCATE TABLE CHECKOUTS;
TRUNCATE TABLE RENTAL_AGREEMENTS;

INSERT INTO TOOLS(tooltype, toolbrand, toolcode) VALUES
    ('Ladder', 'Werner', 'LADW'),
    ('Chainsaw', 'Stihl', 'CHNS'),
    ('Jackhammer', 'Ridgid', 'JAKR'),
    ('Jackhammer', 'DeWalt', 'JAKD');

INSERT INTO CHARGES(tooltype, dailycharge, weekdaycharge, weekendcharge, holidaycharge) VALUES
    ('Ladder', 1.99, true, true, false),
    ('Chainsaw', 1.49, true, false, true),
    ('Jackhammer', 2.99, true, false, false);