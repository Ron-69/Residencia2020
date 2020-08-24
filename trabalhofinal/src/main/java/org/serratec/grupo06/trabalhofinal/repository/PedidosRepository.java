package org.serratec.grupo06.trabalhofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.serratec.grupo06.trabalhofinal.model.Pedidos;


@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer>{

}
