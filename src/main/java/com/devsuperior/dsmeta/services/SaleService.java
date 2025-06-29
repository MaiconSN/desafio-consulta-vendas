package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	
	public List<SellerMinDTO> searchSummary(LocalDate minDate, LocalDate maxDate) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		if (minDate == null) {
			minDate = today.minusYears(1L);
		}

		if (maxDate == null) {
			maxDate = today;
		}

		List<SellerMinDTO> result = repository.searchSummary(minDate, maxDate);

		return result;
	}
	
	public Page<SaleMinDTO> searchReport(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		if (minDate == null) {
			minDate = today.minusYears(1L);
		}

		if (maxDate == null) {
			maxDate = today;
		}

		Page<SaleMinDTO> result = repository.searchReport(minDate, maxDate, name, pageable);

		return result;
	}
	
}
