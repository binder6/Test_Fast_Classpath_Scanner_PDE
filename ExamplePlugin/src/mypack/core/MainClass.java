package mypack.core;

import java.util.List;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class MainClass {

	public static void main(String[] args) {
		FastClasspathScanner scanner = new FastClasspathScanner("mypack.core").verbose();
		List<String> classNames = scanner.scan().getNamesOfAllClasses();
		for (String name : classNames) {
			System.out.println("The class: " + name);
		}
	}
}
