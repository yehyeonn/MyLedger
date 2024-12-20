DROP TABLE IF EXISTS ALARM;
DROP TABLE IF EXISTS CATEGORIES;
DROP TABLE IF EXISTS TRANSACTIONS;
DROP TABLE IF EXISTS USER;



CREATE TABLE ALARM
(
    id      INT          NOT NULL AUTO_INCREMENT,
    user_id INT          NOT NULL,
    percent INT          NOT NULL,
    type    ENUM ('reminder', 'warning')        NOT NULL,
    message VARCHAR(200) NULL    ,
    PRIMARY KEY (id)
) COMMENT '알림';

CREATE TABLE CATEGORIES
(
    id   INT         NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL ,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
) COMMENT '카테고리';

ALTER TABLE CATEGORIES
    ADD CONSTRAINT UQ_name UNIQUE (name);

ALTER TABLE CATEGORIES
    ADD CONSTRAINT FK_USER_TO_CATEGORIES
        FOREIGN KEY (user_id)
            REFERENCES USER (id);

CREATE TABLE TRANSACTIONS
(
    id                   INT        NOT NULL AUTO_INCREMENT,
    user_id              INT        NOT NULL,
    categories_id        INT        NOT NULL,
    amount               BIGINT     NOT NULL,
    currency             VARCHAR(3) NULL    ,
    date                 DATE       NOT NULL,
    contents             VARCHAR(200)       NULL    ,
    type                 ENUM ('income', 'expense')      NOT NULL DEFAULT 'income',
    is_recurring         BOOLEAN    NULL     DEFAULT false,
    recurrence_frequency ENUM ('monthly', 'weekly', 'yearly')      NULL    ,
    PRIMARY KEY (id)
) COMMENT '수입/지출';

CREATE TABLE USER
(
    id          INT          NOT NULL AUTO_INCREMENT,
    username    VARCHAR(100) NOT NULL,
    password    VARCHAR(100) NOT NULL,
    nickname    VARCHAR(100) NOT NULL,
    profile_img VARCHAR(200) NULL    ,
    currency    VARCHAR(3)   NULL     DEFAULT 'KRW',
    PRIMARY KEY (id)
) COMMENT '사용자';

ALTER TABLE USER
    ADD CONSTRAINT UQ_username UNIQUE (username);

ALTER TABLE ALARM
    ADD CONSTRAINT FK_USER_TO_ALARM
        FOREIGN KEY (user_id)
            REFERENCES USER (id);

ALTER TABLE TRANSACTIONS
    ADD CONSTRAINT FK_USER_TO_TRANSACTIONS
        FOREIGN KEY (user_id)
            REFERENCES USER (id);

ALTER TABLE TRANSACTIONS
    ADD CONSTRAINT FK_CATEGORIES_TO_TRANSACTIONS
        FOREIGN KEY (categories_id)
            REFERENCES CATEGORIES (id);