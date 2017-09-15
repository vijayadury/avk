
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
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if(students == null){
			throw new IllegalArgumentException();
		}
		// Add your implementation here
		this.students = new Student[students.length];
		this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException();
		}
		// Add your implementation here
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if(student == null || index<0 || index>=students.length){
			throw new IllegalArgumentException();
		}
		this.students[index]=student;
		// Add your implementation here
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length+1];
		temp[0]= student;
		int j=1;
		for(Student s: students){
			temp[j++] = s;
		}
		this.students = temp;
	}

	@Override
	public void addLast(Student student) {
		if(student==null){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length+1];
		
		int j=0;
		for(Student s: students){
			temp[j++] = s;
		}
		temp[students.length]= student;
		this.students = temp;
	}

	@Override
	public void add(Student student, int index) {
		if(student==null){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length+1];
		temp[0]= student;
		int j=0;
		for(Student s: students){
			if(j==index){
				temp[j++]=student;
			} else {
				temp[j++] = s;
			}
		}
		this.students = temp;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length-1];
		int j=0;
		for(Student s: students){
			if(j==index){
				continue;
			} else {
				temp[j++] = s;
			}
		}
		this.students = temp;

	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(students==null){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length-1];
		int j=0;
		for(Student s: students){
			if(s.equals(student)){
				continue;
			} else {
				temp[j++] = s;
			}
		}
		this.students = temp;

	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException();
		}
		//
		int j=0;
		for(Student s: students){
			if(j==index){
				break;
			}
			j++;
		}
		Student[] temp = new Student[j+1];
		for(int k=0;k<temp.length;k++){
			temp[k] = this.students[k];
		}
		this.students = temp;
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		// Add your implementation here
		if(student == null){
			throw new IllegalArgumentException();
		}
		//
		int j=0;
		for(Student s: students){
			if(s.equals(student)){
				break;
			}
			j++;
		}
		Student[] temp = new Student[j+1];
		for(int k=0;k<temp.length;k++){
			temp[k] = this.students[k];
		}
		this.students = temp;
		

	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		
		if(index<0 || index>=students.length){
			throw new IllegalArgumentException();
		}
		//
		int j=0;
		for(Student s: students){
			if(j==index){
				break;
			}
			j++;
		}
		Student[] temp = new Student[students.length-j];
		for(int k=j;k<temp.length;k++){
			temp[k] = this.students[k];
		}
		this.students = temp;
		

	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		// Add your implementation here
		
		if(student == null){
			throw new IllegalArgumentException();
		}
		//
		int j=0;
		for(Student s: students){
			if(s.equals(student)){
				break;
			}
			j++;
		}
		Student[] temp = new Student[students.length-j];
		for(int k=j;k<temp.length;k++){
			temp[k] = this.students[k];
		}
		this.students = temp;

	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for (int a=1; a<students.length; a++) {
	        for(int b=0; b<students.length - a; b++) {
	        	if (students[b].compareTo(students[b+1]) > 0)
	            {
	                Student temp = students[b];
	                students[b] = students[b+1];
	                students[b+1] = temp;
	            }
	        }
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length];
		int j=0;
		for(Student s: students){
			if(s.getBirthDate() != null && s.getBirthDate().equals(date)){
				temp[j++]=s;
			}
		}
		Student[] temp1 = new Student[j];
		for(int k=0;k<temp1.length;k++){
			temp1[k]=temp[k];
		}
		return temp1;
		
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate == null){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length];
		int j=0;
		for(Student s: students){
			if(s.getBirthDate() != null && 
					(s.getBirthDate().equals(firstDate) || s.getBirthDate().after(firstDate))
					&& 
					(s.getBirthDate().equals(lastDate) || s.getBirthDate().before(lastDate))  ){
				temp[j++]=s;
			}
		}
		Student[] temp1 = new Student[j];
		for(int k=0;k<temp1.length;k++){
			temp1[k]=temp[k];
		}
		return temp1;

	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if(date == null){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length];
		int j=0;
		for(Student s: students){
			int d = (int) ((s.getBirthDate().getTime() - date.getTime()) / (1000 * 60 * 60 * 24));
			if(d>=days ){
				temp[j++]=s;
			}
		}
		Student[] temp1 = new Student[j];
		for(int k=0;k<temp1.length;k++){
			temp1[k]=temp[k];
		}
		return temp1;

	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent == 0 || indexOfStudent <0|| indexOfStudent>=students.length){
			throw new IllegalArgumentException();
		}
		Student s = students[indexOfStudent];
		int d = (int) ((new Date().getTime() -s.getBirthDate().getTime()) / (1000 * 60 * 60 * 24 *12*365));
		
        return d;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		if(age == 0){
			throw new IllegalArgumentException();
		}
		Student[] temp = new Student[students.length];
		int j=0;
		for(Student s: students){
			int d = (int) ((new Date().getTime() -s.getBirthDate().getTime()) / (1000 * 60 * 60 * 24 *12*365));
			if(d>=age ){
				temp[j++]=s;
			}
		}
		Student[] temp1 = new Student[j];
		for(int k=0;k<temp1.length;k++){
			temp1[k]=temp[k];
		}
		return temp1;

		
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		Student[] temp = new Student[students.length];
		int j=0;
		int tempavg=0;
		for(Student s: students){
			if(tempavg<s.getAvgMark()){
				tempavg=(int)s.getAvgMark();
			}
		}
		j=0;
		for(int k=0;k<students.length;k++){
			if(students[k].getAvgMark() == tempavg){
				temp[j++]=students[k];
			}
		}
		Student[] temp1 = new Student[j];
		int k=0;
		for(Student s:temp){
			temp1[k++]=s;
		}
		
		return temp1;

	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student==null){
			throw new IllegalArgumentException();
		}
		int j=1;
		for(Student s: students){
			if(s.equals(student)){
				break;
			} 
			j++;
		}
		if(j<students.length-1){
			return students[j];
		} else {
			return null;
		}
		

	}
}
