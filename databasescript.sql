-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.cities
(
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employees
(
    user_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying(200) NOT NULL,
    web_address character varying(150) NOT NULL,
    phone_number character varying(20) NOT NULL,
    is_verified boolean NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.employers_verification_employees
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    employee_id integer NOT NULL,
    created_at date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL,
    job_title character varying(255) NOT NULL,
    created_at date,
    is_active boolean,
    is_deleted boolean,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_postings
(
    id integer NOT NULL,
    description character varying(100) NOT NULL,
    salary_min integer NOT NULL,
    salary_max integer NOT NULL,
    open_positions integer NOT NULL,
    published_at date NOT NULL,
    created_at date NOT NULL,
    is_active boolean NOT NULL,
    is_deleted boolean NOT NULL,
    deadline date NOT NULL,
    is_open boolean NOT NULL,
    city_id integer NOT NULL,
    employer_id integer NOT NULL,
    job_position_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.jobseekers
(
    user_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    national_id character varying(11) NOT NULL,
    is_verified boolean NOT NULL,
    date_of_birth date NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying(150) NOT NULL,
    password character varying(40) NOT NULL,
    created_at date NOT NULL,
    is_active boolean NOT NULL,
    is_deleted boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.verification_codes
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    code character varying(50) NOT NULL,
    is_confirmed boolean NOT NULL,
    created_at date NOT NULL,
    user_id integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.employees
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers_verification_employees
    ADD FOREIGN KEY (employee_id)
    REFERENCES public.employees (user_id)
    NOT VALID;


ALTER TABLE public.employers_verification_employees
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (city_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_postings
    ADD FOREIGN KEY (job_position_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.jobseekers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.verification_codes
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.verification_codes
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;

END;