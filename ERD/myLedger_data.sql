# 외래 키 제약 조건 비활성화
SET FOREIGN_KEY_CHECKS = 0;

#테이블 삭제
DELETE
FROM ALARM;
ALTER TABLE ALARM
    AUTO_INCREMENT = 1;

DELETE
FROM CATEGORIES;
ALTER TABLE CATEGORIES
    AUTO_INCREMENT = 1;

DELETE
FROM TRANSACTIONS;
ALTER TABLE TRANSACTIONS
    AUTO_INCREMENT = 1;

DELETE
FROM USER;
ALTER TABLE USER
    AUTO_INCREMENT = 1;

# 외래 키 제약 조건 활성화
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO USER (username, password, nickname, profile_img, currency)
VALUES ('yee', '1234', '옌', '435a27099c2f7a977390c210a3405c66.gif', null);

select * from USER;

INSERT INTO CATEGORIES (user_id, name) VALUES (1, '현대카드');
INSERT INTO CATEGORIES (user_id, name) VALUES (1, '엄카');

select * from CATEGORIES;

INSERT INTO TRANSACTIONS (user_id, categories_id, amount, currency, date, contents, type, recurrence_frequency)
VALUES (1, 1, 12000, null, CURDATE(), '식비', 'expense', null);

# select * from TRANSACTIONS;