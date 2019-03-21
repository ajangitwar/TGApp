-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2019 at 01:11 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tgapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AID` int(11) NOT NULL,
  `Uname` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Fullname` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `CreatedOn` datetime NOT NULL,
  `Active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AID`, `Uname`, `Password`, `Fullname`, `Email`, `CreatedOn`, `Active`) VALUES
(1, 'Neon', 'Nikhil@123', 'Nikhil Ashok Borkar', 'nikhilborkar884@gmail.com', '2019-03-06 00:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `attend`
--

CREATE TABLE `attend` (
  `aid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `day` varchar(255) NOT NULL,
  `l1` varchar(255) NOT NULL,
  `l2` varchar(255) NOT NULL,
  `l3` varchar(255) NOT NULL,
  `l4` varchar(255) NOT NULL,
  `l5` varchar(255) NOT NULL,
  `l6` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `beinfo`
--

CREATE TABLE `beinfo` (
  `BEID` int(11) NOT NULL,
  `InstiName` varchar(11) NOT NULL,
  `SEM` varchar(11) NOT NULL,
  `SGPA` int(11) NOT NULL,
  `Percentage` int(11) NOT NULL,
  `backlogs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE `education` (
  `EID` int(11) NOT NULL,
  `JEE/MHTCET` int(11) NOT NULL,
  `GID` int(11) NOT NULL,
  `DEID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `family`
--

CREATE TABLE `family` (
  `FID` int(11) NOT NULL,
  `FName` int(11) NOT NULL,
  `FMobNo` int(11) NOT NULL,
  `FOcc` int(11) NOT NULL,
  `MName` int(11) NOT NULL,
  `MOcc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `friendinfo`
--

CREATE TABLE `friendinfo` (
  `FIID` int(11) NOT NULL,
  `MobNo` int(30) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `TypeOfFriend` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `geninstitute`
--

CREATE TABLE `geninstitute` (
  `GID` int(11) NOT NULL,
  `InstiName` varchar(255) NOT NULL,
  `Year` int(11) NOT NULL,
  `Percentage` int(11) NOT NULL,
  `Std` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mediinfo`
--

CREATE TABLE `mediinfo` (
  `Mid` int(11) NOT NULL,
  `Disease` varchar(255) NOT NULL,
  `age?` int(11) NOT NULL,
  `exist?` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `personal`
--

CREATE TABLE `personal` (
  `PID` int(11) NOT NULL,
  `Fullname` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `sem` int(11) NOT NULL,
  `Paddress` varchar(255) NOT NULL,
  `Taddress` varchar(255) NOT NULL,
  `MobNo` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Blood` varchar(255) NOT NULL,
  `DOB` date NOT NULL,
  `Height` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `UID` int(11) NOT NULL,
  `PAN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `SID` int(11) NOT NULL,
  `TID` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `Uname` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `year` varchar(255) NOT NULL,
  `semester` varchar(255) NOT NULL,
  `CreatedOn` datetime NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `alloted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`SID`, `TID`, `fullname`, `Uname`, `Password`, `year`, `semester`, `CreatedOn`, `Active`, `alloted`) VALUES
(142, 0, 'vsvs', 'afa', 'dsfdsdfaafd', '3', '5', '2019-03-06 21:02:00', 1, 1),
(1602, 8055, 'dsfsdfds', 'affdsfdgfds', 'adwasd', '3', '5', '2019-03-06 11:56:31', 1, 1),
(15019, 8055, 'Ashok Borkar', 'Ashok@gmail.com', '123456', '2', '3', '2019-03-06 20:40:05', 1, 1),
(15201, 8055, 'Kartik Tyagi', 'drfghb', 'edfgbhn', '2', '3', '2019-03-06 11:35:28', 1, 1),
(16012, 8055, 'Nikhil Ashok Borkar', 'asd@gmail.com', '123456', '3', '5', '2019-03-06 11:15:54', 1, 1),
(16019, 8055, 'Abhishek jangitwar', 'abhi', 'abhi', '3', '6', '0000-00-00 00:00:00', 1, 0),
(16020, 1, 'Pratik jawanjal', 'pratik', 'pratik', '3', '6', '2019-03-14 00:00:00', 1, 1),
(16021, 1, 'Pratik gajapati', 'abc', 'abc', '3', '6', '2019-03-14 00:00:00', 1, 1),
(16025, 8055, 'Aniket', 'Aniket', '123456', '3', '5', '2019-03-10 08:22:35', 1, 1),
(17012, 8055, 'dfsfdgfdhghgjh', 'jfhfghfdgsdfsd', 'qssdfrtt', '4', '7', '2019-03-06 11:57:29', 1, 1),
(17047, 0, 'efgbn', 'okjn', 'asdfghjk', '4', '7', '2019-03-06 20:52:49', 1, 1),
(19012, 8055, 'Ashwin Borkar', 'AshwinB', '1234567890', '2', '3', '2019-03-09 16:36:16', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subid` varchar(255) NOT NULL,
  `subsem` varchar(255) NOT NULL,
  `subname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subid`, `subsem`, `subname`) VALUES
('', '', ''),
('B1001', '3', 'ACPLD'),
('hg', '5', 'hgj'),
('hgvh', 'jhj', 'hgh'),
('s', 'ss', 'ss');

-- --------------------------------------------------------

--
-- Table structure for table `subjectatten`
--

CREATE TABLE `subjectatten` (
  `AttendId` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  `AttendanceMark` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `swotinfo`
--

CREATE TABLE `swotinfo` (
  `SWOTID` int(11) NOT NULL,
  `Strength` varchar(255) NOT NULL,
  `Weakness` varchar(255) NOT NULL,
  `opportunity` varchar(255) NOT NULL,
  `threats` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `TID` int(11) NOT NULL,
  `Uname` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Salutation` varchar(255) NOT NULL,
  `Fullname` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Mobile` varchar(255) NOT NULL,
  `CreatedOn` datetime NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `Updated` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`TID`, `Uname`, `Password`, `Salutation`, `Fullname`, `Email`, `Mobile`, `CreatedOn`, `Active`, `Updated`) VALUES
(8055, 'Abhishek', '1234', 'Dr.', 'Abhishek Jangitwar', 'ajangitwar@gmail.com', '8975889364', '2019-03-14 00:00:00', 1, '0000-00-00 00:00:00'),
(123456, 'Ankit ', 'ask', '', 'Nikhil Borkar', 'nikhilborkar884@gmail.com', '', '2019-03-09 00:00:00', 1, '2019-03-09 00:00:00'),
(455427, 'aniket ', 'ask', '', 'Komal Borkar', 'KomalB@gmail.com', '', '2019-03-09 16:34:34', 1, '2019-03-09 16:34:34');

-- --------------------------------------------------------

--
-- Table structure for table `technicalinfo`
--

CREATE TABLE `technicalinfo` (
  `TIID` int(11) NOT NULL,
  `PossKnowledge` varchar(255) NOT NULL,
  `NeededKnowledge` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AID`);

--
-- Indexes for table `attend`
--
ALTER TABLE `attend`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `beinfo`
--
ALTER TABLE `beinfo`
  ADD PRIMARY KEY (`BEID`) USING BTREE;

--
-- Indexes for table `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`EID`);

--
-- Indexes for table `family`
--
ALTER TABLE `family`
  ADD PRIMARY KEY (`FID`);

--
-- Indexes for table `friendinfo`
--
ALTER TABLE `friendinfo`
  ADD PRIMARY KEY (`FIID`);

--
-- Indexes for table `geninstitute`
--
ALTER TABLE `geninstitute`
  ADD PRIMARY KEY (`GID`);

--
-- Indexes for table `mediinfo`
--
ALTER TABLE `mediinfo`
  ADD PRIMARY KEY (`Mid`);

--
-- Indexes for table `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`SID`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subid`);

--
-- Indexes for table `subjectatten`
--
ALTER TABLE `subjectatten`
  ADD PRIMARY KEY (`AttendId`);

--
-- Indexes for table `swotinfo`
--
ALTER TABLE `swotinfo`
  ADD PRIMARY KEY (`SWOTID`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`TID`);

--
-- Indexes for table `technicalinfo`
--
ALTER TABLE `technicalinfo`
  ADD PRIMARY KEY (`TIID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `TID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=455428;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
