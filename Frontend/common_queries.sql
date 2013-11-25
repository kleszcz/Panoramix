select * from Images join POI using (iid) join Assumptions using (pid) where oid = 200001;
select * from POI    left join Assumptions using (pid) left join Objects using (oid);