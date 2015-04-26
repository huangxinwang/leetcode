import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class problem_a {
	
	public static String convert(int num, String str){
		
		char[] rnt = new char[num];
		
		for(int i=0; i<num; i++){
			int offset = 0;
			int start = i*8;
			for(int j=7; j>=0; j--){
				if(str.charAt(start+j) == 'I'){
					offset = offset + (int)Math.pow(2, 7-j);
				}
			}
			rnt[i] = (char)('A'+ offset - 65);
		}
		
		return String.valueOf(rnt);
	}
	
		
	public  static void main(String[] args) throws IOException{
		
		
		String filename = "E:\\GitHub\\Leetcode\\google-code-jam\\src\\A-small-practice.in";
		String outputfile = "E:\\GitHub\\Leetcode\\google-code-jam\\src\\output.txt";
		PrintWriter writer = new PrintWriter(outputfile, "UTF-8");
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line;
		    if((line = br.readLine())!=null){
		    	int total_num = Integer.parseInt(line);
		    	for(int i =0; i<total_num; i++){
		    		int num = Integer.parseInt(br.readLine());
		    		String str = br.readLine();
		    		String rnt = convert(num, str);
		    		//System.out.println("Case #"+i+": "+rnt);
		    		writer.println("Case #"+(i+1)+": "+rnt);
		    	}
		    }
		}
		writer.close();
		System.out.println("finished!");
		
//		int num = 2;
//		String str = "OIOOIIIIOIOOIOII";
//		int num = 21;
//		String str = "OIOOIOOIOOIOOOOOOOIOOIIIOOIIIIOOOOIIOOIIOOIOOIIIOOIOOOOOOOIOOOIOOIOOOOIIOOIIOOOOOIIOOIOOOOIIOOIIOOIOOOOOOIOOIOIOOOIIOIOOOIIOIIOIOOIOOOIOOOIOOOOIOOIOOOOOOOIIIOIOOOIOIOOI";
//		String rnt = convert(num, str);
//		System.out.println(rnt);
		
	}

}

