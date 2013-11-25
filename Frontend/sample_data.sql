insert into Users values(100001, 'mwielgus',      'wymyslcos', CURRENT_TIMESTAMP);
insert into Users values(100002, 'jkleszczynski', 'wymyslcos', CURRENT_TIMESTAMP);
insert into Users values(100003, 'joahum',        'wymyslcos', CURRENT_TIMESTAMP);

insert into Objects values(200001, 100001, 'Bystra',  'Najwyższy szczyt Tatr Zachodnich (2248).', null, null);
insert into Objects values(200002, 100001, 'Błyszcz', 'Zwornik dla grani Bystrej.',               null, null);

insert into Images values(300001, 100001, 'sample.jpg', 'Zdjęcie robione z okolic Beskidu/Suchej Przełęczy.', CURRENT_TIMESTAMP, null);

insert into POI values(400001, 300001, 100001, 635, 235);
insert into POI values(400002, 300001, 100001, 680, 247);

insert into Assumptions values(500001, 400001, 200001, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500002, 400002, 200002, 100001, CURRENT_TIMESTAMP);

insert into Comments values(600001, 500001, 100003, 'Właśnie tak! Widać po Błyszczu.', CURRENT_TIMESTAMP, +1);
