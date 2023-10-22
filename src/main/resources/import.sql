-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql:3306
-- Generation Time: Oct 22, 2023 at 11:18 PM
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
                                        (0x1b833b8386e14430b107d365394608fa, ' Jason Clark'),
                                        (0x3353aa639c47418081b50d1c7279cb76, ' Martijn Verburg'),
                                        (0x676a6e1d64dd48ed8a24932a4ad56c4d, ' audrey'),
                                        (0x692cb833ea0d4e06867c3c921d9ac759, ' thomas'),
                                        (0x81da43a9410c457fa52acf799231ce56, ' Benjamin'),
                                        (0x8cc2a1fc21c147f9b45eef33b61e6dc6, 'Alex Preukschat'),
                                        (0xb50bdf93ae864643b0c231c23506f351, ' J. Evans'),
                                        (0xfc7bf03fe82f41edb8c82bfd3dd00684, ' Drummond Reed');

--
-- Dumping data for table `Book`
--

INSERT INTO `Book` (`id`, `isbn`, `title`) VALUES
                                               (0x3a7d0b2f967545f88cc221a4de00ffae, '978-1-61729-887-5', 'Well-Grounded Java Developer (second edition)'),
                                               (0xe90b1dea8791480ebff60ae223fb90ad, '978-1-61729-659-8', 'Self-Sovereign Identity');

--
-- Dumping data for table `book_author`
--

INSERT INTO `book_author` (`author_id`, `book_id`) VALUES
                                                       (0x1b833b8386e14430b107d365394608fa, 0x3a7d0b2f967545f88cc221a4de00ffae),
                                                       (0x3353aa639c47418081b50d1c7279cb76, 0x3a7d0b2f967545f88cc221a4de00ffae),
                                                       (0x81da43a9410c457fa52acf799231ce56, 0x3a7d0b2f967545f88cc221a4de00ffae),
                                                       (0xb50bdf93ae864643b0c231c23506f351, 0x3a7d0b2f967545f88cc221a4de00ffae),
                                                       (0x8cc2a1fc21c147f9b45eef33b61e6dc6, 0xe90b1dea8791480ebff60ae223fb90ad),
                                                       (0xfc7bf03fe82f41edb8c82bfd3dd00684, 0xe90b1dea8791480ebff60ae223fb90ad);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;