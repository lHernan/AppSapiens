SELECT 
	STEP_NAME AS STEP, 
	TRUNCATE((b1.end_time - b1.start_time), 2) AS DURATION, 
	b1.STATUS 
FROM 
	BATCH_STEP_EXECUTION b1 inner join BATCH_JOB_EXECUTION b2
	on b1.JOB_EXECUTION_ID = b2.JOB_EXECUTION_ID
WHERE 
	b2.CREATE_TIME = 
		(select MAX(create_time) 
		 from BATCH_JOB_EXECUTION); 
