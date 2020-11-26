-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2020 at 07:52 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tour`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `A_id` varchar(5) NOT NULL,
  `A_name` varchar(20) NOT NULL,
  `A_pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`A_id`, `A_name`, `A_pass`) VALUES
('A001', 'supriya', 'password123'),
('A002', 'shruti', 'password123'),
('A003', 'samridhi', 'password123');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_id` varchar(5) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` enum('f,m,o') NOT NULL,
  `contact` int(10) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `p_id` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dependents`
--

CREATE TABLE `dependents` (
  `d_id` varchar(5) NOT NULL,
  `d_name` varchar(20) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` enum('f,m,o') DEFAULT NULL,
  `c_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `guide`
--

CREATE TABLE `guide` (
  `g_id` varchar(5) NOT NULL,
  `g_name` varchar(20) NOT NULL,
  `sex` enum('f,m,o') NOT NULL,
  `contact` int(10) NOT NULL,
  `p_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `g_lang`
--

CREATE TABLE `g_lang` (
  `g_id` varchar(5) NOT NULL,
  `lang` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `h_id` varchar(5) NOT NULL,
  `h_name` varchar(20) NOT NULL,
  `type` enum('ac,non_ac') NOT NULL,
  `address` varchar(20) NOT NULL,
  `p_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `manage`
--

CREATE TABLE `manage` (
  `a_id` varchar(5) NOT NULL,
  `c_id` varchar(5) DEFAULT NULL,
  `d_id` varchar(5) DEFAULT NULL,
  `p_id` varchar(5) DEFAULT NULL,
  `g_id` varchar(5) DEFAULT NULL,
  `h_id` varchar(5) DEFAULT NULL,
  `t_id` varchar(5) DEFAULT NULL,
  `tour_id` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `p_id` varchar(5) NOT NULL,
  `p_name` varchar(20) NOT NULL,
  `amount` int(6) NOT NULL,
  `offer_id` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `trans_id` varchar(5) NOT NULL,
  `amount` int(6) NOT NULL,
  `mode` varchar(20) NOT NULL,
  `p_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tour`
--

CREATE TABLE `tour` (
  `tour_id` varchar(5) NOT NULL,
  `destination` varchar(20) NOT NULL,
  `nights` int(2) NOT NULL,
  `p_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transport`
--

CREATE TABLE `transport` (
  `t_id` varchar(5) NOT NULL,
  `t_name` varchar(30) NOT NULL,
  `seat_no` varchar(5) NOT NULL,
  `arrival` varchar(20) DEFAULT NULL,
  `departure` varchar(20) DEFAULT NULL,
  `to1` datetime DEFAULT NULL,
  `from1` datetime DEFAULT NULL,
  `t_mode` enum('train,flight') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
