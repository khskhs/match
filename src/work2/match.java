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
	    			
	    			
	    			boolean Timematch=false;
	    			List<String> es=bd.event_schedules;
	    			List<String> ft=bs.free_time;
	    			for(int k=0;k<es.size();k++)
	    			{
	    				String DepDay="";
	    				String DepTime="";
	    				
	    				for(int l=0;l<es.get(k).length();l++)
	    				{
	    					if(es.get(k).charAt(l)>=65&&es.get(k).charAt(l)<=122)
	    					{
	    						DepDay+=es.get(k).charAt(l);
	    					}
	    					else if(es.get(k).charAt(l)=='.')
	    					{
	    						continue;
	    					}
	    					else if(es.get(k).charAt(l)==':')
	    					{
	    						break;
	    					}
	    					else
	    					{
	    						DepTime+=es.get(k).charAt(l);
	    					}
	    				}
	    				for(int n=0;n<bs.free_time.size();n++)
	    				{
	    					String StuDay="";
		    				String StuTime="";
		    				
	    					for(int m=0;m<ft.get(n).length();m++)
	    					{
	    						if(ft.get(n).charAt(m)>=65&&ft.get(n).charAt(m)<=122)
		    					{
		    						StuDay+=ft.get(n).charAt(m);
		    					}
		    					else if(ft.get(n).charAt(m)=='.')
		    					{
		    						continue;
		    					}
		    					else if(ft.get(n).charAt(m)==':')
		    					{
		    						break;
		    					}
		    					else
		    					{
		    						StuTime+=ft.get(n).charAt(m);
		    					}
	    					}
	    					if(DepDay==StuTime&&(DepTime==StuTime)||(StuTime+1==DepTime))
		    				 {
		    					 Timematch=true;
		    					 break;
		    				 }
	    				}
	    				if(Timematch=true)
	    					break;
	    			}	 
	    					   		
	    					List<String> tag=bd.tags;
	    					for(int l=0;l<tag.size();l++)
	    						if(Timematch=true&&bs.getTags().contains(tag.get(l)))
	    						{
	    							if(bd.member_limit-->0)
	    							{
	    								bs.Stu_admit=true;
	    								bd.Dep_admit=true; 
			
	    								bd.student_no.add(bs.student_no);
					    			break;
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
	    			admitted ad = new admitted();
	    			ad.department_no=bd.department_no;
	    			ad.member=bd.student_no;
	    			output.admitted.add(ad);
	    		
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


