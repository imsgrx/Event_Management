package com.cdac.nashik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.nashik.entity.Pricing;
import com.cdac.nashik.repository.PricingRepo;

@Service
public class PricingServiceImple implements  PricingService{
	@Autowired
	private PricingRepo pricingRepo;

	@Override
	public Pricing insertPricings(Pricing pricing) {
		return pricingRepo.save(null);
	}

	@Override
	public List<Pricing> getAllPricings() {
		return pricingRepo.findAll();
	}
	
	@Override
	public List<Pricing> getPricingsByItems(String items) {
		return pricingRepo.findByItems(items);
	}

	@Override
	public List<Pricing> getPricingsById(int itemsId) {
		return pricingRepo.findByItemsId(itemsId);
	}

	@Override
	public Pricing updatePricings(Pricing pricing) {
		return pricingRepo.save(pricing);
	}

	@Override
	public void deletePricing(int itemsId) {
		Pricing price = pricingRepo.getById(itemsId);
		pricingRepo.delete(price);		
	}

}