--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4 (Debian 14.4-1.pgdg110+1)
-- Dumped by pg_dump version 14.4 (Debian 14.4-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: auth; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA auth;


ALTER SCHEMA auth OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: group; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth."group" (
    id bigint NOT NULL,
    name character varying(64) NOT NULL,
    father_id bigint
);


ALTER TABLE auth."group" OWNER TO postgres;

--
-- Name: group_id_seq; Type: SEQUENCE; Schema: auth; Owner: postgres
--

CREATE SEQUENCE auth.group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auth.group_id_seq OWNER TO postgres;

--
-- Name: group_id_seq; Type: SEQUENCE OWNED BY; Schema: auth; Owner: postgres
--

ALTER SEQUENCE auth.group_id_seq OWNED BY auth."group".id;


--
-- Name: grouppermission; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth.grouppermission (
    id bigint NOT NULL,
    group_id bigint,
    permission_id bigint
);


ALTER TABLE auth.grouppermission OWNER TO postgres;

--
-- Name: grouppermission_id_seq; Type: SEQUENCE; Schema: auth; Owner: postgres
--

CREATE SEQUENCE auth.grouppermission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auth.grouppermission_id_seq OWNER TO postgres;

--
-- Name: grouppermission_id_seq; Type: SEQUENCE OWNED BY; Schema: auth; Owner: postgres
--

ALTER SEQUENCE auth.grouppermission_id_seq OWNED BY auth.grouppermission.id;


--
-- Name: grouproles; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth.grouproles (
    group_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE auth.grouproles OWNER TO postgres;

--
-- Name: groupusers; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth.groupusers (
    group_id bigint NOT NULL,
    user_id bigint NOT NULL
);


ALTER TABLE auth.groupusers OWNER TO postgres;

--
-- Name: permission; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth.permission (
    id bigint NOT NULL,
    code character varying(12) NOT NULL
);


ALTER TABLE auth.permission OWNER TO postgres;

--
-- Name: permission_id_seq; Type: SEQUENCE; Schema: auth; Owner: postgres
--

CREATE SEQUENCE auth.permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auth.permission_id_seq OWNER TO postgres;

--
-- Name: permission_id_seq; Type: SEQUENCE OWNED BY; Schema: auth; Owner: postgres
--

ALTER SEQUENCE auth.permission_id_seq OWNED BY auth.permission.id;


--
-- Name: role; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth.role (
    id bigint NOT NULL,
    name character varying(64) NOT NULL,
    father_id bigint
);


ALTER TABLE auth.role OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE; Schema: auth; Owner: postgres
--

CREATE SEQUENCE auth.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auth.role_id_seq OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: auth; Owner: postgres
--

ALTER SEQUENCE auth.role_id_seq OWNED BY auth.role.id;


--
-- Name: rolepermission; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth.rolepermission (
    id bigint NOT NULL,
    permission_id bigint,
    role_id bigint
);


ALTER TABLE auth.rolepermission OWNER TO postgres;

--
-- Name: rolepermission_id_seq; Type: SEQUENCE; Schema: auth; Owner: postgres
--

CREATE SEQUENCE auth.rolepermission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auth.rolepermission_id_seq OWNER TO postgres;

--
-- Name: rolepermission_id_seq; Type: SEQUENCE OWNED BY; Schema: auth; Owner: postgres
--

ALTER SEQUENCE auth.rolepermission_id_seq OWNED BY auth.rolepermission.id;


--
-- Name: user; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth."user" (
    id bigint NOT NULL,
    name character varying(64) NOT NULL,
    password character varying(128) NOT NULL,
    loginname character varying(64) NOT NULL
);


ALTER TABLE auth."user" OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: auth; Owner: postgres
--

CREATE SEQUENCE auth.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auth.user_id_seq OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: auth; Owner: postgres
--

ALTER SEQUENCE auth.user_id_seq OWNED BY auth."user".id;


--
-- Name: userpermission; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth.userpermission (
    id bigint NOT NULL,
    permission_id bigint,
    user_id bigint
);


ALTER TABLE auth.userpermission OWNER TO postgres;

--
-- Name: userpermission_id_seq; Type: SEQUENCE; Schema: auth; Owner: postgres
--

CREATE SEQUENCE auth.userpermission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE auth.userpermission_id_seq OWNER TO postgres;

--
-- Name: userpermission_id_seq; Type: SEQUENCE OWNED BY; Schema: auth; Owner: postgres
--

ALTER SEQUENCE auth.userpermission_id_seq OWNED BY auth.userpermission.id;


--
-- Name: userroles; Type: TABLE; Schema: auth; Owner: postgres
--

CREATE TABLE auth.userroles (
    role_id bigint NOT NULL,
    user_id bigint NOT NULL
);


ALTER TABLE auth.userroles OWNER TO postgres;

--
-- Name: oauth2_registered_client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.oauth2_registered_client (
    id character varying(100) NOT NULL,
    client_id character varying(100) NOT NULL,
    client_id_issued_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_secret character varying(200),
    client_secret_expires_at timestamp without time zone,
    client_name character varying(200) NOT NULL,
    client_authentication_methods character varying(1000) NOT NULL,
    authorization_grant_types character varying(1000) NOT NULL,
    redirect_uris character varying(1000),
    scopes character varying(1000) NOT NULL,
    client_settings character varying(2000) NOT NULL,
    token_settings character varying(2000) NOT NULL
);


ALTER TABLE public.oauth2_registered_client OWNER TO postgres;

--
-- Name: group id; Type: DEFAULT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth."group" ALTER COLUMN id SET DEFAULT nextval('auth.group_id_seq'::regclass);


--
-- Name: grouppermission id; Type: DEFAULT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.grouppermission ALTER COLUMN id SET DEFAULT nextval('auth.grouppermission_id_seq'::regclass);


--
-- Name: permission id; Type: DEFAULT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.permission ALTER COLUMN id SET DEFAULT nextval('auth.permission_id_seq'::regclass);


--
-- Name: role id; Type: DEFAULT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.role ALTER COLUMN id SET DEFAULT nextval('auth.role_id_seq'::regclass);


--
-- Name: rolepermission id; Type: DEFAULT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.rolepermission ALTER COLUMN id SET DEFAULT nextval('auth.rolepermission_id_seq'::regclass);


--
-- Name: user id; Type: DEFAULT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth."user" ALTER COLUMN id SET DEFAULT nextval('auth.user_id_seq'::regclass);


--
-- Name: userpermission id; Type: DEFAULT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.userpermission ALTER COLUMN id SET DEFAULT nextval('auth.userpermission_id_seq'::regclass);


--
-- Data for Name: group; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth."group" (id, name, father_id) FROM stdin;
\.


--
-- Data for Name: grouppermission; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth.grouppermission (id, group_id, permission_id) FROM stdin;
\.


--
-- Data for Name: grouproles; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth.grouproles (group_id, role_id) FROM stdin;
\.


--
-- Data for Name: groupusers; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth.groupusers (group_id, user_id) FROM stdin;
\.


--
-- Data for Name: permission; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth.permission (id, code) FROM stdin;
1	0001
2	0002
3	0003
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth.role (id, name, father_id) FROM stdin;
\.


--
-- Data for Name: rolepermission; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth.rolepermission (id, permission_id, role_id) FROM stdin;
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth."user" (id, name, password, loginname) FROM stdin;
1	test	$2a$10$jaMggtzdwL4bM5xvk6x7POdg5h7zs3WIfHShVDWu.gI4h4Y7c3qti	test
\.


--
-- Data for Name: userpermission; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth.userpermission (id, permission_id, user_id) FROM stdin;
\.


--
-- Data for Name: userroles; Type: TABLE DATA; Schema: auth; Owner: postgres
--

COPY auth.userroles (role_id, user_id) FROM stdin;
\.


--
-- Data for Name: oauth2_registered_client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.oauth2_registered_client (id, client_id, client_id_issued_at, client_secret, client_secret_expires_at, client_name, client_authentication_methods, authorization_grant_types, redirect_uris, scopes, client_settings, token_settings) FROM stdin;
84a30d13-4a16-477d-94f3-a75c1a2f8afe	client1	2022-11-26 11:35:44.449414	$2a$10$ZY0YHDKG89ZhHYmBuThb3ekdH443deeAp27Ni0Vcr/uwOJMRK2f12	\N	84a30d13-4a16-477d-94f3-a75c1a2f8afe	client_secret_basic	refresh_token,authorization_code	http://domicilio:8080/login/oauth2/code/users-client-oidc,http://domicilio:8080/authorized	read,openid	{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}	{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.core.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000]}
\.


--
-- Name: group_id_seq; Type: SEQUENCE SET; Schema: auth; Owner: postgres
--

SELECT pg_catalog.setval('auth.group_id_seq', 1, false);


--
-- Name: grouppermission_id_seq; Type: SEQUENCE SET; Schema: auth; Owner: postgres
--

SELECT pg_catalog.setval('auth.grouppermission_id_seq', 1, false);


--
-- Name: permission_id_seq; Type: SEQUENCE SET; Schema: auth; Owner: postgres
--

SELECT pg_catalog.setval('auth.permission_id_seq', 3, true);


--
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: auth; Owner: postgres
--

SELECT pg_catalog.setval('auth.role_id_seq', 1, false);


--
-- Name: rolepermission_id_seq; Type: SEQUENCE SET; Schema: auth; Owner: postgres
--

SELECT pg_catalog.setval('auth.rolepermission_id_seq', 1, false);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: auth; Owner: postgres
--

SELECT pg_catalog.setval('auth.user_id_seq', 1, true);


--
-- Name: userpermission_id_seq; Type: SEQUENCE SET; Schema: auth; Owner: postgres
--

SELECT pg_catalog.setval('auth.userpermission_id_seq', 1, false);


--
-- Name: group group_pkey; Type: CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth."group"
    ADD CONSTRAINT group_pkey PRIMARY KEY (id);


--
-- Name: grouppermission grouppermission_pkey; Type: CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.grouppermission
    ADD CONSTRAINT grouppermission_pkey PRIMARY KEY (id);


--
-- Name: permission permission_pkey; Type: CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: rolepermission rolepermission_pkey; Type: CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.rolepermission
    ADD CONSTRAINT rolepermission_pkey PRIMARY KEY (id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: userpermission userpermission_pkey; Type: CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.userpermission
    ADD CONSTRAINT userpermission_pkey PRIMARY KEY (id);


--
-- Name: oauth2_registered_client oauth2_registered_client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.oauth2_registered_client
    ADD CONSTRAINT oauth2_registered_client_pkey PRIMARY KEY (id);


--
-- Name: rolepermission fk14kirk7t76s89r7er6c6ircbe; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.rolepermission
    ADD CONSTRAINT fk14kirk7t76s89r7er6c6ircbe FOREIGN KEY (permission_id) REFERENCES auth.permission(id);


--
-- Name: grouppermission fk1py9m9ih1oqbglvi63h52t0n9; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.grouppermission
    ADD CONSTRAINT fk1py9m9ih1oqbglvi63h52t0n9 FOREIGN KEY (group_id) REFERENCES auth."group"(id);


--
-- Name: grouppermission fk3s6bo92c3oe1cayp4ka1s8uy5; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.grouppermission
    ADD CONSTRAINT fk3s6bo92c3oe1cayp4ka1s8uy5 FOREIGN KEY (permission_id) REFERENCES auth.permission(id);


--
-- Name: userpermission fk5j6kxx2g0pxrd8ht2ss9e0uoe; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.userpermission
    ADD CONSTRAINT fk5j6kxx2g0pxrd8ht2ss9e0uoe FOREIGN KEY (permission_id) REFERENCES auth.permission(id);


--
-- Name: userroles fk8my9q4fh52cpbn3ql49aoqtu8; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.userroles
    ADD CONSTRAINT fk8my9q4fh52cpbn3ql49aoqtu8 FOREIGN KEY (role_id) REFERENCES auth.role(id);


--
-- Name: groupusers fkbvp9i8cbp3nyvvocxsruq3b3x; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.groupusers
    ADD CONSTRAINT fkbvp9i8cbp3nyvvocxsruq3b3x FOREIGN KEY (user_id) REFERENCES auth."user"(id);


--
-- Name: grouproles fke64nvrd6jn1f92bhqwnattg8e; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.grouproles
    ADD CONSTRAINT fke64nvrd6jn1f92bhqwnattg8e FOREIGN KEY (role_id) REFERENCES auth.role(id);


--
-- Name: rolepermission fkfa75v4h0djvvrq0pqrh0x9n3m; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.rolepermission
    ADD CONSTRAINT fkfa75v4h0djvvrq0pqrh0x9n3m FOREIGN KEY (role_id) REFERENCES auth.role(id);


--
-- Name: groupusers fklhodshd1gj5ud7upbo54us593; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.groupusers
    ADD CONSTRAINT fklhodshd1gj5ud7upbo54us593 FOREIGN KEY (group_id) REFERENCES auth."group"(id);


--
-- Name: role fkmicflpj0726xhtn1iv56emjhe; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.role
    ADD CONSTRAINT fkmicflpj0726xhtn1iv56emjhe FOREIGN KEY (father_id) REFERENCES auth.role(id);


--
-- Name: userroles fkoxgydmg26io5fqwy8gb7dbn14; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.userroles
    ADD CONSTRAINT fkoxgydmg26io5fqwy8gb7dbn14 FOREIGN KEY (user_id) REFERENCES auth."user"(id);


--
-- Name: grouproles fkp58uqf5r712qjs06gtgx4lkpa; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.grouproles
    ADD CONSTRAINT fkp58uqf5r712qjs06gtgx4lkpa FOREIGN KEY (group_id) REFERENCES auth."group"(id);


--
-- Name: group fkq91vv8kn6jpfrf0l6rce1xjw7; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth."group"
    ADD CONSTRAINT fkq91vv8kn6jpfrf0l6rce1xjw7 FOREIGN KEY (father_id) REFERENCES auth."group"(id);


--
-- Name: userpermission fks5wddn2j2872axd91k4heuvoe; Type: FK CONSTRAINT; Schema: auth; Owner: postgres
--

ALTER TABLE ONLY auth.userpermission
    ADD CONSTRAINT fks5wddn2j2872axd91k4heuvoe FOREIGN KEY (user_id) REFERENCES auth."user"(id);


--
-- PostgreSQL database dump complete
--

