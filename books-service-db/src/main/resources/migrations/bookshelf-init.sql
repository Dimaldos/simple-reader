--liquibase formatted sql
--changeset dimaldos:bookshelf-init
create schema if not exists bookshelf;

create table bookshelf.books
(
    id          serial primary key,
    title       varchar(100) not null check ( length(trim(title)) > 0 ),
    author      varchar(100),
    description varchar(1000)
);

create table bookshelf.volumes
(
    id       serial primary key,
    title    varchar(100) not null check ( length(trim(title)) > 0 ),
    book_id  serial,
    position int          not null,
    foreign key (book_id) references bookshelf.books (id)
);

create table bookshelf.chapters
(
    id         serial primary key,
    title      varchar(100) not null check ( length(trim(title)) > 0 ),
    volume_id  serial       not null,
    position   int          not null,
    content_id serial unique,
    foreign key (volume_id) references bookshelf.volumes (id)
);

create table bookshelf.contents
(
    id      serial primary key,
    content jsonb,
    foreign key (id) references bookshelf.chapters (content_id)
);