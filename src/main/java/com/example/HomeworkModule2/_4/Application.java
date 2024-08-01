package com.example.HomeworkModule2._4;

import com.example.HomeworkModule2._4.Entity.Note;
import com.example.HomeworkModule2._4.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final NoteService noteService;

	@Autowired
	public Application(NoteService noteService) {
		this.noteService = noteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Note note1 = new Note();
		note1.setTitle("First Note");
		note1.setContent("This is the content of the first note.");
		noteService.add(note1);

		Note note2 = new Note();
		note2.setTitle("Second Note");
		note2.setContent("This is the content of the second note.");
		noteService.add(note2);

		
		noteService.listAll().forEach(System.out::println);

		
		note1.setContent("Updated content of the first note.");
		noteService.update(note1);
		System.out.println(noteService.getById(note1.getId()));

		
		noteService.deleteById(note2.getId());
		System.out.println(noteService.listAll());
	}
}
