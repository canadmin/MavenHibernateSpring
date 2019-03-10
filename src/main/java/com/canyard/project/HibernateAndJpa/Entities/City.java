package com.canyard.project.HibernateAndJpa.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)//otomatik artacağını belirttik
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="countrycode")
	private String countryCode;
	@Column(name="district")
	private String district;
	@Column(name="population")
	private int population;
	
	public City() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public City(int id, String name, String countryCode, String district, int population) {
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	
	//katmanlı mimari
	//bir tane veri tabani vardır
	//bir uygulama vasıtası ile bu veritabanina bağlantı kurarız
	//DataAcces katmanı en alt katmanı veri erişim katmanı biz sadece veri erişim işleri gerçekleştiririz DAL/DAo
	//hibernate kodunu dataacces katmanına yazarız Dal/Dao
	//bir de business katmanı vardır bu katman bizim iş katmanımızdır iş kodları yazılır
	//mesela koşullu işlem yapılacak
	//bir de arayüz katmanı vardır
	
	//business ile ui arasında bir service yazılmalıdır
	//bu katmanlar birbiri ile interfaceler aracılığıyla haberleşir
	
}
