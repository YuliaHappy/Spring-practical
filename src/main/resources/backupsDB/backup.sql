--
-- PostgreSQL database cluster dump
--

-- Started on 2016-06-28 16:37:25

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION PASSWORD 'md5738d021d4bc194576641fa9936656836';






--
-- Database creation
--

REVOKE ALL ON DATABASE template1 FROM PUBLIC;
REVOKE ALL ON DATABASE template1 FROM postgres;
GRANT ALL ON DATABASE template1 TO postgres;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.3.3
-- Started on 2016-06-28 16:37:25

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2002 (class 1262 OID 12029)
-- Dependencies: 2001
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 7 (class 2615 OID 16393)
-- Name: bookingservice; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA bookingservice;


ALTER SCHEMA bookingservice OWNER TO postgres;

--
-- TOC entry 182 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2005 (class 0 OID 0)
-- Dependencies: 182
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 181 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2006 (class 0 OID 0)
-- Dependencies: 181
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = bookingservice, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 16404)
-- Name: auditorium; Type: TABLE; Schema: bookingservice; Owner: postgres; Tablespace: 
--

CREATE TABLE auditorium (
    id integer NOT NULL,
    name character varying(255),
    countofseats integer
);


ALTER TABLE bookingservice.auditorium OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 16527)
-- Name: auditorium_id_seq; Type: SEQUENCE; Schema: bookingservice; Owner: postgres
--

CREATE SEQUENCE auditorium_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bookingservice.auditorium_id_seq OWNER TO postgres;

--
-- TOC entry 2007 (class 0 OID 0)
-- Dependencies: 180
-- Name: auditorium_id_seq; Type: SEQUENCE OWNED BY; Schema: bookingservice; Owner: postgres
--

ALTER SEQUENCE auditorium_id_seq OWNED BY auditorium.id;


--
-- TOC entry 178 (class 1259 OID 16496)
-- Name: bookedticket; Type: TABLE; Schema: bookingservice; Owner: postgres; Tablespace: 
--

CREATE TABLE bookedticket (
    id integer NOT NULL,
    iduser integer NOT NULL,
    nameevent character varying(255),
    seat character varying(255)
);


ALTER TABLE bookingservice.bookedticket OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16494)
-- Name: bookedticket_id_seq; Type: SEQUENCE; Schema: bookingservice; Owner: postgres
--

CREATE SEQUENCE bookedticket_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bookingservice.bookedticket_id_seq OWNER TO postgres;

--
-- TOC entry 2008 (class 0 OID 0)
-- Dependencies: 177
-- Name: bookedticket_id_seq; Type: SEQUENCE OWNED BY; Schema: bookingservice; Owner: postgres
--

ALTER SEQUENCE bookedticket_id_seq OWNED BY bookedticket.id;


--
-- TOC entry 174 (class 1259 OID 16430)
-- Name: event; Type: TABLE; Schema: bookingservice; Owner: postgres; Tablespace: 
--

CREATE TABLE event (
    name character varying(255) NOT NULL,
    rating character varying(5) NOT NULL,
    baseprice integer NOT NULL,
    vipprice integer NOT NULL,
    datetime timestamp without time zone NOT NULL,
    idauditorium integer,
    CONSTRAINT event_rating_check CHECK (((rating)::text = ANY ((ARRAY['HIGH'::character varying, 'MID'::character varying, 'LOW'::character varying])::text[])))
);


ALTER TABLE bookingservice.event OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16444)
-- Name: ticket; Type: TABLE; Schema: bookingservice; Owner: postgres; Tablespace: 
--

CREATE TABLE ticket (
    seat character varying(255) NOT NULL,
    nameevent character varying(255) NOT NULL,
    price double precision,
    isbought boolean DEFAULT false
);


ALTER TABLE bookingservice.ticket OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16394)
-- Name: user; Type: TABLE; Schema: bookingservice; Owner: postgres; Tablespace: 
--

CREATE TABLE "user" (
    id integer NOT NULL,
    name character varying(255),
    email character varying(255),
    birthday date NOT NULL,
    isregistered boolean DEFAULT false
);


ALTER TABLE bookingservice."user" OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16441)
-- Name: user_id_seq; Type: SEQUENCE; Schema: bookingservice; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bookingservice.user_id_seq OWNER TO postgres;

--
-- TOC entry 2009 (class 0 OID 0)
-- Dependencies: 175
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: bookingservice; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 173 (class 1259 OID 16414)
-- Name: vipseats; Type: TABLE; Schema: bookingservice; Owner: postgres; Tablespace: 
--

CREATE TABLE vipseats (
    id integer NOT NULL,
    idauditorium integer,
    numberseat integer NOT NULL
);


ALTER TABLE bookingservice.vipseats OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 16524)
-- Name: vipseats_id_seq; Type: SEQUENCE; Schema: bookingservice; Owner: postgres
--

CREATE SEQUENCE vipseats_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bookingservice.vipseats_id_seq OWNER TO postgres;

--
-- TOC entry 2010 (class 0 OID 0)
-- Dependencies: 179
-- Name: vipseats_id_seq; Type: SEQUENCE OWNED BY; Schema: bookingservice; Owner: postgres
--

ALTER SEQUENCE vipseats_id_seq OWNED BY vipseats.id;


--
-- TOC entry 1856 (class 2604 OID 16529)
-- Name: id; Type: DEFAULT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY auditorium ALTER COLUMN id SET DEFAULT nextval('auditorium_id_seq'::regclass);


--
-- TOC entry 1860 (class 2604 OID 16499)
-- Name: id; Type: DEFAULT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY bookedticket ALTER COLUMN id SET DEFAULT nextval('bookedticket_id_seq'::regclass);


--
-- TOC entry 1854 (class 2604 OID 16443)
-- Name: id; Type: DEFAULT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 1857 (class 2604 OID 16526)
-- Name: id; Type: DEFAULT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY vipseats ALTER COLUMN id SET DEFAULT nextval('vipseats_id_seq'::regclass);


--
-- TOC entry 1988 (class 0 OID 16404)
-- Dependencies: 172
-- Data for Name: auditorium; Type: TABLE DATA; Schema: bookingservice; Owner: postgres
--

COPY auditorium (id, name, countofseats) FROM stdin;
1	Auditorium_1	20
2	Auditorium_2	15
\.


--
-- TOC entry 2011 (class 0 OID 0)
-- Dependencies: 180
-- Name: auditorium_id_seq; Type: SEQUENCE SET; Schema: bookingservice; Owner: postgres
--

SELECT pg_catalog.setval('auditorium_id_seq', 4, true);


--
-- TOC entry 1994 (class 0 OID 16496)
-- Dependencies: 178
-- Data for Name: bookedticket; Type: TABLE DATA; Schema: bookingservice; Owner: postgres
--

COPY bookedticket (id, iduser, nameevent, seat) FROM stdin;
\.


--
-- TOC entry 2012 (class 0 OID 0)
-- Dependencies: 177
-- Name: bookedticket_id_seq; Type: SEQUENCE SET; Schema: bookingservice; Owner: postgres
--

SELECT pg_catalog.setval('bookedticket_id_seq', 1, false);


--
-- TOC entry 1990 (class 0 OID 16430)
-- Dependencies: 174
-- Data for Name: event; Type: TABLE DATA; Schema: bookingservice; Owner: postgres
--

COPY event (name, rating, baseprice, vipprice, datetime, idauditorium) FROM stdin;
Event_1	HIGH	100	120	1994-05-05 17:00:00	1
Event_2	MID	70	90	1994-07-07 18:00:00	2
Event_3	LOW	50	70	1994-11-11 19:00:00	1
\.


--
-- TOC entry 1992 (class 0 OID 16444)
-- Dependencies: 176
-- Data for Name: ticket; Type: TABLE DATA; Schema: bookingservice; Owner: postgres
--

COPY ticket (seat, nameevent, price, isbought) FROM stdin;
1	Event_1	100	f
2	Event_1	100	f
3	Event_1	100	f
4	Event_1	100	f
5	Event_1	100	f
6	Event_1	100	f
7	Event_1	100	f
8	Event_1	100	f
9	Event_1	100	f
10	Event_1	120	f
11	Event_1	120	f
12	Event_1	100	f
13	Event_1	100	f
14	Event_1	100	f
15	Event_1	100	f
16	Event_1	100	f
17	Event_1	100	f
18	Event_1	100	f
19	Event_1	100	f
20	Event_1	100	f
1	Event_2	70	f
2	Event_2	70	f
3	Event_2	70	f
4	Event_2	70	f
5	Event_2	70	f
6	Event_2	70	f
7	Event_2	90	f
8	Event_2	90	f
9	Event_2	70	f
10	Event_2	70	f
11	Event_2	70	f
12	Event_2	70	f
13	Event_2	70	f
14	Event_2	70	f
15	Event_2	70	f
1	Event_3	50	f
2	Event_3	50	f
3	Event_3	50	f
4	Event_3	50	f
5	Event_3	50	f
6	Event_3	50	f
7	Event_3	50	f
8	Event_3	50	f
9	Event_3	50	f
10	Event_3	70	f
11	Event_3	70	f
12	Event_3	50	f
13	Event_3	50	f
14	Event_3	50	f
15	Event_3	50	f
16	Event_3	50	f
17	Event_3	50	f
18	Event_3	50	f
19	Event_3	50	f
20	Event_3	50	f
\.


--
-- TOC entry 1987 (class 0 OID 16394)
-- Dependencies: 171
-- Data for Name: user; Type: TABLE DATA; Schema: bookingservice; Owner: postgres
--

COPY "user" (id, name, email, birthday, isregistered) FROM stdin;
2	User_2	b@epam.com	1994-07-07	f
1	User_1	a@epam.com	1994-06-06	f
4	User_3	c@epam.com	1994-12-12	f
5	User_4	d@epam.com	2009-11-03	f
\.


--
-- TOC entry 2013 (class 0 OID 0)
-- Dependencies: 175
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: bookingservice; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 15, true);


--
-- TOC entry 1989 (class 0 OID 16414)
-- Dependencies: 173
-- Data for Name: vipseats; Type: TABLE DATA; Schema: bookingservice; Owner: postgres
--

COPY vipseats (id, idauditorium, numberseat) FROM stdin;
1	1	10
2	1	11
3	2	7
4	2	8
\.


--
-- TOC entry 2014 (class 0 OID 0)
-- Dependencies: 179
-- Name: vipseats_id_seq; Type: SEQUENCE SET; Schema: bookingservice; Owner: postgres
--

SELECT pg_catalog.setval('vipseats_id_seq', 1, false);


--
-- TOC entry 1866 (class 2606 OID 16408)
-- Name: auditorium_pkey; Type: CONSTRAINT; Schema: bookingservice; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY auditorium
    ADD CONSTRAINT auditorium_pkey PRIMARY KEY (id);


--
-- TOC entry 1874 (class 2606 OID 16504)
-- Name: bookedticket_pkey; Type: CONSTRAINT; Schema: bookingservice; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bookedticket
    ADD CONSTRAINT bookedticket_pkey PRIMARY KEY (id);


--
-- TOC entry 1870 (class 2606 OID 16435)
-- Name: event_pkey; Type: CONSTRAINT; Schema: bookingservice; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY event
    ADD CONSTRAINT event_pkey PRIMARY KEY (name);


--
-- TOC entry 1872 (class 2606 OID 16461)
-- Name: ticket_seat_nameevent_pk; Type: CONSTRAINT; Schema: bookingservice; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ticket
    ADD CONSTRAINT ticket_seat_nameevent_pk PRIMARY KEY (seat, nameevent);


--
-- TOC entry 1862 (class 2606 OID 16403)
-- Name: user_email_key; Type: CONSTRAINT; Schema: bookingservice; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_email_key UNIQUE (email);


--
-- TOC entry 1864 (class 2606 OID 16401)
-- Name: user_pkey; Type: CONSTRAINT; Schema: bookingservice; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 1868 (class 2606 OID 16418)
-- Name: vipseats_pkey; Type: CONSTRAINT; Schema: bookingservice; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vipseats
    ADD CONSTRAINT vipseats_pkey PRIMARY KEY (id);


--
-- TOC entry 1878 (class 2606 OID 16505)
-- Name: bookedticket___fk_iduser; Type: FK CONSTRAINT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY bookedticket
    ADD CONSTRAINT bookedticket___fk_iduser FOREIGN KEY (iduser) REFERENCES "user"(id) ON DELETE CASCADE;


--
-- TOC entry 1879 (class 2606 OID 16510)
-- Name: bookedticket___fk_nameevent; Type: FK CONSTRAINT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY bookedticket
    ADD CONSTRAINT bookedticket___fk_nameevent FOREIGN KEY (nameevent, seat) REFERENCES ticket(nameevent, seat) ON DELETE CASCADE;


--
-- TOC entry 1876 (class 2606 OID 16436)
-- Name: event_idauditorium_fkey; Type: FK CONSTRAINT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY event
    ADD CONSTRAINT event_idauditorium_fkey FOREIGN KEY (idauditorium) REFERENCES auditorium(id) ON DELETE CASCADE;


--
-- TOC entry 1877 (class 2606 OID 16453)
-- Name: ticket_nameevent_fkey; Type: FK CONSTRAINT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY ticket
    ADD CONSTRAINT ticket_nameevent_fkey FOREIGN KEY (nameevent) REFERENCES event(name) ON DELETE CASCADE;


--
-- TOC entry 1875 (class 2606 OID 16419)
-- Name: vipseats_idauditorium_fkey; Type: FK CONSTRAINT; Schema: bookingservice; Owner: postgres
--

ALTER TABLE ONLY vipseats
    ADD CONSTRAINT vipseats_idauditorium_fkey FOREIGN KEY (idauditorium) REFERENCES auditorium(id) ON DELETE CASCADE;


--
-- TOC entry 2004 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-06-28 16:37:25

--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.3
-- Dumped by pg_dump version 9.3.3
-- Started on 2016-06-28 16:37:25

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1929 (class 1262 OID 1)
-- Dependencies: 1928
-- Name: template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- TOC entry 170 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1932 (class 0 OID 0)
-- Dependencies: 170
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1931 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-06-28 16:37:26

--
-- PostgreSQL database dump complete
--

-- Completed on 2016-06-28 16:37:26

--
-- PostgreSQL database cluster dump complete
--

