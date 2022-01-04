insert into `place` (`place_type`, `place_Name`, `address`, `phone_Number`, `current_Number_Of_People`,`capacity`, `memo`, `limit_time`)
values
('SPORTS', '서울 배드민턴장', '경기도 성남시 대왕판교로 999', '010-9999-0000', 30, 20, '판교는 정말 체크남방셔츠 뿐인가', '9'),
('RESTAURANT', '패캠 레스토랑', '서울시 강남구 가나대로 123', '010-1234-5678', 29, 10, '테스트 메모', '10'),
('SPORTS', '천국 스키장', '하늘 천국 천국로 555', '010-1004-1004', 15, 9000, null, 10),
('COMMON', '패캠 본사', '111, Gana-ro, Gangnam-gu, Seoul', '010-1111-1111', 5, 50, '패캠마니사랑해주세열', '9'),
('PARTY', '패캠 무도회장', '서울시 강남구 가나대로 123 2층', '010-1234-5678', 3, 1, '에블바리', '9' ),
('SPORTS', '서울 스키장', '경기도 성남시 대왕판교로 999', '010-9999-0000', 30, 20, '판교는 정말 체크남방셔츠 뿐인가', '10'),
('RESTAURANT', '우마이돈', '서울시 강남구 가나대로 123', '010-1234-5678', 29, 10, '테스트 메모', '9'),
('SPORTS', '서울 배드민턴', '하늘 천국 천국로 555', '010-1004-1004', 15, 9000, null, '9'),
('COMMON', 'ktds 본사', '111, Gana-ro, Gangnam-gu, Seoul', '010-1111-1111', 5, 50, '패캠마니사랑해주세열', '9'),
('PARTY', 'ktds 무도회장', '서울시 강남구 가나대로 123 2층', '010-1234-5678', 3, 1, '에블바리', '9')
;

insert into `member` (`email`, `password`, `authority`, `activated`)
values
('test', '1234', 'ROLE_USER',1),
('test2','1234', 'ROLE_ADMIN',1 )
;

insert into `favorite` (`place_id`, `user_Name`)
values
(1, 'test'),
(1, 'test2')
;
