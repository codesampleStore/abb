INSERT INTO course(id, name, create_date, last_updated_date) values(10001, 'JPA in 50 Steps', sysdate(), sysdate());
INSERT INTO course(id, name, create_date, last_updated_date) values(10002, 'JAVA in 50 Steps', sysdate(), sysdate());
INSERT INTO course(id, name, create_date, last_updated_date) values(10003, 'C++ in 50 Steps', sysdate(), sysdate());
INSERT INTO course(id, name, create_date, last_updated_date) values(10004, 'C in 50 Steps', sysdate(), sysdate());
INSERT INTO course(id, name, create_date, last_updated_date) values(10005, 'ASP.NET in 50 Steps', sysdate(), sysdate());
INSERT INTO course(id, name, create_date, last_updated_date) values(10006, 'K8S in 50 Steps', sysdate(), sysdate());

INSERT INTO passport(id, number) values(40001, 'E1234567');
INSERT INTO passport(id, number) values(40002, 'N1234567');
INSERT INTO passport(id, number) values(40003, 'L1231213');

INSERT INTO review(id, rating, description) values(50001, '5', 'Great Course');
INSERT INTO review(id, rating, description) values(50002, '4', 'Wonderful Course');
INSERT INTO review(id, rating, description) values(50003, '5', 'Awsom Course');

INSERT INTO student(id, name, passport_id) values(20001, 'Ranga', 40001);
INSERT INTO student(id, name, passport_id) values(20002, 'Adam', 40002);
INSERT INTO student(id, name, passport_id) values(20003, 'Jane', 40003);