-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 11, 2022 lúc 11:56 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `manage_cake`
--
CREATE DATABASE manage_cake;
USE manage_cake;
-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cake`
--

CREATE TABLE `cake` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `quality` int(11) NOT NULL,
  `price` float NOT NULL,
  `typecake` varchar(100) NOT NULL,
  `image` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cake`
--

INSERT INTO `cake` (`id`, `name`, `quality`, `price`, `typecake`, `image`) VALUES
(1, 'ice cream', 100, 3000, 'cream cake', 'https://bizweb.dktcdn.net/100/333/744/products/4b918258125bd805814a.jpg?v=1648095375027'),
(2, 'hao', 2, 1500, 'cream cake', 'https://media.foody.vn/res/g5/42120/prof/s/foody-upload-api-foody-mobile-banhmi-200715112206.jpg'),
(3, 'break', 9, 5000, 'break', 'https://media.foody.vn/res/g5/42120/prof/s/foody-upload-api-foody-mobile-banhmi-200715112206.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cake`
--
ALTER TABLE `cake`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cake`
--
ALTER TABLE `cake`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
