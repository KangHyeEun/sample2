package com.goodee.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JB03_Files {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("D:/sample/abc.txt");
		System.out.println("디렉토리 여부 : " + Files.isDirectory(path));
		System.out.println("파일 여부 : " + Files.isRegularFile(path));
		System.out.println("마지막 수정 시간 : " + Files.getLastModifiedTime(path));
		System.out.println("파일 크기 : " + Files.size(path));
		System.out.println("소유자 : " + Files.getOwner(path));
		System.out.println("숨김 파일 여부 : " + Files.isHidden(path));
		System.out.println("읽기 가능 여부 : " + Files.isReadable(path));
		System.out.println("쓰기 가능 여부 : " + Files.isWritable(path));
		
		//디렉토리 생성
		Path path1 = Paths.get("D:/sample/sample1");
		if(Files.notExists(path1)) Files.createDirectories(path1);
		
		// 파일을 생성
		Path path2 = Paths.get("D:/sample/abc5.txt");
		if(Files.notExists(path2)) Files.createFile(path2);
	}
}
