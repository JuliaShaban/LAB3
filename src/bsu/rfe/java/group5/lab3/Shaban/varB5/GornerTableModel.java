package bsu.rfe.java.group5.lab3.Shaban.varB5;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
		this.from = from;
		this.to = to;
		this.step = step;
		this.coefficients = coefficients;
	}
	
	public Double getFrom() {
		return from;
	}
	
	public Double getTo() {
		return to;
	}
	
	public Double getStep() {
		return step;
	}
	public int getColumnCount() {
		return 3;
	}
	@SuppressWarnings("removal")
	public int getRowCount() {
		
		return new Double(Math.ceil((to-from)/step)).intValue()+1;
	}
	
	public Object getValueAt(int row, int col) {
		double x = from + step*row;
		double r = 0;
		for (Double arg : coefficients) 
			r = r * x + arg;
		switch(col) {
		case 0:
			return x;
		case 1:	
			return r;
		default:
			if(r<2) return false;
			boolean prime = true;
			for (int i = 2; i < r/2; i++)
			if ((int)r%i==0) {
				prime = false;
				break;
			}
			return prime;
	}
	}
	
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Значение X";
		case 1:
			return "Значение многочлена";
		default:
			return "Значение простое?";
		}
	}
	
	public Class<?> getColumnClass(int col) {
		if (col==2) return Boolean.class;
		else return Double.class;
	}

}
