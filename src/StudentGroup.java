import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

import javax.xml.ws.handler.LogicalMessageContext;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		try{
			if(students!=null){
				this.students=students;
			}else{
				throw new IllegalArgumentException();
			}
		}catch(IllegalArgumentException e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<this.students.length||index>=0){
			return this.students[index];
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<this.students.length||index>=0||student!=null){
			this.students[index]=student;
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student!=null){
			Student temp1=student;
			Student temp2=this.students[0];
			int i;
			for(i=0;i<this.students.length-2;i++){
				students[i]=temp1;
				temp1=students[i+1];
				students[i+1]=temp2;
				temp2=students[i+2];
			}
			students[i+1]=temp2;
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student!=null){
			students[students.length+1]=student;
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<this.students.length||index>=0||student!=null){
			Student temp1=student;
			Student temp2=this.students[index];
			int i;
			for(i=index;i<this.students.length-2;i++){
				students[i]=temp1;
				temp1=students[i+1];
				students[i+1]=temp2;
				temp2=students[i+2];
			}
			students[i+1]=temp2;
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void remove(int index) throws IllegalArgumentException {
		// Add your implementation here
		if(index<this.students.length||index>=0||students!=null){
			
			for(int i=index;i<this.students.length;i++)
				{
				this.students[i]=students[i+1];
				}
		}else{
			throw new IllegalArgumentException();
		}
			
		
	}

	@Override
	public void remove(Student student)throws IllegalArgumentException {
		// Add your implementation here
		try {
			if(students!=null)
		{
			for (int i=0;i<this.students.length;i++)
             {
				if(students[i]==student)
				{
					students[i]=students[i+1];
				}
				else
				{
					throw new IllegalArgumentException();
					}
             }
		}
		}
                catch(IllegalArgumentException e){
					System.out.println("Student not exist");
	          }
		}
	

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<this.students.length||index>=0||students!=null){
			
			for(int i=index;i<this.students.length;i++)
				{
				this.students[i]=null;
				}
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException {
		// Add your implementation here
		int index=0;
		if(students!=null){
		for(int i=0;i<this.students.length;i++)
		{
			if(students[i]==student)
			{
				index=i;           
			}
		
        }
		for(int i=index;i<students.length;i++){
			students[i]=null;
			}
		}
		 else {
				throw new IllegalArgumentException();
		}
	}

	@Override
	public void removeToIndex(int index)throws IllegalArgumentException {
		// Add your implementation here
			if(index<this.students.length||index>=0||students!=null){	
			for(int i=0;i<index;i++)
				{
				this.students[i]=null;
				}
			}else{
				throw new IllegalArgumentException();
			}
		}

	@Override
	public void removeToElement(Student student) throws IllegalArgumentException{
		// Add your implementation here
		int index=0;
		if(students!=null){
			for(int i=0;i<this.students.length;i++){
				if(students[i]==student){
					index=i;           
				}	
        	}
			for(int i=index;i<students.length;i++){
				students[i]=null;
			}
		}else{
			throw new IllegalArgumentException();
		}
	}




	@Override
	public void bubbleSort() {
		// Add your implementation here
		int temp=0;
		for(int i=0;i<this.students.length;i++)
		{
			for(int j=1;j<this.students.length;j++)
			{
				if(students[j-1].getId()>students[j].getId())
				{
					temp=students[j-1].getId();
					students[j-1].setId(students[j].getId());
					students[j].setId(temp);
				}
					
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) throws IllegalArgumentException{
		// Add your implementation here
		Student[] res=new Student[students.length];
		int j=0;
		if(date!=null){
			for(Student student:students){
				if(date.compareTo(student.getBirthDate())==0){
					res[j]=student;
					j++;
				}
			}
		}else{
			throw new IllegalArgumentException();
		}
		return res;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException{
		Student[] res=new Student[students.length];
		int j=0;
		if(firstDate!=null||lastDate!=null){
			for(Student student:students){
				if(firstDate.compareTo(student.getBirthDate())>=0&&lastDate.compareTo(student.getBirthDate())<=0){
					res[j]=student;
					j++;
				}
			}
		}else{
			throw new IllegalArgumentException();
		}
		return res;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) throws IllegalArgumentException {
		// Add your implementation here
		
		Student[] res=new Student[students.length];
		int i=0;
		for(Student student:students){
			if(Math.abs(student.getBirthDate().getTime()-date.getTime())<=days){
				res[i]=student;
			}
		}
		return res;
}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		Calendar cal=Calendar.getInstance();
		cal.setTime(students[indexOfStudent].getBirthDate());
		return Calendar.getInstance().get(Calendar.YEAR)-cal.get(Calendar.YEAR);
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student[] res=new Student[students.length];
		int j=0;
		for(int i=0;i<students.length;i++){
			if(getCurrentAgeByDate(i)==age){
				res[j]=students[i];
				j++;
			}
		}
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max=students[0].getAvgMark();
		for(int i=0;i<students.length;i++)
		{
			max=students[i].getAvgMark();
		}
		Student[] result= new Student[students.length];
        for(int i=0;i<students.length;i++)
		{
        	if(students[i].getAvgMark()==max)
        	{
        	result[i]=students[i];	
        	}
		}
		
		return result ;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		
		if(student!=null)
		{	
			int index=0;
			for(int i=0;i<students.length;i++)
			{
				if(students[i]==student)index=i;
			}
			return students[index+1];
		}else{
			throw new IllegalArgumentException();
		}
		
	}
}
