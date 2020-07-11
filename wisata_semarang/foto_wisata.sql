-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 11, 2020 at 09:27 PM
-- Server version: 10.2.32-MariaDB-cll-lve
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `micq6558_event`
--

-- --------------------------------------------------------

--
-- Table structure for table `foto_wisata`
--

CREATE TABLE `foto_wisata` (
  `id` int(10) NOT NULL,
  `nama_foto` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foto_wisata`
--

INSERT INTO `foto_wisata` (`id`, `nama_foto`) VALUES
(1, 'Screenshot_20200707-185239.png'),
(2, 'IMG-20200707-WA0008.jpg'),
(3, 'Screenshot_20200707-185206.png'),
(4, 'IMG-20200707-WA0006.jpg'),
(5, 'IMG-20200707-WA0005.jpg'),
(6, 'Screenshot_20200707-115924.png'),
(7, 'IMG-20200706-WA0004.jpg'),
(8, 'IMG_20200707_212321.jpg'),
(9, 'IMG_20200526_134648.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `foto_wisata`
--
ALTER TABLE `foto_wisata`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `foto_wisata`
--
ALTER TABLE `foto_wisata`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
