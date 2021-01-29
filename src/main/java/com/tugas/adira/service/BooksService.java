package com.tugas.adira.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tugas.adira.domain.Books;
import com.tugas.adira.repository.BooksRepository;

@Service
@Transactional
public class BooksService {

	private final BooksRepository booksRepository;
	
	public BooksService (BooksRepository booksRepository) {
		this.booksRepository=booksRepository;
	}
	
	public Books save(Books book) {
		Books result = booksRepository.save(book);
		return result;
	}
	
	public List<Books> findAll(){
		List<Books> result = booksRepository.findAll();
		return result;
	}
}
