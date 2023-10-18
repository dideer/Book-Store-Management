package net.didier.BSM.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.didier.BSM.entity.Book;
import net.didier.BSM.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bRepo;

    public void save(Book b){
        bRepo.save(b);
    }

    public List<Book> getAllBook(){
        return bRepo.findAll();
    }
    public Book getBookById(int id){

        return bRepo.findById(id).get();
    }

    public void deletById(int id){
        bRepo.deleteById(id);
    }
}
