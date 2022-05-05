package com.example.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ExpenseRepository  extends CrudRepository<Expense, Integer> {

}
