package net.didier.BSM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import net.didier.BSM.entity.Book;
import net.didier.BSM.entity.myBookList;
import net.didier.BSM.service.BookService;
import net.didier.BSM.service.MyBookService;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    
    @Autowired
    private MyBookService myBookService;


    @GetMapping("/")
    public String home(){
        return"home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/avaliable_book")
    public ModelAndView getAllBook(){
        List<Book>list=service.getAllBook();
        // ModelAndView m= new ModelAndView();
        // m.setViewName("booklist");
        // m.addObject("book",list);

        return new ModelAndView("booklist", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return"redirect:/avaliable_book";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<myBookList>list=myBookService.getAllMyBook();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b=service.getBookById(id);
        myBookList mb=new myBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
       Book b= service.getBookById(id);
       model.addAttribute("book", b);
        return"bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
       service.deletById(id);
        return"redirect:/avaliable_book";
    }

    
   


    
}
