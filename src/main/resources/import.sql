-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql:3306
-- Generation Time: Oct 22, 2023 at 11:46 PM
-- Server version: 8.1.0
-- PHP Version: 8.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Raymond`
--

--
-- Dumping data for table `Author`
--

INSERT INTO `Author` (`id`, `name`) VALUES
    (0xd4046b809b934b0397e898e23f49aa9a, 'Vlad Kohnonov');

--
-- Dumping data for table `Book`
--

INSERT INTO `Book` (`id`, `isbn`, `title`) VALUES
    (0x36e19afd8d204382a671a1f474949089, '978-1-098-100131', 'Learning Domain-Driven Design');


INSERT INTO `Theme` (`id`, `name`) VALUES
                                       (0x20592d15186b4feb9809370250264119, ' architecture'),
                                       (0xd1fc91ce1762409fbf4461f425aa3ef6, 'software Engineering'),
                                       (0xf112c3e67ee74dc9a29d99315824275f, ' business Strategy');
--
-- Dumping data for table `book_author`
--

INSERT INTO `book_author` (`author_id`, `book_id`) VALUES
    (0xd4046b809b934b0397e898e23f49aa9a, 0x36e19afd8d204382a671a1f474949089);

--
-- Dumping data for table `book_theme`
--

INSERT INTO `book_theme` (`book_id`, `theme_id`) VALUES
                                                     (0x36e19afd8d204382a671a1f474949089, 0x20592d15186b4feb9809370250264119),
                                                     (0x36e19afd8d204382a671a1f474949089, 0xd1fc91ce1762409fbf4461f425aa3ef6),
                                                     (0x36e19afd8d204382a671a1f474949089, 0xf112c3e67ee74dc9a29d99315824275f);

--
-- Dumping data for table `Theme`
--


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;