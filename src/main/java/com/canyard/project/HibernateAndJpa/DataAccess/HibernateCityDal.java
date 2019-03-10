package com.canyard.project.HibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.canyard.project.HibernateAndJpa.Entities.City;
@Repository
public class HibernateCityDal implements ICityDal{

	private EntityManager entityManager;
	//mevzu session faktory buna otomatik enjekte edicez
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	//aspect oriented programming
	@Override
	@Transactional //sanki trasactional açıyor gibi davranıyor
	public List<City> getAll() {
		Session session=entityManager.unwrap(Session.class);//jpa hibernate ile ilgili tüm enjeksiyonları gerçekleştiriyor
		List<City> cities=session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		Session session=entityManager.unwrap(Session.class);//jpa hibernate ile ilgili tüm enjeksiyonları gerçekleştiriyor
		session.saveOrUpdate(city);
		
	}

	@Override
	public void update(City city) {

		Session session=entityManager.unwrap(Session.class);//jpa hibernate ile ilgili tüm enjeksiyonları gerçekleştiriyor
		session.saveOrUpdate(city);
	}

	@Override
	public void delete(City city) {
		Session session=entityManager.unwrap(Session.class);//jpa hibernate ile ilgili tüm enjeksiyonları gerçekleştiriyor
		City cityToDelete=session.get(City.class, city.getId());
		session.delete(cityToDelete);
		
	}
	@Override
	public City getById(int id) {
		Session session=entityManager.unwrap(Session.class);//jpa hibernate ile ilgili tüm enjeksiyonları gerçekleştiriyor
		City city=session.get(City.class, id);
		return city;
		}

}
