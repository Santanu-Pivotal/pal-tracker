package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {

	private long id;
	private long projectId;
	private long userId;
	private LocalDate date;
	private int hours;
	
	public TimeEntry(long projectId2, long userId2, LocalDate parse, int i) {
		this.projectId = projectId2;
		this.userId = userId2;
		this.date = parse;
		this.hours = i;
	}
	public TimeEntry(long timeEntryId, long projectId2, long userId2, LocalDate parse, int i) {
		
		this.id = timeEntryId;
		this.projectId = projectId2;
		this.userId = userId2;
		this.date = parse;
		this.hours = i;
		
	}
	public TimeEntry() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + hours;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (projectId ^ (projectId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeEntry other = (TimeEntry) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hours != other.hours)
			return false;
		if (id != other.id)
			return false;
		if (projectId != other.projectId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
