package work2;

import java.util.ArrayList;
import java.util.List;

public class beanDepartment {
	public List<String> event_schedules;
	public int member_limit;
	public String department_no;
	public List<String> tags;
	public boolean Dep_admit =false;
	public List<String> student_no=new ArrayList<>(); 
	public int student_num=0;
	
	public List<String> getEvent_schedules() {
		return event_schedules;
	}
	public void setEvent_schedules(List<String> event_schedules) {
		this.event_schedules = event_schedules;
	}
	public int getMember_limit() {
		return member_limit;
	}
	public void setMember_limit(int member_limit) {
		this.member_limit = member_limit;
	}
	public String getDepartment_no() {
		return department_no;
	}
	public void setDepartment_no(String department_no) {
		this.department_no = department_no;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public boolean isDep_admit() {
		return Dep_admit;
	}
	public void setDep_admit(boolean dep_admit) {
		Dep_admit = dep_admit;
	}
	public List<String> getStudent_no() {
		return student_no;
	}
	public void setStudent_no(List<String> student_no) {
		this.student_no = student_no;
	}
	
}
