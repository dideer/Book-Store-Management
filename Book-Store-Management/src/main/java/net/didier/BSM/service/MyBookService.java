package net.didier.BSM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.didier.BSM.entity.myBookList;
import net.didier.BSM.repository.MyBookRepository;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository mybook;


    public void saveMyBooks(myBookList book){
        mybook.save(book);
    }

    public List<myBookList> getAllMyBook(){
        return mybook.findAll();
    }

    public void deletById(int id){
        mybook.deleteById(id);
    }


}
