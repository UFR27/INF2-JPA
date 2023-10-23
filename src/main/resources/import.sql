-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql:3306
-- Generation Time: Oct 23, 2023 at 01:03 AM
-- Server version: 8.1.0
-- PHP Version: 8.2.11

SET FOREIGN_KEY_CHECKS=0;
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
                                        (0x98ab602ea662460bbfc8e6b7715808ca, 'Jeremy Howard '),
                                        (0xae9227616c22442b8f6601e6777b6946, ' Sylvain Gugger '),
                                        (0xfad705080e5440bb957c7953d4e6ea68, ' Roger Vailland ');

--
-- Dumping data for table `Book`
--

INSERT INTO `Book` (`id`, `DTYPE`, `isbn`, `title`) VALUES
                                                        (0x5febdd3ca7ec4a098b64ac42b906f7c7, 'ITBook', '978-1-492-04552-6', 'Deep LEarning for Coders with fastai & Pytorch '),
                                                        (0xe67897e1336c4b1cacef296a03d13d2f, 'RegularBook', 'XXXX', 'Boroboudour voyage à Bali, Java et autres îles (La grande collection');

--
-- Dumping data for table `book_author`
--

INSERT INTO `book_author` (`author_id`, `book_id`) VALUES
                                                       (0x98ab602ea662460bbfc8e6b7715808ca, 0x5febdd3ca7ec4a098b64ac42b906f7c7),
                                                       (0xae9227616c22442b8f6601e6777b6946, 0x5febdd3ca7ec4a098b64ac42b906f7c7),
                                                       (0xfad705080e5440bb957c7953d4e6ea68, 0xe67897e1336c4b1cacef296a03d13d2f);

--
-- Dumping data for table `book_theme`
--

INSERT INTO `book_theme` (`book_id`, `theme_id`) VALUES
                                                     (0x5febdd3ca7ec4a098b64ac42b906f7c7, 0x0aacf407a55d42a38fd1e239c7d0d3ab),
                                                     (0xe67897e1336c4b1cacef296a03d13d2f, 0xebc05ce6660749ca98b716884305b4f0),
                                                     (0xe67897e1336c4b1cacef296a03d13d2f, 0xf6059e61b03b4a66b4bfc8598a04fe60);

--
-- Dumping data for table `ItBook_languages`
--

INSERT INTO `ItBook_languages` (`ItBook_id`, `languages`) VALUES
    (0x5febdd3ca7ec4a098b64ac42b906f7c7, 'Python');

--
-- Dumping data for table `Theme`
--

INSERT INTO `Theme` (`id`, `name`) VALUES
                                       (0x0aacf407a55d42a38fd1e239c7d0d3ab, 'AI'),
                                       (0xebc05ce6660749ca98b716884305b4f0, 'Java'),
                                       (0xf6059e61b03b4a66b4bfc8598a04fe60, 'indonesie');
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;