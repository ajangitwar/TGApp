-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2019 at 06:52 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

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
  `EID` int(125) NOT NULL,
  `InstiName` varchar(11) NOT NULL,
  `Branch` varchar(255) NOT NULL,
  `Iper` varchar(255) NOT NULL,
  `IIper` varchar(255) NOT NULL,
  `IIIper` varchar(255) NOT NULL,
  `IVper` varchar(255) NOT NULL,
  `Vper` varchar(255) NOT NULL,
  `VIper` varchar(255) NOT NULL,
  `VIIper` varchar(255) NOT NULL,
  `VIIIper` varchar(255) NOT NULL,
  `backlogs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beinfo`
--

INSERT INTO `beinfo` (`EID`, `InstiName`, `Branch`, `Iper`, `IIper`, `IIIper`, `IVper`, `Vper`, `VIper`, `VIIper`, `VIIIper`, `backlogs`) VALUES
(0, 'SBJITMR', 'Computer Science and Engineering', '70', '78', '63', '75', '73', '', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE `education` (
  `EID` int(11) NOT NULL,
  `JEE` int(125) NOT NULL,
  `MHTCET` int(125) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `education`
--

INSERT INTO `education` (`EID`, `JEE`, `MHTCET`) VALUES
(7, 46, 56);

-- --------------------------------------------------------

--
-- Table structure for table `family`
--

CREATE TABLE `family` (
  `FID` int(11) NOT NULL,
  `FName` varchar(225) NOT NULL,
  `FMobNo` varchar(225) NOT NULL,
  `FOcc` varchar(225) NOT NULL,
  `MName` varchar(225) NOT NULL,
  `MMobNo` varchar(255) NOT NULL,
  `MOcc` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `family`
--

INSERT INTO `family` (`FID`, `FName`, `FMobNo`, `FOcc`, `MName`, `MMobNo`, `MOcc`) VALUES
(16, '', '', '', '', '', ''),
(17, '', '', '', '', '', ''),
(18, '1', '1', '1', '1', '', 'Chj'),
(19, '', '', '', '', '', ''),
(20, '', '', '', '', '', ''),
(21, '', '', '', '', '', ''),
(22, '', '', '', '', '', ''),
(23, '', '', '', '', '', ''),
(24, '', '', '', '', '', ''),
(25, '', '', '', '', '', ''),
(26, '', '', '', '', '', ''),
(27, '', '', '', '', '', ''),
(28, '', '', '', '', '', ''),
(29, '', '', '', '', '', ''),
(30, '', '', '', '', '', ''),
(31, '', '', '', '', '', ''),
(32, '', '', '', '', '', ''),
(33, '', '', '', '', '', ''),
(34, '', '', '', '', '', ''),
(35, '', '', '', '', '', ''),
(36, '', '', '', '', '', ''),
(37, '', '', '', '', '', ''),
(38, '', '', '', '', '', ''),
(39, '', '', '', '', '', ''),
(40, '', '', '', '', '', ''),
(41, '', '', '', '', '', ''),
(42, '', '', '', '', '', ''),
(43, '', '', '', '', '', ''),
(44, '', '', '', '', '', ''),
(45, '', '', '', '', '', ''),
(46, '', '', '', '', '', ''),
(47, '', '', '', '', '', ''),
(48, 'I FF', 'Ydg', 'Ydyd', 'Xgx', '', 'Bb'),
(49, 'Gg', 'Gh', 'Gg', 'Gg', '', 'Bb'),
(50, 'Hshs', 'Ff', 'F', 'D', '', 'F'),
(51, 'Hsjj', 'Ff', 'F', 'F', 'F', 'F');

-- --------------------------------------------------------

--
-- Table structure for table `friendinfo`
--

CREATE TABLE `friendinfo` (
  `FIID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `MobNo` int(30) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `geninstitute`
--

CREATE TABLE `geninstitute` (
  `EID` int(125) NOT NULL,
  `InstiNameX` varchar(255) NOT NULL,
  `YearX` varchar(255) NOT NULL,
  `PercentageX` varchar(255) NOT NULL,
  `InstiNameXII` varchar(255) NOT NULL,
  `YearXII` varchar(255) NOT NULL,
  `PerXII` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `geninstitute`
--

INSERT INTO `geninstitute` (`EID`, `InstiNameX`, `YearX`, `PercentageX`, `InstiNameXII`, `YearXII`, `PerXII`) VALUES
(0, 'SBJIT', '2016', '82', 'SBJIT', '2018', '68'),
(0, '', '', '', '', '', ''),
(0, '', '', '', '', '', ''),
(0, 'VDHS', '2014', '60', 'ASJC', '2016', '62');

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
  `Paddress` varchar(255) NOT NULL,
  `Taddress` varchar(255) NOT NULL,
  `MobNo` varchar(225) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `Blood` varchar(255) NOT NULL,
  `DOB` date NOT NULL,
  `Height` varchar(225) NOT NULL,
  `weight` varchar(225) NOT NULL,
  `UID` varchar(225) NOT NULL,
  `PAN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personal`
--

INSERT INTO `personal` (`PID`, `Fullname`, `Paddress`, `Taddress`, `MobNo`, `Email`, `gender`, `Blood`, `DOB`, `Height`, `weight`, `UID`, `PAN`) VALUES
(1, 'Nikhil Ashok Borkar', 'Dabha,Nagpur', 'Dabha,Nagpur', '9604745124', 'nikhilborkar@gmail.com', 'male', 'o+', '2019-03-15', '123', '50', '123456789963', 123456),
(3, 'Ashwin ashok borkar', 'Nagpur', 'Nagpur', '3698745251', 'ashwin@gmail.com', 'M', 'O', '0000-00-00', '124', '123', '12345678', 12345678),
(5, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(6, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(7, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(8, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(9, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(10, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(11, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(12, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(13, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(14, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(15, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(16, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(17, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(18, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(19, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(20, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0),
(21, '', '', '', '', '', '', '', '0000-00-00', '', '', '', 0);

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
  `year` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  `CreatedOn` datetime NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `alloted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`SID`, `TID`, `fullname`, `Uname`, `Password`, `year`, `semester`, `CreatedOn`, `Active`, `alloted`) VALUES
(120, 12, 'Nikhil Ashok Borkar', '1', '1', 3, 5, '2019-03-15 00:00:00', 1, 1),
(15012, 0, 'Ashwin Ashok Borkar', 'AshwinB', 'Ashwin@123', 2, 3, '2019-03-13 18:58:00', 1, 1),
(16012, 12, 'Nikhil Ashok Borkar', 'NikhilB', 'Nikhil@123', 3, 5, '2019-03-13 00:00:00', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `SID` int(11) NOT NULL,
  `SubName` varchar(255) NOT NULL,
  `SubjectCounter` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `AttendanceId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `Fullname` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `CreatedOn` datetime NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `Updated` datetime NOT NULL,
  `Mobile` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`TID`, `Uname`, `Password`, `Fullname`, `Email`, `CreatedOn`, `Active`, `Updated`, `Mobile`) VALUES
(123456, 'Ankit ', 'ask', 'Nikhil Borkar', 'nikhilborkar884@gmail.com', '2019-03-09 00:00:00', 1, '2019-03-09 00:00:00', 1234567890),
(455427, 'aniket ', 'ask', 'Komal Borkar', 'KomalB@gmail.com', '2019-03-09 16:34:34', 1, '2019-03-09 16:34:34', 1234567890),
(455428, 'NikhilB', 'Nikhil@123', 'Nikhil Borkar', 'nikhilborkar885@gmail.com', '2019-03-12 19:23:42', 1, '2019-03-12 19:23:42', 2147483647);

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
  ADD PRIMARY KEY (`SID`);

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
-- AUTO_INCREMENT for table `education`
--
ALTER TABLE `education`
  MODIFY `EID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `family`
--
ALTER TABLE `family`
  MODIFY `FID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `personal`
--
ALTER TABLE `personal`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `TID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=455429;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
