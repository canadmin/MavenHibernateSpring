package com.canyard.project.HibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canyard.project.HibernateAndJpa.DataAccess.ICityDal;
import com.canyard.project.HibernateAndJpa.Entities.City;
//business dataaccess den hizmet alıcak hiçbir zaman classlarla iletişim kullanmayacak
//interfaceler ile iletişim kurulacak
@Service // bu bir iş katmanıdır
public class CityManager implements ICityService {
	
//bu citymanageriçin yapılandırıcıda verilen ıcitydal çözümlenmesi gerekiyor
	private ICityDal citydal;
	@Autowired
	public CityManager(ICityDal citydal) {
		this.citydal = citydal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return this.citydal.getAll();//interface ile ıcitydal daki get all metodunu çağıdrım
	}

	@Override
	@Transactional
	public void add(City city) {
		this.citydal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.citydal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.citydal.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {

		return this.citydal.getById(id);
	}

}
