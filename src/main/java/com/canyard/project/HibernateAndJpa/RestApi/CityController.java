package com.canyard.project.HibernateAndJpa.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canyard.project.HibernateAndJpa.Entities.City;
import com.canyard.project.HibernateAndJpa.Business.ICityService;

//bunun bir rest controller olabilmesi için restcontroller anatsyonu ile süslenmesi gerekir
//bu noktada bir diğer durum ise api lerde standart vardır domain isimleri 
@RestController
@RequestMapping("/api")//bu clastaki her operasyon api ile başlayacak
public class CityController {
	private ICityService cityService;

	@Autowired// hızlı injection cityservise sadece manager kullanıyor
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	@GetMapping("/cities")
	public List<City> get(){
		return cityService.getAll();
	}
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		this.cityService.add(city);
	}
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		this.cityService.update(city);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		this.cityService.delete(city);
	}
	
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id){ // bu
		return cityService.getById(id);
	}
 
}
