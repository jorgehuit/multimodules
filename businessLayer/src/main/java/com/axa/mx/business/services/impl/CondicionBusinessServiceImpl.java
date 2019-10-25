package com.axa.mx.business.services.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.dto.CondicionBusinessDto;
import com.axa.mx.business.dto.CondicionBusinessDto.CondicionBusinessOutDto;
import com.axa.mx.business.dto.CondicionBusinessDto.ListCondicionBusinessOutDto;
import com.axa.mx.business.dto.CondicionBusinessDto.ProvisionalIdBusinessDto;
import com.axa.mx.business.dto.CondicionInsertBusinessDto;
import com.axa.mx.business.exception.ResourceNotFoundException;
import com.axa.mx.business.services.CondicionBusinessService;
import com.axa.mx.persistence.entity.CatOpcionCondicion;
import com.axa.mx.persistence.entity.Condicion;
import com.axa.mx.persistence.repository.CatOpcionCondicionRepository;
import com.axa.mx.persistence.repository.CondicionRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CondicionBusinessServiceImpl implements CondicionBusinessService {
	
	private final DozerBeanMapper mapper = new DozerBeanMapper();
	private static final int ESTATUS_ACTIVO_CONDICION = 1;
	private static final int ESTATUS_INACTIVO_CONDICION = 2;
	
	@Autowired
	private CondicionRepository condicionRepository;
	
	@Autowired
	private CatOpcionCondicionRepository catOpcionCondicionRepository;

	@Override
	public CondicionBusinessDto getInfoCondicionById(Long id) {
		Condicion condicionEntity = null;
		condicionEntity = condicionRepository.getCondicionById(id);
		if (condicionEntity == null) {
			log.error("Error al obtener condición");
			throw new ResourceNotFoundException("No se encontro condición");
		}
		CondicionBusinessDto condicionBusinessDto = mapper.map(condicionEntity, CondicionBusinessDto.class);
		
		return condicionBusinessDto;
	}

	@Override
	public CondicionBusinessOutDto insertCondicion(CondicionInsertBusinessDto condicionInsertBusinessDto) {
		CondicionBusinessOutDto condicionBusinessOutDto = new CondicionBusinessOutDto();		
		Condicion condicionEntity = condicionRepository.save(createInsertCondicion(condicionInsertBusinessDto));
		if(condicionEntity != null) {
			condicionBusinessOutDto = mapper.map(condicionEntity, CondicionBusinessOutDto.class);
			
		}else {
			throw new ResourceNotFoundException("No se inserto condicion.");
		}
		
		return condicionBusinessOutDto;
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
			
		CondicionBusinessDto condicionBusinessDto = mapper.map(condicionBaja, CondicionBusinessDto.class);
		return condicionBusinessDto;
	}
	
	@Override
	public CondicionBusinessDto editarCondicion(
			Long id, 
			CondicionInsertBusinessDto condicionInsertBusinessDto) {
		Condicion condicionEntity = condicionRepository.getCondicionById(id);
		if(condicionEntity == null) {
			log.error("No se encontro condición para editar. ");
			throw new ResourceNotFoundException("No se encontro condición para editar. ");
		}
		
		condicionEntity.setDescripcion(condicionInsertBusinessDto.getDescripcion());
		condicionEntity.setTexto(condicionInsertBusinessDto.getTexto());
		condicionEntity.setTipo(condicionInsertBusinessDto.getTipo());
		condicionEntity.setTitulo(condicionInsertBusinessDto.getTitulo());
		condicionEntity.setIdGenerado(generarIdEditado(condicionEntity.getIdGenerado()));
		
		Condicion condicionMod = condicionRepository.save(condicionEntity);
		
		CondicionBusinessDto condicionBusinessDto = mapper.map(condicionMod, CondicionBusinessDto.class);
		return condicionBusinessDto;
	}
	
	@Override
	public String generarIdProvicional(ProvisionalIdBusinessDto provisionalIdBusinessDto) {
		
		List<CatOpcionCondicion> listCatOpcionCondicion = 
				catOpcionCondicionRepository.getByDescripcion(provisionalIdBusinessDto.getDescripcion().toUpperCase());
		CatOpcionCondicion catOpcionCondicion= null;
		String idProvisional = null;
		if(listCatOpcionCondicion.isEmpty()) {
			//Se genera un id provisional nuevo
			catOpcionCondicion = catOpcionCondicionRepository.save(createCatOpcionCondicion(provisionalIdBusinessDto));
			if(catOpcionCondicion == null) {
				throw new ResourceNotFoundException("No se inserto cat operacion condicion. ");
				
			}
			
			idProvisional = generarIdProvisional(catOpcionCondicion);
			catOpcionCondicion.setIdProvisional(idProvisional);
			catOpcionCondicionRepository.save(catOpcionCondicion);
			
		}else {
			//Se suma un consecutivo al generado por primera vez
			listCatOpcionCondicion.sort(Comparator.comparing(CatOpcionCondicion::getConsecutivo));
			catOpcionCondicion = catOpcionCondicionRepository.save(
					createCatOpcionCondicion(listCatOpcionCondicion.get(listCatOpcionCondicion.size() - 1)));
			if(catOpcionCondicion == null) {
				throw new ResourceNotFoundException("No se inserto cat operacion condicion. ");
				
			}
			idProvisional = generarIdProvisional(catOpcionCondicion);
			catOpcionCondicion.setIdProvisional(idProvisional);
			catOpcionCondicionRepository.save(catOpcionCondicion);
			
		}
		
		return idProvisional;
	}

	private String generarIdProvisional(CatOpcionCondicion catOpcionCondicion) {
		String idProvisional;
		StringBuilder builder = new StringBuilder();
		builder.append("P"); //P -> Provisional
		builder.append(catOpcionCondicion.getDescripcion().substring(0, 4)); //Tipo de condición
		builder.append(String.format("%04d", catOpcionCondicion.getConsecutivo())); // Nva condicion consecutivo
		builder.append("00"); 
		builder.append("00");
		idProvisional = builder.toString();
		return idProvisional;
	}

	
	private CatOpcionCondicion createCatOpcionCondicion(CatOpcionCondicion catOpcionCondicionbyDescripcion) {
		CatOpcionCondicion catOpcionCondicion = new CatOpcionCondicion();
		catOpcionCondicion.setActivo(ESTATUS_ACTIVO_CONDICION);
		catOpcionCondicion.setConsecutivo(catOpcionCondicionbyDescripcion.getConsecutivo() + 1 );
		catOpcionCondicion.setDescripcion(catOpcionCondicionbyDescripcion.getDescripcion().toUpperCase());
		catOpcionCondicion.setFechaAlta(new Date());
		
		return catOpcionCondicion;
	}

	private CatOpcionCondicion createCatOpcionCondicion(ProvisionalIdBusinessDto provisionalIdBusinessDto) {
		CatOpcionCondicion catOpcionCondicion = new CatOpcionCondicion();
		catOpcionCondicion.setActivo(ESTATUS_ACTIVO_CONDICION);
		catOpcionCondicion.setConsecutivo(ESTATUS_ACTIVO_CONDICION);
		catOpcionCondicion.setDescripcion(provisionalIdBusinessDto.getDescripcion().toUpperCase());
		catOpcionCondicion.setFechaAlta(new Date());
		
		return catOpcionCondicion;
	}

	private String generarIdEditado(String idGenerado) {
		String idBase = idGenerado.substring(0, idGenerado.length() - 2);
		Integer version = Integer.parseInt(idGenerado.substring(idGenerado.length() - 2));
		
		return idBase + String.format("%02d", version + 1);
	}

	public <T> Collection<T> getCollectionFromIteralbe(Iterable<T> itr) {
		Collection<T> cltn = new ArrayList<T>();
		itr.forEach(cltn::add); 
		
		return cltn;
	}
	
	CondicionBusinessOutDto mapCondicionBusinessToCondicionEntity(Condicion condicion) {
		CondicionBusinessOutDto condicionBusinessOutDto = mapper.map(condicion, CondicionBusinessOutDto.class);
		
		return condicionBusinessOutDto;
	}

	private Condicion createInsertCondicion(
			CondicionInsertBusinessDto condicionInsertBusinessDto) {
		Condicion condicion = new Condicion();
		condicion.setDescripcion(condicionInsertBusinessDto.getDescripcion());
		condicion.setEstatus(ESTATUS_ACTIVO_CONDICION);
		condicion.setIdGenerado(condicionInsertBusinessDto.getIdGenerado());
		condicion.setTexto(condicionInsertBusinessDto.getTexto());
		condicion.setTipo(condicionInsertBusinessDto.getTipo());
		condicion.setTitulo(condicionInsertBusinessDto.getTitulo());
		return condicion;
	}

}
