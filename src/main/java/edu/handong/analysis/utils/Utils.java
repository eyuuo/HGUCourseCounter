package edu.handong.analysis.utils;

import java.io.BufferedReader;
import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;



public class Utils {
	
	
	//파일이 잘 lines에 들어갔는지 확인 하기 위해 만든 것. 
//	public static void main(String[] args) {
//	
//		getLines("hw5data.csv",false);///Users/eyuuo/Documents/GitHub/HGUCourseCounter/hw5data.csv 라고 해도 된다.
//	}

	/**
	 * getLines method reads csv file from the given file path and returns ArrayList<String> object. One element has a string of one line. The second argument is the option to avoid including first line to ArrayList when true.
	 * getLines 메서드는 지정된 파일 경로에서 csv 파일을 읽고 ArrayList <String> 개체를 반환한다. 
	 * 한 원소는 한 줄의 줄을 가지고 있다. 
	 * 두 번째 인수는 true일 때 ArrayList에 첫 번째 라인을 포함하지 않는 옵션이다.
	 * ->파일을 읽고 한줄씩 넣은 어레이리스트를 반환한다. 
	 * @param file
	 * @param removeHeader
	 * @return
	 */
	public static ArrayList<String> getLines(String file,boolean removeHeader){
		//file = "hw5data2.csv"; //removeHeader = true
       
		ArrayList<String> lines = new ArrayList<String>();
		
		File locationFile = new File(file);
		String line = null;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(locationFile));
			while( (line = in.readLine()) != null) {
				lines.add(line);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(removeHeader==true) lines.remove(0);
		
		//저장된 라인 프린트 하기 
//		for(String line2 : lines) {
//			System.out.println(line2);
//		}
//		System.out.println(lines.get(0));
		return lines;
	}
	
	/**
	 * writeAFile saves the result information in the ArrayList to a file in the second argument. If a file does not exist in the directory, FileNotFoundException may occur, to prevent, a logic to create directory is required. There is a hint at TIPS below.
	 * writeAFile은 ArrayList의 결과 정보를 두 번째 인수의 파일에 저장한다. 
	 * 디렉토리에 파일이 없는 경우, FileNotFoundException이 발생할 수 있으며, 
	 * 이를 방지하기 위해 디렉토리를 작성하는 논리가 필요하다. 
	 * @param lines
	 * @param targetFileName
	 */
	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		
		String content="StudentID, TotalNumberOfSemestersRegistered, Semester, NumCoursesTakenInTheSemester";
		 for (int count = 0 ; count < lines.size() ; count++) {
			  content=content+"\n"+lines.get(count);
	        }
		try {
			//그냥 파일이름만 적었을때를 위해.
			if(targetFileName.contains("/")==false) targetFileName = "./"+targetFileName;
           
			Path path = Paths.get(targetFileName);
            
            Files.createDirectories(path.getParent());

            Files.write(path, content.getBytes());
            //System.out.println(Files.readAllLines(path));
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
		
		

	}

}
