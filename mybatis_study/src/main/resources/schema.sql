DROP TABLE IF EXISTS Member;
DROP TABLE IF EXISTS Coach;
DROP TABLE IF EXISTS Center;


CREATE TABLE Center
(
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(250) NOT NULL,
    regDt DATE NOT NULL,
    email VARCHAR(250) DEFAULT NULL
);

CREATE TABLE Coach
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(250) NOT NULL,
    regDt    DATETIME NOT NULL,
    updateDt DATETIME DEFAULT NULL,
    email    VARCHAR(250) DEFAULT NULL,
    centerId INT,
    FOREIGN KEY (centerId) REFERENCES Center (id)

);

CREATE TABLE Member
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(250) NOT NULL,
    regDt    DATETIME NOT NULL,
    updateDt DATETIME DEFAULT NULL,
    email    VARCHAR(250) DEFAULT NULL,
    centerId INT,
    coachId  INT,
    FOREIGN KEY (centerId) REFERENCES Center (id),
    FOREIGN KEY (coachId) REFERENCES Coach (id)
);