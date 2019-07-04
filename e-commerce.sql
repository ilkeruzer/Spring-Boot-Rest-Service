-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 04 Tem 2019, 15:48:53
-- Sunucu sürümü: 10.1.40-MariaDB
-- PHP Sürümü: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `e-commerce`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `basket`
--

CREATE TABLE `basket` (
  `products_id` int(11) DEFAULT NULL,
  `products_price` float DEFAULT NULL,
  `products_piece` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `basket`
--

INSERT INTO `basket` (`products_id`, `products_price`, `products_piece`) VALUES
(1, 50, 2),
(2, 25, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Giyim'),
(2, 'Elektronik'),
(3, 'Ev Dekorasyon'),
(4, 'Mücevher'),
(5, 'Spor Malzemeleri'),
(6, 'Kitap/Müzik');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(5),
(5);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `products`
--

CREATE TABLE `products` (
  `products_id` int(11) NOT NULL,
  `categories_id` int(11) NOT NULL,
  `products_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `products_price` float NOT NULL,
  `products_image` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `products_detail` varchar(500) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `products`
--

INSERT INTO `products` (`products_id`, `categories_id`, `products_name`, `products_price`, `products_image`, `products_detail`) VALUES
(1, 1, 'T-Shirt', 25, '', 'Kırmızı T-Shirt'),
(2, 1, 'Çeket', 50, '', 'Kalın kışlık çeket'),
(3, 1, 'Ayakkabı', 40, '', 'Spor ayakkabı'),
(4, 2, 'Cep telefonu', 1600, '', 'Xiomi Mi A2 akıllı cep telefonu'),
(5, 2, 'Bilgisayar', 2500, '', 'Lenovo ideapad 320 ABR'),
(6, 3, 'Masa', 250, '', 'Çalışma masası'),
(7, 3, 'Sandalye', 100, '', 'Ofis sandalyesi'),
(8, 4, 'Kolye', 50, '', 'Boncuk kolye'),
(9, 4, 'Saat', 100, '', 'Klasik erkek kol saati'),
(10, 5, 'Çanta', 75, '', 'Spor çantaası'),
(11, 5, 'Eşofman Takımı', 90, '', 'Spor eşofman takımı'),
(12, 6, 'Kitap', 15, '', 'Tanrının Unutulan Çocukları'),
(13, 6, 'Plak', 64, '', 'Cem karaca plak seti');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`products_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `products`
--
ALTER TABLE `products`
  MODIFY `products_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
