-- Database: db_people

CREATE DATABASE IF NOT EXISTS db_people;
USE db_people;

CREATE TABLE IF NOT EXISTS person (
    id varchar(255) PRIMARY KEY,
    nama varchar(255) NOT NULL,
    thn_lahir int NOT NULL,
    kategori varchar(255) NOT NULL,
    jenis_kelamin varchar(255) NOT NULL
);

INSERT INTO person (id, nama, thn_lahir, kategori, jenis_kelamin) VALUES
('EMP001', 'Budi Santoso', 1992, 'Full-time', 'Laki-laki'),
('EMP002', 'Siti Aminah', 1997, 'Full-time', 'Perempuan'),
('EMP003', 'Rian Pratama', 1995, 'Contract', 'Laki-laki'),
('EMP004', 'Dewi Lestari', 1998, 'Part-time', 'Perempuan'),
('EMP005', 'Ahmad Fauzi', 2001, 'Internship', 'Laki-laki');