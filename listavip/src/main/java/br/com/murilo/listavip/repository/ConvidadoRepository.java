package br.com.murilo.listavip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.murilo.listavip.entity.Convidado;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}
