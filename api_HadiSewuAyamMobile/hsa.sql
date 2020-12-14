-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2020 at 08:10 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hsa`
--

-- --------------------------------------------------------

--
-- Table structure for table `hadisewu_sales_visit`
--

CREATE TABLE `hadisewu_sales_visit` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nama` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pemilik` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `area` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `kontak` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `ttl` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `penanggungjawab` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tanggal_kunjungan` date DEFAULT NULL,
  `kebutuhan` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `keterangan` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gambar` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hadisewu_sales_visit`
--

INSERT INTO `hadisewu_sales_visit` (`id`, `nama`, `pemilik`, `alamat`, `area`, `kontak`, `ttl`, `penanggungjawab`, `tanggal_kunjungan`, `kebutuhan`, `keterangan`, `gambar`, `created_at`, `updated_at`) VALUES
(5, 'Hadi Sewu Ayam', 'hadigrup.com', 'jl. pleret ', 'Barat', '085251419621', '2020-12-25 18:28:05', 'hadi', '2020-12-31', 'ayam', '3 kilo', NULL, NULL, NULL),
(6, 'man', 'man', 'mann', 'Kota', '0852', '2020-12-26 18:12:43', 'man', '2020-12-11', 'man', 'man', NULL, NULL, NULL),
(8, 'sewu', 'man', 'jl. ringroad', 'Barat', '0852464', '2020-12-05 19:09:09', 'man', '2020-12-31', 'ayam', 'aku ', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `created_at`, `updated_at`) VALUES
(34, 'Emanuel Krowe Goran', 'emanuelkrowegoran@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', '2020-12-14 09:18:58', NULL),
(35, 'Lea', 'emanuelkrowe@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', '2020-12-14 14:09:57', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hadisewu_sales_visit`
--
ALTER TABLE `hadisewu_sales_visit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hadisewu_sales_visit`
--
ALTER TABLE `hadisewu_sales_visit`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
