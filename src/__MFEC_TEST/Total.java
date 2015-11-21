package __MFEC_TEST;

public class Total {
	private String name = null;
	private double total_sal, nol_sal, ot_sal, late_sal;

	public Total(String name, double total_sal, double nol_sal, double ot_sal, double late_sal) {
		this.name = name;
		this.total_sal = total_sal;
		this.nol_sal = nol_sal;
		this.ot_sal = ot_sal;
		this.late_sal = late_sal;
	}

	public double getTotalSalaries() {
		return total_sal;
	}
	
	public double getNolSalaries() {
		return nol_sal;
	}
	
	public double getOtSalaries() {
		return ot_sal;
	}
	
	public double getLateSalaries() {
		return late_sal;
	}

	public String getName() {
		return name;
	}
}
