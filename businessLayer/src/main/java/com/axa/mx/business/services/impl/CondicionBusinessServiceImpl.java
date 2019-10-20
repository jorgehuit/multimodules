package com.axa.mx.business.services.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.client.ClienteRemoto;
import com.axa.mx.business.dto.CondicionBusinessDto;
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
	@Autowired
	private CondicionRepository condicionRepository;
	
	@Autowired
	private ClienteRemoto clienteRemoto;

	@Override
	public CondicionBusinessDto getInfoCondicionById(Long id) {
		Condicion condicionEntity = null;
		try {
			condicionEntity = condicionRepository.findById(id).get();
			
		} catch (Exception e) {
			log.error("Error al obtener condición");
			throw new ResourceNotFoundException("No se encontro condición");
		}
		
		return mapFromCondicionBusinessDtoToEntity(condicionEntity);
	}

	@Override
	public String insertCondicion(CondicionInsertBusinessDto condicionInsertBusinessDto) {
		
		String tipo = condicionInsertBusinessDto.getTipo().substring(0, 4);
		String idGenerado = "";
		List<Condicion> listCondicion = condicionRepository.getCondicionByIdGenerado(tipo);
		if(!listCondicion.isEmpty()) {
			listCondicion.sort(Comparator.comparing(Condicion::getIdGenerado));
			idGenerado = generarIdConsecutivo(listCondicion.get(listCondicion.size() - 1));
			
		}else {
			idGenerado = generaIdPrimeraVez(tipo);
			
		}
		
		Condicion condicionEntity = condicionRepository.save(createInsertCondicion(condicionInsertBusinessDto, idGenerado));
		
		return condicionEntity != null ? "Id : " + condicionEntity.getId() + " Id Generado : " + condicionEntity.getIdGenerado() : null;
	}

	private String generarIdConsecutivo(Condicion condicionEntityByIdGenerado) {
		String idGenerado = condicionEntityByIdGenerado.getIdGenerado();
		StringBuilder builder = new StringBuilder();
		if(idGenerado.length() == 12) {
			String tipo = idGenerado.substring(0, 4);
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
		builder.append(tipo);
		builder.append("0001");
		builder.append("00");
		builder.append("00");
		return builder.toString();
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
