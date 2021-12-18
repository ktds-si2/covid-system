insert into `place` (`place_type`, `place_Name`, `address`, `phone_Number`, `current_Number_Of_People`,`capacity`, `memo`)
values
('SPORTS', '서울 배드민턴장', '경기도 성남시 대왕판교로 999', '010-9999-0000', 30, 20, '판교는 정말 체크남방셔츠 뿐인가'),
('RESTAURANT', '패캠 레스토랑', '서울시 강남구 가나대로 123', '010-1234-5678', 29, 10, '테스트 메모'),
('SPORTS', '천국 스키장', '하늘 천국 천국로 555', '010-1004-1004', 15, 9000, null),
('COMMON', '패캠 본사', '111, Gana-ro, Gangnam-gu, Seoul', '010-1111-1111', 5, 50, '패캠마니사랑해주세열'),
('PARTY', '패캠 무도회장', '서울시 강남구 가나대로 123 2층', '010-1234-5678', 3, 1, '에블바리')
;

insert into `user` (`email`, `nickname`, `password`, `phone_Number`, `is_Admin`)
values
('test@naver.com', '노루', 'shfn', '010-9999-0000', false),
('test1@naver.com', '사슴', 'tktma', '010-1234-5678', false),
('test2@naver.com', '강아지', 'rkddkwl', '010-1004-1004', false),
('test3@naver.com', '고양이', 'rhdiddl', '010-1111-1111', false),
('test4@naver.com', '돼지', 'ehowl', '010-1234-5678', false)
;
