package net.didier.BSM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.didier.BSM.entity.myBookList;
@Repository
public interface MyBookRepository extends JpaRepository<myBookList,Integer> {
    
}
