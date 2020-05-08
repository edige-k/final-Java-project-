-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 08 2020 г., 18:11
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `dl_projects`
--

-- --------------------------------------------------------

--
-- Структура таблицы `attendences`
--

CREATE TABLE `attendences` (
  `id` int(11) NOT NULL,
  `sheadulesId` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `passwordNumber` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `attendences`
--

INSERT INTO `attendences` (`id`, `sheadulesId`, `name`, `surname`, `passwordNumber`) VALUES
(5, '1', 'fygh', 'ui', 'poi');

-- --------------------------------------------------------

--
-- Структура таблицы `sheadules`
--

CREATE TABLE `sheadules` (
  `id` int(11) NOT NULL,
  `kindofsubjects` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `sheadules`
--

INSERT INTO `sheadules` (`id`, `kindofsubjects`, `name`, `time`) VALUES
(1, 'prog', 'c++', '16:00'),
(2, 'prog', 'java', '12:00'),
(4, 'Edige', 'Sensei', '12:00');

-- --------------------------------------------------------

--
-- Структура таблицы `studentdata`
--

CREATE TABLE `studentdata` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `telephoneNumber` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `studentdata`
--

INSERT INTO `studentdata` (`id`, `login`, `password`, `address`, `telephoneNumber`) VALUES
(1, 'nurs', '1111', '852', '1234568'),
(3, 'Edige', '08082001', '123456789', '132654897');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `attendences`
--
ALTER TABLE `attendences`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `sheadules`
--
ALTER TABLE `sheadules`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `studentdata`
--
ALTER TABLE `studentdata`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `attendences`
--
ALTER TABLE `attendences`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `sheadules`
--
ALTER TABLE `sheadules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `studentdata`
--
ALTER TABLE `studentdata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
