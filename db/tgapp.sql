-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2019 at 02:05 PM
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
  `CreatedOn` date NOT NULL,
  `Active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `attend`
--

CREATE TABLE `attend` (
  `aid` int(11) NOT NULL,
  `id` int(255) NOT NULL,
  `sid` int(255) NOT NULL,
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
  `EID` int(255) NOT NULL,
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
  `SID` int(255) NOT NULL,
  `JEE/MHTCET` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `family`
--

CREATE TABLE `family` (
  `FID` int(11) NOT NULL,
  `SID` int(255) NOT NULL,
  `FName` varchar(255) NOT NULL,
  `FMobNo` varchar(255) NOT NULL,
  `FOcc` varchar(255) NOT NULL,
  `MName` varchar(255) NOT NULL,
  `MMobNo` varchar(255) NOT NULL,
  `MOcc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `friendinfo`
--

CREATE TABLE `friendinfo` (
  `FIID` int(11) NOT NULL,
  `SID` int(255) NOT NULL,
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
  `EID` int(255) NOT NULL,
  `InstiName` varchar(255) NOT NULL,
  `Year` int(11) NOT NULL,
  `Percentage` int(11) NOT NULL,
  `Std` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lecture_table`
--

CREATE TABLE `lecture_table` (
  `lid` int(255) NOT NULL,
  `lname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mediinfo`
--

CREATE TABLE `mediinfo` (
  `Mid` int(11) NOT NULL,
  `SID` int(255) NOT NULL,
  `Disease` varchar(255) NOT NULL,
  `age` int(255) NOT NULL,
  `exist` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `personal`
--

CREATE TABLE `personal` (
  `PID` int(11) NOT NULL,
  `SID` int(11) NOT NULL,
  `Fullname` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `sem` int(11) NOT NULL,
  `Paddress` varchar(255) NOT NULL,
  `Taddress` varchar(255) NOT NULL,
  `MobNo` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Blood` varchar(255) NOT NULL,
  `DOB` date NOT NULL,
  `gender` varchar(255) NOT NULL,
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
  `Uname` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `CreatedOn` datetime NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `alloted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `Subid` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sub_lec`
--

CREATE TABLE `sub_lec` (
  `id` int(255) NOT NULL,
  `day` varchar(255) NOT NULL,
  `subid` int(255) NOT NULL,
  `lid` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `swotinfo`
--

CREATE TABLE `swotinfo` (
  `SWOTID` int(11) NOT NULL,
  `SID` int(255) NOT NULL,
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

-- --------------------------------------------------------

--
-- Table structure for table `technicalinfo`
--

CREATE TABLE `technicalinfo` (
  `TIID` int(11) NOT NULL,
  `SID` int(255) NOT NULL,
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
  ADD PRIMARY KEY (`aid`),
  ADD KEY `sid` (`sid`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `beinfo`
--
ALTER TABLE `beinfo`
  ADD PRIMARY KEY (`BEID`) USING BTREE,
  ADD KEY `EID` (`EID`);

--
-- Indexes for table `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`EID`),
  ADD KEY `SID` (`SID`);

--
-- Indexes for table `family`
--
ALTER TABLE `family`
  ADD PRIMARY KEY (`FID`),
  ADD KEY `SID` (`SID`);

--
-- Indexes for table `friendinfo`
--
ALTER TABLE `friendinfo`
  ADD PRIMARY KEY (`FIID`),
  ADD KEY `SID` (`SID`);

--
-- Indexes for table `geninstitute`
--
ALTER TABLE `geninstitute`
  ADD PRIMARY KEY (`GID`),
  ADD KEY `EID` (`EID`);

--
-- Indexes for table `lecture_table`
--
ALTER TABLE `lecture_table`
  ADD PRIMARY KEY (`lid`);

--
-- Indexes for table `mediinfo`
--
ALTER TABLE `mediinfo`
  ADD PRIMARY KEY (`Mid`),
  ADD KEY `SID` (`SID`);

--
-- Indexes for table `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`PID`),
  ADD KEY `SID` (`SID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`SID`),
  ADD KEY `TID` (`TID`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`Subid`);

--
-- Indexes for table `sub_lec`
--
ALTER TABLE `sub_lec`
  ADD PRIMARY KEY (`id`),
  ADD KEY `lec_id` (`lid`),
  ADD KEY `sub_id` (`subid`);

--
-- Indexes for table `swotinfo`
--
ALTER TABLE `swotinfo`
  ADD PRIMARY KEY (`SWOTID`),
  ADD KEY `SID` (`SID`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`TID`);

--
-- Indexes for table `technicalinfo`
--
ALTER TABLE `technicalinfo`
  ADD PRIMARY KEY (`TIID`),
  ADD KEY `SID` (`SID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lecture_table`
--
ALTER TABLE `lecture_table`
  MODIFY `lid` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sub_lec`
--
ALTER TABLE `sub_lec`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attend`
--
ALTER TABLE `attend`
  ADD CONSTRAINT `attend_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`SID`),
  ADD CONSTRAINT `attend_ibfk_2` FOREIGN KEY (`id`) REFERENCES `sub_lec` (`id`);

--
-- Constraints for table `beinfo`
--
ALTER TABLE `beinfo`
  ADD CONSTRAINT `beinfo_ibfk_1` FOREIGN KEY (`EID`) REFERENCES `education` (`EID`);

--
-- Constraints for table `education`
--
ALTER TABLE `education`
  ADD CONSTRAINT `education_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`);

--
-- Constraints for table `family`
--
ALTER TABLE `family`
  ADD CONSTRAINT `family_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`);

--
-- Constraints for table `friendinfo`
--
ALTER TABLE `friendinfo`
  ADD CONSTRAINT `friendinfo_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`);

--
-- Constraints for table `geninstitute`
--
ALTER TABLE `geninstitute`
  ADD CONSTRAINT `geninstitute_ibfk_1` FOREIGN KEY (`EID`) REFERENCES `education` (`EID`);

--
-- Constraints for table `mediinfo`
--
ALTER TABLE `mediinfo`
  ADD CONSTRAINT `mediinfo_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`);

--
-- Constraints for table `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`TID`) REFERENCES `teacher` (`TID`);

--
-- Constraints for table `sub_lec`
--
ALTER TABLE `sub_lec`
  ADD CONSTRAINT `sub_lec_ibfk_1` FOREIGN KEY (`lid`) REFERENCES `lecture_table` (`lid`),
  ADD CONSTRAINT `sub_lec_ibfk_2` FOREIGN KEY (`subid`) REFERENCES `subjects` (`Subid`);

--
-- Constraints for table `swotinfo`
--
ALTER TABLE `swotinfo`
  ADD CONSTRAINT `swotinfo_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`);

--
-- Constraints for table `technicalinfo`
--
ALTER TABLE `technicalinfo`
  ADD CONSTRAINT `technicalinfo_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
