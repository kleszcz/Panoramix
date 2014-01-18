-- display image
select * from POI    left join Assumptions using (pid) left join Objects using (oid) where iid=300001;

-- search
select iid, oid, filename, label, votes, Images.added
from (
	select iid, oid, max(votes) as votes
	from Votes left join POI using (pid)
	where oid in (
		select oid from Objects where upper(label) like upper('%wat%')
	)
	group by iid,oid
) as Results left join Objects using (oid) left join Images using (iid)
order by label, votes desc;