package com.tugas.adira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tugas.adira.domain.Books;


@SuppressWarnings("unused")
@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
	
}