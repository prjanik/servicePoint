package com.app.crud.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="point")
public class Point {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false, insertable = true, updatable = true)
	private int id;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city_id")
	private City city;
    
    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "country_id")
	private Country country;


    @Column(name="address", nullable = true, insertable = true, updatable = true, length = 45)
	private String address;

    @Column(name="name", nullable = false, insertable = true, updatable = true, length = 45)
	private String name;

    @ManyToMany
    @JoinTable(
			name="point_service",
			joinColumns=@JoinColumn(name="point_id"),
			inverseJoinColumns=@JoinColumn(name="service_id")
			)
	private List<Service> services = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }

    public Country getCountry()
    {
        return country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Service> getServices()
    {
        return services;
    }

    public void setServices(List<Service> services)
    {
        this.services = services;
    }

    public void addService(Service service) {

		if (services == null) {
			services = new ArrayList<>();
		}

		services.add(service);
	}

	@Override
	public String toString() {
		return "Point [id=" + id + ", name=" + name + "]";
	}
		
}











