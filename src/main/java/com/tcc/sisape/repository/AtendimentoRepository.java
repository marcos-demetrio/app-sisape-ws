package com.tcc.sisape.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcc.sisape.domain.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
	public List<Atendimento> findByDataAtendimentoBetween(Date dataInicio, Date dataFinal);

	@Query(value = "select atendimento.* "
					+ " from atendimento as atendimento inner join "
					+ " agendamento as agendamento "
					+ " on atendimento.i_agendamento = agendamento.i_agendamento inner join "
					+ " cidadao as cidadao "
					+ " on cidadao.i_cidadao = agendamento.i_cidadao "
					+ " where cidadao.i_unidade_basica_saude = ?1", nativeQuery = true)
	public List<Atendimento> findByUnidadeBasicaSaude(Long aId);
	
	@Query(value = "select atendimento.* "
			+ " from atendimento as atendimento inner join "
			+ " agendamento as agendamento "
			+ " on atendimento.i_agendamento = agendamento.i_agendamento inner join "
			+ " profissional_lotacao as profissional_lotacao"
			+ " on profissional_lotacao.i_profissional_lotacao = agendamento.i_profissional_lotacao "
			+ " where profissional_lotacao.i_profissional = ?1", nativeQuery = true)
	public List<Atendimento> findByProfissional(Long aId);

	@Query(value = "select atendimento.* "
			+ " from atendimento as atendimento inner join "
			+ " agendamento as agendamento "
			+ " on atendimento.i_agendamento = agendamento.i_agendamento "
			+ " where agendamento.i_cidadao = ?1", nativeQuery = true)
	public List<Atendimento> findByCidadao(Long aId);
	
	@Query(value = "select atendimento.* "
			+ " from atendimento as atendimento inner join "
			+ " atendimento_sintoma as atendimento_sintoma "
			+ " on atendimento.i_atendimento = atendimento_sintoma.i_atendimento ", nativeQuery = true)
	public List<Atendimento> findAdoecimentoAll();
	
	@Query(value = "select atendimento.* "
			+ " from atendimento as atendimento inner join "
			+ " atendimento_sintoma as atendimento_sintoma "
			+ " on atendimento.i_atendimento = atendimento_sintoma.i_atendimento inner join "
			+ " agendamento as agendamento "
			+ " on agendamento.i_agendamento = atendimento.i_agendamento inner join "
			+ " profissional_lotacao as profissional_lotacao "
			+ " on profissional_lotacao.i_profissional_lotacao = agendamento.i_profissional_lotacao inner join "
			+ " unidade_basica_saude as unidade_basica_saude "
			+ " on unidade_basica_saude.i_unidade_basica_saude = profissional_lotacao.i_unidade_basica_saude "
			+ " where unidade_basica_saude.i_municipio = ?1", nativeQuery = true)
	public List<Atendimento> findAdoecimentoByMunicipioId(Long aId);
	
	@Query(value = "select atendimento.* "
			+ " from atendimento as atendimento inner join "
			+ " atendimento_sintoma as atendimento_sintoma "
			+ " on atendimento.i_atendimento = atendimento_sintoma.i_atendimento inner join "
			+ " agendamento as agendamento "
			+ " on agendamento.i_agendamento = atendimento.i_agendamento inner join "
			+ " profissional_lotacao as profissional_lotacao "
			+ " on profissional_lotacao.i_profissional_lotacao = agendamento.i_profissional_lotacao "
			+ " where profissional_lotacao.i_unidade_basica_saude = ?1", nativeQuery = true)
	public List<Atendimento> findAdoecimentoByUbsId(Long aId);
	
	@Query(value = "select atendimento.* "
			+ " from atendimento as atendimento inner join "
			+ " atendimento_sintoma as atendimento_sintoma "
			+ " on atendimento.i_atendimento = atendimento_sintoma.i_atendimento "
			+ " where atendimento.data_atendimento between ?1 and ?2", nativeQuery = true)
	public List<Atendimento> findAdoecimentoByDataAtendimentoBetween(Date dataInicio, Date dataFinal);
}
