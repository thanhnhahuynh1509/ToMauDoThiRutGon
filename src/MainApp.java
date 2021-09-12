import java.io.File;

public class MainApp {
	

	public static void main(String... args) {
		XuLyFile xlF = new XuLyFile();
		XuLyDoThi xlD = new XuLyDoThi();
		
		File file = xlF.docFile("MaTran.txt");
		int[][] a = xlD.khoiTaoDoThiTuFile(file);
		
		xlD.inDoThi(a);
		xlD.inCacMauCuaDinh(a);
		
	}
	
}
