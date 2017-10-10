package work2;
import java.util.ArrayList;
import java.util.List; 
public class out {
	public List<String> unlucky_student=new ArrayList<>();
	
	public static class admitted {
		public List<String> member=new ArrayList<>();
		public String department_no;
	}
	public List<admitted> admitted= new ArrayList<>();
	public List<String> unlucky_department=new ArrayList<>();
	public List<String> getUnlucky_student() {
		return unlucky_student;
	}
	public void setUnlucky_student(List<String> unlucky_student) {
		this.unlucky_student = unlucky_student;
	}
	
	
	public List<String> getUnlucky_department() {
		return unlucky_department;
	}
	public void setUnlucky_department(List<String> unlucky_department) {
		this.unlucky_department = unlucky_department;
	}
	
	
}
