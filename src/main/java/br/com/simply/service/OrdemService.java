package br.com.simply.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.simply.BusinessException;
import br.com.simply.model.ContaSimply;
import br.com.simply.model.Moeda;
import br.com.simply.model.Ordem;
import br.com.simply.repository.ContaSimplyRepository;
import br.com.simply.repository.MoedaRepository;
import br.com.simply.repository.OrdemRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrdemService {

	@Autowired
	private OrdemRepository ordemRepository;

	@Autowired
	private ContaSimplyRepository contaSimplyRepository;

	@Autowired
	private MoedaRepository moedaRepository;

	public Ordem criarOrdem(Ordem ordem) {
		Optional<Moeda> moeda = moedaRepository.findById(ordem.getMoeda().getId());
		Optional<ContaSimply> conta = contaSimplyRepository.findById(ordem.getContaSimply().getId());
		BigDecimal valorOrdem = ordem.getMoeda().getCotacao().multiply(BigDecimal.valueOf(ordem.getQuantidadeMoedas()));
		
		ordem.setValorOrdem(valorOrdem);
		ordem.setStatusOrdem("A");
		if (conta.get().getSaldo().doubleValue() < valorOrdem.doubleValue()
				/*|| (conta.get().getSaldo().doubleValue() - ordem.getValorOrdem().doubleValue()) >= 0*/) {
			throw new BusinessException("Saldo insulficiente!");
		}

		Ordem ordemCriada = ordemRepository.save(ordem);

		return ordemCriada;
	}

	/*@Scheduled(cron = "0/3 * * * * *")
	private void executaOrdem() {
		log.info("Iniciando executaOrdem() - OrdemService");
		List<Ordem> ordensAguardando = ordemRepository.findAllByStatusOrdem("A");
		ordensAguardando.forEach(ordem -> {
			if(ordem.getTipo().equals("C")) { 
				executaCompra(ordem);
			}else {
				executaVenda(ordem);
			}
		});
		ordemRepository.saveAll(ordensAguardando);
		log.info("Finalizando executaOrdem() - OrdemService");
	}*/

	private void executaVenda(Ordem ordem) {
		Optional<ContaSimply> conta = contaSimplyRepository.findById(ordem.getContaSimply().getId());
		BigDecimal saldoAtualizado = conta.get().getSaldo().add(ordem.getValorOrdem());
		if (saldoAtualizado.doubleValue() >= 0) {
			conta.get().setSaldo(saldoAtualizado);
			ordem.setStatusOrdem("E");
		} else {
			ordem.setStatusOrdem("R");
		}
		contaSimplyRepository.save(conta.get());
	}

	private void executaCompra(Ordem ordem) {
		Optional<ContaSimply> conta = contaSimplyRepository.findById(ordem.getContaSimply().getId());
		BigDecimal saldoAtualizado = conta.get().getSaldo().subtract(ordem.getValorOrdem());
		if (saldoAtualizado.doubleValue() >= 0) {
			conta.get().setSaldo(saldoAtualizado);
			ordem.setStatusOrdem("E");
		} else {
			ordem.setStatusOrdem("R");
		}
		contaSimplyRepository.save(conta.get());
	}
}
