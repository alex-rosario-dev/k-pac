INSERT INTO `k_pac_dev`.`k_pac`
(`title`,`description`,`creation_date`)
VALUES
("Title 1","Description 1",curdate()),
("Title 2","Description 2",curdate()),
("Title 3","Description 3",curdate()),
("Title 4","Description 4",curdate());

INSERT INTO `k_pac_dev`.`set`
(`title`)
VALUES
("Set Title 1"),
("Set Title 2"),
("Set Title 3"),
("Set Title 4"),
("Set Title 5");

INSERT INTO `k_pac_dev`.`k_pac_set`
(`k_pac_id`,`set_id`)
VALUES
(1,1),
(1,2),
(2,1),
(3,4),
(4,3);

