package match;

import java.util.ArrayList;
import java.util.List;

public class MatchUtil {
	public static Result match(StuAndDepart sad) {
		Result res=new Result();
		//��ѧ���б���ȡ����
		List<ExStudent> es = new ArrayList<>();
		for (Student s : sad.getStudents()) {
			ExStudent estu=new ExStudent(s);
			es.add(estu);
		}
		//�������б���ȡ����
		List<ExDepartment> ed=new ArrayList<>();
		for (Department d: sad.getDepartments()) {
			ExDepartment ede=new ExDepartment(d);
			ed.add(ede);
		}
		//��ʼƥ�䣬�ɲ�������
		for (ExDepartment exdepartment : ed) {
			for (ExStudent exstudent : es) {
				if(isMatch(exdepartment,exstudent)) {
					admitted(exdepartment,exstudent);
				}
			}
		}
		//���������
		for (ExStudent exstudent : es) {
			if(!exstudent.isAdmitted()) 
				res.getUnlucky_student().add(exstudent.getStudent__no());
		}
		for (ExDepartment exdepartment : ed) {
			if(exdepartment.isEmpty())
				res.getUnluck_departments().add(exdepartment.getDepartment_no());
			else {
				res.getAdmitted().add(new Admitted(exdepartment));
			}
		}
		return res;
		
	}

	private static void admitted(ExDepartment exdepartment, ExStudent exstudent) {
		// TODO Auto-generated method stub
		int limit=exdepartment.getMember_limit();
		if(limit>0) {
			limit--;
			exdepartment.setMember_limit(limit);
			exdepartment.getMembers().add(exstudent);
			exdepartment.setEmpty(false);
			exstudent.setAdmitted(true);
		}
		
	}

	private static boolean isMatch(ExDepartment exdepartment, ExStudent exstudent) {
		// TODO Auto-generated method stub
		for (String apt :exstudent.getApplication_department()) {
			if(apt.equals(exdepartment.getDepartment_no())) {
				return tagMatch(exdepartment,exstudent);
			}
		}
		return false;
	}

	private static boolean tagMatch(ExDepartment exdepartment, ExStudent exstudent) {
		// TODO Auto-generated method stub
		for (String dtag : exdepartment.getTags()) {
			for (String stag : exstudent.getTags()) {
				if(dtag.equals(stag))
					return true;
				
			}
		}
		return false;
	}
}