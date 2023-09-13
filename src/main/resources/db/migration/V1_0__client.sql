DROP TABLE if EXISTS user_roles ;
DROP TABLE if EXISTS roles ;

CREATE TABLE roles (
    ID  SERIAL PRIMARY KEY,
    NAME TEXT NOT NULL
);

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');


DROP TABLE if EXISTS users ;

CREATE TABLE users(
    ID  SERIAL PRIMARY KEY,
    username character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    is_active boolean NOT NULL DEFAULT true,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL
);
CREATE UNIQUE INDEX users_username_key ON "users" USING btree ("username");

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id INT NOT NULL,
    Foreign Key (user_id) REFERENCES users(id),
    Foreign Key (role_id) REFERENCES roles(id),
    UNIQUE (user_id,role_id)
);

DROP TABLE if EXISTS files ;
CREATE TABLE files(
    ID SERIAL PRIMARY KEY,
    "data" oid,
    file_name character varying(255),
    file_type character varying(255),
    is_folder boolean NOT NULL DEFAULT true,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    folder_id BIGINT default null,
    user_id BIGINT NOT NULL,
    Foreign Key (user_id) REFERENCES users(id),
    UNIQUE (file_name, file_type, user_id)
);
