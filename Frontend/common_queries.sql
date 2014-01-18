select * from Images join POI using (iid) join Assumptions using (pid) where oid = 200001;
select * from POI    left join Assumptions using (pid) left join Objects using (oid) where iid=300001;
select * from POI left join Assumptions using (pid) left join Objects using (oid) where iid=300002;
select * from (select A.*, (select coalesce(sum(vote),0) from Comments as C where C.aid = A.aid) as votes from Assumptions as A) as AV left join Objects using (oid) order by votes desc, AV.added;
