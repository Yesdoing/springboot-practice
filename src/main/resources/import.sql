INSERT INTO USER (USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES ('javajigi', 'test', '재성', 'javajigi@slipp.net', NOW());
INSERT INTO USER (USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES ('sanjigi', 'test', '산지기', 'sanjigi@slipp.net', NOW());

INSERT INTO QUESTION (ID, CONTENTS, CREATE_DATE, TITLE, WRITER_ID, COUNT_OF_ANSWER) VALUES (1, 'TEST', NOW(), 'TEST', 1, 0);
INSERT INTO QUESTION (ID, CONTENTS, CREATE_DATE, TITLE, WRITER_ID, COUNT_OF_ANSWER) VALUES (2, 'TEST2', NOW(), 'TEST2', 2, 0);