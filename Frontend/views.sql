drop view Votes;

create view Votes as
	select
		A.*,
		(select coalesce(sum(vote),0) from Comments as C where C.aid = A.aid) as votes
	from Assumptions as A;