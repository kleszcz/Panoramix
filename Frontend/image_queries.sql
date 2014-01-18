select POI.pid, POI.x, POI.y, OBJECTS.Label, Objects.DESCRIPTION, A.Aid, (select coalesce(sum(vote),0) from comments where aid = A.aid) as votes from POI left join ASSUMPTIONS as A using(pid) left join Objects using (oid) where POI.IID = 300002 order by pid, votes asc;
select DISTINCT Images.IID, Images.FILENAME, Images.DESCRIPTION  from PANORAMIX.Images join POI using (iid) join Assumptions using (pid) where oid = 200001;

select * from POI left join ASSUMPTIONS as A using(pid) left join Comments using (aid) where POI.IID = 300002 ;