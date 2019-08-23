package serviceimplementation;

import entity.Student_Info;

public class Calculate {		
	
	public static int getTotal(Student_Info student_info)
	{
		int total;
		int maths=student_info.getMaths();
		System.out.println(maths);
		int chemistry=student_info.getChemistry();
		int physics=student_info.getPhysics();
		total=maths+physics+chemistry;
		System.out.println(total);
		return total;
	}
	public static String getGrade(int total)
	{
		if(total>=300)
		{
			return "A";
		}
		if(total<300 && total>200)
		{
			return "B";
		}
		if(total<=200 && total >100)
		{
			return "C";
		}
		else
			return "D";
	}
}

