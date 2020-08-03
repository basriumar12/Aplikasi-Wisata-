-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 11, 2020 at 09:26 PM
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
-- Table structure for table `tbl_wisata`
--

CREATE TABLE `tbl_wisata` (
  `id_wisata` int(11) NOT NULL,
  `nama_wisata` varchar(200) NOT NULL,
  `gambar_wisata` varchar(200) NOT NULL,
  `deksripsi_wisata` text NOT NULL,
  `alamat_wisata` text NOT NULL,
  `event_wisata` varchar(200) NOT NULL,
  `latitude_wisata` varchar(20) NOT NULL,
  `longitude_wisata` varchar(20) NOT NULL,
  `gambar2` varchar(200) NOT NULL,
  `gambar1` varchar(200) NOT NULL,
  `gambar3` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_wisata`
--

INSERT INTO `tbl_wisata` (`id_wisata`, `nama_wisata`, `gambar_wisata`, `deksripsi_wisata`, `alamat_wisata`, `event_wisata`, `latitude_wisata`, `longitude_wisata`, `gambar2`, `gambar1`, `gambar3`) VALUES
(34, 'Pantai Pasir Putih 1', 'SAY05118.jpg', 'Ongkos ojek dari kota ke tempat wisata 100.000 ribu rupiah', 'Jln. Fakfak sanggram, kampung pasir putih', 'Tidak ada event', '-2.9545425', '132.3465273', '0', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_wisata`
--
ALTER TABLE `tbl_wisata`
  ADD PRIMARY KEY (`id_wisata`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_wisata`
--
ALTER TABLE `tbl_wisata`
  MODIFY `id_wisata` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
