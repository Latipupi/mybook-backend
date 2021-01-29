package com.tugas.adira.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugas.adira.domain.Books;
import com.tugas.adira.repository.BooksRepository;
import com.tugas.adira.service.BooksService;

@RestController
@RequestMapping("/api")
@Transactional
public class BooksResource {

	private static final String ENTITY_NAME = "books";

	private final BooksRepository booksRepository;

	private final BooksService booksService;

	
	public BooksResource(BooksRepository booksRepository, BooksService booksService) {
		this.booksRepository = booksRepository;
		this.booksService = booksService;
	}

	@PostMapping("/books")
	public ResponseEntity<Books> create(@RequestBody Books user) throws URISyntaxException {
		Books result = booksService.save(user);
		return ResponseEntity.created(new URI("/api/books/" + user.getId())).body(result);
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Books> update(@RequestBody Books user)  {
		if (user.getId() == null) {
			return new ResponseEntity("Invalid id " + ENTITY_NAME + " idnull", HttpStatus.BAD_REQUEST);
		}
		Books result = booksService.save(user);
		return  ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		booksRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/books/find-all")
	public ResponseEntity<List<Books>> findAll(Pageable pageable) {
		List<Books> page = booksService.findAll();
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Books> findById(@PathVariable Long id) {
		Optional<Books> test = booksRepository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(test.get());
	}
}