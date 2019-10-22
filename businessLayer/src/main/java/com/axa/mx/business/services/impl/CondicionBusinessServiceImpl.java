package com.axa.mx.business.services.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.dto.CondicionBusinessDto;
import com.axa.mx.business.dto.CondicionBusinessDto.CondicionBusinessOutDto;
import com.axa.mx.business.dto.CondicionBusinessDto.ListCondicionBusinessOutDto;
import com.axa.mx.business.dto.CondicionInsertBusinessDto;
import com.axa.mx.business.exception.ResourceNotFoundException;
import com.axa.mx.business.services.CondicionBusinessService;
import com.axa.mx.persistence.entity.Condicion;
import com.axa.mx.persistence.repository.CondicionRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CondicionBusinessServiceImpl implements CondicionBusinessService {
	
	private static final int ESTATUS_ACTIVO_CONDICION = 1;
	private static final int ESTATUS_INACTIVO_CONDICION = 2;
	
	@Autowired
	private CondicionRepository condicionRepository;

	@Override
	public CondicionBusinessDto getInfoCondicionById(Long id) {
		Condicion condicionEntity = null;
		condicionEntity = condicionRepository.getCondicionById(id);
		if (condicionEntity == null) {
			log.error("Error al obtener condición");
			throw new ResourceNotFoundException("No se encontro condición");
		}

		return mapFromCondicionBusinessDtoToEntity(condicionEntity);
	}

	@Override
	public CondicionBusinessOutDto insertCondicion(CondicionInsertBusinessDto condicionInsertBusinessDto) {
		CondicionBusinessOutDto insertCondicionBusinessOutDto = new CondicionBusinessOutDto();
		String tipo = condicionInsertBusinessDto.getTipo().substring(0, 4);
		String idGenerado = "";
		List<Condicion> listCondicion = condicionRepository.getCondicionByIdGenerado(tipo.toUpperCase());
		if(!listCondicion.isEmpty()) {
			listCondicion.sort(Comparator.comparing(Condicion::getIdGenerado));
			idGenerado = generarIdConsecutivo(listCondicion.get(listCondicion.size() - 1));
			
		}else {
			idGenerado = generaIdPrimeraVez(tipo);
			
		}
		
		Condicion condicionEntity = condicionRepository.save(createInsertCondicion(condicionInsertBusinessDto, idGenerado));
		if(condicionEntity != null) {
			insertCondicionBusinessOutDto.setDescripcion(condicionEntity.getDescripcion());
			insertCondicionBusinessOutDto.setEstatus(condicionEntity.getEstatus());
			insertCondicionBusinessOutDto.setId(condicionEntity.getId());
			insertCondicionBusinessOutDto.setIdGenerado(condicionEntity.getIdGenerado());
			insertCondicionBusinessOutDto.setTexto(condicionEntity.getTexto());
			insertCondicionBusinessOutDto.setTipo(condicionEntity.getTipo());
			insertCondicionBusinessOutDto.setTitulo(condicionEntity.getTitulo());
			
		}else {
			throw new ResourceNotFoundException("No se inserto condicion.");
		}
		
		return insertCondicionBusinessOutDto;
	}
	
	@Override
	public ListCondicionBusinessOutDto getAllCondiciones() {
		ListCondicionBusinessOutDto listCondicionBusinessOutDto = new ListCondicionBusinessOutDto();

		listCondicionBusinessOutDto.setListCondicionBusinessOutDto(
				getCollectionFromIteralbe(condicionRepository.getCondiciones())
				.stream()
				.map(this::mapCondicionBusinessToCondicionEntity)
				.collect(toList()));

		return listCondicionBusinessOutDto;
	}
	
	@Override
	public CondicionBusinessDto bajaLogicaCondicion(Long id) {
		Condicion condicionEntity = condicionRepository.getCondicionById(id);
		if(condicionEntity == null) {
			log.error("No se encontro condición para dar de baja. ");
			throw new ResourceNotFoundException("No se encontro condición para dar de baja");
		}
		condicionEntity.setEstatus(ESTATUS_INACTIVO_CONDICION);
		Condicion condicionBaja = condicionRepository.save(condicionEntity);
			
		return mapFromCondicionBusinessDtoToEntity(condicionBaja);
	}
	
	public <T> Collection<T> getCollectionFromIteralbe(Iterable<T> itr) {
		Collection<T> cltn = new ArrayList<T>();
		itr.forEach(cltn::add); 
		
		return cltn;
	}

	private String generarIdConsecutivo(Condicion condicionEntityByIdGenerado) {
		String idGenerado = condicionEntityByIdGenerado.getIdGenerado();
		StringBuilder builder = new StringBuilder();
		if(idGenerado.length() == 12) {
			String tipo = idGenerado.substring(0, 4).toUpperCase();
			Integer nvoConsecutivo = Integer.parseInt(idGenerado.substring(4, 8));
			Integer clon = Integer.parseInt(idGenerado.substring(8, 10));
			Integer version = Integer.parseInt(idGenerado.substring(10, 12));
			builder.append(tipo); //Tipo condicion
			builder.append(String.format("%04d", nvoConsecutivo + 1)); // Nva condicion consecutivo
			builder.append(String.format("%02d",  clon +1 )); // Clon consecutivo
			builder.append(String.format("%02d",  version +1 )); // Version consecutivo
			
		}
		return builder.toString();
	}

	private String generaIdPrimeraVez(String tipo) {
		StringBuilder builder = new StringBuilder();
		builder.append(tipo.toUpperCase());
		builder.append("0001");
		builder.append("00");
		builder.append("00");
		return builder.toString();
	}
	
	CondicionBusinessOutDto mapCondicionBusinessToCondicionEntity(Condicion condicion) {
		CondicionBusinessOutDto condicionBusinessOutDto = new CondicionBusinessOutDto();
		condicionBusinessOutDto.setDescripcion(condicion.getDescripcion());
		condicionBusinessOutDto.setEstatus(condicion.getEstatus());
		condicionBusinessOutDto.setId(condicion.getId());
		condicionBusinessOutDto.setIdGenerado(condicion.getIdGenerado());
		condicionBusinessOutDto.setTexto(condicion.getTexto());
		condicionBusinessOutDto.setTipo(condicion.getTipo());
		condicionBusinessOutDto.setTitulo(condicion.getTitulo());
		
		return condicionBusinessOutDto;
	}
	
	CondicionBusinessDto mapFromCondicionBusinessDtoToEntity(Condicion condicion) {
		CondicionBusinessDto condicionBusinessDto = new CondicionBusinessDto();
		condicionBusinessDto.setDescripcion(condicion.getDescripcion());
		condicionBusinessDto.setTexto(condicion.getTexto());
		condicionBusinessDto.setTipo(condicion.getTipo());
		condicionBusinessDto.setTitulo(condicion.getTitulo());
		condicionBusinessDto.setIdGenerado(condicion.getIdGenerado());
		condicionBusinessDto.setEstatus(condicion.getEstatus());
		
		return condicionBusinessDto;
	}

	private Condicion createInsertCondicion(CondicionInsertBusinessDto condicionInsertBusinessDto, String idGenerado) {
		Condicion condicion = new Condicion();
		condicion.setDescripcion(condicionInsertBusinessDto.getDescripcion());
		condicion.setEstatus(ESTATUS_ACTIVO_CONDICION);
		condicion.setIdGenerado(idGenerado);
		condicion.setTexto(condicionInsertBusinessDto.getTexto());
		condicion.setTipo(condicionInsertBusinessDto.getTipo());
		condicion.setTitulo(condicionInsertBusinessDto.getTitulo());
		return condicion;
	}


}
