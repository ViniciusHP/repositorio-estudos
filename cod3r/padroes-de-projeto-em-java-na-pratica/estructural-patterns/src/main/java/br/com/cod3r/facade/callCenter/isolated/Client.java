package br.com.cod3r.facade.callCenter.isolated;

import br.com.cod3r.facade.callCenter.isolated.model.Card;
import br.com.cod3r.facade.callCenter.isolated.services.CallCenterFacade;
import br.com.cod3r.facade.callCenter.isolated.services.CallCenterNewCardFacade;

public class Client {

	public static void main(String[] args) {
		CallCenterFacade facade = new CallCenterFacade();
		CallCenterNewCardFacade newCardFacade = new CallCenterNewCardFacade();
		long userNumber = 123456L;

		Long cardNumber = facade.getCardByUser(userNumber);
		System.out.println(cardNumber);

		facade.getSumary(cardNumber);
		facade.getPaymentInfoByCard(cardNumber);

		newCardFacade.cancelLastRegister(userNumber);
		newCardFacade.orderNewCard(userNumber);

		Long newCardNumber  = facade.getCardByUser(123456L);
		System.out.println(newCardNumber);
	}
}
