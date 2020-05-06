import java.util.ArrayList;

public class EmpWageCalc {

	private static final int IS_FULL_TIME = 1;
	private static final int IS_PART_TIME = 2;

	private static int empHrs;
	private static int numOfCompanies = 0;

	private static ArrayList<CompanyEmpWage> companiesArrayList = new ArrayList<CompanyEmpWage>();
	private static ArrayList<Integer> wagesArrayList = new ArrayList<Integer>(); 

	public static void addCompany(String company, int empRatePerHr, int maxWorkingDays, int maxWorkingHrsPerMonth){
		CompanyEmpWage cew = new CompanyEmpWage (company,empRatePerHr,maxWorkingDays, maxWorkingHrsPerMonth);
		companiesArrayList.add(cew);
		numOfCompanies++;
	}	

	public static void calcEmpWageForEachCompany(){
		for(int company=0; company<numOfCompanies ; company++){
			int totalWage = calcEmpWage(companiesArrayList.get(company));
			System.out.print(companiesArrayList.get(company).company+" company employee Daily wages:");
			printCompanyEmpDailyWage(companiesArrayList.get(company).numOfWorkingDays);
			System.out.println();
			System.out.println("totalWage"+totalWage);
		}
	}		

	public static void printCompanyEmpDailyWage(int numOfWorkingDays){
		for(int workingDay=0; workingDay < numOfWorkingDays; workingDay++){
			System.out.print(wagesArrayList.get(workingDay)+" ");			
		}
        }
	
	
	public static int empWorkingHours(){
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
		return empHrs;
	}

	public static int calcEmpWage(CompanyEmpWage cew){

		int totalWorkingHrs = 0, totalEmpWage = 0, empWorkingDays = 0, empWage = 0;

		while( empWorkingDays < cew.numOfWorkingDays && totalWorkingHrs <= cew.maxHoursPerMonth ){
			empWorkingDays++;
			int empWorkingHrs = empWorkingHours();
			totalWorkingHrs += empWorkingHrs; 
			wagesArrayList.add(empWorkingHrs * cew.empRatePerHour);				
		}
		totalEmpWage = totalWorkingHrs * cew.empRatePerHour;		
		return totalEmpWage; 
	}

	public static void main(String []args){
		System.out.println("Welcome to Employee Wage Computation");

		addCompany("DMart",20,2,10);
		addCompany("Reliance",10,4,20);

		calcEmpWageForEachCompany();
	}
}
