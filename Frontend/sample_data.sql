insert into Users values(100001, 'mwielgus',      'wymyslcos', CURRENT_TIMESTAMP);
insert into Users values(100002, 'jkleszczynski', 'wymyslcos', CURRENT_TIMESTAMP);
insert into Users values(100003, 'joahum',        'wymyslcos', CURRENT_TIMESTAMP);
insert into Users values(100004, 'euzebiusz',     'wymyslcos', CURRENT_TIMESTAMP);

insert into Objects values(200001, 100001, 'Bystra',             'Najwyższy szczyt Tatr Zachodnich (2248m n.p.m.).', null, null);
insert into Objects values(200002, 100001, 'Błyszcz',            'Zwornik dla grani Bystrej.',                       null, null);
insert into Objects values(200003, 100001, 'Świnica',            '2301m n.p.m. (wyższy wierzchołek).',               null, null);
insert into Objects values(200004, 100001, 'Koprowy Wierch',     'Dostępny turystycznie',                            null, null);
insert into Objects values(200005, 100001, 'Siwy Zwornik',       'Zwornik dla grani Ornaku',                         null, null);
insert into Objects values(200006, 100001, 'Wołowiec',           'Zwornik dla grani Rohaczy',                        null, null);
insert into Objects values(200007, 100001, 'Kominiarski Wierch', 'Wybitny, bardzo zamknięty. Szkoda',                null, null);
insert into Objects values(200008, 100001, 'Kościelec',          '2155m n.p.m., odosobniony - świetny widok.',       null, null);
insert into Objects values(200009, 100001, 'Niebieska Turnia',   'Piękny ząb w grani Świnicy.',                      null, null);

insert into Images values(300001, 100001, 'sample1.jpg', 'Zdjęcie robione z okolic Beskidu/Suchej Przełęczy.', CURRENT_TIMESTAMP, null);
insert into Images values(300002, 100001, 'sample2.jpg', 'Zdjęcie robione z okolic Świnicy.',                  CURRENT_TIMESTAMP, null);
insert into Images values(300003, 100001, 'sample3.jpg', 'Piękny zaawansowany wschód słońca z Giewontu.',      CURRENT_TIMESTAMP, null);
insert into Images values(300004, 100001, 'sample4.jpg', 'Widok z Ciemniaka na GGTZ',                          CURRENT_TIMESTAMP, null);
insert into Images values(300005, 100001, 'sample5.jpg', 'Widok z okolic Murowańca na Kościelec i kolegów.',   CURRENT_TIMESTAMP, null);

insert into POI values(400001, 300001, 100001, 635, 235); -- Bystra
insert into POI values(400002, 300001, 100001, 680, 247); -- Błyszcz
insert into POI values(400003, 300002, 100001,  52, 310); -- Bystra
insert into POI values(400004, 300002, 100001, 137, 324); -- Błyszcz
insert into POI values(400005, 300001, 100001, 782, 252); -- Starorobociański. Purposefully without assumptions
insert into POI values(400006, 300003, 100001, 142, 298); -- Świnica
insert into POI values(400007, 300003, 100001, 324, 320); -- Koprowy Wierch
insert into POI values(400008, 300004, 100001, 166, 347); -- Siwy Zwornik
insert into POI values(400009, 300004, 100001, 483, 323); -- Wołowiec
insert into POI values(400010, 300004, 100001, 910, 386); -- Kominiarski
insert into POI values(400011, 300005, 100001, 455, 305); -- Świnica
insert into POI values(400012, 300005, 100001, 226, 292); -- Kościelec
insert into POI values(400013, 300005, 100001, 316, 324); -- Niebieska Turnia
insert into POI values(400014, 300003, 100001, 108, 308); -- Niebieska Turnia.

insert into Assumptions values(500001, 400001, 200001, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500002, 400002, 200002, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500003, 400003, 200001, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500004, 400004, 200002, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500005, 400004, 200003, 100004, CURRENT_TIMESTAMP);
insert into Assumptions values(500006, 400004, 200001, 100004, CURRENT_TIMESTAMP);
insert into Assumptions values(500007, 400006, 200003, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500008, 400007, 200004, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500009, 400008, 200005, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500010, 400009, 200006, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500011, 400010, 200007, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500012, 400011, 200003, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500013, 400012, 200008, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500014, 400013, 200009, 100001, CURRENT_TIMESTAMP);
insert into Assumptions values(500015, 400014, 200009, 100001, CURRENT_TIMESTAMP);

insert into Comments values(600001, 500001, 100003, 'Właśnie tak! Widać po Błyszczu.',                     CURRENT_TIMESTAMP, +1);
insert into Comments values(600002, 500001, 100004, 'Zgadzam się z Tobą, joahumie, po tym właśnie widać.', CURRENT_TIMESTAMP, +1);
insert into Comments values(600003, 500004, 100004, 'Trudno orzec po tym zdjęciu - jesteś przekonany?.',   CURRENT_TIMESTAMP,  0);
insert into Comments values(600004, 500004, 100001, 'Tak. Popatrz na grań od Bystrej na dużym zoomie.',    CURRENT_TIMESTAMP,  0);
insert into Comments values(600005, 500005, 100003, 'Nie w tę stronę, euzebiuszu.',                        CURRENT_TIMESTAMP, -1);
insert into Comments values(600006, 500005, 100002, 'Świnica nie leży w Tatrach Zachodnich.',              CURRENT_TIMESTAMP, -1);
insert into Comments values(600007, 500005, 100001, 'To zdjęcie jest robione ze Świnicy...',               CURRENT_TIMESTAMP, -1);
insert into Comments values(600008, 500006, 100001, 'To jest Błyszcz - Bystra jest kawałek w lewo...',     CURRENT_TIMESTAMP, -1);
insert into Comments values(600009, 500007, 100004, 'A nie MSW?',                                          CURRENT_TIMESTAMP,  0);
insert into Comments values(600010, 500007, 100001, 'Nie. Popatrz sobie gdzie jest Koprowy',               CURRENT_TIMESTAMP,  0);
insert into Comments values(600011, 500007, 100003, 'Tak, to jest Świnica',                                CURRENT_TIMESTAMP, +1);
