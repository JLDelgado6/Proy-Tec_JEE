package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdVehiculo")
	private Long idVeh;
	
	@Column(name="Marca")
	private String marcaVeh ="";
	
	@Column(name="Modelo")
	private String modeloVeh ="";
	
	@Column(name="Precio")
	private Integer precioVeh =0;
	
	
	public Vehiculo() {
	}
	public Long getIdVeh() {
		return idVeh;
	}
	public void setIdVeh(Long idVeh) {
		this.idVeh = idVeh;
	}
	public String getMarcaVeh() {
		return marcaVeh;
	}
	public void setMarcaVeh(String marcaVeh) {
		this.marcaVeh = marcaVeh;
	}
	public String getModeloVeh() {
		return modeloVeh;
	}
	public void setModeloVeh(String modeloVeh) {
		this.modeloVeh = modeloVeh;
	}
	public Integer getPrecioVeh() {
		return precioVeh;
	}
	public void setPrecioVeh(Integer precioVeh) {
		this.precioVeh = precioVeh;
	}
	@Override
	public String toString() {
		return "Vehiculo [idVeh=" + idVeh + ", marcaVeh=" + marcaVeh + ", modeloVeh=" + modeloVeh + ", precioVeh="
				+ precioVeh + "]";
	}

	
}
