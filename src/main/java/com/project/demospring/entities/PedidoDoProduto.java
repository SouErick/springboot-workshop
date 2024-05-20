package com.project.demospring.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.demospring.entities.pk.PedidoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class PedidoDoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private PedidoPK id = new PedidoPK();
    
    private Integer quantidade;
    private Double preco;
    
    public PedidoDoProduto() {
    }
    
    public PedidoDoProduto(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    public Produto getProduto() {
        return id.getProduto();
    }
    
    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }
    
    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }
    
    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PedidoDoProduto other = (PedidoDoProduto) obj;
        return Objects.equals(id, other.id);
    }
}