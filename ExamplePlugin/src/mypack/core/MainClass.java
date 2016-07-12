package mypack.core;

import java.util.List;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class MainClass {

	public static void main(String[] args) {
		// When scanning the classes of the project itself, the scanner can get the classes of a given package in the main method.
//		FastClasspathScanner scanner = new FastClasspathScanner("mypack.core").verbose();
//		List<String> classNames = scanner.scan().getNamesOfAllClasses();
//		for (String name : classNames) {
//			System.out.println("The class: " + name);
//		}
		// When scanning the classes of the jars of plug-in dependencies, the scanner can get the classes of a given package in the main method.
		FastClasspathScanner scanner = new FastClasspathScanner("org.eclipse.swt.accessibility").verbose();
		List<String> classNames = scanner.scan().getNamesOfAllClasses();
		for (String name : classNames) {
			System.out.println("The class: " + name);
		}
	}
}
