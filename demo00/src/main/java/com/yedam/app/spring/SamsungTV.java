package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {	
	@Autowired	
	Speaker speaker; // 삼성클래스 안에 필드로 존재
	
	//1. 생성자방식
	SamsungTV(Speaker speaker){
		this.speaker = speaker;
	}
	//2. set방식 - 생성자를 기본 추가 후 실행 (1번을 하지 않을 경우에는 아래에 반드시 적어줘야함
	SamsungTV() {}
		void setSpeaker(Speaker speaker) {
			this.speaker = speaker;
		}
	
	@Override
	public void on() {
		System.out.println("삼성 TV를 켰습니다.");
		speaker.on(); //그대로 실행할 경우 문법적인 오류가 아닌 실행적 오류가 발생한다. java에서는 인스턴스를 가져야하는데 내부에서 가지고 있지않기때문에 오류가 난다.
		
	}
}
