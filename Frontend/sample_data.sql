insert into Users values(100001, 'mwielgus',      'wymyslcos', CURRENT_TIMESTAMP);
insert into Users values(100002, 'jkleszczynski', 'wymyslcos', CURRENT_TIMESTAMP);
insert into Users values(100003, 'joahum',        'wymyslcos', CURRENT_TIMESTAMP);
insert into Users values(100004, 'euzebiusz',     'wymyslcos', CURRENT_TIMESTAMP);

insert into Objects values(200001, 100001, 'Bystra',  'Najwyższy szczyt Tatr Zachodnich (2248m n.p.m.).', null, null);
insert into Objects values(200002, 100001, 'Błyszcz', 'Zwornik dla grani Bystrej.',                       null, null);
insert into Objects values(200003, 100001, 'Świnica', '2301m n.p.m. (wyższy wierzchołek).',               null, null);

insert into Images values(300001, 100001, 'sample.jpg' , 'Zdjęcie robione z okolic Beskidu/Suchej Przełęczy.', CURRENT_TIMESTAMP, null);
insert into Images values(300002, 100001, 'sample2.jpg', 'Zdjęcie robione z okolic Świnicy.',                  CURRENT_TIMESTAMP, null);

insert into POI values(400001, 300001, 100001, 635, 235);
insert into POI values(400002, 300001, 100001, 680, 247);
insert into POI values(400003, 300002, 100001,  52, 310);
insert into POI values(400004, 300002, 100001, 137, 324);

insert into Assumptions values(500001, 400001, 200001, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500002, 400002, 200002, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500003, 400003, 200001, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500004, 400004, 200002, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500005, 400004, 200003, 100004, CURRENT_TIMESTAMP);
insert into Assumptions values(500006, 400004, 200001, 100004, CURRENT_TIMESTAMP);

insert into Comments values(600001, 500001, 100003, 'Właśnie tak! Widać po Błyszczu.',                     CURRENT_TIMESTAMP, +1);
insert into Comments values(600002, 500001, 100004, 'Zgadzam się z Tobą, joahumie, po tym właśnie widać.', CURRENT_TIMESTAMP, +1);
insert into Comments values(600003, 500004, 100004, 'Trudno orzec po tym zdjęciu - jesteś przekonany?.',   CURRENT_TIMESTAMP,  0);
insert into Comments values(600004, 500004, 100001, 'Tak. Popatrz na grań od Bystrej na dużym zoomie.',    CURRENT_TIMESTAMP, +1);
insert into Comments values(600005, 500005, 100003, 'Nie w tę stronę, euzebiuszu.',                        CURRENT_TIMESTAMP, -1);
insert into Comments values(600006, 500005, 100002, 'Świnica nie leży w Tatrach Zachodnich.',              CURRENT_TIMESTAMP, -1);
insert into Comments values(600007, 500005, 100001, 'To zdjęcie jest robione ze Świnicy...',               CURRENT_TIMESTAMP, -1);