package com.example.Hello.Repos;

import com.example.Hello.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends JpaRepository<Category,Long>
{

}
