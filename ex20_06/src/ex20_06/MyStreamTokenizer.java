package ex20_06;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class MyStreamTokenizer extends StreamTokenizer{
	private final Map<String, Double> values = new HashMap<String, Double>();
	private final String[] op = {"+","-","="};
	private String targetValue;
	private String targetOp;
	private double targetNumber;
	private int flag = 0;

	public MyStreamTokenizer(Reader r){
		super(r);
		init();
	}

	private void init(){
		this.values.put("RED",0.0);
		this.values.put("GREEN",0.0);
		this.values.put("BLUE",0.0);
	}

	public static void main(String[] args) throws IOException{
		FileReader fileIn = new FileReader(args[0]);
		MyStreamTokenizer mst = new MyStreamTokenizer(fileIn);
		String tmp = null;
		while(mst.nextToken() != MyStreamTokenizer.TT_EOF){
			if(mst.flag == 0 && mst.ttype == StreamTokenizer.TT_WORD){
				for(String element :mst.values.keySet()){
					if(element.equals(mst.sval)){
						mst.targetValue = mst.sval;
						mst.flag = 1;
					}
				}
			}else if(mst.flag == 1 && mst.ttype == StreamTokenizer.TT_WORD){
				for(String element :mst.op){
					if(element.equals(mst.sval)){
						mst.targetOp = mst.sval;
						mst.flag = 2;
					}
				}
			}else if(mst.flag == 2 && mst.ttype == StreamTokenizer.TT_NUMBER){
				mst.targetNumber = mst.nval;
				mst.execute();
			}else{
				mst.flag = 0;
				mst.targetValue = null;
				mst.targetOp = null;
				mst.targetNumber = 0;
			}
		}
	}
	private void execute(){
		if(this.targetValue != null){
			if(this.targetOp.equals("+")){
				this.values.put(this.targetValue,this.values.get(this.targetValue)+this.targetNumber);
			} else if (this.targetOp.equals("-")){
				this.values.put(this.targetValue,this.values.get(this.targetValue)-this.targetNumber);
			} else {
				this.values.put(this.targetValue,this.values.get(this.targetValue));
			}
		}
	}

}
