package com.hamburgueria.demo.entity;

import com.hamburgueria.demo.dto.ItemDto;
import jakarta.persistence.*;


import java.util.UUID;

@Entity
@Table(name = "menu")
public class Menu {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    @Id
    private int itemId;
    @Column
    private String descricao;
    @Column
    private Double preco;
    @Column
    private String nome;

    public Menu() {
    }

    public Menu(ItemDto itemDto) {
        this.descricao = itemDto.descricao();
        this.preco = itemDto.preco();
        this.nome = itemDto.nome();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

//    @DynamoDbPartitionKey
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    @DynamoDbSortKey
//    @DynamoDbAttribute("item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
