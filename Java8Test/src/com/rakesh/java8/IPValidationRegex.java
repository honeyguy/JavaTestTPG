package com.rakesh.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IPValidationRegex {	
	private final static String fileName = "C:\\temp\\ipv4.txt";
	private static List<String> lstStr;
	private static final String IPV4_REGEX = "(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))";
	private static Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);
	
	public static boolean isValidIPV4(final String s)
	   {          
	      return IPV4_PATTERN.matcher(s).matches();
	   }
	
	public static void checkForValidIPAdress() {
		try(Stream<String> ip4 = Files.lines(Paths.get(fileName))) {	
			lstStr = ip4.collect(Collectors.toList());
			lstStr.forEach(item -> System.out.println(" Valid IP Address? - " + item + " : " + isValidIPV4(item) ));
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {			
		checkForValidIPAdress();
	}
}