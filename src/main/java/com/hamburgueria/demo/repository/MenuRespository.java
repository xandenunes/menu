package com.hamburgueria.demo.repository;

import com.hamburgueria.demo.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRespository extends JpaRepository<Menu, Long> {

    Menu findByItemId(Long aLong);
}
