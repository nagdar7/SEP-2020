-- Insert rows into table 'authority'
INSERT INTO authority ( name ) VALUES ( 'AUTHOR'), ('EDITOR');

INSERT INTO `account` (`account_id`,`active`,`city`,`country`,`email`,`first_name`,`last_name`,`password`,`reviewer`,`title`,`username`) VALUES (1,1,'asdf','asdf','sloncine@hotmail.com','asdf','asdf','$2a$10$mF39BBjlDzr7begNlmcaHejSTTEx1Cu7prpiY6dtRgfbzwxg/joJe',1,'asdf','asdf');
INSERT INTO `account` (`account_id`,`active`,`city`,`country`,`email`,`first_name`,`last_name`,`password`,`reviewer`,`title`,`username`) VALUES (2,1,'ffff','ffff','asdf@adfs.com','ffff','ffff','$2a$10$t2zLE/Mv8CFTCvp.2tC5vOdgIkznczlHWhhvsMFiwnLMvk.3WmWlC',1,'ffff','ffff');
INSERT INTO `account` (`account_id`,`active`,`city`,`country`,`email`,`first_name`,`last_name`,`password`,`reviewer`,`title`,`username`) VALUES (3,1,'wert','wert','wert@wert.com','wert','wert','$2a$10$hJkTV7Aa5nlE5ZT4V1LEUe8rukcwfSrOTfhBGRPkTnzs7FEqEtnoC',0,'','wert');

INSERT INTO `account_authority` (`account_id`,`authority_name`) VALUES (1,'AUTHOR');
INSERT INTO `account_authority` (`account_id`,`authority_name`) VALUES (2,'AUTHOR');
INSERT INTO `account_authority` (`account_id`,`authority_name`) VALUES (2,'EDITOR');
INSERT INTO `account_authority` (`account_id`,`authority_name`) VALUES (3,'EDITOR');

