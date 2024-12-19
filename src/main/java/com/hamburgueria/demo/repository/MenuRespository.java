package com.hamburgueria.demo.repository;

import com.hamburgueria.demo.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRespository extends JpaRepository<Menu, Long> {

    Optional<Menu> findByItemId(Long aLong);
}
