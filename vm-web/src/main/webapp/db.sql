select v.*,course_name,speaker_name from video v,course c,speaker s where speaker_id=s.id or course_id=c.id


select v.*,course_name,speaker_name from video v left join course c on course_id=c.id left join speaker s on speaker_id=s.id