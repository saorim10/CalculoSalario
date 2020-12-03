package entities;

import java.util.Date;

public class HourContract {
	
	// Variaveis ==============================================================
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	
	// Construtores ===========================================================
	public HourContract() {
	}

	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	
	// Getters & Setters ======================================================
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	// Métodos ================================================================
	
	public Double totalValue() {
		return valuePerHour * hours;
	}
	
	// toString ==
	public String toString() {
		return "Date: "
				+ date
				+ ", value per hour: "
				+ valuePerHour
				+ ", Total of hours: "
				+ hours;
	}
}
