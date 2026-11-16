
CREATE INDEX idx_check_result_monitor_checked_at
ON check_result (monitor_id, checked_at DESC);

ALTER TABLE monitor
RENAME CONSTRAINT monitor_pkey TO pk_monitor;

ALTER TABLE check_result
RENAME CONSTRAINT check_result_pkey TO pk_check_result;

ALTER TABLE check_result
RENAME CONSTRAINT check_result_monitor_id_fkey
TO fk_check_result_monitor;

ALTER TABLE monitor
ADD CONSTRAINT ck_monitor_interval_positive
CHECK (check_interval_seconds > 0);


ALTER TABLE monitor
ALTER COLUMN active SET DEFAULT TRUE;
