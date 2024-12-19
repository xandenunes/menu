package com.hamburgueria.demo.service;

import com.hamburgueria.demo.dto.ItemDto;
import com.hamburgueria.demo.entity.Menu;
import com.hamburgueria.demo.repository.MenuRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    MenuRespository menuRespository;

    public Menu save(ItemDto itemDto){
       return menuRespository.save(new Menu(itemDto));
    }

    public List<Menu> getAll(){
        return menuRespository.findAll();
    }

    public Menu update(Long id, ItemDto menu) throws Exception{
        Menu menuAtual = this.findById(id);
        BeanUtils.copyProperties(menu, menuAtual, "id");
        return menuRespository.save(menuAtual);
    }

    public Menu findById(Long id) throws Exception {
        return menuRespository.findByItemId(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void deleteById(Long id) {
        menuRespository.deleteById(id);
    }
}
