SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


INSERT INTO `Author` (`id`, `name`) VALUES
                                        (0x1e5f187c86e94faab0ff0cd4f978c02b, ' Jules Joseph LeClercq'),
                                        (0x231aed889af8486b9d778f4a2da835fe, 'Jeremy Howard'),
                                        (0x932ee8ed2cef4db3b705329f8a4c9eed, ' Sylvain Gugger');

INSERT INTO `Book` (`id`, `isbn`, `title`) VALUES
    (0x95a48224f8a844a4a5dfb3c1c00eca19, '978-1144500083', 'Un Séjour Dans L île De Java: Le Pays, Les Habitants, Le Système Colonial'),
(0xbef619cc49a7490689063c81f5d08fb2, '978-1-492-04552-6', 'Deep LEarning for Coders with fastai & Pytorch');

INSERT INTO `book_author` (`author_id`, `book_id`) VALUES
(0x1e5f187c86e94faab0ff0cd4f978c02b, 0x95a48224f8a844a4a5dfb3c1c00eca19),
(0x231aed889af8486b9d778f4a2da835fe, 0xbef619cc49a7490689063c81f5d08fb2),
(0x932ee8ed2cef4db3b705329f8a4c9eed, 0xbef619cc49a7490689063c81f5d08fb2);

INSERT INTO `book_theme` (`book_id`, `theme_id`) VALUES
(0x95a48224f8a844a4a5dfb3c1c00eca19, 0x0e820a0dea3b43899772c809ef50078f),
(0xbef619cc49a7490689063c81f5d08fb2, 0x86766e7c78f94825a9a83b1e73521488),
(0x95a48224f8a844a4a5dfb3c1c00eca19, 0xf147c1a3218b4d00a072c8bbb746809e);

INSERT INTO `ItBook` (`id`) VALUES
(0xbef619cc49a7490689063c81f5d08fb2);

INSERT INTO `ItBook_languages` (`ItBook_id`, `languages`) VALUES
(0xbef619cc49a7490689063c81f5d08fb2, 'Python');

CREATE TABLE `Theme` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `Theme` (`id`, `name`) VALUES
(0x0e820a0dea3b43899772c809ef50078f, ' Iles'),
(0x86766e7c78f94825a9a83b1e73521488, ' AI'),
(0xf147c1a3218b4d00a072c8bbb746809e, 'Java');


ALTER TABLE `Theme`
  ADD PRIMARY KEY (`id`);
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;