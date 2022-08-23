INSERT INTO Center (name, regDt, email)
VALUES ('test1', '1994-02-23', 'test1@gmail.com'),
       ('test2', '2010-03-04', 'test2@gmail.com'),
       ('test3', '2015-06-14', 'test3@gmail.com');


INSERT INTO Coach (name, regDt, email, centerId)
VALUES ('coach1', '2022-01-03', 'coach1@gmail.com', 1),
       ('coach2', '2022-01-04', 'coach2@gmail.com', 2),
       ('coach3', '2022-01-05', 'coach3@gmail.com', 3);

INSERT INTO Member (name, regDt, email, centerId)
VALUES ('member1', '2022-01-03', 'member1@gmail.com', 1),
       ('member2', '2022-01-04', 'member2@gmail.com', 1),
       ('member3', '2022-01-05', 'member3@gmail.com', 1);