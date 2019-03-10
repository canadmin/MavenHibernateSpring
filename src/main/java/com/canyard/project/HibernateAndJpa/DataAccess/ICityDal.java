package com.canyard.project.HibernateAndJpa.DataAccess;
import java.util.List;

import com.canyard.project.HibernateAndJpa.Entities.City;
public interface ICityDal {
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);

}
