use land_db;

DROP TABLE IF EXISTS `Log` CASCADE;
DROP TABLE IF EXISTS `Ride` CASCADE;
DROP TABLE IF EXISTS `Staff` CASCADE;
DROP TABLE IF EXISTS `Consumer` CASCADE;



CREATE TABLE `Log`
(
    `log_id`    VARCHAR(255) NOT NULL COMMENT 'log_id',
    `log_contents`    VARCHAR(255) NOT NULL COMMENT 'log_contents',
    `ride_code`    VARCHAR(255) NOT NULL COMMENT 'ride_code',
    `log_title` varchar(255) COMMENT 'log_title',
    `log_date` varchar(255) COMMENT 'log_date',
    `staff_id`    VARCHAR(255) COMMENT 'staff_id',
    CONSTRAINT PRIMARY KEY ( `log_id` )
) COMMENT = '점검일지';


INSERT INTO Log (log_id, log_contents, ride_code, log_title, log_date, staff_id) VALUES
                                                                                     ('L101','첫 번째 점검 일지 작성을 완료했습니다.','R101','첫 번째 점검 일지','2024-06-25','S101'),
                                                                                     ('L102','두 번째 점검 일지 작성을 완료했습니다.','R102','두 번째 점검 일지','2024-06-26','S102'),
                                                                                     ('L103','세 번째 점검 일지 작성을 완료했습니다.','R103','세 번째 점검 일지','2024-06-27','S103'),
                                                                                     ('L104','네 번째 점검 일지 작성을 완료했습니다.','R104','네 번째 점검 일지','2024-06-28','S104'),
                                                                                     ('L105','다섯 번째 점검 일지 작성을 완료했습니다.','R105','다섯 번째 점검 일지','2024-06-29','S105');


CREATE TABLE `Ride`
(
    `ride_code`    VARCHAR(255) NOT NULL COMMENT 'ride_code',
    `ride_name`    VARCHAR(255) COMMENT 'ride_name',
    `staff_id`    VARCHAR(255) NOT NULL COMMENT 'staff_id',
    constraint PRIMARY KEY ( `ride_code`,`staff_id` )
) COMMENT = '놀이기구';



INSERT INTO RIDE (ride_code, ride_name, staff_id) VALUES
                                                      ('R101','회전목마','S101'),
                                                      ('R102','롤러코스터','S102'),
                                                      ('R103','바이킹','S103'),
                                                      ('R104','파바오의 분노','S104'),
                                                      ('R105','손바딕의 모험','S105');




CREATE TABLE `Staff`
(
    `staff_id`    VARCHAR(255) NOT NULL COMMENT 'staff_id',
    `staff_phone`    VARCHAR(255) COMMENT 'staff_phone',
    `staff_rank`    VARCHAR(255) NOT NULL COMMENT 'staff_rank',
    `ride_code`    VARCHAR(255) NOT NULL COMMENT 'ride_code',
    `log_count`    INTEGER COMMENT 'log_count',
    `staff_name` varchar(255) NOT NULL COMMENT 'staff_name',
    PRIMARY KEY ( `staff_id`,`ride_code` )
) COMMENT = '직원';

ALTER TABLE Staff ADD COLUMN staff_password varchar(255) NOT NULL ;


INSERT INTO Staff (staff_id,staff_phone,staff_rank,ride_code,log_count,staff_name) VALUES
                                                                                       ('S101','010-1234-5678','사원','R101','0','박장욱'),
                                                                                       ('S102','010-2587-3699','대리','R102','1','한승엽'),
                                                                                       ('S103','010-7896-5412','과장','R103','2','정승수'),
                                                                                       ('S104','010-5557-8882','차장','R104','3','김현욱'),
                                                                                       ('S105','010-3333-6697','부장','R105','4','김명희');

CREATE TABLE `Consumer`
(
    `Consumer_id`       VARCHAR(255) NOT NULL COMMENT 'Consumer_id',
    `Consumer_pw`      varchar(255) NOT NULL COMMENT 'Consumer_pw',
    `Consumer_name`     varchar(255) NOT NULL COMMENT 'Consumer_name',
    `Consumer_phone`    VARCHAR(255) COMMENT 'Consumer_phone',
    `Consumer_rank`     VARCHAR(255) NOT NULL COMMENT 'Consumer_rank',
    `Consumer_date`     VARCHAR(255) NOT NULL COMMENT 'Consumer_date',
   CONSTRAINT PRIMARY KEY ( `Consumer_id` )
) COMMENT = '고객';



INSERT INTO Consumer (Consumer_id, Consumer_pw, Consumer_name, Consumer_phone, Consumer_rank, Consumer_date) VALUES
                                                                                       ('C101','p123','권은혜','010-5234-5678','실버','2020-02-05'),
                                                                                       ('C102','p234','배하은','010-4587-4699','골드','2020-03-05'),
                                                                                       ('C103','p345','이의정','010-3896-3412','VIP','2020-04-05'),
                                                                                       ('C104','p456','도라에몽','010-2557-2882','실버','2020-05-05'),
                                                                                       ('C105','p567','맹구','010-1333-1697','골드','2020-06-05');