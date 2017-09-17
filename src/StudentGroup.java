import java.util.Date;

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
	public void setStudent(Student student, int index)throws IllegalArgumentException {
		// Add your implementation here
		if(index<this.students.length||index>=0||student!=null){
			this.students[index]=student;
		}else{
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {
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
	public void add(Student student, int index) throws IllegalArgumentException {
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
	public void remove(int index)  {
		// Add your implementation here
       

	}

	@Override
	public void remove(Student student){
		// Add your implementation here
		
	}

	@Override
	public void removeFromIndex(int index)throws IllegalArgumentException {
		// Add your implementation here
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
