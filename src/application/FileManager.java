package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	static File animal = new File("animal.txt");

	public static void textToLL(File file) throws IOException {
		BufferedReader bufferedreader = null;
		try {
			FileReader filereader = new FileReader(file);
			bufferedreader = new BufferedReader(filereader);
			String line;
			while ((line = bufferedreader.readLine()) != null) {
				String[] info = line.split(" ");
				Animal animal = new Animal(Long.parseLong(info[3]), info[1], info[0],
						Integer.parseInt(info[2]));
				LinkedList.ll.addLast(animal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedreader != null) {
				try {
					bufferedreader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void createIdListIFromText(File file, ArrayList<Long> array) throws IOException {
		BufferedReader bufferedreader = null;
		try {
			FileReader filereader = new FileReader(file);
			bufferedreader = new BufferedReader(filereader);
			String line;
			while ((line = bufferedreader.readLine()) != null) {
				String[] info = line.split(" ");
				array.add(Long.parseLong(info[3]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedreader != null) {
				try {
					bufferedreader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void sortedLLToText() throws IOException {
		Animal temp = LinkedList.ll.front;
		FileWriter filewriter = new FileWriter(FileManager.animal, false);
		BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
		while (temp != null) {
			bufferedwriter.write(temp.animalName + " " + temp.animalKind + " " + temp.animalAge + " " + temp.animalId);
			bufferedwriter.newLine();
			temp = temp.next;
		}
		bufferedwriter.close();
	}
}
