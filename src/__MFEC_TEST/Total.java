package __MFEC_TEST;

public class Total {
	private String name = null;
	private double total_sal;

	public Total(String name, double total_sal) {
		this.name = name;
		this.total_sal = total_sal;
	}

	public double getSalariesTotal() {
		return total_sal;
	}

	public String getName() {
		return name;
	}
}
