package com.goodee.main;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class JB02_FileSystem {

	public static void main(String[] args) throws IOException {
		FileSystem fileSystem = FileSystems.getDefault();
		
		for (FileStore store : fileSystem.getFileStores()) {
			System.out.println("드라이버명 : " + store.name());
			System.out.println("파일시스탬 : " + store.type());
			System.out.println("전체 공간 : " + store.getTotalSpace() + "바이트");
			System.out.println("사용중안 공간 : " + (store.getTotalSpace() - store.getUnallocatedSpace())+ "바이트");
			System.out.println("사용 가능한 공간 : " + store.getUnallocatedSpace());
			System.out.println("파일 구분자 : " + fileSystem.getSeparator());
		}
	}

}
