package __MFEC_TEST;

public class Salaries {
	private float nol_sal_per_Min = (float) 300 / (float) 8 / (float) 60;
	private float nol_salOT_per_Min = ((float) 300 / (float) 8 / (float) 60) * (float) 1.5;
	private String name = null;
	private long nol_Min = 0, ot_Min = 0, late_Min = 0;
	private double nol_sal = 0, ot_sal = 0, late_sal = 0, total_sal;

	public Salaries(String name, long nol_Min, long ot_Min, long late_Min) {
		this.name = name;
		this.nol_Min = nol_Min;
		this.ot_Min = ot_Min;
		this.late_Min = late_Min;
	}

	void NomalSalaries() {
		nol_sal = nol_sal_per_Min * nol_Min;
	}

	void NomalOtSalaries() {
		ot_sal = nol_salOT_per_Min * ot_Min;
	}

	void NomalLateSalaries() {
		late_sal = 0 - (nol_sal_per_Min * late_Min);
	}

	public double getSalaries() {
		NomalSalaries();
		NomalOtSalaries();
		NomalLateSalaries();
		total_sal = nol_sal + ot_sal + late_sal;
		return total_sal;
	}

	public double getNolSalaries() {
		NomalSalaries();
		return nol_sal;
	}

	public double getOtSalaries() {
		NomalSalaries();
		return ot_sal;
	}

	public double getLateSalaries() {
		NomalSalaries();
		return late_sal;
	}

	public String getName() {
		return name;
	}
}
