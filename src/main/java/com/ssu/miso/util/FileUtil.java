package com.ssu.miso.util;

public class FileUtil {
//�ߺ����� üũ
	public String changeFilename(String filePath, String filename) {
		//�Խù���ȣ�� ���� �̸��� ���̱�
		//uuid + Ȯ���ڸ� ���ϸ�����.
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
