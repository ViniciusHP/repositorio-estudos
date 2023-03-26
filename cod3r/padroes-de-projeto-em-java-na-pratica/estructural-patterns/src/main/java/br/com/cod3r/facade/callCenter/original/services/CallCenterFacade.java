package br.com.cod3r.facade.callCenter.original.services;

import br.com.cod3r.facade.callCenter.original.model.Card;
import br.com.cod3r.facade.callCenter.original.model.Register;

import java.util.List;

public class CallCenterFacade {

    private CardService cardService;
    private RegisterService registerService;
    private ReportService reportService;
    private PaymentService paymentService;
    private SecurityService securityService;

    public CallCenterFacade() {
        cardService = new CardService();
        registerService = new RegisterService();
        reportService = new ReportService(registerService);
        paymentService = new PaymentService(registerService);
        securityService = new SecurityService(cardService, registerService);
    }

    public Card getCardByUser(long user) {
        return cardService.getCardByUser(user);
    }

    public void getSumary(Card card) {
        reportService.getSumary(card);
    }

    public void getPaymentInfoByCard(Card card) {
        paymentService.getPaymentInfoByCard(card);
    }

    public void cancelLastRegister(Card card) {
        List<Register> registers = registerService.getRegistersByCard(card);
        registerService.removeByIndex(card, registers.size() - 1);
        List<Register> pendingRegisters = securityService.blockCard(card);
        Card newCard = cardService.createNewCard(123456L, 33445566L);
        registerService.addCardRegisters(newCard, pendingRegisters);
        reportService.getSumary(newCard);
    }
}
