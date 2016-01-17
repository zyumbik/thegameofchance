// Created by glebsabirzyanov on 10/01/16.

import java.io.File;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
//		File in = new File("input.txt");
//		File out = new File("output.txt");
//		Scanner sc = new Scanner(System.in);
//		while (sc.hasNext()) {
//
//		}

		String[] array = {"a", "b", "c", "d"};
		int max = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			max += (int) 9 * Math.pow(10, i);
		}
		int current = 1, temporary;
		boolean isnew;
		while(current <= max) {
			isnew = true;
			temporary = current;
			for (int i = array.length - 1; i >= 0; i--) {
				if (!(temporary % (int) Math.pow(10, i) >= array.length) && (isnew == true)) {
					isnew = true;
				} else {
					isnew = false;
				}
			}
			if (isnew) {
				for (int i = array.length - 1; i >= 0; i--) {
					System.out.print(array[temporary % (int) Math.pow(10, i)]);
				}
			}
			System.out.println();
			current++;
		}

	}

}
