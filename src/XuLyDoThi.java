import java.io.File;
import java.util.Scanner;

public class XuLyDoThi {

	public int[][] khoiTaoDoThiTuFile(File file) {
		Scanner sc = null;
		int[][] a = null;

		try {
			sc = new Scanner(file);
			int n = sc.nextInt();
			a = new int[n][n];

			while (sc.hasNext()) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						a[i][j] = sc.nextInt();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Loi roi kia! Noi dung: " + e.getMessage());
		} finally {
			if (sc != null)
				sc.close();
		}

		return a;

	}

	public void inDoThi(int[][] a) {
		int n = a.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public int bacCuaDinh(int[][] a, int dinh) {
		int count = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if (a[dinh][i] != 0)
				count++;
		}
		return count;
	}

	private void sapXepDoThiTheoBacVaLuuVaoMangTmp(int[][] a, int[] tmp) {
		int n = a.length;

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j > i; j--) {
				if (bacCuaDinh(a, tmp[j]) >= bacCuaDinh(a, tmp[j - 1])) {
					int tmpValue = tmp[j];
					tmp[j] = tmp[j - 1];
					tmp[j - 1] = tmpValue;
				}
			}
		}
	}

	public void inCacMauCuaDinh(int[][] a) {
		int count = 0;
		int n = a.length;
		int[] mauCuaDinh = toMauDoThi(a);

		for (int i = 1; i <= n; i++) {
			System.out.print("Mau " + i + ": ");
			for (int j = 0; j < n; j++) {
				if (mauCuaDinh[j] == i) {
					count++;
					System.out.print((j + 1) + " ");
				}
			}
			System.out.println();
			if (count == n)
				break;
		}

	}

	private int[] toMauDoThi(int[][] a) {

		int count = 0;
		int mau = 0;
		int n = a.length;
		int mauCuaDinh[] = new int[n];
		int[] tmp = new int[n];
		
		for(int i = 0; i < n; i++) {
			tmp[i] = i;
		}

		sapXepDoThiTheoBacVaLuuVaoMangTmp(a, tmp);
		
		while (count < n) {
			count += toMauDinh(a, ++mau, mauCuaDinh, tmp);
		}
		return mauCuaDinh;

	}

	private int toMauDinh(int[][] a, int mau, int[] mauCuaDinh, int[] tmp) {
		int n = a.length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (mauCuaDinh[tmp[i]] == 0 && choPhepTo(a, tmp[i], mauCuaDinh, mau)) {
				mauCuaDinh[tmp[i]] = mau;
				count++;
			}
		}
		return count;
	}

	private boolean choPhepTo(int[][] a, int i, int[] mauCuaDinh, int mau) {
		int n = a.length;
		for (int j = 0; j < n; j++)
			if (a[i][j] == 1 && mauCuaDinh[j] == mau)
				return false;
		return true;
	}

}
