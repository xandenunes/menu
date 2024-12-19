package com.hamburgueria.demo.controller;

import com.hamburgueria.demo.dto.ItemDto;
import com.hamburgueria.demo.entity.Menu;
import com.hamburgueria.demo.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cardapio")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/save")
    public ResponseEntity<Menu> save(@RequestBody ItemDto itemDto){

        Menu menu=menuService.save(itemDto);

        return ResponseEntity.status(201).body(menu);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Menu>> getAllMenu(){

        List<Menu> menu=menuService.getAll();

        return ResponseEntity.ok(menu);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity getMenu(@PathVariable Long id) {
        var menu = new Menu();
        try{
            menu = menuService.findById(id);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
        return ResponseEntity.ok(menu);
    }


    @PutMapping(value = "/save/{id}")
    public ResponseEntity updateMenu(@PathVariable Long id, @RequestBody ItemDto menu) {
        Menu menuAtualizado = new Menu();
        try{
            menuAtualizado = menuService.update(id,menu);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
        return ResponseEntity.ok(menuAtualizado);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity removeMenu(@PathVariable Long id) {
        try{
            menuService.deleteById(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
        return ResponseEntity.ok(true);
    }

}
