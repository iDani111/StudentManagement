-- Table: admin_tbl_code_pattern

-- DROP TABLE admin_tbl_code_pattern;

CREATE TABLE admin_tbl_code_pattern
(
  ser_pattern_id bigint NOT NULL,
  is_active boolean,
  num_last_key_value bigint,
  txt_code_pattern character varying(255),
  txt_code_pattern_for character varying(255),
  CONSTRAINT admin_tbl_code_pattern_pkey PRIMARY KEY (ser_pattern_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE admin_tbl_code_pattern
  OWNER TO postgres;


Code Pattern Configuration Script use for Student and Course

INSERT INTO admin_tbl_code_pattern(
            ser_pattern_id, is_active, num_last_key_value, txt_code_pattern, 
            txt_code_pattern_for)
    VALUES (1, true, 1, 'STD', 
            'student');


            
INSERT INTO admin_tbl_code_pattern(
            ser_pattern_id, is_active, num_last_key_value, txt_code_pattern, 
            txt_code_pattern_for)
    VALUES (2, true, 1, 'CRE', 
            'course');


-- Table: admin_tbl_users

-- DROP TABLE admin_tbl_users;

CREATE TABLE admin_tbl_users
(
  ser_user_id bigint NOT NULL,
  bln_active boolean,
  ser_student_id bigint,
  txt_password character varying(255),
  txt_user_name character varying(255),
  CONSTRAINT admin_tbl_users_pkey PRIMARY KEY (ser_user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE admin_tbl_users
  OWNER TO postgres;



-- Table: course_information

-- DROP TABLE course_information;

CREATE TABLE course_information
(
  ser_course_id bigint NOT NULL,
  bln_active boolean,
  num_credit_hours double precision,
  txt_course_code character varying(255),
  txt_course_name character varying(255),
  CONSTRAINT course_information_pkey PRIMARY KEY (ser_course_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE course_information
  OWNER TO postgres;



-- Table: student_information

-- DROP TABLE student_information;

CREATE TABLE student_information
(
  ser_student_id bigint NOT NULL,
  bln_active boolean,
  txt_first_name character varying(255),
  txt_last_name character varying(255),
  txt_student_code character varying(255),
  CONSTRAINT student_information_pkey PRIMARY KEY (ser_student_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE student_information
  OWNER TO postgres;




-- Table: student_course_registration

-- DROP TABLE student_course_registration;

CREATE TABLE student_course_registration
(
  ser_registration_id bigint NOT NULL,
  bln_active boolean,
  ser_course_id bigint,
  ser_student_id bigint,
  CONSTRAINT student_course_registration_pkey PRIMARY KEY (ser_registration_id),
  CONSTRAINT fk6ye47trfkc4dblcdvu3rvoo9r FOREIGN KEY (ser_course_id)
      REFERENCES course_information (ser_course_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkm4w0nih0y5s9k36q71ft9ujw2 FOREIGN KEY (ser_student_id)
      REFERENCES student_information (ser_student_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE student_course_registration
  OWNER TO postgres;
