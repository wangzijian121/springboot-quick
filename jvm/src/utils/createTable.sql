CREATE TABLE `ddc_event` (
                             `id` varchar(32) DEFAULT NULL,
                             `type` varchar(255) DEFAULT NULL,
                             `action` varchar(255) DEFAULT NULL,
                             `message` varchar(255) DEFAULT NULL,
                             `comment` varchar(255) DEFAULT NULL,
                             `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci