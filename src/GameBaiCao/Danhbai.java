package GameBaiCao;
import java.util.*;
class Xaobai {
	public static void Xao(int Bai[], int n) {
		int i, so;
		Random r = new Random();//Khởi tạo biến random r
		for(i=0; i<n; i++) {
			Bai[i]=i;//Gan giá trị từ 0-51 cho 52 lá bài
		}
		//Tạo 1 dãy không lặp
		for(i=0; i<n; i++) {
			so =i + r.nextInt(n-i);
			int temp=Bai[i];
			Bai[i]=Bai[so];
			Bai[so]=temp;
		}
	}
}
class Chiabai {
	public static void Chia(int Bai[],int n, int tu[][], int d) {
		int k=0;
		int tien[]= new int[d];
		for(int i=0; i<d; i++) {
			tien[i]=100000;
		}
		int nut[]=new int[d];//Khởi tạo số nút của từng tụ bài
		//Chia bài
		
		for(int i=0; i<d; i++) {
			System.out.print("\nTu "+(i+1)+":");
				for(int j=0;j<3;j++) {
					int doi=-1;
					if((Bai[k+j*d]%13)>=10||(Bai[k+j*d]%13)==0) {
						doi=Bai[k+j*d]%13;
						tu[i][j]=0;
					}
					else {
						if(Bai[k+j*d]%13==1)
							doi=Bai[k+j*d]%13;
						tu[i][j]=Bai[k+j*d]%13;
					}
					if(doi!=-1) {
						switch (doi){
						case 0:
							System.out.print(" K");
							break;
						case 1:
							System.out.print(" A");
							break;
						case 10:
							System.out.print(" 10");
							break;
						case 11:
							System.out.print(" J");
							break;
						case 12:
							System.out.print(" Q");
						}
					}
					else
						System.out.print(" "+tu[i][j]);
					nut[i]=nut[i]+tu[i][j];//Tính nút
				}
				nut[i]=nut[i]%10;
				System.out.print("\tSo nut tu "+(i+1)+"="+nut[i]);
				k++;
		}
		//Tính số nút cao nhất trong tất cả các tụ
		int max=nut[0];
		for(int i=1; i<d; i++) {
			if(nut[i]>max) {
				max=nut[i];
			}
		}
		//Đếm số lượng người chơi có điểm cao nhất và xuất ra.
		int sl=0;
		int stt[]= new int[d];
		for(int i=0; i<d; i++) {
			if(nut[i]==max) {
				stt[sl]=i+1;
				sl++;				
				System.out.print("\nTu "+(i+1)+" co diem cao nhat la: "+max+" diem!");
			}
		}
		if(sl!=1) {
			System.out.println("\nCo "+sl+" tu co so diem bang nhau la tu: ");
			for(int i=0; i<sl; i++) {
				System.out.print("\t"+stt[i]);
			}
		}
	}
}
class Xuatmang {
	public static void Xuat(int Bai[], int n) {
		for(int i=0; i<n; i++) {
			int doi=-1;
			if((Bai[i]%13)>=10||(Bai[i]%13)==0) {
				doi=Bai[i]%13;
			}else if(Bai[i]%13==1)
					doi=Bai[i]%13;
			if(doi!=-1) {
				switch (doi){
				case 0:
					System.out.print(" K");
					break;
				case 1:
					System.out.print(" A");
					break;
				case 10:
					System.out.print(" 10");
					break;
				case 11:
					System.out.print(" J");
					break;
				case 12:
					System.out.print(" Q");
				}
			}
			else
				System.out.print(" "+Bai[i]%13);
		}
	}
}
public class Danhbai {
	static int n=52;// 52 la bai cua 1 bo bai
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int Bai[];
		int d;
		Bai = new int[n];
		int choi=0;
		do {
			do {
				System.out.println("Nhap so nguoi choi (2<= so nguoi<=17): ");
				d = input.nextInt();
				if(d<2 || d>17)
					System.out.print("\nSo nguoi choi khong hop le, moi chon lai: ");
				}while(d<2 || d>17);
				int tu[][];
				tu = new int[d][];
				for(int i=0; i<d; i++)	tu[i]=new int[3];//Khởi tạo số tụ bài, có d tụ, mỗi tụ có 3 lá bài.
			Xaobai.Xao(Bai, n);
			Xuatmang.Xuat(Bai, n);
			System.out.println("\n");
			Xuatmang.Xuat(Bai, d*3);
			Chiabai.Chia(Bai, n, tu, d);
			System.out.print("\nNhap 1 de choi tiep, nhap 0 de dung choi:");
			choi= input.nextInt();
		}while(choi!=0);
	}
}

