package work2;
import java.util.ArrayList;
import java.util.List;

import work2.out.admitted;
public class match {
	public static out result(bean b) {
		List<beanStudent> stu= b.getStudents();
		List<beanDepartment> dep = b.getDepartments();
	    for(int i=0;i<dep.size();i++)
	    {
	    	beanDepartment bd=dep.get(i);//获得部门对象
	    	for(int j=0;j<stu.size();j++)
	    	{
	    		beanStudent bs=stu.get(j);//获得学生对象
	    		//System.out.println(bs.getApplications_department());
	    		//System.out.println(bd.department_no);
	    		if(bs.getApplications_department().contains(bd.department_no))
	    		{
	    			
	    			
	    			
	    			List<String> es=bd.event_schedules;
	    			for(int k=0;k<es.size();k++)
	    			{	    			
	    				if(bs.getFree_time().contains(es.get(k)))
	    				{	System.out.println(111111);	
	    					List<String> tag=bd.tags;
	    					for(int l=0;l<tag.size();l++)
	    						if(bs.getTags().contains(tag.get(l)))
	    						{
	    							bs.Stu_admit=true;
					    			bd.Dep_admit=true;
					    			bd.student_no.add(bs.student_no);
					    			
					    			
	    						}
	    					
	    				}
	    			}
	    		}
	    			
	    			
	    			
	    				
	    		}
	    	}
	    
	    out output=new out();
	    for(int j=0;j<stu.size();j++)
    	{
    		beanStudent bs=stu.get(j);
    		if(bs.Stu_admit==false)
    		{
    			output.getUnlucky_student().add(bs.student_no);
    		}
    	}

	    for(int i=0;i<dep.size();i++)
	    {
	    	beanDepartment bd=dep.get(i);
	    	if(bd.Dep_admit==true)
	    	{
	    		for(int j=0;j<bd.student_no.size();j++)
	    		{
	    			admitted ad = new admitted();
	    			ad.department_no=bd.department_no;
	    			ad.student_no=bd.student_no;
	    			output.admitted.add(ad);
	    		}
	    	}
	    
	    }
	    for(int i=0;i<dep.size();i++)
	    {
	    	beanDepartment bd=dep.get(i);
	    	if(bd.Dep_admit==false)
	    	{
	    		output.getUnlucky_department().add(bd.department_no);
	    	}
	    }
		return output;
	    
	    
	}
	
}

