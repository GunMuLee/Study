package com.Study.Project.handler;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.response.MultipleDetailMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

public class coolSMSAPI {

	public MultipleDetailMessageSentResponse sendAuthCode(int authCode, String phone) {
		DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("NCSYN9ESBTWTKQ1B", "KSHNQFIJZN6L129DVFZJCGBXN9SJW1P0", "https://api.coolsms.co.kr");
		// Message 패키지가 중복될 경우 net.nurigo.sdk.message.model.Message로 치환하여 주세요
		Message message = new Message();
		message.setFrom("01090945932");
		message.setTo(phone.replaceAll("-", ""));
		message.setText("인증번호는 [" + authCode + "] 입니다.");

		try {
		  // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
		  return messageService.send(message);
		} catch (NurigoMessageNotReceivedException exception) {
		  // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
		  System.out.println(exception.getFailedMessageList());
		  System.out.println(exception.getMessage());
		} catch (Exception exception) {
		  System.out.println(exception.getMessage());
		}
		return null;
	}
	
}
