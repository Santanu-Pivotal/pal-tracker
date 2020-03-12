package io.pivotal.pal.tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
	
	@Autowired
	TimeEntryRepository inEntryRepository;

	public TimeEntryController(TimeEntryRepository timeEntryRepository) {
		this.inEntryRepository= timeEntryRepository;
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
		
		TimeEntry timeentry = this.inEntryRepository.create(timeEntryToCreate);
		return new ResponseEntity<>(timeentry, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
		
		TimeEntry timeentry = this.inEntryRepository.find(timeEntryId);
		
		if(timeentry != null) {
			return new ResponseEntity<TimeEntry>(timeentry, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<TimeEntry>(timeentry, HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping
	public ResponseEntity<List<TimeEntry>> list() {
		List<TimeEntry> listtimeentry = this.inEntryRepository.list();
		
		return new ResponseEntity<List<TimeEntry>>(listtimeentry, HttpStatus.OK);
		
	}

	@PutMapping("{id}")
	public ResponseEntity<TimeEntry> update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {
		
		TimeEntry timeentry = this.inEntryRepository.update(timeEntryId, expected);
		if(timeentry != null) {
			return new ResponseEntity<TimeEntry>(timeentry, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<TimeEntry>(timeentry, HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable long timeEntryId) {
		this.inEntryRepository.delete(timeEntryId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
