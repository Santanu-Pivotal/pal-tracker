package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
	
	public TimeEntry create(TimeEntry t);
	public List<TimeEntry> list();
	public TimeEntry update(Long id,TimeEntry t);
	public void delete(Long id);
	TimeEntry find(Long id);

}
