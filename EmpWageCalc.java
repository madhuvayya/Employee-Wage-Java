public class EmpWageCalc {

	private static final int IS_FULL_TIME = 1;
	private static final int IS_PART_TIME = 2;

	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;

	private EmpWageCalc(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth){
		this.company = company;
		this.empRatePerHour = empRatePerHour ;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}

	public void calcEmpWageForCompany(){

		int empWorkingHrs = 0, totalEmpWage = 0, empWorkingDays = 0 ;

		while( empWorkingDays < numOfWorkingDays && empWorkingHrs <= maxHoursPerMonth ){

			empWorkingDays++;
			int empHrs = 0;
			int empCheck = (int) Math.floor( Math.random() * 10 ) % 3;

			switch( empCheck ){
		 		case IS_FULL_TIME:
					empHrs = 8;
					break;
				case IS_PART_TIME:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
			}
			empWorkingHrs += empHrs ;
		}
		totalEmpWage = empWorkingHrs * empRatePerHour;
		System.out.println(company+" Employee Wage is :"+ totalEmpWage);
	}

	public static void main(String []args){
		System.out.println("Welcome to Employee Wage Computation");

		EmpWageCalc ewc1 = new EmpWageCalc("DMart",20,2,10);
		ewc1.calcEmpWageForCompany();

		EmpWageCalc ewc2 = new EmpWageCalc("Reliance",10,4,20);
		ewc2.calcEmpWageForCompany();
	}
}
