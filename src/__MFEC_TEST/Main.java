package __MFEC_TEST;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Scanner sc = new Scanner(new File("working_time.log"));
		ArrayList<Input> arlIn = new ArrayList<Input>();
		ArrayList<Salaries> arlSa = new ArrayList<Salaries>();
		ArrayList<Total> arlSaTotal = new ArrayList<Total>();
		SimpleDateFormat df = new SimpleDateFormat("d/M/yyyy HH:mm");
		String startOT = "17:30";
		String startLate = "08:05";
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split("\\|");
			try {
				arlIn.add(new Input(str[0], str[1], str[2], str[3], str[4]));
			} catch (Exception ex) {
				arlIn.add(new Input(str[0], str[1], "00:00", str[3], "00:00"));
			}
		}
		String dateTmp = arlIn.get(0).getStartDate();
		int hNum = 0;
		for (int i = 0; i < arlIn.size(); i++) {
			if (!arlIn.get(i).getStartTime().equals("00.00")) {
				Date dS = null;
				Date dE = null;
				Date dOT = null;
				Date dLate = null;
				try {
					dS = df.parse(arlIn.get(i).getStartDT());
					dE = df.parse(arlIn.get(i).getEndDT());
					dOT = df.parse(arlIn.get(i).getStartDate() + " " + startOT);
					dLate = df.parse(arlIn.get(i).getStartDate() + " " + startLate);
					long nol_Min = 0;
					long ot_Min = (dE.getTime() - dOT.getTime());
					long late_Min = (dS.getTime() - dLate.getTime());
					if ((dS.getTime() < (dOT.getTime() + 1800000)) && (dE.getTime() - dS.getTime() != 0)) {
						nol_Min = 480;
						late_Min = late_Min / 60 / 1000;
					} else {
						nol_Min = 0;
						late_Min = 0;
					}
					ot_Min = ot_Min > 0 ? ot_Min / 60 / 1000 : 0;
					late_Min = late_Min > 0 ? late_Min : 0;
					arlSa.add(new Salaries(arlIn.get(i).getName(), nol_Min, ot_Min, late_Min));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {

			}
			if (dateTmp.equals(arlIn.get(i).getStartDate())) {
				hNum++;
			}
		}
		for (int i = 0; i < hNum; i++) {
			double tmpSal = 0;
			double tmpNolSal = 0;
			double tmpOtSal = 0;
			double tmpLateSal = 0;
			for (int j = i + 0; j < arlIn.size(); j += hNum) {
				if (arlSa.get(i).getName().equals(arlSa.get(j).getName())) {
					tmpSal += arlSa.get(j).getSalaries();
					tmpNolSal += arlSa.get(j).getNolSalaries();
					tmpOtSal += arlSa.get(i).getOtSalaries();
					tmpLateSal += arlSa.get(i).getLateSalaries();
				}
			}
			arlSaTotal.add(new Total(arlSa.get(i).getName(), tmpSal, tmpNolSal, tmpOtSal, tmpLateSal));
		}
		System.out.printf("|=======================================================================|\n");
		System.out.printf("|  No.\tName.\t\t\tNol\tOT\tLate\tTotal\t\t|");
		System.out.printf("\n|=======================================================================|\n");
		for (int i = 0; i < arlSaTotal.size(); i++) {
			System.out.print("|  " + (i + 1) + "\t");
			System.out.print(arlSaTotal.get(i).getName() + "  \t\t"
					+ arlSaTotal.get(i).getNolSalaries() + "\t" + arlSa.get(i).getOtSalaries() + "\t"
					+ arlSa.get(i).getLateSalaries() + "\t" + arlSaTotal.get(i).getTotalSalaries());
			System.out.println("    \t|");
		}
		System.out.printf("|=======================================================================|\n");
	}
}
