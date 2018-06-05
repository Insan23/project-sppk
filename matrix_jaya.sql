-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2018 at 06:30 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `matrix_jaya`
--

-- --------------------------------------------------------

--
-- Table structure for table `alternatif_kriteria`
--

CREATE TABLE `alternatif_kriteria` (
  `id` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alternatif_kriteria`
--

INSERT INTO `alternatif_kriteria` (`id`, `id_produk`, `id_kriteria`, `nilai`) VALUES
(1, 1, 1, 5000),
(2, 1, 2, 100),
(3, 1, 3, 30),
(4, 1, 4, 10),
(5, 2, 1, 5000),
(6, 2, 2, 250),
(7, 2, 3, 30),
(8, 2, 4, 10),
(9, 3, 1, 20500),
(10, 3, 2, 100),
(11, 3, 3, 25),
(12, 3, 4, 70),
(13, 4, 1, 21000),
(14, 4, 2, 100),
(15, 4, 3, 25),
(16, 4, 4, 10),
(17, 5, 1, 10000),
(18, 5, 2, 150),
(19, 5, 3, 23),
(20, 5, 4, 10),
(21, 6, 1, 14000),
(22, 6, 2, 125),
(23, 6, 3, 25),
(24, 6, 4, 10),
(25, 7, 1, 20500),
(26, 7, 2, 100),
(27, 7, 3, 25),
(28, 7, 4, 70),
(29, 8, 1, 21000),
(30, 8, 2, 100),
(31, 8, 3, 25),
(32, 8, 4, 10),
(33, 9, 1, 14000),
(34, 9, 2, 100),
(35, 9, 3, 30),
(36, 9, 4, 30),
(37, 10, 1, 12500),
(38, 10, 2, 100),
(39, 10, 3, 25),
(40, 10, 4, 10);

-- --------------------------------------------------------

--
-- Table structure for table `kriteria`
--

CREATE TABLE `kriteria` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `bobot` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kriteria`
--

INSERT INTO `kriteria` (`id`, `nama`, `bobot`) VALUES
(1, 'Harga', 0.4),
(2, 'Kuantitas', 0.3),
(3, 'Tekstur', 0.1),
(4, 'Rasa', 0.2);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `kode_transaksi` varchar(20) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `kuantitas` int(11) NOT NULL,
  `total` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tipe` enum('Makanan Ringan','Makanan Berat','Makanan Penunjang') NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id`, `nama`, `tipe`, `harga`) VALUES
(1, 'Abon Catfish', 'Makanan Penunjang', 25000),
(2, 'Nugget Catfish', 'Makanan Berat', 25000),
(3, 'Keripik Catfish', 'Makanan Ringan', 9500),
(4, 'Stick Catfish', 'Makanan Ringan', 9000),
(5, 'Siomay Catfish', 'Makanan Berat', 20000),
(6, 'Widaran Catfish', 'Makanan Ringan', 16000),
(7, 'Keripik Duri Catfish', 'Makanan Ringan', 9500),
(8, 'Stick Duri Catfish', 'Makanan Ringan', 9000),
(9, 'Pastel Abon Catfish', 'Makanan Penunjang', 16000),
(10, 'Sumpia Abon Catfish', 'Makanan Penunjang', 17500);

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `id` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `terakhir_diperbarui` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stok`
--

INSERT INTO `stok` (`id`, `id_produk`, `stok`, `terakhir_diperbarui`) VALUES
(1, 1, 200, '2018-06-04'),
(2, 2, 200, '2018-06-04'),
(3, 3, 200, '2018-06-04'),
(4, 4, 200, '2018-06-04'),
(5, 5, 200, '2018-06-04'),
(6, 6, 200, '2018-06-04'),
(7, 7, 200, '2018-06-04'),
(8, 8, 200, '2018-06-04'),
(9, 9, 200, '2018-06-04'),
(10, 10, 200, '2018-06-04');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `level`) VALUES
(1, 'kasir', 'kasir', 'kasir'),
(2, 'produksi', 'produksi', 'gudang'),
(3, 'pemilik', 'pemilik', 'pemilik'),
(4, 'admin', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alternatif_kriteria`
--
ALTER TABLE `alternatif_kriteria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kriteria` (`id_kriteria`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alternatif_kriteria`
--
ALTER TABLE `alternatif_kriteria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `kriteria`
--
ALTER TABLE `kriteria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `stok`
--
ALTER TABLE `stok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alternatif_kriteria`
--
ALTER TABLE `alternatif_kriteria`
  ADD CONSTRAINT `alternatif_kriteria_ibfk_1` FOREIGN KEY (`id_kriteria`) REFERENCES `kriteria` (`id`),
  ADD CONSTRAINT `alternatif_kriteria_ibfk_2` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id`);

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id`);

--
-- Constraints for table `stok`
--
ALTER TABLE `stok`
  ADD CONSTRAINT `stok_ibfk_1` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
