create table if not exists public.employee
(
    first_name character varying(50) not null,
    last_name  character varying(50) not null,
    salary     integer,
    address    text,
    phone      character varying(50),
    id         integer primary key   not null
);

