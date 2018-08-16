package com.ssu.miso.util;

public class FileUtil {
//중복파일 체크
	public String changeFilename(String filePath, String filename) {
		//게시물번호를 파일 이름에 붙이기
		//uuid + 확장자를 파일명으로.
		//
		return "";
	}

	public static void main(String[] args) {
		FileUtil fu = new FileUtil();
		System.out.println(fu.changeFilename("lana","a.jpg"));
		System.out.println(fu.changeFilename("lana","b.jpg"));
		System.out.println(fu.changeFilename("lana","a.jpg"));
		System.out.println(fu.changeFilename("lana2","b.jpg"));
	}

}
