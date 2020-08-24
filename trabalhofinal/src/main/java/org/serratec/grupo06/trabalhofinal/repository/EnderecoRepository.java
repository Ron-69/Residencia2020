package org.serratec.grupo06.trabalhofinal.repository;

import org.serratec.grupo06.trabalhofinal.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
