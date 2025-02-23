package com.bankline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bankline.dto.LancamentoDto;
import com.bankline.model.Conta;
import com.bankline.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{
	public List<Lancamento> findByConta(Conta conta);
	
	@Query(value = "SELECT new com.bankline.dto.LancamentoDto(c.numero, cd.numero, l.date, l.descricao, pc.nome ,l.valor) "
			+ "FROM Lancamento l "
			+ "JOIN l.conta c "
			+ "LEFT JOIN l.destino cd "
			+ "JOIN l.planoConta pc "
			+ "WHERE c.id = :contaId ")
	public List<LancamentoDto> findByContaIdAndDateBetween(@Param("contaId")Integer contaId);
}


