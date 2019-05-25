package edu.handong.analysis;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import edu.handong.analysis.utils.NotEnoughArgumentException;
import edu.handong.analysis.utils.Utils;

//trim()사용해야함.
public class HGUCoursePatternAnalyzer {

	private HashMap<String,Student> students;
	
	/**
	 * This method runs our analysis logic to save the number courses taken by each student per semester in a result file.
	 * Run method must not be changed!!
	 * 학기당 학생 한명당 수강하는 강좌 수를 결과 파일에 저장하기 위한 분석 논리를 실행.
	 * @param args
	 */
	public void run(String[] args) {//수정 하지 말 것.
		/* when there are not enough arguments from CLI, it throws the NotEnoughArgmentException which must be defined by you.*/
		
		try {		
			if(args.length<2)
				throw new NotEnoughArgumentException();
		} catch (NotEnoughArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(0);//파일의 경로가 올바르지 않을때. 
		} 
		
		String dataPath = args[0]; // csv file to be analyzed //hw5data2.csv 또는 /Users/eyuuo/Documents/GitHub/HGUCourseCounter/hw5data2.csv
		String resultPath = args[1]; // the file path where the results are saved.//result.csv 또는  /Users/eyuuo/Documents/GitHub/HGUCourseCounter/result.csv
		
		//line에 한줄씩 넣는다.	0
		ArrayList<String> lines = Utils.getLines(dataPath, true);
		
		students = loadStudentCourseRecords(lines);
		
		// To sort HashMap entries by key values so that we can save the results by student ids in ascending order.
		Map<String, Student> sortedStudents = new TreeMap<String,Student>(students); 
		
		// Generate result lines to be saved.
		ArrayList<String> linesToBeSaved = countNumberOfCoursesTakenInEachSemester(sortedStudents);
		
		// Write a file (named like the value of resultPath) with linesTobeSaved.
		Utils.writeAFile(linesToBeSaved, resultPath);
	}
	
	/**
	 * This method create HashMap<String,Student> from the data csv file. Key is a student id and the corresponding object is an instance of Student.
	 * The Student instance have all the Course instances taken by the student.
	 * 데이터 csv파일에서 HashMap <String, Student>를 생성한다. 키는 학생 아이디이고 해당 개체는 학생의 인스턴스다.
	 * @param lines
	 * @return
	 */
	private HashMap<String,Student> loadStudentCourseRecords(ArrayList<String> lines) {
		//리턴할 값 
		HashMap<String,Student> students = new HashMap<String,Student>();
		// TODO: Implement this method
		
		return null; // do not forget to return a proper variable.
	}

	/**
	 * This method generate the number of courses taken by a student in each semester. The result file look like this:
	 * 매 학기 수강생 수를 산출한다. 결과는 아래와 같다. 한 학생의 학기별 들은 수업의 수와 학점의 양. 파일로 내보낸다...?
	 * StudentID, TotalNumberOfSemestersRegistered, Semester, NumCoursesTakenInTheSemester 
	 * 0001,14,1,9
     * 0001,14,2,8
	 * ....
	 * 
	 * 0001,14,1,9 => this means, 0001 student registered 14 semeters in total. In the first semeter (1), the student took 9 courses.
	 * 
	 * 
	 * @param sortedStudents
	 * @return
	 */
	private ArrayList<String> countNumberOfCoursesTakenInEachSemester(Map<String, Student> sortedStudents) {
		
		// TODO: Implement this method
		
		return null; // do not forget to return a proper variable.
	}
}
