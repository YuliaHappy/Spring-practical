
CREATE SCHEMA bookingService AUTHORIZATION postgres;

CREATE TABLE bookingService.user(
  id INT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255) UNIQUE,
  birthday DATE NOT NULL);
CREATE TABLE bookingService.auditorium(
  id INT PRIMARY KEY,
  name VARCHAR(255),
  countOfSeats INT);
CREATE TABLE bookingService.vipSeats(
  id INT PRIMARY KEY,
  idAuditorium INT,
  numberSeat INT NOT NULL,
  FOREIGN KEY (idAuditorium) REFERENCES bookingService.auditorium(id) ON DELETE CASCADE);
CREATE TABLE bookingService.event(
  name VARCHAR(255) PRIMARY KEY,
  rating varchar(5) NOT NULL CHECK (rating IN('HIGH', 'MID', 'LOW')),
  basePrice INT NOT NULL,
  vipPrice INT NOT NULL,
  dateTime TIMESTAMP NOT NULL,
  idAuditorium INT,
  FOREIGN KEY (idAuditorium) REFERENCES bookingService.auditorium(id) ON DELETE CASCADE);
CREATE TABLE bookingService.event(
  name VARCHAR(255) PRIMARY KEY,
  rating varchar(5) NOT NULL CHECK (rating IN('HIGH', 'MID', 'LOW')),
  basePrice INT NOT NULL,
  vipPrice INT NOT NULL,
  dateTime TIMESTAMP NOT NULL,
  idAuditorium INT,
  FOREIGN KEY (idAuditorium) REFERENCES bookingService.auditorium(id) ON DELETE CASCADE);
CREATE TABLE bookingservice.bookedTicket (
  id SERIAL PRIMARY KEY NOT NULL,
  idUser INT NOT NULL,
  nameEvent VARCHAR(255),
  seat VARCHAR(255),
  CONSTRAINT bookedTicket___fk_idUser FOREIGN KEY (idUser) REFERENCES bookingService.user(id) ON DELETE CASCADE ,
  CONSTRAINT bookedTicket___fk_nameEvent FOREIGN KEY (nameEvent, seat) REFERENCES bookingService.ticket(nameEvent, seat) ON DELETE CASCADE);
	   
INSERT INTO bookingService.user VALUES(1, 'User_1', 'a@epam.com', '1994-06-06');
INSERT INTO bookingService.user VALUES(2, 'User_2', 'b@epam.com', '1994-07-07');

INSERT INTO bookingService.auditorium VALUES(1, 'Auditorium_1', 20);
INSERT INTO bookingService.auditorium VALUES(2, 'Auditorium_2', 15);

INSERT INTO bookingService.vipSeats VALUES(1, 1, 10);
INSERT INTO bookingService.vipSeats VALUES(2, 1, 11);
INSERT INTO bookingService.vipSeats VALUES(3, 2, 7);
INSERT INTO bookingService.vipSeats VALUES(4, 2, 8);

INSERT INTO bookingService.event VALUES('Event_1', 'HIGH', 100, 120, '1994-05-05 17:00:00', 1);
INSERT INTO bookingService.event VALUES('Event_2', 'MID', 70, 90, '1994-07-07 18:00:00', 2);
INSERT INTO bookingService.event VALUES('Event_3', 'LOW', 50, 70, '1994-10-10 19:00:00', 1);

INSERT INTO bookingService.ticket VALUES('1', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('2', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('3', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('4', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('5', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('6', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('7', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('8', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('9', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('10', 'Event_1', 120);
INSERT INTO bookingService.ticket VALUES('11', 'Event_1', 120);
INSERT INTO bookingService.ticket VALUES('12', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('13', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('14', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('15', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('16', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('17', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('18', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('19', 'Event_1', 100);
INSERT INTO bookingService.ticket VALUES('20', 'Event_1', 100);

INSERT INTO bookingService.ticket VALUES('1', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('2', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('3', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('4', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('5', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('6', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('7', 'Event_2', 90);
INSERT INTO bookingService.ticket VALUES('8', 'Event_2', 90);
INSERT INTO bookingService.ticket VALUES('9', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('10', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('11', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('12', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('13', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('14', 'Event_2', 70);
INSERT INTO bookingService.ticket VALUES('15', 'Event_2', 70);

INSERT INTO bookingService.ticket VALUES('1', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('2', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('3', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('4', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('5', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('6', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('7', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('8', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('9', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('10', 'Event_3', 70);
INSERT INTO bookingService.ticket VALUES('11', 'Event_3', 70);
INSERT INTO bookingService.ticket VALUES('12', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('13', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('14', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('15', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('16', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('17', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('18', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('19', 'Event_3', 50);
INSERT INTO bookingService.ticket VALUES('20', 'Event_3', 50);