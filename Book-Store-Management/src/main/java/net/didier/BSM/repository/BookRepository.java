package net.didier.BSM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.didier.BSM.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    
}


