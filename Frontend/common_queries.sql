-- Image info
select
	iid, Images.uid as uid, uname, filename, Images.description, added,
	label as taken_from
from  Images join Users using (uid) left join Objects on (taken_from = oid)
where iid = 300001;

-- all POIs and all Assumed Objects on an Image
select
	pid, POI.uid as point_author, x, y,
	aid, Votes.uid as assumption_author, votes, Votes.added as added,
	oid, description, label
from  POI left join Votes using (pid) left join Objects using (oid)
where iid = 300001
order by pid, Votes.votes desc;

-- all Comments on an Image
select
	cid, text, Comments.UID as author, vote, Comments.added as added,
	aid
from  POI join Assumptions using (pid) join Comments using (aid)
where iid = 300001;

-- search image by name
select iid, oid, filename, label, votes, Images.added
from (
	select iid, oid, max(votes) as votes
	from Votes join POI using (pid)
	where oid in (
		select oid from Objects where upper(label) like upper('%ystra%')
	)
	group by iid,oid
) as Results join Objects using (oid) join Images using (iid)
order by label, votes desc;

-- Frontpage: 4 newest Images
-- also: stupid fucking derby I will eat your soul
select * from (
    select ROW_NUMBER() OVER() as rownum, Images.*
    from Images order by added desc
) as tmp -- what the fuck, derby?!
where rownum <= 4;
