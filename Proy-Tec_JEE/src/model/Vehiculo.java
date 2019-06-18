package model;

public class Vehiculo {
	private Long idVeh;
	private String marcaVeh;
	private String modeloVeh;
	private Integer precioVeh;
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
