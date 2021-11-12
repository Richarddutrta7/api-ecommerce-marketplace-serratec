package com.grupo4.projetofinalapi.repositories;

import com.grupo4.projetofinalapi.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{
}
