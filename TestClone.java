
import java.util.Objects;


public class TestClone
{
	public static void main(String[] argv) throws CloneNotSupportedException
	{
		//TODO – ADD CODE HERE
		//TODO - Add code that will produce the following results:
	
                Name name = new Name();
                name.setFirst("Joe");
                CollegeStudent student = new CollegeStudent(name, "000-09", 2020, "B.A");
                CollegeStudent studentClone = (CollegeStudent) student.clone();
                System.out.println("Testing CollegeStudent's clone method");
                System.out.println("This is Joe: "+student.toString());
                System.out.println("This is Joe's clone: "+studentClone.toString());
                studentClone.setYear(2021);
                studentClone.setDegree("M.A");
                System.out.println("This is Joe's clone after changing its year and degree: "+studentClone.toString());
                System.out.println("This is Joe: "+student.toString());
                Name newName = new Name();
                newName.setLast("Smith");
                name.giveLastNameTo(newName);
                System.out.println("This is Joe after changing its lastName: "+student.toString());
                System.out.println("This is Joe's clone: "+studentClone.toString());
	} // end main
} // end Driver
/**
   A class that represents a college student that can be cloned.
*/
class CollegeStudent extends Student implements Cloneable
{
	private int    year;   // Year of graduation
	private String degree; // Degree sought

	//TODO – ADD CODE HERE
	//TODO - Add Constructors, Getters/Setters and other required methods
    public CollegeStudent()
    {
        
    }

    public CollegeStudent(Name studentName,String studentId,int graduationYear, String degreeSought)
    {
        this.year = graduationYear;
        this.degree = degreeSought;
        super.setStudent(studentName, studentId);
        
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year) 
    {
        this.year = year;
    }

    public String getDegree() 
    {
        return degree;
    }

    public void setDegree(String degree)
    {
        this.degree = degree;
    }
    
    public void setStudent(Name studentName, String studentId, int graduationYear, String degreeSought)
    {
        super.setStudent(studentName, degree);
        this.year = graduationYear;
        this.degree = degreeSought;
    }

    @Override
    public String toString() 
    {
        return super.toString()+" Student " + year + ", " + degree+".";
    }
    
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    } 

} // end CollegeStudent

/**
   A class that represents a student that can be cloned.
*/
class Student implements Cloneable
{
	private Name   fullName;
	private String id;      // Identification number

	//TODO – ADD CODE HERE
	//TODO - Add Constructors, Getters/Setters and other required methods
    public Student() 
    {
        
    }

    public Student(Name studentName, String id)
    {
        this.fullName = studentName;
        this.id = id;
    }

    public Name getFullName() 
    {
        return fullName;
    }

    public void setFullName(Name fullName)
    {
        this.fullName = fullName;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
    public void setStudent(Name studentName, String id)
    {
        this.fullName = studentName;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() 
    {
        return   id + " "+ fullName ;
    }
    
    
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    
	
}  // end Student

/**
   A mutable class that represents a person's name that can be cloned.
*/
class Name implements Cloneable
{
	private String first; // First name
	private String last;  // Last name

	//TODO – ADD CODE HERE
	//TODO - Add Constructors, Getters/Setters and other required methods
    public Name() 
    {
        first = "";
        last = "";
    }

    public Name(String first, String last)
    {
        this.first = first;
        this.last = last;
    }

    public String getName()
    {
        return first+" "+last;
    }   
    
    public void setName(String first,String last)
    {
        this.first = first;
        this.last = last;
    }

    public String getFirst()
    {
        return first;
    }

    public void setFirst(String first)
    {
        this.first = first;
    }

    public String getLast()
    {
        return last;
    }

    public void setLast(String last)
    {
        this.last = last;
    }
    
    public void giveLastNameTo(Name aname)
    {
        this.last = aname.last;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Name other = (Name) obj;
        if (!Objects.equals(this.first, other.first)) {
            return false;
        }
        if (!Objects.equals(this.last, other.last)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  first + " " + last;
    }
    
    
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
} // end Name