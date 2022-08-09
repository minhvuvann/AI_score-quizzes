package com.test.test;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.test.grading.GetAnswers;
import com.test.grading.GetFrame;
import com.test.model.Line;
import com.test.process.Plantain_StudentID;

public class Test {
	public static void main(String[] args) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		for (int i = 1; i <= 100; i++) {
			if (i != 1 && i != 2 && i != 3 && i != 6 && i != 7 && i != 8 && i != 9 && i != 10 && i != 12 && i != 13
					&& i != 14 && i != 15 && i != 16 && i != 17 && i != 18 && i != 19) {
//				

				String name = i + "";
				String filePath = "src/img/img-new/oke/" + name + ".jpg";

				Mat src = Imgcodecs.imread(filePath);

				Mat idExam = new Mat();
				Mat idStudent = new Mat();
				Mat resultExam = new Mat();

				GetFrame getFrame = new GetFrame();
				getFrame.execute(src, idExam, idStudent, resultExam);
//		System.out.println("height "+resultExam.height());

				Plantain_StudentID stu = new Plantain_StudentID(idStudent, true);
				String MSSV = stu.getCodeID();
				System.out.println(name + "MSSV: " + MSSV);

				Plantain_StudentID plan = new Plantain_StudentID(idExam, false);
				String MaDe = plan.getCodeID();
				System.out.println(name + "MÃ ĐỀ: " + MaDe);
			}
		}
	}

	public static void print(Map<Integer, Line> ok) {
		for (Entry<Integer, Line> en : ok.entrySet()) {
			System.out.println(en.getKey() + "  " + en.getValue().getValue());
		}
	}
}
