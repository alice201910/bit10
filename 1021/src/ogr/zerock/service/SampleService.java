package ogr.zerock.service;

import java.util.ArrayList;
import java.util.List;

public enum SampleService {
//문자열 처리 서비스
	INSTANCE;
	
	private List<String> list;
	
	SampleService() {
		list = new ArrayList<>();
	}
	//추가하기
	public void add(String str) {
		list.add(str);
	}
	//목록 가져오기
	public List<String> getList(){
		return list;
	}
}
