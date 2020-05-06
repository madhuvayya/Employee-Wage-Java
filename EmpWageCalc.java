public class EmpWageCalc {

	private static final int IS_FULL_TIME = 1;
	private static final int IS_PART_TIME = 2;

	public static void calcEmpWageForCompany(CompanyEmpWage cew){

		int empWorkingHrs = 0, totalEmpWage = 0, empWorkingDays = 0 ;

		while( empWorkingDays < cew.numOfWorkingDays && empWorkingHrs <= cew.maxHoursPerMonth ){

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
		totalEmpWage = empWorkingHrs * cew.empRatePerHour;
		System.out.println(cew.company+" Employee Wage is :"+ totalEmpWage);
	}

	public static void main(String []args){
		System.out.println("Welcome to Employee Wage Computation");

		CompanyEmpWage cew1 = new CompanyEmpWage ("DMart",20,2,10);
		calcEmpWageForCompany(cew1);

		CompanyEmpWage cew2 = new CompanyEmpWage ("Reliance",10,4,20);
		calcEmpWageForCompany(cew2);
	}
}
